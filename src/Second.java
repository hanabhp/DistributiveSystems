import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Second extends Remote{

	public String sayHi(int c, Hello o, Person p) throws RemoteException;

}
