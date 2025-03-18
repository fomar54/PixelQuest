


package PixelQuest;

import java.util.Random;

public class Enemy {
Random rand = new Random ();
public int health = 100;
public int strength = 23;
	
	
	public int attack() {
		// PROCESSING when method is called it will start a random function picking a number 0- current strength max 
		int weaponDamage  ;
	
			weaponDamage = rand.nextInt(strength);
			// return that to game 
		   return weaponDamage;
	}

	public void strengthLevel(int lvl) {
		// INPUT 
		// if parameter level is current at 2 
		// PROCESSING 
		if (lvl == 2) {
			// increase strength max of enemy
			strength = 27;
		}
		
	}
	
	public static void main(String[] args) {

	}

}
