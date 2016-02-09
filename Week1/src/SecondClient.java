import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SecondClient {

	public static void main(String[] args) {
		try {
			
			if(args.length<1){
				System.out.println("Usage: java HelloCleint <server host>");
				return;
			}
			String host =args[0];
			Registry registry = LocateRegistry.getRegistry(host);
			Hello h = (Hello) registry.lookup("Hello1");
			Second s = (Second) registry.lookup("second");
			Person p = new Person("Hana", "Brh");
			String result = h.sayHello();
			System.out.println(result);
			String result2 = s.sayHi(3, h, p);
			System.out.println(result2);
			
		} catch (Exception e) {
			System.out.println(" Application Error ");
			e.printStackTrace();
		}
	}
}
