
package Products;

import java.util.StringTokenizer;


public class Pharmacy extends Pharmaceutical {

	public boolean medicine = false; // true = medicine, false = non-medicine
	public Pharmacy(String s)
	{
		StringTokenizer stk = new StringTokenizer(s);
		
		stk.nextToken();
		
		this.Item_name = stk.nextToken();
		this.Item_code = stk.nextToken();
		this.price = Double.parseDouble(stk.nextToken());
		this.type = stk.nextToken();
		if (stk.nextToken().compareTo("false") == 0)
			medicine = false;
		else
			medicine = true;
		this.inventory = Integer.parseInt(stk.nextToken());
		
	}
	
	public String toString()
	{
			return super.toString() + ", Medicine: " + medicine;
	}
}
