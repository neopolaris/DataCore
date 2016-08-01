/**
 * 
 */
package testsuite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.Sort;

/**
 * @author Vaygr
 *
 */
public class SortAndSearchTest {
	private int[] simpleArray = null; 

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
		simpleArray = new int[] { 6,7,2,4,8,3,5,1,12,9,11,10 };
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Sort.mergeSort(simpleArray);
		printArray(simpleArray);
	}
	
	private void printArray(int[] input){
		for ( int e : input ){
			System.out.print(e + ",");
		}
	}

}
