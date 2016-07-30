/**
 * 
 */
package datastructures;

import java.util.List;

/**
 * @author aminn
 *
 */
public abstract class Tree {
	protected TreeVertex root = null;
	private String name = "";

	/**
	 * 
	 */
	public Tree() {
		this(null, "");
	}
	
	public Tree(TreeVertex r){
		this ( r, "");
	}
	
	public Tree(TreeVertex r, String n){
		root = r;
		name = n;
	}
	
	public void setRoot(TreeVertex r){
		root = r;
	}
	
	public TreeVertex getRoot(){
		return root;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public String getName(String n){
		return name;
	}
	
	public void traverseDFS(VertexOperator v){
		implementTraverseDFS(v);
	}
	
	public void traverseBFS(VertexOperator v){
		implementTraverseBFS(v);
	}
	
	public TreeVertex findTreeVertex(String name){
		return implementFindTreeVertex(name);
	}
	
	public List<String> toStringList(){
		return implementToStringList();
	}
	
	public String toString(){
		return implementToStringList().toString();
	}
	
	protected abstract void implementTraverseBFS(VertexOperator v);
	protected abstract void implementTraverseDFS(VertexOperator v);
	protected abstract TreeVertex implementFindTreeVertex(String name);
	protected abstract List<String> implementToStringList();
}
