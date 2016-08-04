/**
 * 
 */
package algorithms;

/**
 * @author Vaygr
 *
 */
public class Search {

	/**
	 * 
	 */
	public Search() {
		// TODO Auto-generated constructor stub
	}
	
	public static int rabinKarpStringSearch(String text, String pattern){
		// TODO Implement Rabin Karp String search algorithm
		return -1;
	}
	
	public static int binarySearch(int target, int[] input){
		return binarySearch(0,input.length-1, target, input);
	}
	
	private static int binarySearch(int low, int high, int target, int[] input){
		if ( low > high ){
			return -1;
		}
		else {
			int mid = ( low + high ) / 2;
			if ( target == input[mid] ){
				return mid;
			}
			else if ( target < input[mid] ){
				return binarySearch( low, mid, target, input);
			}
			else if ( target > input[mid] ){
				return binarySearch( mid+1, high, target, input);
			}
		}
		return -1;
	}

}
