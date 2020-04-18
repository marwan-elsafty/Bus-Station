package accounts;

import static accounts.Users.UserType.DRIVER;

import java.io.Serializable;

public class Drivers extends Users implements Serializable {

	private static final long serialVersionUID = 1L;
    
    public Drivers() {
        userType = DRIVER;
        tripsEncountered = 0;
    }
    
    public String review;
    public int tripsEncountered;
    private String ID;
    

    public String getID() {
		return ID;
	}


	public void setID(String ID) {
		this.ID = ID.toUpperCase();
	}


	@Override
    public String showUserType() {
        return "driver";
    }
    
    
}
