import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
	public static void main(String [] args) {
		try{
			if (args.length <1) {
				System.out.println("Usage:java HelloClient <rmiregistry host>");
				return ;
			}
			String host=args [0];
			Registry registry = LocateRegistry.getRegistry(host);
			Hello h= (Hello) registry.lookup("Hello1");
			String res= h.sayHello();
		}
			catch(Exception e){
				System.out.println("Error on Client:" + e);
				e.printStackTrace();
			}
				
	}
}


