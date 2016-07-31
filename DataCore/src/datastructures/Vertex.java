/**
 * 
 */
package datastructures;

/**
 * @author Vaygr
 * An abstract base class for all vertex objects
 */
public abstract class Vertex  implements Comparable<Vertex> {
	
	// At the minimum, a vertex should have a name
	protected String vertexName = "";
	
	/**
	 * Default Constructor.
	 */
	public Vertex(){
		this("");
	}
	
	/**
	 * Overloaded constructor.
	 * @param name
	 */
	public Vertex(String name){
		vertexName = name;
	}
	
	/**
	 * Set the vertex name
	 * @param str - Name of the vertex to be set.
	 */
	public void setVertexName(String str){
		vertexName = str;
	}
	
	/**
	 * Get the name of the vertex
	 * @return - Vertex Name
	 */
	public String getVertexName(){
		return vertexName;
	}
	
	/**
	 * Override for equality operation of two vertices.
	 */
	public boolean equals(Object v){
		if ( v instanceof Vertex ){
			Vertex rhs = (Vertex)v;
			return vertexName.equals(rhs.vertexName);
		}
		return false;
	}
	
	/**
	 * Generate hash code for this vertex.
	 */
	public int hashCode(){
		return vertexName.hashCode();
	}
	
	public int compareTo(Vertex v1){
		return (this.vertexName.compareTo(v1.getVertexName()));
	}
	
	public String toString(){
		return getVertexName();
	}
}
