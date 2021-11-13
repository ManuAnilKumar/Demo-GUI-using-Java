package pack;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Booking extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField t1;
	private JTable tb;
	private JTextField t3;
	private JTextField t4;
	
	private static  int tid=100;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Booking() {
		setTitle("BOOKING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrigin = new JLabel("ORIGIN :");
		lblOrigin.setForeground(Color.WHITE);
		lblOrigin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrigin.setBounds(98, 85, 147, 32);
		contentPane.add(lblOrigin);
		
		final JComboBox<String> cb3 = new JComboBox<String>();
		cb3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb3.setBounds(277, 349, 76, 32);
		contentPane.add(cb3);
		
		JLabel lblDestination = new JLabel("DESTINATION :");
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDestination.setBounds(98, 133, 147, 32);
		contentPane.add(lblDestination);
		
		final JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"-select-", "Kochi", "Kalamassery", "Kaloor", "Kakkanad"}));
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb1.setBounds(246, 87, 147, 29);
		contentPane.add(cb1);
		
		final JComboBox cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"-select-", "Kochi", "Kalamassery", "Kaloor", "Kakkanad"}));
		cb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb2.setBounds(246, 135, 147, 29);
		contentPane.add(cb2);
		
		final JComboBox cb5 = new JComboBox<Object>();
		cb5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
			
			String th=cb3.getItemAt(cb3.getSelectedIndex()).toString();
			String qry="select * from bus where BUS_ID='"+th+"'";
			PreparedStatement st=con.prepareStatement(qry);		
			
			ResultSet res=st.executeQuery(qry);
			
			if(res.next())
			{
				String jk=cb5.getItemAt(cb5.getSelectedIndex()).toString();
				int lk=Integer.parseInt(jk);
				String hj=res.getString(5);
				int yy=Integer.parseInt(hj);
				int xx=(lk*yy);
				String ww=Integer.toString(xx);
				t4.setText(ww);
				
			}
		}
		catch(Exception e5){}
		}
		});
		
		cb5.setModel(new DefaultComboBoxModel(new String[] {"-select-", "1", "2", "3", "4", "5"}));
		cb5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb5.setBounds(596, 349, 76, 32);
		contentPane.add(cb5);
		
		final JTextField t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t5.setBounds(277, 412, 76, 32);
		contentPane.add(t5);		
		
		JButton btnBook = new JButton("BOOK");
		btnBook.setForeground(Color.BLUE);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
					
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
					Statement stmt=(Statement) con.createStatement();
					
					String qry = null;
					
					ResultSet res;
					
			try {
				res=stmt.executeQuery(" select TICKET_ID from ( select TICKET_ID from TICKET order by TICKET_ID desc) where rownum=1");
				if (res.isBeforeFirst() ) { 
					res.next();
					String[] a = res.getString(1).split("T",2);
					int i = Integer.parseInt(a[1]);
					 tid = ++i;
					System.out.println("Split is "+i);
				}
				
			} 
			catch (Exception e1) {}
						
			String s1="T"+tid;
			System.out.println(s1);
					
					String s2=t5.getText();
					String s3=cb3.getItemAt(cb3.getSelectedIndex()).toString();
					String s4=cb5.getItemAt(cb5.getSelectedIndex()).toString();
					String s5=t3.getText();
					String s6=t4.getText();
					String s7=t1.getText();
					
					String q="insert into TICKET values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
					stmt.executeUpdate(q);
					
					JOptionPane.showMessageDialog(null, "You have succesfully booked, your ticked id is : '"+s1+"'");
					new Ticket().setVisible(true);
					setVisible(false);
										
				}
				catch(Exception se){}			
			}		
		});
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBook.setBounds(611, 560, 100, 40);
		contentPane.add(btnBook);
		
		JButton btnViewDetails = new JButton("BUS DETAILS");
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
								
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
					Statement stmt=(Statement) con.createStatement();
					
					String s1=t1.getText();
					
					ResultSet rs=stmt.executeQuery("select * from BUS where ROUTE_ID = '"+s1+"'");
					tb.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception e1)
					{}
			
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
					Statement stmt=(Statement) con.createStatement();
				
					String s1=t1.getText();
					String r="select BUS_ID from BUS where ROUTE_ID ='"+s1+"'";
								
					ResultSet res=stmt.executeQuery(r);
				
					while(res.next())
					{
						cb3.addItem(res.getString(1));				
					}				
				}
				catch(Exception se){}				
			}
		});
		btnViewDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewDetails.setBounds(143, 263, 150, 40);
		contentPane.add(btnViewDetails);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setEditable(false);
		t1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		t1.setBounds(555, 135, 76, 29);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Route ID :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(470, 135, 81, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 212, 408, 91);
		contentPane.add(scrollPane);
		
		tb = new JTable();
		tb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tb.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Bus ID", "Route ID", "Arrival time", "Departure time", "Fare"
			}
		));
		tb.getColumnModel().getColumn(2).setPreferredWidth(82);
		tb.getColumnModel().getColumn(3).setPreferredWidth(88);
		scrollPane.setViewportView(tb);
		
		JButton btnSearchRoute = new JButton("SEARCH ROUTE");
		btnSearchRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
				Statement stmt=(Statement) con.createStatement();
								
				String s1=cb1.getItemAt(cb1.getSelectedIndex()).toString();
				String s2=cb2.getItemAt(cb2.getSelectedIndex()).toString();
				
				String q="select * from ROUTE where ORIGIN='"+s1+"' and DESTINATION='"+s2+"'";
							
				ResultSet res=stmt.executeQuery(q);
				
					if(res.next())
					{
						t1.setText(res.getString(1));
					}
				}				
				catch(Exception se) {}									
			}
		});
		btnSearchRoute.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchRoute.setBounds(471, 85, 160, 40);
		contentPane.add(btnSearchRoute);
		
		JLabel lblViewAvailableBuses = new JLabel("View available Buses :");
		lblViewAvailableBuses.setForeground(Color.WHITE);
		lblViewAvailableBuses.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblViewAvailableBuses.setBounds(143, 212, 173, 32);
		contentPane.add(lblViewAvailableBuses);
		
		JLabel lblBusId = new JLabel("Bus ID :");
		lblBusId.setForeground(Color.WHITE);
		lblBusId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBusId.setBounds(153, 349, 81, 32);
		contentPane.add(lblBusId);
		
		JLabel lblPassengerId = new JLabel("Passenger ID :");
		lblPassengerId.setForeground(Color.WHITE);
		lblPassengerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId.setBounds(153, 411, 114, 32);
		contentPane.add(lblPassengerId);
		
		JLabel lblSeatNo = new JLabel("No. of Seats :");
		lblSeatNo.setForeground(Color.WHITE);
		lblSeatNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeatNo.setBounds(465, 349, 112, 32);
		contentPane.add(lblSeatNo);
		
		t4 = new JTextField();
		t4.setEditable(false);
		t4.setFont(new Font("Tahoma", Font.BOLD, 17));
		t4.setColumns(10);
		t4.setBounds(593, 415, 118, 32);
		contentPane.add(t4);
		
		JLabel lblDate = new JLabel("Booking Date :");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(153, 474, 118, 32);
		contentPane.add(lblDate);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t3.setColumns(10);
		t3.setBounds(277, 475, 118, 32);
		contentPane.add(t3);
		
		JLabel lblFare = new JLabel("Total Cost (Rs):");
		lblFare.setForeground(Color.WHITE);
		lblFare.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFare.setBounds(451, 412, 132, 32);
		contentPane.add(lblFare);
		
		JButton btnLogout = new JButton("BACK");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				new Main().setVisible(true);
				setVisible(false);				
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(153, 561, 100, 40);
		contentPane.add(btnLogout);
		
		JLabel lblTicketBooking = new JLabel("TICKET BOOKING");
		lblTicketBooking.setForeground(Color.WHITE);
		lblTicketBooking.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTicketBooking.setBackground(Color.YELLOW);
		lblTicketBooking.setBounds(277, 10, 306, 67);
		contentPane.add(lblTicketBooking);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\1116905.jpg"));
		lblNewLabel_1.setBounds(0, 0, 832, 679);
		contentPane.add(lblNewLabel_1);
	}
}
