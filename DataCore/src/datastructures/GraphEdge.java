/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 *
 */
public class GraphEdge extends SimpleEdge {

	/**
	 * 
	 */
	public GraphEdge() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 * @param e
	 */
	public GraphEdge(GraphVertex s, GraphVertex e) {
		super(s, e);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 * @param e
	 * @param w
	 */
	public GraphEdge(GraphVertex s, GraphVertex e, double w) {
		super(s, e, w);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 * @param e
	 * @param w
	 * @param d
	 */
	public GraphEdge(GraphVertex s, GraphVertex e, double w, boolean d) {
		super(s, e, w, d);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Given one vertex, get the other vertex
	 * @param v - A vertex belonging to an edge.
	 * @return - The other vertex belonging to an edge.
	 */
	public Vertex getOtherVertex(GraphVertex v){
		if ( v == null ){
			return null;
		}
		if ( v.equals(sVertex)){
			return eVertex;
		}
		if ( v.equals(eVertex)){
			return sVertex;
		}
		return null;
	}
	
	/**
	 * Get the starting vertex.
	 * @return - The starting vertex.
	 */
	public GraphVertex getStartVertex(){
		return (GraphVertex)sVertex;
	}
	
	/**
	 * Get the ending vertex.
	 * @return - The ending vertex.
	 */
	public GraphVertex getEndVertex(){
		return (GraphVertex)eVertex;
	}

}
