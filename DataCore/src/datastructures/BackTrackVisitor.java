/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vaygr
 *
 */
public abstract class BackTrackVisitor extends Visitor {
	 

	/**
	 * 
	 */
	public BackTrackVisitor() {
		// TODO: Nothing to do here.
	}

	/* (non-Javadoc)
	 * @see datastructures.Visitor#implementOperate(java.lang.Object)
	 */
	@Override
	protected void implementOperate(Object v) {
		// TODO Auto-generated method stub

	}
	
	public boolean finished(){
		// TODO: Implement exit early;
		return false;
	}
	 
	public void processSolution(List<Object> curSet, int curIdx){
		implementProcess(curSet, curIdx);
	}
	
	public boolean isSolution(List<Object> curSet, int curIdx){
		return implementIsSolution(curSet, curIdx);
	}
	
	public List<Object> getNextCandidates(List<Object> curSet, int curIdx){
		return implementGetNextCandidates(curSet, curIdx);
	}
	
	public void makeMove(List<Object> curSet, int curIdx){
		implementMakeMove(curSet, curIdx);
	}
	
	public void undoMove(List<Object> curSet, int curIdx){
		implementMakeMove(curSet, curIdx);
	}
	
	protected abstract boolean implementIsSolution(List<Object> curSet, int curIdx);
	protected abstract List<Object> implementGetNextCandidates(List<Object> curSet, int curIdx);
	protected abstract void implementMakeMove(List<Object> curSet, int curIdx);
	protected abstract void implementUndoMove(List<Object> curSet, int curIdx);
	protected abstract void implementProcess(List<Object> curSet, int curIdx);
}
