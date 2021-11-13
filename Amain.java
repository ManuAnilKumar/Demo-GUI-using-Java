package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Amain extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Amain frame = new Amain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Amain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMyAccount = new JButton("VIEW ROUTES");
		btnMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				new Aroute().setVisible(true);
				setVisible(false);								
			}
		});
		btnMyAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMyAccount.setBounds(80, 110, 180, 40);
		contentPane.add(btnMyAccount);
		
		JButton btnBooking = new JButton("VIEW BUS");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				new Abus().setVisible(true);
				setVisible(false);				
			}
		});
		btnBooking.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBooking.setBounds(354, 110, 180, 40);
		contentPane.add(btnBooking);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				new Alogin().setVisible(true);
				setVisible(false);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogout.setBounds(228, 336, 120, 40);
		contentPane.add(btnLogout);
		
		JButton btnViewBooking = new JButton("VIEW BOOKING");
		btnViewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				new Abook().setVisible(true);
				setVisible(false);			
			}
		});
		btnViewBooking.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnViewBooking.setBounds(349, 220, 185, 40);
		contentPane.add(btnViewBooking);
		
		JButton btnViewUsers = new JButton("VIEW USERS");
		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				new Uprofile().setVisible(true);
				setVisible(false);								
			}
		});
		btnViewUsers.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnViewUsers.setBounds(80, 220, 180, 40);
		contentPane.add(btnViewUsers);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblHome.setBackground(Color.YELLOW);
		lblHome.setBounds(241, 0, 110, 67);
		contentPane.add(lblHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\329313.jpg"));
		lblNewLabel.setBounds(0, 0, 610, 479);
		contentPane.add(lblNewLabel);
	}
}
