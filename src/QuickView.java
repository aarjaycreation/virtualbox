import java.io.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


class TableShow extends JFrame

{
	JLabel title2;
	JTable t;

	TableShow(String row_Data[][], String col_Name[],String s1)
	{
		 title2=new JLabel("View In Table of "+s1,JLabel.CENTER);
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
		setTitle("View In Table");
		show();
	}
}


public class QuickView extends JInternalFrame implements ActionListener

{

	JLabel title=new JLabel("Quick View By Table",JLabel.CENTER);

	JCheckBox rb1=new JCheckBox("Chief Notice");
	JCheckBox rb2=new JCheckBox("Faculty Notice");
	JCheckBox rb3=new JCheckBox("Official Notice");

	JButton b1=new JButton("Show In Table");

	Connection con;
	Statement st;
	ResultSet rs;
	ResultSetMetaData rsmt;

	String col_Name[]=new String[20];
	String row_Data[][]=new String[20][20];
	int j=0;


  	QuickView()
  	{

		super("Quick View By Table",false,true,false,true);

		Container c=getContentPane();
		c.setLayout(null);

		dataConnection();

		title.setBounds(10,5,370,35);

   		rb1.setBounds(100,60,200,30);
   		rb2.setBounds(100,100,200,30);
   		rb3.setBounds(100,140,200,30);

        b1.setBounds(125,190,150,20);
		b1.addActionListener(this);
		b1.setMnemonic('S');

		c.add(title);

		c.add(rb1);
		c.add(rb2);
		c.add(rb3);

		c.add(b1);

        title.setFont(new Font("Dialog", 1, 20));
        title.setBorder(BorderFactory.createRaisedBevelBorder());
		title.setForeground(Color.blue);
		title.setBackground(Color.red);


        rb1.setFont(new Font("Dialog", 1, 16));
        rb1.setBorder(BorderFactory.createRaisedBevelBorder());
		rb1.setForeground(Color.black);
		rb1.setBackground(Color.pink);

        rb2.setFont(new Font("Dialog", 1, 16));
        rb2.setBorder(BorderFactory.createRaisedBevelBorder());
		rb2.setForeground(Color.black);
		rb2.setBackground(Color.pink);

        rb3.setFont(new Font("Dialog", 1, 16));
        rb3.setBorder(BorderFactory.createRaisedBevelBorder());
		rb3.setForeground(Color.black);
		rb3.setBackground(Color.pink);

		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBorder(BorderFactory.createRaisedBevelBorder());

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
 		}
 		catch(Exception ce)
 		{
 			JOptionPane.showMessageDialog(null,ce);
 		}
	}



	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				if(rb1.isSelected())
				{
					int ss1=0;
					rs=st.executeQuery("select Notice.N_Name,Notice.YearBatch,Notice.Notice from Chief,Notice where Chief.C_Name=Notice.N_Name");
					rsmt=rs.getMetaData();
					int s22=rsmt.getColumnCount();

					col_Name=new String[s22];
					rs=st.executeQuery("select count(YearBatch) from Notice");

					if(rs.next())
			 		ss1=rs.getInt(1);
					row_Data=new String[ss1][s22];
					rs=st.executeQuery("Select Notice.N_Name,Notice.YearBatch,Notice.Notice From Chief,Notice where Chief.C_Name=Notice.N_Name");

					rsmt=rs.getMetaData();

					for(int i=1;i<=s22;i++)
					{
					 	col_Name[i-1]=rsmt.getColumnName(i);
					}
					j=0;
					while(rs.next())
					{
						row_Data[j][0]=rs.getString(1);
						row_Data[j][1]=rs.getString(2);
						row_Data[j][2]=rs.getString(3);
						j++;
					}
					TableShow ts=new TableShow(row_Data, col_Name,"Chief");
				}

				
				if(rb2.isSelected())
				{
					int ss1=0;
					rs=st.executeQuery("select Notice.N_Name,Notice.YearBatch,Notice.Notice from FacOff,Notice where FacOff.FO_Name=Notice.N_Name and FacOff.Type='Faculty'");
					rsmt=rs.getMetaData();
					int s22=rsmt.getColumnCount();

					col_Name=new String[s22];
					rs=st.executeQuery("select count(YearBatch) from Notice");

					if(rs.next())
			 		ss1=rs.getInt(1);
					row_Data=new String[ss1][s22];
					rs=st.executeQuery("select Notice.N_Name,Notice.YearBatch,Notice.Notice from FacOff,Notice where FacOff.FO_Name=Notice.N_Name and FacOff.Type='Faculty'");

					rsmt=rs.getMetaData();

					for(int i=1;i<=s22;i++)
					{
					 	col_Name[i-1]=rsmt.getColumnName(i);
					}
					j=0;
					while(rs.next())
					{
						row_Data[j][0]=rs.getString(1);
						row_Data[j][1]=rs.getString(2);
						row_Data[j][2]=rs.getString(3);
						j++;
					}
					TableShow ts1=new TableShow(row_Data, col_Name,"Faculty");
				}

			
				if(rb3.isSelected())
				{
					int ss1=0;
					rs=st.executeQuery("select Notice.N_Name,Notice.YearBatch,Notice.Notice from FacOff,Notice where FacOff.FO_Name=Notice.N_Name and FacOff.Type='Official'");
					rsmt=rs.getMetaData();
					int s22=rsmt.getColumnCount();

					col_Name=new String[s22];
					rs=st.executeQuery("select count(YearBatch) from Notice");

					if(rs.next())
			 		ss1=rs.getInt(1);
					row_Data=new String[ss1][s22];
					rs=st.executeQuery("select Notice.N_Name,Notice.YearBatch,Notice.Notice from FacOff,Notice where FacOff.FO_Name=Notice.N_Name and FacOff.Type='Official'");

					rsmt=rs.getMetaData();

					for(int i=1;i<=s22;i++)
					{
					 	col_Name[i-1]=rsmt.getColumnName(i);
					}
					j=0;
					while(rs.next())
					{
						row_Data[j][0]=rs.getString(1);
						row_Data[j][1]=rs.getString(2);
						row_Data[j][2]=rs.getString(3);
						j++;
					}
					TableShow ts2=new TableShow(row_Data, col_Name,"Official");
				}
			
		}//1st if
		}//try
			catch(Exception e444){}
	}//actionperformed
}//class
