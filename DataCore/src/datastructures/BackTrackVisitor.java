/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 *
 */
public class BackTrackVisitor extends Visitor {

	/**
	 * 
	 */
	public BackTrackVisitor() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see datastructures.Visitor#implementOperate(java.lang.Object)
	 */
	@Override
	protected void implementOperate(Object v) {
		// TODO Auto-generated method stub

	}
	
	public boolean finished(){
		// TODO: Implement exit early;
		return false;
	}

}
