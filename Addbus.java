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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Addbus extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JComboBox cb1;
	private JTextField t3;
	private JLabel lblArrivalTime;
	private JLabel lblRouteId_2;
	private JTextField t4;
	private JTextField t5;
	private JLabel lblAddBus;
	private JButton btnBack;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbus frame = new Addbus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Addbus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRouteId = new JLabel("BUS ID :");
		lblRouteId.setForeground(Color.WHITE);
		lblRouteId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRouteId.setBounds(87, 97, 136, 37);
		contentPane.add(lblRouteId);
		
		JLabel lblOrigin = new JLabel("ROUTE ID :");
		lblOrigin.setForeground(Color.WHITE);
		lblOrigin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrigin.setBounds(87, 156, 136, 37);
		contentPane.add(lblOrigin);
		
		JLabel lblDestination = new JLabel("DEPARTURE TIME :");
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDestination.setBounds(87, 271, 159, 37);
		contentPane.add(lblDestination);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setColumns(10);
		t1.setBounds(244, 97, 249, 37);
		contentPane.add(t1);
		
		cb1 = new JComboBox();
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb1.setBounds(244, 156, 249, 37);
		contentPane.add(cb1);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t3.setColumns(10);
		t3.setBounds(244, 212, 249, 37);
		contentPane.add(t3);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
			
		Statement stmt=(Statement) con.createStatement();
		String r="select ROUTE_ID from ROUTE";
				
		ResultSet res=stmt.executeQuery(r);
		
		while(res.next())
		{
			cb1.addItem(res.getString(1));		
		}		
		}
		catch(Exception se){}
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
					Statement stmt=(Statement) con.createStatement();
										
					String s1=t1.getText();
					String s2=cb1.getItemAt(cb1.getSelectedIndex()).toString();
					String s3=t3.getText();
					String s4=t4.getText();
					String s5=t5.getText();
									
					String q="insert into BUS values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
					stmt.executeUpdate(q);
					
					JOptionPane.showMessageDialog(null, "You have successfully added bus");
					new Abus().setVisible(true);
					setVisible(false);					
				}
				catch(Exception se){}				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdd.setBounds(393, 428, 100, 40);
		contentPane.add(btnAdd);
		
		lblArrivalTime = new JLabel("ARRIVAL TIME :");
		lblArrivalTime.setForeground(Color.WHITE);
		lblArrivalTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblArrivalTime.setBounds(87, 212, 136, 37);
		contentPane.add(lblArrivalTime);
		
		lblRouteId_2 = new JLabel("FARE :");
		lblRouteId_2.setForeground(Color.WHITE);
		lblRouteId_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRouteId_2.setBounds(87, 335, 136, 37);
		contentPane.add(lblRouteId_2);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t4.setColumns(10);
		t4.setBounds(244, 271, 249, 37);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t5.setColumns(10);
		t5.setBounds(244, 337, 249, 37);
		contentPane.add(t5);
		
		lblAddBus = new JLabel("ADD BUS");
		lblAddBus.setForeground(Color.WHITE);
		lblAddBus.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAddBus.setBackground(Color.YELLOW);
		lblAddBus.setBounds(228, 0, 147, 67);
		contentPane.add(lblAddBus);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				new Abus().setVisible(true);
				setVisible(false);				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(87, 428, 100, 40);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\13327.jpg"));
		lblNewLabel.setBounds(0, 0, 610, 543);
		contentPane.add(lblNewLabel);
	}
}
