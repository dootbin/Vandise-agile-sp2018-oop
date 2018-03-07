
public class Coordinate extends CoordinateSubject {
	private boolean called;
	private boolean hasShip;

	public Coordinate() {
		this.called = false;
		this.hasShip = false;
	}

	// TODO
	// call the coordinate, check if the ship was hit, missed, or sunk
	// read about the observer pattern
	//
	public String call() throws Exception {
		if (!this.called) {
			this.notifyObserver();
			return "Miss";
		} else {
			throw new Exception("Coordinate already called");
		}
	}

	// TODO
	//	read about inheritance and calling parent
	//	methods in Java
	//
	@Override
	public void attach(Ship observer) {
		// TODO
	}

	// TODO
	// return if the coordinate has been called or not
	//
	public boolean called() {
		return false;
	}

	// TODO
	// is there a ship on this coordinate?
	//
	public boolean hasShip() {
		return false;
	}
}
