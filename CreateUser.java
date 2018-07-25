import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;


public class CreateUser {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField birthDay;

	private Date birth;
	private String relation;

	/**
	 * Launch the application.
	 */
	public static void CreateUser(ArrayList<User> users) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser window = new CreateUser(users);
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateUser(ArrayList<User> users) {
		initialize(users);
	}

	private void initialize(ArrayList<User> users) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 506);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user\\workspaceJava\\FacebookSystem\\Facebooklogo1.png"));

		JLabel lblNewLabel = new JLabel("Create User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_2 = new JLabel("Password (re-type)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_3 = new JLabel("Name Surname");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_4 = new JLabel("School Graduated");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("Birth Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_6 = new JLabel("Relationship Status");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat Date_Format = new SimpleDateFormat("dd/MM/yyyy");
				boolean birthdayEmpty = false;
				try {
					if (birthDay.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "All Spaces Must Be Filled!");
						birthdayEmpty = true;
					} else {
						birth = Date_Format.parse(birthDay.getText());
					}

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!(textField_3.getText().equals("") || textField.getText().equals("")
						|| passwordField_1.getText().equals("") || passwordField.getText().equals("")
						|| textField_4.getText().equals(""))) {

					if (passwordField.getText().equals(passwordField_1.getText())) {
						users.add(new User(textField_3.getText(), textField.getText(), passwordField.getText(),
								textField_4.getText(), relation, birth));
						if(birthdayEmpty == false){
							JOptionPane.showMessageDialog(null, "Success!");
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Passwords Must Be Same!");
					}
				} else {
					if (birthdayEmpty == false) {
						JOptionPane.showMessageDialog(null, "All Spaces Must Be Filled!");
					}

				}
			}
		});

		textField = new JTextField();
		textField.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		birthDay = new JTextField();
		birthDay.setColumns(10);

		JList list = new JList();

		passwordField = new JPasswordField();

		passwordField_1 = new JPasswordField();

		String[] tempRelation = { "In a relationship", "Divorced", "Complicated", "Single" };
		JComboBox comboBox = new JComboBox(tempRelation);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relation = comboBox.getSelectedItem().toString();
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(lblNewLabel_6).addContainerGap(309, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addGap(164)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(182, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
												groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(lblNewLabel_2, Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE, 117,
																				Short.MAX_VALUE)
																		.addComponent(lblUsername, Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE, 117,
																				Short.MAX_VALUE))
																.addGap(25))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblNewLabel_1).addGap(84)))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblNewLabel_5).addGap(81)))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_3).addGap(48)))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_4)
												.addGap(33)))
										.addGroup(
												groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
														.createParallelGroup(Alignment.LEADING).addGroup(
																groupLayout.createSequentialGroup()
																		.addComponent(textField_3,
																				GroupLayout.PREFERRED_SIZE, 242,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(40, Short.MAX_VALUE))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
																		87, GroupLayout.PREFERRED_SIZE)
																.addContainerGap())
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(passwordField_1,
																		GroupLayout.PREFERRED_SIZE, 87,
																		GroupLayout.PREFERRED_SIZE)
																.addContainerGap())
														.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(textField,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(btnNewButton,
																						GroupLayout.DEFAULT_SIZE, 93,
																						Short.MAX_VALUE)
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addComponent(list,
																								GroupLayout.PREFERRED_SIZE,
																								1,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(comboBox, 0, 241,
																								Short.MAX_VALUE)))
																		.addComponent(textField_4, Alignment.LEADING,
																				GroupLayout.PREFERRED_SIZE, 242,
																				GroupLayout.PREFERRED_SIZE))
																.addGap(206)))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(birthDay, GroupLayout.PREFERRED_SIZE, 86,
																		GroupLayout.PREFERRED_SIZE)
																.addContainerGap())))
								.addGroup(groupLayout
										.createSequentialGroup().addGap(54).addComponent(label,
												GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(78, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblUsername).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(
						passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4).addComponent(
						textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5).addComponent(
						birthDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_6)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(42).addComponent(btnNewButton).addGap(12)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
