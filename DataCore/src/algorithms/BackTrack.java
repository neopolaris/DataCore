/**
 * 
 */
package algorithms;

import java.util.ArrayList;
import java.util.List;

import datastructures.BackTrackVisitor;
import datastructures.Visitor;

/**
 * @author Vaygr
 *
 */
public class BackTrack {

	/**
	 * 
	 */
	public BackTrack() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static List<Object> execute(List<Object> curSet, int k, BackTrackVisitor v){
		if ( v.isSolution(curSet, k)){
			v.processSolution(curSet, k);
		}
		else {			
			k++;
			List<Object> candidates = v.getNextCandidates( curSet, k );
			for ( Object candidate : candidates ){
				curSet.set(k, candidate);
				v.operate(candidate); // Make a move
				execute(curSet, k, v);// TODO: Need to check. Backtrack
				v.operate(candidate); // Undo a move
				if ( v.finished() ){
					return curSet;
				}
			}
			
		}
		return curSet;				   // Need to double check
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Object> a = new ArrayList<Object>();
		
		for ( int i=1; i <= 4; i++){
			a.add(0);					
		}
		System.out.println("Testing backtracking ...");
		System.out.println(a);
		
		BTCombinationVisitor v = new BTCombinationVisitor(3);
		BackTrack.execute(a, 0, v);
		List<List<Object>> solution = new ArrayList<List<Object>>();
		solution = v.getSolution();
		System.out.println(solution);
		
		List<Object> input = new ArrayList<Object>();
		for ( int i=1; i <= 3; i++){
			input.add(i);					
		}
		
		List<Object> permBuffer = new ArrayList<Object>();
		for ( int i=1; i <= 4; i++ ){
			permBuffer.add(0);
		}
		BTPermutationVisitor vP = new BTPermutationVisitor(input,3);
		BackTrack.execute(permBuffer, 0, vP);
		List<List<Object>> solution1 = vP.getSolution();
		System.out.println(solution1);
	}

}
