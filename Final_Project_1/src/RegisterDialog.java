import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;
	private JPasswordField passwordField;
	private JPasswordField confirmedPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterDialog dialog = new RegisterDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisterDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbID = new JLabel("ID:");
			lbID.setBounds(67, 62, 78, 22);
			contentPanel.add(lbID);
		}
		{
			JLabel lbPW = new JLabel("Password:");
			lbPW.setBounds(67, 99, 119, 22);
			contentPanel.add(lbPW);
		}
		{
			JLabel lbConfirmedPW = new JLabel("Password confirm:");
			lbConfirmedPW.setBounds(67, 137, 156, 22);
			contentPanel.add(lbConfirmedPW);
		}
		{
			textFieldID = new JTextField();
			textFieldID.setBounds(227, 59, 156, 28);
			contentPanel.add(textFieldID);
			textFieldID.setColumns(10);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(227, 96, 156, 28);
			contentPanel.add(passwordField);
		}
		{
			confirmedPasswordField = new JPasswordField();
			confirmedPasswordField.setBounds(227, 134, 156, 28);
			contentPanel.add(confirmedPasswordField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				//when ok button is pressed
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//this if statement checks whether passwordfield and confirmedpasswordfield have same password.
						//only if they are same, it is registered.

						try {
							//this if statement checks whether textFieldID and passwordField are empty or not.
							//if one of them or both of them are empty, it throws NoIDorPWException.
							if (textFieldID.getText().equals("")||passwordField.getText().equals("")||confirmedPasswordField.getText().equals("")) {
								throw new NoIDorPWException();
							}
							//this if statement checks whether passwordfield and confirmedpasswordfield have same password.
							//if they are same, it is registered.
							if (passwordField.getText().equals(confirmedPasswordField.getText())) {
								FileOutputStream fileObject;
								try {
									fileObject = new FileOutputStream("data.txt", false);
									PrintWriter writer = new PrintWriter(fileObject);
									writer.print(textFieldID.getText()+"\n");
									writer.print(confirmedPasswordField.getText()+"\n");
									writer.close();
									fileObject.close();
									JOptionPane.showMessageDialog(null, "You are registered!");
									LoginDialog screen = new LoginDialog();
									screen.setVisible(true);
									dispose();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Your password and confirm password are different. please try again.","Error Message", JOptionPane.ERROR_MESSAGE);
							}
						} catch(NoIDorPWException e1) {
							JOptionPane.showMessageDialog(null, "You should enter both ID and password.","Error Message", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
