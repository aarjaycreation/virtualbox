import java.io.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


class TableSearch extends JFrame

{
	JLabel title2=new JLabel("Search Result In Table",JLabel.CENTER);
	JTable t;

	TableSearch(String row_Data[][], String col_Name[])
	{
		Container c1=getContentPane();
		c1.setLayout(null);
		t=new JTable(row_Data, col_Name);
		JScrollPane js=new JScrollPane(t);

		title2.setBounds(10,5,600,35);
		js.setBounds(10,60,600,212);
		c1.add(title2);
		c1.add(js);

        title2.setFont(new Font("Dialog", 1, 20));
        title2.setBorder(BorderFactory.createRaisedBevelBorder());
		title2.setForeground(Color.blue);
		title2.setBackground(Color.red);

		t.setEnabled(false);
		setBackground(Color.black);
		setSize(630,310);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height-getHeight())/2-50);
		setResizable(false);
		setTitle("Search Result");
		show();
	}
}


public class Search extends JInternalFrame implements ActionListener

{

	JLabel title=new JLabel("Quick Search",JLabel.CENTER);

	JLabel l1=new JLabel("Enter Year :",JLabel.RIGHT);
	JLabel l2=new JLabel("Enter Batch No :",JLabel.RIGHT);

	JTextField t1=new JTextField();
	JTextField t2=new JTextField();

	JButton b1=new JButton("Search Notice");

	Connection con,con1;
	Statement st,st1;
	ResultSet rs,rs1;
	ResultSetMetaData rsmt,rsmt1;

	String col_Name[]=new String[20];
	String row_Data[][]=new String[20][20];
	int j=0;


  	Search()
  	{

		super("Quick Search",false,true,false,true);

		Container c=getContentPane();
		c.setLayout(null);

		dataConnection1();

		title.setBounds(10,5,370,35);

		l1.setBounds(20,60,100,20);
		t1.setBounds(140,60,40,20);
		l2.setBounds(220,60,100,20);
		t2.setBounds(340,60,40,20);

        b1.setBounds(125,90,150,20);
		b1.addActionListener(this);
		b1.setMnemonic('S');

		c.add(title);

		c.add(l1);
		c.add(l2);
		c.add(t1);
		c.add(t2);

		c.add(b1);

        title.setFont(new Font("Dialog", 1, 20));
        title.setBorder(BorderFactory.createRaisedBevelBorder());
		title.setForeground(Color.blue);
		title.setBackground(Color.red);

		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBorder(BorderFactory.createRaisedBevelBorder());

		setBackground(Color.pink);
		setSize(400,150);
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
 		catch(Exception ce111)
 		{
 			JOptionPane.showMessageDialog(null,ce111);
 		}
	}



	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
			try
			{
			if((t1.getText().equals("")) || (t2.getText().equals("")))
			JOptionPane.showMessageDialog(this,"Must fill all the fields.");
			else
			{
				String s=("Year: "+t1.getText()+"     "+"Batch: "+t2.getText());
				String query="select * from Notice where YearBatch='"+s+"'";
				rs1=st1.executeQuery(query);

				if(rs1.next())
				{
					dataConnection();
					int ss1=0;
					rs=st.executeQuery("select * from Notice where YearBatch='"+s+"'");
					rsmt=rs.getMetaData();
					int s22=rsmt.getColumnCount();

					col_Name=new String[s22];
					rs=st.executeQuery("select count(YearBatch) from Notice");

					if(rs.next())
			 		ss1=rs.getInt(1);
					row_Data=new String[ss1][s22];
					rs=st.executeQuery("select * from Notice where YearBatch='"+s+"'");

					rsmt=rs.getMetaData();

					for(int i=1;i<=s22;i++)
					{
					 	col_Name[i-1]=rsmt.getColumnName(i);
					}

					while(rs.next())
					{
						row_Data[j][0]=rs.getString(1);
						row_Data[j][1]=rs.getString(2);
						row_Data[j][2]=rs.getString(3);
						j++;
					}
					TableSearch ts=new TableSearch(row_Data, col_Name);
				}
				else
				JOptionPane.showMessageDialog(this,"Notice Not Available, Try Again.");
			}
			}catch(Exception e888){}
			}
		}
		catch(Exception e444){}
	}
}
