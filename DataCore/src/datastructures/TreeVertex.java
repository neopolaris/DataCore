/**
 * 
 */
package datastructures;

import java.util.List;

/**
 * @author Vaygr
 * This is a simplest tree node. Also a base class for all tree nodes.
 */
public abstract class TreeVertex extends SimpleVertex {
	
	/**
	 * Default constructor.
	 */
	public TreeVertex() {
		// Nothing to do here
	}

	/**
	 * Overloaded constructor.
	 * @param name
	 */
	public TreeVertex(String name) {
		super(name);
	}
	
	public int getNeighborCount() {
		return implementNeighborCount();
	}
	
	public boolean isLeaf(){
		return ( implementNeighborCount() == 0 );
	}
	
	public TreeVertex addChild(TreeVertex v){
		return ( implementAddChild(v));
	}
	
	public List<TreeVertex> getNextNeighbors(){
		if ( !isLeaf() ){
			return implementGetNextNeighbors();
		}
		return null;
	}
	
	public TreeVertex getChildAt(int i){
		return implementGetChildAt(i);
	}
	
	protected abstract List<TreeVertex> implementGetNextNeighbors();//{ return null; };
	protected abstract int implementNeighborCount();//{ return 0; };
	protected abstract TreeVertex implementAddChild(TreeVertex v);
	protected abstract TreeVertex implementGetChildAt(int i);
}