package gui;

public class LoadProgram extends Thread {

	public void run() {
		Loading loading = new Loading();
	    loading.setVisible(true);
	    
	    LogIn logIn = new LogIn();
	    logIn.setVisible(false);
	
		for(int i=0 ; i<100 ; i++) {    	
	    	try {
	    		Thread.sleep(20);
	    	} catch ( Exception e){       
	        }
	        loading.lbLoading.setText(Integer.toString(i));               
	    }
		
		loading.dispose();
	    logIn.setVisible(true);
	}
}