package singlePlayer;

import java.awt.Point;
import java.util.Stack;

import maps.Map;
import network.GameCube;

public class FishingShip implements Runnable{
	private int index;
	private GameCube gameCube;
	//private int x;
	//private int y;
	private long d ;
	private int load;
	private int framecheck;
	private int order;
	private Stack<Point> path;
	private PlayerResources PR;
	private Point currentTile;
	private Point tempTarget;
	public FishingShip(GameCube gameCube,int index, PlayerResources pr){
		this.index = index;
		this.gameCube = gameCube;

		framecheck = 0;
		path = new Stack<>();
		PR = pr ;
		this.currentTile = PR.map.getTileIndex(PR.map.convert_to_2D(new Point(gameCube.cube[this.gameCube.ClientNumber-1][index][0]
				, this.gameCube.cube[this.gameCube.ClientNumber-1][index][1])));

		load = 0;
		
		order = 0;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setTempTarget(Point tempTarget) {
		this.tempTarget = tempTarget;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return order;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
			//moving order1
			goToTarget(1, tempTarget);

			//moving order21
			goToTarget(21, tempTarget);
			
			//gather resource order2
			while (order == 2) {
				Point aroundTarget = null;
				if (PR.map.getFirstLayer()[tempTarget.y-1][tempTarget.x] == 0) {
					aroundTarget = new Point(tempTarget.x, tempTarget.y-1);
				}
				else if(PR.map.getFirstLayer()[tempTarget.y-1][tempTarget.x-1] == 0){
					aroundTarget = new Point(tempTarget.x-1, tempTarget.y-1);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y][tempTarget.x-1] == 0) {
					aroundTarget = new Point(tempTarget.x-1, tempTarget.y);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y+1][tempTarget.x-1] == 0) {
					aroundTarget = new Point(tempTarget.x-1, tempTarget.y+1);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y+1][tempTarget.x] == 0) {
					aroundTarget = new Point(tempTarget.x, tempTarget.y+1);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y+1][tempTarget.x+1] == 0) {
					aroundTarget = new Point(tempTarget.x+1, tempTarget.y+1);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y][tempTarget.x+1] == 0) {
					aroundTarget = new Point(tempTarget.x+1, tempTarget.y);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y-1][tempTarget.x+1] == 0) {
					aroundTarget = new Point(tempTarget.x+1, tempTarget.y-1);
				}
				goToTarget(2, aroundTarget);
				PR.pickLoadFishingShip(this, 7, 2, tempTarget);
				aroundTarget = PR.nearPortAddress();
				goToTarget(2, aroundTarget);
				PR.unloadFishingShip(this);	
				
			}

			//gather resource order22
			while (order == 22) {
				Point aroundTarget = null;
				if (PR.map.getFirstLayer()[tempTarget.y-1][tempTarget.x] == 0) {
					aroundTarget = new Point(tempTarget.x, tempTarget.y-1);
				}
				else if(PR.map.getFirstLayer()[tempTarget.y-1][tempTarget.x-1] == 0){
					aroundTarget = new Point(tempTarget.x-1, tempTarget.y-1);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y][tempTarget.x-1] == 0) {
					aroundTarget = new Point(tempTarget.x-1, tempTarget.y);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y+1][tempTarget.x-1] == 0) {
					aroundTarget = new Point(tempTarget.x-1, tempTarget.y+1);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y+1][tempTarget.x] == 0) {
					aroundTarget = new Point(tempTarget.x, tempTarget.y+1);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y+1][tempTarget.x+1] == 0) {
					aroundTarget = new Point(tempTarget.x+1, tempTarget.y+1);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y][tempTarget.x+1] == 0) {
					aroundTarget = new Point(tempTarget.x+1, tempTarget.y);
				}
				else if (PR.map.getFirstLayer()[tempTarget.y-1][tempTarget.x+1] == 0) {
					aroundTarget = new Point(tempTarget.x+1, tempTarget.y-1);
				}
				goToTarget(22, aroundTarget);
				PR.pickLoadFishingShip(this, 7, 22, tempTarget);
				aroundTarget = PR.nearPortAddress();
				goToTarget(22, aroundTarget);
				PR.unloadFishingShip(this);	
				
			}
			
			
		}
	}

	public Point getCurrentTile() {
		return currentTile;
	}

	private void goToTarget(int currentOrder, Point target) {
		Point temp ;
		path = PR.findPath(new Point(gameCube.cube[gameCube.ClientNumber-1][index][0],gameCube.cube[gameCube.ClientNumber-1][index][1]), target , 0);
		int targetY, targetX;
		gameCube.cube[gameCube.ClientNumber-1][index][3] = 5;
		PR.getClient().sendMap(gameCube.ClientNumber-1,index,3,5,   -1,0,0);
		while(!path.isEmpty()  && order == currentOrder){    
			temp = path.pop();
			if(temp.x == currentTile.x - 1 &&  temp.y == currentTile.y - 1){
				gameCube.cube[gameCube.ClientNumber-1][index][4] = 0 ;
				PR.getClient().sendMap(gameCube.ClientNumber-1,index,4,0,   -1,0,0);
				//move from center to center
				targetY = gameCube.cube[gameCube.ClientNumber-1][index][1] - Map.getTileSize();
				while(gameCube.cube[gameCube.ClientNumber-1][index][1] != targetY){
					gameCube.cube[gameCube.ClientNumber-1][index][1] -= PR.getYstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,1,gameCube.cube[gameCube.ClientNumber-1][index][1],   -1,0,0);
					d = System.currentTimeMillis();
					while (d+PR.monthSpeed()>System.currentTimeMillis());
					nextFrame();
				}
				
				currentTile = temp;
			}
			else if(temp.x == currentTile.x - 1 && temp.y == currentTile.y){
				gameCube.cube[gameCube.ClientNumber-1][index][4] = 1 ;
				PR.getClient().sendMap(gameCube.ClientNumber-1,index,4,1,   -1,0,0);
				//move from center to center
				targetY = gameCube.cube[gameCube.ClientNumber-1][index][1] - Map.getTileSize()/2 ;
				while(gameCube.cube[gameCube.ClientNumber-1][index][1] != targetY ){
					gameCube.cube[gameCube.ClientNumber-1][index][1] -= PR.getYstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,1,gameCube.cube[gameCube.ClientNumber-1][index][1],   -1,0,0);
					gameCube.cube[gameCube.ClientNumber-1][index][0] -= PR.getXstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,0,gameCube.cube[gameCube.ClientNumber-1][index][0],   -1,0,0);
					d = System.currentTimeMillis();
					while (d+PR.monthSpeed()>System.currentTimeMillis());
					nextFrame();
				}
				
				currentTile = temp ;
			}
			else if(temp.x == currentTile.x - 1 && temp.y == currentTile.y + 1){
				gameCube.cube[gameCube.ClientNumber-1][index][4] = 2;
				PR.getClient().sendMap(gameCube.ClientNumber-1,index,4,2,   -1,0,0);
				//move from center to center
				targetX = gameCube.cube[gameCube.ClientNumber-1][index][0] - Map.getTileSize()*2;
				while(gameCube.cube[gameCube.ClientNumber-1][index][0] != targetX ){
					gameCube.cube[gameCube.ClientNumber-1][index][0] -= PR.getXstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,0,gameCube.cube[gameCube.ClientNumber-1][index][0],   -1,0,0);
					d = System.currentTimeMillis();
					while (d+PR.monthSpeed()>System.currentTimeMillis());
					nextFrame();
				}
				currentTile = temp;
			}
			else if(temp.x == currentTile.x  && temp.y == currentTile.y - 1){
				gameCube.cube[gameCube.ClientNumber-1][index][4] = 7 ;
				PR.getClient().sendMap(gameCube.ClientNumber-1,index,4,7,   -1,0,0);
				//move from center to center
				targetX = gameCube.cube[gameCube.ClientNumber-1][index][0] + Map.getTileSize();
				while(gameCube.cube[gameCube.ClientNumber-1][index][0] != targetX ){
					gameCube.cube[gameCube.ClientNumber-1][index][1] -= PR.getYstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,1,gameCube.cube[gameCube.ClientNumber-1][index][1],   -1,0,0);
					gameCube.cube[gameCube.ClientNumber-1][index][0] += PR.getXstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,0,gameCube.cube[gameCube.ClientNumber-1][index][0],   -1,0,0);
					d = System.currentTimeMillis();
					while (d+PR.monthSpeed()>System.currentTimeMillis());
					nextFrame();
				}
				currentTile = temp;
			}
			else if(temp.x == currentTile.x  && temp.y == currentTile.y + 1){
				gameCube.cube[gameCube.ClientNumber-1][index][4] = 3 ;
				PR.getClient().sendMap(gameCube.ClientNumber-1,index,4,3,   -1,0,0);
				//move from center to center
				targetX = gameCube.cube[gameCube.ClientNumber-1][index][0] - Map.getTileSize();
				while(gameCube.cube[gameCube.ClientNumber-1][index][0] != targetX ){
					gameCube.cube[gameCube.ClientNumber-1][index][1] += PR.getYstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,1,gameCube.cube[gameCube.ClientNumber-1][index][1],   -1,0,0);
					gameCube.cube[gameCube.ClientNumber-1][index][0] -= PR.getXstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,0,gameCube.cube[gameCube.ClientNumber-1][index][0],   -1,0,0);
					d = System.currentTimeMillis();
					while (d+PR.monthSpeed()>System.currentTimeMillis());
					nextFrame();
				}
				currentTile = temp ;
			}
			else if(temp.x == currentTile.x + 1 && temp.y == currentTile.y - 1){
				gameCube.cube[gameCube.ClientNumber-1][index][4] = 6 ;
				PR.getClient().sendMap(gameCube.ClientNumber-1,index,4,6,   -1,0,0);
				//move from center to center
				targetX = gameCube.cube[gameCube.ClientNumber-1][index][0] + Map.getTileSize() * 2;
				while(gameCube.cube[gameCube.ClientNumber-1][index][0] != targetX ){
					gameCube.cube[gameCube.ClientNumber-1][index][0] += PR.getXstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,0,gameCube.cube[gameCube.ClientNumber-1][index][0],   -1,0,0);
					d = System.currentTimeMillis();
					while (d+PR.monthSpeed()>System.currentTimeMillis());
					nextFrame();
				}
				currentTile = temp ;
			}
			else if(temp.x == currentTile.x + 1 && temp.y == currentTile.y ){
				gameCube.cube[gameCube.ClientNumber-1][index][4] = 5 ;
				PR.getClient().sendMap(gameCube.ClientNumber-1,index,4,5,   -1,0,0);
				//move from center to center
				targetX = gameCube.cube[gameCube.ClientNumber-1][index][0] + Map.getTileSize();
				while(gameCube.cube[gameCube.ClientNumber-1][index][0] != targetX ){
					gameCube.cube[gameCube.ClientNumber-1][index][1] += PR.getYstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,1,gameCube.cube[gameCube.ClientNumber-1][index][1],   -1,0,0);
					gameCube.cube[gameCube.ClientNumber-1][index][0] += PR.getXstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,0,gameCube.cube[gameCube.ClientNumber-1][index][0],   -1,0,0);
					d = System.currentTimeMillis();
					while (d+PR.monthSpeed()>System.currentTimeMillis());
					nextFrame();
				}
				currentTile = temp ;
			}
			else if(temp.x == currentTile.x + 1 && temp.y == currentTile.y + 1){
				gameCube.cube[gameCube.ClientNumber-1][index][4] = 4 ;
				PR.getClient().sendMap(gameCube.ClientNumber-1,index,4,4,   -1,0,0);
				//move from center to center
				targetY = gameCube.cube[gameCube.ClientNumber-1][index][1] + Map.getTileSize();
				while(gameCube.cube[gameCube.ClientNumber-1][index][1] != targetY ){
					gameCube.cube[gameCube.ClientNumber-1][index][1] += PR.getYstepSize_human();
					PR.getClient().sendMap(gameCube.ClientNumber-1,index,1,gameCube.cube[gameCube.ClientNumber-1][index][1],   -1,0,0);
					d = System.currentTimeMillis();
					while (d+PR.monthSpeed()>System.currentTimeMillis());
					nextFrame();
				}
				currentTile = temp ;
			}
		}
	}
		
	public int getState() {
		return gameCube.cube[gameCube.ClientNumber-1][index][3];
	}


	public void setState(int state) {
		gameCube.cube[gameCube.ClientNumber-1][index][3] = state;
		PR.getClient().sendMap(gameCube.ClientNumber-1,index,3,state,   -1,0,0);
	}


	public int getLoad() {
		return load;
	}


	public void setLoad(int load) {
		this.load += load;
	}

	public int getX() {
		return gameCube.cube[gameCube.ClientNumber-1][index][0];
	}
	public int getY() {
		return gameCube.cube[gameCube.ClientNumber-1][index][0];
	}

	public void setX(int x) {
		gameCube.cube[gameCube.ClientNumber-1][index][0] = x;
		PR.getClient().sendMap(gameCube.ClientNumber-1,index,0,x,   -1,0,0);
	}
	public void setY(int y) {
		gameCube.cube[gameCube.ClientNumber-1][index][1] = y;
		PR.getClient().sendMap(gameCube.ClientNumber-1,index,1,y,   -1,0,0);
	}
	
	public int nextFrame(){
		if(framecheck<2){
			gameCube.cube[gameCube.ClientNumber-1][index][5]++;
			PR.getClient().sendMap(gameCube.ClientNumber-1,index,5,gameCube.cube[gameCube.ClientNumber-1][index][5],   -1,0,0);
			framecheck = gameCube.cube[gameCube.ClientNumber-1][index][5];
		}
		if(framecheck==2){
			gameCube.cube[gameCube.ClientNumber-1][index][5]--;
			PR.getClient().sendMap(gameCube.ClientNumber-1,index,5,gameCube.cube[gameCube.ClientNumber-1][index][5],   -1,0,0);
			if(gameCube.cube[gameCube.ClientNumber-1][index][5]==0)
				framecheck = gameCube.cube[gameCube.ClientNumber-1][index][5];
		}
		return gameCube.cube[gameCube.ClientNumber-1][index][5];
	}
	
	public void setTrueFrame(){
		gameCube.cube[gameCube.ClientNumber-1][index][5] = 0;
		PR.getClient().sendMap(gameCube.ClientNumber-1,index,5,0,   -1,0,0);
	}
	
	public int getFrameNum() {
		return gameCube.cube[gameCube.ClientNumber-1][index][5];
	}

	public int getDir() {
		return gameCube.cube[gameCube.ClientNumber-1][index][4];
	}
}
