/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 *
 */
public abstract class Visitor {

	/**
	 * Default constructor 
	 */
	public Visitor() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Perform a specific operation on the current object.
	 * @param v - The current object visitor is visiting.
	 */
	public void operate(Object v){
		implementOperate(v);
	}
	
	/**
	 * Abstract class for implementation of operation.
	 * @param v - The object visitor is visiting. 
	 */
	protected abstract void implementOperate(Object v);

}
