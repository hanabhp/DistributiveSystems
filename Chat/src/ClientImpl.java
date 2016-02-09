import java.rmi.RemoteException;

public class ClientImpl implements Client {

    

    public void print(String msg){
	System.out.println(msg);
    }
    
}
