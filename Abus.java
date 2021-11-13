package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Abus extends JFrame {

	private JPanel contentPane;
	private JTable tb;
	private JLabel lblBusDetails;
	private JButton btnLogout;
	private JButton btnAddBus;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Abus frame = new Abus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Abus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 83, 512, 211);
		contentPane.add(scrollPane);
		
		tb = new JTable();
		tb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tb.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tb);
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
		Statement stmt=(Statement) con.createStatement();
				
		ResultSet rs=stmt.executeQuery("select * from BUS");
		tb.setModel(DbUtils.resultSetToTableModel(rs));
		
		lblBusDetails = new JLabel("BUS DETAILS");
		lblBusDetails.setForeground(Color.WHITE);
		lblBusDetails.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblBusDetails.setBackground(Color.YELLOW);
		lblBusDetails.setBounds(283, 0, 212, 67);
		contentPane.add(lblBusDetails);
		
		btnLogout = new JButton("BACK");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				new Amain().setVisible(true);
				setVisible(false);				
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogout.setBounds(128, 348, 100, 40);
		contentPane.add(btnLogout);
		
		btnAddBus = new JButton("ADD BUS");
		btnAddBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				new Addbus().setVisible(true);
				setVisible(false);				
			}
		});
		btnAddBus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddBus.setBounds(520, 348, 120, 40);
		contentPane.add(btnAddBus);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\329313.jpg"));
		lblNewLabel.setBounds(0, 0, 797, 468);
		contentPane.add(lblNewLabel);	
		}
		catch(Exception e1){}
	}
}
