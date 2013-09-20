package awesome;

import java.util.ArrayList;

/**
 * This represents a connectfour board.
 * @author Kristof Bruyninckx
 * @author Pieter Verlinden
 *
 */

public class ConnectFourBoard {
	
	private final static int BOARD_WIDTH = 7;
	private final static int BOARD_HEIGHT = 6;
	
	char[][] board = new char[BOARD_HEIGHT][BOARD_WIDTH];
	private final char player;
	private boolean winningBoard = false;
	
	public ConnectFourBoard(ConnectFourBoard start, char player){
		board = start.getBoard();
		this.player = start.getPlayer();
		setWinningBoard(start.isWinningBoard());
		
	}

	public ConnectFourBoard(char player){
		initializeBoard();
		this.player = player;
	}
	
	private void initializeBoard(){
		for (int i=0; i<BOARD_HEIGHT;i++){
			for (int j=0; j<BOARD_WIDTH;j++){
				board[i][j] = 'e';
			}
		}
	}
	
	public char[][] getBoard() {
		return board;
	}
	

	/**
	 * @return the winningBoard
	 */
	public boolean isWinningBoard() {
		return winningBoard;
	}

	/**
	 * @param winningBoard the winningBoard to set
	 */
	public void setWinningBoard(boolean winningBoard) {
		this.winningBoard = winningBoard;
	}

	
	/**
	 * @return the player
	 */
	public char getPlayer() {
		return player;
	}

	public Iterable<ConnectFourBoard> getNeighbouringBoards(){
		ArrayList<ConnectFourBoard> neighbours = new ArrayList<ConnectFourBoard>();
		for (int i=0; i<BOARD_WIDTH; i++){
			ConnectFourBoard neighbourBoard;
			neighbourBoard = GetNeighbour(i);
			if(neighbourBoard != null){
				neighbours.add(neighbourBoard);
			}
		}
		return neighbours;
	}

	private ConnectFourBoard GetNeighbour(int i) {
		ConnectFourBoard newBoard = new ConnectFourBoard(this,swap(getPlayer()));
		if(newBoard.getBoard()[BOARD_HEIGHT - 1][i] != 'e'){
			return null;
		}
		for(int y = 0; y < BOARD_HEIGHT; y++){
			if(newBoard.getBoard()[y][i] == 'e'){
				newBoard.getBoard()[y][i] = getPlayer();
				newBoard.checkWinner(); // if there is a winner change the winningboard boolean to true.
				return newBoard;
			}
		}
		return null;
		
	}
	
	private char swap(char player) {
		if(player == 'r'){
			return 'y';
		}else{
			return 'r';
		}
	}

	private void checkWinner(){
		
	}
	
}
