
public class SantoriniGame {

	/*
	 * Instance variables
	 */
	private String[][] board;
	private Worker[] workers = new Worker[4];

	/*
	 * A constructor that creates a game with default values
	 */
	public SantoriniGame() {
		board = new String[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = "";
			}
		}
		
		/*
		 * Initialize variables
		 */
		workers[0] = new Worker("w11", 0);
		workers[1] = new Worker("w12", 1);
		workers[2] = new Worker("w21", 2);
		workers[3] = new Worker("w22", 3);

	}
	/*
	 * returns the current status of the board
	 */
	public String toString() {
		
		String status = "";
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<5; j++) {
				status += "|";
				status += board[i][j];
				status += "\t";
			}
			status += "\n----------------------------------------\n";
			
		}
		return status;
	}
	
	/*
	 * A build method
	 * receives the location of the desired building place in addition to index number of the worker
	 */
	public boolean build (int positionX, int positionY, int workerNumber) {
		// checks that the inputs are within the bounds
		if ((positionX >= 0 & positionX <5) & (positionY >=0 & positionY < 5)) {
			
			// checks that the place is adjacent and does not have a dome
			if ((board[positionX][positionY].equals("") | board[positionX][positionY].equals("B") | board[positionX][positionY].equals("BB") | board[positionX][positionY].equals("BBB"))&
			((positionX == this.workers[workerNumber].positionX & (positionY == this.workers[workerNumber].positionY +1 | positionY == this.workers[workerNumber].positionY - 1)) |
			(positionX == this.workers[workerNumber].positionX + 1 & (positionY == this.workers[workerNumber].positionY +1 | positionY == this.workers[workerNumber].positionY - 1)) |
			(positionY == this.workers[workerNumber].positionY & (positionX == this.workers[workerNumber].positionX +1 | positionX == this.workers[workerNumber].positionX - 1)) | 
			(positionX == this.workers[workerNumber].positionX - 1 & (positionY == this.workers[workerNumber].positionY +1 | positionY == this.workers[workerNumber].positionY - 1)) ))
			{
				// The building action
				if (board[positionX][positionY].equals("BBB"))
				{
					board[positionX][positionY] = "BBBD";
					return true;
				}
				
				else
				{
					board[positionX][positionY] += "B";
					return true;
				}
			
			}
			else {
				System.out.println("Sorry, you cannot build in this place");
				return false;
			}
				
		}
		
		else {
			System.out.println("Sorry, you cannot build in this place");
			return false;
		}
			
	}
	
	/*
	 * checks whether one of the player's workers is above a three level building or not 
	 */
	public boolean hasWon(int workerNumber) {
		String cellName = "";
		switch(workerNumber) {
			case 0:
				cellName = "BBBw11";
				break;
			case 1:
				cellName = "BBBw12";
				break;
			case 2:
				cellName = "BBBw21";
				break;
			case 3:
				cellName = "BBBw22";
				break;
		}

			if (board[workers[workerNumber].positionY][workers[workerNumber].positionX].equals(cellName))
			{
				return true;
			}
			else
				return false;
	}

	/*
	 * checks if ALL adjacent cells have two or more level building
	 */
	public boolean isTrapped(int index) {
		
		// Corners test
		
		if((workers[index].positionX == 0 || workers[index].positionX == 4) && (workers[index].positionY == 0 || workers[index].positionY == 4)) {
				
			String a = null;
			int x = 0;
			int y = 0;
			if(workers[index].positionX == 0 && workers[index].positionY == 0) {
				x = 1;
				y = 1;
			}
			if(workers[index].positionX == 0 && workers[index].positionY == 4) {
				x = 1;
				y = -1;
			}
			if(workers[index].positionX == 4 && workers[index].positionY == 0) {
				x = -1;
				y = 1;
			}
			if(workers[index].positionX == 4 && workers[index].positionY == 4) {
				x = -1;
				y = -1;
			}
			if(index == 0)
				a = "w11";
			if(index == 1)
				a = "w12";
			if(index == 2)
				a = "w21";
			if(index == 3)
				a = "w22";
				
			if((board[workers[index].positionX][workers[index].positionY].equals(a))) {
				
				if(board[workers[index].positionX + x][workers[index].positionY] != "" && board[workers[index].positionX][workers[index].positionY + y] != "" &&
				board[workers[index].positionX + x][workers[index].positionY + y] != "" && board[workers[index].positionX + x][workers[index].positionY] != "B" &&
				board[workers[index].positionX][workers[index].positionY + y] != "B" && board[workers[index].positionX + x][workers[index].positionY + y] != "B") {
				
				
					
					return true;
				}else
					return false;
					
				}else {if((board[workers[index].positionX][workers[index].positionY].equals("B" + a))) {
					
				if(board[workers[index].positionX + x][workers[index].positionY] != "" && board[workers[index].positionX][workers[index].positionY + y] != "" &&
				board[workers[index].positionX + x][workers[index].positionY + y] != "" && board[workers[index].positionX + x][workers[index].positionY] != "B" &&
				board[workers[index].positionX][workers[index].positionY + y] != "B" && board[workers[index].positionX + x][workers[index].positionY + y] != "B" &&
				board[workers[index].positionX + x][workers[index].positionY] != "BB" && board[workers[index].positionX][workers[index].positionY + y] != "BB" &&
				board[workers[index].positionX + x][workers[index].positionY + y] != "BB") {
			
					return true;
				}else 
					return false;
				
				}else {if((board[workers[index].positionX][workers[index].positionY].equals("BB" + a))) {
					
				if(board[workers[index].positionX + x][workers[index].positionY] != "" && board[workers[index].positionX][workers[index].positionY + y] != "" &&
				board[workers[index].positionX + x][workers[index].positionY + y] != "" && board[workers[index].positionX + x][workers[index].positionY] != "B" &&
				board[workers[index].positionX][workers[index].positionY + y] != "B" && board[workers[index].positionX + x][workers[index].positionY + y] != "B" &&
				board[workers[index].positionX + x][workers[index].positionY] != "BB" && board[workers[index].positionX][workers[index].positionY + y] != "BB" &&
				board[workers[index].positionX + x][workers[index].positionY + y] != "BB" && board[workers[index].positionX + x][workers[index].positionY] != "BBB" &&
				board[workers[index].positionX][workers[index].positionY + y] != "BBB" && board[workers[index].positionX + x][workers[index].positionY + y] != "BBB") {
			
					return true;
				}else
					return false;
				}else
					return false;	
				}
			
			}
				
		} // Done
		else {
			// First row and last row
			if(workers[index].positionX == 0 || workers[index].positionX == 4) {
				
				if(workers[index].positionY == 1 || workers[index].positionY == 2 || workers[index].positionY == 3) {
					
				String a = null;
				int x = 0;
				
				if(workers[index].positionX == 0) 
					x = 1;
				if(workers[index].positionX == 4) 
					x = -1;
				
				if(index == 0)
					a = "w11";
				if(index == 1)
					a = "w12";
				if(index == 2)
					a = "w21";
				if(index == 3)
					a = "w22";
				
				if((board[workers[index].positionX][workers[index].positionY].equals(a))) {
					
				if(board[workers[index].positionX][workers[index].positionY - 1] != "" && board[workers[index].positionX + x][workers[index].positionY -1] != "" &&
				board[workers[index].positionX + x][workers[index].positionY ] != "" && board[workers[index].positionX + x][workers[index].positionY + 1] != "" &&
				board[workers[index].positionX][workers[index].positionY + 1] != "" && board[workers[index].positionX][workers[index].positionY - 1] != "B" &&
				board[workers[index].positionX + x][workers[index].positionY -1] != "B" && board[workers[index].positionX + x][workers[index].positionY ] != "B" &&
				board[workers[index].positionX + x][workers[index].positionY + 1] != "B" && board[workers[index].positionX][workers[index].positionY + 1] != "B") {
					
					return true;
				}else
					return false;
						
				}else {if((board[workers[index].positionX][workers[index].positionY].equals("B" + a))) {
					
				if(board[workers[index].positionX][workers[index].positionY - 1] != "" && board[workers[index].positionX + x][workers[index].positionY -1] != "" &&
				board[workers[index].positionX + x][workers[index].positionY ] != "" && board[workers[index].positionX + x][workers[index].positionY + 1] != "" &&
				board[workers[index].positionX][workers[index].positionY + 1] != "" && board[workers[index].positionX][workers[index].positionY - 1] != "B" &&
				board[workers[index].positionX + x][workers[index].positionY -1] != "B" && board[workers[index].positionX + x][workers[index].positionY ] != "B" &&
				board[workers[index].positionX + x][workers[index].positionY + 1] != "B" && board[workers[index].positionX][workers[index].positionY + 1] != "B" &&
				board[workers[index].positionX][workers[index].positionY - 1] != "BB" && board[workers[index].positionX + x][workers[index].positionY -1] != "BB" &&
				board[workers[index].positionX + x][workers[index].positionY ] != "BB" &&board[workers[index].positionX + x][workers[index].positionY + 1] != "BB" &&
				board[workers[index].positionX][workers[index].positionY + 1] != "BB") {
						
					return true;
				}else 
					return false;
					
				}else {if((board[workers[index].positionX][workers[index].positionY].equals("BB" + a))) {
						
				if(board[workers[index].positionX][workers[index].positionY - 1] != "" && board[workers[index].positionX + x][workers[index].positionY -1] != "" &&
				board[workers[index].positionX + x][workers[index].positionY ] != "" && board[workers[index].positionX + x][workers[index].positionY + 1] != "" &&
				board[workers[index].positionX][workers[index].positionY + 1] != "" && board[workers[index].positionX][workers[index].positionY - 1] != "B" &&
				board[workers[index].positionX + x][workers[index].positionY -1] != "B" && board[workers[index].positionX + x][workers[index].positionY ] != "B" &&
				board[workers[index].positionX + x][workers[index].positionY + 1] != "B" && board[workers[index].positionX][workers[index].positionY + 1] != "B" &&
				board[workers[index].positionX][workers[index].positionY - 1] != "BB" && board[workers[index].positionX + x][workers[index].positionY -1] != "BB" &&
				board[workers[index].positionX + x][workers[index].positionY ] != "BB" &&board[workers[index].positionX + x][workers[index].positionY + 1] != "BB" &&
				board[workers[index].positionX][workers[index].positionY + 1] != "BB" && board[workers[index].positionX][workers[index].positionY - 1] != "BBB" &&
				board[workers[index].positionX + x][workers[index].positionY -1] != "" &&board[workers[index].positionX + x][workers[index].positionY ] != "BBB" &&
				board[workers[index].positionX + x][workers[index].positionY + 1] != "BBB" && board[workers[index].positionX][workers[index].positionY + 1] != "BBB") {
							
					return true;
				}else
					return false;
				}else
					return false;	
				}
					
					
				}
					
				}
				
			}else {
				// First and last column
				if(workers[index].positionY == 0 || workers[index].positionY == 4) {
					
					if(workers[index].positionX == 1 || workers[index].positionX == 2 || workers[index].positionX == 3) {
						
					String a = null;
					int y = 0;
					
					if(workers[index].positionY == 0) 
						y = 1;
					if(workers[index].positionY == 4) 
						y = -1;
					
					if(index == 0)
						a = "w11";
					if(index == 1)
						a = "w12";
					if(index == 2)
						a = "w21";
					if(index == 3)
						a = "w22";
					
					if((board[workers[index].positionX][workers[index].positionY].equals(a))) {
						
					if(board[workers[index].positionX - 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY + y] != "" &&
					board[workers[index].positionX][workers[index].positionY + y] != "" && board[workers[index].positionX + 1][workers[index].positionY + y] != "" &&
					board[workers[index].positionX + 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY] != "B" &&
					board[workers[index].positionX - 1][workers[index].positionY + y] != "B" &&board[workers[index].positionX][workers[index].positionY + y] != "B" &&
					board[workers[index].positionX + 1][workers[index].positionY + y] != "B" && board[workers[index].positionX + 1][workers[index].positionY] != "B") {
						
						return true;
					}else
						return false;
							
					}else {if((board[workers[index].positionX][workers[index].positionY].equals("B" + a))) {
						
					if(board[workers[index].positionX - 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY + y] != "" &&
					board[workers[index].positionX][workers[index].positionY + y] != "" && board[workers[index].positionX + 1][workers[index].positionY + y] != "" &&
					board[workers[index].positionX + 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY] != "B" &&
					board[workers[index].positionX - 1][workers[index].positionY + y] != "B" &&board[workers[index].positionX][workers[index].positionY + y] != "B" &&
					board[workers[index].positionX + 1][workers[index].positionY + y] != "B" && board[workers[index].positionX + 1][workers[index].positionY] != "B" &&
					board[workers[index].positionX - 1][workers[index].positionY] != "BB" && board[workers[index].positionX - 1][workers[index].positionY + y] != "BB" &&
					board[workers[index].positionX][workers[index].positionY + y] != "BB" && board[workers[index].positionX + 1][workers[index].positionY + y] != "BB" &&
					board[workers[index].positionX + 1][workers[index].positionY] != "BB") {
							
						return true;
					}else 
						return false;
						
					}else {if((board[workers[index].positionX][workers[index].positionY].equals("BB" + a))) {
							
					if(board[workers[index].positionX - 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY + y] != "" &&
					board[workers[index].positionX][workers[index].positionY + y] != "" && board[workers[index].positionX + 1][workers[index].positionY + y] != "" &&
					board[workers[index].positionX + 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY] != "B" &&
					board[workers[index].positionX - 1][workers[index].positionY + y] != "B" &&board[workers[index].positionX][workers[index].positionY + y] != "B" &&
					board[workers[index].positionX + 1][workers[index].positionY + y] != "B" && board[workers[index].positionX + 1][workers[index].positionY] != "B" &&
					board[workers[index].positionX - 1][workers[index].positionY] != "BB" && board[workers[index].positionX - 1][workers[index].positionY + y] != "BB" &&
					board[workers[index].positionX][workers[index].positionY + y] != "BB" && board[workers[index].positionX + 1][workers[index].positionY + y] != "BB" &&
					board[workers[index].positionX + 1][workers[index].positionY] != "BB" && board[workers[index].positionX - 1][workers[index].positionY] != "BBB" &&
					board[workers[index].positionX - 1][workers[index].positionY + y] != "BBB" &&board[workers[index].positionX][workers[index].positionY + y] != "BBB" &&
					board[workers[index].positionX + 1][workers[index].positionY + y] != "BBB" &&
					board[workers[index].positionX + 1][workers[index].positionY] != "BBB" ) {
								
						return true;
					}else
						return false;
					}else
						return false;	
					}
						
						
					}
						
					}
					
				}else {
					// remaining cells
					if((workers[index].positionX == 1 || workers[index].positionX == 2 || workers[index].positionX == 3) &&
					(workers[index].positionY == 1 || workers[index].positionY == 2 || workers[index].positionY == 3)) {
						
						String a = null;
						if(index == 0)
							a = "w11";
						if(index == 1)
							a = "w12";
						if(index == 2)
							a = "w21";
						if(index == 3)
							a = "w22";
						
						if((board[workers[index].positionX][workers[index].positionY].equals(a))) {
							
						if(board[workers[index].positionX - 1][workers[index].positionY - 1] != "" && board[workers[index].positionX][workers[index].positionY - 1] != "" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "" && board[workers[index].positionX - 1][workers[index].positionY] != "" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "" &&
						board[workers[index].positionX - 1][workers[index].positionY - 1] != "B" && board[workers[index].positionX][workers[index].positionY - 1] != "B" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "B" && board[workers[index].positionX - 1][workers[index].positionY] != "B" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "B" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "B" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "B" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "B") {
							
							return true;
						}else
							return false;
								
						}else {if((board[workers[index].positionX][workers[index].positionY].equals("B" + a))) {
							
						if(board[workers[index].positionX - 1][workers[index].positionY - 1] != "" && board[workers[index].positionX][workers[index].positionY - 1] != "" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "" && board[workers[index].positionX - 1][workers[index].positionY] != "" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "" &&
						board[workers[index].positionX - 1][workers[index].positionY - 1] != "B" && board[workers[index].positionX][workers[index].positionY - 1] != "B" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "B" && board[workers[index].positionX - 1][workers[index].positionY] != "B" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "B" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "B" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "B" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "B" &&
						board[workers[index].positionX - 1][workers[index].positionY - 1] != "BB" && board[workers[index].positionX][workers[index].positionY - 1] != "BB" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "BB" && board[workers[index].positionX - 1][workers[index].positionY] != "BB" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "BB" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "BB" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "BB" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "BB") {
								
							return true;
						}else 
							return false;
							
						}else {if((board[workers[index].positionX][workers[index].positionY].equals("BB" + a))) {
								
						if(board[workers[index].positionX - 1][workers[index].positionY - 1] != "" && board[workers[index].positionX][workers[index].positionY - 1] != "" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "" && board[workers[index].positionX - 1][workers[index].positionY] != "" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "" &&
						board[workers[index].positionX - 1][workers[index].positionY - 1] != "B" && board[workers[index].positionX][workers[index].positionY - 1] != "B" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "B" && board[workers[index].positionX - 1][workers[index].positionY] != "B" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "B" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "B" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "B" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "B" &&
						board[workers[index].positionX - 1][workers[index].positionY - 1] != "BB" && board[workers[index].positionX][workers[index].positionY - 1] != "BB" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "BB" && board[workers[index].positionX - 1][workers[index].positionY] != "BB" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "BB" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "BB" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "BB" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "BB" &&
						board[workers[index].positionX - 1][workers[index].positionY - 1] != "BBB" && board[workers[index].positionX][workers[index].positionY - 1] != "BBB" &&
						board[workers[index].positionX + 1][workers[index].positionY - 1] != "BBB" && board[workers[index].positionX - 1][workers[index].positionY] != "BBB" &&
						board[workers[index].positionX + 1][workers[index].positionY] != "BBB" && board[workers[index].positionX - 1][workers[index].positionY + 1] != "BBB" &&
						board[workers[index].positionX][workers[index].positionY + 1] != "BBB" &&board[workers[index].positionX + 1][workers[index].positionY + 1] != "BBB") {
									
							return true;
						}else
							return false;
						}else
							return false;	
						}
							
							
						}
						
					}
				}
			}
			
		}
		return false;
			
	}
	
	/*
	 * resets the game to default values
	 */
	public void reset() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				board[i][j] = "";
			}
		}
	}
	
	/*
	 * get an exact deep copy of the board
	 */
	public String[][] getBoard() {
		String [][] newBoard = new String[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}
	
	/*
	 * change the board
	 */
	public void setBoard(String s, int positionX, int positionY) {
		board[positionX][positionY] = s;
	}
	
	/*
	 * get an exact deep copy of the worker array
	 */
	public Worker getWorker(int index) {
		Worker copy = new Worker(workers[index].name, index);
		copy.positionX = workers[index].positionX;
		copy.positionY = workers[index].positionY;

		return copy;	
	}
	
	/*
	 * set the worker position
	 */
	public void setWorker(int index, int positionX, int positionY) {
		workers[index].positionX = positionX;
		workers[index].positionY = positionY;

		board[positionX][positionY] += workers[index].name;
		
	}
}
	