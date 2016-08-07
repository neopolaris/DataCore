/**
 * 
 */
package testsuite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.Search;
import algorithms.Sort;

/**
 * @author Vaygr
 *
 */
public class SortAndSearchTest {
	private int[] simpleArray = null; 
	private String inText = "";
	private String inPattern = "";

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
		inText = "A long long time ago in a galaxy far far away.";
		inPattern = "galaxy";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMergeSort() {
		System.out.println("Testing Merge Sort ... ");
		System.out.print("Original Array : ");
		printArray(simpleArray);
		Sort.mergeSort(simpleArray);
		printArray(simpleArray);
	}
	
	@Test
	public void testBinarySearch(){
		Sort.mergeSort(simpleArray);
		printArray(simpleArray);
		System.out.println("\nTesting binary search for 10... ");
		int index = Search.binarySearch(10, simpleArray);
		System.out.println("Search target found at index: " + index);
	}
	
	@Test
	public void testRabinKarpStringSearch(){
		System.out.println("\nTesting Rabin Karp's String Search ...");
		System.out.println("Searching for : [ " + inPattern + " ]");
		System.out.println("In the text : " + inText);
		int loc = Search.rabinKarpStringSearch(inText, inPattern);
		System.out.println("Target pattern found at : " + loc);
	}
	
	private void printArray(int[] input){
		for ( int e : input ){
			System.out.print(e + ",");
		}
	}

}
