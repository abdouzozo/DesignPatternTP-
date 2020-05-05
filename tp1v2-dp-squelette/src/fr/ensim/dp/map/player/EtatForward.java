package fr.ensim.dp.map.player;

public class EtatForward extends StateAdaptator {
	@Override
	public void passeStop(Player pl) {
		pl.etat = new EtatStop();
	} 
	
	@Override
	public void passeBackward(Player pl) {
		pl.etat = new EtatBackward();
	} 
}
