import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	private JFrame frmFacebookLoginPage;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ReadFile read = new ReadFile();
		ArrayList<User> users = read
				.readFileUsers(args[0]); /* arg[0]=users.txt */
		read.readFileCommands(args[1], users); /* arg[1]=commands.txt */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main(users);
					window.frmFacebookLoginPage.setVisible(true);
					window.frmFacebookLoginPage.setLocationRelativeTo(null);
					window.frmFacebookLoginPage.setResizable(false);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main(ArrayList<User> users) {
		initialize(users);
	}

	private void initialize(ArrayList<User> users) {
		JList list_1 = new JList();
		list_1.setVisibleRowCount(1);

		frmFacebookLoginPage = new JFrame();
		frmFacebookLoginPage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				list_1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				list_1.setModel(new AbstractListModel() {
					public int getSize() {
						return users.size();
					}

					public Object getElementAt(int index) {
						return users.get(index).getUsername();
					}
				});
			}
		});
		frmFacebookLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFacebookLoginPage.getContentPane().setBackground(Color.WHITE);
		frmFacebookLoginPage.setBackground(Color.WHITE);
		frmFacebookLoginPage.setTitle("Facebook Login Page");
		frmFacebookLoginPage.setBounds(100, 100, 697, 588);

		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\workspaceJava\\FacebookSystem\\Facebooklogo1.png"));
		
		JFormattedTextField UsernameField = new JFormattedTextField();
		UsernameField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		UsernameField.setValue("");

		JButton btnLoginButton = new JButton("Login");
		btnLoginButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean control = false;
				if (!(passwordField.getText().equals("") || UsernameField.getText().equals(""))) {
					for (int i = 0; i < users.size(); i++) {
						if (users.get(i).getUsername().equals(UsernameField.getValue().toString())) {
							if (users.get(i).getPassword().equals(passwordField.getText())) {
								control = true;
								LoggedPage lp = new LoggedPage(users, i);
								lp.LoggedPage(users, i);
								break;
							} else {
								JOptionPane.showMessageDialog(null, "Password Is Not Correct!");
								control = true;
								break;
							}
						}
					}
					if (control == false) {
						JOptionPane.showMessageDialog(null, "Username Does Not Exist!");
					}

				} else
					JOptionPane.showMessageDialog(null, "Username or Password Space Must Be Filled!");

			}
		});
		btnLoginButton.setBackground(new Color(220, 220, 220));
		btnLoginButton.setBorder(UIManager.getBorder("CheckBox.border"));

		JLabel lblNewLabel_1 = new JLabel("Registered Users");

		JLabel lblNewLabel_2 = new JLabel(" Username");

		JLabel lblNewLabel_3 = new JLabel(" Password");

		list_1.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent mouseEvent) {
				int index = list_1.locationToIndex(mouseEvent.getPoint());
				UsernameField.setValue(users.get(index).getUsername());
				passwordField.setText(users.get(index).getPassword());
				list_1.setSelectedIndex(index);
			}
		});
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return users.size();
			}

			public Object getElementAt(int index) {
				return users.get(index).getUsername();
			}
		});

		JButton btnNewButton = new JButton("Remove User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (list_1.isSelectedIndex(list_1.getSelectedIndex())) {
					if (response == JOptionPane.YES_OPTION) {
						int index = list_1.getSelectedIndex();
						users.remove(index);
						list_1.setModel(new AbstractListModel() {
							public int getSize() {
								return users.size();
							}

							public Object getElementAt(int index) {
								return users.get(index).getUsername();
							}
						});
					}
				} else
					JOptionPane.showMessageDialog(null, "A User Must Be Selected For Removing!");

			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));

		JButton btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUser nw = new CreateUser(users);
				nw.CreateUser(users);
			}
		});
		btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewUser.setBackground(new Color(220, 220, 220));
		btnNewUser.setBorder(UIManager.getBorder("CheckBox.border"));

		passwordField = new JPasswordField();

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setMaximum(0);
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);


		GroupLayout groupLayout = new GroupLayout(frmFacebookLoginPage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(list_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
									.addComponent(scrollBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
										.addComponent(btnNewUser, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
								.addGap(67))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(11)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel_2)
									.addComponent(lblNewLabel_3))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordField)
									.addComponent(btnLoginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(UsernameField, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
								.addGap(70)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(100)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnLoginButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewUser))
					.addContainerGap())
		);
		frmFacebookLoginPage.getContentPane().setLayout(groupLayout);
	}
}
