package testSocket;

import java.io.BufferedReader;
import java.io.IOException;


public class Reception_Client implements Runnable {

	private BufferedReader in;
	private String message = null;
	
	public Reception_Client(BufferedReader in){
		
		this.in = in;
	}
	
	public void run() {
		
		while(true){
	        try {
	        	
			message = in.readLine();
			System.out.println("Le serveur vous dit :" +message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
