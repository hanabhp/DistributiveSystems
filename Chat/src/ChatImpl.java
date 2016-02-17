import java.rmi.RemoteException;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*;

public class ChatImpl implements Chat {

    LinkedList<Client> clientList;
    FileWriter fw;

    ChatImpl(){
	clientList = new LinkedList<Client>();
	//fw = new FileWriter("history.txt");
    }

    public void connect(Client client){
	try {
	    FileReader fr = new FileReader("history.txt");
	    BufferedReader br = new BufferedReader(fr);
	    String s;
	    while((s = br.readLine()) != null) {
		client.print(s, "History");
	    }
	    fr.close();

	    // if (clientList.size() == 0){
	    // 	fw = new FileWriter("history.txt", true);
	    // }
	    clientList.add(client);
	    for (int i = 0; i < clientList.size(); i++){
		try {clientList.get(i).print("added",client.getName());}
		catch (Exception e){
		}
	    }
	
	} catch (FileNotFoundException e) {
	    try {client.print("No History","History");}
	    catch (Exception e2){}
	}
	 catch (IOException e) {
	    e.printStackTrace();
	 }
    }
    
    public void disconnect(Client client){
	for (int i = 0; i < clientList.size(); i++){
	    try {clientList.get(i).print("disconnected", client.getName());}
	    catch (Exception e) {
	    }
	}
	clientList.remove(client);
	// if (clientList.size() == 0){
	//     try {
	// 	fw.close();
	//     } catch (IOException e) {
	// 	e.printStackTrace();
	//     }
	// }
    }

    public void sendMessage(String msg, String name){
	try {
	    fw = new FileWriter("history.txt", true);
	    fw.write(String.format(name + ":"));
	    fw.write(System.lineSeparator()); 
	    fw.write(String.format(msg));
	    fw.write(System.lineSeparator()); 
	    fw.close();
	    for (int i = 0; i < clientList.size(); i++){
		try {clientList.get(i).print(msg, name);}
		catch (Exception e) {

		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
