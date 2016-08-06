/**
 * 
 */
package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.MinMaxPriorityQueue;
import datastructures.Graph;
import datastructures.GraphEdge;
import datastructures.GraphVertex;
import datastructures.Vertex;
import datastructures.VertexPathOp;
import datastructures.VertexProperties;
import datastructures.VertexPropertyOp;

/**
 * @author Vaygr
 *
 */
public class GraphAlgorithms {

	/**
	 * 
	 */
	public GraphAlgorithms() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Perform topological sorting of a directed acyclic graph
	 * @param g - A directed graph to be sorted.
	 * @return - List of vertices in sorted order.
	 */
	public static List<Vertex> topSort(Graph g){
		// TODO:Implement topSort
		// Graph can do dfs. With an operator class
		// operating at each process.
		GraphVertex gV = g.getGraphVertex("0");
		VertexPathOp vpOp = new VertexPathOp();
		g.traverseDFS(gV, vpOp);
		return vpOp.getPath();
	}
	
	/**
	 * Test if a graph is directed acyclic
	 * @param g - A graph to be tested.
	 * @return - True if graph is a DAG, false otherwise.
	 */
	public static boolean isDAG(Graph g){
		// TODO: Implement isDAG
		return false;
	}
	
	public static int connectedComponents(Graph g){
		
		// Initialize starting component number and map to keep track of these ID.
		Integer comNo = 1;
		List<GraphVertex> graphVertices = g.getAllVertices();
		HashMap<GraphVertex, Integer> vertexCompMap = new HashMap<GraphVertex, Integer>();
		GraphVertex gV = g.getFirstVertex();
		
		while ( gV != null ){
			// Do a DFS traversal and set all vertices to current component number.
			VertexPropertyOp pptyOp = new VertexPropertyOp(VertexProperties.ComponentNo, comNo);
			g.traverseDFS(gV, pptyOp);
			
			for ( Vertex v : pptyOp.getPath()){
				vertexCompMap.put((GraphVertex)v, comNo);
			}
	
			// Find next GraphVertex that is not in the component list
			boolean found = false;
			gV = null;
			Iterator<GraphVertex> iter = graphVertices.iterator();
			while ( iter.hasNext() && !found ){
				GraphVertex tV = iter.next();
				if ( !vertexCompMap.containsKey(tV)){
					gV = tV;
					found = true;
					comNo++;
				}
			}
		}
		return comNo;
	}
	
	public static List<Vertex> eulerianPath(){
		// TODO: Implement Eulerian Path
		return null;
	}
	
	public static List<Vertex> singleSourceShortestPath(Graph g, String svName, String tvName) {
		
		//VertexPathOp vpOp = new VertexPathOp();
		GraphVertex startV = g.getGraphVertex(svName);
		GraphVertex targetV = g.getGraphVertex(tvName);
		
		HashMap<GraphVertex, Double> distances = new HashMap<GraphVertex, Double>();
		HashMap<GraphVertex, GraphVertex> parents = new HashMap<GraphVertex, GraphVertex>();
		HashSet<GraphVertex> visited = new HashSet<GraphVertex>();
		
		MinMaxPriorityQueue<GraphVertex> vertexQ = MinMaxPriorityQueue.orderedBy(new GVDistComparator(distances)).create();
		
		for ( GraphVertex gV : g.getAllVertices() ){
			distances.put(gV, Double.POSITIVE_INFINITY);
			parents.put(gV, null);
			vertexQ.add(gV);
		}
		
		distances.put(startV, 0.0);	// This essentially sets the source node as first.
		
		while ( !vertexQ.isEmpty() ){
			GraphVertex currV = vertexQ.removeFirst();
			if ( !visited.contains(currV)){
				visited.add(currV);
				if ( targetV.equals(currV)){
					return traceParents(parents, targetV);
				}
				List<GraphVertex> neighbors = g.getNextNeighbors(currV);
				for ( GraphVertex nV : neighbors ){
					if ( !visited.contains(nV)){
						GraphEdge gE = g.getEdge(currV, nV);
						double dist = distances.get(currV) + gE.getWeight();
						if ( dist < distances.get(nV) ){
							distances.put(nV, dist);
							parents.put(nV, currV);
							vertexQ.add(nV);
						}
					}
				}				
			}						
		}
		return new ArrayList<Vertex>();
		
	}

	private static List<Vertex> traceParents(HashMap<GraphVertex, GraphVertex> parents, GraphVertex tV){
		List<Vertex> path = new ArrayList<Vertex>();
		if ( parents.get(tV) == null ){
			path.add(tV);
			return (path);
		}
		else {
			List<Vertex> curPath = traceParents(parents, parents.get(tV));
			curPath.add(tV);
			return curPath;
		}
	}
	
	
	
	// TODO: Add static method for checking if a graph has disconnected components.
	// TODO: Add minimum spanning tree method.
	// TODO: Add Single Source Shortest Path.
	// TODO: Add Manhattan tourist
	// TODO: Add TSP
	// TODO: Add network flow, Bipartite
}
