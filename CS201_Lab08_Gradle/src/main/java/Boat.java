public class Boat extends Vehicle {
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
}
