package Other;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

public class SetCursor {
	Toolkit toolkit;
	Image[] image;
	Cursor c;
	public SetCursor() {
		// TODO Auto-generated constructor stub
	toolkit = Toolkit.getDefaultToolkit();
	image = new Image[6];
	//normal
	image[0] = toolkit.getImage("images\\buildings\\Menu.png");
	//minning
	image[1] = toolkit.getImage("images\\buildings\\mining.png");
	//farming
	image[2] = toolkit.getImage("images\\buildings\\farming.png");
	//Wooding
	image[3] = toolkit.getImage("images\\buildings\\Untitled-1.png");
	//choose
	image[4] = toolkit.getImage("images\\buildings\\mouseselected.png");
	}
	
	public Cursor setMouseIcon(int i){
		return c = toolkit.createCustomCursor(image[i], (new Point(0,0) ), null);
			
	}
}
