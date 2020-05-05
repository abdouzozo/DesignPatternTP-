package fr.ensim.dp.map.player;

public class Player {

	public StateAdaptator etat;

	public Player() {
		etat = new EtatStop();
		etat.setStrState("stop");
	}

	public void play() {
		etat.play(this);
	}

	public void pause() {
		etat.pause(this);
	}
	
	public void stop() {
		etat.stop(this);
	}
	
	public void backward() {
		etat.backward(this);
	}
	
	public void forward() {
		etat.forward(this);
	}
}