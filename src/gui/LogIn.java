package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.ClientFrame;
import gui.LogIn;
import gui.ManagerFrame;
import accounts.Clients;
import accounts.Managers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUserNameSignUp;
	private JTextField txtEmail;
	private JPasswordField passwordFieldSignUp;
	private JTextField txtUserNameSignIn;
	private JPasswordField passwordFieldSignIn;

	
	/**
	 * Create the frame.
	 */
	public LogIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons\\bus (4).png"));
		this.setSize(684,460);
		this.setUndecorated(true);
		this.setResizable(true);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel BusPanel = new JPanel();
		BusPanel.setLayout(null);
		BusPanel.setBackground(new Color(97, 212, 195));
		BusPanel.setBounds(0, 0, 258, 460);
		contentPane.add(BusPanel);
		
		JLabel lblBusStation = new JLabel("<html>BUS<br/>STATION</html>");
		lblBusStation.setForeground(Color.WHITE);
		lblBusStation.setFont(new Font("Century Gothic", Font.PLAIN, 32));
		lblBusStation.setBounds(60, 78, 128, 72);
		BusPanel.add(lblBusStation);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icons\\busStop.png"));
		lblNewLabel.setBounds(60, 162, 128, 128);
		BusPanel.add(lblNewLabel);
		
		JLabel lblTwitter = new JLabel("");
		lblTwitter.setIcon(new ImageIcon("icons\\twitterLogo.png"));
		lblTwitter.setBounds(112, 396, 32, 32);
		BusPanel.add(lblTwitter);
		
		JLabel lblInstagram = new JLabel("");
		lblInstagram.setIcon(new ImageIcon("icons\\instagramLogo.png"));
		lblInstagram.setBounds(163, 396, 32, 32);
		BusPanel.add(lblInstagram);
		
		JLabel lblFacebook = new JLabel("");
		lblFacebook.setIcon(new ImageIcon("icons\\facebookLogo.png"));
		lblFacebook.setBounds(60, 396, 32, 32);
		BusPanel.add(lblFacebook);
		
		JButton btnManager = new JButton("MANAGER");
		btnManager.setBounds(10, 10, 75, 20);
		btnManager.setBorder(null);
		btnManager.setForeground(Color.WHITE);
		btnManager.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnManager.setBorder(null);
		btnManager.setBackground(new Color(97, 212, 195));
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Managers c = new Managers();
				c.name.setFirst("amr");
				c.name.setLast("fahmy");
				
				ManagerFrame x = new ManagerFrame(c);
				x.setVisible(true);
				
				dispose();
			}
		});
		BusPanel.add(btnManager);
		
		final JPanel SignInPanel = new JPanel();
		SignInPanel.setVisible(false);
		
		JLabel lblExitP2 = new JLabel("X");
		lblExitP2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		final JPanel SignUpPanel = new JPanel();
		SignUpPanel.setLayout(null);
		SignUpPanel.setBackground(new Color(36, 47, 65));
		SignUpPanel.setBounds(258, 0, 426, 460);
		contentPane.add(SignUpPanel);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUserName.setBounds(100, 112, 83, 19);
		SignUpPanel.add(lblUserName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEmail.setBounds(100, 189, 83, 19);
		SignUpPanel.add(lblEmail);
		
		JLabel label_4 = new JLabel("PASSWORD");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label_4.setBounds(100, 268, 83, 19);
		SignUpPanel.add(label_4);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblName.setBounds(100, 35, 83, 19);
		SignUpPanel.add(lblName);
		
		txtFirstName = new JTextField();
		txtFirstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtFirstName.setText(null);
			}
		});
		
		txtFirstName.setText("First Name");
		txtFirstName.setForeground(Color.WHITE);
		txtFirstName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtFirstName.setColumns(10);
		txtFirstName.setBorder(null);
		txtFirstName.setBackground(new Color(36, 47, 65));
		txtFirstName.setBounds(100, 65, 102, 20);
		SignUpPanel.add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtLastName.setText(null);
			}
		});
		txtLastName.setText("Last Name");
		txtLastName.setForeground(Color.WHITE);
		txtLastName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtLastName.setColumns(10);
		txtLastName.setBorder(null);
		txtLastName.setBackground(new Color(36, 47, 65));
		txtLastName.setBounds(230, 65, 102, 20);
		SignUpPanel.add(txtLastName);
		
		txtUserNameSignUp = new JTextField();
		txtUserNameSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtUserNameSignUp.setText(null);
			}
		});
		txtUserNameSignUp.setText("Enter Your User Name Here");
		txtUserNameSignUp.setForeground(Color.WHITE);
		txtUserNameSignUp.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtUserNameSignUp.setColumns(10);
		txtUserNameSignUp.setBorder(null);
		txtUserNameSignUp.setBackground(new Color(36, 47, 65));
		txtUserNameSignUp.setBounds(100, 142, 232, 20);
		SignUpPanel.add(txtUserNameSignUp);
		
		txtEmail = new JTextField();
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtEmail.setText(null);
			}
		});
		txtEmail.setText("Enter Your Email Here");
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(36, 47, 65));
		txtEmail.setBounds(100, 219, 232, 20);
		SignUpPanel.add(txtEmail);
		
		passwordFieldSignUp = new JPasswordField();
		passwordFieldSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				passwordFieldSignUp.setText(null);
			}
		});
		passwordFieldSignUp.setText("Password Here");
		passwordFieldSignUp.setForeground(Color.WHITE);
		passwordFieldSignUp.setBorder(null);
		passwordFieldSignUp.setBackground(new Color(36, 47, 65));
		passwordFieldSignUp.setBounds(100, 298, 216, 20);
		SignUpPanel.add(passwordFieldSignUp);
		
		final JSeparator separatorFirstName = new JSeparator();
		separatorFirstName.setForeground(Color.WHITE);
		separatorFirstName.setBackground(Color.WHITE);
		separatorFirstName.setBounds(100, 85, 102, 12);
		SignUpPanel.add(separatorFirstName);
		
		final JSeparator separatorLastName = new JSeparator();
		separatorLastName.setForeground(Color.WHITE);
		separatorLastName.setBackground(Color.WHITE);
		separatorLastName.setBounds(230, 85, 102, 12);
		SignUpPanel.add(separatorLastName);
		
		final JSeparator separatorUserNameSignUp = new JSeparator();
		separatorUserNameSignUp.setForeground(Color.WHITE);
		separatorUserNameSignUp.setBackground(Color.WHITE);
		separatorUserNameSignUp.setBounds(100, 163, 232, 12);
		SignUpPanel.add(separatorUserNameSignUp);
		
		final JSeparator separatorPasswordSignUp = new JSeparator();
		separatorPasswordSignUp.setForeground(Color.WHITE);
		separatorPasswordSignUp.setBackground(Color.WHITE);
		separatorPasswordSignUp.setBounds(100, 318, 232, 12);
		SignUpPanel.add(separatorPasswordSignUp);
		
		final JSeparator separatorEmail = new JSeparator();
		separatorEmail.setForeground(Color.WHITE);
		separatorEmail.setBackground(Color.WHITE);
		separatorEmail.setBounds(100, 239, 233, 12);
		SignUpPanel.add(separatorEmail);
		
		final JCheckBox checkBox = new JCheckBox("accept");
		checkBox.setSelected(true);
		checkBox.setForeground(Color.WHITE);
		checkBox.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		checkBox.setBorder(null);
		checkBox.setBackground(new Color(36, 47, 65));
		checkBox.setBounds(100, 337, 62, 23);
		SignUpPanel.add(checkBox);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(new Color(97, 212, 195));
		btnSignUp.setBounds(100, 396, 83, 32);
		SignUpPanel.add(btnSignUp);
		
		JButton btnCreateAccount = new JButton("already have account");
		btnCreateAccount.setForeground(Color.WHITE);
		btnCreateAccount.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnCreateAccount.setBorder(null);
		btnCreateAccount.setBackground(new Color(36, 47, 65));
		btnCreateAccount.setBounds(193, 394, 142, 38);
		SignUpPanel.add(btnCreateAccount);
		
		final JButton btnTerms = new JButton("terms and conditions");
		btnTerms.setForeground(Color.WHITE);
		btnTerms.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnTerms.setBorder(null);
		btnTerms.setBackground(new Color(36, 47, 65));
		btnTerms.setBounds(165, 339, 125, 19);
		SignUpPanel.add(btnTerms);
		
		JLabel lblExitP1 = new JLabel("X");
		lblExitP1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.saveOnExit();
				System.exit(0);
			}
		});
		lblExitP1.setForeground(Color.WHITE);
		lblExitP1.setFont(new Font("Tunga", Font.PLAIN, 22));
		lblExitP1.setBounds(400, 11, 16, 16);
		SignUpPanel.add(lblExitP1);
		
		JLabel lblSeePasswordSignUp = new JLabel("");
		lblSeePasswordSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				passwordFieldSignUp.setEchoChar((char)0);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				passwordFieldSignUp.setEchoChar('â—�');
				passwordFieldSignUp.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			}
		});
		lblSeePasswordSignUp.setIcon(new ImageIcon("icons\\eyeOpen.png"));
		lblSeePasswordSignUp.setForeground(Color.WHITE);
		lblSeePasswordSignUp.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblSeePasswordSignUp.setBounds(316, 298, 16, 16);
		SignUpPanel.add(lblSeePasswordSignUp);
				
				btnCreateAccount.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						SignInPanel.setVisible(true);
						SignUpPanel.setVisible(false);	
					}
				});
				btnSignUp.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent arg0) {
						boolean emptyFieldEncountered = false;

						if(txtFirstName.getText().isEmpty() || txtFirstName.getText().equals("First Name")) {
							emptyFieldEncountered = true;
							txtFirstName.setText("First Name");
							txtFirstName.setForeground(Color.RED);
							separatorFirstName.setForeground(Color.RED);
							separatorFirstName.setBackground(Color.RED);
						} else {
							txtFirstName.setForeground(Color.WHITE);
							separatorFirstName.setForeground(Color.WHITE);
							separatorFirstName.setBackground(Color.WHITE);
						}


						if(txtLastName.getText().isEmpty() || txtLastName.getText().equals("Last Name")) {
							emptyFieldEncountered = true;
							txtLastName.setText("Last Name");
							txtLastName.setForeground(Color.RED);
							separatorLastName.setForeground(Color.RED);
							separatorLastName.setBackground(Color.RED);
						} else {
							txtLastName.setForeground(Color.WHITE);
							separatorLastName.setForeground(Color.WHITE);
							separatorLastName.setBackground(Color.WHITE);
						}

						
						if(txtUserNameSignUp.getText().isEmpty() || txtUserNameSignUp.getText().equals("Enter Your User Name Here")) {
							emptyFieldEncountered = true;
							txtUserNameSignUp.setText("Enter Your User Name Here");
							txtUserNameSignUp.setForeground(Color.RED);
							separatorUserNameSignUp.setForeground(Color.RED);
							separatorUserNameSignUp.setBackground(Color.RED);
						} else {
							txtUserNameSignUp.setForeground(Color.WHITE);
							separatorUserNameSignUp.setForeground(Color.WHITE);
							separatorUserNameSignUp.setBackground(Color.WHITE);
						}

						
						if(txtEmail.getText().isEmpty() || txtEmail.getText().equals("Enter Your Email Here")) {
							emptyFieldEncountered = true;
							txtEmail.setText("Enter Your Email Here");
							txtEmail.setForeground(Color.RED);
							separatorEmail.setForeground(Color.RED);
							separatorEmail.setBackground(Color.RED);
						} else {
							txtEmail.setForeground(Color.WHITE);
							separatorEmail.setForeground(Color.WHITE);
							separatorEmail.setBackground(Color.WHITE);
						}

						
						if(passwordFieldSignUp.getText().isEmpty() || passwordFieldSignUp.getText().equals("Password Here")) {
							emptyFieldEncountered = true;
							passwordFieldSignUp.setText("Password Here");
							passwordFieldSignUp.setForeground(Color.RED);
							separatorPasswordSignUp.setForeground(Color.RED);
							separatorPasswordSignUp.setBackground(Color.RED);
						} else {
							passwordFieldSignUp.setForeground(Color.WHITE);
							separatorPasswordSignUp.setForeground(Color.WHITE);
							separatorPasswordSignUp.setBackground(Color.WHITE);
						}
						
						if(!checkBox.isSelected()) {
							emptyFieldEncountered = true;
							checkBox.setForeground(Color.RED);
							btnTerms.setForeground(Color.RED);
						} else {
							checkBox.setForeground(Color.WHITE);
							btnTerms.setForeground(Color.WHITE);
						}

						// sanity check
						if(emptyFieldEncountered)
							return;
							
						// create instance to store information
						Clients client = new Clients();
						
						client.name.setFirst(txtFirstName.getText());
						client.name.setLast(txtLastName.getText());
						client.setUserName(txtUserNameSignUp.getText());
						client.setEmail(txtEmail.getText());
						client.setUserPassword(passwordFieldSignUp.getText());
						
						
						// add to database
						Main.getClientsArrayList().add(client);
						
//						// add to database
//						try {
//							FileOutputStream clientsFile = new FileOutputStream("data-base\\clientsFile.ser", true);
//							ObjectOutputStream clientsObject = new ObjectOutputStream(clientsFile);
//
//							clientsObject.writeObject(client);
//
//							clientsObject.close();
//							clientsFile.close();
//						}
//						catch (FileNotFoundException e) {
//							System.out.println("File not found");
//						}
//						catch (IOException e) {
//							System.out.println("Error initializing stream");
//						}
						
						// switch to client frame
						setVisible(false);
						
						ClientFrame clientFrame = new ClientFrame(client);
						clientFrame.setVisible(true);
					}
				});
		lblExitP2.setForeground(Color.WHITE);
		lblExitP2.setFont(new Font("Tunga", Font.PLAIN, 22));
		lblExitP2.setBounds(400, 11, 16, 16);
		SignInPanel.add(lblExitP2);
		SignInPanel.setLayout(null);
		SignInPanel.setForeground(Color.WHITE);
		SignInPanel.setBackground(new Color(36, 47, 65));
		SignInPanel.setBounds(258, 0, 426, 461);
		contentPane.add(SignInPanel);
		
		JLabel lblUserNameSignIn = new JLabel("USER NAME");
		lblUserNameSignIn.setForeground(Color.WHITE);
		lblUserNameSignIn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUserNameSignIn.setBounds(100, 120, 83, 19);
		SignInPanel.add(lblUserNameSignIn);
		
		txtUserNameSignIn = new JTextField();
		txtUserNameSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtUserNameSignIn.setText("");
			}
		});
		txtUserNameSignIn.setText("Enter Your User Name Here");
		txtUserNameSignIn.setForeground(Color.WHITE);
		txtUserNameSignIn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtUserNameSignIn.setColumns(10);
		txtUserNameSignIn.setBorder(null);
		txtUserNameSignIn.setBackground(new Color(36, 47, 65));
		txtUserNameSignIn.setBounds(100, 150, 232, 20);
		SignInPanel.add(txtUserNameSignIn);
		
		final JSeparator separatorUserNameSignIn = new JSeparator();
		separatorUserNameSignIn.setForeground(Color.WHITE);
		separatorUserNameSignIn.setBackground(Color.WHITE);
		separatorUserNameSignIn.setBounds(100, 171, 232, 12);
		SignInPanel.add(separatorUserNameSignIn);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSignIn.setBorder(null);
		btnSignIn.setBackground(new Color(97, 212, 195));
		btnSignIn.setBounds(100, 396, 83, 32);
		SignInPanel.add(btnSignIn);
		
		JButton btnHaveAccount = new JButton("create new account");
		btnHaveAccount.setForeground(Color.WHITE);
		btnHaveAccount.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnHaveAccount.setBorder(null);
		btnHaveAccount.setBackground(new Color(36, 47, 65));
		btnHaveAccount.setBounds(196, 394, 139, 38);
		SignInPanel.add(btnHaveAccount);
		
		final JRadioButton radioButtonManger = new JRadioButton("Manger");
		radioButtonManger.setForeground(Color.WHITE);
		radioButtonManger.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		radioButtonManger.setBorder(null);
		radioButtonManger.setBackground(new Color(36, 47, 65));
		radioButtonManger.setBounds(100, 284, 109, 23);
		SignInPanel.add(radioButtonManger);
		
		final JRadioButton radioButtonClient = new JRadioButton("Client");
		radioButtonClient.setForeground(Color.WHITE);
		radioButtonClient.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		radioButtonClient.setBorder(null);
		radioButtonClient.setBackground(new Color(36, 47, 65));
		radioButtonClient.setBounds(226, 284, 109, 23);
		SignInPanel.add(radioButtonClient);
		
		passwordFieldSignIn = new JPasswordField();
		passwordFieldSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				passwordFieldSignIn.setText("");
			}
		});
		passwordFieldSignIn.setText("Password Here");
		passwordFieldSignIn.setForeground(Color.WHITE);
		passwordFieldSignIn.setBorder(null);
		passwordFieldSignIn.setBackground(new Color(36, 47, 65));
		passwordFieldSignIn.setBounds(100, 234, 216, 20);
		SignInPanel.add(passwordFieldSignIn);
		
		final JSeparator separatorPasswordSignIn = new JSeparator();
		separatorPasswordSignIn.setForeground(Color.WHITE);
		separatorPasswordSignIn.setBackground(Color.WHITE);
		separatorPasswordSignIn.setBounds(100, 254, 232, 12);
		SignInPanel.add(separatorPasswordSignIn);
		
		JLabel lblPasswordSignIn = new JLabel("PASSWORD");
		lblPasswordSignIn.setForeground(Color.WHITE);
		lblPasswordSignIn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPasswordSignIn.setBounds(100, 204, 83, 19);
		SignInPanel.add(lblPasswordSignIn);
		
		final JLabel lblUserNameSignInError = new JLabel("");
		lblUserNameSignInError.setVisible(false);
		lblUserNameSignInError.setIcon(new ImageIcon("icons\\error.png"));
		lblUserNameSignInError.setBounds(350, 150, 16, 16);
		SignInPanel.add(lblUserNameSignInError);
		
		final JLabel lblPasswordSignInError = new JLabel("");
		lblPasswordSignInError.setVisible(false);
		lblPasswordSignInError.setIcon(new ImageIcon("icons\\error.png"));
		lblPasswordSignInError.setBounds(350, 234, 16, 16);
		SignInPanel.add(lblPasswordSignInError);
		
		btnHaveAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SignInPanel.setVisible(false);
				SignUpPanel.setVisible(true);				
			}
		});	
		
		btnSignIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				boolean emptyFieldEncountered = false;
				
				if(txtUserNameSignIn.getText().isEmpty() || txtUserNameSignIn.getText().equals("Enter Your User Name Here")) {
					emptyFieldEncountered = true;
					txtUserNameSignIn.setText("Enter Your User Name Here");
					txtUserNameSignIn.setForeground(Color.RED);
					separatorUserNameSignIn.setForeground(Color.RED);
					separatorUserNameSignIn.setBackground(Color.RED);
				} else {
					txtUserNameSignIn.setForeground(Color.WHITE);
					separatorUserNameSignIn.setForeground(Color.WHITE);
					separatorUserNameSignIn.setBackground(Color.WHITE);
				}

				
				if(passwordFieldSignIn.getText().isEmpty() || passwordFieldSignIn.getText().equals("Password Here")) {
					emptyFieldEncountered = true;
					passwordFieldSignIn.setText("Password Here");
					passwordFieldSignIn.setForeground(Color.RED);
					separatorPasswordSignIn.setForeground(Color.RED);
					separatorPasswordSignIn.setBackground(Color.RED);
				} else {
					passwordFieldSignIn.setForeground(Color.WHITE);
					separatorPasswordSignIn.setForeground(Color.WHITE);
					separatorPasswordSignIn.setBackground(Color.WHITE);
				}
				
				if(!radioButtonClient.isSelected() && !radioButtonManger.isSelected()) {
					emptyFieldEncountered = true;
					radioButtonClient.setForeground(Color.RED);
					radioButtonManger.setForeground(Color.RED);
				} else {
					radioButtonClient.setForeground(Color.WHITE);
					radioButtonManger.setForeground(Color.WHITE);
				}

				// sanity check 
				if(emptyFieldEncountered)
					return;
				
				if(radioButtonClient.isSelected()) {
					
					for(int i=0 ; i<Main.getClientsArrayList().size() ; i++) {
						if( txtUserNameSignIn.getText().equals(Main.getClientsArrayList().get(i).getUserName())
								&& passwordFieldSignIn.getText().equals(Main.getClientsArrayList().get(i).getUserPassword()) ) {
															
								ClientFrame clientFrame = new ClientFrame(Main.getClientsArrayList().get(i));
								clientFrame.setVisible(true);
								
								// switch to manger frame
								dispose();
							}
					}
					
//					try {
//						// check in client file
//						FileInputStream clientsFile = new FileInputStream("data-base\\clientsFile.ser");
//						ObjectInputStream clientsData = new ObjectInputStream(clientsFile);					
//						
//						while(clientsData.available()>-1) {
//							// create dummy instance to store information while looping
//							Clients client = (Clients) clientsData.readObject();
//
//							if(txtUserNameSignIn.getText().equals(client.getUserName())
//									&& passwordFieldSignIn.getText().equals(client.getUserPassword()) ) {
//								
//								
//								clientsData.close();
//								clientsFile.close();
//								
//								// switch to client frame
//								dispose();
//								
//								ClientFrame clientFrame = new ClientFrame(client);
//								clientFrame.setVisible(true);
//							}
//						}						
//						clientsData.close();
//						clientsFile.close();
//						
//						lblUserNameSignInError.setVisible(true);
//						lblPasswordSignInError.setVisible(true);
//						
//					} catch (FileNotFoundException e) {
//						System.out.println("file not found");
//					} catch (IOException e) {
//						System.out.println("error initializing stream");
//					} catch (ClassNotFoundException e) {
//						System.out.println("class not found");
//					}
					lblUserNameSignInError.setVisible(true);
					lblPasswordSignInError.setVisible(true);
				}
				
				else if(radioButtonManger.isSelected()) {	
				
						
//					try {	
//						// check in manger file
//						FileInputStream managersFile = new FileInputStream("data-base\\managerFile.ser");
//						ObjectInputStream managersData = new ObjectInputStream(managersFile);
//	
//						while(managersData.available()>-1) {
//							// create dummy instance to store information while looping
//							Managers manager = (Managers) managersData.readObject();
//							
//							if(txtUserNameSignIn.getText().equals(manager.getUserName()) 
//									&& passwordFieldSignIn.getText().equals(manager.getUserPassword()) ) {
//								
//								managersData.close();
//								managersFile.close();
//								
//								// switch to manger frame
//								setVisible(false);
//								
//								ManagerFrame managerFrame = new ManagerFrame(manager);
//								managerFrame.setVisible(true);
//							}
//						}
//						managersData.close();
//						managersFile.close();
//						
//						lblUserNameSignInError.setVisible(true);
//						lblPasswordSignInError.setVisible(true);
//						
//					} catch (FileNotFoundException e) {
//						System.out.println("file not found");
//					} catch (IOException e) {
//						System.out.println("error initializing stream");
//					} catch (ClassNotFoundException e) {
//						System.out.println("class not found");
//					}				
				}
				lblUserNameSignInError.setVisible(true);
				lblPasswordSignInError.setVisible(true);
			}
		});
		
		JLabel lblSeePasswordSignIn = new JLabel("");
		lblSeePasswordSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				passwordFieldSignIn.setEchoChar((char)0);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				passwordFieldSignIn.setEchoChar('â—�');
				passwordFieldSignIn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			}
		});
		lblSeePasswordSignIn.setIcon(new ImageIcon("icons\\eyeOpen.png"));
		lblSeePasswordSignIn.setForeground(Color.WHITE);
		lblSeePasswordSignIn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblSeePasswordSignIn.setBounds(316, 234, 16, 16);
		SignInPanel.add(lblSeePasswordSignIn);
		
		ButtonGroup userTypeGroup = new ButtonGroup();
		userTypeGroup.add(radioButtonClient);
		userTypeGroup.add(radioButtonManger);
	}
}
