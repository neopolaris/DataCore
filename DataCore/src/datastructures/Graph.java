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
	
	public boolean addVertex(Vertex v){
		if ( implementAddVertex(v) ){
			vertexCount++;
			return true;
		}
		return false;
	}
	
	public boolean addEdge(Edge e){
		if ( implementAddEdge(e)){
			edgeCount++;
			return true;
		}
		return false;
	}
	
	public List<String> toStringList(){
		return implementToStringList();
	}
	
	public void doDFS(Visitor v){
		implementDoDFS(v);
	}
	
	public void doBFS(Visitor v){
		implementDoBFS(v);
	}
	
	protected abstract void implementDoDFS(Visitor v);
	protected abstract void implementDoBFS(Visitor v);
	protected abstract boolean implementAddVertex(Vertex v);
	protected abstract boolean implementAddEdge(Edge e);
	protected abstract List<Vertex> implementGetNextNeighbors(Vertex v);
	protected abstract List<String> implementToStringList();

}
