package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import accounts.Clients;
import accounts.Drivers;
import accounts.Managers;
import essentials.Trips;
import essentials.Vehicles;
import essentials.ReservedTrips;

public class Main {
	
	private static ArrayList <Clients> clientsArrayList = new ArrayList <Clients> ();
	private static ArrayList <Managers> managersArrayList = new ArrayList <Managers> ();
	private static ArrayList <Drivers> driversArrayList = new ArrayList <Drivers> ();
	private static ArrayList <Trips> tripsArrayList = new ArrayList <Trips> ();
	private static ArrayList <ReservedTrips> reservedTripsArrayList = new ArrayList <ReservedTrips> ();
	private static ArrayList <Vehicles> vehiclesArrayList = new ArrayList <Vehicles> ();
	
	
	/* clients setters and getters
	 */
    public static ArrayList<Clients> getClientsArrayList() {
		return Main.clientsArrayList;
	}

	public static void setClientsArrayList() {
		// load client data-base
    	try {
			FileInputStream clientsFile = new FileInputStream("data-base\\clientsFile.ser");
			ObjectInputStream clientsData = new ObjectInputStream(clientsFile);					
			
			while(clientsData.available()>0)
				Main.clientsArrayList.add((Clients) clientsData.readObject());
					
			clientsData.close();
			clientsFile.close();
			
    	} catch (FileNotFoundException e) {
			System.out.println("clients :: file not found");
		} catch (IOException e) {
			System.out.println("clients :: error initializing stream");
		} catch (ClassNotFoundException e) {
			System.out.println("clients :: class not found");
		}
	}

	// write in clients file
	public static void writeToFileClientsArrayList() {
		try {
			FileOutputStream clientsFile = new FileOutputStream("data-base\\clientsFile.ser");
			ObjectOutputStream clientsData = new ObjectOutputStream(clientsFile);

			for(int i = 0 ; i < Main.getClientsArrayList().size() ; i++)
				clientsData.writeObject(Main.getClientsArrayList().get(i));
			
			clientsData.close();
			clientsFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("clients :: file not found");
		} catch (IOException e) {
			System.out.println("clients :: error initializing stream");
		}	

	}
	
	
	
	/* managers setters and getters
	 */
	public static ArrayList<Managers> getManagersArrayList() {
		return Main.managersArrayList;
	}

	public static void setManagersArrayList() {
		// load managers data-base
    	try {
			FileInputStream managersFile = new FileInputStream("data-base\\managersFile.ser");
			ObjectInputStream managersData = new ObjectInputStream(managersFile);					

			while(managersData.available()>-1)
				Main.managersArrayList.add((Managers) managersData.readObject());
				
			managersData.close();
			managersFile.close();
			
	    } catch (FileNotFoundException e) {
			System.out.println("managers :: file not found");
		} catch (IOException e) {
			System.out.println("managers :: error initializing stream");
		} catch (ClassNotFoundException e) {
			System.out.println("managers :: class not found");
		}
	}
	
	// write in managers file
	public static void writeToFileManagersArrayList() {
		try {
			FileOutputStream managersFile = new FileOutputStream("data-base\\managersFile.ser");
			ObjectOutputStream managersData = new ObjectOutputStream(managersFile);

			for(int i = 0 ; i < Main.getManagersArrayList().size() ; i++)
				managersData.writeObject(Main.getManagersArrayList().get(i));
			
			managersData.close();
			managersFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("managers :: file not found");
		} catch (IOException e) {
			System.out.println("managers :: error initializing stream");
		}
	}
	
	
	
	/* drivers setters and getters 
	 */
	public static ArrayList<Drivers> getDriversArrayList() {
		return Main.driversArrayList;
	}
	
	public static void setDriversArrayList() {
		// load drivers data-base
    	try {
			FileInputStream driversFile = new FileInputStream("data-base\\driversFile.ser");
			ObjectInputStream driversData = new ObjectInputStream(driversFile);					

			while(driversData.available()>-1)
				Main.driversArrayList.add((Drivers) driversData.readObject());
				
			driversData.close();
			driversFile.close();
			
    	} catch (FileNotFoundException e) {
			System.out.println("drivers :: file not found");
		} catch (IOException e) {
			System.out.println("drivers :: error initializing stream");
		} catch (ClassNotFoundException e) {
			System.out.println("drivers :: class not found");
		}
	}	

	// write in drivers file
	public static void writeToFileDriversArrayList() {
		try {
			FileOutputStream driversFile = new FileOutputStream("data-base\\driversFile.ser");
			ObjectOutputStream driversData = new ObjectOutputStream(driversFile);

			for(int i = 0 ; i < Main.getDriversArrayList().size() ; i++)
				driversData.writeObject(Main.getDriversArrayList().get(i));
			
			driversData.close();
			driversFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("drivers :: file not found");
		} catch (IOException e) {
			System.out.println("drivers :: error initializing stream");
		}	
	}


	
	/* trips setters and getters
	 */
	public static ArrayList<Trips> getTripsArrayList() {
		return Main.tripsArrayList;
	}

	public static void setTripsArrayList() {
		// load trips data-base
    	try {
			FileInputStream tripsFile = new FileInputStream("data-base\\tripsFile.ser");
			ObjectInputStream tripsData = new ObjectInputStream(tripsFile);					

			while(tripsData.available()>-1)
				Main.tripsArrayList.add((Trips) tripsData.readObject());
				
			tripsData.close();
			tripsFile.close();
			
    	} catch (FileNotFoundException e) {
			System.out.println("trips :: file not found");
		} catch (IOException e) {
			System.out.println("trips :: error initializing stream");
		} catch (ClassNotFoundException e) {
			System.out.println("trips :: class not found");
		}
	}
	
	// write in trips file
	public static void writeToFileTripsArrayList() {
		try {
			FileOutputStream tripsFile = new FileOutputStream("data-base\\tripsFile.ser");
			ObjectOutputStream tripsData = new ObjectOutputStream(tripsFile);

			for(int i = 0 ; i < Main.getTripsArrayList().size() ; i++)
				tripsData.writeObject(Main.getTripsArrayList().get(i));
			
			tripsData.close();
			tripsFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("trips :: file not found");
		} catch (IOException e) {
			System.out.println("trips :: error initializing stream");
		}	
	}



	/* reserved trips setters and getters
	 */
	public static ArrayList<ReservedTrips> getReservedTripsArrayList() {
		return Main.reservedTripsArrayList;
	}

	public static void setReservedTripsArrayList() {
		// load reserved trips data-base
    	try {
			FileInputStream reservedTripsFile = new FileInputStream("data-base\\reservedTripsFile.ser");
			ObjectInputStream reservedTripsData = new ObjectInputStream(reservedTripsFile);					

			while(reservedTripsData.available()>-1)
				Main.reservedTripsArrayList.add((ReservedTrips) reservedTripsData.readObject());
				
			reservedTripsData.close();
			reservedTripsFile.close();
			
    	} catch (FileNotFoundException e) {
			System.out.println("reserved-trips :: file not found");
		} catch (IOException e) {
			System.out.println("reserved-trips :: error initializing stream");
		} catch (ClassNotFoundException e) {
			System.out.println("reserved-trips :: class not found");
		}
	}	
	
	// write in reserved trips file
		public static void writeToFileReservedTripsArrayList() {
			try {	
				FileOutputStream reservedTripsFile = new FileOutputStream("data-base\\reservedTripsFile.ser");
				ObjectOutputStream reservedTripsData = new ObjectOutputStream(reservedTripsFile);

				for(int i = 0 ; i < Main.getReservedTripsArrayList().size() ; i++)
					reservedTripsData.writeObject(Main.getReservedTripsArrayList().get(i));
				
				reservedTripsData.close();
				reservedTripsFile.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("reservedTrips :: file not found");
			} catch (IOException e) {
				System.out.println("reservedTrips :: error initializing stream");
			}
		}
	
	
	
	/* vehicles setters and getters
	 */
	public static ArrayList<Vehicles> getVehiclesArrayList() {
		return Main.vehiclesArrayList;
	}

	public static void setVehiclesArrayList() {
		// load reserved trips data-base
    	try {
			FileInputStream vehiclesFile = new FileInputStream("data-base\\vehiclesFile.ser");
			ObjectInputStream vehiclesData = new ObjectInputStream(vehiclesFile);					

			while(vehiclesData.available()>-1)
				Main.vehiclesArrayList.add((Vehicles) vehiclesData.readObject());
				
			vehiclesData.close();
			vehiclesFile.close();
			
    	} catch (FileNotFoundException e) {
			System.out.println("vehicles :: file not found");
		} catch (IOException e) {
			System.out.println("vehicles :: error initializing stream");
		} catch (ClassNotFoundException e) {
			System.out.println("vehicles :: class not found");
		}
	}
	
	// write in vehicles file
	public static void writeToFileVehiclesArrayList() {
		try {
			FileOutputStream vehiclesFile = new FileOutputStream("data-base\\vehiclesFile.ser");
			ObjectOutputStream vehiclesData = new ObjectOutputStream(vehiclesFile);

			for(int i = 0 ; i < Main.getVehiclesArrayList().size() ; i++)
				vehiclesData.writeObject(Main.getVehiclesArrayList().get(i));
			
			vehiclesData.close();
			vehiclesFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("vehicles :: file not found");
		} catch (IOException e) {
			System.out.println("vehicles :: error initializing stream");
		}
	}
	
	
	/* save on exit method
	 */
	public static void saveOnExit() {
		Main.writeToFileClientsArrayList();
		Main.writeToFileDriversArrayList();
		Main.writeToFileManagersArrayList();
		Main.writeToFileReservedTripsArrayList();
		Main.writeToFileTripsArrayList();
		Main.writeToFileVehiclesArrayList();
	}

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Main.setClientsArrayList();
		Main.setDriversArrayList();
		Main.setManagersArrayList();
		Main.setTripsArrayList();
		Main.setReservedTripsArrayList();
		
		Thread loadProgram = new LoadProgram();
		loadProgram.start();	
    }
}
