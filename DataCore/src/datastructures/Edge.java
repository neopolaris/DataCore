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
	
	/**
	 * Default Constructor.
	 */
	public Edge(){
		this(null, null);
	}
	
	/**
	 * Overloaded constructor.
	 * @param s - Starting Vertex.
	 * @param e - Ending Vertex.
	 * @param w - Weight of the edge.
	 */
	public Edge( Vertex s, Vertex e){
		sVertex = s;
		eVertex = e;
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
	
	/**
	 * Get the weight of the edge if there is one.
	 * @return
	 */
	public double getWeight(){
		return implementGetWeight();
	}
	
	/**
	 * Get a particular property of edge based on its name
	 * @return
	 */
	public Object getProperty(String key){
		return implementGetProperty(key);
	}
	
	/**
	 * Set a particular property given its name.
	 * @param key - The string name of the property
	 * @param value - Object representing the value;
	 * @return
	 */
	public boolean setProperty(String key, Object value){
		return implementSetProperty(key, value);
	}
	
	/**
	 * Override for comparing two edge objects. At the
	 * minimum, two edges are equal iff two vertices
	 * are equal.
	 */
	public boolean equals(Object e){
		if ( e != null && e instanceof Edge ){
			Edge edg = (Edge)e;
			return ( sVertex.equals(edg.getStartVertex()) && eVertex.equals(edg.getEndVertex()));
		}
		return false;
	}
	
	/**
	 * Override for generating hash codes for edges.
	 */
	public int hashCode(){
		return ( sVertex.hashCode() ^ eVertex.hashCode());
	}
	
	protected abstract double implementGetWeight();
	protected abstract Object implementGetProperty(String key);
	protected abstract boolean implementSetProperty(String key, Object value);
	
}
