package fr.ensim.dp.map.player;

public class EtatPause extends StateAdaptator {
	@Override
	public void stop(Player player) {
		player.etat = new EtatStop();
	} 
	
	@Override
	public void play(Player player) {
		player.etat = new EtatPlay();
	} 
}
