import java.util.ArrayList;


public class Game {
	public enum Status {ONGOING, TIE, PLAYER1_WIN, PLAYER2_WIN;}
	public enum Move {X, O;}
	
	private String name;
	private Player playerX, playerO;
	private final Move [][]grid;
	private ArrayList<Player> lurkers; 
	private Status status;
	private Move currentMove;
		
	public Game (){
		name = "";
		playerX = null;
		playerO = null;
		status = Status.ONGOING;
		currentMove = Move.X;
		grid = new Move [3][3];
	}
	
	public Game (String name, Player playerX, Player playerO){
		this.name = name;
		this.playerX = playerX;
		this.playerO = playerO;
		currentMove = Move.X;
		status = Status.ONGOING;
		grid = new Move [3][3];
	}
	
	public boolean addPlayerX(Player player){
		if (playerX == null){
			playerX = player;
			return true;
		}else if (! playerX.isConnected()){
			playerX.connect();
			return true;
		}
		return false;
	}
	
	public boolean addPlayerO(Player player){
		if (playerO == null){
			playerO = player;
			return true;
		}else if (! playerO.isConnected()){
			playerO.connect();
			return true;
		}
		return false;
	}
	
	public boolean addLurker(Player player){
		return lurkers.add(player);
	}
	
	public boolean removeLurker(Player player){
		return lurkers.remove(player);
	}
	
	public Move getCell (int row, int col){
		if (row >= 0 && row < 3 && col >= 0 && col < 3)
			return grid[row][col];
		else
			return null;
	}
	
	public boolean setCell(int row, int col){
		if (row < 3 && row >= 0 && col >= 0 && col < 3){					
			if (grid[row][col] == null){
				grid[row][col] = (currentMove == Move.X) ? Move.X : Move.O;
				return true;
			}
		}
		return false;
	}
	
	public boolean setName (String name){
		if (this.name == ""){
			this.name = name;
			return true;
		}
		return false;
	}
	
	public String getName (){
		return name;
	}
	
	public Status getStatus(){
		status = checkWin();
		if (status == Status.ONGOING)
			status = checkTie();
		return status;
	}
	
	public Status checkWin(){
		if (grid[0][0] == grid[0][1] && grid[0][0] == grid[0][2] && grid[0][0] != null) // Horizontal 1
			return (grid[0][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
		else if (grid[1][0] == grid[1][1] && grid[1][0] == grid[1][2] && grid[1][0] != null) // Horizontal 2
			return (grid[1][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
		else if (grid[2][0] == grid[2][1] && grid[2][0] == grid[2][2] && grid[2][0] != null) // Horizontal 3
			return (grid[2][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
		else if (grid[0][0] == grid[1][0] && grid[0][0] == grid[2][0] && grid[0][0] != null) // Vertical 1
			return (grid[0][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
		else if (grid[0][1] == grid[1][1] && grid[0][1] == grid[2][1] && grid[0][1] != null) // Vertical 2
			return (grid[0][1] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
		else if (grid[0][2] == grid[1][2] && grid[0][2] == grid[2][2] && grid[0][2] != null) // Vertical 3
			return (grid[0][2] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
		else if (grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[0][0] != null) // Diagonal 1 
			return (grid[0][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
		else if (grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0] && grid[0][2] != null) // Diagonal 2 
			return (grid[0][2] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
		return Status.ONGOING;
	}
	
	public Status checkTie(){
		if (grid[0][0] == grid[0][1] || grid[0][1] == grid[0][2] || grid[0][0] == grid[0][2]){ // Horizontal 1
			if (grid[0][0] == null || grid[0][1] == null|| grid[0][2] == null){
				return Status.ONGOING;
			}
		}else if(grid[1][0] == grid[1][1] || grid[1][1] == grid[1][2] || grid[1][0] == grid[1][2]){ // Horizontal 2
			if (grid[1][0] == null || grid[1][1] == null || grid[1][2] == null){
				return Status.ONGOING;
			}
		}else if(grid[2][0] == grid[2][1] || grid[2][1] == grid[2][2] || grid[2][0] == grid[2][2]){ // Horizontal 3
			if (grid[2][0] == null || grid[2][1] == null || grid[2][2] == null){
				return Status.ONGOING;
			}
		}else if (grid[0][0] == grid[1][0] || grid[1][0] == grid[2][0] || grid[2][0] == grid[0][0]){ // Vertical 1 			
			if (grid[0][0] == null || grid[1][0] == null || grid[2][0] == null)
				return Status.ONGOING;
		}else if (grid[0][1] == grid[1][1] || grid[1][1] == grid[2][1] || grid[2][1] == grid[0][1]){ // Vertical 2 			
			if (grid[0][1] == null || grid[1][1] == null || grid[2][1] == null)
				return Status.ONGOING;
		}else if (grid[0][2] == grid[1][2] || grid[1][2] == grid[2][2] || grid[2][2] == grid[0][2]){ // Vertical 3 			
			if (grid[0][2] == null || grid[1][2] == null || grid[2][2] == null)
				return Status.ONGOING;
		}else if (grid[0][0] == grid[1][1] || grid[1][1] == grid[2][2] || grid[0][0] == grid[2][2]){ // Diagonal 1
			if (grid[0][0] == null || grid[1][1] == null || grid[2][2] == null)
				return Status.ONGOING;
		}else if (grid[2][0] == grid[1][1] || grid[1][1] == grid[0][2] || grid[2][0] == grid[0][2]){ // Diagonal 2
			if (grid[2][0] == null || grid[1][1] == null || grid[0][2] == null)
				return Status.ONGOING;
		}
		return Status.TIE;
	}
}

