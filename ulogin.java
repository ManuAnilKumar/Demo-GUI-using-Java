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

public class ulogin extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ulogin frame = new ulogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ulogin() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb = new JLabel("USERNAME :");
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb.setBounds(139, 89, 116, 37);
		contentPane.add(lb);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(139, 151, 116, 37);
		contentPane.add(lblPassword);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setBounds(265, 89, 249, 37);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JPasswordField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setBounds(265, 150, 249, 39);
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
					PreparedStatement stmt=con.prepareStatement("select username,password from passenger where username=? and password=?");
					
					stmt.setString(1,t1.getText());
					stmt.setString(2,t2.getText());
					ResultSet rs=stmt.executeQuery();
					
					if(rs.next())
					{
							System.out.println("Success");
						
							JOptionPane.showMessageDialog(null, "You have successfully logged in");
							
						new Main().setVisible(true);
						this.dispose();
							
						}
						
						else
						{
							System.out.println("UnSuccessfull");
							
							JOptionPane.showMessageDialog(null, "Invalid username or password");
							this.dispose();
								
						}
						con.close();
					}
					catch(Exception se){}
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		b1.setBounds(394, 239, 120, 40);
		contentPane.add(b1);
		
		JButton btnNewUser = new JButton("SIGN IN");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new Newuser().setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewUser.setBounds(394, 303, 120, 40);
		contentPane.add(btnNewUser);
		
		JLabel lblOnlineBusBooking = new JLabel("USER LOGIN");
		lblOnlineBusBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineBusBooking.setForeground(Color.WHITE);
		lblOnlineBusBooking.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblOnlineBusBooking.setBackground(Color.YELLOW);
		lblOnlineBusBooking.setBounds(228, 0, 196, 67);
		contentPane.add(lblOnlineBusBooking);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setForeground(Color.RED);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				new Alogin().setVisible(true);
				setVisible(false);
				
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnAdmin.setBounds(139, 239, 100, 40);
		contentPane.add(btnAdmin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\13327.jpg"));
		lblNewLabel.setBounds(0, 0, 651, 407);
		contentPane.add(lblNewLabel);
	}
}