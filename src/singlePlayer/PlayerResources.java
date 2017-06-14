package singlePlayer;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Other.MyTime;
import maps.Map;
import maps.ResourceVector;
import network.Client;
import network.GameCube;
public class PlayerResources{

	//private final int WORKERFREEHOUSE;
	public Worker[] workers;
	public Soldier[] soldiers;
	public Ship[] ships;
	public FishingShip[] Fships;
	public int[] lastIndex;
	//public BuildingHouse[] buildings;
	
	private GameCube gameCube;
	private final int PickResourceDELAY;
	private final int AttackDELAY;
	private final int WORKER_CAPACITY;
	private final int SOLDIER_FOODUSE;
	private final int WORKER_FOODUSE;
	private final int SHIP_CAPACITY;
	private final int SOLDIER_DAMAGEPOINT;
	private final int WORKER_DAMAGEPOINT;
	private int totalIron , totalGold , totalWood , totalFood;
	private final int FISHINGSHIP_CAPACITY ;
	public static Map map;
	private static int [][] mixedLayer;
	private int speedMonth [] ;
	private ResourceVector RV;
	private MyTime myTime;
	private int wW , wH ,sW , sH , fW , fH , shW , shH ;
	private Point castleAddress;
	private Client client;
	public PlayerResources(GameCube gameCube, ResourceVector RV , Map map , MyTime mt, Client client) {
		// TODO Auto-generated constructor stub
		
		this.gameCube = gameCube;
		this.client = client;
		speedMonth = new int[]{200, 200, 200, 240, 240, 240, 320, 320,320,550,550,550};
		WORKER_CAPACITY = 300;
		SOLDIER_FOODUSE = 2 ;
		WORKER_FOODUSE = 1 ;
		SHIP_CAPACITY = 10 ;
		SOLDIER_DAMAGEPOINT = 70;
		WORKER_DAMAGEPOINT = 20;
		AttackDELAY = 500;
		PickResourceDELAY = 500;
		FISHINGSHIP_CAPACITY = 1200;
		mixedLayer = map.exteractMixedLayer();
		this.RV = RV;
		myTime = mt;
		
		workers = new Worker[gameCube.cube[0].length/5];
		soldiers = new Soldier[gameCube.cube[0].length/5];
		ships = new Ship[gameCube.cube[0].length/5];
		Fships = new FishingShip[gameCube.cube[0].length/5];
		lastIndex = new int[5];
		for (int i = 0; i < lastIndex.length; i++) {
			lastIndex[i] = 0;
		}
		
		
		map.setPlayerResource(this);
		
		//findCastleAddress();
	}
	
	public Client getClient() {
		return client;
	}
	
	public static void setMixedLayer(int[][] mixedLayer) {
		PlayerResources.mixedLayer = mixedLayer;
	}
	
	public void findCastleAddress() {

		for (int i = 0; i < map.getSecondLayer().length; i++) {
			for (int j = 0; j < map.getSecondLayer()[0].length; j++) {
				if (map.getSecondLayer()[i][j] == (gameCube.ClientNumber*2*map.MAX_GROUP_CODE + 6))
					castleAddress = new Point(j, i);
					gameCube.cube[gameCube.ClientNumber-1][lastIndex[4] + gameCube.cube[0].length*4/5][0] = j;
					client.sendMap(gameCube.ClientNumber-1,lastIndex[4] + gameCube.cube[0].length*4/5,0,j,   -1,0,0);
					gameCube.cube[gameCube.ClientNumber-1][lastIndex[4] + gameCube.cube[0].length*4/5][1] = i;
					client.sendMap(gameCube.ClientNumber-1,lastIndex[4] + gameCube.cube[0].length*4/5,1,i,   -1,0,0);
					gameCube.cube[gameCube.ClientNumber-1][lastIndex[4] + gameCube.cube[0].length*4/5][2] = 10000;
					client.sendMap(gameCube.ClientNumber-1,lastIndex[4] + gameCube.cube[0].length*4/5,2,10000,   -1,0,0);
					lastIndex[4]++;
					
					j = 10000;
					i = 10000;       //to get out of the loop
					
			}
		}
	}

	public int getYstepSize_human() {
		return map.getTileSize()/20;
	}

	public int getXstepSize_human() {
		return map.getTileSize()/10;
	}


	public int monthSpeed(){
		return speedMonth[myTime.getDate()[1]];
	}

	public int searchForSelfMovingObject(int x , int y ){
		for (int i = 0; i < gameCube.cube[0].length/5; i++) {
			if(x >= gameCube.cube[gameCube.ClientNumber-1][i][0] && x <= gameCube.cube[gameCube.ClientNumber-1][i][0] + wW
					&& y >= gameCube.cube[gameCube.ClientNumber-1][i][1] && y <= gameCube.cube[gameCube.ClientNumber-1][i][1] + wH){
				return i;
			}
		}
		
		for (int i = gameCube.cube[0].length/5; i < gameCube.cube[0].length*2/5; i++) {
			if(x >= gameCube.cube[gameCube.ClientNumber-1][i][0] && x <= gameCube.cube[gameCube.ClientNumber-1][i][0] + sW
					&& y >= gameCube.cube[gameCube.ClientNumber-1][i][1] && y <= gameCube.cube[gameCube.ClientNumber-1][i][1] + sH){
				return i;
			}
		}
		
		for (int i = gameCube.cube[0].length*2/5; i < gameCube.cube[0].length*3/5; i++) {
			if(x >= gameCube.cube[gameCube.ClientNumber-1][i][0] && x <= gameCube.cube[gameCube.ClientNumber-1][i][0] + shW
					&& y >= gameCube.cube[gameCube.ClientNumber-1][i][1] && y <= gameCube.cube[gameCube.ClientNumber-1][i][1] + shH){
				return i;
			}
		}
		
		for (int i = gameCube.cube[0].length*3/5; i < gameCube.cube[0].length*4/5; i++) {
			if(x >= gameCube.cube[gameCube.ClientNumber-1][i][0] && x <= gameCube.cube[gameCube.ClientNumber-1][i][0] + fW
					&& y >= gameCube.cube[gameCube.ClientNumber-1][i][1] && y <= gameCube.cube[gameCube.ClientNumber-1][i][1] + fH){
				return i;
			}
		}
		
		return -1;
	}

	public int searchForOthersMovingObject(int x , int y ){
		for (int j = 0; j < gameCube.cube.length; j++) {
			if (j == gameCube.ClientNumber-1) 
				continue;
		
			for (int i = 0; i < gameCube.cube[0].length; i++) {
				if(x > gameCube.cube[j][i][0] && x < gameCube.cube[j][i][0] + wW
						&& y > gameCube.cube[j][i][1] && y < gameCube.cube[j][i][1] + wH){
					return i + j*gameCube.cube[0].length;
				}
			}
		}
				
		return -1;
	}
	
	public int getSelfBuildingIndex(int x, int y){
		for (int i = gameCube.cube[0].length*4/5; i < gameCube.cube[0].length; i++) {
			if(gameCube.cube[gameCube.ClientNumber-1][i][0] == x && gameCube.cube[gameCube.ClientNumber-1][i][1] == y ){
				return i;
			}
		}
		return -1;
		
	}

	
	public int getwW() {
		return map.getTileSize()*1/10;
	}

	public int getwH() {
		return map.getTileSize()*1/5;
	}

	public int getsW() {
		return map.getTileSize()*1/8;
	}

	public int getsH() {
		return map.getTileSize()*1/4;
	}

	public int getfH() {
		return map.getTileSize()*1/6;
	}

	public int getfW() {
		return map.getTileSize()*1/3;
	}

	public int getShH() {
		return map.getTileSize()*2/5;
	}

	public int getShW() {
		return map.getTileSize()*4/5;
	}

	public void setOrder(char order, int selectedSpriteIndex, Point targetPoint){
		switch (selectedSpriteIndex / 50) {
		case 0:
			switch (order) {
			case 'm'://move to target
				workers[selectedSpriteIndex%50].setTempTarget(targetPoint);
				if(workers[selectedSpriteIndex%50].getOrder() == 21)
					workers[selectedSpriteIndex%50].setOrder(1);
				else 
					workers[selectedSpriteIndex%50].setOrder(21);
				break;

			case 'g'://gatherResource
				workers[selectedSpriteIndex%50].setTempTarget(targetPoint);
				if(workers[selectedSpriteIndex%50].getOrder() == 22)
					workers[selectedSpriteIndex%50].setOrder(2);
				else 
					workers[selectedSpriteIndex%50].setOrder(22);
				break;
				
//			case 'a'://attack
//				if(workers.get(selectedSpriteIndex/10).getOrder() == 21)
//					workers.get(selectedSpriteIndex/10).setOrder(1);
//				else 
//					workers.get(selectedSpriteIndex/10).setOrder(21);
//				break;
//				
//			case 'b'://build
//				if(workers.get(selectedSpriteIndex/10).getOrder() == 21)
//					workers.get(selectedSpriteIndex/10).setOrder(1);
//				else 
//					workers.get(selectedSpriteIndex/10).setOrder(21);
//				break;

			default:
				break;
			}
			break;

		case 1:
			switch (order) {
			case 'm'://move to target
				soldiers[selectedSpriteIndex%50].setTempTarget(targetPoint);
				if(soldiers[selectedSpriteIndex%50].getOrder() == 21)
					soldiers[selectedSpriteIndex%50].setOrder(1);
				else 
					soldiers[selectedSpriteIndex%50].setOrder(21);
				break;

//				case 'a'://attack
//				if(workers.get(selectedSpriteIndex/10).getOrder() == 21)
//					workers.get(selectedSpriteIndex/10).setOrder(1);
//				else 
//					workers.get(selectedSpriteIndex/10).setOrder(21);
//				break;

			default:
				break;
			}
			break;

		case 2:
			switch (order) {
			case 'm'://move to target
				ships[selectedSpriteIndex%50].setTempTarget(targetPoint);
				if(ships[selectedSpriteIndex%50].getOrder() == 21)
					ships[selectedSpriteIndex%50].setOrder(1);
				else 
					ships[selectedSpriteIndex%50].setOrder(21);
				break;

			default:
				break;
			}
			break;
			
		case 3:
			switch (order) {
			case 'm'://move to target
				Fships[selectedSpriteIndex%50].setTempTarget(targetPoint);
				if(Fships[selectedSpriteIndex%50].getOrder() == 21)
					Fships[selectedSpriteIndex%50].setOrder(1);
				else 
					Fships[selectedSpriteIndex%50].setOrder(21);
				break;
				
			case 'g'://gatherResource
				Fships[selectedSpriteIndex%50].setTempTarget(targetPoint);
				if(Fships[selectedSpriteIndex%50].getOrder() == 22)
					Fships[selectedSpriteIndex%50].setOrder(2);
				else 
					Fships[selectedSpriteIndex%50].setOrder(22);
				break;

			default:
				break;
			}
			break;



		default:
			break;
		}


	}

	public void pickLoadWorker(Worker w ,int resourceType, int currentOrder, Point ResourceP){
		int tempIndex = RV.searchForResource(resourceType, ResourceP);
		while(canPickWorker(w.getGoldLoad(), w.getIronLoad() , w.getFoodLoad() , w.getWoodLoad()) && w.getOrder()==currentOrder){
			gameCube.cube[gameCube.ClientNumber-1][w.getIndex()][3] = 0;
			client.sendMap(gameCube.ClientNumber-1,w.getIndex(),3,0,   -1,0,0);
			gatherResourceUnit(resourceType, tempIndex, w);
			long d = System.currentTimeMillis();
			while (d+PickResourceDELAY>System.currentTimeMillis());
		}
	}
	
	
	public void gatherResourceUnit(int resourceType , int index ,Worker w){
		switch (resourceType) {
		case 8:{//tree
			RV.getTree().get(index).setRemindingResource(RV.getTree().get(index).getGiveSpeed());
			w.setWoodLoad(3*RV.getTree().get(index).getGiveSpeed());
		}

		break;

		case 9:{//farm
			RV.getFarm().get(index).setRemindingResource(RV.getFarm().get(index).getGiveSpeed());
			w.setFoodLoad(RV.getFarm().get(index).getGiveSpeed());
		}

		break;

		case 10:{//iron
			RV.getIronMine().get(index).setRemindingResource(RV.getIronMine().get(index).getGiveSpeed());
			w.setIronLoad(4*RV.getIronMine().get(index).getGiveSpeed());
		}

		break;

		case 11:{//gold
			RV.getGoldMine().get(index).setRemindingResource(RV.getGoldMine().get(index).getGiveSpeed());
			w.setGoldLoad(5*RV.getGoldMine().get(index).getGiveSpeed());
		}
		break;

		default:
			break;
		}
	}

	public void pickLoadFishingShip(FishingShip FS ,int resourceType,int currentOrder , Point ResourceP){
		int tempIndex = RV.searchForResource(resourceType, ResourceP);
		while(canPickFishingShip(FS.getLoad()) && FS.getOrder()==currentOrder){
			gameCube.cube[gameCube.ClientNumber-1][FS.getIndex()][3] = 0;
			client.sendMap(gameCube.ClientNumber-1,FS.getIndex(),3,0,   -1,0,0);
			gatherResourceUnitFish(tempIndex, FS);
			long d = System.currentTimeMillis();
			while (d+PickResourceDELAY>System.currentTimeMillis());
		}
	}

	public void gatherResourceUnitFish(int i ,FishingShip fs){
		RV.getFish().get(i).setRemindingResource(RV.getFish().get(i).getGiveSpeed());
		fs.setLoad(1*RV.getFish().get(i).getGiveSpeed());
	}


	public boolean canPickWorker(int GL , int IL , int FL , int WL ) {
		// TODO Auto-generated method stub
		if(GL+IL+FL+WL>=WORKER_CAPACITY)
			return false;
		else
			return true;
	}

	public boolean canPickFishingShip(int FishLoad) {
		// TODO Auto-generated method stub
		if(FishLoad>=FISHINGSHIP_CAPACITY)
			return false;
		else
			return true;
	}

	public void Boarding_ship(Ship sh){
		if(canBoard(sh)){
			sh.pickPassanger();
		}
	}

	public boolean canBoard(Ship sh){
		return sh.canGivePassanger(SHIP_CAPACITY);
	}

//	public void soldierAttack(Soldier self, Worker target){
//		while(target.isAlive() && self.getState() == attacking_state){
//			target.decreaseHealth(SOLDIER_DAMAGEPOINT);
//			long d = System.currentTimeMillis();
//			while (d+AttackDELAY>System.currentTimeMillis());
//		}
//
//	}
//
//	public void soldierAttack(Soldier self, Soldier target){
//		while(target.isAlive() && self.getState() == attacking_state){
//			target.decreaseHealth(SOLDIER_DAMAGEPOINT);
//			long d = System.currentTimeMillis();
//			while (d+AttackDELAY>System.currentTimeMillis());
//		}
//
//	}
//
//	public void soldierAttack(Soldier self, BuildingHouse target){
//		while(target.isAlive() && self.getState() == attacking_state){
//			target.changeHealth(1, SOLDIER_DAMAGEPOINT);
//			long d = System.currentTimeMillis();
//			while (d+AttackDELAY>System.currentTimeMillis());
//		}
//
//	}
//
//	public void workerAttack(Worker self, Worker target){
//		while(target.isAlive() && self.getState() == attacking_state){
//			target.decreaseHealth(WORKER_DAMAGEPOINT);
//			long d = System.currentTimeMillis();
//			while (d+AttackDELAY>System.currentTimeMillis());
//		}
//
//	}
//
//	public void workerAttack(Worker self, Soldier target){
//		while(target.isAlive() && self.getState() == attacking_state){
//			target.decreaseHealth(WORKER_DAMAGEPOINT);
//			long d = System.currentTimeMillis();
//			while (d+AttackDELAY>System.currentTimeMillis());
//		}
//
//	}
//
//	public void workerAttack(Worker self, BuildingHouse target){
//		while(target.isAlive() && self.getState() == attacking_state){
//			target.changeHealth(1, WORKER_DAMAGEPOINT);
//			long d = System.currentTimeMillis();
//			while (d+AttackDELAY>System.currentTimeMillis());
//		}
//
//	}
//
//	public void healBuilding(Worker self, BuildingHouse target) {
//		while(self.getState() == building_state){
//			target.changeHealth(2, WORKER_DAMAGEPOINT);
//			long d = System.currentTimeMillis();
//			while (d+AttackDELAY>System.currentTimeMillis());
//		}
//
//	}
	
	public Point nearCastleAddress(){
		if (map.getFirstLayer()[castleAddress.y-1][castleAddress.x] > 0) {
			return new Point(castleAddress.x, castleAddress.y-1);
		}
		else if(map.getFirstLayer()[castleAddress.y-1][castleAddress.x-1] > 0){
			return new Point(castleAddress.x-1, castleAddress.y-1);
		}
		else if (map.getFirstLayer()[castleAddress.y][castleAddress.x-1] > 0) {
			return new Point(castleAddress.x-1, castleAddress.y);
		}
		else if (map.getFirstLayer()[castleAddress.y+1][castleAddress.x-1] > 0) {
			return new Point(castleAddress.x-1, castleAddress.y+1);
		}
		else if (map.getFirstLayer()[castleAddress.y+1][castleAddress.x] > 0) {
			return new Point(castleAddress.x, castleAddress.y+1);
		}
		else if (map.getFirstLayer()[castleAddress.y+1][castleAddress.x+1] > 0) {
			return new Point(castleAddress.x+1, castleAddress.y+1);
		}
		else if (map.getFirstLayer()[castleAddress.y][castleAddress.x+1] > 0) {
			return new Point(castleAddress.x+1, castleAddress.y);
		}
		else if (map.getFirstLayer()[castleAddress.y-1][castleAddress.x+1] > 0) {
			return new Point(castleAddress.x+1, castleAddress.y-1);
		}
	
		System.out.println("couldnt find land around castle");
		return null;
		
	}
	
	public Point nearPortAddress() {
		return null;
	}
	
	public void unloadFishingShip(FishingShip FS){
			setTotalFood(FS.getLoad());
			FS.setLoad(-FS.getLoad());
			long d = System.currentTimeMillis();
			while (d+PickResourceDELAY>System.currentTimeMillis());
	}
	
	public void unloadWorker(Worker worker){
		gameCube.cube[gameCube.ClientNumber-1][worker.getIndex()][3] = 0;
		client.sendMap(gameCube.ClientNumber-1,worker.getIndex(),3,0,   -1,0,0);
		
		setTotalFood(worker.getFoodLoad());
		worker.setFoodLoad(-worker.getFoodLoad());
		
		setTotalWood(worker.getWoodLoad());
		worker.setWoodLoad(-worker.getWoodLoad());
		
		setTotalIron(worker.getIronLoad());
		worker.setIronLoad(-worker.getIronLoad());
		
		setTotalGold(worker.getGoldLoad());
		worker.setGoldLoad(-worker.getGoldLoad());
		
		long d = System.currentTimeMillis();
		while (d+PickResourceDELAY>System.currentTimeMillis());
}

	public void deCreaseTotalIron(int cost) {
		totalIron -= cost;
	}

	public void deCreaseTotalGOld(int cost) {
		totalGold -= cost;
	}
	
	public void setTotalIron(int totalIron) {
		this.totalIron += totalIron;
	}

	public void setTotalGold(int totalGOld) {
		this.totalGold += totalGOld;
	}


	public void setTotalWood(int totalWOod) {
		this.totalWood += totalWOod;
	}

	public void setTotalFood(int totalFood) {
		this.totalFood += totalFood;
	}

	
	public void consumeWood(int cost) {
		totalWood -= cost;
	}
	
	public void consumeFood(int cost) {
		totalFood -= cost;
	}

	public int getTotalIron() {
		return totalIron;
	}

	public int getTotalGold() {
		return totalGold;
	}

	public int getTotalWood() {
		return totalWood;
	}

	public int getTotalFood() {
		return totalFood;
	}


	public Stack<Point> findPath(Point start , Point end , int type) {
		//do moving beetween two point
		Stack<Point> path = new Stack<>();
		MyPoint p = getPathBFS(map.getTileIndex(map.convert_to_2D(start)),map.getTileIndex(map.convert_to_2D(end)) , type);
		while(p.getParent()!= null){
			path.push(new Point(p.x,p.y));
			p = p.getParent();
		}//pas az in while ma masir ro darim
		return path;
	}


	private static class MyPoint {
		int x;
		int y;
		MyPoint parent;

		public MyPoint(int x, int y, MyPoint parent) {
			this.x = x;
			this.y = y;
			this.parent = parent;
		}

		public MyPoint getParent() {
			return this.parent;
		}

		public String toString() {
			return "x = " + x + " y = " + y;
		}
	}

	public static Queue<MyPoint> q = new LinkedList<MyPoint>();

	public static MyPoint getPathBFS(Point start , Point end , int type) {
		q.add(new MyPoint(start.x,start.y, null));

		while(!q.isEmpty()) {
			MyPoint p = q.remove();

			if (p.x == end.x && p.y == end.y) {
				return p;
			}


			else  if(isFree(p.x+1,p.y+1 , type)) {
				mixedLayer[p.x][p.y] = -1;
				MyPoint nextP = new MyPoint(p.x+1,p.y+1, p);
				q.add(nextP);
			}

			else if(isFree(p.x,p.y+1 , type)) {
				mixedLayer[p.x][p.y] = -1;
				MyPoint nextP = new MyPoint(p.x,p.y+1, p);
				q.add(nextP);               
			}

			else if(isFree(p.x+1,p.y , type)) {
				mixedLayer[p.x][p.y] = -1;
				MyPoint nextP = new MyPoint(p.x+1,p.y, p);
				q.add(nextP);
			}

			else if(isFree(p.x-1,p.y+1 , type)) {
				mixedLayer[p.x][p.y] = -1;
				MyPoint nextP = new MyPoint(p.x-1,p.y+1, p);
				q.add(nextP);
			}

			else if(isFree(p.x-1,p.y , type)) {
				mixedLayer[p.x][p.y] = -1;
				MyPoint nextP = new MyPoint(p.x-1,p.y, p);
				q.add(nextP);
			}



			else if(isFree(p.x,p.y-1 , type)) {
				mixedLayer[p.x][p.y] = -1;
				MyPoint nextP = new MyPoint(p.x,p.y-1, p);
				q.add(nextP);
			}

			else if(isFree(p.x-1,p.y-1 ,type)) {
				mixedLayer[p.x][p.y] = -1;
				MyPoint nextP = new MyPoint(p.x-1,p.y-1, p);
				q.add(nextP);

			}

			else if(isFree(p.x+1,p.y-1 , type)) {
				mixedLayer[p.x][p.y] = -1;
				MyPoint nextP = new MyPoint(p.x+1,p.y-1, p);
				q.add(nextP);
			}

		}
		return null;
	}


	public static boolean isFree(int x, int y , int type) {
		if(type==0){//human Or soldier
			if((x >= 0 && x < mixedLayer.length) && (y >= 0 && y < mixedLayer[x].length) && (mixedLayer[x][y] == 2)) {
				return true;
			}
			return false;
		}
		//		if(type==0){//soldier or soldier have MountionWear
		//			if((x >= 0 && x < mixedLayer.length) && (y >= 0 && y < mixedLayer[x].length) && (mixedLayer[x][y] == 2)) {
		//				return true;
		//			}
		//			return false;
		//		}
		if(type==1){//ships
			if((x >= 0 && x < mixedLayer.length) && (y >= 0 && y < mixedLayer[x].length) && (mixedLayer[x][y] == 1)) {
				return true;
			}
			return false;
		}
		return false;
	}


}
