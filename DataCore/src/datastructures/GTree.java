/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vaygr
 * A general purpose tree that make use of 
 * TLVertex as tree nodes.
 */
public class GTree extends Tree {
	
	public enum VisitOrder { pre_order, in_order, post_order };
	private VisitOrder vOrder = VisitOrder.post_order;

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
		vOrder = VisitOrder.post_order;
	}
		
	/**
	 * Overloaded constructor
	 * @param name
	 */
	public GTree(TLVertex r, String name) {
		super(r, name);
	}
	
	public VisitOrder getVisitOrder(){
		return vOrder;
	}
	
	public void setVisitOrder(GTree.VisitOrder order ){
		vOrder = order;
	}

	@Override
	protected void implementTraverseBFS(VertexOperator op) {
		doBFS(getRoot(), op);
		
	}

	@Override
	protected void implementTraverseDFS(VertexOperator op) {
		doDFS(this.getRoot(), op);
		
	}

	@Override
	protected TreeVertex implementFindTreeVertex(String name) {
		// TODO: implement this method.
		return null;
	}
	
	/**
	 * Depth first traversal of the tree.
	 * @param v - Current vertex that is being traversed.
	 * @param op - An operator with certain operation to perform visit.
	 */
	protected void doDFS(TreeVertex v, VertexOperator op){
		//if ( v == null ){
		///}
		visitPreOrder(v, op);
		if ( !v.isLeaf() ){
			List<TreeVertex> descendants = v.getNextNeighbors(); 
			for ( int i=0; i < descendants.size(); i++ ){
				TreeVertex tVertex = descendants.get(i);
				doDFS(tVertex, op);
 
				// Note: This only makes sense for binary trees
				if ( i == 0 ) {
					visitInOrder(v, op);
				}
			}
		}
		else {
			// This Could really be improved
			visitInOrder(v, op);
		}
		visitPostOrder(v, op);
	}
	
	private void visitPostOrder(TreeVertex v, VertexOperator op) {
		if ( vOrder == VisitOrder.post_order ){
			visitVertex(v, op);
		}
	}

	private void visitInOrder(TreeVertex v, VertexOperator op) {
		if ( vOrder == VisitOrder.in_order ){
			visitVertex(v, op);
		}
	}

	private void visitPreOrder(TreeVertex v, VertexOperator op) {
		if ( vOrder == VisitOrder.pre_order ){
			visitVertex(v, op);
		}
	}

	protected void doBFS(TreeVertex v, VertexOperator op){
		LinkedList<TreeVertex> q = new LinkedList<TreeVertex>();
		q.add(v);
		while ( !q.isEmpty() ){
			TreeVertex curV = q.removeFirst();
			if ( !curV.isLeaf() ) {
				q.addAll(curV.getNextNeighbors());
			}
			visitVertex(curV,op);
		}
	}

	protected void visitVertex(TreeVertex v, VertexOperator op){
		op.operate(v);
	}
	
	@Override
	protected List<String> implementToStringList() {
		VertexPathOp vOp = new VertexPathOp();
		doDFS(root,vOp);
		List<String> retList = new ArrayList<String>();
		List<Vertex> tList = vOp.getPath();
		for ( Vertex v : tList ){
			retList.add(v.getVertexName());
		}
		return retList;
	}
}
