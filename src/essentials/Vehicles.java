package essentials;

import java.io.Serializable;

public class Vehicles implements Serializable {

	private static final long serialVersionUID = 1L;

	public Vehicles() {     //???
    }
    
    public enum VehiclesTypes implements Serializable{
        BUS,
        MINIBUS,
        LIMOUSINE
    }

    private String ID;
    private int seats;
    private int availableSeats;
    private VehiclesTypes vehicleType;

	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID.toUpperCase();
	}
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		this.seats = this.availableSeats = seats;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public VehiclesTypes getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehiclesTypes vehicleType) {
		this.vehicleType = vehicleType;
	}  
}
