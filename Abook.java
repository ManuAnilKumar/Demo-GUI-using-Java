package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Abook extends JFrame {

	private JPanel contentPane;
	private JTable tb;
	private JLabel lblBookingDetails;
	private JButton btnLogout;
	private JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Abook frame = new Abook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Abook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 87, 532, 209);
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
						
			ResultSet rs=stmt.executeQuery("select * from TICKET");
			tb.setModel(DbUtils.resultSetToTableModel(rs));
			
			lblBookingDetails = new JLabel("BOOKING DETAILS");
			lblBookingDetails.setForeground(Color.WHITE);
			lblBookingDetails.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblBookingDetails.setBackground(Color.YELLOW);
			lblBookingDetails.setBounds(240, 0, 302, 67);
			contentPane.add(lblBookingDetails);
			
			btnLogout = new JButton("BACK");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{					
					new Amain().setVisible(true);
					setVisible(false);					
				}
			});
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnLogout.setBounds(345, 351, 100, 40);
			contentPane.add(btnLogout);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\1116905.jpg"));
			label.setBounds(0, 0, 797, 461);
			contentPane.add(label);
			}
			catch(Exception e1){}		
	}
}
