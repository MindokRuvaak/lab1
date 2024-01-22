import java.util.Arrays;
import src.*;

public class testingMain {
    /*
        Simple main for testing :)
    */
    public static void main(String[] args) {
        Car saab = new Saab95();
        Car volvo = new Volvo240();

        System.out.println("Saab95: x " + saab.getDirection()); // prints a null
        saab.turnLeft();
        System.out.println("Saab95: x " + saab.getDirection());

        volvo.startEngine();
        volvo.move();
        System.out.println(volvo.getCurrentSpeed());
        System.out.println("Volvo40: x " + volvo.getDirection());
        System.out.println("Volvo 240 x " + volvo.getPosition());
    }
}
