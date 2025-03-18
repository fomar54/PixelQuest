package PixelQuest;

public class Items {
	private String itemName;
	
	public Items(String name ) {
		//PROCESSING 
		this.itemName = name;	
	
		// assigns the parameter as a item
	}

	public String toString() {
		//OUTPUT 
		// prints variable as itemName
		return this.itemName;
	
	}
	
	public static void main(String[] args) {
		//OUTPUT 
	 Items item = new Items("hi" );
	 	
	}
	
	
	
	
	
	
}
