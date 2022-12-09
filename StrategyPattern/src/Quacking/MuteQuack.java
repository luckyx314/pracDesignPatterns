package Quacking;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        // do nothing - cant quack!
        System.out.println("<< Silence >>");
    }
}
