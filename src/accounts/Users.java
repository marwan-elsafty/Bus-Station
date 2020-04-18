package accounts;

import java.io.Serializable;

import utilities.StringManipulation;

public abstract class Users implements Serializable{

	private static final long serialVersionUID = 1L;

	public Users() {                                          // EH LAZMETHA?
    }
    
    public class Name implements Serializable {
        
		private static final long serialVersionUID = 1L;

		public Name() {                                     // EH LAZMETHA?
        }
        
        public Name(String first, String last) {
            this.first = StringManipulation.initialsToUpper(first);
            this.last = StringManipulation.initialsToUpper(last);
        }
        
        private String first;
        private String last;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = StringManipulation.initialsToUpper(first);
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = StringManipulation.initialsToUpper(last);
        }
    }
    
    public enum UserType implements Serializable {
        MANGER,
        DRIVER,
        CLIENT    
    }
    
    public Name name = new Name();              
    protected String userPassword;
    protected String userName;
    protected String email;
    protected UserType userType;

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String accountPassword) {
        this.userPassword = accountPassword;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public UserType getUserType() {
        return this.userType;
    }
    
    public abstract String showUserType();
}
