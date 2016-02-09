import java.rmi.RemoteException;

public class HelloImpl implements Hello {

	private String message;

	public HelloImpl(String s) {
		message = s;
	}

	public String sayHello() throws RemoteException {
		return message;
	}

}
