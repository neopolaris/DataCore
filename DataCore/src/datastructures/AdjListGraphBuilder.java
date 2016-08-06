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
			String vertStr = "";
			String edgeStr = "";
			
			// Check if the vertex is a leaf and build it accordingly.
			if ( tokens.length > 0 ){
				vertStr = tokens[0];
			}
			if ( tokens.length > 1 ){
				edgeStr = tokens[1];
			}
			
			// Add a new vertex with the string name if the name is not blank.
			if ( !vertStr.isEmpty() ){
				GraphVertex sVert = new GraphVertex(vertStr); 
				graph.addVertex(sVert);
			
			
				// If if the trailing nodes are blank then we just have a leaf vertex.
				if ( !edgeStr.isEmpty() ) {
				String[] edgeTokens = edgeStr.split(",");
					for ( String edgeToken : edgeTokens ){
						// Now split it using ":"
						String[] edgeVals = edgeToken.split(":");				
						String eVertVal = "";
						String wgtVal = "";
						
						// Check if the edges has weights and parse it accordingly
						if ( edgeVals.length > 0 ){
							eVertVal = edgeVals[0];
						}
						if ( edgeVals.length > 1 ){
							wgtVal = edgeVals[1];
						}
						
						// If ending vertex name is not empty.
						if ( !eVertVal.isEmpty() ) {
							GraphVertex eVert = new GraphVertex(eVertVal);
							Double weight = 0.0;
							try {
								weight = Double.parseDouble(wgtVal);
							}
							catch ( NumberFormatException ex ){
								weight = 0.0;
							}
							GraphEdge sEdge = new GraphEdge(sVert, eVert, weight);
							graph.addEdge(sEdge);
						}
					}
				}
			}
		}
		return graph;
	}

}
