
package Products;


public abstract class Electronics extends Item {
	String type; // Audio or Video
	
	public String toString()
	{
		return super.toString() + ", Type: " + type;
	}
}
