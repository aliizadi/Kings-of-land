package maps;

import java.awt.Point;

import javax.swing.plaf.synth.Region;

public class Resource {
	private int capacity;
	private Point resourceP;
	private int remindingResource;
	private int regenaite;
	private int giveSpeed;
	public Resource(int capacity , Point p , int regen , int speed ) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		resourceP = p;
		regenaite = regen;
		giveSpeed = speed;
		remindingResource = capacity;
	}
	
	public int getRemindingResource() {
		return remindingResource;
	}
	
	public void setRemindingResource(int repick) {
		this.remindingResource -= repick;
	}
	
	public int getGiveSpeed() {
		return giveSpeed;
	}
	
	public void setGiveSpeed(int increasspeed) {
		this.giveSpeed += increasspeed;
	}
	
	public void setRemindingResource(){
		this.remindingResource += this.regenaite;
	}

	public Point getResourceP() {
		return resourceP;
	}
	
	
}
