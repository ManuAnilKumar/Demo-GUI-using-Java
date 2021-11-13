package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

public class Alogin extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alogin frame = new Alogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Alogin() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb = new JLabel("ADMIN NAME :");
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb.setBounds(129, 87, 120, 37);
		contentPane.add(lb);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(129, 149, 120, 37);
		contentPane.add(lblPassword);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setBounds(259, 89, 249, 37);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JPasswordField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setBounds(259, 150, 249, 39);
		contentPane.add(t2);
		
		JButton b1 = new JButton("LOGIN");
		b1.setFont(new Font("Tahoma", Font.BOLD, 18));
		b1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
					Statement stmt=(Statement) con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from ADMIN");
					String un=t1.getText(); String pwd=t2.getText();
					while(rs.next())
					{
						System.out.println(un); 
						System.out.println(pwd);
						if((un.equals(rs.getString(1)))&&(pwd.equals(rs.getString(2))))
						{
							System.out.println("Success");
						
							JOptionPane.showMessageDialog(null, "You have successfully logged in");
							
						new Amain().setVisible(true);
						this.dispose();
							break;
						}
						else
						{
							System.out.println("UnSuccessfull");
							
							JOptionPane.showMessageDialog(null, "Invalid username or password");
								
						}
					}
						con.close();
					
					}
					catch(Exception se){}				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		b1.setBounds(387, 239, 120, 40);
		contentPane.add(b1);
		
		JLabel lblOnlineBusBooking = new JLabel("ADMIN LOGIN");
		lblOnlineBusBooking.setForeground(Color.WHITE);
		lblOnlineBusBooking.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblOnlineBusBooking.setBackground(Color.YELLOW);
		lblOnlineBusBooking.setBounds(201, 0, 229, 67);
		contentPane.add(lblOnlineBusBooking);
		
		JButton btnUser = new JButton("USER");
		btnUser.setForeground(Color.BLUE);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				new ulogin().setVisible(true);
				setVisible(false);								
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnUser.setBounds(129, 239, 100, 40);
		contentPane.add(btnUser);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\abstract-background-design-black_53876-43543.jpg"));
		lblNewLabel.setBounds(0, 0, 623, 393);
		contentPane.add(lblNewLabel);
	}
}