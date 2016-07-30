/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Vaygr
 * This visitor returns all nodes in the same level.
 */
public class TVLevelOp extends VertexOperator {
	private HashMap<Integer, List<TreeVertex>> levels = null;
	private HashMap<TreeVertex, Integer> vertexLevel = null;

	/**
	 * Default constructor.
	 */
	public TVLevelOp() {
		levels = new HashMap<Integer, List<TreeVertex>>();
		vertexLevel = new HashMap<TreeVertex, Integer>();
	}

	@Override
	protected void implementOperate(Object v) {
		// This method would just need one hash table to map each vertex to
		// its corresponding level which can be used to construct level by
		// level presentation.
		if ( v instanceof TreeVertex ){
			TreeVertex vertex = (TreeVertex)v;
			
			// Add the root if it's the first one.
			if ( levels.isEmpty() ){
				List<TreeVertex> rootLevel = new ArrayList<TreeVertex>(); 
				rootLevel.add(vertex);
				levels.put(levels.size(), rootLevel);
				vertexLevel.put(vertex, levels.size());
				setVertexLevels(0,rootLevel);
			}

			// Then process all descendants.
			List<TreeVertex> descendants = vertex.getNextNeighbors();
			if ( descendants != null ){
				int pLevel = vertexLevel.get(vertex);
				List<TreeVertex> curLevel = levels.get(pLevel+1);
				if ( curLevel != null ) {
					curLevel.addAll(descendants);
				}
				else {
					levels.put(pLevel+1, descendants);
				}
				setVertexLevels(pLevel+1, descendants);
			}
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	private void setVertexLevels(int i, List<TreeVertex> descedants) {
		// TODO Auto-generated method stub
		for ( TreeVertex v : descedants ){
			vertexLevel.put(v, i);
		}
	}

	public List<List<TreeVertex>> getTreeLevels(){
		ArrayList<List<TreeVertex>> retList = new ArrayList<List<TreeVertex>>();
		for( int i=0; i < levels.size(); i++ ){
			List<TreeVertex> curLevel = levels.get(i);
			retList.add(curLevel);
		}
		return retList;
	}
}
