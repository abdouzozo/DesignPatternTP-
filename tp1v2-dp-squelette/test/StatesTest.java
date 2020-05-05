import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.ensim.dp.map.player.EtatForward;
import fr.ensim.dp.map.player.EtatPlay;
import fr.ensim.dp.map.player.EtatStop;
import fr.ensim.dp.map.player.Player;

public class StatesTest {
	
	@Test
	public void testAll() {
		Player player = new Player();
		assertEquals(player.etat.getClass(),EtatStop.class);
		
		player.play();
		assertEquals(player.etat.getClass(),EtatPlay.class);
		
		
		player.forward();
		assertEquals(player.etat.getClass(),EtatForward.class);
		
		
	}

}
