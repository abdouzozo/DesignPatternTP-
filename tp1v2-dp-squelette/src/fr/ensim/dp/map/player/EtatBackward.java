package fr.ensim.dp.map.player;

public class EtatBackward extends StateAdaptator {
	@Override
	public void passeStop(Player pl) {
		pl.etat = new EtatStop();
	} 
	
	@Override
	public void passeForward(Player pl) {
		pl.etat = new EtatForward();
	} 
}
