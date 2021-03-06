
import java.util.ArrayList;
import ocsf.server.ConnectionToClient;

public class Game {

    public enum Status {

        ONGOING, TIE, PLAYER1_WIN, PLAYER2_WIN;
    }

    public enum Move {

        X, O;
    }
    private String name;
    public ConnectionToClient playerX, playerO;
    private final Move[][] grid;
    private ArrayList<Player> lurkers;
    private Status status;
    private Move currentMove;

    public Game() {
        name = "";
        playerX = null;
        playerO = null;
        status = Status.ONGOING;
        currentMove = Move.X;
        grid = new Move[3][3];
    }

    public boolean checkTurn(ConnectionToClient player) {
        if (player == playerX && currentMove == Move.X) {
            return true;
        } else if (player == playerX && currentMove == Move.O) {
            return false;
        } else if (player == playerO && currentMove == Move.X) {
            return false;
        } else if (player == playerO && currentMove == Move.O) {
            return true;
        }
        return true;
    }

    public boolean addPlayerX(ConnectionToClient player) {
        if (playerX == null) {
            playerX = player;
            return true;
        }
        else return false;        
    }

    public boolean addPlayerO(ConnectionToClient player) {
        if (playerO == null) {
            playerO = player;
            return true;
        }
        return false;
    }

    public boolean addLurker(Player player) {
        return lurkers.add(player);
    }

    public boolean removeLurker(Player player) {
        return lurkers.remove(player);
    }

    public Move getCell(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            return grid[row][col];
        } else {
            return null;
        }
    }

    public boolean setCell(int row, int col) {
        if (row < 3 && row >= 0 && col >= 0 && col < 3) {
            if (grid[row][col] == null) {
                grid[row][col] = (currentMove == Move.X) ? Move.X : Move.O;
                if (currentMove == Move.X) {
                    currentMove = Move.O;
                } else if (currentMove == Move.O) {
                    currentMove = Move.X;
                }
                updateStatus();
                return true;
            }
        }
        return false;
    }

    public boolean setName(String name) {
        if ("".equals(this.name)) {
            this.name = name;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void updateStatus() {
        status = checkWin();
        if (status == Status.ONGOING) {
            status = checkTie();
        }
    }

    public boolean checkPlayerXWin() {
        return (status == Status.PLAYER1_WIN) ? true : false;
    }

    public boolean checkPlayerOWin() {
        return (status == Status.PLAYER2_WIN) ? true : false;
    }

    public boolean checkDraw() {
        return (status == Status.TIE) ? true : false;
    }

    public Status checkWin() {
        if (grid[0][0] == grid[0][1] && grid[0][0] == grid[0][2] && grid[0][0] != null) // Horizontal 1
        {
            return (grid[0][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
        } else if (grid[1][0] == grid[1][1] && grid[1][0] == grid[1][2] && grid[1][0] != null) // Horizontal 2
        {
            return (grid[1][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
        } else if (grid[2][0] == grid[2][1] && grid[2][0] == grid[2][2] && grid[2][0] != null) // Horizontal 3
        {
            return (grid[2][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
        } else if (grid[0][0] == grid[1][0] && grid[0][0] == grid[2][0] && grid[0][0] != null) // Vertical 1
        {
            return (grid[0][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
        } else if (grid[0][1] == grid[1][1] && grid[0][1] == grid[2][1] && grid[0][1] != null) // Vertical 2
        {
            return (grid[0][1] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
        } else if (grid[0][2] == grid[1][2] && grid[0][2] == grid[2][2] && grid[0][2] != null) // Vertical 3
        {
            return (grid[0][2] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
        } else if (grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[0][0] != null) // Diagonal 1 
        {
            return (grid[0][0] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
        } else if (grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0] && grid[0][2] != null) // Diagonal 2 
        {
            return (grid[0][2] == Move.X) ? Status.PLAYER1_WIN : Status.PLAYER2_WIN;
        }
        return Status.ONGOING;
    }

    public Status checkTie() {
        if (grid[0][0] != null && grid[0][1] != null && grid[0][2] != null && grid[1][0] != null && grid[1][1] != null && grid[1][2] != null && grid[2][0] != null && grid[2][1] != null && grid[2][2] != null && status != Status.PLAYER1_WIN && status != Status.PLAYER1_WIN) {
            return Status.TIE;
        } else {
            return Status.ONGOING;
        }
    }
}
