/*
 * Amir Hossain
 *   
 *     
 */


package MVC;

import java.io.IOException;

import Products.Fruit;
import Products.Pharmacy;
import Products.Shoes;
import Products.TVS;


public class Driver 
{

	
	public static void main(String[] args)  throws IOException, ClassNotFoundException, Exception 
	{
		
		GUI mywindow = new GUI();	
		Controller mylistener = new Controller();
		InventoryManager inventory = new InventoryManager(); 


		mylistener.setInventory(inventory);

		inventory.setController(mylistener);

		mywindow.setListener(mylistener);
		
		mylistener.setScreen(mywindow);

	}

}
