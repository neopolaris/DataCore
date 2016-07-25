/**
 * 
 */
package testsuite;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.AdjListGraphBuilder;
import utils.StringMatch;

/**
 * @author Vaygr
 *
 */
public class StringMatchTest {
	
	private List<String> simpleList = null;
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
		//simpleList = DataLoader.LoadData("\\data\\simple_graph_test.txt");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String[] tokens = "0 -> 1:7".split(" -> ");
		assertEquals("Testing split tokens", true, tokens[0].equals("0"));
		assertEquals("Testing split tokens", true, tokens[1].equals("1:7"));
	}

}
