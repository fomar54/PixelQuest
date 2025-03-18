// Player.java 
/* 
 * Title : player class 
 * Author : Fatima 
 */
package PixelQuest;

import java.util.ArrayList;
import java.util.Random;
public class Player {
 Random healing = new Random();
 Random attacking = new Random();
 Random abilityUsed = new Random();
private  int strength = 34;
private ArrayList<Items> Inventory= new ArrayList<Items>();
	
 int health = 100;	

	
public void additem(Items item) {
	// PROCESSING 
	// adding another item in inventory 
	this.Inventory.add(item);
}

	public int  attack () {
		// PROCESSING 
		// attack is a variable that is assigned the resulting number after the random function is done 
		int attack  ;	
		// strength is already created int that is equal to 34 ]
		// random function would pick a number between 0-20
		attack = attacking.nextInt(strength);
		// OUTPUT 
		// returning variable  to main game 
		return attack;
	}
	
	public int heal() {
		//PROCESSING 
		// heal  is a variable that is assigned the resulting number after the random function is done
		int heal;
		// random function would pick a number between 0-23

		 heal = healing.nextInt(23);
		 //OUTPUT 
		// returning variable  to main game 
		return heal ;
	}
	
	public void strength(int strengthLvl) {
		//INPUT 
		//takes the parameter strength level found in game 
		//PROCESSING 
		// comparing if strength level is greater than 2 change  the strength of player to be greater
		if(strengthLvl > 2) {
			strength = 40;
			// same thing comparing but now greater than 9 
		}if (strengthLvl > 9) {
			strength = 45;
		}
		
		
	}
	public int  abilties (int ability ) {
		// PROCESSING 
		//parameter from main game indicating if player has ability
		// action int is at 0 
			int action = 0 ;
			// if player has ability from game  the ability should be 2 or 5 so comparing it greater than 1 would show if player has abilities 
			if (ability > 1) {
				action = abilityUsed.nextInt(4);	
			}
			//OUTPUT 
			// return 3		
		return action;
	}

	
	public ArrayList viewInventory() {
		// OUTPUT 
		// prints out inventory statement 
 
	System.out.println("Inventory: " + Inventory);
	return Inventory;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
