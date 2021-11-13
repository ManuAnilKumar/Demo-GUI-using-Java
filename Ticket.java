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
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ticket extends JFrame {

	private JPanel contentPane;
	private JTextField t5;
	private JComboBox cb1;
	private JTextField t3;
	private JTextField t4;
	private JTextField t9;
	private JTextField t10;
	private JTextField t8;
	private JTextField t7;
	private JTextField t6;
	private JTextField t11;
	private JButton btnCancelBooking;
	private JLabel lblTicket;
	private JTextField tt;
	private JLabel lblNewLabel;
	private JTextField ttt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ticket() {
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("TICKET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTicketId = new JLabel("TICKET ID :");
		lblTicketId.setForeground(Color.WHITE);
		lblTicketId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTicketId.setBounds(73, 197, 147, 32);
		contentPane.add(lblTicketId);
		
		JLabel lblPassengerId = new JLabel("PASSENGER ID :");
		lblPassengerId.setForeground(Color.WHITE);
		lblPassengerId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId.setBounds(73, 138, 147, 32);
		contentPane.add(lblPassengerId);
		
		JLabel lblBusId = new JLabel("BUS ID :");
		lblBusId.setForeground(Color.WHITE);
		lblBusId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBusId.setBounds(73, 255, 147, 32);
		contentPane.add(lblBusId);
		
		JLabel lblSeatNo = new JLabel("NO. OF SEATS :");
		lblSeatNo.setForeground(Color.WHITE);
		lblSeatNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeatNo.setBounds(497, 80, 147, 32);
		contentPane.add(lblSeatNo);
		
		JLabel lblDate = new JLabel("DATE :");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(497, 138, 147, 32);
		contentPane.add(lblDate);
		
		JLabel lblFare = new JLabel("TOTAL COST (Rs):");
		lblFare.setForeground(Color.WHITE);
		lblFare.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblFare.setBounds(238, 439, 200, 45);
		contentPane.add(lblFare);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(654, 139, 159, 32);
		contentPane.add(t5);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(230, 256, 159, 32);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(654, 80, 159, 32);
		contentPane.add(t4);
		
		t9 = new JTextField();
		t9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t9.setEditable(false);
		t9.setColumns(10);
		t9.setBounds(654, 369, 159, 32);
		contentPane.add(t9);
		
		t10 = new JTextField();
		t10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		t10.setEditable(false);
		t10.setColumns(10);
		t10.setBounds(448, 446, 159, 32);
		contentPane.add(t10);
		
		JLabel lblPassengerId_1_1_1 = new JLabel("DEPATURE TIME :");
		lblPassengerId_1_1_1.setForeground(Color.WHITE);
		lblPassengerId_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId_1_1_1.setBounds(497, 368, 147, 32);
		contentPane.add(lblPassengerId_1_1_1);
		
		JLabel lblPassengerId_1_1_1_1 = new JLabel("ARRIVAL TIME :");
		lblPassengerId_1_1_1_1.setForeground(Color.WHITE);
		lblPassengerId_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId_1_1_1_1.setBounds(497, 310, 147, 32);
		contentPane.add(lblPassengerId_1_1_1_1);
		
		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t8.setEditable(false);
		t8.setColumns(10);
		t8.setBounds(654, 311, 159, 32);
		contentPane.add(t8);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 16));
		t7.setEditable(false);
		t7.setColumns(10);
		t7.setBounds(654, 255, 159, 32);
		contentPane.add(t7);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 16));
		t6.setEditable(false);
		t6.setColumns(10);
		t6.setBounds(654, 197, 159, 32);
		contentPane.add(t6);
		
		cb1 = new JComboBox();
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) 
			{
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
				Statement stmt=(Statement) con.createStatement();
				
				String s1=cb1.getItemAt(cb1.getSelectedIndex()).toString();
				
				String q="select * from TICKET where TICKET_ID = '"+s1+"'";
				ResultSet res=stmt.executeQuery(q);
				
					if(res.next())
					{						
						t3.setText(res.getString(3));
						t4.setText(res.getString(4));
						t5.setText(res.getString(5));
						t10.setText(res.getString(6));
						t11.setText(res.getString(7));
					}				
				}				
				catch(Exception se) {}

				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
				Statement stmt=(Statement) con.createStatement();
				
				String s2=cb1.getItemAt(cb1.getSelectedIndex()).toString();
				
				String q="select * from BUS where BUS_ID in(select BUS_ID from TICKET where TICKET_ID='"+s2+"')";
				ResultSet res=stmt.executeQuery(q);
				
					if(res.next())
					{
						t8.setText(res.getString(3));
						t9.setText(res.getString(4));						
					}				
				}
				
				catch(Exception se) {}

				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
				Statement stmt=(Statement) con.createStatement();
				
				String s3=cb1.getItemAt(cb1.getSelectedIndex()).toString();
				
				String q="select * from ROUTE where ROUTE_ID in(select ROUTE_ID from TICKET where TICKET_ID='"+s3+"')";
				ResultSet res=stmt.executeQuery(q);
				
					if(res.next())
					{
						t6.setText(res.getString(2));
						t7.setText(res.getString(3));						
					}				
				}
				
				catch(Exception se) {}								
			}
		});
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb1.setEditable(false);
		cb1.setBounds(230, 197, 159, 32);
		contentPane.add(cb1);
		
		JLabel lblPassengerId_1 = new JLabel("ORIGIN :");
		lblPassengerId_1.setForeground(Color.WHITE);
		lblPassengerId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId_1.setBounds(497, 197, 147, 32);
		contentPane.add(lblPassengerId_1);
		
		JLabel lblPassengerId_1_1 = new JLabel("DESTINATION :");
		lblPassengerId_1_1.setForeground(Color.WHITE);
		lblPassengerId_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId_1_1.setBounds(497, 255, 147, 32);
		contentPane.add(lblPassengerId_1_1);
				
		ttt = new JTextField();
		ttt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{				
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
				Statement stmt=(Statement) con.createStatement();
				
				String s3=ttt.getText();
				
				String q="select * from PASSENGER where USERNAME ='"+s3+"'";
				ResultSet res=stmt.executeQuery(q);
				
					if(res.next())
					{
						tt.setText(res.getString(1));						
					}				
				}
				
				catch(Exception se) {}	
			}
		});
		ttt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ttt.setColumns(10);
		ttt.setBounds(230, 81, 159, 32);
		contentPane.add(ttt);
				
		JButton btnConfirm = new JButton("BACK TO MAIN");
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new Main().setVisible(true);
				setVisible(false);				
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConfirm.setBounds(498, 518, 200, 50);
		contentPane.add(btnConfirm);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
			Statement stmt=(Statement) con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from TICKET");
			
			JLabel lblRouteId = new JLabel("ROUTE ID :");
			lblRouteId.setForeground(Color.WHITE);
			lblRouteId.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRouteId.setBounds(73, 310, 147, 32);
			contentPane.add(lblRouteId);
			
			t11 = new JTextField();
			t11.setFont(new Font("Tahoma", Font.PLAIN, 15));
			t11.setEditable(false);
			t11.setColumns(10);
			t11.setBounds(230, 310, 159, 32);
			contentPane.add(t11);
			
			btnCancelBooking = new JButton("CANCEL BOOKING");
			btnCancelBooking.setForeground(Color.BLACK);
			btnCancelBooking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
										
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
					Statement stmt=(Statement) con.createStatement();
					
					String s1=cb1.getItemAt(cb1.getSelectedIndex()).toString();
					
					String q="delete from TICKET where TICKET_ID='"+s1+"'";
					ResultSet res=stmt.executeQuery(q);
											
					JOptionPane.showMessageDialog(null, "You have successfully canceled your booking");
					new Ticket().setVisible(true);
					setVisible(false);					
					}
					
					catch(Exception se) {}				
				}
			});
			btnCancelBooking.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnCancelBooking.setBounds(189, 519, 200, 50);
			contentPane.add(btnCancelBooking);
			
			lblTicket = new JLabel("TICKET");
			lblTicket.setHorizontalAlignment(SwingConstants.CENTER);
			lblTicket.setForeground(Color.WHITE);
			lblTicket.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblTicket.setBackground(Color.YELLOW);
			lblTicket.setBounds(389, 0, 140, 67);
			contentPane.add(lblTicket);
			
			tt = new JTextField();
			tt.setEditable(false);
			tt.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) 
				{
										
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Manu1234");
						
					Statement stmt=(Statement) con.createStatement();
					String r="select TICKET_ID from TICKET where PASSENGER_ID ='"+tt.getText()+"'";
										
					ResultSet res=stmt.executeQuery(r);
					
					while(res.next())
					{
						cb1.addItem(res.getString(1));					
					}					
					}
					
					catch(Exception se)
					{}					
				}
			});
			
			tt.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tt.setColumns(10);
			tt.setBounds(230, 139, 159, 32);
			contentPane.add(tt);
			
			}
			catch(Exception e1)
			{}
		
		JLabel lblPassengerId_2 = new JLabel("NAME :");
		lblPassengerId_2.setForeground(Color.WHITE);
		lblPassengerId_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassengerId_2.setBounds(73, 80, 147, 32);
		contentPane.add(lblPassengerId_2);		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\329313.jpg"));
		lblNewLabel.setBounds(0, 0, 926, 657);
		contentPane.add(lblNewLabel);
	
	}
}
