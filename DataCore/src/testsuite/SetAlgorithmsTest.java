/**
 * 
 */
package testsuite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.SetAlgorithms;

/**
 * @author Vaygr
 *
 */
public class SetAlgorithmsTest {

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link algorithms.SetAlgorithms#SetAlgorithms()}.
	 */
	@Test
	public void testSetAlgorithms() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link algorithms.SetAlgorithms#findAllSubsets(java.util.List, int)}.
	 */
	@Test
	public void testFindAllSubsets() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link algorithms.SetAlgorithms#findAllSubset(java.util.List)}.
	 */
	@Test
	public void testFindAllSubset() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link algorithms.SetAlgorithms#setCover()}.
	 */
	@Test
	public void testSetCover() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link algorithms.SetAlgorithms#minSumSubSet(int[], int)}.
	 */
	@Test
	public void testMinSumSubSet() {
		System.out.println("Testing minimum subset sum ...");
		int[] d = new int[] {1,3,5};
		int total = 2;
		int minCount = SetAlgorithms.minSumSubSet(d, total);
		System.out.println(minCount);
	}

	@Test
	public void testNumSubSetSum(){
		System.out.println("Testing number of ways elements of a set can sum up to a total ...");
		int[] d = new int[] { 1,2,3 };
		int total = 5;
		int numWays = SetAlgorithms.numSubSetsSum(d, total);
		System.out.println(numWays);
	}
	
	@Test
	public void testIsSubSetSum(){
		System.out.println("Testing if elements of a set can sum up to a total ...");
		int[] e = new int[] { 3,2,1,7 };
		int sum = 6;
		boolean solution = SetAlgorithms.isSubSetSum(e, sum);
		System.out.println(solution);
	}
	
	/**
	 * Test method for {@link algorithms.SetAlgorithms#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
