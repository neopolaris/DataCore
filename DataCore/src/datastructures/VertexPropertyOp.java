/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 *
 */
public class VertexPropertyOp extends VertexPathOp {

	private VertexProperties propertyKey;
	private Object valueObj = null;
	
	/**
	 * 
	 */
	public VertexPropertyOp(VertexProperties pKey, Object value) {
		propertyKey = pKey;
		valueObj = value;
	}

	/* (non-Javadoc)
	 * @see datastructures.Visitor#implementOperate(java.lang.Object)
	 */
	@Override
	protected void implementOperate(Object v) {
		super.implementOperate(v);
		if ( v instanceof SimpleVertex ){
			SimpleVertex vertex = (SimpleVertex)v;
			vertex.setProperty(propertyKey.toString(), valueObj);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
