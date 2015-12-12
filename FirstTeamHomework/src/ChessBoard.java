
public class ChessBoard {
	private int totalRows;
	private int totalCols;
	private char[][] board;
	
	ChessBoard(int rowCount, int colCount) {
		totalRows = rowCount;
		totalCols = colCount;
		board = new char[rowCount][colCount];
	}

	void knightMove(int row, int col) {
		board[row][col] = 'k';
		if (row+2<totalRows && col+1<totalCols && board[row+2][col+1] != 'k') {

			knightMove(row+2, col+1);
		} else if (row+2<totalRows && col-1>=0 && board[row+2][col-1] != 'k') {

			knightMove(row+2, col-1);
		} else if (row+1<totalRows && col+2<totalCols && board[row+1][col+2] != 'k') {
			;
			knightMove(row+1, col+2);
		} else if (row+1<totalRows && col-2>=0 && board[row+1][col-2] != 'k') {

			knightMove(row+1, col-2);
		} else if (row-2>=0 && col-1>=0 && board[row-2][col-1] != 'k') {

			knightMove(row-2, col-1);
		} else if (row-2>=0 && col+1<totalCols && board[row-2][col+1] != 'k') {


		} else if (row-1>=0 && col-2>=0 && board[row-1][col-2] != 'k') {

			knightMove(row-1, col-2);
		} else if (row-1>=0 && col+2<totalCols && board[row-1][col+2] != 'k') {

			knightMove(row-1, col+2);
		}
		else {
			return;
		}
	}
	void moveKnight(int row, int col) {
		
		
		if (row<0 || row> board.length-1) {
			return;
		}
		if (col<0 || col > board[0].length-1) {
			return;
		}
		if (board[row][col] == 'k') {
			return;
		}
		board[row][col]='k';
		moveKnight(row-2,col-1);
		moveKnight(row-2,col+1);
		moveKnight(row-1,col-2);
		moveKnight(row-1,col+2);
		moveKnight(row+1,col-2);
		moveKnight(row+1,col+2);
		moveKnight(row+2,col-1);
		moveKnight(row+2,col+1);
	}
	void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 'k') {
					board[i][j]='0';
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print("|"+board[i][j]+"|");
			}
			System.out.println();
		}
	}

}
