/*
 * Observer pattern
 */
public abstract class CoordinateSubject {
	protected Ship observer;

	// TODO
	// update the observer
	// read about the observer pattern
	//
	public void notifyObserver() {
		try {
			this.observer.hit();
		} catch (Exception e) {
			/* fixme */
		}
	}

	public Ship getObservable() {
		return this.observer;
	}

	public void attach(Ship observer) {
		this.observer = observer;
	}
}
