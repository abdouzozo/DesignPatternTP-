package fr.ensim.dp.map.player;

public class EtatForward extends StateAdaptator {
	@Override
	public void stop(Player player) {
		player.etat = new EtatStop();
	} 
	
	@Override
	public void backward(Player player) {
		player.etat = new EtatBackward();
	} 
}
