public class Ship implements Observable {
	private int life;
	private boolean sunk;

	public Ship(int life) {
		this.life = life;
		this.sunk = false;
	}

	public void update() throws Exception {
		this.hit();
	}

	public boolean isSunk() {
		return this.sunk;
	}

	public int getLife() {
		return this.life;
	}

	public void hit() throws Exception {
		if (!this.sunk) {
			this.life -= 1;
			if (this.life == 0) {this.sunk = true; }
		} else {
			throw new Exception("Hit on ship that's already sunk.");
		}
	}
}
