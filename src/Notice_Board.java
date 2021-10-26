import java.io.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;



class Notice_Board extends JFrame implements ActionListener
{
	JMenuBar bar;
	JMenu ViewNotice,QuickView,PrintNotice,AccountSignup,AccountEdit,NoticeUpdate,Exit;
	JMenuItem vnChief,vnFaculty,vnOfficial,qvTable,qvSearch,pnChief,pnFaculty,pnOfficial,asChief,asFaculty,asOfficial,aeChief,aeFaculty,aeOfficial,nuChief,nuFaculty,nuOfficial,xAbout,xClose;

	JDesktopPane desktop=new JDesktopPane();


	Notice_Board()
	{
		super("Virtual Notice Board");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screenSize.width,screenSize.height);

		bar=new JMenuBar();
		setJMenuBar(bar);


		ViewNotice=new JMenu("View Notice"); ViewNotice.setMnemonic('V');
		ViewNotice.setFont(new Font("Dialog", Font.BOLD, 16));

		QuickView=new JMenu ("Quick View"); QuickView.setMnemonic('Q');
		QuickView.setFont(new Font("Dialog", Font.BOLD, 16));

		PrintNotice=new JMenu ("Print Notice"); PrintNotice.setMnemonic('P');
		PrintNotice.setFont(new Font("Dialog", Font.BOLD, 16));

		AccountSignup=new JMenu ("Account Signup"); AccountSignup.setMnemonic('S');
		AccountSignup.setFont(new Font("Dialog", Font.BOLD, 16));

		AccountEdit=new JMenu ("Account Edit/Delete"); AccountEdit.setMnemonic('E');
		AccountEdit.setFont(new Font("Dialog", Font.BOLD, 16));

		NoticeUpdate=new JMenu ("Notice Manipulation"); NoticeUpdate.setMnemonic('N');
		NoticeUpdate.setFont(new Font("Dialog", Font.BOLD, 16));

		Exit=new JMenu ("About"); Exit.setMnemonic('x');
		Exit.setFont(new Font("Dialog", Font.BOLD, 16));

		vnChief=new JMenuItem ("View Chief Notice",'C');
		vnChief.setAccelerator(javax.swing.KeyStroke.getKeyStroke(67,java.awt.event.KeyEvent.CTRL_MASK));
		vnChief.addActionListener(this);
		vnFaculty=new JMenuItem("View Faculty Notice",'F');
		vnFaculty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(70,java.awt.event.KeyEvent.CTRL_MASK));
		vnFaculty.addActionListener(this);
		vnOfficial=new JMenuItem("View Official Notice",'O');
		vnOfficial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(79,java.awt.event.KeyEvent.CTRL_MASK));
		vnOfficial.addActionListener(this);

		qvTable=new JMenuItem ("By Table",'T');
		qvTable.setAccelerator(javax.swing.KeyStroke.getKeyStroke(84,java.awt.event.KeyEvent.CTRL_MASK));
		qvTable.addActionListener(this);
		qvSearch=new JMenuItem ("By Search",'S');
		qvSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(83,java.awt.event.KeyEvent.CTRL_MASK));
		qvSearch.addActionListener(this);

		pnChief=new JMenuItem ("Print Chief Notice",'C');
		pnChief.setAccelerator(javax.swing.KeyStroke.getKeyStroke(67,java.awt.event.KeyEvent.CTRL_MASK));
		pnChief.addActionListener(this);
		pnFaculty=new JMenuItem("Print Faculty Notice",'F');
		pnFaculty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(70,java.awt.event.KeyEvent.CTRL_MASK));
		pnFaculty.addActionListener(this);
		pnOfficial=new JMenuItem("Print Official Notice",'O');
		pnOfficial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(79,java.awt.event.KeyEvent.CTRL_MASK));
		pnOfficial.addActionListener(this);

		asChief=new JMenuItem ("Chief Account Signup",'C');
		asChief.setAccelerator(javax.swing.KeyStroke.getKeyStroke(67,java.awt.event.KeyEvent.CTRL_MASK));
		asChief.addActionListener(this);
		asFaculty=new JMenuItem("Faculty Account Signup",'F');
		asFaculty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(70,java.awt.event.KeyEvent.CTRL_MASK));
		asFaculty.addActionListener(this);
		asOfficial=new JMenuItem("Official Account Signup",'O');
		asOfficial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(79,java.awt.event.KeyEvent.CTRL_MASK));
		asOfficial.addActionListener(this);

		aeChief=new JMenuItem ("Chief Edit/Delete",'C');
		aeChief.setAccelerator(javax.swing.KeyStroke.getKeyStroke(67,java.awt.event.KeyEvent.CTRL_MASK));
		aeChief.addActionListener(this);
		aeFaculty=new JMenuItem("Faculty Edit/Delete",'F');
		aeFaculty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(70,java.awt.event.KeyEvent.CTRL_MASK));
		aeFaculty.addActionListener(this);
		aeOfficial=new JMenuItem("Official Edit/Delete",'O');
		aeOfficial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(79,java.awt.event.KeyEvent.CTRL_MASK));
		aeOfficial.addActionListener(this);

		nuChief=new JMenuItem ("Update Chief Notice",'C');
		nuChief.setAccelerator(javax.swing.KeyStroke.getKeyStroke(67,java.awt.event.KeyEvent.CTRL_MASK));
		nuChief.addActionListener(this);
		nuFaculty=new JMenuItem("Update Faculty Notice",'F');
		nuFaculty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(70,java.awt.event.KeyEvent.CTRL_MASK));
		nuFaculty.addActionListener(this);
		nuOfficial=new JMenuItem("Update Official Notice",'O');
		nuOfficial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(79,java.awt.event.KeyEvent.CTRL_MASK));
		nuOfficial.addActionListener(this);

		xAbout=new JMenuItem ("About Author",'A');
		xAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(65,java.awt.event.KeyEvent.CTRL_MASK));
		xAbout.addActionListener(this);
		xClose=new JMenuItem ("Close Everything",'C');
		xClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(67,java.awt.event.KeyEvent.CTRL_MASK));
		xClose.addActionListener(this);


	// adding Menu in MenuBar
		bar.add(ViewNotice);
		bar.add(QuickView);
		bar.add(PrintNotice);
		bar.add(AccountSignup);
		bar.add(AccountEdit);
		bar.add(NoticeUpdate);
		bar.add(Exit);

	// adding MenuItem of ViewNotice
		ViewNotice.add(vnChief);
		ViewNotice.addSeparator();
		ViewNotice.add(vnFaculty);
		ViewNotice.addSeparator();
		ViewNotice.add(vnOfficial);

	// adding MenuItem of QuickView
		QuickView.add(qvTable);
		QuickView.addSeparator();
		QuickView.add(qvSearch);

	// adding MenuItem of PrintNotice
		PrintNotice.add(pnChief);
		PrintNotice.addSeparator();
		PrintNotice.add(pnFaculty);
		PrintNotice.addSeparator();
		PrintNotice.add(pnOfficial);

	// adding MenuItem of AccountSignup
		AccountSignup.add(asChief);
		AccountSignup.addSeparator();
		AccountSignup.add(asFaculty);
		AccountSignup.addSeparator();
		AccountSignup.add(asOfficial);

	// adding MenuItem of AccountEdit
		AccountEdit.add(aeChief);
		AccountEdit.addSeparator();
		AccountEdit.add(aeFaculty);
		AccountEdit.addSeparator();
		AccountEdit.add(aeOfficial);

	// adding MenuItem of NoticeUpdate
		NoticeUpdate.add(nuChief);
		NoticeUpdate.addSeparator();
		NoticeUpdate.add(nuFaculty);
		NoticeUpdate.addSeparator();
		NoticeUpdate.add(nuOfficial);

	// adding MenuItem of Exit
		Exit.add(xAbout);
		Exit.addSeparator();
		Exit.add(xClose);


		setIconImage(Toolkit.getDefaultToolkit().getImage("notice.gif"));

		ViewNotice.setBackground(Color.blue);
		ViewNotice.setBorder(BorderFactory.createRaisedBevelBorder());
		QuickView.setBackground(Color.orange);
		QuickView.setBorder(BorderFactory.createRaisedBevelBorder());
		PrintNotice.setBackground(Color.blue);
		PrintNotice.setBorder(BorderFactory.createRaisedBevelBorder());
		AccountSignup.setBackground(Color.green);
		AccountSignup.setBorder(BorderFactory.createRaisedBevelBorder());
		AccountEdit.setBackground(Color.green);
		AccountEdit.setBorder(BorderFactory.createRaisedBevelBorder());
		NoticeUpdate.setBackground(Color.blue);
		NoticeUpdate.setBorder(BorderFactory.createRaisedBevelBorder());
		Exit.setBackground(Color.red);
		Exit.setBorder(BorderFactory.createRaisedBevelBorder());

		setContentPane(desktop);
		desktop.setBackground(Color.black);
		
		show();
	}



	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==asChief)
		{
			try
			{
			String s=JOptionPane.showInputDialog(this,"Enter Group name for Chief Signup Form:");
			if (s.equals ("chief"))
			{
				Chief_Account_Signup CAS=new Chief_Account_Signup();
				desktop.add(CAS);
			}
				else JOptionPane.showMessageDialog(this,"Invalid Password !!!");
			}catch(Exception e88){}
		}


		if(e.getSource()==asFaculty)
		{
			try
			{
			String t=JOptionPane.showInputDialog(this,"Enter Group name for Faculty Signup Form:");
			if (t.equals ("faculty"))
			{
				Faculty_Account_Signup FAS=new Faculty_Account_Signup();
				desktop.add(FAS);
			}
				else JOptionPane.showMessageDialog(this,"Invalid Password !!!");
			}catch(Exception e99){}
		}


		if(e.getSource()==asOfficial)
		{
			try
			{
			String u=JOptionPane.showInputDialog(this,"Enter Group name for Official Signup Form:");
			if (u.equals ("official"))
			{
				Official_Account_Signup OAS=new Official_Account_Signup();
				desktop.add(OAS);
			}
				else JOptionPane.showMessageDialog(this,"Invalid Password !!!");
			}catch(Exception e33){}
		}


		if(e.getSource()==vnChief)
		{
			View_Chief_Notice VCN=new View_Chief_Notice();
			desktop.add(VCN);
		}


		if(e.getSource()==vnFaculty)
		{
			View_Faculty_Notice VFN=new View_Faculty_Notice();
			desktop.add(VFN);
		}


		if(e.getSource()==vnOfficial)
		{
			View_Official_Notice VON=new View_Official_Notice();
			desktop.add(VON);
		}


		if(e.getSource()==pnChief)
		{
			Print_Chief_Notice PCN=new Print_Chief_Notice();
			desktop.add(PCN);
		}


		if(e.getSource()==pnFaculty)
		{
			Print_Faculty_Notice PFN=new Print_Faculty_Notice();
			desktop.add(PFN);
		}


		if(e.getSource()==pnOfficial)
		{
			Print_Official_Notice PON=new Print_Official_Notice();
			desktop.add(PON);
		}


		if(e.getSource()==aeChief)
		{
			Edit_Chief_Account ECA=new Edit_Chief_Account();
			desktop.add(ECA);
		}


		if(e.getSource()==aeFaculty)
		{
			Edit_Faculty_Account EFA=new Edit_Faculty_Account();
			desktop.add(EFA);
		}


		if(e.getSource()==aeOfficial)
		{
			Edit_Official_Account EOA=new Edit_Official_Account();
			desktop.add(EOA);
		}


		if(e.getSource()==nuChief)
		{
			Update_Chief_Notice UCN=new Update_Chief_Notice();
			desktop.add(UCN);
		}


		if(e.getSource()==nuFaculty)
		{
			Update_Faculty_Notice UFN=new Update_Faculty_Notice();
			desktop.add(UFN);
		}


		if(e.getSource()==nuOfficial)
		{
			Update_Official_Notice UON=new Update_Official_Notice();
			desktop.add(UON);
		}


		if(e.getSource()==qvTable)
		{
			QuickView qv=new QuickView();
			desktop.add(qv);
		}


		if(e.getSource()==qvSearch)
		{
			Search qvs=new Search();
			desktop.add(qvs);
		}


		if(e.getSource()==xAbout)
		{
			About ab=new About();
			desktop.add(ab);
		}


		if(e.getSource()==xClose)
		{
			System.exit(0);
		}
	}



	public static void main(String args[])
	{
		Notice_Board riyad=new Notice_Board();
	}
}
