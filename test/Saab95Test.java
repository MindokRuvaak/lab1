package test;

import org.junit.Before;
import org.junit.Test;
import src.*;

import static org.junit.Assert.assertTrue;

public class Saab95Test {
    Saab95 testSaab = new Saab95();

    @Before
    public void init() {
        testSaab = new Saab95();
    }

    @Test
    public void testSetTurboOn() {
        double initSpeed = testSaab.getCurrentSpeed();
        testSaab.gas(1);
        double gasWoTurbo = testSaab.getCurrentSpeed();
        testSaab.setTurboOn();
        testSaab.gas(1);
        double gasWithTurbo = testSaab.getCurrentSpeed();
        assertTrue((gasWoTurbo - initSpeed) < (gasWithTurbo - gasWoTurbo));
    }
}
