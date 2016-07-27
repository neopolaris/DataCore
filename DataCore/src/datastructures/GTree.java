/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 * A general purpose tree that make use of 
 * TLVertex as tree nodes.
 */
public class GTree extends Tree {

	/**
	 * Default constructor
	 */
	public GTree() {
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * Overloaded constructor
	 * @param name
	 */
	public GTree(TLVertex r) {
		super(r);
	}
	
	/**
	 * Overloaded constructor
	 * @param name
	 */
	public GTree(TLVertex r, String name) {
		super(r, name);
	}

	@Override
	protected void implementTraverseBFS() {
		doBFS(getRoot());
		
	}

	@Override
	protected void implementTraverseDFS() {
		doDFS(this.getRoot());
		
	}

	@Override
	protected TreeVertex implementFindTreeVertex(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void doDFS(TreeVertex v){
		if ( v.isLeaf() ){
			return;
		}
		else {
			for ( TreeVertex tVertex : v.getNextNeighbors() ){
				doDFS(tVertex);
			}
		}
	}
	
	private void doBFS(TreeVertex v){
		//LinkedList<>
	}

}
