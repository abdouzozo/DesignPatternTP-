package fr.ensim.dp.map.player;

public class Player {

	public IState etat;

	public Player() {
		etat = new EtatStop();
	}

	public void play() {
		etat.passePlay(this);
	}

	public void pause() {
		etat.passePause(this);
	}
	
	public void stop() {
		etat.passeStop(this);
	}
	
	public void backward() {
		etat.passeBackward(this);
	}
	
	public void forward() {
		etat.passeForward(this);
	}
}