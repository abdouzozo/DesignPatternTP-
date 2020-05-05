package fr.ensim.dp.map.player;

public class EtatStop extends StateAdaptator {

	@Override
	public void backward(Player player) {
		player.etat = new EtatBackward();
	} 
	
	@Override
	public void play(Player player) {
		player.etat = new EtatPlay();
	} 
	
	@Override
	public void forward(Player player) {
		player.etat = new EtatForward();
	} 

}
