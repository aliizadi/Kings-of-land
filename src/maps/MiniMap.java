package maps;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import firstLayerObject.LayerObject;
import frames.MainFrame;

public class MiniMap extends JPanel{

	private LayerObject []  layerObject;
	private final int max_tile_code;
	private int tileSize, halfTileSize;
	private final Color rectColor;
	private Point mapSize ; 
	private Point offset;
	private int x;
	private int y;
	private int width , height ; 


	private Map map;

	public MiniMap(Map map , int width , int height , Point mapSize ) {

		this.map = map ;
		this.width = width ; 
		this.height = height ; 
		this.mapSize = mapSize ; 

		layerObject = map.getLayerObject();
		max_tile_code = map.getMax_tile_code();
		calcTileSize();
		calcOffset();
		rectColor = new Color(225, 51, 51 );
	}


	@Override
	public void paint(Graphics p) {


		// TODO Auto-generated method stub
		super.paint(p);



		p.setColor(rectColor);
		setBackground(Color.black);
		//draw map
		for(int i=0 ; i<map.getFirstLayer().length ; i++){
			for(int j=0 ; j<map.getFirstLayer()[0].length ;j++){
				x = j * halfTileSize;
				y = i * halfTileSize;



				converttoiso();

				x = x + offset.x ;   
				y = y + offset.y ; 

				p.drawImage(layerObject[map.getFirstLayer()[i][j]/max_tile_code].getImg(map.getFirstLayer()[i][j]%max_tile_code),x,y,tileSize,tileSize,null);
				if(map.getSecondLayer()[i][j] != 0){
					if(map.getSecondLayer()[i][j] <12)
						//drawing a resource
						p.drawImage(map.getLayerObject2()[(map.getSecondLayer()[i][j]%map.MAX_GROUP_CODE)].getImg(), x, y, tileSize*2 ,tileSize*2 , null  );
					else{
						//drawing a building
						if((map.getSecondLayer()[i][j]%(map.MAX_GROUP_CODE*2)) != 6)	
							p.drawImage(map.getBuildingObject()[(map.getSecondLayer()[i][j]%(map.MAX_GROUP_CODE*2))].getImage(), x, y, tileSize*2 ,tileSize*2 , null  );
						else
							p.drawImage(map.getCastles()[((map.getSecondLayer()[i][j]+1)/map.MAX_GROUP_CODE-1)/2-1].getImage(), x, y, tileSize*2 ,tileSize*2 , null  );

					}

				}







			}
		}

		//drawing red rect
		Point start = map.convert_to_2D(new Point(0,0));
		start = new Point(start.x * halfTileSize/map.getTileSize(),start.y * halfTileSize/map.getTileSize());
		
		Point end = map.convert_to_2D(mapSize);
		end = new Point(end.x * halfTileSize/map.getTileSize(),end.y * halfTileSize/map.getTileSize());
		
		
		start = converttoiso(start);
		
		end = converttoiso(end);
		p.drawRect(start.x + offset.x, start.y + offset.y, end.x-start.x, end.y-start.y);
	}

	private void converttoiso(){

		int x2,y2;

		x2 = x;

		y2 = y;

		x = (x2 - y2);

		y = (int)(x2 + y2)/2  ;
	}





	private Point converttoiso(Point p ){    

		return new Point(p.x-p.y , (int)(p.x+p.y)/2);

	}

	public Point convert_to_2D(Point p){
		return new Point((p.y - halfTileSize - offset.y) + (p.x - halfTileSize - offset.x)/2, (p.y - halfTileSize - offset.y) - (p.x - halfTileSize - offset.x)/2);
	}

	public Point getTileIndex(Point p) {
		return new Point((int)p.x/halfTileSize,(int)p.y/halfTileSize);
	}

	public int getHalfTileSize() {
		return halfTileSize;
	}

	public void calcTileSize() {
		tileSize = Math.min(2*width/(map.getFirstLayer().length + map.getFirstLayer()[0].length), 4*height/(map.getFirstLayer().length + map.getFirstLayer()[0].length));
		halfTileSize = tileSize/2;
	}

	public void calcOffset() {
		//initializing offset
		int tempX = (width - (map.getFirstLayer().length + map.getFirstLayer()[0].length - 2)*tileSize/2)/2 + (map.getFirstLayer().length-1)*tileSize/2 - halfTileSize;
		int tempY = (height - (map.getFirstLayer().length + map.getFirstLayer()[0].length - 2)*tileSize/4)/2;
		offset = new Point(tempX, tempY);
	}


}