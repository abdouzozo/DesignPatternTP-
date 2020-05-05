package fr.ensim.dp.map.player;

public interface IState {
	
	public void play(Player player);
	public void pause(Player player);
	public void stop(Player player);
	public void backward(Player player);
	public void forward(Player player);

}
