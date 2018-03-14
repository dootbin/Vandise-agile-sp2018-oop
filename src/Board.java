
public class Board {

	private int size;
	private int shipCount;
	Coordinate[] coordinateVector;
	
	public Board(int size) {
		this.size = size;
		this.shipCount = 0;
		this.coordinateVector = new Coordinate[size*size];
		for (int i = 0; i < this.coordinateVector.length; i++) {
			this.coordinateVector[i] = new Coordinate();
		}
	}

	public int getSize() {
		return this.size;
	}

	public String callCoordinate(int x, int y) throws Exception {
		int coordinates = y * this.size + x;
		return (this.coordinateVector[coordinates]).call();
	}

	public void addShip(int x, int y, ShipType type) throws Exception {
		
		Ship ship = ShipFactory.create(type);
		
		int size = ship.getLife();
		for (int i = 0; i < size; i++) {
			int coordinate = ( y - i ) * this.size + x;
			if (coordinate < 0 ) {
				throw new Exception("Invalid coordinate");
			}
			(this.coordinateVector[coordinate]).attach(ship);
		}
		this.shipCount += 1;
	}

	public int getShipCount() {
		return this.shipCount;
	}
}
