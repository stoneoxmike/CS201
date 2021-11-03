public class Car extends Vehicle {

	@Override
	public boolean endTrip(Terrain t) {
		if ( t == Terrain.AIRPORT || t == Terrain.MARINA ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean move(Terrain t) {
		if ( t == Terrain.AIRPORT || t == Terrain.MARINA || t == Terrain.ROAD ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean startTrip(Terrain t) {
		if ( t == Terrain.AIRPORT || t == Terrain.MARINA ) {
			return true;
		} else {
			return false;
		}
	}
}
