import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {

	private Ship ship;
	
	@Before
	public void setUp() throws Exception {
		this.ship = new Ship(3);
	}

	@Test
	public void testShipIsInitializedWithLife() {
		assertThat(this.ship.getLife(), is(3));
	}

	@Test
	public void testShipIsNotSunkOnInitialize() {
		assertThat(this.ship.isSunk(), is(false));
	}

	@Test
	public void testShipHitDeductsLife() throws Exception {
		this.ship.hit();
		assertThat(this.ship.getLife(), is(2));
	}

	@Test
	public void testShipCanBeSunk() throws Exception {
		int life = this.ship.getLife();
		for (int i = 0; i < life; i++) {
			this.ship.hit();
		}
		assertThat(this.ship.isSunk(), is(true));
	}

	@Test
	public void testShipUpdateCallsHit() throws Exception {
		 this.ship.update();
		 assertThat(this.ship.getLife(), is(2));
	}

	@Test(expected = Exception.class)
	public void testCannotHitShipMoreThenMaxLife() throws Exception {
		this.ship.hit();
		this.ship.hit();
		this.ship.hit();
		// error!
		this.ship.hit();
	}
}
