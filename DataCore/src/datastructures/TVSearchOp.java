/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 * Vertex operator for binary search operation.
 */
public class TVSearchOp extends VertexOperator {

	/**
	 * 
	 */
	public TVSearchOp() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see datastructures.Visitor#implementOperate(java.lang.Object)
	 */
	@Override
	protected void implementOperate(Object v) {
		if ( v instanceof Vertex ){
			//Vertex vertex = (Vertex)v;
			//if ( vertex.equals( ))
		}
		else {
			throw new IllegalArgumentException();
		}

	}

}
