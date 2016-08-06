## Revison 1, 09.09.2015: Maria Prokhorova. Option for setting Font for SampleID
## Revison 2, 22.10.2015: Maria Prokhorova. Fix for GILD4449-57 Error in sample ID
## Revison 3, 08.04.2016: Mikhail Trushkevich. GILD4449-60 workaround applied. 
## Revison 4, 03.08.2016: Allan Minn. Fixed sample ID insertion text comparison to Plain Text.
# Font Size option does not woks properly with version of control 14. Last version is ok
# if you'd like to play with it - uncomment line 91 "ctl.Selection.FontSize = FONT_SIZE" in InsertSampleID procedure
## Use this script within a dynamic toolbar within a Text section ##
## This script will ensure that with each new document and clone that the sample ID sequence always starts at 1 ##
## Script also attempts to add a new row with the sample ID generated ##

import  clr

clr.AddReference("TXTextControl")

from System import String
from System.Reflection import BindingFlags
from System.Drawing import Font, Color, FontStyle
from System.Windows.Forms import MessageBox
from Symyx.Notebook.Extensibility.Properties import SampleIdentificationSequencer
from Symyx.Framework.WinForms import MessageBox
from Symyx.Framework.Properties import Allowability
from TXTextControl import Selection, TextControl, TextField, StringStreamType

section = editor.ActiveDocumentSection
document = editor.Document

SAMPLE_ID_SEQUENCE_KEY = "SampleIdentificationSequence"
sampleSectionTitle = "Samples"
sampleIdInt = 0

FONT_NAME = "Arial"
FONT_SIZE = 18
FONT_COLOR = "Red"
FONT_IS_BOLD = True

# Sets the clonable property for the extended proeprty to not allowed
def UpdateSequenceClone():
    extendedProps = document.ExtendedProperties
    if extendedProps.Contains(SAMPLE_ID_SEQUENCE_KEY):
        # Get the property and set its cloneability
        prop = extendedProps[SAMPLE_ID_SEQUENCE_KEY]
        prop.PropertyClass.Clonable = Allowability.NotAllowed


# Gets the next sample id from the extended property via the SampleIdentificationSequencer
def GetSampleId():
    sampleId = ""
    sampleIdInt = SampleIdentificationSequencer.GenerateNext(document)
    sequence = String.Format("{0:000}", sampleIdInt)
    UpdateSequenceClone()
    autoname = document.Autoname
    if not String.IsNullOrEmpty(autoname):
        sampleId = String.Format("{0}-{1}", autoname, sequence)
    else:
        sampleId = sequence
    return sampleId


def GetSectionByTitle(sectionTitle):
    section = None
    section = document.Sections.Find(lambda x : (x.Title == sectionTitle))
    return section


def AddSampleIdToSamplesSection(sampleId):
  if not String.IsNullOrEmpty(sampleId):
    # Add a row with this sample ID into the samples section
    samplesSection = GetSectionByTitle(sampleSectionTitle)
    if samplesSection != None:
        try:
            row = samplesSection.AddRow()
            row.PropertySets["SampleIdentification"]["SampleId"].Value = sampleId
            row.PropertySets["Material"]["Name"].Value = sampleId
        except:
            pass

def InsertSampleID(RichText, SelectionStart, sampleId):
    ctl = TextControl()
    ctl.CreateControl()
    ctl.Load(RichText, StringStreamType.RichTextFormat)
               
    ctl.Selection.Start = SelectionStart
    s = sampleId
    f = TextField(s);
    if ctl.TextFields.Add(f):  
        f.Editable = False
        f.ID = sampleIdInt
        f.Name = sampleId
        f.ShowActivated = False

    ctl.Selection.Start = SelectionStart# - f.Length
    ctl.Selection.Length = f.Length
    ctl.Selection.Bold = FONT_IS_BOLD
    ctl.Selection.ForeColor = Color.FromName(FONT_COLOR)
    ctl.Selection.FontName = FONT_NAME
    #ctl.Selection.FontSize = FONT_SIZE
    
    #Add space after sampleId
    ctl.Selection.Length = 0
    ctl.Selection.Start  = selectionStart + f.Length 
    ctl.Selection.Text = " "
    ctl.Selection.Length = 1

    NewData = ctl.Save(StringStreamType.RichTextFormat)
    
    return NewData

# Name: GetPlainText(RichText)
# Author: Allan Minn
# Date: AUG032016
# Description: Converts the RichText from the parameter to plain text.
# Input: RichTextFormat
# Return - Plain Text of the input
def GetPlainText(RichText):
    ctl = TextControl()
    ctl.CreateControl()
    ctl.Load(RichText, StringStreamType.RichTextFormat)
    PlainText = ctl.Save(StringStreamType.PlainText);
    return PlainText

def CheckEndIfTheDocument(positionToInsert):
    section.Text.Selection.Start = positionToInsert
    section.Text.Selection.Length = 1
    lnSel = len(section.Text.Selection.PlainText)
    lnTot = len(section.Text.PlainText)
    if lnSel == lnTot :
        return True
    if  lnSel <= 2 :
        for _chr in section.Text.Selection.PlainText:
            _code = ord(_chr)
            if _code in (10, 13):
                return True


if active_workspace.IsOnline:
    if not section.IsLocked:
        if not editor.IsReadOnly:
            selection = section.Text.Selection
            if selection.Length <= 0:
                textDocument = section.TextDocument
                textEditor = None
                for extension in section.TextSectionExtensions:
                    if hasattr(extension, "TextEditor") and extension.TextEditor is not None:
                        textEditor = extension.TextEditor
                        break

                # Use the function to get the sample id
                sampleId = GetSampleId() 
                # Could use a GUID as the name but the sample ID is probably sufficient in case of a uniqueness  requirement
                #textDocument.Fields.Add(Guid.NewGuid().ToString(), sampleId, False, True)
                if not String.IsNullOrEmpty(sampleId):
                    #Get Editor Control
                    textControl = textDocument.GetType().GetProperty("TextControl", BindingFlags.NonPublic |  BindingFlags.Instance).GetValue(textDocument, None)
                    #Save current font settings
                    fontBold = textControl.Selection.Bold 
                    fontColor = textControl.Selection.ForeColor 
                    fontName = textControl.Selection.FontName
                    fontSize = textControl.Selection.FontSize 
            
                    #Insert Sample ID Field
                    selectionStart = section.Text.Selection.Start
                    isTheEnd = CheckEndIfTheDocument(selectionStart)

                    newText = InsertSampleID(textDocument.RichText, selectionStart, sampleId)

                    #Converts RTF into plain text for comparison (Allan Minn AUG032016)
                    newPlainText = GetPlainText(newText)
                    oldPlainText = GetPlainText(textDocument.RichText)

                    if newPlainText.Length > textDocument.PlainText.Length:
                      textDocument.RichText = newText 
                
                      textControl.Selection.Start = selectionStart + sampleId.Length + 1
                    else:
                      MessageBox.Show("Sample ID could not be inserted due to indentation limit. Please make sure  that file contain less than 8 indentations.")
                    textControl.Selection.Length = 0
                    textControl.Selection.Bold = fontBold 
                    textControl.Selection.ForeColor = fontColor
                    textControl.Selection.FontName = fontName 
            
                    AddSampleIdToSamplesSection(sampleId)
                else:
                    MessageBox.Show('Could not generate a sample id. No error detected.', 'Generate Sample Id')
            else:
                MessageBox.Show('Do not select text, place cursor between text instead.', 'Generate Sample Id')
        else:
            MessageBox.Show('Not available when document is opened ReadOnly', 'Generate Sample Id')
    else:
        MessageBox.Show('Not available when section is locked', 'Generate Sample Id')
else:
    MessageBox.Show('Not available when working offline', 'Generate Sample Id')