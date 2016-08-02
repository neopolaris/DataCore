/**
 * 
 */
package datastructures;

import java.util.Comparator;

/**
 * @author aminn
 *
 */
public class GraphEdgeComparator implements Comparator<GraphEdge> {
	/**
	 * 
	 */
	public GraphEdgeComparator() {
		//this(false);
	}

	@Override
	public int compare(GraphEdge gV0, GraphEdge gV1) {
			return gV0.compareTo(gV1);
	}

}
