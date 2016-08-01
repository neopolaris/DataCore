/**
 * 
 */
package datastructures;

import java.util.List;

/**
 * @author Vaygr
 *
 */
public abstract class Graph {
	protected int edgeCount;
	protected int vertexCount;
	
	public Graph(){
		edgeCount = 0;
		vertexCount = 0;
	}
	
	public boolean addVertex(GraphVertex v){
		if ( implementAddVertex(v) ){
			vertexCount++;
			return true;
		}
		return false;
	}
	
	public boolean addEdge(GraphEdge e){
		if ( implementAddEdge(e)){
			edgeCount++;
			return true;
		}
		return false;
	}
	
	public List<GraphVertex> getNextNeighbors(GraphVertex v){
		return implementGetNextNeighbors(v);
	}
	
	public GraphVertex getGraphVertex(String name){
		return implementGetGraphVertex(name);
	}
	
	public List<String> toStringList(){
		return implementToStringList();
	}
	
	public void traverseDFS(GraphVertex gV, VertexOperator vOp){
		implementDoDFS(gV, vOp);
	}
	
	public void traverseBFS(GraphVertex gV, VertexOperator vOp){
		implementDoBFS(gV, vOp);
	}
	
	protected abstract void implementDoDFS(GraphVertex gV, VertexOperator v);
	protected abstract void implementDoBFS(GraphVertex gV, VertexOperator v);
	protected abstract boolean implementAddVertex(GraphVertex v);
	protected abstract boolean implementAddEdge(GraphEdge e);
	protected abstract List<GraphVertex> implementGetNextNeighbors(GraphVertex v);
	protected abstract List<String> implementToStringList();
	protected abstract GraphVertex implementGetGraphVertex(String name);

}
