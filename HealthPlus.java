import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import Form.EventClickHandel;

class Clock implements Runnable
{   
   JLabel lblclock;
    Clock()
    {
    	lblclock=new JLabel("Clock");
    }
	public void run()
	{
		while(true)
		{  // JOptionPane.showMessageDialog(null, "Yes")
			lblclock.setText( new java.util.Date().toString()  );
			try
	        { 	
	        	Thread.sleep(1000);
	        }
	        catch(Exception e)
	        {
	        	
	        }
		}
	}  
}  
class HealthPlusWork extends Clock
{
	JFrame jframe;
	JPanel plogin,pall,ploginusername,ploginpass,pbutton,pchoices,pbnoaddmedi,
	       pheading,paddmedicine,pbtnaddmedicine,pheadaddmedi,
	       pnameaddmedi,pqtyaddmedi,ppriceaddmedi,pmfdaddmedi,pefdaddmedi,paddcust
	       ,pnameaddcust,pmobnoaddcust,paddrsaddcust,pbtnaddcust,pcustidaddcust,
	       psearchmedi,psearchbasis,psearchtable,psearchmedicomponents,pbtnsearchmedi
	       ,premovemedi,pbnoremovemedi,pnameremovemedi,pqtyremovemedi,pmfdremovemedi,
	       pefdremovemedi,ppriceremovemedi,pbtnremovemedi,psearchremovecust
	       ,pcustidsearchcust,pnamesearchcust,pmobnosearchcust,paddrssearchcust,
	       pbtnsearchcust,pplaceorder,pnameplaceorder,pmobplaceorder,pmedinameplaceorder,
	       pqtyplaceorder,pbtnplaceorder,ptableplaceordr;
	JLabel lblusername,lblpass,lblloginhead,lblheading,lbladdmedicinehead,lblbnoaddmedi,lblnameaddmedicine,
	       lblpriceaddmedicine,lblqtyaddmedicine,lblmfdaddmedicine,lblexpdaddmedicine,
	       lblnameaddcust,lblmobnoaddcust,lbladdrsaddcust,lblheadaddcust,lblcustidaddcust
	       ,lblerrornameaddcust,lblerrornameaddmedi,lblerrorbnoaddmedi,lblbasissearchmedi
	       ,lblheadsearchmedi,lblnamesearchmedi,lblbnosearchmedi,lblheadremovemedi,lblbnoremovemedi
	       ,lblnameremovemedi,lblpriceremovemedi,lblqtyremovemedi,lblmfdremovemedi,
	       lblexpdremovemedi,lblerrorremovemedi,lblerrorqtyremovemedi,lblerrorpriceremovemedi
	       ,lblerrormfdremovemedi,lblerrorexpremovemedi,lblerrormobnoaddcust,
	       lblerroraddrsaddcust,lblheadsearchcust,lblcustidsearchcust,lblnamesearchcust,
	       lbladdrssearchcust,lblmobnosearchcust,lblerrorqtyaddmedi,lblerrormfdaddmedi
	       ,lblerrorexpaddmedi,lblerrormrpaddmedi,lblheadplaceorder,lblnameplaceorder,
	       lblmobplaceorder,lblmedinameplaceorder,lblqtyplaceorder;
	JTextField txtusername,txtbnoaddmedi,txtnameaddmedi,txtpriceaddmedi,txtqtyaddmedi
			   ,txtnameaddcust,txtmobnoaddcust,txtcustidaddcust,txtnamesearchmedi,
			   txtbnosearchmedi,txtbnoremovemedi,txtnameremovemedi,txtpriceremovemedi
			   ,txtqtyremovemedi,txtcustidsearchcust,txtnamesearchcust,txtmobnosearchcust
			   ,txtnameplaceorder,txtmobplaceorder,txtmedinameplaceorder,txtqtyplaceorder;
	JPasswordField txtpass;
	JButton btnlogin,btnclearlogin,btnexitlogin,btnaddmedicine,btnaddcustomer,btnbackchoice,
	        btnexitchoice,btnexitaddmedicine,btnbackaddmedicine,btninsertmedi,btninsertaddcust
	        ,btnbackaddcust,btnexitaddcust,btnclearaddcust,btnclearaddmedi,btnsearchmedi
	        ,btnexitsearchmedi,btnbacksearchmedi,btnsearchsearchmedi,btnremovemedi
	        ,btnexitremovemedi,btnbackremovemedi,btnclearremovemedi,
	        btnremovemedimedi,btnupdatemedimedi,btnupdatemedi,btnsearchsearchcust,
	        btnremovesearchcust,btnclearsearchcust,btnbacksearchcust,btnexitsearchcust,
	        btnremovecust,btnupdatecust,btnsearchcust,btnupdatecustworking,btnplaceorder
	        ,btnclearplaceorder,btnaddplaceorder,btnexitplaceorder,btnbackplaceorder,btnprintplaceorder;
	JComboBox comboexpmonth,comboexpyear,combomfdmonth,combomfdyear
			  ,combexpmnthremovemedi,combexpyrremovemedi,combmfdmnthremovemedi,combmfdyrremovemedi;
	JTextArea txtaddrsaddcust,txtaddrssearchcust;
	JRadioButton radbno,radname;
	ButtonGroup bgsearchchoice;
	JCheckBox chknameupdatemedi,chkqtyupdatemedi,chkpriceupdatemedi,chkexpdupdatemedi,chkmfdupdatemedi;
	JTable tabelsearchmedi,tableplaceorder;            
	DefaultTableModel model,modelplaceorder;
	GridBagLayout gbl=new GridBagLayout();
    GridBagConstraints gbc=new GridBagConstraints();
    CardLayout cardLayout=new CardLayout();
    
	String[] mnthexp=new String[13];
	String[] yrexp=new String[49];
	String[] mnthexpremovemedi=new String[13];
	String[] yrexpremovemedi=new String[49];
	
	String[] mnthmfd=new String[13];  
	String[] yrmfd=new String[49];
	String[] mnthmfdremovemedi=new String[13];
	String[] yrmfdremovemedi=new String[49];
    // Code of login panel
	class EventHandlelogin implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{   try
		   {
			if(e.getSource()==btnlogin)
			{
				String username=txtusername.getText();
				String pass=new String(txtpass.getPassword());
				if(username.equals("admin"))
				{
					if(pass.equals("admin"))
					{
						cardLayout.show(pall,"choices");
					}
					else
					JOptionPane.showMessageDialog(null, "WrongInput");
				}
				else
				JOptionPane.showMessageDialog(null, "WrongInput");
			} // end of if of btnlogin
			
			else if(e.getSource()==btnclearlogin)
				clearLogin();
			else
			System.exit(0);
			
		   }
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "WrongInput");
		}
	  } // end of function	
		
	}// end of class
	

	HealthPlusWork()
	{  
		jframe=new JFrame("Health Plus");
		pall=new JPanel(cardLayout);
		plogin=new JPanel(gbl);
		ploginusername=new JPanel();
		ploginpass=new JPanel();
		pheading=new JPanel();
		pbutton=new JPanel();
		lblloginhead=new JLabel("       Login Portal");
		lblusername=new JLabel("Username ");
		lblpass=new JLabel("Password  ");
		lblheading=new JLabel(" HealthPlus");
		txtusername=new JTextField(6);
		txtpass=new JPasswordField(6);
		btnlogin=new JButton("Login");
		btnclearlogin=new JButton("Clear");
		btnexitlogin=new JButton(" Exit ");
		// login allocation finish  
		pchoices=new JPanel(gbl);
		btnplaceorder=new JButton("  Place Order       ");
		btnaddmedicine=new JButton("  Add Medicine    ");
		btnremovemedi=new JButton(" Remove Medicine");
		btnupdatemedi=new JButton(" Update Medicine ");
		btnsearchmedi=new JButton(" Search Medicine  ");
		btnaddcustomer=new JButton("  Add Customer    ");
		btnremovecust=new JButton("Remove Customer");
		btnupdatecust=new JButton("Update Customer ");
		btnsearchcust=new JButton("Search Customer  ");
		btnbackchoice=new JButton("        Back            ");
		btnexitchoice=new JButton("        Exit             ");
		choicesFrame();
		// choices allocation over
		paddmedicine=new JPanel(gbl);
		pheadaddmedi=new JPanel();
		pbnoaddmedi=new JPanel();
		pnameaddmedi=new JPanel();
		pqtyaddmedi=new JPanel(); 
		ppriceaddmedi=new JPanel();
		pmfdaddmedi=new JPanel();
		pefdaddmedi=new JPanel();
		lbladdmedicinehead=new JLabel("            Add Medicine");
		btnexitaddmedicine=new JButton(" Exit ");
		btnbackaddmedicine=new JButton(" Back ");
		btninsertmedi=new JButton(" Add ");
		btnclearaddmedi=new JButton(" Clear ");
		pbtnaddmedicine=new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblbnoaddmedi=new JLabel(" B.No.             ");
		lblnameaddmedicine=new JLabel(" Name             ");
		lblerrornameaddmedi=new JLabel("");
		lblerrorbnoaddmedi=new JLabel("");
		lblerrorqtyaddmedi=new JLabel("");
		lblerrormfdaddmedi=new JLabel("");
	    lblerrorexpaddmedi=new JLabel("");
	    lblerrormrpaddmedi=new JLabel("");
	    lblpriceaddmedicine=new JLabel(" MRP             ");
	    lblqtyaddmedicine=new JLabel(" Quantity        ");
	    lblmfdaddmedicine=new JLabel(" Mfd               ");
	    lblexpdaddmedicine=new JLabel(" Expiery Date  ");
	    txtbnoaddmedi=new JTextField(9);
	    txtnameaddmedi=new JTextField(9);
	    txtpriceaddmedi=new JTextField(9);
	    txtqtyaddmedi=new JTextField(9);
	    
		mnthexp[0]="mm";
		for(int i=1,j=1;i<=12;i++,j++)
		mnthexp[i]=j+"";
		comboexpmonth=new JComboBox(mnthexp);
		
		yrexp[0]="yyyy";
		for(int i=1,j=2000;i<=48;i++,j++)
		yrexp[i]=j+"";
		comboexpyear=new JComboBox(yrexp);
		
		mnthmfd[0]="mm";
		for(int i=1,j=1;i<=12;i++,j++)
		mnthmfd[i]=j+"";
		combomfdmonth=new JComboBox(mnthmfd);
		
		
		yrmfd[0]="yyyy";
		for(int i=1,j=2000;i<=48;i++,j++)
		yrmfd[i]=j+"";
		combomfdyear=new JComboBox(yrmfd);
		MedicineFrame();
		 
		// code of Add Medicine over
		
		paddcust=new JPanel(gbl);
		pnameaddcust=new JPanel();
		pmobnoaddcust=new JPanel();
		paddrsaddcust=new JPanel();
		pcustidaddcust=new JPanel();
		pbtnaddcust=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		lblheadaddcust=new JLabel("        Add Customer ");
		lblcustidaddcust=new JLabel("Cust_Id        ");
		lblnameaddcust=new JLabel("Name           ");
		lbladdrsaddcust=new JLabel("Address        ");
		lblmobnoaddcust=new JLabel("ContactNo    ");
		lblerrornameaddcust=new JLabel("");
		lblerrormobnoaddcust=new JLabel("");
		lblerroraddrsaddcust=new JLabel("");
		txtnameaddcust=new JTextField(8);
		txtmobnoaddcust=new JTextField(8);
		txtaddrsaddcust=new JTextArea(2,8);
		txtcustidaddcust=new JTextField(8);
		btninsertaddcust=new JButton("Insert");
		btnupdatecustworking=new JButton("Update");
		btnbackaddcust=new JButton("Back ");
		btnexitaddcust=new JButton(" Exit ");
		btnclearaddcust=new JButton("Clear");
		AddCust();
		
		// add customer over
		// search medicine start
		
		psearchmedi=new JPanel(gbl);
		psearchbasis=new JPanel();
		psearchmedicomponents=new JPanel();
		lblheadsearchmedi=new JLabel("                Search Medicine");
		lblbasissearchmedi=new JLabel("Select_Search_Basis    ");
		lblnamesearchmedi=new JLabel("  Name");
		lblbnosearchmedi=new JLabel("Bno");
		txtnamesearchmedi=new JTextField(8);
		txtbnosearchmedi=new JTextField(8);
		radbno=new JRadioButton("B.No");
		radname=new JRadioButton("Name");
		bgsearchchoice=new ButtonGroup();
		tabelsearchmedi=new JTable();
		model=new DefaultTableModel();
		psearchtable=new JPanel();
		pbtnsearchmedi=new JPanel();
		btnexitsearchmedi=new JButton("Exit");
		btnbacksearchmedi=new JButton("Back");
		btnsearchsearchmedi=new JButton("Search");
		callSearchMediFrame();
		// Search Medicine code over
		// Code of remove+update medicine start
		premovemedi=new JPanel(gbl);
		lblheadremovemedi=new JLabel(".");
		lblbnoremovemedi=new JLabel(" B.No.                 ");
	    lblnameremovemedi=new JLabel(" Name              ");
	    lblpriceremovemedi=new JLabel(" MRP              ");
	    lblqtyremovemedi=new JLabel(" Quantity         ");
	    lblmfdremovemedi=new JLabel(" Mfd                ");
	    lblexpdremovemedi=new JLabel(" Expiery Date   ");
	    lblerrorremovemedi=new JLabel("");
	    lblerrorqtyremovemedi=new JLabel("");
	    lblerrorpriceremovemedi=new JLabel("");
	    lblerrormfdremovemedi=new JLabel("");
	    lblerrorexpremovemedi=new JLabel("");
	    txtbnoremovemedi=new JTextField(9);
	    txtnameremovemedi=new JTextField(9);
	    txtpriceremovemedi=new JTextField(9);  
	    txtqtyremovemedi=new JTextField(9);
	    btnexitremovemedi=new JButton("Exit");
	    btnbackremovemedi=new JButton("Back");
	    btnclearremovemedi=new JButton("Clear");
        btnremovemedimedi=new JButton("Remove");
        btnupdatemedimedi=new JButton("Update");
	    pbnoremovemedi=new JPanel();
	    pnameremovemedi=new JPanel();
	    pqtyremovemedi=new JPanel();
	    pmfdremovemedi=new JPanel();
	    pefdremovemedi=new JPanel(); 
	    ppriceremovemedi=new JPanel();
	    pbtnremovemedi=new JPanel();
	    mnthexpremovemedi[0]="mm";
		for(int i=1,j=1;i<=12;i++,j++)
		mnthexpremovemedi[i]=j+"";
		combexpmnthremovemedi=new JComboBox(mnthexpremovemedi);
		
		yrexpremovemedi[0]="yyyy";
		for(int i=1,j=2000;i<=48;i++,j++)
		yrexpremovemedi[i]=j+"";
		combexpyrremovemedi=new JComboBox(yrexpremovemedi);
		
		mnthmfdremovemedi[0]="mm";
		for(int i=1,j=1;i<=12;i++,j++)
		mnthmfdremovemedi[i]=j+"";
		combmfdmnthremovemedi=new JComboBox(mnthmfdremovemedi);
		
		
		yrmfdremovemedi[0]="yyyy";
		for(int i=1,j=2000;i<=48;i++,j++)
			yrmfdremovemedi[i]=j+"";
		combmfdyrremovemedi=new JComboBox(yrmfdremovemedi);
		chknameupdatemedi=new JCheckBox(" ");
		chkqtyupdatemedi=new JCheckBox(" ");
		chkpriceupdatemedi=new JCheckBox(" ");
		chkexpdupdatemedi=new JCheckBox(" ");
		chkmfdupdatemedi=new JCheckBox(" ");
		callRemoveMedi();
		// remove and update medicine over
		psearchremovecust=new JPanel(gbl);
		lblheadsearchcust=new JLabel("..");
		pcustidsearchcust=new JPanel();
		pmobnosearchcust=new JPanel();
		paddrssearchcust=new JPanel();
		pbtnsearchcust=new JPanel();
		lblcustidsearchcust=new JLabel("Cust_Id        ");
		txtcustidsearchcust=new JTextField(8);
		lblnamesearchcust=new JLabel("Name *         ");
		lbladdrssearchcust=new JLabel("Address         ");
		lblmobnosearchcust=new JLabel("ContactNo *  ");
		btnsearchsearchcust=new JButton("Search");
		btnremovesearchcust=new JButton("Remove");
		btnclearsearchcust=new JButton("Clear");
		btnbacksearchcust=new JButton("Back");
		btnexitsearchcust=new JButton("Exit");
		txtnamesearchcust=new JTextField(8);
		txtmobnosearchcust=new JTextField(8);
		pnamesearchcust=new JPanel();
		txtaddrssearchcust=new JTextArea(2,8);
		SearchRemoveCust();
		//search medicine over
		
		// Place Order Code start
		
		pplaceorder=new JPanel(gbl);
		pnameplaceorder=new JPanel();
		pmobplaceorder=new JPanel();
		pmedinameplaceorder=new JPanel();
	    pqtyplaceorder=new JPanel();
	    pbtnplaceorder=new JPanel();
	    ptableplaceordr=new JPanel();
		lblheadplaceorder=new JLabel("                 Place Order");
		lblnameplaceorder=new JLabel("Customer_Name   ");
	    lblmobplaceorder=new JLabel("Contact_No           ");
	    lblmedinameplaceorder=new JLabel("Medicine_Name    ");
	    lblqtyplaceorder=new JLabel("Quantity                ");
	    txtnameplaceorder=new JTextField(8);
	    txtmobplaceorder=new JTextField(8);
	    txtmedinameplaceorder=new JTextField(8);
	    txtqtyplaceorder=new JTextField(8);
	    tableplaceorder=new JTable();
	    modelplaceorder=new DefaultTableModel();
	    btnclearplaceorder=new JButton("Clear");
	    btnaddplaceorder=new JButton("Add");
	    btnexitplaceorder=new JButton("Exit");
	    btnbackplaceorder=new JButton("Back");
	    btnprintplaceorder=new JButton("Print");
		callPlaceOrderFrame();
	   
	}
	
	public void putOnlogin(int x,int y,JComponent c)
	{   gbc.anchor=GridBagConstraints.NORTHWEST;
	    gbc.insets=new Insets(8,8,29,12);
		gbc.gridx=x;
		gbc.gridy=y;
		gbl.setConstraints(c,gbc);
	    plogin.add(c);
		
	}
	
	
	public void colorFontOperationLogin()
	{
		Font fo=new Font("Imprint MT Shadow",Font.BOLD,30);
		Color font=new Color(255,74,0);
		JComponent[] component= {lblusername,lblpass,lblloginhead,
				txtusername,txtpass,btnclearlogin,btnlogin,btnexitlogin,lblheading};
		
		for(JComponent c:component)
		{
			c.setFont(fo);
			c.setForeground(font);
		}
	}
	public void addonLogin()
	{
		jframe.add(pall);
		pheading.add(lblheading);
		pheading.add(lblclock);
		jframe.add(pheading,BorderLayout.NORTH);
		jframe.setIconImage(new ImageIcon("D:\\HealthPlus:\\icon.jpg").getImage());
		ploginusername.add(lblusername);
		ploginusername.add(txtusername);
		ploginpass.add(lblpass);
		ploginpass.add(txtpass);
		putOnlogin(1,1,lblloginhead);
		putOnlogin(1,3,ploginusername);
		//putOnlogin(4,3,txtusername);
		putOnlogin(1,4,ploginpass);
		pbutton.add(btnlogin);
		pbutton.add(btnclearlogin);
		pbutton.add(btnexitlogin);
		putOnlogin(1,5,pbutton);
		pall.add(plogin,"login");
		pall.add(pchoices,"choices");
		pall.add(paddmedicine,"addmedicine");
		pall.add(paddcust,"addcust");
		pall.add(psearchmedi, "searchmedi");
		pall.add(premovemedi,"removemedi");
		pall.add(psearchremovecust,"searchremovecust");
		pall.add(pplaceorder,"placeorder");
	}
	
	public void show()
	{   
		jframe.setSize(800,800);
		jframe.setLocation(10,5);
		jframe.setVisible(true);

		Thread t1=new Thread(new HealthPlusWork());
        t1.start();
        
	}

	
	public void eventHandling()
	{    
		EventHandlelogin ec=new EventHandlelogin();
		btnlogin.addActionListener(ec);
		btnclearlogin.addActionListener(ec);
		btnexitlogin.addActionListener(ec);
	}
	
	public void clearLogin()
	{
		txtusername.setText("");
		txtpass.setText("");
	}
	
	/* code for login frame ends except memory 
	allocation, all frames elements are allocated memory in constructor*/
	class EventHaldleChoices implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==btnbackchoice)
			{
				cardLayout.show(pall,"login");
			    clearLogin();
			}
			else if(e.getSource()==btnexitchoice)
			System.exit(0);
			else if(e.getSource()==btnaddmedicine)
			{cardLayout.show(pall,"addmedicine");}
			else if(e.getSource()==btnsearchmedi)
			{cardLayout.show(pall,"searchmedi");}
			else if(e.getSource()==btnaddcustomer)
			{cardLayout.show(pall,"addcust");
			txtcustidaddcust.setText(String.valueOf(System.currentTimeMillis()));
			btninsertaddcust.setEnabled(true);
			btnupdatecustworking.setEnabled(false);
			}
			else if(e.getSource()==btnremovemedi)
			{
				cardLayout.show(pall,"removemedi");
				btnremovemedimedi.setEnabled(true);
				lblheadremovemedi.setText("        Remove Medicine");
				txtnameremovemedi.setEditable(false);
				txtqtyremovemedi.setEditable(false);
				txtpriceremovemedi.setEditable(false);
				combmfdmnthremovemedi.setEnabled(false);
				combmfdyrremovemedi.setEnabled(false);
				combexpmnthremovemedi.setEnabled(false);
				combexpyrremovemedi.setEnabled(false);
				btnupdatemedimedi.setEnabled(false);
				lblnameremovemedi.setEnabled(false);
				lblmfdremovemedi.setEnabled(false);
				lblqtyremovemedi.setEnabled(false);
				lblpriceremovemedi.setEnabled(false);
				lblexpdremovemedi.setEnabled(false);
				chknameupdatemedi.setEnabled(false);
				chkqtyupdatemedi.setEnabled(false);
				chkpriceupdatemedi.setEnabled(false);
				chkexpdupdatemedi.setEnabled(false);
				chkmfdupdatemedi.setEnabled(false);
			}
			else if(e.getSource()==btnupdatemedi)
			{   
				cardLayout.show(pall,"removemedi");
				btnremovemedimedi.setEnabled(false);
				lblheadremovemedi.setText("         Update Medicine");
				txtnameremovemedi.setEditable(false);
				txtqtyremovemedi.setEditable(false);
				txtpriceremovemedi.setEditable(false);
				combmfdmnthremovemedi.setEnabled(false);
				combmfdyrremovemedi.setEnabled(false);
				combexpmnthremovemedi.setEnabled(false);
				combexpyrremovemedi.setEnabled(false);
				btnupdatemedimedi.setEnabled(true);
				lblnameremovemedi.setEnabled(true);
				lblmfdremovemedi.setEnabled(true);
				lblqtyremovemedi.setEnabled(true);
				lblpriceremovemedi.setEnabled(true);
				lblexpdremovemedi.setEnabled(true);
				chknameupdatemedi.setEnabled(true);
				chkqtyupdatemedi.setEnabled(true);
				chkpriceupdatemedi.setEnabled(true);
				chkexpdupdatemedi.setEnabled(true);
				chkmfdupdatemedi.setEnabled(true);
			}
			else if(e.getSource()==btnsearchcust)
			{
				cardLayout.show(pall, "searchremovecust");
				txtaddrssearchcust.setEditable(false);
				btnsearchsearchcust.setEnabled(true);
				btnremovesearchcust.setEnabled(false);
				lblheadsearchcust.setText("        Search Customer");
			}
			else if(e.getSource()==btnupdatecust)
			{
				cardLayout.show(pall, "addcust");
				lblheadaddcust.setText("      Update Customer");
				txtcustidaddcust.setText(String.valueOf(System.currentTimeMillis()));
				btninsertaddcust.setEnabled(false);
				btnupdatecustworking.setEnabled(true);
				
			}
			else if(e.getSource()==btnremovecust)
			{
				cardLayout.show(pall, "searchremovecust");
				txtaddrssearchcust.setEditable(false);
				btnsearchsearchcust.setEnabled(false);
				btnremovesearchcust.setEnabled(true);
				lblheadsearchcust.setText("        Remove Customer");
			}
			
			else if(e.getSource()==btnplaceorder)
			{
				cardLayout.show(pall,"placeorder");
			}
			
		} // end of function
		
	}// end of class of event handling choices
	
	public void EventHandleChoice()
	{
		EventHaldleChoices ehc=new EventHaldleChoices();
	    btnexitchoice.addActionListener(ehc);
	    btnbackchoice.addActionListener(ehc);
		btnaddmedicine.addActionListener(ehc);
		btnaddcustomer.addActionListener(ehc);
		btnsearchmedi.addActionListener(ehc);
		btnremovemedi.addActionListener(ehc);
		btnupdatemedi.addActionListener(ehc);
		btnsearchcust.addActionListener(ehc);
		btnupdatecust.addActionListener(ehc);
		btnremovecust.addActionListener(ehc);
		btnplaceorder.addActionListener(ehc);
		//btnremovemedimedi.addActionListener(ehc);
	}
	public void choicesFrame()
	{
		colorFontOperationChoices();
		addonChoices();
		EventHandleChoice(); 
		clearLogin();
	}
	
	public void colorFontOperationChoices()
	{
		Font fo=new Font("Imprint MT Shadow",Font.BOLD,30);
		Color font=new Color(255,74,0);
		JComponent[] component= {btnaddmedicine,btnremovemedi,btnsearchmedi,btnupdatemedi
				,btnaddcustomer,btnbackchoice,btnexitchoice,btnremovecust,btnupdatecust
				,btnsearchcust,btnplaceorder};
		for(JComponent c:component)
		{
			c.setFont(fo);
			c.setForeground(font);
		}
	}
	public void putOnChoices(int x,int y,JComponent c)
	{   gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.insets=new Insets(8,8,5,12);
		gbc.gridx=x;
		gbc.gridy=y;
		gbl.setConstraints(c,gbc);
	    pchoices.add(c);
		
	}
	
	public void addonChoices()
	{   putOnChoices(2,1,btnplaceorder);
		putOnChoices(2,2,btnaddmedicine);
		putOnChoices(2,3,btnsearchmedi);
		putOnChoices(2,4,btnupdatemedi);
		putOnChoices(2,5,btnremovemedi);
		putOnChoices(2,6,btnaddcustomer);
		putOnChoices(2,7,btnsearchcust);
		putOnChoices(2,8,btnupdatecust);
		putOnChoices(2,9,btnremovecust);
		putOnChoices(2,10,btnbackchoice);
		putOnChoices(2,11,btnexitchoice);
	}
	// code for choices panel over
	public void addMedicine()
	{   
		String name=txtnameaddmedi.getText().trim().toUpperCase(),corrname="";
	    String bno=txtbnoaddmedi.getText().trim().toUpperCase(),corrbno="";
	    String qty=txtqtyaddmedi.getText().trim(),corrqty="";
	    String mfdmnth=combomfdmonth.getSelectedItem()+"",mfdyr=combomfdyear.getSelectedItem()+""
	    		,corrmfd="";
	    String expmnth=comboexpmonth.getSelectedItem()+"",expyr=comboexpyear.getSelectedItem()+"",
	    		correxp="";
	    String price=txtpriceaddmedi.getText().trim(),corrprice="";
	    if(bno.length()<3 || bno.matches(("[0-9]+")))
	    lblerrorbnoaddmedi.setText("Incorrect BNO");
	    else
	    {
	    	corrbno=bno;
	    	lblerrorbnoaddmedi.setText("");
	    }
	    
		if(name.length()<3)
		lblerrornameaddmedi.setText("more than 2 characters");
		else if(name.matches(("[0-9]+")))
		lblerrornameaddmedi.setText("Incorrect name");
		else
		{
			corrname=name;
			lblerrornameaddmedi.setText("");
		}
		
		if(qty.length()==0 || Integer.parseInt(qty)==0)
		lblerrorqtyaddmedi.setText("Incorrect Quantity");
		else
		{
			corrqty=qty;
			lblerrorqtyaddmedi.setText("");
		}
		
		if(mfdmnth.equals("mm") || mfdyr.equals("yyyy"))
		lblerrormfdaddmedi.setText("Choose correct date");
		else
		{
			corrmfd=mfdmnth+"/"+mfdyr;
			lblerrormfdaddmedi.setText("");
		}
		
		if(expmnth.equals("mm") || expyr.equals("yyyy"))
		lblerrorexpaddmedi.setText("Choose correct date");
		else if(mfdmnth.equals("mm")==false && mfdyr.equals("yyyy")==false && expmnth.equals("mm")==false || expyr.equals("yyyy")==false)
		{
			if(Integer.parseInt(mfdyr)>Integer.parseInt(expyr))
			lblerrorexpaddmedi.setText("Choose correct date");
			else if(Integer.parseInt(mfdyr)==Integer.parseInt(expyr) && Integer.parseInt(expmnth)<=(Integer.parseInt(mfdmnth)+2) )
			lblerrorexpaddmedi.setText("Choose correct date");
			else
			{
				correxp=expmnth+"/"+expyr;
				lblerrorexpaddmedi.setText("");
			}
		}
		
		
		if(price.length()==0 || Double.parseDouble(price)==0)
		lblerrormrpaddmedi.setText("Incorrect Price");
		else
		{
			corrprice=price;
			lblerrormrpaddmedi.setText("");
		}
		
		
		if(corrname.length()>2 && corrbno.length()>2 && corrmfd.equals("")==false && 
				corrprice.equals("")==false && correxp.equals("")==false)
		{ lblerrornameaddmedi.setText("");
		  lblerrorbnoaddmedi.setText("");
		  try
		  {
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/medi_info.db");
			String query="insert into medicines values(?,?,?,?,?,?)";
			PreparedStatement smt=c.prepareStatement(query);
			smt.setString(1,corrbno);
			smt.setString(2,corrname);
			smt.setInt(3,Integer.parseInt(txtqtyaddmedi.getText()));
			smt.setString(4,corrmfd);
			smt.setString(5,correxp);
			smt.setFloat(6,Float.parseFloat(txtpriceaddmedi.getText()));
			int row=smt.executeUpdate();
			smt.close();
			  c.close();
			  if(row>0)
		 	  {
				  JOptionPane.showMessageDialog(null,"Record successfully added...");
				  clearAddMedicine();
		 	  }
		}
	
		catch(Exception e)
		{
			 JOptionPane.showMessageDialog(null,"Record Not added..." + e.getMessage());
		}
	}
}
	
	class EventHandleAddMedicine implements ActionListener
	{
			public void actionPerformed(ActionEvent e) 
			{  try {
				if(e.getSource()==btnexitaddmedicine)
					System.exit(0);
				else if(e.getSource()==btnbackaddmedicine)
				{cardLayout.show(pall,"choices");
				clearAddMedicine();}
				else if(e.getSource()==btninsertmedi)
				{
					addMedicine();
				}
				else
				{clearAddMedicine();}
			   }
			catch(Exception a)
			{
				JOptionPane.showMessageDialog(null, "Enter Details");
			}
			}
       
	}
	
	public void haldleAddMedicine()
	{  
		EventHandleAddMedicine eh=new EventHandleAddMedicine();
		btnexitaddmedicine.addActionListener(eh);
		btnbackaddmedicine.addActionListener(eh);
		btninsertmedi.addActionListener(eh);
		btnclearaddmedi.addActionListener(eh);
	}
	public void MedicineFrame()
	{   colorFontOperationAddMedicine();
		addonAddMedicine();
		haldleAddMedicine();
		//cardLayout.show(pall,"addmedicine");
	}
	
	public void colorFontOperationAddMedicine()
	{
		Font fo=new Font("Imprint MT Shadow",Font.BOLD,30);
		Color font=new Color(255,74,0);
		Color combo=new Color(255,255,255);
		JComponent[] component= {lblbnoaddmedi,txtbnoaddmedi,lbladdmedicinehead,btnbackaddmedicine,
				btnexitaddmedicine,btnclearaddmedi,lblnameaddmedicine,lblpriceaddmedicine
				,lblqtyaddmedicine,lblmfdaddmedicine,lblexpdaddmedicine,txtnameaddmedi,txtqtyaddmedi
				,txtpriceaddmedi,combomfdyear,combomfdmonth,comboexpyear,btninsertmedi,comboexpmonth};
		JComponent[] comb= {combomfdyear,combomfdmonth,comboexpyear,comboexpmonth};
		for(JComponent c:component)
		{
			c.setFont(fo);                   
			c.setForeground(font);
		}
		for(JComponent c: comb)
		{
			c.setBackground(combo);
		}
	}
	
	public void putOnAddMedicine(int x,int y,JComponent c)
	{   gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.insets=new Insets(8,8,18,12);
		gbc.gridx=x;
		gbc.gridy=y;
		gbl.setConstraints(c,gbc);
	    paddmedicine.add(c);
		
	}
	
	public void addonAddMedicine()
	{   pheadaddmedi.add(lbladdmedicinehead);
		putOnAddMedicine(1,1,pheadaddmedi);
		
		pbnoaddmedi.add(lblbnoaddmedi);
		pbnoaddmedi.add(txtbnoaddmedi);
		pbnoaddmedi.add(lblerrorbnoaddmedi);
		putOnAddMedicine(1,2,pbnoaddmedi);
		
		pnameaddmedi.add(lblnameaddmedicine);  
		pnameaddmedi.add(txtnameaddmedi);
		pnameaddmedi.add(lblerrornameaddmedi);
		putOnAddMedicine(1,3,pnameaddmedi);
		
		pqtyaddmedi.add(lblqtyaddmedicine);
		pqtyaddmedi.add(txtqtyaddmedi);
		pqtyaddmedi.add(lblerrorqtyaddmedi);
		putOnAddMedicine(1,4,pqtyaddmedi);
		
		pmfdaddmedi.add(lblmfdaddmedicine);
		pmfdaddmedi.add(combomfdmonth);
		pmfdaddmedi.add(combomfdyear);
		pmfdaddmedi.add(lblerrormfdaddmedi);
		putOnAddMedicine(1,5,pmfdaddmedi);
		
		pefdaddmedi.add(lblexpdaddmedicine);
		pefdaddmedi.add(comboexpmonth);
		pefdaddmedi.add(comboexpyear);
		pefdaddmedi.add(lblerrorexpaddmedi);
		putOnAddMedicine(1,6,pefdaddmedi);
		
		ppriceaddmedi.add(lblpriceaddmedicine);
		ppriceaddmedi.add(txtpriceaddmedi);
		ppriceaddmedi.add(lblerrormrpaddmedi);
		putOnAddMedicine(1,7,ppriceaddmedi);
		
		pbtnaddmedicine.add(btninsertmedi);
		pbtnaddmedicine.add(btnclearaddmedi);
		pbtnaddmedicine.add(btnbackaddmedicine);
		pbtnaddmedicine.add(btnexitaddmedicine);
		putOnAddMedicine(1,8,pbtnaddmedicine);
		
	}
	
	public void clearAddMedicine()
	{
		txtbnoaddmedi.setText("");
		txtnameaddmedi.setText("");
		txtqtyaddmedi.setText("");
		combomfdmonth.setSelectedIndex(0);
		combomfdyear.setSelectedIndex(0);
		comboexpmonth.setSelectedIndex(0);
		comboexpyear.setSelectedIndex(0);
		txtpriceaddmedi.setText("");
		txtnameremovemedi.setEditable(false);
		txtqtyremovemedi.setEditable(false);
		txtpriceremovemedi.setEditable(false);
		combmfdmnthremovemedi.setEnabled(false);
		combmfdyrremovemedi.setEnabled(false);
		combexpmnthremovemedi.setEnabled(false);
		combexpyrremovemedi.setEnabled(false);
		btnupdatemedimedi.setEnabled(false);
		
	}
	// code of AddMedicine panel over
	
	//code of add customer start
	public void addCustomer()
	{
		try
		{   
			String mob=txtmobnoaddcust.getText().trim();
			String temp=txtnameaddcust.getText().toUpperCase().trim(),name="";
			String addrss=txtaddrsaddcust.getText().toUpperCase().trim(),corraddrs="";
			long corrmob=0;
			if(temp.matches(("[A-Za-z]{3,30}")))
			{
				name=temp;
				lblerrornameaddcust.setText("");
			}
			else if(temp.length()<3)
			lblerrornameaddcust.setText("more than 2 characters");
			else
			lblerrornameaddcust.setText("only characters are allowed");
			
			if(mob.length()>5 && mob.matches(("[0-9]+")))
			{
				corrmob=Long.parseLong(mob);
				lblerrormobnoaddcust.setText("");
			}
			else
			lblerrormobnoaddcust.setText("Incorrect Number");
			
			if(addrss.length()>3)
			{corraddrs=addrss;
			lblerroraddrsaddcust.setText("");
			}
			else
			lblerroraddrsaddcust.setText("Incorrect Address");
			
			if(name.length()>2 && corrmob!=0 && corraddrs.length()>3)
			{
				int count=0;
				
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/cust_info.db");
			String qury="select cust_id,address from customer where name=? and contactno=?";
			PreparedStatement sm=c.prepareStatement(qury);
			sm.setString(1,name);
			sm.setLong(2,corrmob);
			ResultSet rs = sm.executeQuery();
			while(rs.next())
			{	count++;
			//JOptionPane.showMessageDialog(null,"......");
			}
			
			if(count==0) {
			String query="insert into customer values(?,?,?,?)";
			PreparedStatement smt=c.prepareStatement(query);
			smt.setLong(1,Long.parseLong(txtcustidaddcust.getText().trim()));
			smt.setString(2,name);
			smt.setLong(3,Long.parseLong(mob));
			smt.setString(4,txtaddrsaddcust.getText().toUpperCase().trim());
			int rows_affected = smt.executeUpdate();
			  smt.close();
			  c.close();
			  if(rows_affected>0)
		 	 {
				  JOptionPane.showMessageDialog(null,"Record successfully added...");
				  clearAddCust();
				  txtcustidaddcust.setText(String.valueOf(System.currentTimeMillis()));
		 	 }
		} // end of If with count
		else
    	{
			JOptionPane.showMessageDialog(null, "Customer Already Exists...");
			clearAddCust();
    	} //end of else if with count
		
	}
		else if(temp.equals("") || mob.length()==0 ||  addrss.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Fill all details");
			lblerrornameaddcust.setText("");
			lblerrormobnoaddcust.setText("");
			lblerroraddrsaddcust.setText("");
			
         }
				
	}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Not Added In Database"+e.getMessage());
			
		}
		
	}
	
	class EventHadleAddCust implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnexitaddcust)
			System.exit(0);
			else if(e.getSource()==btnbackaddcust)
			{
				cardLayout.show(pall, "choices");
				clearAddCust();
			}
			else if(e.getSource()==btnclearaddcust)
			{
				clearAddCust();
				//txtcustidaddcust.setText(String.valueOf(System.currentTimeMillis()));
			}
			else if(e.getSource()==btninsertaddcust)
			{addCustomer();}
			else if(e.getSource()==btnupdatecustworking)
			{
				updateCust();
			}
		}
		
	}
	public void AddCustFrame()
	{   EventHadleAddCust a=new EventHadleAddCust();
		btnexitaddcust.addActionListener(a);
		btnbackaddcust.addActionListener(a);
		btnclearaddcust.addActionListener(a);
		btninsertaddcust.addActionListener(a);
		btnupdatecustworking.addActionListener(a);
	}
	
	public void AddCust()
	{
		colorFontOperationAddCustomer();
		addonAddCust();
		AddCustFrame();
	}
	public void putOnAddCust(int x,int y,JComponent c)
	{   gbc.anchor=GridBagConstraints.NORTHWEST;
	    gbc.insets=new Insets(8,8,29,12);
		gbc.gridx=x;
		gbc.gridy=y;
		gbl.setConstraints(c,gbc);
	    paddcust.add(c);
		
	}
	
	
	public void colorFontOperationAddCustomer()
	{
		Font fo=new Font("Imprint MT Shadow",Font.BOLD,30);
		Color font=new Color(255,74,0);
		JComponent[] component= {lblcustidaddcust,lblnameaddcust,lbladdrsaddcust,lblmobnoaddcust,txtcustidaddcust,txtnameaddcust,txtmobnoaddcust
				                 ,btnupdatecustworking,txtaddrsaddcust,lblheadaddcust,btnclearaddcust,btninsertaddcust,btnbackaddcust,btnexitaddcust};
		
		for(JComponent c:component)
		{
			c.setFont(fo);
			c.setForeground(font);
		}
	}
	public void addonAddCust()
	{   putOnAddCust(1,1,lblheadaddcust);
	    
	    pcustidaddcust.add(lblcustidaddcust);
	    txtcustidaddcust.setEditable(false);
	    pcustidaddcust.add(txtcustidaddcust);
	    putOnAddCust(1,2, pcustidaddcust);
	    
		pnameaddcust.add(lblnameaddcust);
		pnameaddcust.add(txtnameaddcust);
		pnameaddcust.add(lblerrornameaddcust);
		putOnAddCust(1,3,pnameaddcust);
		
		pmobnoaddcust.add(lblmobnoaddcust);
		pmobnoaddcust.add(txtmobnoaddcust);
		pmobnoaddcust.add(lblerrormobnoaddcust);
		putOnAddCust(1,4,pmobnoaddcust);
		
		paddrsaddcust.add(lbladdrsaddcust);
		paddrsaddcust.add(new JScrollPane(txtaddrsaddcust));
		paddrsaddcust.add(lblerroraddrsaddcust);
		putOnAddCust(1,5,paddrsaddcust);
		
		pbtnaddcust.add(btninsertaddcust);
		pbtnaddcust.add(btnupdatecustworking);
		pbtnaddcust.add(btnclearaddcust);
		pbtnaddcust.add(btnbackaddcust);
		pbtnaddcust.add(btnexitaddcust);
		putOnAddCust(1,6,pbtnaddcust);
	}
	
	public void clearAddCust()
	{
		//txtcustidaddcust.setText("");
		txtnameaddcust.setText("");
		txtmobnoaddcust.setText("");
		txtaddrsaddcust.setText("");
		lblerrornameaddcust.setText("");
		lblerrormobnoaddcust.setText("");
		lblerroraddrsaddcust.setText("");
	}
	
	// code of add customer panel over
	
	class EventHandleSearchMedi implements ActionListener
	{
      public void actionPerformed(ActionEvent e) 
      {
    	  if(e.getSource()==btnexitsearchmedi)
    		  System.exit(0);
    	  else if(e.getSource()==btnbacksearchmedi)
    		 cardLayout.show(pall,"choices");
    	  else if(e.getSource()==btnsearchsearchmedi)
    		  callSearchOperation();
    	  if(radbno.isSelected()==true)
    	  { txtbnosearchmedi.setEditable(true);
    	    txtnamesearchmedi.setEditable(false);
    	    txtnamesearchmedi.setText("");
    	  }
    	  else if(radname.isSelected()==true)
    	  { txtbnosearchmedi.setEditable(false);
    	    txtnamesearchmedi.setEditable(true);
    	    txtbnosearchmedi.setText("");
    	  }
	  }
		
	}
	
	public void eventHandleSearchMedi()
	{
		EventHandleSearchMedi e=new EventHandleSearchMedi();
		btnexitsearchmedi.addActionListener(e);
		btnbacksearchmedi.addActionListener(e);
		radbno.addActionListener(e);
		radname.addActionListener(e);
		btnsearchsearchmedi.addActionListener(e);
	}
	
	public void callSearchOperation()
	{   //txtbnosearchmedi.setEditable(true);
	    //txtnamesearchmedi.setEditable(false);
		try
		{   ArrayList<String[]> rows = new ArrayList<String[]>();
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/medi_info.db");
			//Statement stmt = c.createStatement();
			if(radbno.isSelected()==true)
			{ 
			 String query="Select * from medicines where B_No=?";
			 PreparedStatement smt=c.prepareStatement(query);
			 smt.setString(1,txtbnosearchmedi.getText().trim());
			
			ResultSet rs = smt.executeQuery();
			while(rs.next())
			{
				String[] row= {rs.getString(1),rs.getString(2),rs.getInt(3)+"",
						rs.getString(4),rs.getString(5),rs.getFloat(6)+""};
				rows.add(row);
			}
		    	rs.close();
		     // stmt.close();
		      c.close();
		      
		      String[][] data = new String[rows.size()][];
				int r=0;
				for(String[] row : rows)
				{
					data[r] = row;
					r++;
				}
				String[] headers = {"B_No","NAME","Qty", "MFD","Expiery Date","MRP"};
				//JOptionPane.showMessageDialog(null, data);
				//psearchtable.removeAll();
				model = new DefaultTableModel(data,headers);
				tabelsearchmedi = new JTable(model);
				JOptionPane.showMessageDialog(null, tabelsearchmedi);
			}
			
			if(radname.isSelected()==true)
			{ 
			 String query="Select * from medicines where name=?";
			 PreparedStatement smt=c.prepareStatement(query);
			 smt.setString(1,txtnamesearchmedi.getText().trim());
			
			ResultSet rs = smt.executeQuery();
			while(rs.next())
			{
				String[] row= {rs.getString(1),rs.getString(2),rs.getInt(3)+"",
						rs.getString(4),rs.getString(5),rs.getFloat(6)+""};
				rows.add(row);
			}
		    	rs.close();
		     // stmt.close();
		      c.close();
		      
		      String[][] data = new String[rows.size()][];
				int r=0;
				for(String[] row : rows)
				{
					data[r] = row;
					r++;
				}
				String[] headers = {"B_No","NAME","Qty", "MFD","Expiery Date","MRP"};
				//JOptionPane.showMessageDialog(null, data);
				model = new DefaultTableModel(data,headers);
				tabelsearchmedi = new JTable(model);
				JOptionPane.showMessageDialog(null, tabelsearchmedi);
			}
		
				
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something Went Wrong..."+e.getMessage());
		}
	  
	}
	
	public void callSearchMediFrame()
	{
		colorFontOperationSearchmedi();
		addonSearchMedicine();
	 eventHandleSearchMedi();
	}
	public void putOnSearchMedi(int x,int y,JComponent c)
	{   gbc.anchor=GridBagConstraints.NORTHWEST;
	    gbc.insets=new Insets(5,5,5,5);
		gbc.gridx=x;
		gbc.gridy=y;
		gbl.setConstraints(c,gbc);
	    psearchmedi.add(c);
		
	}
	
	
	public void colorFontOperationSearchmedi()
	{
		Font fo=new Font("Imprint MT Shadow",Font.BOLD,30);
		Color font=new Color(255,74,0);
		JComponent[] component= {radbno,radname,lblbasissearchmedi,lblheadsearchmedi,lblbnosearchmedi
				,txtbnosearchmedi,lblnamesearchmedi,txtnamesearchmedi,btnsearchsearchmedi
				,btnexitsearchmedi,btnbacksearchmedi};
		
		for(JComponent c:component)
		{
			c.setFont(fo);
			c.setForeground(font);
		}
	}
	public void addonSearchMedicine()
	{
		txtbnosearchmedi.setEditable(false);
	    txtnamesearchmedi.setEditable(false);
		bgsearchchoice.add(radbno);
		bgsearchchoice.add(radname);
		psearchbasis.add(lblbasissearchmedi);
		psearchbasis.add(radbno);
		psearchbasis.add(radname);
		//putOnSearchMedi(1,1,lblheadsearchmedi);
		putOnSearchMedi(1,2,psearchbasis);
		
		psearchmedicomponents.add(lblbnosearchmedi);
		psearchmedicomponents.add(txtbnosearchmedi);
		psearchmedicomponents.add(lblnamesearchmedi);
		psearchmedicomponents.add(txtnamesearchmedi);
		putOnSearchMedi(1,3,psearchmedicomponents);
		//psearchtable.removeAll();
		//psearchtable.setMinimumSize(new Dimension(20,20));
		psearchtable.add(new JScrollPane(tabelsearchmedi));
		putOnSearchMedi(1,4,psearchtable);
		pbtnsearchmedi.add(btnsearchsearchmedi);
		pbtnsearchmedi.add(btnbacksearchmedi);
	    pbtnsearchmedi.add(btnexitsearchmedi);
	   putOnSearchMedi(1,5,pbtnsearchmedi);
	    
	}
	
	// code of search medicine over
	// code of remove medicine start + Update Medicine
	class EventHandlingRemoveUpdate implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnexitremovemedi)
				System.exit(0);
			else if(e.getSource()==btnbackremovemedi)
			cardLayout.show(pall, "choices");
			else if(e.getSource()==btnclearremovemedi)
			clearRemoveMedi();
			else if(e.getSource()==btnremovemedimedi)
			{	JOptionPane.showMessageDialog(null, "Confirm..??");
				removeMedicine();
				txtbnoremovemedi.setText("");
			}
			else if(e.getSource()==btnupdatemedimedi)
			updateMedicine();
			
			if(chknameupdatemedi.isSelected())
			{txtnameremovemedi.setEditable(true);}
			if(chknameupdatemedi.isSelected()==false)
			{
			txtnameremovemedi.setEditable(false);
			txtnameremovemedi.setText("");
			lblerrorremovemedi.setText("");
			}
			
			if(chkqtyupdatemedi.isSelected())
			txtqtyremovemedi.setEditable(true);
			if(chkqtyupdatemedi.isSelected()==false)
			{
				txtqtyremovemedi.setEditable(false);
				txtqtyremovemedi.setText("");
				lblerrorqtyremovemedi.setText("");
			}
			
			if(chkpriceupdatemedi.isSelected())
			txtpriceremovemedi.setEditable(true);
			if(chkpriceupdatemedi.isSelected()==false)
			{
				txtpriceremovemedi.setEditable(false);
				txtpriceremovemedi.setText("");
				lblerrorpriceremovemedi.setText("");
			}
			
			if(chkmfdupdatemedi.isSelected())
			combmfdmnthremovemedi.setEnabled(true);
			if(chkmfdupdatemedi.isSelected()==false)
			{
				combmfdmnthremovemedi.setEnabled(false);
				combmfdmnthremovemedi.setSelectedIndex(0);
				lblerrormfdremovemedi.setText("");
			}
			
			if(chkmfdupdatemedi.isSelected())
			combmfdyrremovemedi.setEnabled(true);
			if(chkmfdupdatemedi.isSelected()==false)
			{
				combmfdyrremovemedi.setEnabled(false);
				combmfdyrremovemedi.setSelectedIndex(0);
				lblerrormfdremovemedi.setText("");
			}
			
			if(chkexpdupdatemedi.isSelected())
			combexpmnthremovemedi.setEnabled(true);
			if(chkexpdupdatemedi.isSelected()==false)
			{
				combexpmnthremovemedi.setEnabled(false);
				combexpmnthremovemedi.setSelectedIndex(0);
				lblerrorexpremovemedi.setText("");
			}
				
			if(chkexpdupdatemedi.isSelected())
			combexpyrremovemedi.setEnabled(true);
			if(chkexpdupdatemedi.isSelected()==false)
			{
				combexpyrremovemedi.setEnabled(false);
				combexpyrremovemedi.setSelectedIndex(0);
				lblerrorexpremovemedi.setText("");
			}
			
		}
		
	}
	public void callRemoveUpdateHandling()
	{   EventHandlingRemoveUpdate a=new EventHandlingRemoveUpdate();
		btnexitremovemedi.addActionListener(a);
		btnbackremovemedi.addActionListener(a);
		btnclearremovemedi.addActionListener(a);
		btnremovemedimedi.addActionListener(a);
		btnupdatemedimedi.addActionListener(a); 
		chknameupdatemedi.addActionListener(a);
		chkqtyupdatemedi.addActionListener(a);
		chkpriceupdatemedi.addActionListener(a);
		chkmfdupdatemedi.addActionListener(a);
		chkexpdupdatemedi.addActionListener(a);
	}
	public void callRemoveMedi()
	{
		colorFontOperationRemoveMedi();
		addonRemoveMedi();
		callRemoveUpdateHandling();
		
	}
	public void putOnRemoveMedi(int x,int y,JComponent c)
	{   gbc.anchor=GridBagConstraints.NORTHWEST;
	    gbc.insets=new Insets(8,8,18,12);
		gbc.gridx=x;
		gbc.gridy=y;
		gbl.setConstraints(c,gbc);
	    premovemedi.add(c); 
		
	}
	
	
	public void colorFontOperationRemoveMedi()
	{
		Font fo=new Font("Imprint MT Shadow",Font.BOLD,30);
		Color font=new Color(255,74,0);
		Color combo=new Color(255,255,255);
		JComponent[] component= {lblheadremovemedi,lblbnoremovemedi,lblnameremovemedi,
						lblqtyremovemedi,lblmfdremovemedi,lblexpdremovemedi,
						lblpriceremovemedi,txtpriceremovemedi,txtbnoremovemedi,txtnameremovemedi
						,txtqtyremovemedi,btnremovemedimedi,btnupdatemedimedi,btnbackremovemedi
						,btnclearremovemedi,btnexitremovemedi,combexpmnthremovemedi,combexpyrremovemedi
						,combmfdmnthremovemedi,combmfdyrremovemedi};
		JComponent[] combocomponents={combexpmnthremovemedi,combexpyrremovemedi
				,combmfdmnthremovemedi,combmfdyrremovemedi};
		for(JComponent c:component)
		{
			c.setFont(fo);
			c.setForeground(font);
		}
		for(JComponent c:combocomponents)
		{
		   c.setBackground(combo);
		}
	}
	public void addonRemoveMedi()
	{
		putOnRemoveMedi(1,1,lblheadremovemedi);
		
		pbnoremovemedi.add(lblbnoremovemedi);
		pbnoremovemedi.add(txtbnoremovemedi);
		putOnRemoveMedi(1,2,pbnoremovemedi);
		
		pnameremovemedi.add(lblnameremovemedi);
		pnameremovemedi.add(chknameupdatemedi);
		pnameremovemedi.add(txtnameremovemedi);
		pnameremovemedi.add(lblerrorremovemedi);
		putOnRemoveMedi(1,3,pnameremovemedi);
		
		pqtyremovemedi.add(lblqtyremovemedi);
		pqtyremovemedi.add(chkqtyupdatemedi);
		pqtyremovemedi.add(txtqtyremovemedi);
		pqtyremovemedi.add(lblerrorqtyremovemedi);
		putOnRemoveMedi(1,4,pqtyremovemedi);
		
		pmfdremovemedi.add(lblmfdremovemedi); 
		pmfdremovemedi.add(chkmfdupdatemedi);
		pmfdremovemedi.add(combmfdmnthremovemedi);
		pmfdremovemedi.add(combmfdyrremovemedi);
		pmfdremovemedi.add(lblerrormfdremovemedi);
		putOnRemoveMedi(1,5,pmfdremovemedi);
		
		pefdremovemedi.add(lblexpdremovemedi);
		pefdremovemedi.add(chkexpdupdatemedi);
		pefdremovemedi.add(combexpmnthremovemedi); 
		pefdremovemedi.add(combexpyrremovemedi);
		pefdremovemedi.add(lblerrorexpremovemedi);
		putOnRemoveMedi(1,6,pefdremovemedi);
		
		ppriceremovemedi.add(lblpriceremovemedi);
		ppriceremovemedi.add(chkpriceupdatemedi);
		ppriceremovemedi.add(txtpriceremovemedi);
		ppriceremovemedi.add(lblerrorpriceremovemedi);
		putOnRemoveMedi(1,7,ppriceremovemedi);
		
		pbtnremovemedi.add(btnremovemedimedi);
		pbtnremovemedi.add(btnupdatemedimedi);  
		pbtnremovemedi.add(btnclearremovemedi);
		pbtnremovemedi.add(btnbackremovemedi);
		pbtnremovemedi.add(btnexitremovemedi);
		putOnRemoveMedi(1,8,pbtnremovemedi);
	}
	public void clearRemoveMedi()
	{
		txtbnoremovemedi.setText("");
		txtnameremovemedi.setText("");
		txtqtyremovemedi.setText("");
		txtpriceremovemedi.setText("");
		lblerrorremovemedi.setText("");
		lblerrorqtyremovemedi.setText("");
		lblerrorpriceremovemedi.setText("");
	    lblerrormfdremovemedi.setText("");
	    lblerrorexpremovemedi.setText("");
		combexpyrremovemedi.setSelectedIndex(0);
		combexpmnthremovemedi.setSelectedIndex(0);
		combmfdmnthremovemedi.setSelectedIndex(0);
		combmfdyrremovemedi.setSelectedIndex(0);
		chknameupdatemedi.setSelected(false);
		chkqtyupdatemedi.setSelected(false);
		chkpriceupdatemedi.setSelected(false);
		chkexpdupdatemedi.setSelected(false);
		chkmfdupdatemedi.setSelected(false);
		txtnameremovemedi.setEditable(false);
		txtqtyremovemedi.setEnabled(false);
		txtpriceremovemedi.setEnabled(false);
	}
	
	public void removeMedicine()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/medi_info.db");
			String query="delete from medicines where B_no=?";
			PreparedStatement smt=c.prepareStatement(query);
			smt.setString(1,txtbnoremovemedi.getText().trim());
			int result=smt.executeUpdate();
			if(result>0)
				JOptionPane.showMessageDialog(null, "Medicine Removed...");
			else
				JOptionPane.showMessageDialog(null, "Not Found");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong"+e.getMessage());
		}
	} // Remove Medicine Function over
	
	
	public void updateMedicine()
	{   try
	   {
		String name="",qty="",price="",mfd="",exp="",query="";
		int count=0,namechk=0,pricechk=0,qtychk=0,mfdchk=0,expchk=0,
			overallchk=0,sumchk=0,nameoverall=0,priceoverall=0,qtyoverall=0
			,mfdoverall=0,expoverall=0;
		if(chknameupdatemedi.isSelected())
		{  nameoverall++;
			String tempname;
		    tempname=txtnameremovemedi.getText().trim();
			if(tempname.length()<3)
			{lblerrorremovemedi.setText("more than 2 characters"); namechk=0;}
			
			if(tempname.matches(("[0-9]+")))
		    {lblerrorremovemedi.setText("numberic not allowed"); namechk=0;}
			
			if(tempname.matches(("[a-zA-Z]+")) && tempname.length()>2)
			{name=tempname;
			lblerrorremovemedi.setText("");
			namechk++;}
		}
		if(chknameupdatemedi.isSelected()==false)
		{
			name="";
			if(namechk>0)
			namechk--;
			if(nameoverall>0)
			nameoverall--;
		}
		
		
		if(chkqtyupdatemedi.isSelected())
		{  qtyoverall++;
			String tempqty;
			int tempqtty=0;
			tempqty=txtqtyremovemedi.getText().trim();
			if(tempqty.matches(("[0-9]+")))
			tempqtty=Integer.parseInt(tempqty);
			
			if(tempqty.length()==0)
			{lblerrorqtyremovemedi.setText("Enter proper value"); qtychk=0;}
			if(tempqtty<=0)
			{lblerrorqtyremovemedi.setText("Enter proper value"); qtychk=0;}
			else
			{qty=tempqtty+""; 
			lblerrorqtyremovemedi.setText("");
			qtychk++;}
	    }
		if(chkqtyupdatemedi.isSelected()==false)
		{
			qty="";
			if(qtychk>0)
			qtychk--;
			
			if(qtyoverall>0)
			qtyoverall--;
		}
		
		
		if(chkpriceupdatemedi.isSelected())
		{  priceoverall++;
			String tempprice;
			double temprice=0;
			tempprice=txtpriceremovemedi.getText().trim();
			if(tempprice.matches(("[0-9.]+")))
			temprice=Double.parseDouble(tempprice);
			if(tempprice.length()==0)
			{lblerrorpriceremovemedi.setText("Enter proper price"); pricechk=0;}
			else if(temprice<=0)
			{lblerrorpriceremovemedi.setText("Enter proper price"); pricechk=0;}
			else
			{price=temprice+"";
			lblerrorpriceremovemedi.setText("");
			pricechk++;}
		}
		if(chkpriceupdatemedi.isSelected()==false)
		{
			price="";
			if(pricechk>0)
			pricechk--;
			
			if(priceoverall>0)
			priceoverall--;
		}
		
		if(chkmfdupdatemedi.isSelected())
		{   mfdoverall++;
			String tempmonthmfd,tempyrmdf;
			tempmonthmfd=combmfdmnthremovemedi.getSelectedItem()+"";
			tempyrmdf=combmfdyrremovemedi.getSelectedItem()+"";
			if(tempmonthmfd.equals("mm") || tempyrmdf.equals("yyyy"))
			{lblerrormfdremovemedi.setText("Choose Correct Date"); mfdchk=0;}
			else
			{mfd=tempmonthmfd+"/"+tempyrmdf; 
			lblerrormfdremovemedi.setText("");
			mfdchk++; }
		}
		if(chkmfdupdatemedi.isSelected()==false)
		{
			mfd="";
			if(mfdchk>0)
				mfdchk--;
			if(mfdoverall>0)
				mfdoverall--;
		}
			
		if(chkexpdupdatemedi.isSelected())
		{   expoverall++;
			String tempmonthexp,tempyrexp;
			tempmonthexp=combexpmnthremovemedi.getSelectedItem()+"";
			tempyrexp=combexpyrremovemedi.getSelectedItem()+"";
			if(tempmonthexp.equals("mm") || tempyrexp.equals("yyyy"))
			{lblerrorexpremovemedi.setText("Choose Correct Date"); expchk=0;}
			else
			{exp=tempmonthexp+"/"+tempyrexp;
			lblerrorexpremovemedi.setText("");
			expchk++;
			}
		}	
		if(chkexpdupdatemedi.isSelected()==false)
		{
			exp="";
			if(expchk>0)
			expchk--;
			if(expoverall>0)
			expoverall--;
		}
		
		if(chkmfdupdatemedi.isSelected()==true && chkexpdupdatemedi.isSelected()==true)
		{   int mfdmnth=0,mfdyr=0,expyr=0,expmnth=0;
			String tempmonthexp,tempyrexp;
			tempmonthexp=combexpmnthremovemedi.getSelectedItem()+"";
			tempyrexp=combexpyrremovemedi.getSelectedItem()+"";
			if(tempmonthexp.equals("mm") || tempyrexp.equals("yyyy"))
			{lblerrorexpremovemedi.setText("Choose Correct Date"); expchk=0;}
			else
			{
				expmnth=Integer.parseInt(tempmonthexp);
				expyr=Integer.parseInt(tempyrexp);
			}
			String tempmonthmfd,tempyrmdf;
			tempmonthmfd=combmfdmnthremovemedi.getSelectedItem()+"";
			tempyrmdf=combmfdyrremovemedi.getSelectedItem()+"";
			if(tempmonthmfd.equals("mm") || tempyrmdf.equals("yyyy"))
			{lblerrormfdremovemedi.setText("Choose Correct Date"); mfdchk=0;}
			else
			{
				mfdmnth=Integer.parseInt(tempmonthmfd);
				mfdyr=Integer.parseInt(tempyrmdf);
			}
			
			if(expmnth>0 && expyr>0 && mfdmnth>0 && mfdyr>0)
			{
				if(expyr<mfdyr)
				{   exp="";
					lblerrorexpremovemedi.setText("Choose Correct Date");
					expchk=0;
				}
				else if(expyr==mfdyr && (expmnth<=mfdmnth+2))
				{lblerrorexpremovemedi.setText("Choose Correct Date");
				  exp="";
				  expchk=0;
				}
			}
	    } // end of if of line 1283
			
		sumchk=namechk+pricechk+qtychk+mfdchk+expchk;
		overallchk=nameoverall+priceoverall+qtyoverall+mfdoverall+expoverall;
		
		
		
	    // Connectivity Starts
		if(sumchk==overallchk && sumchk>0)
		{
			Class.forName("org.sqlite.JDBC");
		 Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/medi_info.db");
		 JOptionPane.showMessageDialog(null,"Confirm Update...??");
		 if(name!="")
		{
			query="update medicines set Name=? where B_no=?";
			PreparedStatement smt=c.prepareStatement(query);
			smt.setString(1,name);
			smt.setString(2,txtbnoremovemedi.getText());
			int result=smt.executeUpdate();
			if(result>0)
			//JOptionPane.showMessageDialog(null, "Name Updated");
			count++;
		}
		
		if(qty!="")
		{
			query="update medicines set quantity=? where B_no=?";
			PreparedStatement smt=c.prepareStatement(query);
			smt.setString(1,qty);
			smt.setString(2,txtbnoremovemedi.getText());
			int result=smt.executeUpdate();
			if(result>0)
			//JOptionPane.showMessageDialog(null, "Quantity Updated");
			count++;
		}
		
		if(mfd!="")
		{
			query="update medicines set mfd=? where B_no=?";
			PreparedStatement smt=c.prepareStatement(query);
			smt.setString(1,mfd);
			smt.setString(2,txtbnoremovemedi.getText());
			int result=smt.executeUpdate();
			if(result>0)
			//JOptionPane.showMessageDialog(null, "MFD Updated");
				count++;
		}
		
		if(exp!="")
		{
			query="update medicines set expiery_date=? where B_no=?";
			PreparedStatement smt=c.prepareStatement(query);
			smt.setString(1,exp);
			smt.setString(2,txtbnoremovemedi.getText());
			int result=smt.executeUpdate();
			if(result>0)
			//JOptionPane.showMessageDialog(null, "Name Updated");
				count++;
		}
		
		if(price!="")
		{
			query="update medicines set mrp=? where B_no=?";
			PreparedStatement smt=c.prepareStatement(query);
			smt.setString(1,price);
			smt.setString(2,txtbnoremovemedi.getText());
			int result=smt.executeUpdate();
			if(result>0)
			//JOptionPane.showMessageDialog(null, "Price Updated");
			count++;
		}
		
		if(count>0)
		{
			JOptionPane.showMessageDialog(null, "Successfully Updated");
			clearRemoveMedi();
		}
		else
			JOptionPane.showMessageDialog(null, "No such B_no found ");
	} // end of if of overallchk==sumchk
	else
	{
		JOptionPane.showMessageDialog(null, "Nothing their to update");
		
	} 	// end of else of overallchk==sumchk
}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Wrong..."+e.getMessage());
	}

	}// end of function
	
	// Search + update Medicine over
	// Update customer Function Start
	public void updateCust()
	{  
	  try
	  {
		String name="",mobno="",addrs="";
	    long corrctnumbr=0L;
		String tempname=txtnameaddcust.getText().trim().toUpperCase();
		String tempmobno=txtmobnoaddcust.getText().trim();
		String tempaddrs=txtaddrsaddcust.getText().trim().toUpperCase();
		long custid=Long.parseLong(txtcustidaddcust.getText());
	    if(tempname.length()<3)
	    lblerrornameaddcust.setText("more than 2 characters");
	    else if(tempname.matches(("[0-9]+")))
	    lblerrornameaddcust.setText("numeric not allowed");
	    else
	    {
	    	name=tempname;
	    	lblerrornameaddcust.setText("");
	    }
	    
	    if(tempmobno.length()<5)
	    lblerrormobnoaddcust.setText("Incorrect Number");
	    else if(tempmobno.matches(("[0-9]+"))==false)
	    lblerrormobnoaddcust.setText("Incorrect Number");
	    else
	    {
	    	mobno=tempmobno;
	    	corrctnumbr=Long.parseLong(mobno);
	    	lblerrormobnoaddcust.setText("");
	    }
	    	
	    if(tempaddrs.length()<4)
	    lblerroraddrsaddcust.setText("Incorrect Address");
	    else
	    {
	    	addrs=tempaddrs;
	    	lblerroraddrsaddcust.setText("");
	    }
	    
	    
	   if(mobno.equals("")==false && name.matches("")==false && addrs.equals("")==false)
	   { 
		Class.forName("org.sqlite.JDBC");
		Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/cust_info.db");  
		String query="update customer set cust_id=?,address=? where name=? and contactno=?";   
		PreparedStatement smt=c.prepareStatement(query);   
		smt.setLong(1,custid);
		smt.setString(2,addrs);
		smt.setString(3,name.toUpperCase());
		smt.setLong(4,corrctnumbr);
		   
		int result=smt.executeUpdate();   
		   
		if(result>0)
		{
			JOptionPane.showMessageDialog(null, "Successfully Updated");
			clearAddCust();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No such customer found");
			clearAddCust();
		}
	   }
	   else if(tempmobno.equals("") || tempname.matches("") || tempaddrs.equals("") )
	   JOptionPane.showMessageDialog(null, "Enter all Details");
	} //end of try block
     catch(Exception e)	
	  {
    	 JOptionPane.showMessageDialog(null, "Not Updated");
	  }
	  
	} // end of update customer function
	
	// code of search + remove cust start
	class EventHandleSearchRemoveCust implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==btnexitsearchcust)
			System.exit(0);
			else if(e.getSource()==btnbacksearchcust)
			{   
				cardLayout.show(pall, "choices");
				clearSearchRemoveCust();
			}
			else if(e.getSource()==btnclearsearchcust)
			clearSearchRemoveCust();
			else if(e.getSource()==btnremovesearchcust)
			{
				removeCust();
				clearSearchRemoveCust();
			}
			else if(e.getSource()==btnsearchsearchcust)
			searchCust();
			
		}
	}
	public void callEventSearchCust()
	{
		EventHandleSearchRemoveCust eh=new EventHandleSearchRemoveCust();
		btnexitsearchcust.addActionListener(eh);
		btnbacksearchcust.addActionListener(eh);
		btnclearsearchcust.addActionListener(eh);
		btnremovesearchcust.addActionListener(eh);
		btnsearchsearchcust.addActionListener(eh);
	}
	public void SearchRemoveCust()
	{
		colorFontOperationSearchRemoveCustomer();
		addonSearchRemoveCust();
		callEventSearchCust();
	}
	public void putOnSearchRemoveCust(int x,int y,JComponent c)
	{   gbc.anchor=GridBagConstraints.NORTHWEST;
	    gbc.insets=new Insets(8,8,29,12);
		gbc.gridx=x;
		gbc.gridy=y;
		gbl.setConstraints(c,gbc);
	    psearchremovecust.add(c);
		
	}
	
	
	public void colorFontOperationSearchRemoveCustomer()
	{
		Font fo=new Font("Imprint MT Shadow",Font.BOLD,30);
		Color font=new Color(255,74,0);
		JComponent[] component= {lblmobnosearchcust,txtmobnosearchcust,lblnamesearchcust,
				lbladdrssearchcust,txtaddrssearchcust,txtnamesearchcust,lblcustidsearchcust
				,txtcustidsearchcust,lblheadsearchcust,btnsearchsearchcust,
				btnremovesearchcust,btnclearsearchcust,btnbacksearchcust,btnexitsearchcust};
		
		for(JComponent c:component)
		{
			c.setFont(fo);
			c.setForeground(font);
		}
	}
	public void addonSearchRemoveCust()
	{   putOnSearchRemoveCust(1,1,lblheadsearchcust);
	    
	    pcustidsearchcust.add(lblcustidsearchcust);
	    txtcustidsearchcust.setEditable(false);
	    pcustidsearchcust.add(txtcustidsearchcust);
	    putOnSearchRemoveCust(1,2, pcustidsearchcust);
	    
		pnamesearchcust.add(lblnamesearchcust); 
		pnamesearchcust.add(txtnamesearchcust); 
		//pnameaddcust.add(lblerrornameaddcust);
		putOnSearchRemoveCust(1,3,pnamesearchcust);
		
		pmobnosearchcust.add(lblmobnosearchcust);
		pmobnosearchcust.add(txtmobnosearchcust);
		//pmobnoaddcust.add(lblerrormobnoaddcust); 
		putOnSearchRemoveCust(1,4,pmobnosearchcust);
		
		paddrssearchcust.add(lbladdrssearchcust);
		paddrssearchcust.add(new JScrollPane(txtaddrssearchcust));
		//paddrssearchcust.add(lblerroraddrsaddcust);
		putOnSearchRemoveCust(1,5,paddrssearchcust);
		
		pbtnsearchcust.add(btnsearchsearchcust);  
		pbtnsearchcust.add(btnremovesearchcust);
		pbtnsearchcust.add(btnclearsearchcust);
		pbtnsearchcust.add(btnbacksearchcust);
		pbtnsearchcust.add(btnexitsearchcust);
		putOnSearchRemoveCust(1,6,pbtnsearchcust);
	}  
	
	public void clearSearchRemoveCust()
	{
		txtcustidsearchcust.setText("");
		txtnamesearchcust.setText("");
		txtmobnosearchcust.setText("");
		txtaddrssearchcust.setText("");
		//lblerrornamesearchcust.setText("");
		//lblerrormobnoaddcust.setText("");
		//lblerroraddrsaddcust.setText("");
	}
	
	public void removeCust()
	{
		try
		{
			String name="";
			long mobno=0;
			name=txtnamesearchcust.getText().trim().toUpperCase();
			mobno=Long.parseLong(txtmobnosearchcust.getText().trim());
			if(name.length()>2 && txtmobnosearchcust.getText().trim().length()>4)
			{   
				Class.forName("org.sqlite.JDBC");
				Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/cust_info.db");
				String query="delete from customer where name=? and contactno=?";
				PreparedStatement smt=c.prepareStatement(query);
				smt.setString(1,name);
				smt.setLong(2,mobno);
				int result=smt.executeUpdate();
				if(result>0)
				JOptionPane.showMessageDialog(null, "Customer Removed");
				else
				JOptionPane.showMessageDialog(null, "No such record found..");
				
			}
			else
			JOptionPane.showMessageDialog(null, "No such record found..");	
		}
		catch(Exception e)
		{
			
		}
	} // remove customer function over
	
	// Search customer function start
	public void searchCust()
	{
		try
		{
			String name="";
			long mobno=0;
			name=txtnamesearchcust.getText().trim().toUpperCase();
			mobno=Long.parseLong(txtmobnosearchcust.getText().trim());
			if(name.length()>2 && txtmobnosearchcust.getText().trim().length()>4)
			{   int count=0;
				Class.forName("org.sqlite.JDBC");
				Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/cust_info.db");
				String query="select cust_id,address from customer where name=? and contactno=?";
				PreparedStatement smt=c.prepareStatement(query);
				smt.setString(1,name);
				smt.setLong(2,mobno);
				ResultSet rs = smt.executeQuery();
				while(rs.next())
				{
					txtcustidsearchcust.setText(rs.getLong(1)+"");
					txtaddrssearchcust.setText(rs.getString(2));
					count++;
				}
				
				if(count==0)
				JOptionPane.showMessageDialog(null, "No such record found");
				
			}
			else
			JOptionPane.showMessageDialog(null, "No such record found");
		}// try block over
		catch(Exception e)
		{
			
		}
	}
	// Search customer function over
	// Place oder code Start.......................
	
	class EventHandlePlaceOrder implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				if(e.getSource()==btnexitplaceorder)
				System.exit(0);
				else if(e.getSource()==btnbackplaceorder)
				{
					cardLayout.show(pall, "choices");
					clearPlaceOrder();
				}
				else if(e.getSource()==btnclearplaceorder)
				{
					clearPlaceOrder();
				}
				else if(e.getSource()==btnprintplaceorder)
				{
					String x=searchCustPlaceOrder();
					if(x.equals("No") || x.equals(""))
					JOptionPane.showMessageDialog(null, "First Add this customer..");
					else
					JOptionPane.showMessageDialog(null, x);
				}
				else if(e.getSource()==btnaddplaceorder)
				{
					searchMediPlaceOrder();
				}
			}
			catch(Exception a)
			{
				
			}
				
		}
	
	} // end of class EventHandlePlaceOrder
	
	public void callPlaceOrderActionListener()
	{
		EventHandlePlaceOrder a=new EventHandlePlaceOrder();
		btnexitplaceorder.addActionListener(a);
		btnbackplaceorder.addActionListener(a);
		btnclearplaceorder.addActionListener(a);
		btnprintplaceorder.addActionListener(a);
		btnaddplaceorder.addActionListener(a);
	}
	
	public void clearPlaceOrder()
	{
		txtmedinameplaceorder.setText("");
		txtnameplaceorder.setText("");
		txtmobplaceorder.setText("");
		txtqtyplaceorder.setText("");
	}
	
	public void callPlaceOrderFrame()
	{
		colorFontOperationPlaceOrder();
		addonPlaceOrder();
		callPlaceOrderActionListener();
	}
	public void putOnPlaceOrder(int x,int y,JComponent c)
	{   gbc.anchor=GridBagConstraints.NORTHWEST;
	    gbc.insets=new Insets(5,5,5,5);
		gbc.gridx=x;
		gbc.gridy=y;
		gbl.setConstraints(c,gbc);
	    pplaceorder.add(c);
		
	}
	
	
	public void colorFontOperationPlaceOrder()
	{
		Font fo=new Font("Imprint MT Shadow",Font.BOLD,25);
		Color font=new Color(255,74,0);
		JComponent[] component= {lblheadplaceorder,lblnameplaceorder,lblmobplaceorder
		,lblmedinameplaceorder,lblqtyplaceorder,txtmedinameplaceorder,txtnameplaceorder
		,txtmobplaceorder,txtqtyplaceorder,btnclearplaceorder,btnaddplaceorder,
		btnexitplaceorder,btnbackplaceorder,btnprintplaceorder};
		
		for(JComponent c:component)
		{
			c.setFont(fo);
			c.setForeground(font);
		}
	}
	public void addonPlaceOrder()
	{
		putOnPlaceOrder(2,1,lblheadplaceorder);
		
		pnameplaceorder.add(lblnameplaceorder);
		pnameplaceorder.add(txtnameplaceorder);
		putOnPlaceOrder(2,2,pnameplaceorder);
		
		pmobplaceorder.add(lblmobplaceorder);
		pmobplaceorder.add(txtmobplaceorder);
		putOnPlaceOrder(2,3,pmobplaceorder);
		
		pmedinameplaceorder.add(lblmedinameplaceorder);
		pmedinameplaceorder.add(txtmedinameplaceorder);
		putOnPlaceOrder(2,4,pmedinameplaceorder);
		
		pqtyplaceorder.add(lblqtyplaceorder);
		pqtyplaceorder.add(txtqtyplaceorder);
		putOnPlaceOrder(2,5,pqtyplaceorder);
		
		ptableplaceordr.add(tabelsearchmedi);
		putOnPlaceOrder(2,6,ptableplaceordr);
		
		pbtnplaceorder.add(btnaddplaceorder);
		pbtnplaceorder.add(btnprintplaceorder);
		pbtnplaceorder.add(btnclearplaceorder);
		pbtnplaceorder.add(btnbackplaceorder);
		pbtnplaceorder.add(btnexitplaceorder);
		putOnPlaceOrder(2,6,pbtnplaceorder);
	}
	
	public String searchCustPlaceOrder()
	{
		try
		{   String detail="";
			String name="";
			long mobno=0;
			name=txtnameplaceorder.getText().trim().toUpperCase();
			mobno=Long.parseLong(txtmobplaceorder.getText().trim());
			if(name.length()>2 && txtmobplaceorder.getText().trim().length()>4)
			{   int count=0;
				Class.forName("org.sqlite.JDBC");
				Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/cust_info.db");
				String query="select cust_id,address from customer where name=? and contactno=?";
				PreparedStatement smt=c.prepareStatement(query);
				smt.setString(1,name);
				smt.setLong(2,mobno);
				ResultSet rs = smt.executeQuery();
				while(rs.next())
				{
					 detail = rs.getLong(1)+"!"+rs.getString(2);
					count++;
				}
				
			if(count==0)
			return "No";
			else 
			return detail;
				//JOptionPane.showMessageDialog(null, "First Add this customer...","Status",JOptionPane.INFORMATION_MESSAGE);
				
			}
			else
			return "No";
				
		}// try block over
		catch(Exception e)
		{
			return "No";
		}
		
	}// searchCustPlaceOrder() over
	
	public void searchMediPlaceOrder()
	{
		try
		{   ArrayList<String[]> rows = new ArrayList<String[]>();
			Class.forName("org.sqlite.JDBC");
			Connection c=DriverManager.getConnection("jdbc:sqlite:D:/CustomerProject/medi_info.db");
			//Statement stmt = c.createStatement();
			 String query="Select * from medicines where name=?";
			 PreparedStatement smt=c.prepareStatement(query);
			 smt.setString(1,txtmedinameplaceorder.getText().trim());
			 
			 ResultSet rs = smt.executeQuery();
			 while(rs.next())
			 {
				String[] row= {rs.getString(1),rs.getString(2),rs.getInt(3)+"",
						rs.getString(4),rs.getString(5),rs.getFloat(6)+""};
				rows.add(row);
			 }
		   	rs.close();
		     // stmt.close();
		      c.close();
		     
		      if(rows.isEmpty()==false)
		      {
		      
		      String[][] data = new String[rows.size()][];
				int r=0;
				for(String[] row : rows)
				{
					data[r] = row;
					r++;
				}
				String[] headers = {"B_No","NAME","Qty", "MFD","Expiery Date","MRP"};
				//JOptionPane.showMessageDialog(null, data);
				modelplaceorder=new DefaultTableModel(data,headers);
				tableplaceorder=new JTable(modelplaceorder);
				JOptionPane.showMessageDialog(null, tableplaceorder);
		      } // end of if
		      else
		      JOptionPane.showMessageDialog(null,"Not in stock...");
		}// end of try block
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Something Went Wrong..."+e.getMessage());
		}
		
		
   }
	
	
	
}// class HealthPlusWork over

public class HealthPlus 
{
	
	public static void main(String[] args) 
	{   
		HealthPlusWork login=new HealthPlusWork();
		login.colorFontOperationLogin();
		login.addonLogin();
		login.show();
		login.eventHandling();
		//JOptionPane.showMessageDialog(null, new java.util.Date());
		//login.threadCall()		
		// Login function ends

	}
}

//System.currentTimeMillis()
//putOnAddMedicine(1,5,lblexpdaddmedicine);
//putOnAddMedicine(1,6,lblpriceaddmedicine);
//putOnAddMedicine(2,2,);
//putOnAddMedicine(2,3,);
//putOnAddMedicine(2,6,txtpricead;dmedi);


















