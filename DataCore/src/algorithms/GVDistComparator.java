/**
 * 
 */
package algorithms;

import java.util.Comparator;
import java.util.Map;

import datastructures.GraphVertex;

/**
 * @author aminn
 *
 */
public class GVDistComparator implements Comparator<GraphVertex> {
	private Map<GraphVertex, Double> distances = null;

	/**
	 * 
	 */
	public GVDistComparator(Map<GraphVertex, Double> distMap) {
		distances = distMap;
	}

	@Override
	public int compare(GraphVertex arg0, GraphVertex arg1) {
		double val0 = distances.get(arg0);
		double val1 = distances.get(arg1);
		return Double.compare(val0, val1);
	}

}
