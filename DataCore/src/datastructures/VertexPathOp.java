/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vaygr
 * A vertex operator that retrieve and saves a list
 * of vertices it encounters during a graph or 
 * tree traversal.
 */
public class VertexPathOp extends VertexOperator {
	private List<Vertex> path = null;

	/**
	 * Default constructor.
	 */
	public VertexPathOp() {
		path = new ArrayList<Vertex>();
	}
	
	/**
	 * Obtain the path this visitor has encounters
	 * during a graph/tree/list traversal.
	 * @return
	 */
	public List<Vertex> getPath(){
		return path;
	}
	
	/* (non-Javadoc)
	 * @see datastructures.Visitor#implementOperate(java.lang.Object)
	 */
	@Override
	protected void implementOperate(Object v) {
		if ( v instanceof Vertex ){
			Vertex vertex = (Vertex)v;
			path.add(vertex);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

}
