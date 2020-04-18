package essentials;

import java.io.Serializable;

import javax.swing.JLabel;

public class CustomSeat implements Serializable {

	private static final long serialVersionUID = 1L;

	public JLabel seatLabel;
	public boolean isGreen;
	public boolean isReserved;
	
	public CustomSeat(){
		isGreen = false;
		isReserved = false;
		seatLabel = new JLabel();
	}
}
