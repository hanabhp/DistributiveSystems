import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.io.*;
//import java.awt.*;

public class ChatClient {
    
    //String name = new String();

    public static void main(String[] args) {
	try {
			
	    if(args.length<1){
		System.out.println("Usage: java ChatClient <server host>");
		return;
	    }
	    String host =args[0];
	    Registry registry = LocateRegistry.getRegistry(host);
	    Chat h = (Chat) registry.lookup("PublicChat");
			
	    ClientImpl hC = new ClientImpl();
	    Client hC_stub = (Client) UnicastRemoteObject.exportObject(hC,0);
			
	    // ask cient for his name
	    Scanner in = new Scanner(System.in);
	    
	    System.out.println("Welcome to our public chat, to connect please enter a pseudo");
	    hC.name = in.nextLine();
	    
	    String inputString = new String();
	    
	    // System.out.println("Print history? (Y/N)");
	    // inputString = in.nextLine();
	    // while (!inputString.contentEquals("N") && (!inputString.contentEquals("Y"))){
	    // 	System.out.println("Please answer by Y for yes, or N for no");
	    // 	inputString = in.nextLine();
	    // }
	    // if (inputString.contentEquals("Y")){
		
	    // }
	    
	

	    h.connect(hC_stub);

	    		    
	    while (!inputString.contentEquals("quit")){
		inputString = in.nextLine();
		h.sendMessage(inputString, hC.name);
	    }
	    h.disconnect(hC_stub);
	    System.exit(0);
	} catch (Exception e) {
	    System.out.println(" Application Error ");
	    e.printStackTrace();
	}
    }
}
