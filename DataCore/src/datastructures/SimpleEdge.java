/**
 * 
 */
package datastructures;

import java.util.HashMap;

/**
 * @author Vaygr
 *
 */
public class SimpleEdge extends Edge {
	
	// A lookup table for properties associated with an edge.
	private HashMap<String,Object> property = null;
	
	// A constant key used to retrieve and set weight property.
	private static String wgtKey = "Weight";
	
	// A flag indicating if this edge is directed.
	private boolean directed = false;

	/**
	 * Default constructor
	 */
	public SimpleEdge() {
		this(null, null, 0.0);
	}

	/**
	 * Overloaded constructor
	 * @param s - Starting vertex of the edge
	 * @param e - Ending vertex of the edge
	 */
	public SimpleEdge(Vertex s, Vertex e) {
		this(s, e, 0.0);
	}

	/**
	 * Overloaded constructor.
	 * @param s - Starting vertex of the edge
	 * @param e - Ending vertex of the edge
	 * @param w - Weight of the edge, if there is one
	 */
	public SimpleEdge(Vertex s, Vertex e, double w) {
		this( s, e, w, false);
	}
	
	/**
	 * Overloaded constructor.
	 * @param s - Starting vertex of the edge
	 * @param e - Ending vertex of the edge
	 * @param w - Weight of the edge, if there is one
	 */
	public SimpleEdge(Vertex s, Vertex e, double w, boolean d) {
		super(s, e);
		property = new HashMap<String,Object>();
		property.put(wgtKey, w);
		directed = d;
	}

	/**
	 * Check if the edge is directed or undirected.
	 * @return
	 */
	public boolean isDirected(){
		return directed;
	}
	
	@Override
	protected double implementGetWeight() {
		return (Double.parseDouble(property.get(wgtKey).toString()));		
	}

	@Override
	protected Object implementGetProperty(String key) {
		return property.get(key);
	}

	@Override
	protected boolean implementSetProperty(String key, Object value) {
		if ( property.containsKey(key)){
			property.put(key, value);
			return true;
		}
		else {
			return false;
		}
	}

}
