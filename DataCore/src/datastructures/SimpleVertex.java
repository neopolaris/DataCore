/**
 * 
 */
package datastructures;

import java.util.HashMap;

/**
 * @author Vaygr
 *
 */
public class SimpleVertex extends Vertex {
	
	protected HashMap<String, Object> propertyMap = null;
	
	/**
	 * Default constructor
	 */
	public SimpleVertex() {
		this("");
	}

	/**
	 * Overloaded constructor
	 * @param name - Unique name for the vertex
	 */
	public SimpleVertex(String name) {
		super(name);
		propertyMap = new HashMap<String,Object>();
	}
	
	/**
	 * Get the property object of the vertex based on its key
	 * @param key - A string key corresponding to the property.
	 * @return - The object representing the property value.
	 */
	public Object getProperty(String key){
		return propertyMap.get(key);
	}
	
	/**
	 * Set the value of a property associated with a key.
	 * @param key - A string key corresponding to the property.
	 * @param value - The value to be set.
	 * @return - True if the property exist, false otherwise
	 */
	public boolean setProperty(String key, Object value){
		if ( propertyMap.containsKey(key)){
			propertyMap.put(key, value);
			return true;
		}
		return false;
	}

	/**
	 * Overload equality comparison between two objects 
	 * of SimpleVertex.
	 */
	public boolean equals(Object v){
		if ( v instanceof SimpleVertex ){
			return super.equals(v);
		}
		return false;
	}
	
	/**
	 * Obtain hash code for this object.
	 */
	public int hashCode(){
		return super.hashCode();
	}

}
