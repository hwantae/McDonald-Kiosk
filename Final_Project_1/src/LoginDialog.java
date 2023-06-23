import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IDText;
	private JLabel lbID;
	private JLabel lbPassword;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		IDText = new JTextField();
		IDText.setBounds(178, 63, 190, 28);
		contentPanel.add(IDText);
		IDText.setColumns(10);
		
		lbID = new JLabel("ID:");
		lbID.setBounds(83, 66, 78, 22);
		contentPanel.add(lbID);
		
		lbPassword = new JLabel("Password:");
		lbPassword.setBounds(83, 125, 112, 22);
		contentPanel.add(lbPassword);
		
		lblNewLabel_2 = new JLabel("Manager Login");
		lblNewLabel_2.setBounds(83, 15, 161, 22);
		contentPanel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 122, 190, 28);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				//when ok button is pressed, it firstly checks whether data.txt is present.
				//if there is no data.txt, LoginDialog disposes and RegisterDialog appears.
				//if there is data.txt, it checks whether id and password are same or not.
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							BufferedReader br;
							br = new BufferedReader(new FileReader("data.txt"));
							List<String> info = new ArrayList<String>();
							info.add(br.readLine());
							info.add(br.readLine());
							if (IDText.getText().equals(info.get(0))&&passwordField.getText().equals(info.get(1))) {
								ManagerLogin screen = new ManagerLogin();
								screen.setVisible(true);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Your ID or password is incorrect. Please try again.","Error Message", JOptionPane.ERROR_MESSAGE);
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "You need to register first!");
							RegisterDialog screen = new RegisterDialog();
							screen.setVisible(true);
							dispose();
							//e1.printStackTrace();
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				//when cancel button is pressed, it returns to first screen.
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FirstScreen screen = new FirstScreen();
						screen.setVisible(true);
						dispose();
					}
				});

				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

