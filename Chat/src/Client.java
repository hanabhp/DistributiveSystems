import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote{

    public void print(String msg) throws RemoteException;	
}
