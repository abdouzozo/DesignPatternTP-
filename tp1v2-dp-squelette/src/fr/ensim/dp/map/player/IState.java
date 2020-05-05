package fr.ensim.dp.map.player;

public interface IState {
	
	public void passePlay(Player o);
	public void passePause(Player o);
	public void passeStop(Player o);
	public void passeBackward(Player o);
	public void passeForward(Player o);

}
