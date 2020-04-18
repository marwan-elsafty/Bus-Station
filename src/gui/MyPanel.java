package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import essentials.CustomSeat;
import essentials.Trips;


public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int i;
	MyPanel(final Trips trip,final JLabel info,final JPanel NewRidePanel) {
		//Trips trip=new Trips();	
		 ArrayList<String []> object = new ArrayList<String []>();
		 //object=trip.getTrips();
		  
		setBackground(new Color(107, 116, 147));

		JLabel l=new JLabel(trip.getTripNumber());
		add(l);

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				setBackground(new Color(137, 116, 147));
				}
		
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(107, 116, 147));

			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				info.setFont(new Font("Century Gothic", Font.BOLD, 12));
				
				info.setText( "<html><pre>Trip No : "+trip.getTripNumber()+"   Driver: "+"     "+"<br/>"+"<br/>"+"From : "+trip.getDestinationFrom()+"     To : "+ trip.getDestinationTo()
			+"<br/>"+"<br/>"+"Number of stops : "+trip.getNumberStops()+"<br/>"+"<br/>"+"Price : "+trip.getPrice()	+ " <br/> "+ "<pre/> </html>"); 

				/***************************************************/

				// n = number of chairs
				// endLine = number or 
					// bounds iterators
					int NEW_ROW;
					int x = NEW_ROW = 88;
					int y = 210;

					System.out.println(trip.getReservations());
					/* 
					 * GETS NUMBER OF SEAT FROM ENTERED BUS
					 * TRIP MUST HAVE INSTAMCE OF BUS
					 **/
					NewRidePanel.removeAll();
					int numberOfChairs=0,endLine=20;
					//Bus ---> vehicle=0
					//mini bus---> vehicle=1
					//lemosine ----> vehicle=2
					//n=number of chairs , 
					if(trip.knowVehic()==0)
					{
						numberOfChairs=40;
						endLine=20;
						
					}
					else if ( trip.knowVehic()==1) 
					{
						numberOfChairs=30;
						endLine=20;
					}
					else {
						return;
					}
					
					
					for( i=0 ; i<numberOfChairs ; i++) {
				    	final CustomSeat seat =  new CustomSeat();
				        seat.seatLabel.addMouseListener(new MouseAdapter() {
				        	
				        	// switching seat into green
					    	// reserving seat
				        	@Override
							public void mouseClicked(MouseEvent arg0) {
				        		// check if reserved
				        		// do nothing
				        		if(trip.getReservations().charAt(Integer.parseInt(seat.seatLabel.getText())-1)=='1')
				        			return;
				        			
				        		// check if already green
				        		// return seat to black if re-pressed
				        		if(seat.isGreen) {
				        			seat.seatLabel.setIcon(new ImageIcon("icons\\seatUnreserved.png"));

									seat.isGreen = false;
									return;
				        		}	        		
				        		
				        		seat.seatLabel.setIcon(new ImageIcon("icons\\seatGreen.png"));
				        		
								seat.isGreen = true;
							}
								        	
				        	// switching seat into blue
				        	// hovering over
							@Override
							public void mouseEntered(MouseEvent arg0) {
								// check if green or reserved
				        		// do not hover over
								if(trip.getReservations().charAt(Integer.parseInt(seat.seatLabel.getText())-1)=='1'|| seat.isGreen)
									return;		
								seat.seatLabel.setIcon(new ImageIcon("icons\\seatBlue.png"));
							}
											
							// switching seat into black
				        	// hovering over ended
							@Override
							public void mouseExited(MouseEvent arg0) {
								// check if green or reserved
				        		// do nothing
								if(trip.getReservations().charAt(Integer.parseInt(seat.seatLabel.getText())-1)=='1'|| seat.isGreen)
									return;					
								seat.seatLabel.setIcon(new ImageIcon("icons\\seatUnreserved.png"));						
							}
						});
				        
				        
				        if (trip.getReservations().charAt(i)=='1') {
				        	if(i<9)seat.seatLabel.setText("0"+Integer.toString(i+1));
							
					        else
					        	{seat.seatLabel.setText(Integer.toString(i+1));}				        	
				        	seat.seatLabel.setIcon(new ImageIcon("icons\\seatRed.png"));}
				        else	
				        {	if(i<9)seat.seatLabel.setText("0"+Integer.toString(i+1));
			
				        else
				        	{seat.seatLabel.setText(Integer.toString(i+1));}
				        	seat.seatLabel.setIcon(new ImageIcon("icons\\seatUnreserved.png"));}
				            seat.seatLabel.setBounds(x, y, 32, 32);
					        NewRidePanel.add(seat.seatLabel);
					        NewRidePanel.repaint();
					        x+=65; 
				    }
					//add your elements
					revalidate();
					repaint();
					
				}
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				/***************************************************/
				

				
				
			
		});
	}

}