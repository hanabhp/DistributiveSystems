import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote{

    public void connect(Client client) throws RemoteException;
    
    public void disconnect(Client client) throws RemoteException;

    public void sendMessage(String msg) throws RemoteException;
		
}
