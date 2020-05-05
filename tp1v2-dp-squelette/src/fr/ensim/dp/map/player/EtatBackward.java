package fr.ensim.dp.map.player;

public class EtatBackward extends StateAdaptator {
	@Override
	public void stop(Player player) {
		player.etat = new EtatStop();
	} 
	
	@Override
	public void forward(Player player) {
		player.etat = new EtatForward();
	} 
}
