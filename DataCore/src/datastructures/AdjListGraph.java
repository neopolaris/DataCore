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
		// And get the list of edges. Otherwise, add the starting
		// vertex into the graph.
		Vertex sV = e.getStartVertex();
		Vertex eV = e.getEndVertex();
		Set<Edge> edges = edgeList.get(sV);
		if ( edges != null ){
			if ( !edgeList.containsKey(eV)){
				addVertex(eV);
			}
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

	@Override
	protected List<String> implementToStringList() {
		List<String> edgeStrList = new ArrayList<String>();
		Set<Vertex> vertices = edgeList.keySet();
		for ( Vertex sV : vertices ){
			StringBuilder sb = new StringBuilder(sV.getVertexName());
			sb.append("->");
			Set<Edge> edges = edgeList.get(sV);
			for ( Edge e : edges ){
				Vertex eV = e.getOtherVertex(sV);
				sb.append(eV.getVertexName());
				sb.append(":");
				sb.append(e.getWeight());
				sb.append(',');
			}
			edgeStrList.add(sb.toString());
		}
		return edgeStrList;
	}

	@Override
	protected void implementDoDFS(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void implementDoBFS(Visitor v) {
		// TODO Auto-generated method stub
		
	}
}
