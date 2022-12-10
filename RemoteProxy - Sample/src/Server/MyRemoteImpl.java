package Server;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{

    protected MyRemoteImpl() throws RemoteException {};

    @Override
    public String sayHello() throws RemoteException {
        return "Saying hello";
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
//            Naming.rebind("RemoteHello", service);

            final int PORT = 1888;
            Registry rgsty = LocateRegistry.createRegistry(PORT);
            rgsty.rebind("hello", service);
            System.out.println("Service is running on PORT: " + PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
