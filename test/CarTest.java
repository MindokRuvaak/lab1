package test;

import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import src.*;

public class CarTest {

    Car testCar;

    @Before
    public void init() {
        testCar = new Saab95();
        testCar.startEngine();
    }

    @Test
    public void testBrake() {
        double initSaabSpeed = testCar.getCurrentSpeed();
        testCar.brake(0.1);
        assertTrue(
            initSaabSpeed > testCar.getCurrentSpeed() 
        );
    }

    @Test
    public void testGas() {
        double initSaabSpeed = testCar.getCurrentSpeed();
        testCar.gas(0.1);
        assertTrue(
            initSaabSpeed < testCar.getCurrentSpeed() 
        );
    }

    @Test
    public void testGetColor() {
        assertTrue(testCar.getColor().getClass() == Color.class);
    }

    @Test
    public void testGetCurrentSpeed() {
        assertTrue(Double.isFinite(testCar.getCurrentSpeed()));
    }

    @Test
    public void testGetDirection() {
        assertTrue(Double.isFinite(testCar.getDirection()));
    }

    @Test
    public void testGetEnginePower() {
        
    }

    @Test
    public void testGetNrDoors() {
        int nrDoors = testCar.getNrDoors();
        assertTrue(nrDoors == 2 || nrDoors == 4);
    }

    @Test
    public void testMove() {


    }

    @Test
    public void testSetColor() {

    }

    @Test
    public void testSpeedFactor() {

    }

    @Test
    public void testStartEngine() {

    }

    @Test
    public void testStopEngine() {

    }

    @Test
    public void testTurnLeft() {

    }

    @Test
    public void testTurnRight() {

    }
}
