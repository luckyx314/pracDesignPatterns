import GumballMachine.GumballMachine;

public class Main {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(3);
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}