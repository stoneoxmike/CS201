public class Airplane extends Vehicle {
    /**
     * Is it possible for this Vehicle to start a trip
     * at the given kind of Terrain?
     *
     * @param maxSpeed@return true if this Vehicle can start at the kind of Terrain,
     *                        false otherwise
     */
    public Airplane(double maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public boolean endTrip(Terrain t) {
        if ( t == Terrain.AIRPORT ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean move(Terrain t) {
        return true;
    }

    @Override
    public boolean startTrip(Terrain t) {
        if (t == Terrain.AIRPORT) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getSpeed(Terrain t) {
        return getMaxSpeed();
    }
}
