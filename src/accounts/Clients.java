package accounts;

import static accounts.Users.UserType.CLIENT;

import java.io.Serializable;

public class Clients extends Users implements Serializable {

	private static final long serialVersionUID = 1L;

    public Clients() {
        userType = CLIENT;
        numberOfTrips = 0;
    }
    
    private int numberOfTrips;
    private int age;

    @Override
    public String showUserType() {
        return "client";
    }
}
