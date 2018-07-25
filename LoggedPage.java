import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class LoggedPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtSchool;

	private String relation;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void LoggedPage(ArrayList<User> users, int index) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoggedPage window = new LoggedPage(users, index);
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
	public LoggedPage(ArrayList<User> users, int index) {
		initialize(users, index);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<User> users, int index) {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 905, 749);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setForeground(Color.BLUE);

		JLabel label = new JLabel("");

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\workspaceJava\\FacebookSystem\\personicon8.png"));

		JLabel lblProfileName = new JLabel(users.get(index).getName());

		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));

		textField_1 = new JTextField();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date(users.get(index).getBirthday().getTime()));
		textField_1.setText(date);
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("");

		JLabel label_2 = new JLabel("");

		JLabel lblSchoolGraduated = new JLabel("School Graduated");
		lblSchoolGraduated.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtSchool = new JTextField();
		txtSchool.setText(users.get(index).getGraduatedSchool());
		txtSchool.setColumns(10);

		JLabel lblRelationshipStatus = new JLabel("Relationship Status");
		lblRelationshipStatus.setFont(new Font("Tahoma", Font.BOLD, 11));

		String[] tempRelation = { "In a relationship", "Divorced", "Complicated", "Single" };
		JComboBox comboBox = new JComboBox(tempRelation);
		comboBox.setEditable(true);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relation = comboBox.getSelectedItem().toString();
			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				users.get(index).setGraduatedSchool(txtSchool.getText());
				users.get(index).setRelationshipStatus(comboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, "Informations Updated Successfully!");
			}
		});

		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				int index = list.locationToIndex(mouseEvent.getPoint());
			}
		});
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return users.get(index).getContact().size();
			}

			public Object getElementAt(int index2) {
				return users.get(index).getContact().get(index2).getUsername();
			}
		});
		list.setSelectedIndex(0);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0)));

		btnUpdate.setBackground(new Color(220, 220, 220));
		btnUpdate.setBorder(UIManager.getBorder("CheckBox.border"));

		JLabel lblNewLabel_1 = new JLabel("Friends");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnNewButton = new JButton("Remove Selected User");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Normal");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(true);
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent mouseEvent) {
						int index = list.locationToIndex(mouseEvent.getPoint());
						list.setSelectedIndex(index);
					}
				});
				list.setModel(new AbstractListModel() {
					public int getSize() {
						return users.get(index).getContact().size();
					}

					public Object getElementAt(int index2) {
						return users.get(index).getContact().get(index2).getUsername();
					}
				});
				list.setSelectedIndex(0);
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
					}
				});
				list.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
		});
		JRadioButton rdbtnBlocked = new JRadioButton("Blocked");
		rdbtnBlocked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(false);
			}
		});
		rdbtnBlocked.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent mouseEvent) {
						int index = list.locationToIndex(mouseEvent.getPoint());
					}
				});
				list.setModel(new AbstractListModel() {
					public int getSize() {
						return users.get(index).getBlocked().size();
					}

					public Object getElementAt(int index2) {
						return users.get(index).getBlocked().get(index2).getUsername();
					}
				});
				list.setSelectedIndex(0);
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
					}
				});
				list.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
		});
		buttonGroup.add(rdbtnBlocked);

		// JButton btnNewButton = new JButton("Remove Selected User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected() == true) {
					if (list.isSelectedIndex(list.getSelectedIndex())) {
						int index2 = list.getSelectedIndex();
						users.get(index).getBlocked().add(users.get(index).getContact().get(index2));
						users.get(index).getContact().remove(users.get(index).getContact().get(index2));
						list.setModel(new AbstractListModel() {
							public int getSize() {
								return users.get(index).getContact().size();
							}

							public Object getElementAt(int index2) {
								return users.get(index).getContact().get(index2).getUsername();
							}
						});
					}
				}

			}
		});

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(label).addGap(6)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(list, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_1, Alignment.LEADING).addComponent(txtSchool)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 210,
												Short.MAX_VALUE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblDateOfBirth).addComponent(label_1).addComponent(label_2)
										.addComponent(lblSchoolGraduated, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblRelationshipStatus).addComponent(lblInformation)
										.addComponent(btnUpdate))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnNewRadioButton)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnBlocked)))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblProfileName)
								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(26, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING).addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE,
								457, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(6)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(label).addComponent(lblNewLabel))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblInformation)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblDateOfBirth)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addGroup(groupLayout
														.createParallelGroup(Alignment.LEADING).addComponent(label_1)
														.addComponent(label_2).addComponent(lblSchoolGraduated))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtSchool, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(lblRelationshipStatus)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnUpdate)
												.addGap(35)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel_1).addComponent(rdbtnNewRadioButton)
														.addComponent(rdbtnBlocked)))
										.addGroup(groupLayout.createSequentialGroup().addGap(134)
												.addComponent(lblProfileName)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton)))
						.addGap(133)));
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return users.get(index).getPosts().size();
			}

			public Object getElementAt(int index2) {
				return users.get(index).getPosts().get(index2).getText()
						+ users.get(index).getPosts().get(index2).getTagged();
			}
		});

		JScrollPane posts = new JScrollPane(list_1);
		tabbedPane.addTab("Posts", null, posts, null);

		JScrollPane friendsPosts = new JScrollPane();
		tabbedPane.addTab("Friend's Posts", null, friendsPosts, null);
		panel.setLayout(null);

		JLabel lblSearch = new JLabel("Search Friends");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearch.setForeground(new Color(255, 255, 255));
		lblSearch.setBounds(198, 11, 83, 14);
		panel.add(lblSearch);

		textField = new JTextField();
		textField.setBounds(291, 8, 261, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnCreateAPost = new JButton("Create a Post");
		btnCreateAPost.setBackground(new Color(220, 220, 220));
		btnCreateAPost.setBorder(UIManager.getBorder("CheckBox.border"));
		btnCreateAPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(291, 8, 261, 20);
		panel.add(comboBox_1);
		btnCreateAPost.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreateAPost.setBounds(682, 7, 109, 23);
		panel.add(btnCreateAPost);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnLogout.setBackground(new Color(220, 220, 220));
		btnLogout.setBorder(UIManager.getBorder("CheckBox.border"));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogout.setBounds(801, 7, 78, 23);
		panel.add(btnLogout);
		frame.getContentPane().setLayout(groupLayout);
	}
}
