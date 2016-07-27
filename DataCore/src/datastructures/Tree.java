/**
 * 
 */
package datastructures;

/**
 * @author aminn
 *
 */
public abstract class Tree {
	private TreeVertex root = null;
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
	
	public void traverseDFS(){
		implementTraverseDFS();
	}
	
	public void traverseBFS(){
		implementTraverseBFS();
	}
	
	public TreeVertex findTreeVertex(String name){
		return implementFindTreeVertex(name);
	}
	
	protected abstract void implementTraverseBFS();
	protected abstract void implementTraverseDFS();
	protected abstract TreeVertex implementFindTreeVertex(String name);
	
	
}
