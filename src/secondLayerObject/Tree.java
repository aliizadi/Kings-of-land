package secondLayerObject;

import java.awt.Image;

import javax.swing.ImageIcon;

import Other.MyTime;

public class Tree implements LayerObject2 {
	
	private ImageIcon [] img ; 
	private MyTime myTime;
	
	public Tree() {
		// TODO Auto-generated constructor stub
		img = new ImageIcon[12];
		img[0] = new ImageIcon("images\\firstLayer\\trees\\tree_spring.png");
		img[1] = img[0];
		img[2] = img[0];
		
		img[3] = new ImageIcon("images\\firstLayer\\trees\\tree_summer.png");
		img[4] = img[3];
		img[5] = img[3];
		
		img[6] = new ImageIcon("images\\firstLayer\\trees\\tree_fall.png");
		img[7] = img[6];
		img[8] = img[6];
		
		img[9] = new ImageIcon("images\\firstLayer\\trees\\tree_winter.png");
		img[10] = img[9];
		img[11] = img[9];
		
	}

	public void setMyTime(MyTime myTime) {
		this.myTime = myTime;
	}
	
	
	public Image getImg() {
		// TODO Auto-generated method stub
		return img[myTime.getDate()[1]].getImage();
	}

}
