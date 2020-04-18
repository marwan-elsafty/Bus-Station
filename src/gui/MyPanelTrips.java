package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import accounts.Drivers;
import essentials.CustomSeat;
import essentials.Trips;
import essentials.Vehicles;


public class MyPanelTrips extends JPanel {

	private static final long serialVersionUID = 1L;
	private static int indexToDelete=0;

	MyPanelTrips(final Trips trip, final JLabel info,final int i) {

		  
		setBackground(new Color(107, 116, 147));
		setLayout(new FlowLayout());
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
				
				info.setText( "<html><pre>"+"Trip No : "+trip.getTripNumber()+ "   Type : "+ trip.getTripType() +"<br/>"+" <br/> "+ "<pre/> </html>"); 

				setIndexToDelete(i);
				}
			

			
		});
	}

	public static int getIndexToDelete() {
		return indexToDelete;
	}

	public static void setIndexToDelete(int indexToDelet) {
		indexToDelete = indexToDelet;
	}
	

}