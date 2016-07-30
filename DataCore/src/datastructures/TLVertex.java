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
		this ("",null);
	}

	/**
	 * @param name
	 */
	public TLVertex(String name) {
		this(name, null);
	}
	
	public TLVertex(String name, TreeVertex parent){
		super(name);
		descendants = new ArrayList<TreeVertex>();
		if ( parent != null ){
			parent.addChild(this);
		}
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

	@Override
	protected TreeVertex implementAddChild(TreeVertex v) {
		if ( !descendants.contains(v)){
			if ( descendants.add(v) )
				return v; 
		}
		return null;
	}
}
