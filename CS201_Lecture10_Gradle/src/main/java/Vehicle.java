public abstract class Vehicle {
    private double maxSpeed;

    public Vehicle(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public abstract boolean startTrip(Terrain t);
    public abstract boolean endTrip(Terrain t);
    public abstract boolean move(Terrain t);
}