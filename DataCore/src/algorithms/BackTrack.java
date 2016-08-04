/**
 * 
 */
package algorithms;

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
	
	public static List<Object> execute(List<Object> curSet, BackTrackVisitor v){
		if ( isSolution( curSet)){
			// Send visitor to process current set.
		}
		else {
			List<Object> candidates = getNextCandidates( curSet );
			for ( Object candidate : candidates ){
				v.operate(candidate); // Make a move
				execute(curSet, v);	  // TODO: Need to check. Backtrack
				v.operate(candidate); // Undo a move
				if ( v.finished() ){
					return curSet;
				}
			}
		}
		return curSet;				   // Need to double check
	}

	private static boolean isSolution(List<Object> curSet){
		// TODO: Implement
		return false;
	}
	
	private static List<Object> getNextCandidates(List<Object> curSet){
		// TODO: Implement
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
