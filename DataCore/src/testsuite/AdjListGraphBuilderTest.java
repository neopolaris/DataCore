/**
 * 
 */
package testsuite;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.AdjListGraph;
import datastructures.AdjListGraphBuilder;
import datastructures.GraphVertex;
import datastructures.VertexPathOp;

/**
 * @author Vaygr
 *
 */
public class AdjListGraphBuilderTest {
	private List<String> simpleList = null;
	private List<String> moderateList = null;
	
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
		simpleList = DataLoader.LoadData("testdata/graph/simple_digraph.txt");
		moderateList = DataLoader.LoadData("testdata/graph/moderate_udigraph.txt");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// Testing a simple directed weighted graph
		AdjListGraphBuilder algSimpleBuilder = new AdjListGraphBuilder(simpleList);
		AdjListGraph alSimpleGraph = algSimpleBuilder.build();
		List<String> simpleGList = alSimpleGraph.toStringList();
		
		// Testing a slightly more complex un directed weighted graph
		AdjListGraphBuilder algModBuilder = new AdjListGraphBuilder(moderateList);
		AdjListGraph alModGraph = algModBuilder.build();
		List<String> modGList = alModGraph.toStringList();
		
		System.out.println(simpleGList.toString());
		System.out.println(modGList.toString());
		
		// Testing Traversal
		System.out.println("Testing DFS on simple graph ... ");
		VertexPathOp vpOp = new VertexPathOp();
		GraphVertex sgV = alSimpleGraph.getGraphVertex("0");
		alSimpleGraph.traverseDFS(sgV, vpOp);
		System.out.println(vpOp.getPath().toString());
		
		System.out.println("Testing BFS on simple graph ... ");
		VertexPathOp vpOpBFS = new VertexPathOp();
		alSimpleGraph.traverseBFS(sgV, vpOpBFS);
		System.out.println(vpOpBFS.getPath().toString());
	}

}
