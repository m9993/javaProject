import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.color.*;

public class Payroll extends JFrame implements ActionListener{
	public static Employee emp;
	public static Admin ad;
	public static EmployeeLogin empl;
	public static AdminLogin al;
	//public static AdminAddEmployee aae;
	//public static AdminRemoveEmployee are;
	private Button aButton, eButton;
	private Label l;
	
	public Payroll(){
		super("Payroll");
		//
		emp=new Employee();
		ad=new Admin();
		empl=new EmployeeLogin();
		al=new AdminLogin();
		//aae=new AdminAddEmployee();
		//are=new AdminRemoveEmployee();
		//
		setSize(300,400);	
		setLayout(null);
		setLocation(500,150);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(31,65,77)); //<<getContentPane()>> Returns the contentPane object for this frame
		
		l=new Label("Login As");
		l.setFont(new Font("Comic Sans MS",1,30));
		l.setForeground (Color.white);
		aButton=new Button("Admin");
		eButton=new Button("Employee");
		
		l.setBounds(85,60,150,50);
		aButton.setBounds(95,120,100,30);
		eButton.setBounds(95,170,100,30);
		
		add(l);
		add(aButton);
		add(eButton);
		
		aButton.addActionListener(this);
		eButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("Admin")){
			System.out.println("Admin Button Pressed");
			ad.setParent(this);
			ad.setVisible(true);
			this.setVisible(false);
		}
		
		else if(s.equals("Employee")){
			System.out.println("Employee Button Pressed");
			emp.setParent(this);
			emp.setVisible(true);
			this.setVisible(false);
		}
		
	}
				
}