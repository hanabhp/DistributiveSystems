import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote{

    public String getName() throws RemoteException;

    public void print(String msg, String name) throws RemoteException;	
}
