
package Products;


public abstract class Pharmaceutical extends Item {

	String type; // "OTC" or "Prescription"
	
	public String toString()
	{
		return super.toString() + ", Type: " + type;
	}
}
