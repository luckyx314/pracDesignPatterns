import GumballMachine.GumballMachineRemote;
import Monitor.GumballMonitor;

import java.rmi.Naming;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        String[] location = {
                "rmi://127.0.0.1:1888/ph/gumballMachine",
                "rmi://127.0.0.1:1888/us/gumballMachine",
                "rmi://127.0.0.1:1888/saudi/gumballMachine",
        };

        GumballMonitor[] monitors = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitors[i] = new GumballMonitor(machine);

                System.out.println(monitors[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();
            System.out.println();
        }
    }
}
