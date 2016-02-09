import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient {

	public static void main(String[] args) {
		try {
			
			if(args.length<1){
				System.out.println("Usage: java ChatClient <server host>");
				return;
			}
			String host =args[0];
			Registry registry = LocateRegistry.getRegistry(host);
			Chat h = (Chat) registry.lookup("PublicChat");
			
			ClientImpl hC = new ClientImpl();
			Client hC_stub = (Client) UnicastRemoteObject.exportObject(hC,0);
			
			h.connect(hC_stub);
			h.sendMessage("hello world");
			h.disconnect(hC_stub);

		} catch (Exception e) {
			System.out.println(" Application Error ");
			e.printStackTrace();
		}
	}
}
