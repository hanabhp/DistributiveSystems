import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatServer {

	public static void main(String[] args) {

		try {
			ChatImpl h = new ChatImpl();
			Chat h_stub = (Chat) UnicastRemoteObject.exportObject(h,0);
			// SecondImpl s = new SecondImpl();
			// Second s_stub = (Second)UnicastRemoteObject.exportObject(s,1201);
			// create registry entry for remote object
			
			Registry registry= LocateRegistry.getRegistry();
			registry.bind("PublicChat", h_stub);
			System.out.println("I am server : --> Chat ready <-- ");
						
		} catch (Exception e) {
			System.out.println("Error while executing request");
			e.printStackTrace();
		}
	}

}
