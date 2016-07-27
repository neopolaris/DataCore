/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aminn
 *
 */
public class TLVertex extends TreeVertex {
	private List<TreeVertex> descendants = null;

	/**
	 * 
	 */
	public TLVertex() {
		this ("");
	}

	/**
	 * @param name
	 */
	public TLVertex(String name) {
		super(name);
		descendants = new ArrayList<TreeVertex>();
	}

	/* (non-Javadoc)
	 * @see datastructures.TreeVertex#implementGetNextNeighbors()
	 */
	@Override
	protected List<TreeVertex> implementGetNextNeighbors() {
		return descendants;
	}

	/* (non-Javadoc)
	 * @see datastructures.TreeVertex#implementNeighborCount()
	 */
	@Override
	protected int implementNeighborCount() {
		return descendants.size();
	}

}
