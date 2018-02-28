import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class ShipFactoryTest {

	@Test
	public void testCanCreatePatrolShips() throws Exception {
		Ship ship = ShipFactory.create(ShipType.PATROL);
		assertThat(ship.getLife(), is(2));
	}

	@Test
	public void testCanCreateSubShips() throws Exception {
		Ship ship = ShipFactory.create(ShipType.SUBMARINE);
		assertThat(ship.getLife(), is(3));
	}

	@Test
	public void testCanCreateDestroyerShips() throws Exception {
		Ship ship = ShipFactory.create(ShipType.DESTROYER);
		assertThat(ship.getLife(), is(3));
	}

	@Test
	public void testCanCreateCarrierShips() throws Exception {
		Ship ship = ShipFactory.create(ShipType.CARRIER);
		assertThat(ship.getLife(), is(5));
	}

	@Test
	public void testCanCreateBattleShips() throws Exception {
		Ship ship = ShipFactory.create(ShipType.BATTLESHIP);
		assertThat(ship.getLife(), is(4));
	}
}
