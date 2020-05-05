package fr.ensim.dp.map.player;

public class EtatPlay extends StateAdaptator {

	@Override
	public void stop(Player player) {
		player.etat = new EtatStop();
	} 

	@Override
	public void pause(Player player) {
		player.etat = new EtatPause();
	} 
	
}
