package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.sql.*;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Newuser extends JFrame {

	private JPanel contentPane;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JButton btnLogout;
	private JLabel lblAccount;
	private JButton btnRegister;
	
	private static  int pid=100;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newuser frame = new Newuser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Newuser() {
		setTitle("NEW USER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(128, 77, 147, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(128, 134, 147, 32);
		contentPane.add(lblPassword);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO :");
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobileNo.setBounds(128, 193, 147, 32);
		contentPane.add(lblMobileNo);
		
		JLabel lblEmail = new JLabel("E-MAIL :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(128, 258, 147, 32);
		contentPane.add(lblEmail);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setColumns(10);
		t2.setBounds(285, 77, 230, 32);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t3.setColumns(10);
		t3.setBounds(285, 134, 230, 32);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t4.setColumns(10);
		t4.setBounds(285, 193, 230, 32);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t5.setColumns(10);
		t5.setBounds(285, 258, 230, 32);
		contentPane.add(t5);
		
		btnLogout = new JButton("BACK");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				new ulogin().setVisible(true);
				setVisible(false);
				
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogout.setBounds(128, 347, 100, 40);
		contentPane.add(btnLogout);
		
		lblAccount = new JLabel("PROFILE");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAccount.setBackground(Color.YELLOW);
		lblAccount.setBounds(251, 0, 155, 67);
		contentPane.add(lblAccount);
		
		btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(Color.BLUE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
					Statement stmt=(Statement) con.createStatement();
					
					ResultSet res;
					
					try {
						res=stmt.executeQuery(" select PASSENGER_ID from ( select PASSENGER_ID from PASSENGER order by PASSENGER_ID desc) where rownum=1");
						if (res.isBeforeFirst() ) 
						{ 
							res.next();
							String[] a = res.getString(1).split("P",2);
							int i = Integer.parseInt(a[1]);
							 pid = ++i;
							System.out.println("Split is "+i);
						}
					} 
					catch (Exception e1) {}
					
					String s1="P"+pid;
					System.out.println(s1);
					
					String s2=t2.getText();
					String s3=t3.getText();
					String s4=t4.getText();
					String s5=t5.getText();
					
					String q="insert into PASSENGER values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
					stmt.executeUpdate(q);
					
					JOptionPane.showMessageDialog(null, "You have successfully registered, your user id id : '"+s1+"'");
					new ulogin().setVisible(true);
					setVisible(false);
				}
				catch(Exception se){}			
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegister.setBounds(375, 347, 140, 40);
		contentPane.add(btnRegister);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\material-design-black-abstract-background-vector-art-green.jpg"));
		lblNewLabel.setBounds(0, 0, 654, 463);
		contentPane.add(lblNewLabel);
	}
}
