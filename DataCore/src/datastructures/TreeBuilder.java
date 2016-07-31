/**
 * 
 */
package datastructures;

import java.util.HashMap;
import java.util.List;

/**
 * @author Vaygr
 *
 */
public class TreeBuilder extends Builder {
	
	public enum TreeType { generic, binary, bst };
	
	private List<String> eStrings = null;
	private HashMap<String, TLVertex> vertices = null;
	private TreeType treeType = TreeType.generic;
	

	/**
	 * 
	 */
	public TreeBuilder(List<String> e, TreeType type) {
		super();
		eStrings = e;
		treeType = type;
		vertices = new HashMap<String,TLVertex>();
	}

	/* (non-Javadoc)
	 * @see datastructures.Builder#build()
	 */
	@Override
	public Object build() {
		// TODO Auto-generated method stub
		// Traverse the string list.
		// At each line, split the v & edges using ->
		// create new v and Add the v
		// Split the edges using comma.
		// Traverse all the edges.
		// At each line, create new v and add.
		TLVertex root = null;
		
		for ( String line : eStrings ){
			String ePath = "->";
			String[] tokens = line.split(ePath);
			String pName = tokens[0];
			String cNames = tokens[1];
			TLVertex pVert = null;
			if ( !vertices.containsKey(pName)) {
				// Create a new vertex.
				pVert = new TLVertex(pName);
				vertices.put(pName, pVert);
			}
			else {
				// Get existing vertex.
				pVert = vertices.get(pName);
			}
			
			// Set the root if this is the first vertex.
			if ( root == null ){
				root = pVert;
			}
			
			String delimeter = ",";
			String[] chNames = cNames.split(delimeter);
			for ( String chName : chNames ){
				TLVertex cVert = null;
				if ( !vertices.containsKey(chName)) {
					cVert = new TLVertex(chName);					
				}
				else {
					cVert = vertices.get(chName);
				}
				pVert.addChild(cVert);
				vertices.put(chName, cVert);
			}
		}
		
		return buildTree(root);
		
	}

	private GTree buildTree(TLVertex root){
		switch ( treeType ){
			case generic:	return new GTree(root);
			case binary: break;
			case bst: return new BSTree(root);
			default: break;
		}
		return null;
	}
}
