import java.util.Scanner;

public class OddMagicSquare {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // Scanner for user input
		System.out.println("Enter an odd number");
		int n = input.nextInt();
		while (n % 2 == 0) { // Allow only odd numbers
			System.out.println("Enter an odd number");
			n = input.nextInt();
		}
		int[][] magicSquare = new int[n][n];

		int number = 1;// number that will be filled in square
		int row = 0; // start from first row
		int col = n / 2; // mid element

		while (number <= n * n) { // square contains n*n numbers
			magicSquare[row][col] = number;
			number++;

			int tempCol = (col + 1) % n; // inc col and if it reaches last start
											// from 0
			int tempRow = (row - 1); // inc row and if it reaches last start
										// from n-1
			if (tempRow < 0)
				tempRow = n - 1;

			if (magicSquare[tempRow][tempCol] != 0) { // if cell is not empty
				row = (row + 1) % n; // move to next row
			} else {
				row = tempRow;
				col = tempCol;
			}

		}
		// print the magic square
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(magicSquare[i][j] + " ");
			}
			System.out.println();
		}
	}

}
