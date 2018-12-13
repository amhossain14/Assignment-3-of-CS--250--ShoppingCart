
package Products;

import java.util.StringTokenizer;


public class Shoes extends Clothing {

	double ShoeSize;
	public Shoes(String s)
	{
		StringTokenizer stk = new StringTokenizer(s);
		
		stk.nextToken();
		
		this.Item_name = stk.nextToken();
		this.Item_code = stk.nextToken();
		this.price = Double.parseDouble(stk.nextToken());
		this.type = stk.nextToken();
		this.ShoeSize = Double.parseDouble(stk.nextToken());
		this.inventory = Integer.parseInt(stk.nextToken());
		
	}
	
	public String toString()
	{
		return super.toString() + ", Size: " + ShoeSize;
	}
	
}
