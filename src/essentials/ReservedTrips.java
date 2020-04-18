package essentials;

import java.io.Serializable;

public class ReservedTrips implements Serializable {
	
	private static final long serialVersionUID = 1L;


	public ReservedTrips() {
	}
	
	private String username;
	private String tripNumber;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTripNumber() {
		return tripNumber;
	}
	public void setTripNumber(String tripNumber) {
		this.tripNumber = tripNumber;
	}
}
