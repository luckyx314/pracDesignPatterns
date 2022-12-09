package Flying;

import Flying.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        // do nothing --cant fly!
        System.out.println("I can't fly");
    }
}
