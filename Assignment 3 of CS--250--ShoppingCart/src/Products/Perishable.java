
package Products;


public abstract class Perishable extends Food {

	boolean flag; // true = frozen, false otherwise
	
	public String toString()
	{
		return super.toString() + ", Perishable: " + flag;
	}
	
}
