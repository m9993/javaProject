import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;
import java.sql.*;

public class AdminUpdateEmployee extends JFrame implements ActionListener{
	private Button logoutButton, bButton, updateButton;
	private Label l,l1;
	private TextField tf,tf1;
	private JFrame parent;	
	
	public AdminUpdateEmployee(){
		super("Update Employee");
		//
		
		//
		setSize(500,400);	
		setLayout(null);
		setLocation(390,150);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(31,65,77)); //<<getContentPane()>> Returns the contentPane object for this frame
		
		l=new Label("ID :");
		l1=new Label("Basic salary :");
		tf= new TextField(10);
		tf1= new TextField(10);
		
		logoutButton=new Button("Logout");
		bButton=new Button("Back");
		updateButton=new Button("Update");
		
		l.setForeground (Color.white);
		l1.setForeground (Color.white);
		
		l.setBounds(140,60,70,30);
		l1.setBounds(107,100,80,30);
		tf.setBounds(210,60,200,30);
		tf1.setBounds(210,100,200,30);
		updateButton.setBounds(283,150,54,22);
		logoutButton.setBounds(250,190,50,22);
		bButton.setBounds(320,190,50,22);
		
		add(l);
		add(l1);
		add(tf);
		add(tf1);
		add(logoutButton);
		add(bButton);
		add(updateButton);
		
		logoutButton.addActionListener(this);
		bButton.addActionListener(this);
		updateButton.addActionListener(this);
	}
		
	public void setParent(JFrame j){
		parent=j;
	}
		
	public void loadData(){
		DataAccess da=new DataAccess();
		String sql="update employee set basic_salary="+tf1.getText()+" where id='"+tf.getText()+"'";
		if(da.updateDB(sql)>0){
			JOptionPane.showMessageDialog(this,"Update Completed!");
		}
		else{
			JOptionPane.showMessageDialog(this,"No id found in Database!");
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
		
		else if(e.getActionCommand()== "Update"){
			System.out.println("Updating Employee");
			if(tf.getText().length()==0 || tf1.getText().length()==0){
				JOptionPane.showMessageDialog(this,"Try Again!");
			}
			else{
				loadData();
			}
		}
	}
		
}