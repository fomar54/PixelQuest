
//Game.java
/*
 * Title: PixelQuest game class
 * Author : Fatima
 * Date:  April 12 
 */


package PixelQuest;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	public String BLUE = "\u001B[34m";
	public String RESET = "\u001B[0m";
	public String GREEN = "\u001B[32m ";
	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);
	Scanner scanner4 = new Scanner(System.in);
	Scanner playermode = new Scanner(System.in);
	Scanner player2name = new Scanner(System.in);
	public int lvl = 1;
	public int strengthLvl = 0;
	public int coins = 0;
	public int abilityLevel = 0; 
	public String name ;
	public String name2;
	private Player player = new Player();
	private Player player2 = new Player();

	private Enemy enemy = new Enemy();

	private void setup() {
		// title page 
		System.out.println(  GREEN +"  _____ _          _    ____                  _   \n"
				+ " |  __ (_)        | |  / __ \\                | |  \n"
				+ " | |__) |__  _____| | | |  | |_   _  ___  ___| |_ \n"
				+ " |  ___/ \\ \\/ / _ \\ | | |  | | | | |/ _ \\/ __| __|\n"
				+ " | |   | |>  <  __/ | | |__| | |_| |  __/\\__ \\ |_ \n"
				+ " |_|   |_/_/\\_\\___|_|  \\___\\_\\\\__,_|\\___||___/\\__|\n"
				+ "                                                  \n"
				+ "                                                  \n"
				+ "" +
				 RESET);
		
		
		System.out.println("Enter any key to continue ");
	// scanner going next method 
		scanner.next();
	}
	
	private void intro() {
	
		int weapon;
	
	// INPUT  scanner input from user 
	System.out.println("What's your name ?");
	// scanner input is now processed as string variable name 
	name = scanner2.nextLine() ;
	// PROCESSING  assigning scanner input to string variable name 
	// printing out introduction for player 
	// OUTPUT  printing name out 
	System.out.println("Welcome " + name);
		System.out.println("Before you start your journey , you must chosse you first weapon ");
		System.out.println("Notice that each startor weapon does the same damage");
		// while loop for error check input 
	
		while (true) {
		System.out.println("\n [1] laser blaster  \n [2]  Plasma Sword   \n [3] Nanotech Riffle" );
		//weapon is assgined to the return value of intVaildtor 
		// PROCESSING  assigning scanner to int then comparing that to options here  while loop breaks 
		weapon = intVaildtor();
		// if user input is equal to 1 or 2 or 3 
		if (weapon == 1 || weapon == 2 || weapon == 3 ) {
			// break the loop if so
			break;
		
	}	else {
		// if not then print error line and continue loop until break 
		System.out.println("Invaild input. Try Again");
	
	}
		}
		// PROCESS if scanner input matches 1 then add new item to inventory arrayList 
		if(weapon == 1) {
			// accessing  player class to use method additem making a new item that will be in inventory 
			player.additem(new Items("Laser Blaster"));
		}
		if (weapon == 2) {
			// same thing different named item 
			player.additem(new Items("Plasma Sword"));
		}
		if (weapon == 3) {
			// same thing different name 
			player.additem(new Items("Nanotech Riffle"));
			
		}
		// use method view inventory in player's class 
		player.viewInventory();
		
	}
	
	
	private void run() {
		// INPUT would be scanner 
		// int variable that will be assigned to scanner input 
		int choice;
			while (true) {
				// printing out options 
			System.out.println(" 21233242354e");
			choice = intVaildtor();
			
			// PROCESSING IS COMPARING THAT TO OPTIONS HERE 
		if(   choice == 1  ||   choice ==2    ||  choice == 3 ) {
			break;
			} 
		else {
			System.out.println(" Invaild input. Try again");	
			}
		}
	
			// OUTPUT would be which method player would go to next
			// player go to next level 
			
	if(choice == 1) {
		// if the current level is 1 go to 1 
		if(lvl == 1) { 
		level1();
		// if the current level is 2 go to 2
		}if(lvl == 2) { 
			level2();
		}
		if (lvl==3) {
			level3();
		}
		
		if(lvl==4) {
			// ends game 
			System.out.println("YOU WON !!!");
			System.exit(0);
		}
		
		
	}
	// player go to store 
	if(choice == 2 ) {
	store();
		
	
	} 
	if (choice == 3) {
		playermode();
	}
	
		}
	
	 
	private void fight() {
		boolean fight = true;
		String fightD;
		// resetting player health and enemy health to 100 
		player.health = 100 ;
		enemy.health = 100;
		// while fight or player health is greater or equal to 100 loop the options 
		while (fight ||  player.health >= 100) {
			System.out.println("Level:" + this.lvl  + ""+"\n What would you like to do ? \n ATTACK \n HEAL \n RUN AWAY \n QUIT");
			// printing out inventory
			player.viewInventory();
			Scanner scanner3 = new Scanner(System.in);	
		System.out.println(  "Fight time " + name );	
		//error checking again while true scanner input will be compared to the options if it matches break loop 
		while (true) {
			// taking user input and converting to upper case before comparing 
		fightD	= scanner3.nextLine().toUpperCase();
		if(fightD.equals("ATTACK") || fightD.equals("HEAL") || fightD.equals("RUN AWAY") ||  fightD.equals("QUIT")) {
			
			break;
		}else {
			System.out.println("Invaild input try again");
		}
			}
		// if fight scanner input matches attack got to attack method   
		
		if(fightD.equals("ATTACK") ){
			attack();
			
		}
		// if fight scanner input matches heal go to heal method 
		
		if (fightD.equals("HEAL")) {
			heal();
			
		}
		// printing out health after action 
		System.out.println(  GREEN + " \n Player's health:" + player.health) ;
		System.out.println("Enemy's health:" + enemy.health + RESET);
		
		// if user pick run away print out statement then go to reset method to reset game to begining 
		if(fightD.equals("RUN AWAY")) {
			System.out.println("Running away you fell off a clif and died");
			reset();	
		}
		// if user quits go back to menu intro 
		if(fightD.equals("QUIT")) {
			System.out.println("Going back to menu");
			run();
		}
		
		//after each actions if player health or enemy health is less than 0 make fight boolean false 
		
		if (player.health < 0 || enemy.health < 0 ) {
			fight = false;
		}
	}	
		// if player health is greater than 0 and enemy health is less than 0 print out win statement and go to mennu again
		if (player.health >0 && enemy.health < 0 ) {
			System.out.println("You have won!! \n you have earned 5+ coins to spend on shop");
			System.out.println("Going back to options ");
			// updating level to increase by 1  
			lvl = (lvl + 1);
			// add 5 more coins after winning 
			coins = (coins + 5);
			// print out current coins 
			System.out.println("Coins currently:" + coins );
			// go back to menu 
			run();
		}
		// if the player health is at 0 then print death statement then reset game 
		if(player.health < 0){
			System.out.println("you have died sadly :(");
			reset();
		
		}	
		
		
	}
	 	
	
	 	
	
	private void playermode() {
		System.out.println("Second player name insert: ");
		 name2 = player2name.nextLine();
		 System.out.println("Welcome " + name2);
		boolean turn = true; 
		String decision  ;
		player.health = 100;
		player2.health = 100 ;
		 while (turn == true || player.health > 0) {
			 System.out.println("it's " + name + "turn ");
			 while (true) {
					// taking user input and converting to upper case before comparing 
				 decision	= playermode.nextLine().toUpperCase();
				if(decision.equals("ATTACK") || decision.equals("HEAL") || decision.equals("RUN AWAY") ||  decision.equals("QUIT")) {
					
					break;
				}else {
					System.out.println("Invaild input try again");
				}
					}
				// if fight scanner input matches attack got to attack method   
				
				if(decision.equals("ATTACK") ){
					player.attack();
					
				}
				// if fight scanner input matches heal go to heal method 
				
				if (decision.equals("HEAL")) {
					player.heal();
					
			 
			 
		 }
				break;	
		
		 }
		// printing out health after action 
			System.out.println(  GREEN + " \n Player's health:" + player.health) ;
			System.out.println("Enemy's health:" + player2.health + RESET);
			
			
		
		
	}
	
	
	public void store() {
	 	
	 	//INPUT SCANNER TAKES USER INPUT THEN COMPARES TO options here
	 		int store;
	 		// prints out coin balance 
	 		System.out.println("Welcome to the store  \n you currently have: " + coins + " coins");
	 		// if user has less than 5 coins return back to menu 
	 		if(coins < 5) {
	 			System.out.println("Sorry you dont have enough coins..");
	 			run();
	 		}
	 		// error checking agam 
	 		while (true) {
	 		System.out.println(" [1] UPDATE weapons [2] mystery weapon?");
	 		store = intVaildtor();
	 	 if(store == 1 || store == 2 ) {
	 		 // break when user matches input to options 
	 		  break;
	 	 }else {
	 		 System.out.println("Invaild input. Ty again");
	 	 }
	 		}
	 	 
	 	 if (store == 1) {
	 		 // add 5 to current strength level then make that the new strength level 
	 		strengthLvl = (strengthLvl + 5);
	 		// print out strength level 
	 		 System.out.println("Upgrading level \n Strength level now this:  " +  strengthLvl );
	 		 
	 	 }
	 	  if (store == 2) {
	 		  int mystery;
	 		  //error checking 
	 		while(true) {  
		 	 System.out.println("There are three options for mystery weapon \n [1] Fire Cannon \n [2] Freeze Ray");
		 	 System.out.println("Having a  one of these weapons will give you the *CHANCE to use a special");
	 		  mystery = intVaildtor();
	 		 if(mystery == 1 || mystery == 2 ) {
		 		  break;
		 	 }else {
		 		 System.out.println("Invaild input. Ty again");
		 	 }
	 		}
	 		  // if user picks first weapon then add new item to player arraylist
	 		  if (mystery == 1 ) {
	 		  
	 			player.additem(new Items("Fire Cannon ")); 
	 		// updates ability level to 2 
	 			abilityLevel =  2;
	 			// prints out inventory
	 			player.viewInventory();
	 			
	 	  }
	 		 if (mystery == 2 ) {
	 			 // same thing but different item and level becomes 5 
		 		  
		 			player.additem(new Items("Freeze Ray ")); 
		 			abilityLevel =  5;
		 			player.viewInventory();	
		 	  }	
	 			
	 	  }
	 	  // subtract 5 coins from current coin balance 
	 	 coins = coins - 5;
	 	 // go back to menu method 
	 	 System.out.println("Going back to menu ");
	 	 run();
	 	
	 	
	 	}
		
	private void level1() {
		// updates level to be at current 
		lvl = 1; 
		// prints out intro 
		System.out.println("Welcome to Pixel Quest storymode \n your adventure is to defeat three monsters to win the game \n sounds easy? \n  after each battle you will earn coins that you can spend on the store \n this is where you would upgrade you weapons to new ones ");
		// go to fight method 
		fight();
	}
	 
	private void level2() {
		// OUTPUT prints intro skips to fight method
		lvl = 2 ;
		// update level #
		// prints out intro 
		System.out.println("You have beaten your first battle congratulations  \n only gets harder from here \n the strength of your next enemy is greater ... \n good luck "  + name );
		// go to fight method 
		fight();
	}
	private void level3() {
		// OUTPUT prints intro skips to fight method
		lvl = 3 ;
		// update level #
		// prints out intro 
		System.out.println("You have beaten your second battle congratulations  \n only gets harder from here \n the strength of your next enemy is greater ... \n good luck "  + name );
		// go to fight method 
		fight();
	}
	
	private void attack() {	
		// PROCESSING attack to enemy damage to player any special abilities  player has 
		//OUTPUT  is health after attack 
		int damage ;
		int attack ;
		int ability ; 
		// make int values the return value of each method
		// parameters of level and ability level are used in a separate method in player class 
		ability = player.abilties(abilityLevel);
		player.strength(strengthLvl);
		enemy.strengthLevel(lvl);
		attack = player.attack();
		damage = enemy.attack();
		// if no damage to player print out statement
		 if (damage == 0 ) {
			 System.out.println( name + " dodged attack  ");
			 // if no attack to enemy print out statement 
		 }
		 if (attack == 0) {
			 	System.out.println(" enemy dodged attack  ");
		
		 }
		  // if ability level is greater than 0 indicating the user has weapon abilities 
		if (abilityLevel >0 ) {
			// if ability is 2 then ability used if not weapon not work 
	 if (ability == 2) {
		 System.out.println("Ability used! ");
		 // which weapon the user has is indicated in abilitylevel 
		 if (abilityLevel == 2) {
			 enemy.health = (enemy.health - attack - 5  );
			
			 System.out.println("Fire Cannon used enemy lost 5 more health ");
			 
		 } 
		 // if user has different weapon 
		 if (abilityLevel == 5) {
			System.out.println("Frezze Ray used, player's health is not damaged ");
		
		 }  
		 
	 }
	 // if ability isnt 2 then state weapon not work
      if (ability < 2) {
    	  // subtract damage and attack fromc curent healths 
    	  System.out.println("Weapon didn't work ");
    	 player.health = (player.health - damage );
		enemy.health = (enemy.health - attack);
			
      }

		}else {
			// if no ability # then continue with attack 
			 player.health = (player.health - damage );
			enemy.health = (enemy.health - attack);
				
		}
	
	}
	private void heal() {
		// PROCESSING  when assigning value to method return 
		// OUTPUT  new player health return to fight method 
		int health ;
		// health int is assigned to player class method heal return value 
		health = player.heal(); 
		// if the player's current health is at 100 then dont use heal 
		if (player.health == 100 ) {
			System.out.println("Can't use healing when health is already at 100%");
		} else {	
			// if not heal player
		player.health = (player.health + health);
		}
		// if player.health after is greater than 100 
		if (player.health> 100 ) {
			// subtract 5 in a loop until it is less than or equal to 100 
			while (player.health> 100 ) {
		  player.health = player.health - 5 ;
		  if (  player.health <= 100 ) {
			  break;
			  
		  		}
			
			}
			
		}
		
	}	
	private void reset() {
		//PROCESSING  player health enemy health 
		//OUTPUT  the methods 
		// makes player and enemy health 100 
		player.health = 100;
		enemy.health = 100;
		System.out.println("Reseting game...");
		// go to setup method then menu 
		setup();
		run();
	}
	
	// Code from teacher 
	public static int intVaildtor() {
		// scanner input if the input has a int value then break while loop by turning boolean on 
		Scanner input = new Scanner(System.in);
		 boolean numberEntered = false ; 

		// while loop
		while(numberEntered == false ) {
			System.out.println(" Enter option selected");
			if(input.hasNextInt()) {
				numberEntered = true;
			}else {// if input is string 
				System.out.println("Invaild Input. Enter number ");
				input.nextLine();
			}
			
		}
		int num = input.nextInt();
		return num;
		
	}	
	// code from teacher ends
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setup();
		game.run();

		game.intro();
	}

}
