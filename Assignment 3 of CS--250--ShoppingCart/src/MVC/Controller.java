/*
 * Amir Hossain
 *   
 *     
 */
package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Products.Item;

public class Controller implements ActionListener, ListSelectionListener {

	GUI myscreen;

	InventoryManager IM;

	int numberofitems;

	Controller listener;

	String selected;
	int Totalitems = 0;
	double Totalprice = 0;

	double PriceOfitemSelected;
	String[] itemadded = new String[100];
	int IndexOfItem;
	int[] quantity = new int[25];

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		AbstractButton buttonclicked = (AbstractButton) arg0.getSource();

		if (buttonclicked.getText().equals(" BUY ")) {
			System.out.println("You clicked on Purchase");
			JOptionPane.showMessageDialog(null,
					"Thanks for shopping with us. Your total cost is $"
							+ Totalprice
							+ ". Please make arrangements for payment");
		}

		else if (buttonclicked.getText().equals(" Purchase ")) {

			if (selected != null) {
				Totalitems++;

				int input = Integer.parseInt(JOptionPane.showInputDialog(null,
						"How many " + selected + " you want "));

				if (input <= IM.getItemsfromInventory()[IndexOfItem]
						.getInventory()) {

					for (int i = 0; i < input; i++) {

						Totalprice += PriceOfitemSelected;
						IM.getItemsfromInventory()[IndexOfItem].setInventory(IM
								.getItemsfromInventory()[IndexOfItem]
								.getInventory() - 1);

					}

					quantity[IndexOfItem] += input;

					System.out.println("You added " + selected);

					myscreen.Cart.append(selected + "     price: $"
							+ PriceOfitemSelected + "     quantity "
							+ quantity[IndexOfItem]);
					myscreen.Cart.append("\n");

					myscreen.Total
							.setText("                                           You selected  "
									+ Totalitems
									+ " items       -      Total $"
									+ String.format("%.2f", Totalprice));
				}

				else {
					JOptionPane.showMessageDialog(
							null,
							"  		        Sorry!! \n We Only Have "
									+ IM.getItemsfromInventory()[IndexOfItem]
											.getInventory() + " " + selected);
				}

			}
		} else if (buttonclicked.getText().equals(" Complete ")) {

			JOptionPane
					.showMessageDialog(null,
							"These will be delivered to you. Thanks Again. Have a Nice Day.");
			try {
				IM.updateinventory();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (buttonclicked.getText().equals(" Exit ")) {

			System.out.println("You clicked on Exit");

			System.exit(0);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {

		JList list = (JList) arg0.getSource(); // get Object Selected

		selected = (String) list.getSelectedValue();

		for (int i = 0; i < IM.getNumberOfItem(); i++) {
			if (IM.getItemsfromInventory()[i].getName().equals(selected)) {
				IndexOfItem = i;
				PriceOfitemSelected = IM.getItemsfromInventory()[i].getPrice();
				myscreen.itemdesc.setText("You selected "
						+ IM.getItemsfromInventory()[i].toString());
			
			}
		}

	}

	public Item getItemsAddedtoCart() {

		return IM.getItemsfromInventory()[IndexOfItem];

	}

	public Item[] getItemsfromController() {

		return IM.getItemsfromInventory();
	}

	public int getnumberofItems() {
		return IM.getNumberOfItem();
	}

	public void setScreen(GUI mywindow) {
		myscreen = mywindow;
	}

	public void setInventory(InventoryManager im) {
		IM = im;
	}

}
