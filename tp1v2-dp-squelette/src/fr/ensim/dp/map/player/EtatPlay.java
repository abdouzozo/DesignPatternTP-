package fr.ensim.dp.map.player;

public class EtatPlay extends StateAdaptator {

	@Override
	public void passeStop(Player pl) {
		pl.etat = new EtatStop();
	} 

	@Override
	public void passePause(Player pl) {
		pl.etat = new EtatPause();
	} 
	
}
