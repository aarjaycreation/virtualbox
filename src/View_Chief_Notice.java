import java.io.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class View_Chief_Notice extends JInternalFrame implements ActionListener

{
	JLabel title=new JLabel("View Chief Notice",JLabel.CENTER);

	JComboBox com1=new JComboBox();
	JComboBox com2=new JComboBox();

	JLabel l1=new JLabel("Select Chief Member :",JLabel.RIGHT);
	JLabel l2=new JLabel("Designation :",JLabel.RIGHT);
	JLabel l3=new JLabel();
	JLabel l4=new JLabel("Select Year & Batch :",JLabel.RIGHT);

	JTextArea ta=new JTextArea();

	Connection con,con1,con2,con3;
	Statement st,st1,st2,st3;
	ResultSet rs,rs1,rs2,rs3;
	ResultSetMetaData rsmt,rsmt1,rsmt2,rsmt3;


	View_Chief_Notice()
	{
		super("View Chief Notice",false,true,false,true);

		Container c=getContentPane();
		c.setLayout(null);

		com1.addItem("");
		dataConnection();
		Com1Show();

		JScrollPane js=new JScrollPane(ta);
		ta.setForeground(Color.black);
		ta.setBackground(Color.white);
		js.setBounds(10,140,370,160);
		c.add(js);

		title.setBounds(10,5,370,35);

		l1.setBounds(10,50,170,20);
		com1.setBounds(200,50,180,20);

		l2.setBounds(10,80,170,20);
		l3.setBounds(200,80,180,20);

		l4.setBounds(10,110,170,20);
		com2.setBounds(200,110,180,20);

		com1.addActionListener(this);
		com2.addActionListener(this);

		c.add(title);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(com1);
		c.add(com2);

        title.setFont(new Font("Dialog", 1, 20));
        title.setBorder(BorderFactory.createRaisedBevelBorder());
		title.setForeground(Color.blue);
		title.setBackground(Color.red);

		ta.setFont(new Font("Dialog", 0, 14));

		com2.setEnabled(false);

		l3.setBorder(BorderFactory.createRaisedBevelBorder());
		l3.setForeground(Color.black);
		l3.setBackground(Color.pink);

		com1.setBorder(BorderFactory.createRaisedBevelBorder());
		com2.setBorder(BorderFactory.createRaisedBevelBorder());

		setBackground(Color.pink);
		setSize(400,340);
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
			rs=st.executeQuery("select * from Chief ");
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


	public void actionPerformed(ActionEvent e)
	{


		if(e.getSource()==com1)
		{
			com1.removeItem("");
			com2.setEnabled(true);
			com2.removeAllItems();
			dataConnection1();
			dataConnection3();
			ta.setText("");
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

