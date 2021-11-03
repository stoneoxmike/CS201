public class Airplane extends Vehicle {
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
}
