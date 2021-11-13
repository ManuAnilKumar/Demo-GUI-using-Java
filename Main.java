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

public class Main extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBooking = new JButton("VIEW TICKET");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new Ticket().setVisible(true);
				setVisible(false);
			}
		});
		btnBooking.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBooking.setBounds(183, 170, 160, 40);
		contentPane.add(btnBooking);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setForeground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new ulogin().setVisible(true);
				setVisible(false);				
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogout.setBounds(203, 252, 120, 40);
		contentPane.add(btnLogout);
		
		JButton btnBook = new JButton("BOOKING");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				new Booking().setVisible(true);
				setVisible(false);
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBook.setBounds(183, 92, 160, 40);
		contentPane.add(btnBook);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblHome.setBackground(Color.YELLOW);
		lblHome.setBounds(203, 0, 113, 67);
		contentPane.add(lblHome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\3974b17c7714a3a3dbf9b79577e01729.jpg"));
		lblNewLabel.setBounds(0, 0, 534, 380);
		contentPane.add(lblNewLabel);
	}
}
