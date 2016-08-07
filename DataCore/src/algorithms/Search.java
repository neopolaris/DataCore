/**
 * 
 */
package algorithms;

import java.util.HashMap;

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
		// Take the string. Creates an array of chars of string's length
		// At each array's element location creates a rolling hash code.
		// 		This code will cover sub-string hash code.
		// Now, use the same hash generation on the pattern.
		// Look up the hash table.
		HashMap<Integer, Integer> codeMap = new HashMap<Integer, Integer>();
		int tLength = text.length();
		int pLength = pattern.length();
		int prevPatternHash = 0;
		for ( int i = 0; i < tLength - pLength; i++){
			String nextPattern = text.substring(i, i+pLength);
			int curPatternHash = genRollingHash(text, nextPattern, prevPatternHash, i-1, 26);
			codeMap.put(curPatternHash,i);
			prevPatternHash = curPatternHash;
		}
		int patternHash = genRollingHash(pattern, 26); //(text, pattern,codeMap, -1, 26);
		return codeMap.get(patternHash);
	}
	
	private static int genRollingHash(String pattern, int base){
		int pHashCode = 0;
		for ( int i= pattern.length() - 1; i >= 0; i--){
			int charCode = pattern.codePointAt(i);
			int exponent = (pattern.length() - 1) - i;
			pHashCode += ( charCode * (Math.pow(base, exponent)));
		}
		return pHashCode;
	}
	
	private static int genRollingHash(String text, String pattern, int prevPatternHash, int prevLoc, int base) {
		// Let's assume that the string is all lower cases.
		// Then generate base 26 number.
		int pHashCode = 0;
		if ( prevLoc < 0 ){ // This is the first or single pattern
			pHashCode = genRollingHash(pattern, base);
		}
		else {
			// new Code = previousHash - value of the prev char + Hash of the new char.
			int prevCharCode = text.codePointAt(prevLoc);
			int curCharHash = pattern.codePointAt(pattern.length() - 1);
			int exponent = pattern.length() - 1;
			int prevCharHash = (int)(prevCharCode * (Math.pow(base, exponent))); 
			int curPatternHash = ((prevPatternHash - prevCharHash) * base ) + curCharHash; 	
			pHashCode = curPatternHash;
		}
		return pHashCode;
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
