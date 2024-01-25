package src;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    // the specifics of a Volvo240 is given to the Car superclass constructor
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
    }

    // the speed factor of a Volvo240 depends on its trim factor 
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
