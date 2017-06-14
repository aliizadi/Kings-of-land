package singlePlayer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SeaPort implements MouseListener,BuildingHouse{
	
	private int x;
	private int y;
	private int health;

	public SeaPort(int x , int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		health = 3000;
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
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
