/**
 * 
 */
package algorithms;

import java.util.List;

import datastructures.Graph;
import datastructures.Vertex;

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
		return null;
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
	
	// TODO: Add static method for checking if a graph has disconnected components.
	// TODO: Add minimum spanning tree method.
	// TODO: Add Diksjtra method.
	// TODO: Add Single Source Shortest Path.
	// TODO: Add Manhattan tourist
	// TODO: Add TSP
	// TODO: Add network flow, Bipartite
}
