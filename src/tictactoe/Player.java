package tictactoe;

public class Player {

	private int wins;
	private String name;
	private int playerNumber;

	public Player (int wins, String name, int playerNumber){
		this.wins = wins;
		this.name = name;
		this.playerNumber = playerNumber;
	}
	
	public void setWins() {
		this.wins++;
	}
	
	public int getWins(){
		return this.wins;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPlayerNumber(){
		return this.playerNumber;	
	}

}
