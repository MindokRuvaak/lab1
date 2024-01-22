package src;
import java.awt.*;

public abstract class Car implements Movable {

    protected Point position;
    protected double directionAngle;
    protected double[] direction;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = new double[]{0.0, 0.0};
        this.position = new Point(0,0);
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

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    public void move() {
        position.move(position.x + (int) (currentSpeed*direction[0]), 
                        position.y + (int) (currentSpeed*direction[1]));
    }

    public double[] getDirection() {
        return direction;
    }

    public void turnLeft() {
        directionAngle++;
        direction = new double[] { Math.cos(directionAngle), Math.sin(directionAngle)};
    }

    public void turnRight() {
        directionAngle--;
        direction = new double[] { Math.cos(directionAngle), Math.sin(directionAngle)};
    }

    public Point getPosition() {return this.position;}

}
