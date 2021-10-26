import java.io.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class Edit_Official_Account extends JInternalFrame implements ActionListener

{
	JLabel title=new JLabel("Edit/Delete Official Account",JLabel.CENTER);

	JComboBox com1=new JComboBox();

	JLabel l1=new JLabel("Select Official Member :",JLabel.RIGHT);
	JLabel l2=new JLabel("Password :",JLabel.RIGHT);
	JLabel l3=new JLabel("Verify Password :",JLabel.RIGHT);
	JLabel l4=new JLabel("Designation :",JLabel.RIGHT);

	JTextField t1=new JPasswordField();
	JTextField t2=new JPasswordField();
	JTextField t3=new JTextField();

	JButton b1=new JButton("Update Existing");
	JButton b2=new JButton("Delete Existing");

	Connection con,con1,con2,con3,con4,con5,con6,con7;
	Statement st,st1,st2,st3,st4,st5,st6,st7;
	ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,rs7;
	ResultSetMetaData rsmt,rsmt1,rsmt2,rsmt3,rsmt4,rsmt5,rsmt6;
	String okay;

	Edit_Official_Account()
	{
		super("Edit/Delete Official Account",false,true,false,true);

		Container c=getContentPane();
		c.setLayout(null);

		com1.addItem("");
		dataConnection();
		Com1Show();


		title.setBounds(10,5,370,35);

		l1.setBounds(10,50,170,20);
		com1.setBounds(200,50,180,20);

		l2.setBounds(10,80,170,20);
		t1.setBounds(200,80,180,20);

		l3.setBounds(10,110,170,20);
		t2.setBounds(200,110,180,20);

		l4.setBounds(10,140,170,20);
		t3.setBounds(200,140,180,20);

		b1.setBounds(10,180,180,25);
		b2.setBounds(200,180,180,25);

		com1.addActionListener(this);

		b1.addActionListener(this);
		b1.setMnemonic('A');
		b2.addActionListener(this);
		b2.setMnemonic('D');


		c.add(title);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(com1);
		c.add(b1);
		c.add(b2);

        title.setFont(new Font("Dialog", 1, 20));
        title.setBorder(BorderFactory.createRaisedBevelBorder());
		title.setForeground(Color.blue);
		title.setBackground(Color.red);


		b1.setEnabled(false);
		b2.setEnabled(false);
		t1.setEnabled(false);
		t2.setEnabled(false);
		t3.setEnabled(false);


		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBorder(BorderFactory.createRaisedBevelBorder());
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBorder(BorderFactory.createRaisedBevelBorder());


		setBackground(Color.white);
		setSize(400,250);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2-50);
		setResizable(false);
		show();
	}



	public void dataConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost/db","root","0000");
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery("select * from FacOff where Type='Official'");
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
		rs7=st7.executeQuery("select * from FacOff where FO_Name='"+tryname+"'");
		try{
		while(rs7.next())
		{
		okay=(rs7.getString(2));
		}}catch(Exception e555555){}

		if (trypass.equals(okay))
		{
			com1.removeItem("");

			b1.setEnabled(true);
			b2.setEnabled(true);

			t1.setEnabled(true);
			t2.setEnabled(true);
			t2.setText("");
			t3.setEnabled(true);

			dataConnection1();
			dataConnection3();
			try
			{
				String comname=((String)com1.getSelectedItem());
				rs1=st1.executeQuery("select * from FacOff where FO_Name='"+comname+"'");

				while(rs1.next())
				{
					t1.setText(rs1.getString(2));
					t3.setText(rs1.getString(3));
				}
			}
			catch(Exception e5)
			{
				System.out.print(e5);
			}

		}
		else JOptionPane.showMessageDialog(this,"Invalid Password !!!");
		}catch(Exception e555){}
		}



		if(e.getSource()==b1)
		{
			try
			{
				String s1=t1.getText();
			if((t1.getText().equals("")) || (t2.getText().equals("")) || (t3.getText().equals("")))
			JOptionPane.showMessageDialog(this,"Must fill all the fields.");
			else
			if(s1.length()<6)
			JOptionPane.showMessageDialog(this,"Password must be more than 6 character");
			
			else
			{
			try
			{
			String pass1=t1.getText();
			String pass2=t2.getText();
			if(pass1.equals(pass2))
			{
			try
			{
				dataConnection4();
				String comname=(String)com1.getSelectedItem();

				String query="update FacOff set FO_Password='"+t1.getText()+"',FO_Designation='"+t3.getText()+"'where FO_Name='"+comname+"'";

				int result=st4.executeUpdate(query);
				if(result==1)
				JOptionPane.showMessageDialog(this,"Records Updated Successfully.");
			}catch(Exception e8){}
			}
			else
			JOptionPane.showMessageDialog(this,"Both passwords are not same. Enter again.");
			}catch(Exception e88){}
			}
			}catch(Exception e888){}
		}


		if(e.getSource()==b2)
		{
			try
			{
				dataConnection6();
				String comname=(String)com1.getSelectedItem();

				String query="delete from FacOff where FO_Name='"+comname+"'";

				int result=st6.executeUpdate(query);
				if(result==1)
				JOptionPane.showMessageDialog(this,"Records Deleted Successfully.");
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

