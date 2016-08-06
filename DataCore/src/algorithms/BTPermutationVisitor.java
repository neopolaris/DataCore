/**
 * 
 */
package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import datastructures.BackTrackVisitor;

/**
 * @author aminn
 *
 */
public class BTPermutationVisitor extends BackTrackVisitor {

	private List<List<Object>> solution = null;
	private int solutionSize = 0;
	private List<Object> inputSet = null;
	
	/**
	 * 
	 */
	public BTPermutationVisitor(List<Object> input, int size) {
		solution = new ArrayList<List<Object>>();
		inputSet = input;
		solutionSize = size; //Note: inputSet size = size
	}

	/* (non-Javadoc)
	 * @see datastructures.BackTrackVisitor#implementIsSolution(java.util.List, int)
	 */
	@Override
	protected boolean implementIsSolution(List<Object> curSet, int curIdx) {
		if ( curIdx == solutionSize ){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see datastructures.BackTrackVisitor#implementGetNextCandidates(java.util.List, int)
	 */
	@Override
	protected List<Object> implementGetNextCandidates(List<Object> curSet, int curIdx) {
		// I have to return the actual candidates not just true or false.
		// Everything in curSet before curIdx is already in permutation.
		// Those from the input  that has not already appear in the curSet.
		List<Object> candidates = new ArrayList<Object>();
		if ( curIdx == 1 ){
			// First time so all starting values are candidates.
			candidates.addAll(inputSet);
		}
		else {
			HashSet<Object> solSofar = new HashSet<Object>();
			for ( int j=1; j < curIdx; j++){ 
				solSofar.add(curSet.get(j));
			}
			
			for ( int i=0; i < inputSet.size(); i++ ){
				if ( !solSofar.contains(inputSet.get(i)) ){
					candidates.add(inputSet.get(i));
				}
			}
		}
		return candidates;
	}

	/* (non-Javadoc)
	 * @see datastructures.BackTrackVisitor#implementMakeMove(java.util.List, int)
	 */
	@Override
	protected void implementMakeMove(List<Object> curSet, int curIdx) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see datastructures.BackTrackVisitor#implementUndoMove(java.util.List, int)
	 */
	@Override
	protected void implementUndoMove(List<Object> curSet, int curIdx) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Object>> getSolution(){
		return solution;
	}

	/* (non-Javadoc)
	 * @see datastructures.BackTrackVisitor#implementProcess(java.util.List, int)
	 */
	@Override
	protected void implementProcess(List<Object> curSet, int curIdx) {
		List<Object> permSet = new ArrayList<Object>();
		for ( int i=1; i < curSet.size(); i++){
			permSet.add(curSet.get(i));
		}
		solution.add(permSet);
	}

}
