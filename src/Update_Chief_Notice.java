import java.io.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class Update_Chief_Notice extends JInternalFrame implements ActionListener

{
	JLabel title=new JLabel("Update Chief Notice",JLabel.CENTER);

	JComboBox com1=new JComboBox();
	JComboBox com2=new JComboBox();

	JLabel l1=new JLabel("Chief Name :",JLabel.RIGHT);
	JLabel l2=new JLabel("Designation :",JLabel.RIGHT);
	JLabel l3=new JLabel();
	JLabel l4=new JLabel("Select Year & Batch :",JLabel.RIGHT);
	JLabel l5=new JLabel("Enter Year :",JLabel.RIGHT);
	JLabel l6=new JLabel("Enter Batch No :",JLabel.RIGHT);

	JTextArea ta=new JTextArea();
	JTextField t1=new JTextField("0");
	JTextField t2=new JTextField("0");

	JButton b1=new JButton("Add New");
	JButton b2=new JButton("Update Existing");
	JButton b3=new JButton("Delete Existing");

	Connection con,con1,con2,con3,con4,con5,con6,con7;
	Statement st,st1,st2,st3,st4,st5,st6,st7;
	ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,rs7;
	ResultSetMetaData rsmt,rsmt1,rsmt2,rsmt3,rsmt4,rsmt5,rsmt6;
	String okay;

	Update_Chief_Notice()
	{
		super("Update Chief Notice",false,true,false,true);

		Container c=getContentPane();
		c.setLayout(null);

		com1.addItem("");
		dataConnection();
		Com1Show();

		JScrollPane js=new JScrollPane(ta);
		ta.setForeground(Color.black);
		ta.setBackground(Color.white);
		js.setBounds(10,200,370,160);
		c.add(js);

		title.setBounds(10,5,370,35);

		l1.setBounds(10,50,170,20);
		com1.setBounds(200,50,180,20);

		l2.setBounds(10,80,170,20);
		l3.setBounds(200,80,180,20);

		l4.setBounds(10,110,170,20);
		com2.setBounds(200,110,180,20);

		l5.setBounds(20,170,100,20);
		t1.setBounds(140,170,40,20);
		l6.setBounds(220,170,100,20);
		t2.setBounds(340,170,40,20);

		b1.setBounds(10,140,110,20);
		b2.setBounds(140,140,110,20);
		b3.setBounds(270,140,110,20);

		com1.addActionListener(this);
		com2.addActionListener(this);

		b1.addActionListener(this);
		b1.setMnemonic('A');
		b2.addActionListener(this);
		b2.setMnemonic('U');
		b3.addActionListener(this);
		b3.setMnemonic('D');

		c.add(title);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(t1);
		c.add(t2);
		c.add(com1);
		c.add(com2);
		c.add(b1);
		c.add(b2);
		c.add(b3);

        title.setFont(new Font("Dialog", 1, 20));
        title.setBorder(BorderFactory.createRaisedBevelBorder());
		title.setForeground(Color.blue);
		title.setBackground(Color.red);

		ta.setFont(new Font("Dialog", 0, 14));

		com2.setEnabled(false);
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		t1.setEnabled(false);
		t2.setEnabled(false);
		ta.setEnabled(false);

		l3.setBorder(BorderFactory.createRaisedBevelBorder());
		l3.setForeground(Color.black);
		l3.setBackground(Color.black);

		com1.setBorder(BorderFactory.createRaisedBevelBorder());
		com2.setBorder(BorderFactory.createRaisedBevelBorder());

		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBorder(BorderFactory.createRaisedBevelBorder());
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBorder(BorderFactory.createRaisedBevelBorder());
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setBorder(BorderFactory.createRaisedBevelBorder());


		setBackground(Color.pink);
		setSize(400,400);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2-50);
		setResizable(false);
		show();
	}



	public void dataConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","0000");
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery("select * from Chief");
		}
		catch(Exception ce)
		{
			JOptionPane.showMessageDialog(null,ce);
		}
	}


	public void dataConnection1()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        con1=DriverManager.getConnection("jdbc:mysql://localhost/db","root","0000");
			st1=con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception ce1)
		{
			JOptionPane.showMessageDialog(null,ce1);
		}
	}


	public void dataConnection2()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        con2=DriverManager.getConnection("jdbc:mysql://localhost/db","root","0000");
			st2=con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception ce2)
		{
			JOptionPane.showMessageDialog(null,ce2);
		}
	}


	public void dataConnection3()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        con3=DriverManager.getConnection("jdbc:mysql://localhost/db","root","0000");
			st3=con3.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception ce3)
		{
			JOptionPane.showMessageDialog(null,ce3);
		}
	}


	public void dataConnection4()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        con4=DriverManager.getConnection("jdbc:mysql://localhost/db","root","0000");
			st4=con4.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs4=st4.executeQuery("select * from Notice");
		}
		catch(Exception ce4)
		{
			JOptionPane.showMessageDialog(null,ce4);
		}
	}


	public void dataConnection5()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        con5=DriverManager.getConnection("jdbc:mysql://localhost/db","root","0000");
			st5=con5.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs5=st5.executeQuery("select * from Notice");
		}
		catch(Exception ce5)
		{
			JOptionPane.showMessageDialog(null,ce5);
		}
	}


	public void dataConnection6()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        con6=DriverManager.getConnection("jdbc:mysql://localhost/db","root","0000");
			st6=con6.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs6=st6.executeQuery("select * from Notice");
		}
		catch(Exception ce6)
		{
			JOptionPane.showMessageDialog(null,ce6);
		}
	}


	public void dataConnection7()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        con7=DriverManager.getConnection("jdbc:mysql://localhost/db","root","0000");
			st7=con7.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception ce7)
		{
			JOptionPane.showMessageDialog(null,ce7);
		}
	}




	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==com1)
		{
		try
		{
		dataConnection7();
		String trypass=JOptionPane.showInputDialog(this,"Enter Password for Notice Update:");
		String tryname=((String)com1.getSelectedItem());
		rs7=st7.executeQuery("select * from Chief where C_Name='"+tryname+"'");
		try{
		while(rs7.next())
		{
		okay=(rs7.getString(2));
		}}catch(Exception e555555){}

		if (trypass.equals(okay))
		{
			com1.removeItem("");
			com2.setEnabled(true);
			com2.removeAllItems();
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			ta.setEnabled(true);
			ta.setText("");
			dataConnection1();
			dataConnection3();
			try
			{
				String comname=((String)com1.getSelectedItem());
				rs1=st1.executeQuery("select * from Notice where N_Name='"+comname+"'");

				while(rs1.next())
				{
					com2.addItem((Object)rs1.getString(2));
				}
			}
			catch(Exception e5)
			{
				System.out.print(e5);
			}


			try
			{
				String comname=((String)com1.getSelectedItem());
				rs3=st3.executeQuery("select * from Chief where C_Name='"+comname+"'");

				while(rs3.next())
				{
					l3.setText(rs3.getString(3));
				}
			}
			catch(Exception e55)
			{
				System.out.print(e55);
			}
		}
		else JOptionPane.showMessageDialog(this,"Invalid Password !!!");
		}catch(Exception e555){}
		}



		if(e.getSource()==com2)
		{
			dataConnection2();

			try
			{
				String comname=(String)com1.getSelectedItem();
				String comyear=(String)com2.getSelectedItem();
				rs2=st2.executeQuery("select * from Notice where N_Name='"+comname+"' and YearBatch='"+comyear+"'");

				while(rs2.next())
				{
					ta.setText(rs2.getString(3));
				}
			}
			catch(Exception e6)
			{
				System.out.print(e6);
			}
		}



		if(e.getActionCommand().equals("Add New"))
		{
			b2.setEnabled(false);
			b3.setEnabled(false);
			com1.setEnabled(false);
			com2.setEnabled(false);
			t1.setEnabled(true);
			t2.setEnabled(true);
			t1.setText("");
			t2.setText("");
			ta.setText("");
			b1.setText("Save");
		}



		if(e.getActionCommand().equals("Save"))
		{
			try
			{
			if((t1.getText().equals("")) || (t2.getText().equals("")) || (ta.getText().equals("")))
			JOptionPane.showMessageDialog(this,"Must fill all the fields.");
			else
			{
			try
			{
				dataConnection5();
				String comname=(String)com1.getSelectedItem();
				String yearbatch="Year: "+t1.getText()+"     "+"Batch: "+t2.getText();
				String notice=ta.getText();

				String query="insert into Notice Values('"+comname+"','"+yearbatch+"','"+notice+"')";
				int result=st5.executeUpdate(query);
				if(result==1)
				JOptionPane.showMessageDialog(this,"Records Added Successfully.");

				t1.setText("");
				t2.setText("");
				ta.setText("");
				b2.setEnabled(true);
				b3.setEnabled(true);
				com1.setEnabled(true);
				com2.setEnabled(true);
				t1.setEnabled(false);
				t2.setEnabled(false);

				b1.setText("Add New");
			}catch(Exception e7){}
			dataConnection1();
			dataConnection3();
			try
			{
				com2.removeAllItems();
				String com2name=((String)com1.getSelectedItem());
				rs1=st1.executeQuery("select * from Notice where N_Name='"+com2name+"'");

				while(rs1.next())
				{
					com2.addItem((Object)rs1.getString(2));
				}
			}
			catch(Exception e5)
			{
				System.out.print(e5);
			}
			}
			}catch(Exception e77){}
		}



		if(e.getSource()==b2)
		{
			try
			{
				dataConnection4();
				String comname=(String)com1.getSelectedItem();
				String comyear=(String)com2.getSelectedItem();

				String query="update Notice set Notice='"+ta.getText()+"' where N_Name='"+comname+"'and YearBatch='"+comyear+"'";

				int result=st4.executeUpdate(query);
				if(result==1)
				JOptionPane.showMessageDialog(this,"Records Updated Successfully.");
			}catch(Exception e8){}
			
		}


		if(e.getSource()==b3)
		{
			try
			{
				dataConnection6();
				String comname=(String)com1.getSelectedItem();
				String comyear=(String)com2.getSelectedItem();

				String query="delete from Notice where N_Name='"+comname+"' and YearBatch='"+comyear+"'";

				int result=st6.executeUpdate(query);
				if(result==1)
				JOptionPane.showMessageDialog(this,"Records Deleted Successfully.");
				
				dataConnection1();
			dataConnection3();
			try
			{com2.removeAllItems();
				String com2name=((String)com1.getSelectedItem());
				rs1=st1.executeQuery("select * from Notice where N_Name='"+com2name+"'");

				while(rs1.next())
				{
					com2.addItem((Object)rs1.getString(2));
				}
			}
			catch(Exception e5)
			{
				System.out.print(e5);
			}
			}catch(Exception e9){}
		}
	}


	public void Com1Show()
	{
		try
		{
			while(rs.next())
			{
				com1.addItem((Object)rs.getString(1));
			}
		}
		catch(Exception e4)
		{
			System.out.print(e4);
		}
	}
}

