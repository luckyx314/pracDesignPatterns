import GumballMachine.GumballMachine;

import java.rmi.registry.*;
import java.util.Scanner;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //            Naming.rebind("//" + loc + "/gumballmachine", gumballMachine);


            final int PORT = 1888;

            GumballMachine gumballMachine1 = new GumballMachine("ph", 3);
            GumballMachine gumballMachine2 = new GumballMachine("us", 2);
            GumballMachine gumballMachine3 = new GumballMachine("saudi", 1);

            Registry registry = LocateRegistry.createRegistry(PORT);


            registry.bind("ph/gumballMachine", gumballMachine1);
            registry.bind("us/gumballMachine", gumballMachine2);
            registry.bind("saudi/gumballMachine", gumballMachine3);

            System.out.println("Service is running on PORT: " + PORT);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}