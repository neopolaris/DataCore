/**
 * 
 */
package algorithms;

import java.util.ArrayList;
import java.util.List;

import datastructures.BackTrackVisitor;

/**
 * @author aminn
 *
 */
public class BTCombinationVisitor extends BackTrackVisitor {
	private List<List<Object>> solution = null;
	private int solutionSize = 0;
	/**
	 * 
	 */
	public BTCombinationVisitor(int size) {
		solution = new ArrayList<List<Object>>();
		solutionSize = size;
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
		List<Object> candidates = new ArrayList<Object>();
		candidates.add(0);
		candidates.add(1);
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
		List<Object> subSet = new ArrayList<Object>();
		for ( int i=1; i <= solutionSize; i++){
			if ( (int)curSet.get(i) != 0 ){
				subSet.add(i);
			}
		}
		solution.add(subSet);

	}

}
