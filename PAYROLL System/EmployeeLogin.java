import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;
import java.sql.*;

public class EmployeeLogin extends JFrame implements ActionListener{
	public static Employee emp;
	private Button logoutButton, bButton, reqButton;
	private TextArea ta;
	private Label l;
	private JFrame parent;
	
	public EmployeeLogin(){
		super("Employee Information");
		//
		
		//
		setSize(500,400);	
		setLayout(null);
		setLocation(390,150);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(31,65,77)); //<<getContentPane()>> Returns the contentPane object for this frame
		
		l=new Label("Your All Data :");
		ta= new TextArea(10,50);
		
		logoutButton=new Button("Logout");
		bButton=new Button("Back");
		reqButton=new Button("Absence Request");
		
		l.setFont(new Font("Arial Black",1,15));
		l.setForeground (Color.white);
		l.setBounds(50,25,100,30);
		ta.setBounds(50,70,400,170);
		ta.setEditable(false);
		//ta.setForeground (Color.white);
		//ta.setBackground(new Color(255,255,255));
		logoutButton.setBounds(300,270,50,22);
		bButton.setBounds(370,270,50,22);
		reqButton.setBounds(60,270,120,22);
		
		add(l);
		add(ta);
		add(logoutButton);
		add(bButton);
		add(reqButton);
		
		logoutButton.addActionListener(this);
		bButton.addActionListener(this);
		reqButton.addActionListener(this);
	}
	
	public void loadData(){
		String sql="select * from employee where id='"+Payroll.emp.getId()+"'";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+"	Name:				"+rs.getString("name")+"\n";
				data=data+"	ID:				"+rs.getString("id")+"\n";
				data=data+"	Phone:				"+rs.getString("phone")+"\n";
				data=data+"	Email:				"+rs.getString("email")+"\n";
				data=data+"	Address:			"+rs.getString("address")+"\n";
				data=data+"	DOB:				"+rs.getString("dob")+"\n";
				data=data+"	HRA:				"+rs.getString("hra")+"\n";
				data=data+"	Basic Salary:			"+rs.getString("basic_salary")+"\n";
				data=data+"	Bonus:				"+rs.getString("bonus")+"\n";
				data=data+"	Medical Allowence:		"+rs.getString("medical_allowence")+"\n";
				data=data+"\n";
			}
			System.out.println(data);
			ta.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in Employee");
		}
	}		
		
	public void setParent(JFrame j){
		parent=j;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()== "Logout"){
			System.out.println("Logout Button Pressed");
			System.exit(0);
		}
		
		else if(e.getActionCommand()== "Back"){
			System.out.println("Back Button Pressed");
			this.setVisible(false);
			parent.setVisible(true);
		}
		
		else if(e.getActionCommand()== "Absence Request"){
			System.out.println("Absence Request Sent");
			JOptionPane.showMessageDialog(this,"Request Sent!");
		}
		
	}		
		
}