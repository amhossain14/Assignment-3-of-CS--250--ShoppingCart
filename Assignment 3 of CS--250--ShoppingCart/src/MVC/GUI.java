/*
 * Amir Hossain
 *  
 *     
 */
package MVC;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import Products.Item;


public class GUI extends JFrame {

	//3 Panels
	JPanel p1,p2,p3;
	//Buttons
	JButton buy;  
	JButton purchase; 
	JButton Complete; 
	JButton Exit; 
	
	JRadioButton showall;
	JRadioButton fruits;
	 JRadioButton shoes;
	 JRadioButton TVs;
	 JRadioButton pharmacy;
	 

	// TextArea
	JTextArea itemdesc;
	JTextArea Cart;
	JTextArea Total; 

	//ScrollPane
	JScrollPane scCart; 
	JScrollPane scrollPaneDescription; 
	JScrollPane scrollPaneItems;

	//Labels
	JLabel output1;
	JLabel output2;
	JLabel labelheader;


	Controller listener; 

	Item[] Items;
	String[] listItems;

	JList ListofItems;
	Container canvas;


	///////////////////////////////

	private void groupButton( ) {

		 ButtonGroup buttonGroup = new ButtonGroup( );
		 buttonGroup.add(showall);
		 buttonGroup.add(pharmacy);
		 buttonGroup.add(fruits);
		 buttonGroup.add(shoes);
		 buttonGroup.add(TVs);

		 }

	public GUI()
	{

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		///////////////////////////////////////////////

		buy = new JButton();
		purchase = new JButton();
		Exit = new JButton();
		Complete = new JButton();
/////////////////////////////////////////////////////////////////////extra
	
		fruits = new JRadioButton("Fruits");
	    shoes = new JRadioButton("Shoes");
	    TVs = new JRadioButton("TVs");
	    pharmacy = new JRadioButton("Pharmacy");
	    showall = new JRadioButton("All");
	    showall.setSelected(true);


		 


		
		
		// Building Frame
		
		setLocation(100,100);
		setSize(1080, 320);//this stands for the object that is being worked on
		setTitle("Assignment #3..........Shopping Cart");
		setResizable(false);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		canvas = getContentPane(); 
		canvas.setLayout(new FlowLayout());
		//  dimension
		Dimension panel1 = new Dimension(250,280);
		Dimension panel2 = new Dimension(300,280);
		Dimension panel3 = new Dimension(480,280);
		Dimension d = new Dimension(30,50);
//		Dimension ditems = new Dimension(380, 200);
		Dimension outdim = new Dimension(250, 200);
		

		//adding panels

		canvas.add(p1);
		canvas.add(p2);
		canvas.add(p3);

// to check that all the panel showed up
		p1.setBackground(Color.BLUE);
		p2.setBackground(Color.GRAY);
		p3.setBackground(Color.getHSBColor(0x40, 0x40, 0xFF));

		p1.setPreferredSize(panel1);
		p2.setPreferredSize(panel2);
		p3.setPreferredSize(panel3);
		// 

		output1 = new JLabel("Selected item");
		itemdesc = new JTextArea();
		itemdesc.setEditable(false);
		itemdesc.setLineWrap(true);
		itemdesc.setWrapStyleWord(true);
		scrollPaneDescription = new JScrollPane(itemdesc);
		scrollPaneDescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneDescription.setPreferredSize(outdim);

		output2 = new JLabel("Cart");
		labelheader = new JLabel("Please select an item");

		Cart = new JTextArea();
		Cart.setEditable(false);
		Cart.setLineWrap(true);
		Cart.setWrapStyleWord(true);
		scCart = new JScrollPane(Cart);
		scCart.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scCart.setPreferredSize(outdim);

		Total = new JTextArea();
		Total.setEditable(false);
		Total.setLineWrap(true);
		Total.setWrapStyleWord(true);
		Total.setPreferredSize(new Dimension(450,20));
		Total.setBackground(Color.GREEN);
	
					
		p1.add(labelheader);
		
		p2.add(scrollPaneDescription);
		p2.add(purchase); 

		p3.add(output1);
		p3.add(scCart); 
		p3.add(Total);
		p3.add(buy);
		p3.add(Complete);
		p3.add(Exit);

		
		buy.setSize(d);
		buy.setText(" BUY ");
		purchase.setSize(d);
		purchase.setText(" Purchase ");		
		
		Complete.setText(" Complete ");
		Exit.setSize(d);
		Exit.setText(" Exit ");		

		System.out.println("\n : GUI working perfectly"); 
	}


	public void setListener(Controller c)
	{
		listener = c;
		buy.addActionListener(listener);
		purchase.addActionListener(listener);
		Complete.addActionListener(c);
		Exit.addActionListener(listener);


		//////////////////////////////////////////////////////////////



		System.out.println("\n : Importing all names to JList"); 
		for (int i=0; i<listener.getnumberofItems(); i++) {	
			System.out.println(listener.getItemsfromController()[i].getName()); 
//			JOptionPane.showMessageDialog(null,listener.getItemsfromController()[i].getName());
		}

		listItems = new String[listener.getnumberofItems()]; 
		for (int i=0; i<listener.getnumberofItems(); i++) {	
			listItems[i]= listener.getItemsfromController()[i].getName(); 
		}

		ListofItems = new JList<String>(listItems);
		System.out.println("\n : Import completed");
		for(String item : listItems) {
			System.out.println(item);
		}

		Dimension ditems = new Dimension(200, 200);
		ListofItems.setPreferredSize (ditems);
		ListofItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListofItems.setVisibleRowCount(9);
		scrollPaneItems = new JScrollPane(ListofItems);
		p1.add(scrollPaneItems); 
		ListofItems.addListSelectionListener(listener);

		setVisible(true);



	}



}
