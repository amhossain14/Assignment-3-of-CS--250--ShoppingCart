
package Products;

import java.util.StringTokenizer;


public class Fruit extends Perishable {

	public Fruit(String s)
	{
		StringTokenizer stk = new StringTokenizer(s);
		
		stk.nextToken();
		
		this.Item_name = stk.nextToken();
		this.Item_code = stk.nextToken();
		this.price = Double.parseDouble(stk.nextToken());
		this.Expiration_Date = stk.nextToken();
		if (stk.nextToken().compareTo("false") == 0)
			this.flag = false;
		else
			this.flag = true;
		this.inventory = Integer.parseInt(stk.nextToken());
		
	}
	
	public String toString()
	{
		return super.toString();
	}
	
}
