import java.util.*;
import java.io.*;

public class Santorini {

	public static void main (String[] args) throws FileNotFoundException {
		SantoriniGame game = new SantoriniGame();
		Worker w = new Worker();
		FileInputStream inStream = new FileInputStream("input.txt");
		Scanner sc = null;
		
		boolean input = true;
		boolean condition1 = true;
		boolean condition2 = true;
		if(input) 
			sc = new Scanner(inStream);
		else
			sc = new Scanner(System.in);
		
		System.out.println("################# Santorini #####################");
		//System.out.println("\nPlayer 1: Please enter your name");
		String name1 = sc.nextLine();
		//System.out.println("\nPlayer 2: Please enter your name");
		String name2 = sc.nextLine();
		System.out.println("## PRESS R ANY TIME YOU WANT TO RESTART THE GAME ##");
		while(condition1) {
			
			String worker = null;
			int x = 0;
			int y = 0;
			int index = 0;
			
			while(condition1) {
				//System.out.println(name1 + ": Enter the worker you want to move (## PRESS R TO RESTART THE GAME ##)");
				worker = sc.next();
				
				if(worker.equalsIgnoreCase("r")) {
					game.reset();
					break;
				}
				
				if(worker.equalsIgnoreCase("w11")) 
					index = 0;
				else if(worker.equalsIgnoreCase("w12")) 
						index = 1;
					else {
						System.out.println("Sorry, your input is invalid\nTry again");
						continue;
					}
				
				//System.out.println(name1 + ": place your worker by entering the Y position");
				x = sc.nextInt();
				//System.out.println("Now X position");
				y = sc.nextInt();
				if(w.placeWorker(x, y, game, index)) {
					sc.nextLine();
					break;
				}
				else
					continue;
			}
			
			if(worker.equalsIgnoreCase("r"))
				continue;
			
			while(condition1) {
				//System.out.println(name1 + ": Enter the other worker you want to move (## PRESS R TO RESTART THE GAME ##)");
				worker = sc.next();
				
				if(worker.equalsIgnoreCase("r")) {
					game.reset();
					break;
				}
				
				if((worker.equalsIgnoreCase("w11")) && (index == 1)) 
					index = 0;
				else if((worker.equalsIgnoreCase("w12")) && (index == 0)) 
						index = 1;
					else {
						System.out.println("Sorry, your input is invalid\nTry again");
						continue;
					}
				
				//System.out.println(name1 + ": place your worker by entering the Y position");
				x = sc.nextInt();
				//System.out.println("Now X position");
				y = sc.nextInt();
				if(w.placeWorker(x, y, game, index)) {
					sc.nextLine();
					break;
				}
				else
					continue;
			}
			
			if(worker.equalsIgnoreCase("r"))
				continue;
			
			while(condition1) {
				//System.out.println(name2 + ": Enter the worker you want to move (## PRESS R TO RESTART THE GAME ##)");
				worker = sc.next();

				if(worker.equalsIgnoreCase("r")) {
					game.reset();
					break;
				}
				
				if(worker.equalsIgnoreCase("w21")) 
					index = 2;
				else if(worker.equalsIgnoreCase("w22")) 
						index = 3;
					else {
						System.out.println("Sorry, your input is invalid\nTry again");
						continue;
					}
				
				//System.out.println(name2 + ": place your worker by entering the Y position");
				x = sc.nextInt();
				//System.out.println("Now X position");
				y = sc.nextInt();
				if(w.placeWorker(x, y, game, index)) {
					sc.nextLine();
					break;
				}
				else
					continue;
			}
			
			if(worker.equalsIgnoreCase("r"))
				continue;
			
			while(condition1) {
				//System.out.println(name2 + ": Enter the other worker you want to move (## PRESS R TO RESTART THE GAME ##)");
				worker = sc.next();

				if(worker.equalsIgnoreCase("r")) {
					game.reset();
					break;
				}
				
				if((worker.equalsIgnoreCase("w21")) && (index == 3)) 
					index = 2;
				else if((worker.equalsIgnoreCase("w22")) && (index == 2)) 
						index = 3;
					else {
						System.out.println("Sorry, your input is invalid\nTry again");
						continue;
					}
						
				
				//System.out.println(name2 + ": place your worker by entering the Y position");
				x = sc.nextInt();
				//System.out.println("Now X position");
				y = sc.nextInt();
				if(w.placeWorker(x, y, game, index)) {
					sc.nextLine();
					break;
				}
				else
					continue;
			}
			
			if(worker.equalsIgnoreCase("r"))
				continue;
			
			System.out.println("\nPlayer 1: " + name1 + "\n" +"Player 2: " + name2);
	
			System.out.println("Placing the workers::");
			System.out.println(game);
			
			while (condition2) {
				
				int moveY = 0;
				int moveX = 0;
				int buildY = 0;
				int buildX = 0;
				
				while (condition2) {
					//System.out.println(name1 +" enter the worker you want to move (## PRESS R TO RESTART THE GAME ##)");
					worker = sc.next();
					
					if(worker.equalsIgnoreCase("r")) {
						game.reset();
						break;
					}
					
					index = determineIndex(worker);
					//System.out.println("Enter the Y position");
					moveY = sc.nextInt();
					//System.out.println("Enter the X position");
					moveX = sc.nextInt();
					System.out.println("The turn is now for player: " + name1 + "\nMoving worker: " + worker + " to " + moveY + " " + moveX);
					sc.nextLine();
					if(w.move(moveY, moveX, game, index)) 
						break;
				}
				
				if(worker.equalsIgnoreCase("r"))
					break;
				
				System.out.println(game);
				
				if (game.hasWon(0) | game.hasWon(1)) {
					System.out.println("Congratulations " + name1 + ", you won the game.");
					break;
				}
				if (game.hasWon(2) | game.hasWon(3)) {
					System.out.println("Congratulations " + name2 + ", you won the game.");
					break;
				}
				
				while (condition2) {
					//System.out.println("Enter the Y position then the X position to build");
					buildY = sc.nextInt();
					buildX = sc.nextInt();
					sc.nextLine();
					if(game.build(buildY, buildX, index))
						break;
				}
				
				System.out.println("Building at position "+ buildY + ", " + buildX);
				System.out.println(game);
				
				while (condition2) {
					//System.out.println(name2 + "enter the worker you want to move (## PRESS R TO RESTART THE GAME ##)");
					worker = sc.next();
					
					if(worker.equalsIgnoreCase("r")) {
						game.reset();
						break;
					}
					
					index = determineIndex(worker);
					//System.out.println("Enter the Y position");
					moveY = sc.nextInt();
					//System.out.println("Enter the X position");
					moveX = sc.nextInt();
					System.out.println("The turn is now for player: " + name2 + "\nMoving worker: " + worker + " to " + moveY + " " + moveX);
					sc.nextLine();
					if(w.move(moveY, moveX, game, index)) 
						break;
				}
				
				if(worker.equalsIgnoreCase("r"))
					break;
				
				System.out.println(game);
				
				if (game.hasWon(0) | game.hasWon(1)) {
					System.out.println("Congratulations " + name1 + ", you won the game.");
					break;
				}
				if (game.hasWon(2) | game.hasWon(3)) {
					System.out.println("Congratulations " + name2 + ", you won the game.");
					break;
				}
				
				while (condition2) {
					//System.out.println("Enter the Y position then the X position to build");
					buildY = sc.nextInt();
					buildX = sc.nextInt();
					sc.nextLine();
					if(game.build(buildY, buildX, index))
						break;
				}
				
				if(game.hasWon(0) | game.hasWon(1) | game.hasWon(2) | game.hasWon(3) | game.isTrapped(0) && game.isTrapped(1) | game.isTrapped(2) && game.isTrapped(3))
					condition2 = false;
				
				
				System.out.println("Building at position "+ buildY + ", " + buildX);
				System.out.println(game);
				
				if (game.isTrapped(0) & game.isTrapped(1)) {
					System.out.println("Sorry the player " + name1 + " is trapped." + "\n" + "Congratulations: " + name2 + ", you won the game.");
					break;
				}
				if (game.isTrapped(2) & game.isTrapped(3)) {
					System.out.println("Sorry the player " + name2 + " is trapped." + "\n" + "Congratulations: " + name1 + ", you won the game.");
					break;
				}
			
			}
			
			if(worker.equalsIgnoreCase("r"))
				continue;
			
			break;
			
		}
		
		sc.close();
	}
	
	public static int determineIndex(String worker) {
		
		int index = -1;
		switch(worker) {
		
			case "w11":
				index = 0;
				break;
				
			case "w12":
				index = 1;
				break;
			case "w21":
				index = 2;
				break;
			case "w22":
				index = 3;
				break;
		}
		return index;
	}
}
