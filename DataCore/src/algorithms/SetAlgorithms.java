package algorithms;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

public class SetAlgorithms {

	public SetAlgorithms() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<List<Integer>> findAllSubsets(List<Integer> set, int idx){
		List<List<Integer>> powerSet = null;
		if ( idx == set.size() ) { //Base case, return empty set
			powerSet = new ArrayList<List<Integer>>();
			powerSet.add(new ArrayList<Integer>()); //Empty Set
		}
		else {
			powerSet = findAllSubsets(set, idx + 1);
			int curItem = set.get(idx);
			
			//Now to generate all new additional subsets
			ArrayList<List<Integer>> moreSubSets = new ArrayList<List<Integer>>();
			
			//Traverse all existing subsets so far (i.e. from previous recursions)
			for ( List<Integer> existingSubSet : powerSet ){
				ArrayList<Integer> newSubSet = new ArrayList<Integer>();
				newSubSet.addAll(existingSubSet);
				newSubSet.add(curItem);
				moreSubSets.add(newSubSet);
			}
 			powerSet.addAll(moreSubSets);
		}
		return powerSet;
	}
	
	public static List<List<Integer>> findAllSubset(List<Integer> set)
	{
		//TODO: Implement this method
		return null;
	}
	
	public static void setCover() {
		
	} 
	
	public static int minSumSubSet(int[] d, int total){
		HashMap<Integer, Integer> minCache = new HashMap<Integer,Integer>();
		minCache.put(0,0);
		for ( int m = 1; m <= total; m++){
			// Given the items in the set d.
			int w = Integer.MAX_VALUE;
			for ( int i=0; i < d.length; i++){				
				if ( m >= d[i] ){ // Cannot divide (or change) evenly by i-th denomination
					int tW = minCache.get(m - d[i]) + 1;
					if ( tW < w ){
						w = tW;
					}
				}
			}
			minCache.put(m, w);
		}
		return minCache.get(total);
	}
	
	public static int numSubSetsSum(int[] d, int total){
		// Columns represents running total & rows represents
		// each elements from the set so far.
		int[][] dpSolMatrix = new int[d.length+1][total+1];
		
		// There is only one way to sum up to a zero total
		// by doing exactly nothing.
		for ( int i=0; i <= d.length; i++ ){
			dpSolMatrix[i][0] = 1;
		}
		
		// There is no way to sum up to zero if there is 
		// no elements to sum up from.
		for ( int i=0; i < total+1; i++){
			dpSolMatrix[0][i] = 0;
		}
		
		for ( int i=1; i <= d.length; i++ ){
			for ( int N=1; N <= total; N++ ){
				if ( d[i-1] <= N ){
					dpSolMatrix[i][N] = dpSolMatrix[i-1][N] + dpSolMatrix[i][N - d[i-1]];
				}
				else {
					// Current element is too large to sum up to N
					// So, number of ways is still the same as
					// those summed up from previous element(s) 
					dpSolMatrix[i][N] = dpSolMatrix[i-1][N];
				}
			}
		}
		return dpSolMatrix[d.length][total];
	}
	
	public static boolean isSubSetSum(int[] e, int sum){
		boolean[][] dpSolMatrix = new boolean[e.length+1][sum+1];
		
		// If sum is zero, then there is 1 way. Return empty set.
		for ( int i=0; i < e.length; i++){
			dpSolMatrix[i][0] = true;
		}
		
		// If there are no elements, then there is just no way.
		for ( int i=1; i <= sum; i++){
			dpSolMatrix[0][i] = false;
		}
		
		for ( int i=1; i <= e.length; i++){
			for ( int S=1; S <= sum; S++){
				
				// First copy the value from row above.
				dpSolMatrix[i][S] = dpSolMatrix[i-1][S];
				
				// If no elements before can sum up to S and S must be 
				// greater than or equal to current element.
				if ( dpSolMatrix[i][S] == false && S >= e[i-1]){
					dpSolMatrix[i][S] = dpSolMatrix[i][S] || dpSolMatrix[i-1][S-e[i-1]];
				}
			}
		}
		return dpSolMatrix[e.length][sum];
		
	}
	
	public static void main(String args[]) {
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		int setSize = 3;
		for (int i=1; i <= setSize; i++){
			set.add(i);
		}
		List<List<Integer>> powerSet = SetAlgorithms.findAllSubsets(set, 0);
		System.out.println(powerSet);
		
	}

}
