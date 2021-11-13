package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login {
	
	private JFrame frame;

	public static void main(String[] args)	throws Exception
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOnlineBusBooking = new JLabel("ONLINE BUS BOOKING");
		lblOnlineBusBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineBusBooking.setForeground(Color.WHITE);
		lblOnlineBusBooking.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 48));
		lblOnlineBusBooking.setBackground(Color.YELLOW);
		lblOnlineBusBooking.setBounds(0, 343, 710, 79);
		frame.getContentPane().add(lblOnlineBusBooking);
		
		JLabel lblWelcomeTo = new JLabel("WELCOME TO");
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeTo.setForeground(Color.WHITE);
		lblWelcomeTo.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 48));
		lblWelcomeTo.setBackground(Color.YELLOW);
		lblWelcomeTo.setBounds(0, 0, 710, 79);
		frame.getContentPane().add(lblWelcomeTo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				new ulogin().setVisible(true);
				setVisible(false);
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MANU\\Downloads\\people-inside-bus.jpg"));
		lblNewLabel.setBounds(0, 0, 710, 422);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
