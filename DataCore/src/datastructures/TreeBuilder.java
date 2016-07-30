/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author aminn
 *
 */
public class TreeBuilder extends Builder {
	private List<String> eStrings = null;
	private HashMap<String, TLVertex> vertices = null;

	/**
	 * 
	 */
	public TreeBuilder(List<String> e) {
		super();
		eStrings = e;
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
		GTree tree = new GTree(root);
		return tree;
	}

}
