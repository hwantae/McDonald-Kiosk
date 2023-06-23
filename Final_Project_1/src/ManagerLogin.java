import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerLogin extends JFrame {

	private JPanel contentPane;
	private JButton btnManager;
	private JButton btnCustomer;
	private JLabel lblNewLabel;
	private JTextField textFieldNumOfCust;
	private JTextField textFieldSales;
	private JLabel lbCustomers;
	private JLabel lbSales;
	private JButton btnGoBack;
	private JButton btnShopClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLogin frame = new ManagerLogin();
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
	public ManagerLogin() {
		//when ManagerLogin window is opened, it shows number of customer came to shop and total sales.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader("total_sales.txt"));
					String line = br.readLine();
					String line2 = br.readLine();
					textFieldNumOfCust.setText(line2);
					textFieldSales.setText(line);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					FileOutputStream fileObject1;
					try {
						fileObject1 = new FileOutputStream("total_sales.txt", false);
						PrintWriter writer1 = new PrintWriter(fileObject1);
						writer1.print("0\n");
						writer1.print("0\n");
						writer1.close();
						fileObject1.close();
						br = new BufferedReader(new FileReader("total_sales.txt"));
						String line = br.readLine();
						String line2 = br.readLine();
						textFieldNumOfCust.setText(line2);
						textFieldSales.setText(line);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 623);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(194, 13, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ManagerLogin.class.getResource("/image/로고2.png")));
		lblNewLabel.setBounds(56, 64, 51, 47);
		contentPane.add(lblNewLabel);
		
		textFieldNumOfCust = new JTextField();
		textFieldNumOfCust.setBounds(321, 244, 156, 28);
		contentPane.add(textFieldNumOfCust);
		textFieldNumOfCust.setColumns(10);
		textFieldNumOfCust.setEditable(false);
		
		textFieldSales = new JTextField();
		textFieldSales.setBounds(321, 304, 156, 28);
		contentPane.add(textFieldSales);
		textFieldSales.setColumns(10);
		textFieldSales.setEditable(false);
		
		lbCustomers = new JLabel("Number of customers");
		lbCustomers.setForeground(new Color(255, 255, 255));
		lbCustomers.setFont(new Font("굴림", Font.BOLD, 23));
		lbCustomers.setBounds(55, 245, 249, 22);
		contentPane.add(lbCustomers);
		
		lbSales = new JLabel("Overall sales");
		lbSales.setForeground(new Color(255, 255, 255));
		lbSales.setFont(new Font("굴림", Font.BOLD, 23));
		lbSales.setBounds(133, 305, 176, 22);
		contentPane.add(lbSales);
		
		btnGoBack = new JButton("Back to First Screen");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstScreen screen = new FirstScreen();
				screen.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setBounds(165, 447, 206, 31);
		contentPane.add(btnGoBack);
		
		btnShopClose = new JButton("Shop close");
		//if btnShopClose is clicked, it resets the number of customer and total sales to 0 and close ManagerLogin screen and open first screen.
		btnShopClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream fileObject1;
				try {
					fileObject1 = new FileOutputStream("total_sales.txt", false);
					PrintWriter writer1 = new PrintWriter(fileObject1);
					writer1.print("0\n");
					writer1.print("0\n");
					writer1.close();
					fileObject1.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FirstScreen screen = new FirstScreen();
				screen.setVisible(true);
				dispose();
				
			}
		});
		btnShopClose.setBounds(165, 493, 206, 31);
		contentPane.add(btnShopClose);
	}
}
