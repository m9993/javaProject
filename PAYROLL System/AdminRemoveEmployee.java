import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;
import java.sql.*;

public class AdminRemoveEmployee extends JFrame implements ActionListener{
	private Button logoutButton, bButton, removeButton;
	private Label l;
	private TextField tf;
	private JFrame parent;	
	
	public AdminRemoveEmployee(){
		super("Remove Employee");
		//
		
		//
		setSize(500,400);	
		setLayout(null);
		setLocation(390,150);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(31,65,77)); //<<getContentPane()>> Returns the contentPane object for this frame
		
		l=new Label("ID :");
		tf= new TextField(10);
		
		logoutButton=new Button("Logout");
		bButton=new Button("Back");
		removeButton=new Button("Remove");
		
		l.setForeground (Color.white);
		l.setBounds(140,60,70,30);
		tf.setBounds(210,60,200,30);
		removeButton.setBounds(283,110,54,22);
		logoutButton.setBounds(250,150,50,22);
		bButton.setBounds(320,150,50,22);
		
		add(l);
		add(tf);
		add(logoutButton);
		add(bButton);
		add(removeButton);
		
		logoutButton.addActionListener(this);
		bButton.addActionListener(this);
		removeButton.addActionListener(this);
	}
		
	public void setParent(JFrame j){
		parent=j;
	}
		
	public void loadData(){
		DataAccess da=new DataAccess();
		String sql="delete from employee where id='"+tf.getText()+"'";
		if(da.updateDB(sql)>0){
			JOptionPane.showMessageDialog(this,"Removing Complete!");
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
		
		else if(e.getActionCommand()== "Remove"){
			System.out.println("Removing Employee");
			if(tf.getText().length()==0){
				JOptionPane.showMessageDialog(this,"Try Again!");
			}
			else{
				loadData();
			}
		}
			
	}
		
}