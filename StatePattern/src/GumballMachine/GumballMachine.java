package GumballMachine;
import State.State;
import State.SoldState;
import State.SoldOutState;
import State.NoQuarterState;
import State.HasQuarterState;
import State.WinnerState;


public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0)
            state = noQuarterState;
        else
            state = soldOutState;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0)
            count = count - 1;
    }
    // other methods below


    public int getCount() {
        return count;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public State getState() {
        return state;
    }

    // setters
    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }
    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }
    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }
    public void setHasQuarterState(State hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setState(State state) {
        this.state = state;
    }
    public void setWinnerState(State winnerState) {
        this.winnerState = winnerState;
    }

    @Override
    public String toString() {
        return "Inventory: " +  count + " gumballs";
    }
}
