package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import accounts.Drivers;
import accounts.Managers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import essentials.Trips;
import essentials.Trips.TripsTypes;
import essentials.Vehicles;
import essentials.Vehicles.VehiclesTypes;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;

import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class ManagerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int xMouse;
	private int yMouse;
	
	private JTextField txtTripNumber;
	private JTextField txtDestinationFrom;
	private JTextField txtDestinationTo;
	private JTextField txtProfit;
	private JTextField txtFirstName;
	private JTextField txtDriverID;
	private JTextField txtLastName;
	private JTextField txtVehicleNumber;

	private JPanel RemoveDriverPanel,RemoveTripPanel;
	private JPanel RemoveVehiclePanel;
	private JScrollPane RemoveVehicleScrollPane =new JScrollPane();
	private JScrollPane RemoveDriversScrollPane,RemoveTripScrollPane;
	private JLabel infoVehicle,infoDriver,infoTrip;
	private JButton DeleteVehicle ;
	private ArrayList<Vehicles> arrayListOfVehicles=Main.getVehiclesArrayList();
	private ArrayList<Drivers> arrayListOfDrivers=Main.getDriversArrayList();
	private ArrayList<Trips> arrayListOfTrips=Main.getTripsArrayList();


	/**
	 * Create the frame.
	 */
	public ManagerFrame(Managers manager) {
		this.setSize(800,500);
		this.setUndecorated(true);
		this.setResizable(true);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		getContentPane().setLayout(null);
		RemoveTripPanel = new JPanel();
		RemoveTripPanel.setVisible(false);
				RemoveDriverPanel = new JPanel();
				RemoveDriverPanel.setVisible(false);
		RemoveVehiclePanel = new JPanel();
		RemoveVehiclePanel.setVisible(false);
		
		
		getContentPane().setLayout(null);
		
		final JPanel ContentPanel = new JPanel();
		ContentPanel.setBounds(0, 65, 800, 435);
		getContentPane().add(ContentPanel);
		ContentPanel.setLayout(null);
		
		JButton btnAddTrip = new JButton("Add Trip");
		btnAddTrip.setForeground(Color.WHITE);
		btnAddTrip.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAddTrip.setBorder(null);
		btnAddTrip.setBackground(new Color(36, 47, 65));
		btnAddTrip.setBounds(60, 35, 150, 150);
		ContentPanel.add(btnAddTrip);
		
		JButton btnRemoveTrip = new JButton("Remove Trip");
		btnRemoveTrip.setForeground(Color.WHITE);
		btnRemoveTrip.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnRemoveTrip.setBorder(null);
		btnRemoveTrip.setBackground(new Color(36, 47, 65));
		btnRemoveTrip.setBounds(60, 240, 150, 150);
		ContentPanel.add(btnRemoveTrip);
		
		JButton btnAddDriver = new JButton("Add Driver");
		btnAddDriver.setForeground(Color.WHITE);
		btnAddDriver.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAddDriver.setBorder(null);
		btnAddDriver.setBackground(new Color(36, 47, 65));
		btnAddDriver.setBounds(330, 35, 150, 150);
		ContentPanel.add(btnAddDriver);
		
		JButton btnRemoveDriver = new JButton("Remove Driver");
		btnRemoveDriver.setForeground(Color.WHITE);
		btnRemoveDriver.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnRemoveDriver.setBorder(null);
		btnRemoveDriver.setBackground(new Color(36, 47, 65));
		btnRemoveDriver.setBounds(330, 240, 150, 150);
		ContentPanel.add(btnRemoveDriver);
		
		JButton btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setForeground(Color.WHITE);
		btnAddVehicle.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAddVehicle.setBorder(null);
		btnAddVehicle.setBackground(new Color(36, 47, 65));
		btnAddVehicle.setBounds(600, 35, 150, 150);
		ContentPanel.add(btnAddVehicle);
		
		JButton btnRemoveVehicle = new JButton("Remove Vehicle");
		btnRemoveVehicle.setForeground(Color.WHITE);
		btnRemoveVehicle.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnRemoveVehicle.setBorder(null);
		btnRemoveVehicle.setBackground(new Color(36, 47, 65));
		btnRemoveVehicle.setBounds(600, 240, 150, 150);
		ContentPanel.add(btnRemoveVehicle);

		RemoveVehiclePanel.setBounds(0, 65, 800, 435);
		getContentPane().add(RemoveVehiclePanel);
		
		 infoVehicle = new JLabel("Vehicle Information");
		 
		 RemoveVehicleScrollPane = new JScrollPane();
		 
		 DeleteVehicle = new JButton("Delete");
		 DeleteVehicle.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		System.out.println(arrayListOfVehicles.size());
		 		try {
		 			arrayListOfVehicles.remove(MyPanelVehicles.getIndexToDelete());
		 		}catch(Exception e) {}
		  		System.out.println(arrayListOfVehicles.size());
		  		MyPanelVehicles.setIndexToDelete(-1);

		 		
		 	}
		 });
		 
		 JButton buttonBackVehicle = new JButton("Back");
		 
		 		 buttonBackVehicle.setForeground(new Color(36, 47, 65));
		 		 buttonBackVehicle.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		 		 buttonBackVehicle.setBorder(null);
		 		 buttonBackVehicle.setBackground(SystemColor.menu);
		 		 GroupLayout gl_RemoveVehiclePanel = new GroupLayout(RemoveVehiclePanel);
		 		 gl_RemoveVehiclePanel.setHorizontalGroup(
		 		 	gl_RemoveVehiclePanel.createParallelGroup(Alignment.LEADING)
		 		 		.addGroup(gl_RemoveVehiclePanel.createSequentialGroup()
		 		 			.addComponent(RemoveVehicleScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
		 		 			.addGap(18)
		 		 			.addGroup(gl_RemoveVehiclePanel.createParallelGroup(Alignment.LEADING, false)
		 		 				.addGroup(gl_RemoveVehiclePanel.createSequentialGroup()
		 		 					.addComponent(DeleteVehicle, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
		 		 					.addGap(54)
		 		 					.addComponent(buttonBackVehicle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		 		 				.addComponent(infoVehicle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		 		 			.addGap(81))
		 		 );
		 		 gl_RemoveVehiclePanel.setVerticalGroup(
		 		 	gl_RemoveVehiclePanel.createParallelGroup(Alignment.LEADING)
		 		 		.addComponent(RemoveVehicleScrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
		 		 		.addGroup(gl_RemoveVehiclePanel.createSequentialGroup()
		 		 			.addGap(29)
		 		 			.addComponent(infoVehicle, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
		 		 			.addGap(72)
		 		 			.addGroup(gl_RemoveVehiclePanel.createParallelGroup(Alignment.BASELINE)
		 		 				.addComponent(DeleteVehicle)
		 		 				.addComponent(buttonBackVehicle, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
		 		 );
		 		 RemoveVehiclePanel.setLayout(gl_RemoveVehiclePanel);

		RemoveDriverPanel.setBounds(0, 65, 800, 435);
		infoDriver=new JLabel("Driver Information");
		getContentPane().add(RemoveDriverPanel);
		
		 RemoveDriversScrollPane = new JScrollPane();
		 
		 JButton DeleteDriver = new JButton("Delete");
		 DeleteDriver.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		System.out.println(arrayListOfDrivers.size());
		 		try {
		 		arrayListOfDrivers.remove(MyPanelDrivers.getIndexToDelete());
		 		}catch(Exception e) {}
		  		System.out.println(arrayListOfDrivers.size());
		  		MyPanelDrivers.setIndexToDelete(-1);

		 	}
		 });
		 
		 JButton buttonBackDriver = new JButton("Back");

		 
		 		 buttonBackDriver.setForeground(new Color(36, 47, 65));
		 		 buttonBackDriver.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		 		 buttonBackDriver.setBorder(null);
		 		 buttonBackDriver.setBackground(SystemColor.menu);
		 		 GroupLayout gl_RemoveDriverPanel = new GroupLayout(RemoveDriverPanel);
		 		 gl_RemoveDriverPanel.setHorizontalGroup(
		 		 	gl_RemoveDriverPanel.createParallelGroup(Alignment.LEADING)
		 		 		.addGroup(gl_RemoveDriverPanel.createSequentialGroup()
		 		 			.addComponent(RemoveDriversScrollPane, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE)
		 		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 		 			.addGroup(gl_RemoveDriverPanel.createParallelGroup(Alignment.LEADING)
		 		 				.addGroup(gl_RemoveDriverPanel.createSequentialGroup()
		 		 					.addComponent(DeleteDriver)
		 		 					.addGap(44)
		 		 					.addComponent(buttonBackDriver, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		 		 				.addComponent(infoDriver, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
		 		 			.addGap(75))
		 		 );
		 		 gl_RemoveDriverPanel.setVerticalGroup(
		 		 	gl_RemoveDriverPanel.createParallelGroup(Alignment.LEADING)
		 		 		.addComponent(RemoveDriversScrollPane, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
		 		 		.addGroup(gl_RemoveDriverPanel.createSequentialGroup()
		 		 			.addComponent(infoDriver, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
		 		 			.addGap(109)
		 		 			.addGroup(gl_RemoveDriverPanel.createParallelGroup(Alignment.BASELINE)
		 		 				.addComponent(DeleteDriver)
		 		 				.addComponent(buttonBackDriver, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		 		 			.addGap(144))
		 		 );
		 		 RemoveDriverPanel.setLayout(gl_RemoveDriverPanel);

		
				RemoveTripPanel.setBounds(0, 65, 800, 435);
				infoTrip=new JLabel("Trip Details");
				getContentPane().add(RemoveTripPanel);
				
				JButton DeleteTrip = new JButton("Delete");
				DeleteTrip.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.out.println(arrayListOfTrips.size());
				 		try {
				 			arrayListOfTrips.remove(MyPanelTrips.getIndexToDelete());
				 		}catch(Exception e) {}
				  		System.out.println(arrayListOfTrips.size());
				  		MyPanelTrips.setIndexToDelete(-1);

				 	}
				});
				
				RemoveTripScrollPane = new JScrollPane();
				
				JButton buttonBackTrip = new JButton("Back");
				
						buttonBackTrip.setForeground(new Color(36, 47, 65));
						buttonBackTrip.setFont(new Font("Century Gothic", Font.PLAIN, 16));
						buttonBackTrip.setBorder(null);
						buttonBackTrip.setBackground(SystemColor.menu);
						GroupLayout gl_RemoveTripPanel = new GroupLayout(RemoveTripPanel);
						gl_RemoveTripPanel.setHorizontalGroup(
							gl_RemoveTripPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_RemoveTripPanel.createSequentialGroup()
									.addComponent(RemoveTripScrollPane, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
									.addGap(63)
									.addGroup(gl_RemoveTripPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_RemoveTripPanel.createSequentialGroup()
											.addComponent(DeleteTrip)
											.addGap(59)
											.addComponent(buttonBackTrip, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
											.addGap(125))
										.addGroup(gl_RemoveTripPanel.createSequentialGroup()
											.addComponent(infoTrip, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
											.addGap(64))))
						);
						gl_RemoveTripPanel.setVerticalGroup(
							gl_RemoveTripPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_RemoveTripPanel.createSequentialGroup()
									.addGap(5)
									.addComponent(infoTrip, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
									.addGroup(gl_RemoveTripPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(buttonBackTrip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(DeleteTrip))
									.addGap(170))
								.addGroup(gl_RemoveTripPanel.createSequentialGroup()
									.addComponent(RemoveTripScrollPane, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						);
						RemoveTripPanel.setLayout(gl_RemoveTripPanel);
		
		
		
		

		
		JPanel HeaderPanel = new JPanel();
		HeaderPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				xMouse = event.getX();
				yMouse = event.getY();
			}
			@Override
			public void mouseReleased(MouseEvent event) {
				setOpacity(1);
			}
		});
		HeaderPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent event) {
				int xDim = event.getXOnScreen() - xMouse;
				int yDim = event.getYOnScreen() - yMouse;
				
				setLocation(xDim,yDim);
				setOpacity(0.75f);
			}
		});
		HeaderPanel.setBackground(new Color(36, 47, 65));
		HeaderPanel.setBounds(0, 0, 800, 40);
		getContentPane().add(HeaderPanel);
		HeaderPanel.setLayout(null);
		
		JLabel lblBusStation = new JLabel("BUS STATION");
		lblBusStation.setForeground(Color.WHITE);
		lblBusStation.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblBusStation.setBounds(10, 0, 200, 40);
		HeaderPanel.add(lblBusStation);
		
		JLabel lblExit1 = new JLabel("X");
		lblExit1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.saveOnExit();
				System.exit(0);
			}
		});
		lblExit1.setForeground(Color.WHITE);
		lblExit1.setFont(new Font("Tunga", Font.PLAIN, 22));
		lblExit1.setBounds(774, 11, 16, 16);
		HeaderPanel.add(lblExit1);
		
		JPanel UserNamePanel = new JPanel();
		UserNamePanel.setBackground(new Color(36, 47, 65));
		UserNamePanel.setBounds(0, 40, 800, 25);
		getContentPane().add(UserNamePanel);
		UserNamePanel.setLayout(null);
		
		JLabel lblUserName = new JLabel();
		lblUserName.setText(manager.name.getFirst().toUpperCase() + " " + manager.name.getLast().toUpperCase());
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblUserName.setBounds(10, 0, 400, 20);
		UserNamePanel.add(lblUserName);
		
		final JPanel AddTripPanel = new JPanel();
		AddTripPanel.setVisible(false);
		AddTripPanel.setLayout(null);
		AddTripPanel.setBounds(0, 65, 800, 435);
		getContentPane().add(AddTripPanel);
				
		final JPanel AddVehiclePanel = new JPanel();
		AddVehiclePanel.setVisible(false);
		AddVehiclePanel.setLayout(null);
		AddVehiclePanel.setBounds(0, 65, 800, 435);
		getContentPane().add(AddVehiclePanel);
		
		JButton btnBackVehicle = new JButton("Back");
		btnBackVehicle.setForeground(new Color(36, 47, 65));
		btnBackVehicle.setBackground(new Color(240, 240, 240));
		btnBackVehicle.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBackVehicle.setBorder(null);
		btnBackVehicle.setBounds(10, 399, 50, 25);
		AddVehiclePanel.add(btnBackVehicle);
		
		JLabel lblVehicleNumber = new JLabel("VEHICLE NUMBER");
		lblVehicleNumber.setForeground(new Color(36, 47, 65));
		lblVehicleNumber.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblVehicleNumber.setBounds(20, 45, 232, 19);
		AddVehiclePanel.add(lblVehicleNumber);
		
		txtVehicleNumber = new JTextField();
		txtVehicleNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtVehicleNumber.setText(null);
			}
		});
		txtVehicleNumber.setText("Enter Vehicle Number Here");
		txtVehicleNumber.setForeground(new Color(36, 47, 65));
		txtVehicleNumber.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtVehicleNumber.setColumns(10);
		txtVehicleNumber.setBorder(null);
		txtVehicleNumber.setBackground(SystemColor.menu);
		txtVehicleNumber.setBounds(20, 75, 232, 20);
		AddVehiclePanel.add(txtVehicleNumber);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-12, 8, 10, 12);
		UserNamePanel.add(scrollPane);
		
	
		final JSeparator separatorVehicleNumber = new JSeparator();
		separatorVehicleNumber.setForeground(new Color(36, 47, 65));
		separatorVehicleNumber.setBackground(new Color(36, 47, 65));
		separatorVehicleNumber.setBounds(20, 100, 232, 12);
		AddVehiclePanel.add(separatorVehicleNumber);
		
		JButton btnSubmitVehicle = new JButton("Submit");
		btnSubmitVehicle.setForeground(Color.WHITE);
		btnSubmitVehicle.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSubmitVehicle.setBorder(null);
		btnSubmitVehicle.setBackground(new Color(36, 47, 65));
		btnSubmitVehicle.setBounds(715, 399, 75, 25);
		AddVehiclePanel.add(btnSubmitVehicle);
		
		JLabel lblVehicleType = new JLabel("VEHICLE TYPE");
		lblVehicleType.setForeground(new Color(36, 47, 65));
		lblVehicleType.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblVehicleType.setBounds(20, 145, 232, 19);
		AddVehiclePanel.add(lblVehicleType);
		
		final JSeparator separatorVehicleType = new JSeparator();
		separatorVehicleType.setForeground(new Color(36, 47, 65));
		separatorVehicleType.setBackground(new Color(36, 47, 65));
		separatorVehicleType.setBounds(20, 200, 232, 12);
		AddVehiclePanel.add(separatorVehicleType);
		
		JLabel lblNumSeats = new JLabel("NUMBER OF SEATS");
		lblNumSeats.setForeground(new Color(36, 47, 65));
		lblNumSeats.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNumSeats.setBounds(20, 245, 232, 19);
		AddVehiclePanel.add(lblNumSeats);
		
		final JSeparator separatorNumSeats = new JSeparator();
		separatorNumSeats.setForeground(new Color(36, 47, 65));
		separatorNumSeats.setBackground(new Color(36, 47, 65));
		separatorNumSeats.setBounds(20, 300, 232, 12);
		AddVehiclePanel.add(separatorNumSeats);
		
		final JComboBox<VehiclesTypes> comboBoxVehicleType = new JComboBox<VehiclesTypes>();
		comboBoxVehicleType.setBorder(null);
		comboBoxVehicleType.setModel(new DefaultComboBoxModel<VehiclesTypes>(VehiclesTypes.values()));
		comboBoxVehicleType.setSelectedIndex(0);
		comboBoxVehicleType.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxVehicleType.setForeground(new Color(36, 47, 65));
		comboBoxVehicleType.setBackground(new Color(36, 47, 65));
		comboBoxVehicleType.setBounds(20, 175, 232, 22);
		AddVehiclePanel.add(comboBoxVehicleType);
		
		final JComboBox<String> comboBoxNumSeats = new JComboBox<String>();
		comboBoxVehicleType.setBorder(null);
		comboBoxNumSeats.setModel(new DefaultComboBoxModel<String>(new String[] {"20", "30", "40"}));
		comboBoxNumSeats.setSelectedIndex(0);
		comboBoxNumSeats.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxNumSeats.setForeground(new Color(36, 47, 65));
		comboBoxNumSeats.setBackground(new Color(36, 47, 65));
		comboBoxNumSeats.setBounds(20, 275, 232, 22);
		AddVehiclePanel.add(comboBoxNumSeats);
		
		final JComboBox<String> comboBoxVehicle = new JComboBox<String>();
		for(int i=0 ; i<Main.getVehiclesArrayList().size() ; i++)
			comboBoxVehicle.addItem(Main.getVehiclesArrayList().get(Main.getVehiclesArrayList().size()-1).getID());
		comboBoxVehicle.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxVehicle.setBackground(new Color(36, 47, 65));
		comboBoxVehicle.setForeground(new Color(36, 47, 65));
		comboBoxVehicle.setBounds(547, 75, 232, 22);
		AddTripPanel.add(comboBoxVehicle);
		
		btnSubmitVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean emptyFieldEncountered = false;
				
				if(txtVehicleNumber.getText().isEmpty() || txtVehicleNumber.getText().equals("Enter Vehicle Number Here")) {
					emptyFieldEncountered = true;
					txtVehicleNumber.setText("Enter Vehicle Number Here");
					txtVehicleNumber.setForeground(Color.RED);
					separatorVehicleNumber.setForeground(Color.RED);
					separatorVehicleNumber.setBackground(Color.RED);
				} else {
					txtVehicleNumber.setForeground(new Color(36, 47, 65));
					separatorVehicleNumber.setForeground(new Color(36, 47, 65));
					separatorVehicleNumber.setBackground(new Color(36, 47, 65));
				}

				// sanity check
				if(emptyFieldEncountered)
					return;
					
				// create instance to store information
				Vehicles vehicle = new Vehicles();
				
				// assigning values
				vehicle.setSeats(Integer.parseInt(comboBoxNumSeats.getSelectedItem().toString()));
				
				System.out.println(vehicle.getSeats());
				
				if( (VehiclesTypes)comboBoxVehicleType.getSelectedItem() == VehiclesTypes.BUS ) {
					vehicle.setID("BUS-"+txtVehicleNumber.getText());
					vehicle.setVehicleType(VehiclesTypes.BUS);
				}
				else if( (VehiclesTypes)comboBoxVehicleType.getSelectedItem() == VehiclesTypes.MINIBUS ) {
					vehicle.setID("MINIBUS-"+txtVehicleNumber.getText());
					vehicle.setVehicleType(VehiclesTypes.MINIBUS);
				}
				else if( (VehiclesTypes)comboBoxVehicleType.getSelectedItem() == VehiclesTypes.LIMOUSINE  ) {
					vehicle.setID("LIMOUSINE-"+txtVehicleNumber.getText());
					vehicle.setVehicleType(VehiclesTypes.LIMOUSINE);
				}
				
				
				// write in data-base
				Main.getVehiclesArrayList().add(vehicle);
				comboBoxVehicle.addItem(Main.getVehiclesArrayList().get(Main.getVehiclesArrayList().size()-1).getID());
			}
		});
		
	
		
		
		
		
		
		JLabel lblTripNumber = new JLabel("TRIP NUMBER");
		lblTripNumber.setForeground(new Color(36, 47, 65));
		lblTripNumber.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTripNumber.setBounds(20, 45, 232, 19);
		AddTripPanel.add(lblTripNumber);
		
		txtTripNumber = new JTextField();
		txtTripNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtTripNumber.setText(null);
			}
		});
		txtTripNumber.setText("Enter Trip Number Here");
		txtTripNumber.setForeground(new Color(36, 47, 65));
		txtTripNumber.setBackground(new Color(240,240,240));
		txtTripNumber.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtTripNumber.setColumns(10);
		txtTripNumber.setBorder(null);
		txtTripNumber.setBounds(20, 75, 232, 20);
		AddTripPanel.add(txtTripNumber);
		txtTripNumber.setBackground(new Color(240,240,240));
		
		final JSeparator separatorTripNumber = new JSeparator();
		separatorTripNumber.setForeground(new Color(36, 47, 65));
		separatorTripNumber.setBackground(new Color(36, 47, 65));
		separatorTripNumber.setBounds(20, 100, 232, 12);
		AddTripPanel.add(separatorTripNumber);
		
		JButton btnSubmitTrip = new JButton("Submit");
		btnSubmitTrip.setForeground(Color.WHITE);
		btnSubmitTrip.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSubmitTrip.setBorder(null);
		btnSubmitTrip.setBackground(new Color(36, 47, 65));
		btnSubmitTrip.setBounds(715, 399, 75, 25);
		AddTripPanel.add(btnSubmitTrip);
		
		JLabel lblDestinationFrom = new JLabel("DESTINATION FROM");
		lblDestinationFrom.setForeground(new Color(36, 47, 65));
		lblDestinationFrom.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDestinationFrom.setBounds(20, 145, 232, 19);
		AddTripPanel.add(lblDestinationFrom);
		
		txtDestinationFrom = new JTextField();
		txtDestinationFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDestinationFrom.setText(null);
			}
		});
		txtDestinationFrom.setText("Enter Destination From Here");
		txtDestinationFrom.setForeground(new Color(36, 47, 65));
		txtDestinationFrom.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtDestinationFrom.setColumns(10);
		txtDestinationFrom.setBorder(null);
		txtDestinationFrom.setBackground(SystemColor.menu);
		txtDestinationFrom.setBounds(20, 175, 232, 20);
		AddTripPanel.add(txtDestinationFrom);
		
		JLabel lblDestinationTo = new JLabel("DESTINATION TO");
		lblDestinationTo.setForeground(new Color(36, 47, 65));
		lblDestinationTo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDestinationTo.setBounds(20, 245, 232, 19);
		AddTripPanel.add(lblDestinationTo);
		
		final JSeparator separatorDestinationTo = new JSeparator();
		separatorDestinationTo.setForeground(new Color(36, 47, 65));
		separatorDestinationTo.setBackground(new Color(36, 47, 65));
		separatorDestinationTo.setBounds(20, 300, 232, 12);
		AddTripPanel.add(separatorDestinationTo);
		
		txtDestinationTo = new JTextField();
		txtDestinationTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDestinationTo.setText(null);
			}
		});
		txtDestinationTo.setText("Enter Destination To Here");
		txtDestinationTo.setForeground(new Color(36, 47, 65));
		txtDestinationTo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtDestinationTo.setColumns(10);
		txtDestinationTo.setBorder(null);
		txtDestinationTo.setBackground(SystemColor.menu);
		txtDestinationTo.setBounds(20, 275, 232, 20);
		AddTripPanel.add(txtDestinationTo);
		
		JLabel lblVie = new JLabel("VEHICLE");
		lblVie.setForeground(new Color(36, 47, 65));
		lblVie.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblVie.setBounds(547, 45, 232, 19);
		AddTripPanel.add(lblVie);
		
		final JSeparator separatorVehicle = new JSeparator();
		separatorVehicle.setForeground(new Color(36, 47, 65));
		separatorVehicle.setBackground(new Color(36, 47, 65));
		separatorVehicle.setBounds(547, 100, 232, 12);
		AddTripPanel.add(separatorVehicle);
		
		JLabel lblDriver = new JLabel("DRIVER");
		lblDriver.setForeground(new Color(36, 47, 65));
		lblDriver.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDriver.setBounds(547, 145, 232, 19);
		AddTripPanel.add(lblDriver);
		
		final JSeparator separatorDriver = new JSeparator();
		separatorDriver.setForeground(new Color(36, 47, 65));
		separatorDriver.setBackground(new Color(36, 47, 65));
		separatorDriver.setBounds(547, 200, 232, 12);
		AddTripPanel.add(separatorDriver);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setForeground(new Color(36, 47, 65));
		lblType.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblType.setBounds(283, 245, 232, 19);
		AddTripPanel.add(lblType);
		
		final JSeparator separatorType = new JSeparator();
		separatorType.setForeground(new Color(36, 47, 65));
		separatorType.setBackground(new Color(36, 47, 65));
		separatorType.setBounds(283, 300, 232, 12);
		AddTripPanel.add(separatorType);
		
		final JSeparator separatorDate = new JSeparator();
		separatorDate.setForeground(new Color(36, 47, 65));
		separatorDate.setBackground(new Color(36, 47, 65));
		separatorDate.setBounds(283, 100, 232, 12);
		AddTripPanel.add(separatorDate);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setForeground(new Color(36, 47, 65));
		lblDate.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDate.setBounds(283, 45, 232, 19);
		AddTripPanel.add(lblDate);
		
		final JSeparator separatorProfit = new JSeparator();
		separatorProfit.setForeground(new Color(36, 47, 65));
		separatorProfit.setBackground(new Color(36, 47, 65));
		separatorProfit.setBounds(283, 200, 232, 12);
		AddTripPanel.add(separatorProfit);
		
		txtProfit = new JTextField();
		txtProfit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtProfit.setText(null);
			}
		});
		txtProfit.setText("Enter Profit Here");
		txtProfit.setForeground(new Color(36, 47, 65));
		txtProfit.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtProfit.setColumns(10);
		txtProfit.setBorder(null);
		txtProfit.setBackground(SystemColor.menu);
		txtProfit.setBounds(283, 175, 232, 20);
		AddTripPanel.add(txtProfit);
		
		JLabel lblProfit = new JLabel("PROFIT");
		lblProfit.setForeground(new Color(36, 47, 65));
		lblProfit.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblProfit.setBounds(283, 145, 232, 19);
		AddTripPanel.add(lblProfit);
		
		
		
		final JComboBox<String> comboBoxDriver = new JComboBox<String>();
		for(int i=0 ; i<Main.getDriversArrayList().size() ; i++)
			comboBoxVehicle.addItem(Main.getDriversArrayList().get(Main.getDriversArrayList().size()-1).getID());
		comboBoxDriver.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxDriver.setForeground(new Color(36, 47, 65));
		comboBoxDriver.setBackground(new Color(36, 47, 65));
		comboBoxDriver.setBounds(547, 175, 232, 22);
		AddTripPanel.add(comboBoxDriver);
		
		final JRadioButton rdbtnInternal = new JRadioButton("Internal");
		rdbtnInternal.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnInternal.setForeground(new Color(36, 47, 65));
		rdbtnInternal.setBounds(283, 274, 70, 23);
		AddTripPanel.add(rdbtnInternal);
		
		final JRadioButton rdbtnExternal = new JRadioButton("External");
		rdbtnExternal.setForeground(new Color(36, 47, 65));
		rdbtnExternal.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnExternal.setBounds(443, 274, 72, 23);
		AddTripPanel.add(rdbtnExternal);
		
		final JSeparator separatorNumStops = new JSeparator();
		separatorNumStops.setForeground(new Color(36, 47, 65));
		separatorNumStops.setBackground(new Color(36, 47, 65));
		separatorNumStops.setBounds(547, 300, 232, 12);
		AddTripPanel.add(separatorNumStops);
		
		final JComboBox<String> comboBoxNumStops = new JComboBox<String>();
		comboBoxNumStops.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5"}));
		comboBoxNumStops.setSelectedIndex(0);
		comboBoxNumStops.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxNumStops.setForeground(new Color(36, 47, 65));
		comboBoxNumStops.setBackground(new Color(36, 47, 65));
		comboBoxNumStops.setBounds(547, 275, 232, 22);
		AddTripPanel.add(comboBoxNumStops);
		
		JLabel lblNumberOfStops = new JLabel("NUMBER OF STOPS");
		lblNumberOfStops.setForeground(new Color(36, 47, 65));
		lblNumberOfStops.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNumberOfStops.setBounds(547, 245, 232, 19);
		AddTripPanel.add(lblNumberOfStops);
		txtTripNumber.setBackground(new Color(240,240,240));
		
		final JSeparator separatorDestinationFrom = new JSeparator();
		separatorDestinationFrom.setForeground(new Color(36, 47, 65));
		separatorDestinationFrom.setBackground(new Color(36, 47, 65));
		separatorDestinationFrom.setBounds(20, 200, 232, 12);
		AddTripPanel.add(separatorDestinationFrom);
		
		final JComboBox<String> comboBoxDay = new JComboBox<String>();
		for(int i=1 ; i<=31; i++)
			comboBoxDay.addItem(Integer.toString(i));
		comboBoxDay.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxDay.setBackground(new Color(36, 47, 65));
		comboBoxDay.setBounds(283, 74, 65, 22);
		AddTripPanel.add(comboBoxDay);
		
		final JComboBox<String> comboBoxYear = new JComboBox<String>();
		for(int i=2018 ; i<=2020; i++)
			comboBoxYear.addItem(Integer.toString(i));
		comboBoxYear.setForeground(new Color(36, 47, 65));
		comboBoxYear.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxYear.setBackground(new Color(36, 47, 65));
		comboBoxYear.setBounds(450, 74, 65, 22);
		AddTripPanel.add(comboBoxYear);
		
		final JComboBox<String> comboBoxMonth = new JComboBox<String>();
		for(int i=1 ; i<=12; i++)
			comboBoxYear.addItem(Integer.toString(i));
		comboBoxMonth.setForeground(new Color(36, 47, 65));
		comboBoxMonth.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBoxMonth.setBackground(new Color(36, 47, 65));
		comboBoxMonth.setBounds(367, 74, 65, 22);
		AddTripPanel.add(comboBoxMonth);
		
		JButton btnBackTrip = new JButton("Back");
		btnBackTrip.setForeground(new Color(36, 47, 65));
		btnBackTrip.setBackground(new Color(240, 240, 240));
		btnBackTrip.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBackTrip.setBorder(null);
		btnBackTrip.setBounds(10, 399, 50, 25);
		AddTripPanel.add(btnBackTrip);
		
		btnBackTrip.setForeground(new Color(36, 47, 65));
		btnBackTrip.setBackground(new Color(240, 240, 240));
		btnBackTrip.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBackTrip.setBorder(null);
		btnBackTrip.setBounds(10, 399, 50, 25);
		AddTripPanel.add(btnBackTrip);
		
		
		
		
		
		btnSubmitTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean emptyFieldEncountered = false;
				
				if(txtTripNumber.getText().isEmpty() || txtTripNumber.getText().equals("Enter Trip Number Here")) {
					emptyFieldEncountered = true;
					txtTripNumber.setText("Enter Trip Number Here");
					txtTripNumber.setForeground(Color.RED);
					separatorTripNumber.setForeground(Color.RED);
					separatorTripNumber.setBackground(Color.RED);
				} else {
					txtTripNumber.setForeground(new Color(36, 47, 65));
					separatorTripNumber.setForeground(new Color(36, 47, 65));
					separatorTripNumber.setBackground(new Color(36, 47, 65));
				}
				
				if(txtDestinationFrom.getText().isEmpty() || txtDestinationFrom.getText().equals("Enter Destination From Here")) {
					emptyFieldEncountered = true;
					txtDestinationFrom.setText("Enter Destination From Here");
					txtDestinationFrom.setForeground(Color.RED);
					separatorDestinationFrom.setForeground(Color.RED);
					separatorDestinationFrom.setBackground(Color.RED);
				} else {
					txtDestinationFrom.setForeground(new Color(36, 47, 65));
					separatorDestinationFrom.setForeground(new Color(36, 47, 65));
					separatorDestinationFrom.setBackground(new Color(36, 47, 65));
				}
				
				if(txtDestinationTo.getText().isEmpty() || txtDestinationTo.getText().equals("Enter Destination To Here")) {
					emptyFieldEncountered = true;
					txtDestinationTo.setText("Enter Destination To Here");
					txtDestinationTo.setForeground(Color.RED);
					separatorDestinationTo.setForeground(Color.RED);
					separatorDestinationTo.setBackground(Color.RED);
				} else {
					txtDestinationTo.setForeground(new Color(36, 47, 65));
					separatorDestinationTo.setForeground(new Color(36, 47, 65));
					separatorDestinationTo.setBackground(new Color(36, 47, 65));
				}
				
				if(txtProfit.getText().isEmpty() || txtProfit.getText().equals("Enter Profit Here")) {
					emptyFieldEncountered = true;
					txtProfit.setText("Enter Profit Here");
					txtProfit.setForeground(Color.RED);
					separatorProfit.setForeground(Color.RED);
					separatorProfit.setBackground(Color.RED);
				} else {
					txtProfit.setForeground(new Color(36, 47, 65));
					separatorProfit.setForeground(new Color(36, 47, 65));
					separatorProfit.setBackground(new Color(36, 47, 65));
				}
				
				if(!rdbtnExternal.isSelected() || !rdbtnInternal.isSelected()) {
					emptyFieldEncountered = true;
					rdbtnExternal.setForeground(Color.RED);
					rdbtnInternal.setForeground(Color.RED);
					separatorType.setForeground(Color.RED);
					separatorType.setBackground(Color.RED);
				} else {
					rdbtnExternal.setForeground(new Color(36, 47, 65));
					rdbtnInternal.setForeground(new Color(36, 47, 65));
					separatorType.setForeground(new Color(36, 47, 65));
					separatorType.setBackground(new Color(36, 47, 65));
				}

				// sanity check
				if(emptyFieldEncountered)
					return;
					
				// create instance to store information
				Trips trip = new Trips();
				
				// assigning values
				for(int i=0 ; i<Main.getVehiclesArrayList().size() ; i++)
					if( Main.getVehiclesArrayList().get(i).getID().equals(comboBoxVehicle.getSelectedItem().toString()) ) {
						trip.vehicle = Main.getVehiclesArrayList().get(i);
						break;
					}
								
				for(int i=0 ; i<Main.getDriversArrayList().size() ; i++)
					if( Main.getDriversArrayList().get(i).getID().equals(comboBoxDriver.getSelectedItem().toString()) ) {
						trip.driver = Main.getDriversArrayList().get(i);
						break;
					}
				trip.date.day = Integer.parseInt((String)comboBoxDay.getSelectedItem());
				trip.date.month = Integer.parseInt((String)comboBoxMonth.getSelectedItem());
				trip.date.year = Integer.parseInt((String)comboBoxYear.getSelectedItem());
				
				trip.setNumberStops((Integer) comboBoxNumStops.getSelectedItem());
				trip.setTripNumber(txtTripNumber.getText());
				trip.setProfit(Double.parseDouble(txtProfit.getText()));
				trip.setDestinationFrom(txtDestinationFrom.getText());
				trip.setDestinationTo(txtDestinationTo.getText());
				
				trip.getDistance();
				trip.getDuration();
				
				
				if(rdbtnExternal.isSelected())
					trip.setTripType(TripsTypes.EXTERNAL);
				else if (rdbtnInternal.isSelected())
					trip.setTripType(TripsTypes.INTERNAL);
				
					
				// write in data-base
				Main.getTripsArrayList().add(trip);		
			}
		});
		
		
		
		final JPanel AddDriverPanel = new JPanel();
		AddDriverPanel.setVisible(false);
		AddDriverPanel.setLayout(null);
		AddDriverPanel.setBounds(0, 65, 800, 435);
		getContentPane().add(AddDriverPanel);
		
		JLabel lblDriverName = new JLabel("DRIVER NAME");
		lblDriverName.setForeground(new Color(36, 47, 65));
		lblDriverName.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDriverName.setBounds(20, 45, 232, 19);
		AddDriverPanel.add(lblDriverName);
		
		txtFirstName = new JTextField();
		txtFirstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtFirstName.setText(null);
			}
		});
		txtFirstName.setText("First Name");
		txtFirstName.setForeground(new Color(36, 47, 65));
		txtFirstName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtFirstName.setColumns(10);
		txtFirstName.setBorder(null);
		txtFirstName.setBackground(SystemColor.menu);
		txtFirstName.setBounds(20, 75, 110, 20);
		AddDriverPanel.add(txtFirstName);
		
		final JSeparator separatorFirstName = new JSeparator();
		separatorFirstName.setForeground(new Color(36, 47, 65));
		separatorFirstName.setBackground(new Color(36, 47, 65));
		separatorFirstName.setBounds(20, 100, 110, 12);
		AddDriverPanel.add(separatorFirstName);
		
		txtLastName = new JTextField();
		txtLastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtLastName.setText(null);
			}
		});
		txtLastName.setText("Last Name");
		txtLastName.setForeground(new Color(36, 47, 65));
		txtLastName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtLastName.setColumns(10);
		txtLastName.setBorder(null);
		txtLastName.setBackground(SystemColor.menu);
		txtLastName.setBounds(142, 75, 110, 20);
		AddDriverPanel.add(txtLastName);
		
		final JSeparator separatorLastName = new JSeparator();
		separatorLastName.setForeground(new Color(36, 47, 65));
		separatorLastName.setBackground(new Color(36, 47, 65));
		separatorLastName.setBounds(140, 100, 110, 12);
		AddDriverPanel.add(separatorLastName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(36, 47, 65));
		lblId.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblId.setBounds(20, 145, 232, 19);
		AddDriverPanel.add(lblId);
		
		txtDriverID = new JTextField();
		txtDriverID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtDriverID.setText(null);
			}
		});
		txtDriverID.setText("Enter Driver ID Here");
		txtDriverID.setForeground(new Color(36, 47, 65));
		txtDriverID.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtDriverID.setColumns(10);
		txtDriverID.setBorder(null);
		txtDriverID.setBackground(SystemColor.menu);
		txtDriverID.setBounds(20, 175, 232, 20);
		AddDriverPanel.add(txtDriverID);
		
		final JSeparator separatorDriverID = new JSeparator();
		separatorDriverID.setForeground(new Color(36, 47, 65));
		separatorDriverID.setBackground(new Color(36, 47, 65));
		separatorDriverID.setBounds(20, 200, 232, 12);
		AddDriverPanel.add(separatorDriverID);
		
		JButton btnBackDriver = new JButton("Back");
		btnBackDriver.setForeground(new Color(36, 47, 65));
		btnBackDriver.setBackground(new Color(240, 240, 240));
		btnBackDriver.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBackDriver.setBorder(null);
		btnBackDriver.setBounds(10, 399, 50, 25);
		AddDriverPanel.add(btnBackDriver);
		
		 buttonBackVehicle.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
					AddTripPanel.setVisible(false);
					AddDriverPanel.setVisible(false);
					AddVehiclePanel.setVisible(false);
					RemoveTripPanel.setVisible(false);
					RemoveDriverPanel.setVisible(false);
					RemoveVehiclePanel.setVisible(false);
					ContentPanel.setVisible(true);
			 	}
			 });

			btnRemoveTrip.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ContentPanel.setVisible(false);
					AddDriverPanel.setVisible(false);
					AddVehiclePanel.setVisible(false);
					RemoveTripPanel.setVisible(true);
					setJPanelandComponentTrips();
					
				}
			});
			
					btnRemoveVehicle.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							ContentPanel.setVisible(false);
							AddDriverPanel.setVisible(false);
							AddVehiclePanel.setVisible(false);
							RemoveVehiclePanel.setVisible(true);
							setJPanelandComponentVehiles();
							RemoveVehiclePanel.repaint();
							
						}
					});
					btnRemoveDriver.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							ContentPanel.setVisible(false);
							AddDriverPanel.setVisible(false);
							AddVehiclePanel.setVisible(false);
							RemoveDriverPanel.setVisible(true);
							setJPanelandComponentDrivers();
						}
					});
		btnBackVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				
				ContentPanel.setVisible(true);
			}
		});
		
		btnBackTrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				
				ContentPanel.setVisible(true);
			}
		});
		buttonBackTrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				RemoveTripPanel.setVisible(false);
				RemoveDriverPanel.setVisible(false);
				RemoveVehiclePanel.setVisible(false);
				ContentPanel.setVisible(true);
			}
		});
		ButtonGroup tripTypeGroup = new ButtonGroup();
		tripTypeGroup.add(rdbtnExternal);
		tripTypeGroup.add(rdbtnInternal);
		
		JButton btnSubmitDriver = new JButton("Submit");
		
		btnSubmitDriver.setForeground(Color.WHITE);
		btnSubmitDriver.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSubmitDriver.setBorder(null);
		btnSubmitDriver.setBackground(new Color(36, 47, 65));
		btnSubmitDriver.setBounds(715, 399, 75, 25);
		AddDriverPanel.add(btnSubmitDriver);
		
		btnSubmitDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean emptyFieldEncountered = false;
				
				if(txtFirstName.getText().isEmpty() || txtFirstName.getText().equals("First Name")) {
					emptyFieldEncountered = true;
					txtFirstName.setText("First Name");
					txtFirstName.setForeground(Color.RED);
					separatorFirstName.setForeground(Color.RED);
					separatorFirstName.setBackground(Color.RED);
				} else {
					txtFirstName.setForeground(new Color(36, 47, 65));
					separatorFirstName.setForeground(new Color(36, 47, 65));
					separatorFirstName.setBackground(new Color(36, 47, 65));
				}
				
				if(txtLastName.getText().isEmpty() || txtLastName.getText().equals("Last Name")) {
					emptyFieldEncountered = true;
					txtLastName.setText("Last Name");
					txtLastName.setForeground(Color.RED);
					separatorLastName.setForeground(Color.RED);
					separatorLastName.setBackground(Color.RED);
				} else {
					txtLastName.setForeground(new Color(36, 47, 65));
					separatorLastName.setForeground(new Color(36, 47, 65));
					separatorLastName.setBackground(new Color(36, 47, 65));
				}
				
				if(txtDriverID.getText().isEmpty() || txtDriverID.getText().equals("Enter Driver ID Here")) {
					emptyFieldEncountered = true;
					txtDriverID.setText("Enter Driver ID Here");
					txtDriverID.setForeground(Color.RED);
					separatorDriverID.setForeground(Color.RED);
					separatorDriverID.setBackground(Color.RED);
				} else {
					txtLastName.setForeground(new Color(36, 47, 65));
					separatorDriverID.setForeground(new Color(36, 47, 65));
					separatorDriverID.setBackground(new Color(36, 47, 65));
				}
				
				// sanity check
				if(emptyFieldEncountered)
					return;
				
				// create instance to store information
				Drivers driver = new Drivers();
				
				// assigning values
				driver.name.setFirst(txtFirstName.getText());
				driver.name.setLast(txtLastName.getText());
				driver.setID(txtDriverID.getText());
				
				
				// write in data-base
				Main.getDriversArrayList().add(driver);
				comboBoxDriver.addItem(Main.getDriversArrayList().get(Main.getDriversArrayList().size()-1).getID());
			}
		});
		
		btnAddVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ContentPanel.setVisible(false);	
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				
				AddVehiclePanel.setVisible(true);
			}
		});
		
		btnAddTrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ContentPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				
				AddTripPanel.setVisible(true);
			}
		});
		
		btnAddDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ContentPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				AddTripPanel.setVisible(false);
				
				AddDriverPanel.setVisible(true);	
			}
		});
		
		btnBackVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				
				ContentPanel.setVisible(true);
			}
		});
		 buttonBackDriver.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent arg0) {
			 		
			 		
			 		AddTripPanel.setVisible(false);
					AddDriverPanel.setVisible(false);
					AddVehiclePanel.setVisible(false);
					RemoveTripPanel.setVisible(false);
					RemoveDriverPanel.setVisible(false);
					RemoveVehiclePanel.setVisible(false);
					ContentPanel.setVisible(true);
			 		
			 	}
			 });
		btnBackTrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				
				ContentPanel.setVisible(true);
			}
		});
		btnBackDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				
				ContentPanel.setVisible(true);	
			}
		});
		
		
		btnSubmitDriver.setForeground(Color.WHITE);
		btnSubmitDriver.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSubmitDriver.setBorder(null);
		btnSubmitDriver.setBackground(new Color(36, 47, 65));
		btnSubmitDriver.setBounds(715, 399, 75, 25);
		AddDriverPanel.add(btnSubmitDriver);
		
		btnSubmitDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean emptyFieldEncountered = false;
				
				if(txtFirstName.getText().isEmpty() || txtFirstName.getText().equals("First Name")) {
					emptyFieldEncountered = true;
					txtFirstName.setText("First Name");
					txtFirstName.setForeground(Color.RED);
					separatorFirstName.setForeground(Color.RED);
					separatorFirstName.setBackground(Color.RED);
				} else {
					txtFirstName.setForeground(new Color(36, 47, 65));
					separatorFirstName.setForeground(new Color(36, 47, 65));
					separatorFirstName.setBackground(new Color(36, 47, 65));
				}
				
				if(txtLastName.getText().isEmpty() || txtLastName.getText().equals("Last Name")) {
					emptyFieldEncountered = true;
					txtLastName.setText("Last Name");
					txtLastName.setForeground(Color.RED);
					separatorLastName.setForeground(Color.RED);
					separatorLastName.setBackground(Color.RED);
				} else {
					txtLastName.setForeground(new Color(36, 47, 65));
					separatorLastName.setForeground(new Color(36, 47, 65));
					separatorLastName.setBackground(new Color(36, 47, 65));
				}
				
				if(txtDriverID.getText().isEmpty() || txtDriverID.getText().equals("Enter Driver ID Here")) {
					emptyFieldEncountered = true;
					txtDriverID.setText("Enter Driver ID Here");
					txtDriverID.setForeground(Color.RED);
					separatorDriverID.setForeground(Color.RED);
					separatorDriverID.setBackground(Color.RED);
				} else {
					txtLastName.setForeground(new Color(36, 47, 65));
					separatorDriverID.setForeground(new Color(36, 47, 65));
					separatorDriverID.setBackground(new Color(36, 47, 65));
				}
				
				// sanity check
				if(emptyFieldEncountered)
					return;
				
				// create instance to store information
				Drivers driver = new Drivers();
				
				// assigning values
				driver.name.setFirst(txtFirstName.getText());
				driver.name.setLast(txtLastName.getText());
				driver.setID(txtDriverID.getText());
				
				/*
				 * WRITE INTO DATA-BASE
				 */
			}
		});

		 
			btnAddVehicle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ContentPanel.setVisible(false);	
					AddTripPanel.setVisible(false);
					AddDriverPanel.setVisible(false);
					
					AddVehiclePanel.setVisible(true);
				}
			});
			
			btnAddTrip.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ContentPanel.setVisible(false);
					AddDriverPanel.setVisible(false);
					AddVehiclePanel.setVisible(false);
					
					AddTripPanel.setVisible(true);
				}
			});
			
			btnAddDriver.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ContentPanel.setVisible(false);
					AddVehiclePanel.setVisible(false);
					AddTripPanel.setVisible(false);
					
					AddDriverPanel.setVisible(true);	
				}
			});
			btnRemoveTrip.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					ContentPanel.setVisible(false);
					AddDriverPanel.setVisible(false);
					AddVehiclePanel.setVisible(false);
					RemoveTripPanel.setVisible(true);
					setJPanelandComponentTrips();
					
				}
			});
			
					btnRemoveVehicle.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							ContentPanel.setVisible(false);
							AddDriverPanel.setVisible(false);
							AddVehiclePanel.setVisible(false);
							RemoveVehiclePanel.setVisible(true);
							setJPanelandComponentVehiles();
							RemoveVehiclePanel.repaint();
							
						}
					});
					btnRemoveDriver.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							ContentPanel.setVisible(false);
							AddDriverPanel.setVisible(false);
							AddVehiclePanel.setVisible(false);
							RemoveDriverPanel.setVisible(true);
							setJPanelandComponentDrivers();
						}
					});
		btnBackVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				
				ContentPanel.setVisible(true);
			}
		});
		
		btnBackTrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddTripPanel.setVisible(false);
				AddDriverPanel.setVisible(false);
				AddVehiclePanel.setVisible(false);
				
				ContentPanel.setVisible(true);
			}
		});
		
		
		tripTypeGroup.add(rdbtnExternal);
		tripTypeGroup.add(rdbtnInternal);
	
	}
	


private void setJPanelandComponentVehiles() {
	
	JPanel canvas = new JPanel();
	canvas.setLayout(new GridLayout(0,1));

	for(int i=0;i<arrayListOfVehicles.size();i++)
		canvas.add(new MyPanelVehicles(arrayListOfVehicles.get(i),infoVehicle,i));


	RemoveVehicleScrollPane.setViewportView(canvas);
	RemoveVehicleScrollPane.setPreferredSize(new Dimension(500,200));
	
	canvas.setPreferredSize(new Dimension(200, arrayListOfVehicles.size()*50));

}
private void setJPanelandComponentDrivers() {
	
	JPanel canvas = new JPanel();
	canvas.setLayout(new GridLayout(0,1));

	/*for(int i=0;i<5;i++)
	{
		Drivers d=new Drivers();
		d.setID(Integer.toString(i));
		arrayListOfDrivers.add(d);
	}*/
	for(int i=0;i<arrayListOfDrivers.size();i++)
		canvas.add(new MyPanelDrivers(arrayListOfDrivers.get(i),infoDriver,i));


	RemoveDriversScrollPane.setViewportView(canvas);
	RemoveDriversScrollPane.setPreferredSize(new Dimension(500,200));
	
	canvas.setPreferredSize(new Dimension(200, arrayListOfDrivers.size()*50));

}
private void setJPanelandComponentTrips() {
	
	JPanel canvas = new JPanel();
	canvas.setLayout(new GridLayout(0,1));

	for(int i=0;i<arrayListOfTrips.size();i++)
		canvas.add(new MyPanelTrips(arrayListOfTrips.get(i),infoTrip,i));


	RemoveTripScrollPane.setViewportView(canvas);
	RemoveTripScrollPane.setPreferredSize(new Dimension(500,200));
	
	canvas.setPreferredSize(new Dimension(200, arrayListOfTrips.size()*50));

}
}
