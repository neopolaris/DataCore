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
	
	private HashMap<String,Object> property = null;
	private static String wgtKey = "Weight";

	/**
	 * 
	 */
	public SimpleEdge() {
		this(null, null, 0.0);
	}

	/**
	 * @param s
	 * @param e
	 */
	public SimpleEdge(Vertex s, Vertex e) {
		this(s, e, 0.0);
	}

	/**
	 * @param s
	 * @param e
	 * @param w
	 */
	public SimpleEdge(Vertex s, Vertex e, double w) {
		super(s, e);
		property = new HashMap<String,Object>();
		property.put(wgtKey, w);
	}

	@Override
	public double implementGetWeight() {
		return (Double.parseDouble(property.get(wgtKey).toString()));		
	}

	@Override
	public Object implementGetProperty(String key) {
		return property.get(key);
	}

	@Override
	public boolean implementSetProperty(String key, Object value) {
		if ( property.containsKey(key)){
			property.put(key, value);
			return true;
		}
		else {
			return false;
		}
	}

}
