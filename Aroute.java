package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Aroute extends JFrame {

	private JPanel contentPane;
	private JTable tb;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aroute frame = new Aroute();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Aroute() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 99, 403, 211);
		contentPane.add(scrollPane);
		
		tb = new JTable();
		tb.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		tb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tb);
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
			Statement stmt=(Statement) con.createStatement();
						
			ResultSet rs=stmt.executeQuery("select * from ROUTE");
			tb.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel lblRouteDetails = new JLabel("ROUTE DETAILS");
			lblRouteDetails.setHorizontalAlignment(SwingConstants.CENTER);
			lblRouteDetails.setForeground(new Color(255, 255, 255));
			lblRouteDetails.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblRouteDetails.setBackground(Color.YELLOW);
			lblRouteDetails.setBounds(186, 0, 262, 67);
			contentPane.add(lblRouteDetails);
			
			JButton btnLogout = new JButton("BACK");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{										
					new Amain().setVisible(true);
					setVisible(false);					
				}
			});
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnLogout.setBounds(119, 365, 100, 40);
			contentPane.add(btnLogout);
			
			JButton btnAddRoute = new JButton("ADD ROUTE");
			btnAddRoute.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{					
					new Addroute().setVisible(true);
					setVisible(false);					
				}
			});
			btnAddRoute.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnAddRoute.setBounds(372, 365, 150, 40);
			contentPane.add(btnAddRoute);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\13327.jpg"));
			lblNewLabel.setBounds(0, 0, 663, 476);
			contentPane.add(lblNewLabel);		
			}
			catch(Exception e1){}
	}
}
