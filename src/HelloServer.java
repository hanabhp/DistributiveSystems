import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer {
	public static void main(String[] args) {
		try {
			HelloImpl h = new HelloImpl("Hello World");
			Hello h_stub = (Hello) UnicastRemoteObject.exportObject(h, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Hello", h_stub);
			System.out.println("Server ready");
		} catch (Exception e) {
			System.out.println("Error on server:" + e);
			e.printStackTrace();
		}
	}

}
