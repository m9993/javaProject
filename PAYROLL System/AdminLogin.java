import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener{
	public static Admin ad;
	public static AdminAddEmployee aae;
	public static AdminRemoveEmployee are;
	public static AdminUpdateEmployee aue;
	private Button logoutButton, bButton, addButton, removeButton, updateButton;
	private TextArea ta;
	private Label l;
	private JFrame parent;
	private String data="";
	private String data1="";
	private String data2="";
	
	public AdminLogin(){
		super("Admin");
		//
		aae=new AdminAddEmployee();
		are=new AdminRemoveEmployee();
		aue=new AdminUpdateEmployee();
		//
		setSize(650,500);	
		setLayout(null);
		setLocation(350,130);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(31,65,77)); //<<getContentPane()>> Returns the contentPane object for this frame
		
		l=new Label("All Data :");
		ta= new TextArea(10,50);
		
		logoutButton=new Button("Logout");
		bButton=new Button("Back");
		updateButton=new Button("Update Employee");
		addButton=new Button("Add Employee");
		removeButton=new Button("Remove Employee");
		
		l.setFont(new Font("Arial Black",1,15));
		l.setForeground (Color.white);
		l.setBounds(50,25,100,30);
		ta.setBounds(50,70,545,250);
		ta.setEditable(false);
		//ta.setForeground (Color.white);
		//ta.setBackground(new Color(255,255,255));
		logoutButton.setBounds(450,350,50,22);
		bButton.setBounds(520,350,50,22);
		updateButton.setBounds(75,350,110,22);
		addButton.setBounds(271,360,97,22);
		removeButton.setBounds(253,395,135,22);
		
		add(l);
		add(ta);
		add(logoutButton);
		add(bButton);
		add(updateButton);
		add(addButton);
		add(removeButton);
		
		logoutButton.addActionListener(this);
		bButton.addActionListener(this);
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		updateButton.addActionListener(this);
	}
	
	public void loadData(){
		//System.out.println(i);
		String sql="select * from admin where id='"+Payroll.ad.getId()+"'";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			while(rs.next()){
				data=data+"You :";
				data=data+"\n";
				data=data+"	Name:				"+rs.getString("name")+"\n";
				data=data+"	ID:				"+rs.getString("id")+"\n";
				data=data+"	Phone:				"+rs.getString("phone")+"\n";
				data=data+"	Email:				"+rs.getString("email")+"\n";
				data=data+"	DOB:				"+rs.getString("dob")+"\n";
				data=data+"\n";
				data=data+"All Employee Info :";
				data=data+"\n";
			}
			
		}
		catch(Exception ex){
			System.out.println("Exception in Admin");
		}
	}
	
	public void loadData1(){
			String sql1="select * from employee";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql1);
			while(rs.next()){
				data1=data1+"\n";
				data1=data1+"          #";
				data1=data1+"	Name:				"+rs.getString("name")+"\n";
				data1=data1+"	ID:				"+rs.getString("id")+"\n";
				data1=data1+"	Phone:				"+rs.getString("phone")+"\n";
				data1=data1+"	Email:				"+rs.getString("email")+"\n";
				data1=data1+"	Address:			"+rs.getString("address")+"\n";
				data1=data1+"	DOB:				"+rs.getString("dob")+"\n";
				data1=data1+"	HRA:				"+rs.getString("hra")+"\n";
				data1=data1+"	Basic Salary:			"+rs.getString("basic_salary")+"\n";
				data1=data1+"	Bonus:				"+rs.getString("bonus")+"\n";
				data1=data1+"	Medical Allowence:		"+rs.getString("medical_allowence")+"\n";
				data1=data1+"\n";
			}
			
			System.out.println(data);
			data2=data+data1;
			System.out.println(data1);
			ta.setText(data2);
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
		
		else if(e.getActionCommand()== "Update Employee"){
			System.out.println("Updating Employee");
			this.setVisible(false);
			aue.setVisible(true);
			aue.setParent(this);
		}
		
		else if(e.getActionCommand()== "Add Employee"){
			System.out.println("Adding Employee");
			this.setVisible(false);
			aae.setParent(this);
			aae.setVisible(true);
		}
		
		else if(e.getActionCommand()== "Remove Employee"){
			System.out.println("Removing Employee");
			this.setVisible(false);
			are.setVisible(true);
			are.setParent(this);
		}
		
	}
	
}