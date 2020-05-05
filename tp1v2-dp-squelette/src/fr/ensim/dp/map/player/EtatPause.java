package fr.ensim.dp.map.player;

public class EtatPause extends StateAdaptator {
	@Override
	public void passeStop(Player pl) {
		pl.etat = new EtatStop();
	} 
	
	@Override
	public void passePlay(Player pl) {
		pl.etat = new EtatPlay();
	} 
}
