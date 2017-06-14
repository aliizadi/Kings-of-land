package maps;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Other.Music;
import Other.SetCursor;

public class RightJpanel extends JPanel {
	private ImageIcon background ;
	private ImageIcon [] secondBackgorund ;
	private int width , height , startY, startX;
	private Dimension screen;
	private String[] fields;
	private String[] values;
	private int fieldsX, valuesX, yIncreament;
	private int backGroundIMG;
	private MyLables newWorker , newSoldier, newShip , newFishingShip, buildBarracks , BuildSeaPOrt , buildFarm , buildGoldQuarry 
	, BuildIronQuarry , buildWoodQuarry ,onBoardAll;
	private JLabel [] labelsArr ;
	private ImageIcon btnImg;
	private Image btnImg2;
	private Music music;
	private Map map;
	private int BuildingNum , Build_X , Build_Y , clicked;
	boolean ClickedAgain;
	public RightJpanel(Music music , Map map) {
		this.music = music;
		this.map = map;
		// TODO Auto-generated constructor stub
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)(screen.width*1/5);
		height = (int)(screen.height*3/4);
		backGroundIMG = -1 ;
		startY = (int)screen.getWidth()*8/69;
		startX = 32;
		fields = new String[6];
		values = new String[6];
		emptyAllFieldsAndValues();
		fieldsX = startX + 35;
		valuesX = 240;
		yIncreament = 35;
		BuildingNum = -1 ;
		clicked = -1;
		
		//set background for rightPanel
		background = new ImageIcon("images\\button\\rightPanelBackGround.jpg");
		btnImg = new ImageIcon("images\\button\\buttonBackground.png");
		btnImg2 = btnImg.getImage();

		
		secondBackgorund = new ImageIcon[17];
		//soldier
 		secondBackgorund[0] = new ImageIcon("images\\button\\soldier_lowop.png");
		//worker
 		secondBackgorund[1]= new ImageIcon("images\\button\\worker_lowop.png");
 		//barraks
		secondBackgorund[2]= new ImageIcon("images\\transparent_building\\barracks0_transparent.png");
		//castle
		secondBackgorund[3] = new ImageIcon("images\\transparent_building\\blueCastle0_transparent.png");
		//quarry farm
		secondBackgorund[5] = new ImageIcon("images\\transparent_building\\farmHouse0_transparent.png");
		//quary gold
		secondBackgorund[6] = new ImageIcon("images\\transparent_building\\goldQuerry0_transparent.png");
		//quary wood
		secondBackgorund[7] = new ImageIcon("images\\transparent_building\\sawMill0_transparent.png");
		//sea port
		secondBackgorund[8] = new ImageIcon("images\\transparent_building\\port0_transparent.png");
		//quarry iron
		secondBackgorund[9] = new ImageIcon("images\\transparent_building\\ironQuerry0_transparent.png");
		//Tree
		secondBackgorund[10] = new ImageIcon("images\\transparent_building\\transparentTree.png");
		//Gold mine
		secondBackgorund[11] = new ImageIcon("images\\transparent_building\\transparentGoldMine.png");
		//Iron mine
		secondBackgorund[12] = new ImageIcon("images\\transparent_building\\transparentIronMine.png");
		//FArm
		secondBackgorund[13] = new ImageIcon("images\\transparent_building\\transparentFarm.png");
		//Fish
		secondBackgorund[14] = new ImageIcon("images\\transparent_building\\transparentFish.png");
		//ship
		secondBackgorund[15] = new ImageIcon("images\\transparent_building\\ship_transparent.png");
		//Fiishing Ship
		secondBackgorund[16] = new ImageIcon("images\\transparent_building\\fishingShip_transparent.png");
		
		
		setFont(new Font("Comic Sans MS", Font.PLAIN, 18));


		//setting size and location of labals
		labelsArr = new JLabel[12];
		//newWorker
		newWorker = new MyLables("NEW WORKER" , getScaledImg(150, 50));
		newWorker.setSize(150, 50);
		newWorker.setLocation(startX,startY + fields.length*yIncreament);
		add(newWorker);
		labelsArr[0] = newWorker;

		//newSoldier
		newSoldier = new MyLables("NEW SOLDIER" , getScaledImg(150, 50));
		newSoldier.setSize(150, 50);
		newSoldier.setLocation(startX,startY + fields.length*yIncreament);
		add(newSoldier);
		labelsArr[1] = newSoldier; 

		//newFishingShip
		newFishingShip = new MyLables("NEW FISHING SHIP" , getScaledImg(150, 50));
		newFishingShip.setSize(150, 50);
		newFishingShip.setLocation(startX,startY + fields.length*yIncreament);
		add(newFishingShip);
		labelsArr[2] = newFishingShip; 

		//newShip
		newShip = new MyLables("NEW SHIP" , getScaledImg(150, 50));
		newShip.setSize(150, 50);
		newShip.setLocation(startX + 170,startY + fields.length*yIncreament);
		add(newShip);
		labelsArr[3] = newShip; 

		//buildBarracks
		buildBarracks = new MyLables("BUILD BARRACKS" , getScaledImg(150, 50));
		buildBarracks.setSize(150, 50);
		buildBarracks.setLocation(startX,startY + fields.length*yIncreament);
		add(buildBarracks);
		labelsArr[4] = buildBarracks; 

		//BuildSeaPOrt
		BuildSeaPOrt = new MyLables("BUILD SEAPORT" , getScaledImg(150, 50));
		BuildSeaPOrt.setSize(150, 50);
		BuildSeaPOrt.setLocation(startX + 170,startY + fields.length*yIncreament);
		add(BuildSeaPOrt);
		labelsArr[5] = BuildSeaPOrt; 

		//BuildQuarryIron
		BuildIronQuarry = new MyLables("BUILD IRONQUARRY" , getScaledImg(150, 50));
		BuildIronQuarry.setSize(150, 50);
		BuildIronQuarry.setLocation(startX,startY + fields.length*yIncreament + 60);
		add(BuildIronQuarry);
		labelsArr[6] = BuildIronQuarry; 

		//BuildQuarryWood
		buildWoodQuarry = new MyLables("BUILD WOODQUARRY" , getScaledImg(150, 50));
		buildWoodQuarry.setSize(150, 50);
		buildWoodQuarry.setLocation(startX + 170,startY + fields.length*yIncreament + 60);
		add(buildWoodQuarry);
		labelsArr[7] = buildWoodQuarry; 

		//BuildQuarryGold
		buildGoldQuarry = new MyLables("BUILD GOLDQUARRY" , getScaledImg(150, 50));
		buildGoldQuarry.setSize(150, 50);
		buildGoldQuarry.setLocation(startX,startY + fields.length*yIncreament + 2*60);
		add(buildGoldQuarry);
		labelsArr[8] = buildGoldQuarry; 

		//BuildQuarryFarm
		buildFarm = new MyLables("BUILD FARM" , getScaledImg(150, 50));
		buildFarm.setSize(150, 50);
		buildFarm.setLocation(startX + 170,startY + fields.length*yIncreament + 2*60);
		add(buildFarm);
		labelsArr[9] = buildFarm; 

		//onBoardAll
		onBoardAll = new MyLables("BUILD IRONQUARRY" , getScaledImg(150, 50));
		onBoardAll.setSize(150, 50);
		onBoardAll.setLocation(startX,startY + fields.length*yIncreament);
		add(onBoardAll);
		onBoardAll.setVisible(false);
		labelsArr[10] = onBoardAll; 

		setLayout(null);
	}

	private void emptyAllFieldsAndValues(){
		for (int i = 0; i < fields.length; i++) {
			fields[i] = "";
			values[i] = "";
		}
	}

	public void setBackGroundRightPanel(char objectCode , int currentHealth , int GL , int IL , int WL , int FL ){
		////clean old panel
		for(int i=0 ; i<labelsArr.length ; i++){
			labelsArr[i].setVisible(false);
		}
		emptyAllFieldsAndValues();
		switch (objectCode) {
		case 'w':{//worker panel
			music.playsound(9,false);
			fields[0] = "Worker";
			fields[1] = Integer.toString(currentHealth);                      //get Current health here
			values[1] = "/ 500";
			fields[2] = "Gold : ";
			values[2] = Integer.toString(GL);
			fields[3] = "Iron : ";
			values[3] = Integer.toString(IL);
			fields[4] = "Wood : ";
			values[4] = Integer.toString(WL);
			fields[5] = "Food : ";
			values[5] = Integer.toString(FL);
			backGroundIMG = 1 ;
			for(int i=4 ; i<10 ; i++){
				labelsArr[i].setVisible(true);
			}
		}
		break;

		case 's':{//soldier panel
			music.playsound(10,false);
			fields[0] = "Soldier";
			fields[1] = Integer.toString(currentHealth);                //      get Current health here
			values[1] = "/ 1000";
			backGroundIMG = 0 ;
		}
		break;

		case 'h':{//ship panel
			music.playsound(28,false);
			fields[0] = "Ship";
			fields[1] = Integer.toString(FL);  //get Current load here
			values[1] = "/ 10";              
			labelsArr[10].setVisible(true);
			backGroundIMG = 15 ;
		}
		break;

		case 'f':{//fishing ship panel
			music.playsound(11,false);
			fields[0] = "FishingShip";
			fields[1] = Integer.toString(FL);  //                    get Current load here
			values[1] = "/ 1200";
			backGroundIMG = 16 ;
		}
		break;

		case 'c':{ //castle panel
			music.playsound(16,false);
			fields[0] = "Castle";
			fields[1] = Integer.toString(currentHealth);                      //get Current health here
			values[1] = "/ 10000";
			fields[2] = "Gold : ";
			values[2] = Integer.toString(GL);
			fields[3] = "Iron : ";
			values[3] = Integer.toString(IL);
			fields[4] = "Wood : ";
			values[4] = Integer.toString(WL);
			fields[5] = "Food : ";
			values[5] = Integer.toString(FL);
			labelsArr[0].setVisible(true);
			backGroundIMG = 3 ;
		}
		break;
		
		case 'b':{//barracks panel
			music.playsound(7,false);
			fields[0] = "Barracks";
			fields[1] = Integer.toString(currentHealth);                      //get Current health here
			values[1] = "/ 5000";
			labelsArr[1].setVisible(true);
			backGroundIMG = 2 ;
		}
		
		break;
		
		case 'p':{//seaport panel
			music.playsound(8,false);
			fields[0] = "SeaPort";
			fields[1] = Integer.toString(currentHealth);                      //get Current health here
			values[1] = "/ 3000";
			labelsArr[2].setVisible(true);
			labelsArr[3].setVisible(true);
			backGroundIMG = 8 ;
		}
		
		break;
		
		case 'F':{//quarry food
			music.playsound(3,false);
			fields[0] = "QuarryFood";
			fields[1] = Integer.toString(currentHealth);                      //get Current health here
			values[1] = "/ 2000";
			backGroundIMG = 5 ;
		}
		
		break;
		
		case 'W':{//quarry wood
			music.playsound(6,false);
			fields[0] = "QuarryWood";
			fields[1] = Integer.toString(currentHealth);                      //get Current health here
			values[1] = "/ 2000";
			backGroundIMG = 7 ;
		}
		
		break;
		
		case 'G':{//quarry gold
			music.playsound(4,false);
			fields[0] = "QuarryGold";
			fields[1] = Integer.toString(currentHealth);                      //get Current health here
			values[1] = "/ 2000";
			backGroundIMG = 6 ;
		}
		
		break;
		
		case 'I':{//quarry Iron
			music.playsound(5,false);
			fields[0] = "QuarryIron";
			fields[1] = Integer.toString(currentHealth);                      //get Current health here
			values[1] = "/ 2000";
			backGroundIMG = 9 ;
		}
		
		break;
		
		case 't':{//tree
			music.playsound(29,false);
			fields[0] = "Tree";
			fields[1] = Integer.toString(WL);                      //get Current health here
			values[1] = "/ 10000";
			fields[2] = "Regenation : ";
			values[2] = Integer.toBinaryString(30);
			backGroundIMG = 10 ;
		}
		
		break;
		
		case 'T':{//wheat
			music.playsound(15,false);
			fields[0] = "Wheat";
			fields[1] = Integer.toString(FL);                      //get Current health here
			values[1] = "/ 8000";
			fields[2] = "Regenation : ";
			values[2] = Integer.toBinaryString(35);
			backGroundIMG = 13 ;
		}
		
		break;
		
		case 'g':{//Gold Mine
			music.playsound(12,false);
			fields[0] = "Gold Mine";
			fields[1] = Integer.toString(GL);                      //get Current health here
			values[1] = "/ 20000";
			fields[2] = "Regenation : " ;
			values[2] = Integer.toBinaryString(20);
			backGroundIMG = 11 ;
		}	
		
		break;
		
		case 'i':{//Iron MIne
			music.playsound(13,false);
			fields[0] = "Iron Mine";
			fields[1] = Integer.toString(IL);                      //get Current health here
			values[1] = "/ 20000";
			fields[2] = "Regenation : ";
			values[2] = Integer.toBinaryString(20);
			backGroundIMG = 12 ;
		}
		
		break;
		
		case 'm':{//Fish(mahi)
			music.playsound(14,false);
			fields[0] = "Fish";
			fields[1] = Integer.toString(FL);                      //get Current health here
			values[1] = "/ 15000";
			fields[2] = "Regenation : ";
			values[2] = Integer.toBinaryString(40);
			backGroundIMG = 14 ;
		}
		
		break;
		
		case 'n':{//null
			backGroundIMG = -1 ;
		}
		break;
		
		default:
			break;
		}
		repaint();
	}

	private ImageIcon getScaledImg(int w, int h) {
		return new ImageIcon(btnImg2.getScaledInstance(w , h,  java.awt.Image.SCALE_SMOOTH));
	}


	@Override
	public void paintComponent(Graphics g){
		g.drawImage(background.getImage(), 0, 0, width ,height , null);
		if(backGroundIMG!=-1)
		g.drawImage(secondBackgorund[backGroundIMG].getImage(), 0,startY, width, height - startY, null);
		for (int i = 0; i < fields.length; i++) {
			g.drawString(fields[i], fieldsX, startY + i*yIncreament);
			g.drawString(values[i], valuesX, startY + i*yIncreament);
		}	
	}

	class MyLables extends JLabel implements MouseListener , Runnable{
		public MyLables(String name ,ImageIcon img) {
			super(name, img, JLabel.CENTER);
			addMouseListener(this);
			setFont(new Font("Comic Sans MS", Font.TRUETYPE_FONT, 12));
			setVerticalTextPosition(JLabel.CENTER);
			setHorizontalTextPosition(JLabel.CENTER);
			setVisible(false);
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getButton()==MouseEvent.BUTTON1){
			if(arg0.getSource()==newWorker){
				
				System.out.println("MakeNewWOrker");
			}
			
			else if(arg0.getSource()==newSoldier){
				System.out.println("MakeNewSoldier");
				
			}
			
			else if(arg0.getSource()==newFishingShip){
				System.out.println("MakeFishingShip");
				
			}
			
			else if(arg0.getSource()==newShip){
				System.out.println("MakeNewShip");
				
			}
			
			else if(arg0.getSource()==buildBarracks){
				music.playsound(1,false);
				clicked = clicked *-1;
				BuildingNum = 4 ;
				ClickedAgain = false;
				(new Thread(this)).start();
			}
			
			else if(arg0.getSource()==buildFarm){
				music.playsound(1,false);
				clicked = clicked *-1;
				ClickedAgain = false;
				BuildingNum = 1;
				(new Thread(this)).start();
			}
			
			else if(arg0.getSource()==buildGoldQuarry){
				music.playsound(1,false);
				clicked = clicked *-1;
				ClickedAgain = false;
				BuildingNum = 3 ;
				(new Thread(this)).start();
			}
			
			else if(arg0.getSource()==buildWoodQuarry){
				music.playsound(1,false);
				BuildingNum = 0 ;
				ClickedAgain = false;
				clicked = clicked *-1;
				(new Thread(this)).start();
			}
			
			else if(arg0.getSource()==BuildIronQuarry){
				music.playsound(1,false);
				clicked = clicked *-1;
				ClickedAgain = false;
				BuildingNum = 2 ;
				(new Thread(this)).start();
			}
			
			else if(arg0.getSource()==BuildSeaPOrt){
				music.playsound(1,false);
				clicked = clicked *-1;
				ClickedAgain = false;
				BuildingNum = 5;
				(new Thread(this)).start();
			}
			
			}
			else if(arg0.getButton()==MouseEvent.BUTTON2){
				clicked = 0;
				ClickedAgain = true;
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource()==buildBarracks)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==buildFarm)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==buildGoldQuarry)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==buildWoodQuarry)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==BuildSeaPOrt)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==BuildIronQuarry)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==newWorker)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==newSoldier)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==newFishingShip)
				setCursor(new SetCursor().setMouseIcon(4));
			else if(arg0.getSource()==newShip)
				setCursor(new SetCursor().setMouseIcon(4));
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stu
			setCursor(new SetCursor().setMouseIcon(0));
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(!ClickedAgain)
			{
				Point p = (new Point(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y));
				map.checkBuilding(BuildingNum,p.x,p.y);
				map.repaint();
			}

		}
	}

	public void setClicked(int clicked) {
		this.clicked = clicked;
	}

	public void setClickedAgain(boolean clickedAgain) {
		ClickedAgain = clickedAgain;
	}
	
	public int getClicked() {
		return clicked;
	}
	
	public void setBuildingNum(int buildingNum) {
		BuildingNum = buildingNum;
	}
}