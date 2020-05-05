package fr.ensim.dp.map.player;

public class StateAdaptator implements IState{
	
	private String strState;
	
	public String getStrState() {
		return strState;
	}

	public void setStrState(String strState) {
		this.strState = strState;
	}

	@Override
	public void play(Player player) {
		strState="play";
		throw new IllegalStateException();
	}

	@Override
	public void pause(Player player) {
		strState="pause";
		throw new IllegalStateException();		
	}

	@Override
	public void stop(Player player) {
		strState="stop";
		throw new IllegalStateException();
		
	}

	@Override
	public void backward(Player player) {
		strState="backward";
		throw new IllegalStateException();
		
	}

	@Override
	public void forward(Player player) {
		strState="forward";
		throw new IllegalStateException();
		
	}

}
