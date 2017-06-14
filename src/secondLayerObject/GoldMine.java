package secondLayerObject;

import java.awt.Image;

import javax.swing.ImageIcon;

import Other.MyTime;

public class GoldMine implements LayerObject2 {
	
	private ImageIcon  img; 

	public GoldMine() {
		// TODO Auto-generated constructor stub
		img = new ImageIcon("images\\firstLayer\\goldMine.PNG");
		
	}

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return img.getImage();
	}

	@Override
	public void setMyTime(MyTime myTime) {
		// TODO Auto-generated method stub
		
	}

}
