package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Uprofile extends JFrame {

	private JPanel contentPane;
	private JComboBox cb1;
	private JTextField t2;
	private JPasswordField t3;
	private JTextField t4;
	private JTextField t5;
	private JButton btnLogout;
	private JLabel lblUsers;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Uprofile frame = new Uprofile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Uprofile() {
		setTitle("USERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassengerId = new JLabel("PASSENGER ID :");
		lblPassengerId.setForeground(Color.WHITE);
		lblPassengerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId.setBounds(128, 85, 147, 32);
		contentPane.add(lblPassengerId);
		
		JLabel lblUsername = new JLabel("USERNAME :");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(128, 138, 147, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(128, 195, 147, 32);
		contentPane.add(lblPassword);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO :");
		lblMobileNo.setForeground(Color.WHITE);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobileNo.setBounds(128, 254, 147, 32);
		contentPane.add(lblMobileNo);
		
		JLabel lblEmail = new JLabel("E-MAIL :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(128, 307, 147, 32);
		contentPane.add(lblEmail);
		
		cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"-select-"}));
		cb1.setFont(new Font("Tahoma", Font.BOLD, 15));
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{				
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
				Statement stmt=(Statement) con.createStatement();
				
				String s1=cb1.getItemAt(cb1.getSelectedIndex()).toString();
				
				String q="select * from PASSENGER where PASSENGER_ID = '"+s1+"'";
				ResultSet res=stmt.executeQuery(q);
				
					if(res.next())
					{						
						t2.setText(res.getString(2));
						t3.setText(res.getString(3));
						t4.setText(res.getString(4));
						t5.setText(res.getString(5));					
					}
				}				
				catch(Exception se) {}				
			}
		});
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
			
		Statement stmt=(Statement) con.createStatement();
		String r="select * from PASSENGER";
				
		ResultSet res=stmt.executeQuery(r);
		
		while(res.next())
		{
			cb1.addItem(res.getString(1));		
		}				
		}
		catch(Exception se){}
		
		cb1.setBounds(285, 85, 89, 32);
		contentPane.add(cb1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBounds(285, 138, 207, 32);
		contentPane.add(t2);
		
		t3 = new JPasswordField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(285, 195, 207, 32);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(285, 255, 207, 32);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(285, 308, 207, 32);
		contentPane.add(t5);
		
		btnLogout = new JButton("BACK");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new Amain().setVisible(true);
				setVisible(false);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(392, 382, 100, 40);
		contentPane.add(btnLogout);
		
		lblUsers = new JLabel("USER DETAILS");
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblUsers.setBackground(Color.YELLOW);
		lblUsers.setBounds(198, 0, 235, 67);
		contentPane.add(lblUsers);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\material-design-black-abstract-background-vector-art-green.jpg"));
		lblNewLabel.setBounds(0, 0, 640, 484);
		contentPane.add(lblNewLabel);
	}
}
