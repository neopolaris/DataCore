/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Vaygr
 * Adjacency List implementation of undirected Graph
 */
public class AdjListGraph extends Graph {

	private HashMap<GraphVertex, Set<GraphEdge>> edgeList;
	
	/**
	 * Default constructor
	 */
	public AdjListGraph() {
		super();
		edgeList = new HashMap<GraphVertex, Set<GraphEdge>>();
	}
	
	/* (non-Javadoc)
	 * @see datastructures.Graph#implementAddEdge(datastructures.Edge)
	 */
	@Override
	protected boolean implementAddVertex(GraphVertex v) {
		if ( !edgeList.containsKey(v)){
			edgeList.put(v, new HashSet<GraphEdge>());
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see datastructures.Graph#implementAddEdge(datastructures.Edge)
	 */
	@Override
	protected boolean implementAddEdge(GraphEdge e) {
		// If the starting vertex is already in the graph find it
		// And get the list of edges. Otherwise, add the starting
		// vertex into the graph.
		GraphVertex sV = e.getStartVertex();
		GraphVertex eV = e.getEndVertex();
		Set<GraphEdge> edges = edgeList.get(sV);
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
	protected List<GraphVertex> implementGetNextNeighbors(GraphVertex v) {
		// Find the vertex in the map and return outgoing edges.
		List<GraphVertex> vertList = new ArrayList<GraphVertex>();
		if ( edgeList.containsKey(v)){
			Set<GraphEdge> edges = edgeList.get(v);
			for ( GraphEdge edge : edges ){
				vertList.add((GraphVertex)edge.getOtherVertex(v));
			}
		}
		return vertList;
	}

	@Override
	protected List<String> implementToStringList() {
		List<String> edgeStrList = new ArrayList<String>();
		Set<GraphVertex> vertices = edgeList.keySet();
		for ( Vertex sV : vertices ){
			StringBuilder sb = new StringBuilder(sV.getVertexName());
			sb.append("->");
			Set<GraphEdge> edges = edgeList.get(sV);
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
	protected void implementDoDFS(GraphVertex gV, VertexOperator vOp) {
		doDFS(gV,vOp);
	}

	@Override
	protected void implementDoBFS(GraphVertex gV, VertexOperator vOp) {
		doBFS(gV, vOp);
	}
	
	private void doBFS(GraphVertex gV, VertexOperator vOp) {
		LinkedList<GraphVertex> vertexQ = new LinkedList<GraphVertex>();
		HashSet<GraphVertex> visited = new HashSet<GraphVertex>();
		vertexQ.addFirst(gV);
		while ( !vertexQ.isEmpty() ){
			GraphVertex curVertex = vertexQ.removeFirst();
			if ( !visited.contains(curVertex)){
				vOp.operate(curVertex);
				List<GraphVertex> neighbors = getNextNeighbors(curVertex);
				vertexQ.addAll(neighbors);
			}
			visited.add(curVertex);
		}
	}

	private void doDFS(GraphVertex gV, VertexOperator op){
		// TODO still needs refinement for visitor operation so that
		// it doesn't operate on those that were already visited.
		if ( gV == null ){
			return;
		}
		else {
			op.operate(gV);
			List<GraphVertex> neighbors = this.getNextNeighbors(gV);
			for ( GraphVertex nV : neighbors ){
				doDFS(nV, op);
			}
		}
	}

	@Override
	protected GraphVertex implementGetGraphVertex(String name) {
		GraphVertex gV = new GraphVertex(name);
		for ( GraphVertex tgV : edgeList.keySet() ){
			if ( tgV.equals(gV)){
				return tgV;
			}
		}
		return null;
	}
}
