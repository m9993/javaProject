import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener{
	public static AdminLogin al;
	private Button lButton, bButton;
	private Label l1,l2;
	private TextField tf,tf1;
	private JFrame parent;
	private String i;
	
	public Admin(){
		super("Admin Login Window");
		//
		al=new AdminLogin();
		//
		setSize(500,400);	
		setLayout(null);
		setLocation(390,150);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(31,65,77)); //<<getContentPane()>> Returns the contentPane object for this frame
		
		l1=new Label("ID :");
		l2=new Label("Password :");
		tf= new TextField(10);
		tf1= new TextField(10);
		
		//l.setFont(new Font("Comic Sans MS",1,30));
		l1.setForeground (Color.white);
		l2.setForeground (Color.white);
		
		lButton=new Button("Login");
		bButton=new Button("Back");
		
		l1.setBounds(140,60,70,30);
		l2.setBounds(100,100,70,30);
		tf.setBounds(210,60,200,30);
		tf1.setBounds(210,100,200,30);
		tf1.setEchoChar('*');
		lButton.setBounds(250,170,50,22);
		bButton.setBounds(320,170,50,22);
		
		add(l1);
		add(tf);
		add(l2);
		add(tf1);
		add(lButton);
		add(bButton);
		
		lButton.addActionListener(this);
		bButton.addActionListener(this);
	}
		
	public void setParent(JFrame j){
		parent=j;
	}
		
	public void setId(String i1){
		i=i1;
	}
	
	public String getId(){
		return i;
	}
		
	private boolean checkAuth(){
		boolean flag=false;
		String i=tf.getText();
		String p=tf1.getText();
		String sql="select * from admin where id='"+i+"' and password='"+p+"'";
		System.out.println(sql);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			while(rs.next()){
				flag=true;
			}
			setId(tf.getText());
		}
		catch(Exception ex){
			System.out.println("Exception occurred");
		}
		return flag;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Login")){
			if(checkAuth()){
				Payroll.al.loadData();
				Payroll.al.loadData1();
				this.setVisible(false);
				Payroll.al.setVisible(true);
				Payroll.al.setParent(this);
				System.out.println("Admin Logged in");
			}
			else {
				System.out.println("Incorrect");
				JOptionPane.showMessageDialog(this,"Try Again!");
			}
		}
		
		else if(e.getActionCommand().equals("Back")){
			System.out.println("Back Button Pressed");
			this.setVisible(false);
			parent.setVisible(true);
		}
		
	}
	
}