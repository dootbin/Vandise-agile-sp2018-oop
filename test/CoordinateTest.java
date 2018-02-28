import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

	private Ship ship;
	private Coordinate coordinate;
	
	@Before
	public void setUp() throws Exception {
		this.ship = ShipFactory.create(ShipType.BATTLESHIP);
		this.coordinate = new Coordinate();
	}

	@Test
	public void testHasShipIsEmptyWithoutShipSet() {
		assertThat(this.coordinate.hasShip(), is(false));
	}
	
	@Test
	public void testCallingCoordinateSetsCalled() throws Exception {
		this.coordinate.call();
		assertThat(this.coordinate.called(), is(true));
	}
	
	@Test
	public void testCoordinateMissesWhenNoShipIsOnIt() throws Exception {
		assertThat(this.coordinate.call(), is("Miss"));
	}

	@Test
	public void testShipOnCoordinateCanBeHit() throws Exception {
		this.coordinate.attach(this.ship);
		this.coordinate.call();
		assertThat(this.ship.getLife(), is(3));
	}

	@Test
	public void testShipCanBeObservedOnMultipleCoordinates() throws Exception {
		Coordinate c = new Coordinate();
		c.attach(this.ship);
		this.coordinate.attach(this.ship);

		this.coordinate.call();
		assertThat(this.ship.getLife(), is(3));

		c.call();
		assertThat(this.coordinate.getObservable().getLife(), is(2));
		assertThat(this.coordinate.getObservable().getLife(), is(
				c.getObservable().getLife()));
	}
}
