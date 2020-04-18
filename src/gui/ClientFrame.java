package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.Toolkit;

import essentials.CustomSeat;
import essentials.ReservedTrips;
import essentials.Trips;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import accounts.Clients;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int xMouse;
	private int yMouse;
	private  JPanel NewRidePanel ;
	private JScrollPane TripsScrollPane;
	private JLabel infoTrip;
	private JPanel panelOfChairs;
	

	/**
	 * Create the frame.
	 * 
	 * 
	 */	
	public ClientFrame(final Clients client) {
		
		this.setSize(800,500);
		this.setUndecorated(true);
		this.setResizable(true);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		getContentPane().setLayout(null);
		
		NewRidePanel = new JPanel();
		NewRidePanel.setVisible(false);
		
		
		
		final JPanel ContentPanel = new JPanel();
		ContentPanel.setBounds(0, 65, 800, 435);
		getContentPane().add(ContentPanel);
		ContentPanel.setLayout(null);
		
		JButton btnBookRide = new JButton("Book A New Ride");
		btnBookRide.setForeground(Color.WHITE);
		btnBookRide.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnBookRide.setBorder(null);
		btnBookRide.setBackground(new Color(36, 47, 65));
		btnBookRide.setBounds(50, 117, 200, 200);
		ContentPanel.add(btnBookRide);
		
		JButton btnBookedRides = new JButton("View Booked Rides");
		btnBookedRides.setForeground(Color.WHITE);
		btnBookedRides.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnBookedRides.setBorder(null);
		btnBookedRides.setBackground(new Color(36, 47, 65));
		btnBookedRides.setBounds(300, 117, 200, 200);
		ContentPanel.add(btnBookedRides);
		
		JButton btnOffers = new JButton("Our Offers");
		btnOffers.setForeground(Color.WHITE);
		btnOffers.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnOffers.setBorder(null);
		btnOffers.setBackground(new Color(36, 47, 65));
		btnOffers.setBounds(550, 117, 200, 200);
		ContentPanel.add(btnOffers);
		

		
		btnBookRide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ContentPanel.setVisible(false);
				NewRidePanel.setVisible(true);
				setJPanelandComponent();
			}
		});
		

		NewRidePanel.setLayout(null);
		NewRidePanel.setBounds(0, 65, 800, 435);
		getContentPane().add(NewRidePanel);
		
		JButton btnBackRide = new JButton("Back");
		btnBackRide.setForeground(new Color(36, 47, 65));
		btnBackRide.setBackground(new Color(240, 240, 240));
		btnBackRide.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnBackRide.setBorder(null);
		btnBackRide.setBounds(10, 400, 50, 25);
		NewRidePanel.add(btnBackRide);
		
		JButton btnSubmitVehicle = new JButton("Submit");
		btnSubmitVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * 
				 * 
				 * 
				 */
				
				ReservedTrips reservedTrips = new ReservedTrips();
				
				//userReservation.setTripNumber();
				reservedTrips.setUsername(client.getUserName());
				
				// write in data-base
				try {	
					// check in reserved trips file
					FileOutputStream reservedTripsFile = new FileOutputStream(new File("data-base\\reservedTripsFile.ser"),true);
					ObjectOutputStream reservedTripsData = new ObjectOutputStream(reservedTripsFile);

					reservedTripsData.writeObject(reservedTrips);
					
					reservedTripsData.close();
					reservedTripsFile.close();
					
				} catch (FileNotFoundException e) {
					System.out.println("reservedTrips :: file not found");
				} catch (IOException e) {
					System.out.println("reservedTrips :: error initializing stream");
				}				
			}
		});
		btnSubmitVehicle.setForeground(Color.WHITE);
		btnSubmitVehicle.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnSubmitVehicle.setBorder(null);
		btnSubmitVehicle.setBackground(new Color(36, 47, 65));
		btnSubmitVehicle.setBounds(715, 399, 75, 25);
		NewRidePanel.add(btnSubmitVehicle);
		
		 TripsScrollPane = new JScrollPane();
		TripsScrollPane.setBorder(null);
		TripsScrollPane.setBounds(0, 0, 500, 200);
		NewRidePanel.add(TripsScrollPane);
		
		panelOfChairs = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelOfChairs.getLayout();
		flowLayout.setHgap(25);
		panelOfChairs.setBounds(0, 200, 800, 200);
		NewRidePanel.add(panelOfChairs);
		
		
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
		
		JLabel lblName = new JLabel();
		lblName.setText(client.name.getFirst().toUpperCase() + " " + client.name.getLast().toUpperCase());
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblName.setBounds(10, 0, 400, 20);
		UserNamePanel.add(lblName);
		
		btnBackRide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewRidePanel.setVisible(false);	
				ContentPanel.setVisible(true);			
			}
		});
	}


	private void setJPanelandComponent() {
		Main.getTripsArrayList();
		
		JPanel canvas = new JPanel();
		ArrayList<Trips> object = new ArrayList<Trips>();

		infoTrip=new JLabel("Trips details");
		NewRidePanel.add(infoTrip);
		infoTrip.setBounds(500,10,300,100);
		for(int i=0;i<10;i++)
		{
			Trips t= new Trips();
			t.setTripNumber(Integer.toString(i+1));
			t.setDestinationFrom("Alex");
			t.setDestinationTo("Cairo");
			t.setReservations("10000000001100000000011000000000110000000001");
		
			object.add(t);
		}
		
		canvas.setLayout(new GridLayout(0,1));		
	
	
		for(int i=0;i<object.size();i++)
			canvas.add(new MyPanel(object.get(i),infoTrip, panelOfChairs));
	
		TripsScrollPane.setViewportView(canvas);
		TripsScrollPane.setPreferredSize(new Dimension(500,200));
		
		canvas.setPreferredSize(new Dimension(200, object.size()*50));
		NewRidePanel.add(TripsScrollPane);
	
	}
}

//*Final