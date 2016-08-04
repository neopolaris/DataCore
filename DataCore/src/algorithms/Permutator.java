/**
 * 
 */
package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aminn
 *
 */
public class Permutator {

	/**
	 * 
	 */
	public Permutator() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<String >permutate(String target){
		// Error checking
		if ( target == null ){
			return null;
		}
		
		List<String> permutations = new ArrayList<String>();
		if ( target.length() == 0 ){
			permutations.add(" "); // Base case add empty string.
			return permutations;
		}
		else {
			char firstChar = target.charAt(0); // Save the first char
			String leftOver = target.substring(1);
			List<String> morePermutations = Permutator.permutate(leftOver); // Remove the first char
			for ( String perm : morePermutations ){
				for ( int i=0; i < perm.length(); i++){
					String morePerm = insertCharAt(firstChar, perm, i );
					permutations.add(morePerm);
				}
			}
		}
		return permutations;
	}
	
	private static String insertCharAt(char c, String target, int i){
		String start = target.substring(0, i);
		String end = target.substring(i);
		return start + c + end;
	}
	
	public static void main(String args[]) {
		
		List<String> permutations = new ArrayList<String>();
		String target = "abcd";
		permutations = Permutator.permutate(target);
		System.out.println(permutations);
		
	}

}
