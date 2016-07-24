/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vaygr
 * Adjacency List implementation of undirected Graph
 */
public class AdjListGraph extends Graph {

	private HashMap<Vertex, Set<Edge>> edgeList;
	/**
	 * Default constructor
	 */
	public AdjListGraph() {
		super();
		edgeList = new HashMap<Vertex, Set<Edge>>();
	}
	
	/* (non-Javadoc)
	 * @see datastructures.Graph#implementAddEdge(datastructures.Edge)
	 */
	@Override
	protected boolean implementAddVertex(Vertex v) {
		if ( !edgeList.containsKey(v)){
			edgeList.put(v, new HashSet<Edge>());
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see datastructures.Graph#implementAddEdge(datastructures.Edge)
	 */
	@Override
	protected boolean implementAddEdge(Edge e) {
		// If the starting vertex is already in the graph find it
		// And get the list of edges.
		Set<Edge> edges = edgeList.get(e.getStartVertex());
		if ( edges != null ){
			if ( !edges.contains(e)){
				edges.add(e);
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see datastructures.Graph#implementGetNextNeighbors(datastructures.Vertex)
	 */
	@Override
	protected List<Vertex> implementGetNextNeighbors(Vertex v) {
		// Find the vertex in the map and return outgoing edges.
		List<Vertex> vertList = new ArrayList<Vertex>();
		if ( edgeList.containsKey(v)){
			Set<Edge> edges = edgeList.get(v);
			for ( Edge edge : edges ){
				vertList.add(edge.getOtherVertex(v));
			}
		}
		return vertList;
	}
}
