package accounts;

import static accounts.Users.UserType.MANGER;   //??

import java.io.Serializable;

public class Managers extends Users implements Serializable {

	private static final long serialVersionUID = 1L;
   
    public Managers() {
        userType = MANGER;
    }
    
    public double salary;

    @Override
    public String showUserType() {
        return "manger";
    }
    
}
