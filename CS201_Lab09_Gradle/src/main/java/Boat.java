public class Boat extends Vehicle {
    /**
     * Is it possible for this Vehicle to start a trip
     * at the given kind of Terrain?
     *
     * @param maxSpeed@return true if this Vehicle can start at the kind of Terrain,
     *                        false otherwise
     */
    public Boat(double maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public boolean endTrip(Terrain t) {
        if ( t == Terrain.MARINA ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean move(Terrain t) {
        if ( t == Terrain.WATER || t == Terrain.MARINA ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean startTrip(Terrain t) {
        if (t == Terrain.MARINA) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getSpeed(Terrain t) {
        if (t == Terrain.WATER) {
            return getMaxSpeed();
        } else if (t == Terrain.MARINA){
            return getMaxSpeed() * 0.25;
        } else {
            throw new IllegalArgumentException("Illegal terrain: " + t);
        }
    }
}
