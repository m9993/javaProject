import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;
import java.sql.*;

public class AdminAddEmployee extends JFrame implements ActionListener{
	private Button logoutButton, bButton, addButton;
	private Label l,l1,l2;
	private TextField tf,tf1,tf2;
	private JFrame parent;	
	
	public AdminAddEmployee(){
		super("Add Employee");
		//
		
		//
		setSize(500,400);	
		setLayout(null);
		setLocation(390,150);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(31,65,77)); //<<getContentPane()>> Returns the contentPane object for this frame
		
		l=new Label("Name :");
		l1=new Label("ID :");
		l2=new Label("Basic salary :");
		tf= new TextField(10);
		tf1= new TextField(10);
		tf2= new TextField(10);
		
		logoutButton=new Button("Logout");
		bButton=new Button("Back");
		addButton=new Button("Add");
		
		l.setForeground (Color.white);
		l1.setForeground (Color.white);
		l2.setForeground (Color.white);
		
		l.setBounds(140,60,70,30);
		l1.setBounds(162,100,30,30);
		l2.setBounds(107,140,80,30);
		tf.setBounds(210,60,200,30);
		tf1.setBounds(210,100,200,30);
		tf2.setBounds(210,140,200,30);
		logoutButton.setBounds(250,230,50,22);
		bButton.setBounds(320,230,50,22);
		addButton.setBounds(285,190,50,22);
		//tf.setBackground(new Color(255,255,255));
		
		add(l);
		add(l1);
		add(l2);
		add(tf);
		add(tf1);
		add(tf2);
		add(logoutButton);
		add(bButton);
		add(addButton);
		
		logoutButton.addActionListener(this);
		bButton.addActionListener(this);
		addButton.addActionListener(this);
	}
		
	public void setParent(JFrame j){
		parent=j;
	}
		
		
	public void loadData(){
		DataAccess da=new DataAccess();
		String sql="insert into employee (name,id,password,basic_salary) values ('"+tf.getText()+"','"+tf1.getText()+"','123',"+tf2.getText()+")";
		if(da.updateDB(sql)>0){
			JOptionPane.showMessageDialog(this,"Adding Complete!");
		}
		System.out.println(sql);
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
		
		else if(e.getActionCommand()== "Add"){
			System.out.println("Adding Employee");
			if(tf.getText().length()==0 || tf1.getText().length()==0 || tf2.getText().length()==0){
				JOptionPane.showMessageDialog(this,"Try Again!");
			}
			else{
				loadData();
			}
		}
			
	}	
		
}