package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Addroute extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JLabel lblAddRoute;
	private JButton btnBack;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addroute frame = new Addroute();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Addroute() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRouteId = new JLabel("ROUTE ID :");
		lblRouteId.setForeground(Color.WHITE);
		lblRouteId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRouteId.setBounds(87, 97, 136, 37);
		contentPane.add(lblRouteId);
		
		JLabel lblOrigin = new JLabel("ORIGIN :");
		lblOrigin.setForeground(Color.WHITE);
		lblOrigin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrigin.setBounds(87, 156, 136, 37);
		contentPane.add(lblOrigin);
		
		JLabel lblDestination = new JLabel("DESTINATION :");
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDestination.setBounds(87, 212, 136, 37);
		contentPane.add(lblDestination);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(233, 97, 249, 37);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(233, 156, 249, 37);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(233, 212, 249, 37);
		contentPane.add(t3);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{								
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
					Statement stmt=(Statement) con.createStatement();
										
					String s1=t1.getText();
					String s2=t2.getText();
					String s3=t3.getText();
										
					String q="insert into ROUTE values('"+s1+"','"+s2+"','"+s3+"')";
					stmt.executeUpdate(q);
					
					JOptionPane.showMessageDialog(null, "You have successfully added bus");
					new Aroute().setVisible(true);
					setVisible(false);										
				}
				catch(Exception se){}				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd.setBounds(382, 300, 100, 40);
		contentPane.add(btnAdd);
		
		lblAddRoute = new JLabel("ADD ROUTE");
		lblAddRoute.setForeground(Color.WHITE);
		lblAddRoute.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAddRoute.setBackground(Color.YELLOW);
		lblAddRoute.setBounds(196, 10, 189, 67);
		contentPane.add(lblAddRoute);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{								
				new Aroute().setVisible(true);
				setVisible(false);				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(87, 299, 100, 40);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\1116905.jpg"));
		lblNewLabel.setBounds(0, 0, 610, 431);
		contentPane.add(lblNewLabel);
	}
}
