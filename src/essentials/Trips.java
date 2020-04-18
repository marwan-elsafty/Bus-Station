package essentials;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import accounts.Drivers;
import essentials.Vehicles;
import utilities.StringManipulation;

public class Trips implements Serializable {
	
	private static final long serialVersionUID = 1L;


	public Trips() {		
	}
	
	public class Date implements Serializable {	

		private static final long serialVersionUID = 1L;

		public Date() {
		}
		
		public int day;
		public int month;
		public int year;
	}
	
	public enum TripsTypes implements Serializable{
        INTERNAL,
        EXTERNAL
    }
	
	public Date date = new Date();
	
	public Vehicles vehicle = new Vehicles();
	public Drivers driver = new Drivers();
	
	private TripsTypes tripType;
	
	private String tripNumber;
	private String destinationFrom;
	private String destinationTo;
	private double price;
	private double profit;
	private int numberStops;
	private boolean roundTrip;

	private String reservations;
	private int vehic;
	final private int priceKM = 10;
	
	private int distance;
	private String duration;
	
	private boolean calculated = false;


	public String getDestinationFrom() {
		return destinationFrom;
	}


	public void setDestinationFrom(String destinationFrom) {
		this.destinationFrom = StringManipulation.initialsToUpper(destinationFrom);
	}


	public String getDestinationTo() {
		return destinationTo;
	}

	public int knowVehic() {
		return vehic;
	}


	public String getReservations() {
		return reservations;
	}


	public void setReservations(String reservations) {
		this.reservations = reservations;
	}


	public void setDestinationTo(String destinationTo) {
		this.destinationTo = StringManipulation.initialsToUpper(destinationTo);
	}


	public String getTripNumber() {
		return tripNumber;
	}


	public void setTripNumber(String tripNumber) {
		this.tripNumber = tripNumber;
	}
	
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public double getPrice() {
		return price;
	}

	public int getNumberStops() {
		return numberStops;
	}


	public void setNumberStops(int numberStops) {
		this.numberStops = numberStops;
	}


	public boolean isRoundTrip() {
		return roundTrip;
	}


	public void setRoundTrip(boolean roundTrip) {
		this.roundTrip = roundTrip;
	}


	public TripsTypes getTripType() {
		return tripType;
	}


	public void setTripType(TripsTypes tripType) {
		this.tripType = tripType;
	}
	
	public int getDistance() {
		calculate();
		return distance;
	}
	
	public String getDuration() {
		calculate();
		return duration;
	}
	
	private void calculate() {
		if(calculated)
			return;
		
		// URLs needs plus signs replacing white spaces
		String origin = this.destinationFrom.replaceAll("\\s", "+");;
		String destination = this.destinationTo.replaceAll("\\s", "+");;
		
		String stringURL = "https://maps.googleapis.com/maps/api/distancematrix/json?"
							+ "origins=" + origin + "|Egypt"
							+ "&destinations=" + destination + "|Egypt"
							+ "&mode=driving";
		
		String line, outputString = "";
		
		try {
			URL url = new URL(stringURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while ((line = reader.readLine()) != null)
			     outputString += line+"\n";
			
		} catch (Exception IOException) {
		}
		
		
		String[] str = outputString.split("\"text\" : \"");
		
		// set distance
		String[] distanceString = str[1].split(" ");
		this.distance = Integer.parseInt(distanceString[0]);
		
		// set duration
		String[] durationString = str[2].split("\",");
		this.duration = StringManipulation.initialsToUpper(durationString[0]);	
		
		// set price
		this.price = ( this.distance * (this.priceKM / this.vehicle.getSeats() ) ) + this.profit;
				
		calculated = true;
	}
}
