package algorithms;

import java.util.ArrayList;
import java.util.BitSet;
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
