public class Worker {
	
	String name;
	int positionX;
	int positionY;
	int index;
	

	
	public Worker(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public Worker() {
		
	}
	
	public boolean placeWorker(int positionX, int positionY, SantoriniGame game, int index) {
		
		if ((positionX >= 0 && positionX < 5) && (positionY >= 0 && positionY < 5) && (game.getBoard()[positionX][positionY] == "")) {
			game.setWorker(index, positionX, positionY);
			return true;
		}	
		else {
			System.out.println("Sorry, the place you have chosen is occupied or out of borders\nTry again");
			return false;
		}	
	}
	
	public boolean move(int newPositionX, int newPositionY, SantoriniGame game, int index) {
		
		if((newPositionX >= 0 && newPositionX < 5) && (newPositionY >= 0 && newPositionY < 5)) {
			if (game.getBoard()[newPositionX][newPositionY].equals("") | game.getBoard()[newPositionX][newPositionY].equals("B")){
				

				if ((newPositionX == game.getWorker(index).positionX & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) |
					(newPositionX == game.getWorker(index).positionX + 1 & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) |
					(newPositionY == game.getWorker(index).positionY & (newPositionX == game.getWorker(index).positionX +1 | newPositionX == game.getWorker(index).positionX - 1)) | 
					(newPositionX == game.getWorker(index).positionX - 1 & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) ) {
				
					String currentPlace = game.getBoard()[game.getWorker(index).positionX][game.getWorker(index).positionY];
					if(currentPlace.equalsIgnoreCase("w11") || currentPlace.equalsIgnoreCase("w12") || currentPlace.equals("w21") || currentPlace.equals("w22")) {
						game.setBoard("", game.getWorker(index).positionX, game.getWorker(index).positionY);
					}	
					else if(currentPlace.equalsIgnoreCase("Bw11") || currentPlace.equalsIgnoreCase("Bw12") || currentPlace.equals("Bw21") || currentPlace.equals("Bw22")) {
						game.setBoard("B", game.getWorker(index).positionX, game.getWorker(index).positionY);
					}	
					else if(currentPlace.equalsIgnoreCase("BBw11") || currentPlace.equalsIgnoreCase("BBw12") || currentPlace.equals("BBw21") || currentPlace.equals("BBw22")) {
						game.setBoard("BB", game.getWorker(index).positionX, game.getWorker(index).positionY);
					}	
					else if(currentPlace.equalsIgnoreCase("BBBw11") || currentPlace.equalsIgnoreCase("BBBw12") || currentPlace.equals("BBBw21") || currentPlace.equals("BBBw22")) {
						game.setBoard("BB", game.getWorker(index).positionX, game.getWorker(index).positionY);
					}
					
					game.setWorker(index, newPositionX, newPositionY);
					
					return true;
				}
				else {
					System.out.println("Sorry, The new place is not adjacent to yours");
					return false;
				}
			
			}
			else if(game.getBoard()[newPositionX][newPositionY].equals("BB")) {
				if (game.getBoard()[game.getWorker(index).positionX][game.getWorker(index).positionY] != game.getWorker(index).name) {
					
					if (((newPositionX == game.getWorker(index).positionX & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) |
							(newPositionX == game.getWorker(index).positionX + 1 & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) |
							(newPositionY == game.getWorker(index).positionY & (newPositionX == game.getWorker(index).positionX +1 | newPositionX == game.getWorker(index).positionX - 1)) | 
							(newPositionX == game.getWorker(index).positionX - 1 & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) )) {
						
						String currentPlace = game.getBoard()[game.getWorker(index).positionX][game.getWorker(index).positionY];
						if(currentPlace.equalsIgnoreCase("w11") || currentPlace.equalsIgnoreCase("w12") || currentPlace.equals("w21") || currentPlace.equals("w22")) {
							game.setBoard("", game.getWorker(index).positionX, game.getWorker(index).positionY);
						}	
						else if(currentPlace.equalsIgnoreCase("Bw11") || currentPlace.equalsIgnoreCase("Bw12") || currentPlace.equals("Bw21") || currentPlace.equals("Bw22")) {
							game.setBoard("B", game.getWorker(index).positionX, game.getWorker(index).positionY);
						}	
						else if(currentPlace.equalsIgnoreCase("BBw11") || currentPlace.equalsIgnoreCase("BBw12") || currentPlace.equals("BBw21") || currentPlace.equals("BBw22")) {
							game.setBoard("BB", game.getWorker(index).positionX, game.getWorker(index).positionY);
						}	
						else if(currentPlace.equalsIgnoreCase("BBBw11") || currentPlace.equalsIgnoreCase("BBBw12") || currentPlace.equals("BBBw21") || currentPlace.equals("BBBw22")) {
							game.setBoard("BB", game.getWorker(index).positionX, game.getWorker(index).positionY);
						}
						
						game.setWorker(index, newPositionX, newPositionY);
						
							return true;
						}
					else {
						System.out.println("Sorry, The new place is not adjacent to yours :(");
						return false;
					}
				}
				else {
					System.out.println("Sorry, you can not go two levels or more up at once :(");
					return false;
				}
					
			}
			else if(game.getBoard()[newPositionX][newPositionY].equals("BBB")) {
				
				if (game.getBoard()[game.getWorker(index).positionX][game.getWorker(index).positionY] != game.getWorker(index).name |
					game.getBoard()[game.getWorker(index).positionX][game.getWorker(index).positionY] != "B" + game.getWorker(index).name) {
					
					if (((newPositionX == game.getWorker(index).positionX & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) |
							(newPositionX == game.getWorker(index).positionX + 1 & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) |
							(newPositionY == game.getWorker(index).positionY & (newPositionX == game.getWorker(index).positionX +1 | newPositionX == game.getWorker(index).positionX - 1)) | 
							(newPositionX == game.getWorker(index).positionX - 1 & (newPositionY == game.getWorker(index).positionY +1 | newPositionY == game.getWorker(index).positionY - 1)) )) {
							
						String currentPlace = game.getBoard()[game.getWorker(index).positionX][game.getWorker(index).positionY];
						if(currentPlace.equalsIgnoreCase("w11") || currentPlace.equalsIgnoreCase("w12") || currentPlace.equals("w21") || currentPlace.equals("w22")) {
							game.setBoard("", game.getWorker(index).positionX, game.getWorker(index).positionY);
						}	
						else if(currentPlace.equalsIgnoreCase("Bw11") || currentPlace.equalsIgnoreCase("Bw12") || currentPlace.equals("Bw21") || currentPlace.equals("Bw22")) {
							game.setBoard("B", game.getWorker(index).positionX, game.getWorker(index).positionY);
						}	
						else if(currentPlace.equalsIgnoreCase("BBw11") || currentPlace.equalsIgnoreCase("BBw12") || currentPlace.equals("BBw21") || currentPlace.equals("BBw22")) {
							game.setBoard("BB", game.getWorker(index).positionX, game.getWorker(index).positionY);
						}	
						else if(currentPlace.equalsIgnoreCase("BBBw11") || currentPlace.equalsIgnoreCase("BBBw12") || currentPlace.equals("BBBw21") || currentPlace.equals("BBBw22")) {
							game.setBoard("BB", game.getWorker(index).positionX, game.getWorker(index).positionY);
						}
						
						game.setWorker(index, newPositionX, newPositionY);
						
							return true;
						}
					else {
						System.out.println("Sorry, The new place is not adjacent to yours :(");
						return false;
					}
				}	
				else {
					System.out.println("Sorry, you can not go two levels or more up at once :(");
					return false;
				}
			}
			else {
				System.out.println("Sorry, you can not move to that place :(");
				return false;
				
				}
			}
		else {
			System.out.println("Sorry, the new place is out of the bounds :(");
			return false;
		}
	
	}
}
