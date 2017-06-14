package firstLayerObject;

import java.awt.Image;
import javax.swing.ImageIcon;

import Other.MyTime;

public class Sea implements LayerObject {
	private ImageIcon[] img;
	private ImageIcon [] img2; 
	private ImageIcon [][] seasons ; 
	private MyTime myTime;

	public Sea() {
		
		seasons = new ImageIcon [12][1];
		img = new ImageIcon[1];
		img2 = new ImageIcon[1];

		img[0] = new ImageIcon("images\\firstLayer\\0-0000.PNG");
		img2[0] = new ImageIcon("images\\firstLayer\\0-0000i.PNG");
		
		

		for(int i =0 ; i<8 ; i++)
			seasons[i] = img;
		for(int i =8; i<12 ; i++)
			seasons[i] = img2;
		
	}
	
	@Override
	public void setMyTime(MyTime myTime) {
		this.myTime = myTime;
	}


	@Override
	public Image getImg(int code) {
		// TODO Auto-generated method stub
		
		return seasons[myTime.getDate()[1]][0].getImage();
		
	}

}
