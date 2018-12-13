/*
 * Amir Hossain
 *   
 *     
 */

package MVC;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;



import javax.swing.JOptionPane;

import Apps.ProductDbaseCreate;
import Products.Fruit;
import Products.Item;
import Products.Pharmacy;
import Products.Shoes;
import Products.TVS;

public class InventoryManager {	
	protected 	Item[] data = new Item[25];
	private int numberofitems = 0; 
	Controller listener; 
	String[] listItems;


	public InventoryManager() throws IOException, ClassNotFoundException 
	{
		File Ininvfile = new File ("Storage.dat"); // calling out the file Storage.dat
		FileInputStream inFileStremer = new FileInputStream (Ininvfile);// streaming the file Storage.dat
		ObjectInputStream inobject = new   ObjectInputStream (inFileStremer);

		int i=0;
		try {
			for (i = 0; i < 25; i++) {
				data[i] = (Item) inobject.readObject();
				numberofitems++;
//				JOptionPane.showMessageDialog(null, "" + data[i]);
			} 
		} catch (EOFException e) {}
		
		inobject.close();
	}
	

	public Item[] getItemsfromInventory()
	{
		return data;
	}
	
	public int getNumberOfItem(){
		return numberofitems; 
	}
	
	public void setController(Controller c)
	{
		listener = c;
	}
	
public void updateinventory() throws FileNotFoundException, IOException{
		
	ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream ("Storage.dat")) ;
	for (int i=0; i<numberofitems; i++) {
		
		out.writeObject(data[i]);
//			JOptionPane.showMessageDialog(null, data[i]);
		}
}	


}