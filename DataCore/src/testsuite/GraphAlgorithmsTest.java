/**
 * 
 */
package testsuite;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.GraphAlgorithms;
import datastructures.AdjListGraph;
import datastructures.AdjListGraphBuilder;
import datastructures.Vertex;

/**
 * @author aminn
 *
 */
public class GraphAlgorithmsTest {
	private List<String> smallList = null;
	private List<String> medList = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		smallList = DataLoader.LoadData("testdata/graph/small_digraph.txt");
		medList = DataLoader.LoadData("testdata/graph/medium_digraph.txt");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link algorithms.GraphAlgorithms#topSort(datastructures.Graph)}.
	 */
	@Test
	public void testTopSort() {
		// Testing a slightly more complex un directed weighted graph
		System.out.println("Testing top-sort algorithm for a small size adjacency list directed graph ... ");
		AdjListGraphBuilder algSmallBuilder = new AdjListGraphBuilder(smallList);
		AdjListGraph alSmallGraph = algSmallBuilder.build();
		List<String> smallGList = alSmallGraph.toStringList();		
		System.out.println(smallGList.toString());
		List<Vertex> topsortResults = GraphAlgorithms.topSort(alSmallGraph);
		System.out.println("Topological Order: " + topsortResults.toString());
	}

	/**
	 * Test method for {@link algorithms.GraphAlgorithms#isDAG(datastructures.Graph)}.
	 */
	@Test
	public void testIsDAG() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link algorithms.GraphAlgorithms#singleSourceShortestPath(datastructures.Graph)}.
	 */
	@Test
	public void testSingleSourceShortestPath() {
		// Testing Single Source Shortest Path
		System.out.println("Testing Dijkstra Algorithm ...." );
		AdjListGraphBuilder algMedBuilder = new AdjListGraphBuilder(medList);
		AdjListGraph alMedGraph = algMedBuilder.build();
		List<String> medGList = alMedGraph.toStringList();		
		System.out.println(medGList.toString());
		List<Vertex> dijkstraResults = GraphAlgorithms.singleSourceShortestPath(alMedGraph, "0", "7");
		System.out.println("Shortest Path: " + dijkstraResults.toString());
	}

}
