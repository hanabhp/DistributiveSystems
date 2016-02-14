import java.rmi.RemoteException;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


public class ChatImpl implements Chat {

    LinkedList<Client> clientList;
    FileWriter fw;

    ChatImpl(){
	clientList = new LinkedList<Client>();
	// fw = new FileWriter("history.txt");
    }

    public void connect(Client client){
	try {
	    if (clientList.size() == 0){
		fw = new FileWriter("history.txt", true);
	    }
	    clientList.add(client);
	    for (int i = 0; i < clientList.size(); i++){
		try {clientList.get(i).print("added",client.getName());}
		catch (Exception e){
		}
	    }
	} catch (IOException e) {
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
	if (clientList.size() == 0){
	    try {
		fw.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

    public void sendMessage(String msg, String name){
	try {
	    fw.write(String.format(name + ":"));
	    fw.write(System.lineSeparator()); 
	    fw.write(String.format(msg));
	    fw.write(System.lineSeparator()); 
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
