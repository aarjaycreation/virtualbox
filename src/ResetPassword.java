import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ResetPassword extends JFrame implements ActionListener
{
	String uid;
	public Connection con;
	public String query;
	PreparedStatement ps;
	
	
	JPanel p1;
	JTextField t1,t2;
	JLabel l1,l2;
	JButton  b1;
	
	public ResetPassword(String a)
	{
		uid=a;
		setLayout(new BorderLayout());
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(2,2));
		
		
		t1=new JTextField();
		t2=new JTextField();
		
		l1= new JLabel("Enter New Password");
		l2= new JLabel("Renter Enter New Password");
		
		
		b1=new JButton("RESET PASSWORD");
		
		
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		
		add(p1,"Center");
		add(b1,"South");
		b1.addActionListener(this);
		
		
		setSize(400,400);
		setTitle("Reset Password");
		setVisible(true);
	}
	
	

	public void actionPerformed(ActionEvent ae)
	{	
		Object ob=ae.getSource();
		if(ob==b1)
		{
			
		String p=t1.getText();
		String cp=t2.getText();
		try
		{
			if(p.equals(cp))
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","0000");
				
				query="update emp set passwd=? where eno=?";
				ps=con.prepareStatement(query);
				ps.setString(1,p);
				ps.setString(2,uid);
				int n=ps.executeUpdate();
				if(n==1)
				{
				JOptionPane.showMessageDialog(this,"Password RESET success","Employee Form",JOptionPane.INFORMATION_MESSAGE);	
				}
			}
			
			else
			{
			JOptionPane.showMessageDialog(this,"PASSWORD not Matching","Employee Form",JOptionPane.INFORMATION_MESSAGE);	
			}
		}	
		
		catch(Exception eq2){}

		}
	}
}
