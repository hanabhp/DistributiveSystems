import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SecondServer {

	public static void main(String[] args) {

		try {
			HelloImpl h = new HelloImpl("Hello Everyone!");
			Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h,1200);
			SecondImpl s = new SecondImpl();
			Second s_stub = (Second)UnicastRemoteObject.exportObject(s,1201);
			// create registry entry for remote object
			Registry registry= LocateRegistry.getRegistry();
			registry.bind("Hello1", h_stub);
			registry= LocateRegistry.getRegistry();
			registry.bind("second", s_stub);
			System.out.println("I am server : --> application ready <-- ");
						
		} catch (Exception e) {
			System.out.println("Error while executing request");
			e.printStackTrace();
		}
	}

}
