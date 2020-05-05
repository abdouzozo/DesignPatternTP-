package fr.ensim.dp.map.player;

public class EtatStop extends StateAdaptator {

	@Override
	public void passeBackward(Player pl) {
		pl.etat = new EtatBackward();
	} 
	
	@Override
	public void passePlay(Player pl) {
		pl.etat = new EtatPlay();
	} 
	
	@Override
	public void passeForward(Player pl) {
		pl.etat = new EtatForward();
	} 

}
