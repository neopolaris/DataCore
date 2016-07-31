/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 * Binary Search Tree
 */
public class BSTree extends GTree {
	
	public enum ChildVertexType { left, right };

	/**
	 * 
	 */
	public BSTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param r
	 */
	public BSTree(TLVertex r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param r
	 * @param name
	 */
	public BSTree(TLVertex r, String name) {
		super(r, name);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param v
	 * @return
	 */
	public boolean insertVertex(TreeVertex v){
		// TODO: Implement
		// Serch for the vertex, if not found, insert it there.
		// Otherwise return false;
		return false;
	}
	
	public TreeVertex getChildVertex(TreeVertex vertex, ChildVertexType cType){
		if ( cType == ChildVertexType.left ){
			return vertex.getChildAt(0);
		}
		else if ( cType == ChildVertexType.right ){
			return vertex.getChildAt(1);
		}
		return null;
	}
	
	public TreeVertex binarySearch(String vName){
		return binarySearch(this.root, new TLVertex(vName));
	}
	public TreeVertex binarySearch(TreeVertex target){
		return binarySearch(this.root, target);
	}
	
	private TreeVertex binarySearch(TreeVertex vertex, TreeVertex target){
		if ( vertex == null || (target.compareTo(vertex) == 0 )){
			return vertex;
		}
		else {
			if ( target.compareTo(vertex) < 0 ) {
				return binarySearch(vertex.getChildAt(0), target);
			}
			else if ( target.compareTo(vertex) > 0 ){
				return binarySearch(vertex.getChildAt(1), target);
			}
			return null;
		}
	}
}
