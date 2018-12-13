
package Products;


public abstract class Clothing extends Item {

	String type; // footwear, dress, accessories or jewellery
	
	public String toString()
	{
		return super.toString() + ", Type: " + type;
	}
}
