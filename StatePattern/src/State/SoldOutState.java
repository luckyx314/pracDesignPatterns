package State;

import GumballMachine.GumballMachine;

public class SoldOutState implements State{
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter.\nThe machine has sold out!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject. You haven't inserted a quarter.");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumballs dispensed");
    }

    @Override
    public String toString() {
        return "Sold out";
    }
}
