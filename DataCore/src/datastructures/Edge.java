/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 *
 */
public abstract class Edge {
	protected Vertex sVertex = null;
	protected Vertex eVertex = null;
	protected double weight = 0.0;
	
	/**
	 * Default Constructor.
	 */
	public Edge(){
		this(null, null, 0.0);
	}
	
	/**
	 * Overloaded constructor.
	 * @param s - Starting Vertex.
	 * @param e - Ending Vertex.
	 */
	public Edge(Vertex s, Vertex e){
		this(s,e, 0.0);
	}
	
	/**
	 * Overloaded constructor.
	 * @param s - Starting Vertex.
	 * @param e - Ending Vertex.
	 * @param w - Weight of the edge.
	 */
	public Edge( Vertex s, Vertex e, double w){
		sVertex = s;
		eVertex = e;
		weight = w;
	}
	
	/**
	 * Given one vertex, get the other vertex
	 * @param v - A vertex belonging to an edge.
	 * @return - The other vertex belonging to an edge.
	 */
	public Vertex getOtherVertex(Vertex v){
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
	public Vertex getStartVertex(){
		return sVertex;
	}
	
	/**
	 * Get the ending vertex.
	 * @return - The ending vertex.
	 */
	public Vertex getEndVertex(){
		return eVertex;
	}
}
