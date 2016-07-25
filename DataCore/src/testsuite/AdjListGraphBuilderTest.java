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

import datastructures.AdjListGraph;
import datastructures.AdjListGraphBuilder;

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
		
				
	}

}
