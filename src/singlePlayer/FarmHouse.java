package singlePlayer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FarmHouse implements BuildingHouse{

	private int x;
	private int y;
	private int health;
	public FarmHouse(int x , int y){
		this.x = x;
		this.y = y;
		health = 2000;
	}
	
	@Override
	public void changeHealth(int enemyORown, int damagePoint){
	//make if for our humen positive damage and for enemy negative damage
	//number for own is 1 for other enemy 2
		if(enemyORown==1){
			health -= damagePoint;
			destroy(!isAlive());
		}
		
		if(enemyORown==2){
			health +=damagePoint;
		}
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		if(health<1){
			return false;
		}
		else
			return true;
	}
	
	@Override
	public void destroy(boolean hp) {
		//dar inja khane mored nazar nabood va namaiesh dadan on motevaghef mishavad
	}
	
}
