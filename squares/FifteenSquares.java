package squares;

public class FifteenSquares {
	// Multi dimensional Array method
	int [] [] arrayNums = new int [4] [4];
	// Declaring a 2D array that that creates a new object int he form of a 4x4 array
	
	static int i, j;
	// Declaring a static int
	
	public void display() {	
		int count = 0;
		// incremental variable to count the increments as our indexes increase
		
		for (int i = 0; i < 4; i++){
		// loops i through the first dimension of the array on the grid	
			for (int j = 0; j < 4; j++){
			// loops j through the second dimension of the array on the grid	
				arrayNums[i][j] = count;
				// counts each time the array moves 
				System.out.println(arrayNums[i][j] + " ");
				// prints out our grid (blank)
				count++;
				// increments the count each time our array moves
			}
			System.out.println(" ");
		}
	}
	
//	public static void main(String[] args) {
//		FifteenSquares puzzle = new FifteenSquares
//	};
//	
//	puzzle.display();

}
	