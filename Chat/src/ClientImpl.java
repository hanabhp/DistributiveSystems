import java.rmi.RemoteException;

public class ClientImpl implements Client {

    String name;
    
    ClientImpl(){
	name = new String();
    }

    public String getName(){
	return name;
    }

    public void print(String msg, String name){
	System.out.println(name + ":");
	System.out.println(msg);
    }
    
}
