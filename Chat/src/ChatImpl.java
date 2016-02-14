import java.rmi.RemoteException;
import java.util.*;

public class ChatImpl implements Chat {

    LinkedList<Client> clientList;

    ChatImpl(){
	clientList = new LinkedList<Client>();
    }

    public void connect(Client client){
	clientList.add(client);
	for (int i = 0; i < clientList.size(); i++){
	    try {clientList.get(i).print("added",client.getName());}
	    catch (Exception e){
	    }
	}
    }
    
    public void disconnect(Client client){
	for (int i = 0; i < clientList.size(); i++){
	    try {clientList.get(i).print("disconnected", client.getName());}
	    catch (Exception e) {
	    }
	}
	clientList.remove(client);
    }

    public void sendMessage(String msg, String name){
	for (int i = 0; i < clientList.size(); i++){
	    try {clientList.get(i).print(msg, name);}
	    catch (Exception e) {

	    }
	}
    }
}
