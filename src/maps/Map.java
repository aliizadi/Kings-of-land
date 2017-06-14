package maps;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Other.MyTime;
import firstLayerObject.HighGround;
import firstLayerObject.LayerObject;
import firstLayerObject.LowGround;
import firstLayerObject.Sea;
import frames.MainFrame;
import frames.PreviewFrame;
import network.GameCube;
import secondLayerObject.Fish;
import secondLayerObject.GoldMine;
import secondLayerObject.IronMine;
import secondLayerObject.LayerObject2;
import secondLayerObject.Tree;
import singlePlayer.CharacterImages;
import singlePlayer.PlayerResources;

public class Map extends JPanel{
	private int firstLayer[][]; 
	private int secondLayer[][];
	private int map_width , map_height;
	private static int scroll_x ; 
	private static int scroll_y ;
	private static int tileSize;
	private int x;
	private int y;
	private int min_zoom , max_zoom , increament_zoom ;
	private int max_tile_code;
	private LayerObject []  layerObject;
	private LayerObject2 [] layerObject2;
	private Dimension screen;
	private PlayerResources playerResource;
	private boolean multiSingle , initialized;
	private MiniMap mm ; 
	public final int MAX_GROUP_CODE ;
	private CharacterImages chImages;
	private ImageIcon[] buildingObject;
	private ImageIcon[] castles;
	private int BuildingNum, Build_X, Build_Y, BuildMouse_X, BuildMouse_Y;
	private GameCube gameCube;

	public Map(int map_width , int map_height, MainFrame mainFrame) {

		screen = Toolkit.getDefaultToolkit().getScreenSize();

		tileSize=(int)screen.getWidth()/100;	
		tileSize*=8;

		this.map_width = map_width;
		this.map_height = map_height;
		MAX_GROUP_CODE = mainFrame.MAX_GROUP_CODE;

		multiSingle = false;
		initialized = true;

		initializeMap();
	}

	public Map(int map_width , int map_height, PreviewFrame previewFrame) {

		screen = Toolkit.getDefaultToolkit().getScreenSize();

		tileSize=(int)screen.getWidth()/100;	
		tileSize*=8;

		this.map_width = map_width;
		this.map_height = map_height;

		MAX_GROUP_CODE = previewFrame.MAX_GROUP_CODE;
		multiSingle = false;
		initialized = true;
		
		firstLayer = new int [map_height][map_width];
		secondLayer = new int [map_height][map_width];



		initializeMap();
	}

	public Map(int map_width , int map_height, GameCube gameCube) {

		screen = Toolkit.getDefaultToolkit().getScreenSize();
		tileSize=(int)screen.getWidth()/100;	
		tileSize*=8;

		this.map_width = map_width;
		this.map_height = map_height;
		this.gameCube = gameCube;

		MAX_GROUP_CODE = 7;
		multiSingle = true;
		initialized = false;
		
		firstLayer = new int [map_height][map_width];
		secondLayer = new int [map_height][map_width];

		initializeMap();
	}
	
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	private void initializeMap() {
		firstLayer = new int [map_height][map_width];
		secondLayer = new int [map_height][map_width];
		//initialize layerObject
		layerObject = new LayerObject[3];
		layerObject[0] = new Sea();
		layerObject[1] = new LowGround();
		layerObject[2] = new HighGround();

		//initialize LayerObject2
		layerObject2 = new LayerObject2[6];
		layerObject2[0] = new Fish();
		layerObject2[1] = new Tree();
		layerObject2[2]	= new secondLayerObject.Farm();
		layerObject2[3] = new IronMine();
		layerObject2[4] = new GoldMine();

		//init building Object
		buildingObject = new ImageIcon[14];

		buildingObject[0] = new ImageIcon("images\\buildings\\sawMill0.png");
		//buildingObject[0][1] = new ImageIcon("images\\buildings\\sawMill1.png");

		//buildingObject[1][0] = new ImageIcon("images\\buildings\\farmHouse0.png");
		buildingObject[1] = new ImageIcon("images\\buildings\\farmHouse1.png");

		buildingObject[2] = new ImageIcon("images\\buildings\\ironQuerry0.png");
		//buildingObject[2][1] = new ImageIcon("images\\buildings\\ironQuerry1.png");

		//buildingObject[3][0] = new ImageIcon("images\\buildings\\goldQuerry0.png");
		buildingObject[3] = new ImageIcon("images\\buildings\\goldQuerry1.png");

		buildingObject[4] = new ImageIcon("images\\buildings\\barracks0.png");
		//buildingObject[4][1] = new ImageIcon("images\\buildings\\barracks1.png");

		//buildingObject[5][0] = new ImageIcon("images\\buildings\\port0.png");
		buildingObject[5] = new ImageIcon("images\\buildings\\port1.png");

		//		buildingObject[6][0] = new ImageIcon("images\\buildings\\redCastle0.png");
		//		buildingObject[6][1] = new ImageIcon("images\\buildings\\blueCastle1.png");
		//		buildingObject[6][2] = new ImageIcon("images\\buildings\\greenCastle0.png");
		//		buildingObject[6][3] = new ImageIcon("images\\buildings\\blackCastle1.png");
		//transparent buildings
		buildingObject[7] = new ImageIcon("images\\buildings\\TransparentSawMill0.png");
		//buildingObject[7][1] = buildingObject[7][0];

		buildingObject[8] = new ImageIcon("images\\buildings\\TransparentFarmHouse0.png");
		//buildingObject[8][1] = buildingObject[8][0];

		buildingObject[9] = new ImageIcon("images\\buildings\\TransparentIronQuerry0.png");
		//buildingObject[9][1] = buildingObject[9][0];

		buildingObject[10] = new ImageIcon("images\\buildings\\TransparentGoldQuerry0.png");
		//buildingObject[10][1] = buildingObject[10][0];

		buildingObject[11] = new ImageIcon("images\\buildings\\TransparentBarracks0.png");
		//buildingObject[11][1] = buildingObject[11][0];

		buildingObject[12] = new ImageIcon("images\\buildings\\TransparentPort0.png");
		//buildingObject[12][1] = buildingObject[12][0];

		castles = new ImageIcon[4];
		castles[0] = new ImageIcon("images\\buildings\\redCastle0.png");
		castles[1] = new ImageIcon("images\\buildings\\blueCastle1.png");
		castles[2] = new ImageIcon("images\\buildings\\greenCastle0.png");
		castles[3] = new ImageIcon("images\\buildings\\blackCastle1.png");

		//initialize scroll_x and scroll_y
		x = firstLayer.length/2*tileSize;
		y = firstLayer[0].length/2*tileSize;
		converttoiso();
		scroll_x = x + tileSize;
		scroll_y = y + tileSize*3/2;

		//initialize zoom
		min_zoom = 50;
		max_zoom = 200;
		increament_zoom = 5;


		//initialize max_tile_code
		max_tile_code = 81;




		//initialize secondLayer

		for( int i =0 ; i<secondLayer.length ; i++){

			for(int j =0 ; j<secondLayer[i].length ; j++){

				secondLayer[i][j] = 0;

			}
		}

	}

	public void checkBuilding(int i , int x , int y ){
		BuildingNum = i ;
		Build_Y = y;
		Build_X = x;
	}

	public void CheckClickedBuild(boolean Clicked_bulding){
		if(Clicked_bulding){
			int i = BuildingNum;
			BuildingNum = -1 ;
			//System.out.println(firstLayer[BuildMouse_Y][BuildMouse_X]);
			if(firstLayer[BuildMouse_Y][BuildMouse_X]/max_tile_code>0){
				secondLayer[BuildMouse_Y][BuildMouse_X]= (i+(2*gameCube.ClientNumber+1)*MAX_GROUP_CODE);
			}
			repaint();
		}    
	}

	public void setBuildMouse_X(int buildMouse_X) {
		BuildMouse_X = buildMouse_X;
	}

	public void setBuildMouse_Y(int buildMouse_Y) {
		BuildMouse_Y = buildMouse_Y;
	}

	public ImageIcon[] getBuildingObject() {
		return buildingObject;
	}

	public ImageIcon[] getCastles() {
		return castles;
	}

	public void set_scroll_y( int y ){

		scroll_y+=y;

	}

	public void set_scroll_x( int x ){

		scroll_x+=x;

	}

	public int getScroll_x() {
		return scroll_x;
	}

	public int getScroll_y() {
		return scroll_y;
	}



	public void setPlayerResource(PlayerResources playerResource) {
		this.playerResource = playerResource;
	}

	public void zoom(int in_or_out) {


		Point p = getTileIndex(convert_to_2D(new Point(getWidth()/2, getHeight()/2)));

		this.tileSize += in_or_out*increament_zoom;

		Point q = new Point(p.x*tileSize, p.y*tileSize);
		scroll_x = converttoiso(q).x+tileSize - getWidth()/2;
		scroll_y = converttoiso(q).y +tileSize*3/2 - getHeight()/2; 
		this.repaint();
		//mm.repaint();

	}

	public static int getTileSize() {
		return tileSize;
	}

	public int getMax_zoom() {
		return max_zoom;
	}

	public int getMin_zoom() {
		return min_zoom;
	}

	public int getIncreament_zoom() {
		return increament_zoom;
	}

	public int getX_middle_tile() {

		return getTileIndex(convert_to_2D(new Point(getWidth()/2 , getHeight()/2))).x;

	}

	public int  getY_middle_tile() {

		return getTileIndex(convert_to_2D(new Point(getWidth()/2 , getHeight()/2))).y;

	}

	public int getMapColumns(){
		return firstLayer[0].length;
	}

	public int getMapRows(){
		return firstLayer.length;
	}

	public void set_firstLayer_cell(Point p , int code ){
		firstLayer[p.y][p.x] = code ;
	}

	public void setSecondLayer(int[][] secondLayer) {
		this.secondLayer = secondLayer;
	}
	public void set_secondLayer_cell(Point p  , int code) {
		secondLayer[p.y][p.x] = code ; 
	}

	public int[][] getFirstLayer() {
		return firstLayer;
	}
	public LayerObject[] getLayerObject() {
		return layerObject;
	}

	public int getMax_tile_code() {
		return max_tile_code;
	}

	public void setMm(MiniMap mm) {
		this.mm = mm;
	}
	public int[][] getSecondLayer() {
		return secondLayer;
	}
	public void setFirstLayer(int[][] firstLayer) {
		this.firstLayer = firstLayer;
	}
	public int getMap_height() {
		return map_height;
	}
	public int getMap_width() {
		return map_width;
	}

	//	public void setLayerObject2(Castle castle) {
	//		layerObject2[5] = castle;
	//	}

	public void setTimeTree(MyTime myTime){
		layerObject2[1].setMyTime(myTime); 
	}

	public LayerObject2[] getLayerObject2() {
		return layerObject2;
	}



	@Override
	public void paint(Graphics p) {
		if (initialized) {

			// TODO Auto-generated method stub
			super.paint(p);

			//draw map
			for(int i=0 ; i<map_width ; i++){
				for(int j=0 ; j<map_height ;j++){

					x = j * tileSize;
					y = i * tileSize;

					converttoiso();

					x = x - scroll_x ; 	
					y = y - scroll_y ;



					if(x>-2*tileSize && y>-2*tileSize && x<getWidth() && y<getHeight()){

						p.drawImage(layerObject[firstLayer[i][j]/max_tile_code].getImg(firstLayer[i][j]%max_tile_code),x,y,tileSize*2,tileSize*2,null);

						if(secondLayer[i][j] != 0){
							if(secondLayer[i][j] <12)
								//drawing a resource
								p.drawImage(layerObject2[(secondLayer[i][j]%MAX_GROUP_CODE)].getImg(), x, y, tileSize*2 ,tileSize*2 , null  );
							else{
								//drawing a building
								if((secondLayer[i][j]%(MAX_GROUP_CODE*2)) != 6)	
									p.drawImage(buildingObject[(secondLayer[i][j]%(MAX_GROUP_CODE*2))].getImage(), x, y, tileSize*2 ,tileSize*2 , null  );
								else
									p.drawImage(castles[((secondLayer[i][j]+1)/MAX_GROUP_CODE-1)/2-1].getImage(), x, y, tileSize*2 ,tileSize*2 , null  );

							}

						}
						else{
							if(multiSingle){
								//drawing spirites
								for (int k1 = 0; k1 < 4; k1++) {
									for (int k2 = 0; k2 < gameCube.cube[0].length/5; k2++) {
										Point tempIndex  = getTileIndex(convert_to_2D(new Point(gameCube.cube[k1][k2][0], gameCube.cube[k1][k2][1])));
										if ( tempIndex.x == j && tempIndex.y == i ) {
											p.drawImage(chImages.currentTile(gameCube.cube[k1][k2][3], gameCube.cube[k1][k2][4],gameCube.cube[k1][k2][5]).getImage()
													, gameCube.cube[k1][k2][0] - scroll_x, gameCube.cube[k1][k2][1] - scroll_y
													, playerResource.getwW(), playerResource.getwH(), null);
										}
									}

									for (int k2 = gameCube.cube[0].length/5; k2 < gameCube.cube[0].length*2/5; k2++) {
										Point tempIndex  = getTileIndex(convert_to_2D(new Point(gameCube.cube[k1][k2][0], gameCube.cube[k1][k2][1])));
										if ( tempIndex.x == j && tempIndex.y == i ) {
											p.drawImage(chImages.currentTile(gameCube.cube[k1][k2][3], gameCube.cube[k1][k2][4],gameCube.cube[k1][k2][5]).getImage()
													, gameCube.cube[k1][k2][0] - scroll_x, gameCube.cube[k1][k2][1] - scroll_y
													, playerResource.getsW(), playerResource.getsH(), null);
										}
									}

									for (int k2 = gameCube.cube[0].length*2/5; k2 < gameCube.cube[0].length*3/5; k2++) {
										Point tempIndex  = getTileIndex(convert_to_2D(new Point(gameCube.cube[k1][k2][0], gameCube.cube[k1][k2][1])));
										if ( tempIndex.x == j && tempIndex.y == i ) {
											p.drawImage(chImages.currentTile(gameCube.cube[k1][k2][3], gameCube.cube[k1][k2][4],gameCube.cube[k1][k2][5]).getImage()
													, gameCube.cube[k1][k2][0] - scroll_x, gameCube.cube[k1][k2][1] - scroll_y
													, playerResource.getShW(), playerResource.getShH(), null);
										}

									}

									for (int k2 = gameCube.cube[0].length*3/5; k2 < gameCube.cube[0].length*4/5; k2++) {
										Point tempIndex  = getTileIndex(convert_to_2D(new Point(gameCube.cube[k1][k2][0], gameCube.cube[k1][k2][1])));
										if ( tempIndex.x == j && tempIndex.y == i ) {
											p.drawImage(chImages.currentTile(gameCube.cube[k1][k2][3], gameCube.cube[k1][k2][4],gameCube.cube[k1][k2][5]).getImage()
													, gameCube.cube[k1][k2][0] - scroll_x, gameCube.cube[k1][k2][1] - scroll_y
													, playerResource.getfW(), playerResource.getfH(), null);
										}

									}	

								}

							}

						}
					}
					//p.setColor(Color.orange);
					//p.drawString(String.valueOf(j)+":"+String.valueOf(i),x+tileSize,y+tileSize*3/2);

				}
			}

			if(BuildingNum!=-1){
				p.drawImage(buildingObject[BuildingNum % (MAX_GROUP_CODE*2)].getImage(), Build_X - tileSize, Build_Y - tileSize*3/2,2*tileSize,2*tileSize, null);
			}
			//p.setColor(new Color(0, 0, 102, 120));

			mm.repaint();

			setBackground(Color.gray);
		}

	}


	public int get_tile_code(Point p , boolean is_center , int type){
		int code =0;

		if(p.y>0) code += firstLayer[p.y-1][p.x]/max_tile_code;

		if(p.x<getMapColumns()-1) code += 3 * (firstLayer[p.y][p.x+1]/max_tile_code);

		if(p.y<getMapRows()-1) code += 9 * (firstLayer[p.y+1][p.x]/max_tile_code);

		if(p.x>0) code += 27 * (firstLayer[p.y][p.x-1]/max_tile_code);


		if(is_center==true)
			code += type%MAX_GROUP_CODE * max_tile_code ;
		else
			code += (firstLayer[p.y][p.x]/max_tile_code) * max_tile_code ;


		return code ; 

	}
	//Convert Coordinate to Isometric

	private void converttoiso(){

		int x2,y2;

		x2 = x;

		y2 = y;

		x = (x2 - y2);

		y = (int)(x2 + y2)/2  ;
	}

	public  Point converttoiso(Point p ){		

		return new Point(p.x-p.y , (int)(p.x+p.y)/2);

	}

	public static Point convert_to_2D(Point p){
		return new Point((p.y - tileSize+scroll_y) + (p.x - tileSize+scroll_x)/2, (p.y - tileSize+scroll_y) - (p.x - tileSize+scroll_x)/2);
	}

	public static Point getTileIndex(Point p) {
		return new Point((int)p.x/tileSize,(int)p.y/tileSize);
	}

	public void reNewMap(int rows , int columns){
		//initialize newLayer
		int [][] newLayer1 = new int[rows][columns];
		int [][] newLayer2 = new int[rows][columns];
		for( int i =0 ; i<newLayer1.length ; i++){
			for(int j =0 ; j<newLayer1[i].length ; j++){
				newLayer1[i][j] = 0;
				newLayer2[i][j] = 0;

			}
		}

		firstLayer = newLayer1;
		secondLayer = newLayer2;
		map_height = rows;
		map_width = columns;

		//initialize scroll_x and scroll_y

		Point p = converttoiso(new Point(newLayer1.length/2*tileSize,newLayer1[0].length/2*tileSize));
		scroll_x = p.x + tileSize-getWidth()/2;
		scroll_y = p.y + tileSize*3/2-getHeight()/2;




		mm.calcTileSize();
		mm.calcOffset();
		repaint();
	}

	public void setMap_height(int map_height) {
		this.map_height = map_height;
	}

	public void setMap_width(int map_width) {
		this.map_width = map_width;
	}

	public MiniMap getMm() {
		return mm;
	}

	public void loadMap(int[][] firstLayer , int[][] secondLayer){

		this.firstLayer = firstLayer;
		this.secondLayer = secondLayer;
		map_height = firstLayer.length;
		map_width = firstLayer[0].length;

		//initialize scroll_x and scroll_y

		Point p = converttoiso(new Point(firstLayer.length/2*tileSize,firstLayer[0].length/2*tileSize));
		scroll_x = p.x + tileSize-getWidth()/2;
		scroll_y = p.y + tileSize*3/2-getHeight()/2;




		mm.calcTileSize();
		mm.calcOffset();
		repaint();
	}


	public int [][] exteractMixedLayer(){
		int [][] tempLayer = new int [firstLayer.length][firstLayer[0].length];
		for(int i=0 ; i<firstLayer.length ; i++){
			for(int j=0 ; j<firstLayer.length ; j++){
				if(firstLayer[i][j]==0){
					tempLayer[i][j] = 1 ;
				}
				else{
					if(secondLayer[i][j]==0)
						tempLayer[i][j]=2;
					else
						tempLayer[i][j]=0;
				}
			}
		}
		return tempLayer;
	}




}


