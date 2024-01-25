package src;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {

    protected Point2D.Double position; // the position of the car
    protected double directionAngle; // the current angle of the car in space
    protected double[] direction; // cos and sin of directionAngle (in that order)
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    // gas, brake, move and turn only has effect if engine is on?
    // protected boolean engineOn;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.directionAngle = 0.0;
        this.direction = new double[] { Math.cos(directionAngle), Math.sin(directionAngle) };
        this.position = new Point2D.Double(0, 0);
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    /* 
     * start/stop engine only set boolean, engine needs to be on in order to 
     * gas/break
     */

    // starting the engine sets the speed to 0.1
    public void startEngine() {
        // engineOn = true; 
        currentSpeed = 0.1;
    }

    // stopping the engine sets the speed to 0
    public void stopEngine() {
        // engineOn =  false;
        currentSpeed = 0;
    }

    // speed factor depends on car model
    protected abstract double speedFactor();


    private void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    private void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    // current speed is not allowed to go above the engine power nor below 0 
    private void setCurrentSpeed(double newSpeed) {
        currentSpeed = Math.clamp(newSpeed, 0, enginePower);
    }

    // gas and break is only allowed values within the span [0,1]
    public void gas(double amount) {
        if (amount < 0 || 1 < amount) {
            throw new IllegalArgumentException();
        }
        // if (engienOn)
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount < 0 || 1 < amount) {
            throw new IllegalArgumentException();
        }
        // if (engienOn)
        decrementSpeed(amount);
    }

    public void move() {
        position.setLocation(position.getX() + currentSpeed * direction[0],
                position.getY() + currentSpeed * direction[1]);
    }

    public double getDirection() {
        return directionAngle;
    }

    // turnspeed is currently arbitrarily set as 1
    public void turnLeft() {
        turn(1);
    }

    public void turnRight() {
        turn(-1);
    }

    private void turn(double angleDelta) {
        directionAngle += angleDelta;
        direction = new double[] { Math.cos(directionAngle), Math.sin(directionAngle) };
    }

    // returns a copy of the position, prevents the car positoin from being changed from 
    // outside of the cars movement methods
    public Point2D.Double getPosition() {
        return new Point2D.Double(this.position.x, this.position.y);
    }

}
