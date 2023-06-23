import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FirstScreen extends JFrame {

	private JPanel contentPane;
	private JButton btnCustomer;
	private JLabel logo;
	private JLabel slogan;
	private JButton btnManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstScreen frame = new FirstScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 847);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194, 13, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnCustomer = new JButton("Order");
		// if btnCustomer is clicked, Kiosk appears and FirstScreen disappears.
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kiosk customer = new Kiosk();
				customer.setVisible(true);
				dispose();
			}
		});
		btnCustomer.setBounds(247, 632, 158, 62);
		contentPane.add(btnCustomer);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(FirstScreen.class.getResource("/image/McDonald.PNG")));
		logo.setBounds(162, 144, 318, 276);
		contentPane.add(logo);
		
		slogan = new JLabel("I'm lovin' it!");
		slogan.setForeground(Color.WHITE);
		slogan.setFont(new Font("굴림", Font.BOLD, 60));
		slogan.setHorizontalAlignment(SwingConstants.CENTER);
		slogan.setBounds(142, 456, 361, 61);
		contentPane.add(slogan);
		
		btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {	
			// if btnManager is clicked, LoginDialog appears and FirstScreen disappears.
			public void actionPerformed(ActionEvent e) {
				LoginDialog manager = new LoginDialog();
				manager.setVisible(true);
				dispose();
			}
		});
		btnManager.setBounds(262, 736, 125, 31);
		contentPane.add(btnManager);
	}
}