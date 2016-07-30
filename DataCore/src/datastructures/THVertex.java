/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Vaygr
 * Tree Node object with HashMap implementation useful
 * for Trie implementations.
 */
public class THVertex extends TreeVertex {
	
	private HashMap<String, TreeVertex> descedants;

	/**
	 * Default constructor
	 */
	public THVertex() {
		this("");
	}

	/**
	 * Overloaded constructor
	 * @param name - The name of the vertex
	 */
	public THVertex(String name) {
		super(name);
		descedants = new HashMap<String, TreeVertex>();
	}

	/* (non-Javadoc)
	 * @see datastructures.TreeVertex#implementGetNextNeighbors()
	 */
	@Override
	protected List<TreeVertex> implementGetNextNeighbors() {
		List<TreeVertex> vertList = new ArrayList<TreeVertex>(descedants.values());
		return vertList;
	}

	/* (non-Javadoc)
	 * @see datastructures.TreeVertex#implementNeighborCount()
	 */
	@Override
	protected int implementNeighborCount() {
		return descedants.size();
	}

	@Override
	protected TreeVertex implementAddChild(TreeVertex v) {
		// TODO Auto-generated method stub
		return null;
	}

}
