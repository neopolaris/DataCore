/**
 * 
 */
package datastructures;

import java.util.List;

/**
 * @author Vaygr
 *
 */
public class AdjListGraphBuilder extends Builder {

	private AdjListGraph graph = null;
	private List<String> inputList = null;
	
	/**
	 * Default constructor
	 */
	public AdjListGraphBuilder(){
		this(null);
	}
	
	/**
	 * Overloaded constructor
	 */
	public AdjListGraphBuilder(List<String> input) {
		inputList = input;
		graph = new AdjListGraph();
	}

	/* (non-Javadoc)
	 * @see datastructures.Builder#build()
	 */
	@Override
	public AdjListGraph build() {
		// TODO Auto-generated method stub
		for ( String inputStr : inputList ){
			// Use regular expression to split the string based on token " -> "
			// The first part is the vertex, so add it.
			// Iterate the remaining parts and split based on ","
			// Then split the parts again based on ":"
			// The remaining parts will be end vertex of the edge and corresponding weight.
			String patStr = "->";
			String[] tokens = inputStr.split(patStr);
			String vertStr = tokens[0];
			String edgeStr = tokens[1];
			SimpleVertex sVert = new SimpleVertex(vertStr); 
			graph.addVertex(sVert);
			String[] edgeTokens = edgeStr.split(",");
			for ( String edgeToken : edgeTokens ){
				// Now split it using ":"
				String[] edgeVals = edgeToken.split(":");
				String eVertVal = edgeVals[0];
				String wgtVal = edgeVals[1];
				SimpleVertex eVert = new SimpleVertex(eVertVal);
				SimpleEdge sEdge = new SimpleEdge(sVert, eVert, Double.parseDouble(wgtVal));
				graph.addEdge(sEdge);
			}
		}
		return graph;
	}

}
