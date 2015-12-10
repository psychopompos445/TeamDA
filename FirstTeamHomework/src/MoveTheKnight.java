import java.util.Scanner;

public class MoveTheKnight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the board's dimensions: ");
		int m = sc.nextInt();
		int n = sc.nextInt();
		ChessBoard cb1 = new ChessBoard();
		cb1.totalRows = m;
		cb1.totalCols = n;
		cb1.board = new char[m][n];
		System.out.print("Please place the knight: ");
		cb1.row = sc.nextInt();
		cb1.col = sc.nextInt();
		sc.close();
		cb1.moveKnight(cb1.row, cb1.col);
		cb1.printBoard();
	}

}
