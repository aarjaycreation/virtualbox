import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener
{
	public Connection con;
	public String query;
	PreparedStatement ps;
	
	Choice c1;
	JPanel p1;
	JTextField t1,t2;
	JLabel l1,l2,l3;
	JButton  b1;
	
	public ForgotPassword()
	{
		p1=new JPanel();
		
		c1=new Choice();
		t1=new JTextField();
		t2=new JTextField();
		
		l1= new JLabel("Enter User Id");
		l2= new JLabel("Select Personal Question");
		l3= new JLabel("Enter Answer");
		
		b1=new JButton("Submit");
		
		
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(c1);
		p1.add(l3);
		p1.add(t2);
		
		setLayout (new BorderLayout());
		p1.setLayout(new GridLayout(3,2));
		
		add(p1,"Center");
		add(b1,"South");
		b1.addActionListener(this);
		
		
		setSize(400,400);
		setTitle("Set New Password");
		setVisible(true);
		loadq();
	}
	
	public void loadq()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","0000");
			Statement st=con.createStatement();
			query="select distinct secretq from emp";
					
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next())
			{
				c1.add(rs.getString(1));
			}
		}catch(Exception eq){}
	
	}
	

	public void actionPerformed(ActionEvent ae)
	{	
		String userans=t2.getText();     //userans="bmw";
		String userno=t1.getText();     //userno="ben@gmail.com"
		String dbans="";
		try{
			
		
		query ="select ans from emp where eno like ?";
		ps=con.prepareStatement(query);
		ps.setString(1,userno);
		ResultSet rs1=ps.executeQuery();
		if(rs1.next())
			{
		dbans=rs1.getString(1);			//dbans="bmw";
			}

		if(dbans.equalsIgnoreCase(userans))
		{
		new ResetPassword(userno);
		dispose();
		//JOptionPane.showMessageDialog(this,"Password RESET success","Employee Form",JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
		JOptionPane.showMessageDialog(this,"Answer not Matching","Employee Form",JOptionPane.INFORMATION_MESSAGE);
		}
		}
		catch(Exception eq2){}

		
	}
	public static void main(String args[])
	{
		new ForgotPassword();
	}
}
