/**
 * 
 */
package algorithms;

/**
 * @author Vaygr
 *
 */
public class DPAlgorithms {

	/**
	 * 
	 */
	public DPAlgorithms() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Createds a fibonacci sequence up to n-th position.
	 * @param n - Sequence length.
	 * @return - Fibonacci sequence of length n.
	 */
	public static int fibonacciNumbersRecursion(int n){
		// A naive method is to use recursion
		if ( n == 0 ){
			return 0;
		}
		else if ( n == 1 ){
			return 1;
		}
		else {
			return fibonacciNumbersRecursion(n-1) + fibonacciNumbersRecursion(n-2);
		}
	}

	public static int fibonacciNumbersDP(int n){
		int[] fibNums = new int[n+1];
		fibNums[0] = 0;
		fibNums[1] = 1;
		for ( int i = 2; i < fibNums.length; i++ ){
			fibNums[i] = fibNums[i-1] + fibNums[i-2]; 
		}
		return fibNums[n];
	}
	
	public static int longestCommonSubsequence(String s1, String s2, int[][] btSolMatrix ){
		int[][] dpMatrix = new int[s2.length()+1][s1.length()+1];
		
		// If S1 is empty then there is no LCS.
		for ( int i=0; i < s2.length()+1; i++){
			dpMatrix[i][0] = 0;
		}
		
		// If S2 is empty then there is no LCS.
		for ( int i=0; i < s1.length()+1; i++){
			dpMatrix[0][i] = 0;
		}
		
		for ( int i=1; i <= s2.length(); i++ ){
			for ( int j=1; j <= s1.length(); j++){
				if ( s2.codePointAt(i-1) == s1.codePointAt(j-1)){
					dpMatrix[i][j] = dpMatrix[i-1][j-1] + 1;
				}
				else {
					dpMatrix[i][j] = Math.max(dpMatrix[i-1][j], dpMatrix[i][j-1]);
				}
			}
		}
		return dpMatrix[s2.length()][s1.length()];
	}
	
	public static int editDistance(String s1, String s2, int[][] btSolMatrix ){
		int[][] dpMatrix = new int[s2.length()+1][s1.length()+1];
		
		// First column, S1 is empty. In this case the only way to
		// mutate the S2 is to remove everything in S2.
		for ( int i=0; i < s2.length()+1; i++ ) {
			dpMatrix[i][0] = i;
		}
		
		// First row, S2 is empty. In this case the only way to mutate
		// S1 is to insert everything from S1.
		for ( int i=0; i < s1.length()+1; i++){
			dpMatrix[0][i] = i;
		}
		
		for ( int i=1; i <= s2.length(); i++ ){
			for ( int j=1; j <= s1.length(); j++ ){
				if ( s2.codePointAt(i-1) == s1.codePointAt(j-1)){
					dpMatrix[i][j] = dpMatrix[i-1][j-1];
				}
				else {
					dpMatrix[i][j] = 1 + Math.min(dpMatrix[i][j-1], 	// Insertion
									     Math.min(dpMatrix[i-1][j],		// Deletion
									              dpMatrix[i-1][j-1] ));// Mutation
				} 
			}
		}
		return dpMatrix[s2.length()][s1.length()];
	}
	
	public static void main(String [] args){
		int fibLoc = 10;
		System.out.println("Testing fibonacci number generation using recursion ... ");
		int fibNumRecur = DPAlgorithms.fibonacciNumbersRecursion(fibLoc);
		System.out.printf("The %d Fibonaccci number is : %d \n", fibLoc, fibNumRecur);
		
		System.out.println("Testing fibonacci number generation using recursion ... ");
		int fibNumDp = DPAlgorithms.fibonacciNumbersDP(fibLoc);
		System.out.printf("The %d Fibonaccci number is : %d \n", fibLoc, fibNumDp);
		
		System.out.println("Testing Largest Common Sub-Sequence ... ");
		String s1 = "ABCDA";
		String s2 = "ACBDEA";
		int[][] solMatrix = new int[s2.length()][s1.length()];
		int lcsLength = DPAlgorithms.longestCommonSubsequence(s1, s2, solMatrix );
		System.out.println("The Anser is " + lcsLength);
		
		System.out.println("Testing edit distance ... ");
		s1 = "horizontal";
		s2 = "horizon";
		int[][] solMatrix1 = new int[s2.length()][s1.length()];
		int distance = DPAlgorithms.editDistance(s1, s2, solMatrix1 );
		System.out.println("The Anser is " + distance);
		
	}
}
