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
	 * 
	 */
	public SimpleVertex() {
		this("");
	}

	/**
	 * @param name
	 */
	public SimpleVertex(String name) {
		super(name);
		propertyMap = new HashMap<String,Object>();
	}
	
	public Object getProperty(String key){
		return propertyMap.get(key);
	}
	
	public boolean setProperty(String key, Object value){
		if ( propertyMap.containsKey(key)){
			propertyMap.put(key, value);
			return true;
		}
		return false;
	}

	public boolean equals(Object v){
		if ( v instanceof SimpleVertex ){
			return super.equals(v);
		}
		return false;
	}
	
	public int hashCode(){
		return super.hashCode();
	}

}
