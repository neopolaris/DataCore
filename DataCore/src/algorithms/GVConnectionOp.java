/**
 * 
 */
package algorithms;

import datastructures.GraphVertex;
import datastructures.VertexPathOp;

/**
 * @author aminn
 *
 */
public class GVConnectionOp extends VertexPathOp {
	
	private int componentNum = -1;

	/**
	 * 
	 */
	public GVConnectionOp() {
		componentNum = 1;
	}
	
	public void incrementComNo()
	{
		componentNum++;
	}
	
	public int getComponentCount(){
		return componentNum;
	}
	
	/* (non-Javadoc)
	 * @see datastructures.Visitor#implementOperate(java.lang.Object)
	 */
	@Override
	protected void implementOperate(Object v) {
		if ( v instanceof GraphVertex ){
			GraphVertex vertex = (GraphVertex)v;
			getPath().add(vertex);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
