package fr.ensim.dp.map.player;

public class StateAdaptator implements IState{
	@Override
	public void passePlay(Player o) {
		throw new IllegalStateException();
	}

	@Override
	public void passePause(Player o) {
		throw new IllegalStateException();		
	}

	@Override
	public void passeStop(Player o) {
		throw new IllegalStateException();
		
	}

	@Override
	public void passeBackward(Player o) {
		throw new IllegalStateException();
		
	}

	@Override
	public void passeForward(Player o) {
		// TODO Auto-generated method stub
		
	}

}
