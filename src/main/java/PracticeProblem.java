import java.util.Arrays;

public class PracticeProblem {
	public static void main(String args[]) {
		String[][] maze = {
			{"", "", "", "", ""},
			{"", "*", "", "", ""},
			{"", "*", "", "*", ""},
			{"S", "*", "", "", "F"},
		  };
		  System.out.println(searchMazeMoves(maze));
	}

	public static int searchMazeMoves(String[][] arr){
		int numMoves = 0;
		int row = arr.length - 1;
		int col = 0;
		return searchMazeMovesHelper(arr, row, col , numMoves);
	}
	
	public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves){
		
		if(row < 0 || row > arr.length-1 || col > arr[row].length-1 || col < 0){
			return -1;
		} 
		
		if(arr[row][col].equals("F")){
			return moves;
		}

		if(arr[row][col].equals("*")){
			return -1;
		}

		arr[row][col] = "*";
		int movesUp = searchMazeMovesHelper(arr, row-1, col, moves + 1);
		int movesRight = searchMazeMovesHelper(arr, row, col+1, moves + 1);
		int movesDown = searchMazeMovesHelper(arr, row+1, col, moves + 1);
		int movesLeft = searchMazeMovesHelper(arr, row, col-1, moves + 1);
		arr[row][col] = "";

		int[] movesArr = {movesUp, movesRight, movesDown, movesLeft};
		Arrays.sort(movesArr);

		int index = 0;
		for(int i = movesArr.length-1; i >= 0; i--){
			if(movesArr[i] != -1){
				index = i;
			}
			
		}

		return(movesArr[index]);
 
	}

}
