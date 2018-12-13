package Products;

public abstract class Food extends Item {

	String Expiration_Date;
	
	public String toString()
	{
		return super.toString() + ", Expiration: " + Expiration_Date;
	}
}
