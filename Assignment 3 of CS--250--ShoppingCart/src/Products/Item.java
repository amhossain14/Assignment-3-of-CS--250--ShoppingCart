/*
 * Amir Hossain
 * CS 250 
 * Assignment 3
 */
package Products;

import java.io.Serializable;
import java.util.Date;

public abstract class Item implements Serializable {

	String Item_name, Item_code;
	double price;
	int inventory;
	
	public String toString()
	{
		return "Name: " + Item_name + ", Code: " + Item_code + ", Price: " + price + ", Inventory: " + inventory;
	}
	
	public String getName()
	{
		return Item_name;
	}
	public String getCode()
	{
		return Item_code;
	}
	public double getPrice()
	{
		return price;
	}
	public int getInventory()
	{
		return inventory;
	}
	
	public void setInventory(int i) // sets the inventory to the new value
	{
		inventory = i;
		
	}
	
}
