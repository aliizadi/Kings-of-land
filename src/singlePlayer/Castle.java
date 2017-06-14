package singlePlayer;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import Other.MyTime;
import maps.LoadForMulti;
import maps.Map;
import secondLayerObject.LayerObject2;

public class Castle implements  LayerObject2 , BuildingHouse{
	private int [][]temp_firstLayer;
	private ArrayList<ArrayList<Point>>  edge  ;
	private boolean [][]  check_put_castle;
	private int [][] edge1;
	private Map map;
	private int numberOfPlayers;
	private ImageIcon img ; 
	private final int castle_code = 11;
	private boolean [][]in_the_islands;
	private int [] distance_with_put_castle;
	public  final int MAX_GROUP_CODE = 7;

	private int health;
	private int goldContent,ironContent,woodContent,foodContent;//mizan avalie moshakhas shavad
	
	


	public Castle(Map map , int number_of_players ) {
		// TODO Auto-generated constructor stub
		
		img = new ImageIcon("images\\firstLayer\\barracks0.PNG");

		this.map = map;
		this.numberOfPlayers = number_of_players;
		temp_firstLayer = new int [map.getMap_height()][map.getMap_width()];
		edge1 = new int [map.getMap_height()][map.getMap_width()];
		check_put_castle = new boolean [map.getMap_height()][map.getMap_width()];
		in_the_islands = new boolean [map.getMap_height()][map.getMap_width()];
		edge = new ArrayList<>();


		setTemp_firstLayer(map.getFirstLayer().clone());
		

		
		
		int number_of_islands = numberOfIslands();
		
		
		edge = new ArrayList<>();
		for(int i =0 ; i<number_of_islands ; i++){
			edge.add(new ArrayList<Point>());
		}
		
		
		///////////////////////
		
		setTemp_firstLayer(map.getFirstLayer().clone());
		edge1 = setEdge1();
		
		
		setTemp_firstLayer(map.getFirstLayer().clone());

		setEdge(edge1);
	
		

		
		
		
		///////////////////////
		
		set_map_location(number_of_players, number_of_islands);
		
//		for(int i =0 ; i<check_put_castle.length ;  i++){
//			for(int j =0 ; j<check_put_castle[i].length ; j++){
//				if(check_put_castle[i][j])
//					System.out.println(i+":wd"+j);
//
//			}
//		}
		map.repaint();

		
		
			
		

	}
	
	private void setTemp_firstLayer(int [][] temps_firstLayer){
		
		for(int i =0 ; i<temps_firstLayer.length ; i++){
			for(int j =0 ; j<temps_firstLayer[i].length; j++){
				
				if(map.getFirstLayer()[i][j]/map.getMax_tile_code()>0){
					this.temp_firstLayer[i][j] = 1;
				}
				else
					this.temp_firstLayer[i][j] = 0;
			}
		}
	}


	private int[][] setEdge1(){
				
		for(int i =0 ; i <temp_firstLayer.length ; i++){
			for(int j =0 ; j<temp_firstLayer[i].length ; j++){
				
				if(temp_firstLayer[i][j]!=0){
					detect_edge_of_island(temp_firstLayer, i, j, temp_firstLayer.length, temp_firstLayer[i].length );
				}
			}
		}
		

		int [][] temp = new int [map.getMap_height()][map.getMap_width()];
		for(int i =0 ; i<edge1.length ; i++){
			for(int j =0 ; j<edge1.length ; j++){
				if(i-1>=0&&j-1>=0){
					if(edge1[i][j]==1&&edge1[i-1][j-1]==1&&in_the_islands[i][j-1]==true)
						temp[i][j-1] = 1;
				}
				if(i+1<edge1.length&&j-1>=0){
					if(edge1[i][j]==1&&edge1[i+1][j-1]==1&&in_the_islands[i+1][j]==true)
						temp[i+1][j] = 1;
				}
				if(i+1<edge1.length&&j+1<edge1.length){
					if(edge1[i][j]==1&&edge1[i+1][j+1]==1&&in_the_islands[i][j+1]==true)
						temp[i][j+1] = 1;
				}
				if(i-1>=0&&j+1<edge1.length){
					if(edge1[i][j]==1&&edge1[i-1][j+1]==1&&in_the_islands[i-1][j]==true)
						temp[i-1][j] = 1;
				}		
			}
		}
		
		for(int i =0 ; i<temp.length ; i++){
			for(int j =0 ; j<temp[i].length ; j++){
				if(temp[i][j]==1)
					edge1[i][j]=1;
			}
		}
		
		return edge1 ;
	}
	
	private ArrayList<ArrayList<Point>> setEdge(int [][] edge1){
		int island_number =0 ; 
		for(int i =0 ; i <edge1.length ; i++){
			for(int j =0 ; j<edge1[i].length ; j++){
				
				if(detectIslandedge_for_edge1(edge1, false ,i,j,edge1.length-1, edge1[i].length-1,island_number))
					island_number++;
			}
		}
		return edge;
	}
	
	private int numberOfIslands(){
		int number_of_islands =0 ; 
		
		for(int i =0 ; i <temp_firstLayer.length ; i++){
			for(int j =0 ; j<temp_firstLayer[i].length ; j++){
				
				if(detectIsland(temp_firstLayer, false ,i,j,temp_firstLayer.length-1, temp_firstLayer[i].length-1))
					number_of_islands++;
					
			}
		}
		return number_of_islands;
	}
	
	private boolean detectIslandedge_for_edge1(int [][] edg1,boolean islandDetected,int i,int j  , int  iMax,	int jMax, int island_number) {

		if (i > iMax || j > jMax || i < 0 || j < 0 || edg1[i][j] == 0){

			return islandDetected;
		}

		else {

			edge.get(island_number).add(new Point(j, i));
			edg1[i][j] = 0;
			
			islandDetected = true;	

			detectIslandedge_for_edge1(edg1, islandDetected, i - 1, j,iMax, jMax , island_number);
			detectIslandedge_for_edge1(edg1, islandDetected, i, j - 1,iMax, jMax,island_number);
			detectIslandedge_for_edge1(edg1, islandDetected, i + 1, j,iMax, jMax,island_number);
			detectIslandedge_for_edge1(edg1, islandDetected, i, j + 1,iMax, jMax,island_number);

		}


		return islandDetected;
	}
	
	private boolean detectIsland(int [][] tempMatrix,boolean islandDetected,int i,int j  , int  iMax,	int jMax) {

		if (i > iMax || j > jMax || i < 0 || j < 0 || tempMatrix[i][j] == 0){

			return islandDetected;
		}

		else {

			tempMatrix[i][j] = 0;

			islandDetected = true;	

			detectIsland(tempMatrix, islandDetected, i - 1, j,iMax, jMax);
			detectIsland(tempMatrix, islandDetected, i, j - 1,iMax, jMax);
			detectIsland(tempMatrix, islandDetected, i + 1, j,iMax, jMax);
			detectIsland(tempMatrix, islandDetected, i, j + 1,iMax, jMax);

		}


		return islandDetected;
	}


	public void detect_edge_of_island(int [][] tempMatrix,int i,int j  , int  iMax,	int jMax ){

		tempMatrix[i][j] = 2 ;
		in_the_islands[i][j] = true;
		
		if(i < iMax && j < jMax && i-1 >= 0 && j >= 0 && tempMatrix[i-1][j] == 1)
			detect_edge_of_island(tempMatrix, i-1, j, iMax, jMax);
		else if(i < iMax && j < jMax && i-1 >= 0 && j >= 0 &&tempMatrix[i-1][j] == 0)
			edge1[i][j] =1;
			
		if(i < iMax && j < jMax && i >= 0 && j-1 >= 0 && tempMatrix[i][j-1] == 1)
			detect_edge_of_island(tempMatrix, i, j-1, iMax, jMax);
		else if(i < iMax && j < jMax && i >= 0 && j-1 >= 0 && tempMatrix[i][j-1] == 0)
			edge1[i][j] =1;
			
		if(i+1 < iMax && j < jMax && i >= 0 && j >= 0 && tempMatrix[i+1][j] == 1)
			detect_edge_of_island(tempMatrix, i+1, j, iMax, jMax);
		else if(i+1 < iMax && j < jMax && i >= 0 && j >= 0 &&tempMatrix[i+1][j] == 0)
		edge1[i][j] =1;
		
		if(i < iMax && j+1 < jMax && i >= 0 && j >= 0 && tempMatrix[i][j+1] == 1)
			detect_edge_of_island(tempMatrix, i, j+1, iMax, jMax);
		else if(i < iMax && j+1 < jMax && i >= 0 && j >= 0 && tempMatrix[i][j+1] == 0)
		edge1[i][j] =1;
		
	}
	
	public void find (int tempMatrix , int i , int j , int iMax , int jMax){
		
		
	}
	
	
	private int make_random(int max){
		Random rn = new Random();
		return rn.nextInt(max);
	}
	
	public int calcute_mapCode(int playerNumber){
		return (2*playerNumber+1)*MAX_GROUP_CODE-1;
	}
	
	
	public void set_map_location (int number_of_players , int number_of_islands){ 

		if(number_of_islands>=number_of_players){
			// kenar ab random castle bezar toye jazire random
			
			for(int i =0 ; i<number_of_players ; i++)
			map.set_secondLayer_cell(edge.get(i).get(make_random(edge.get(i).size())),calcute_mapCode(i+1));
	
		}

		else{

			check_island(number_of_islands);
			
			//ye bazikon random ro dar yek jaye random jazireye baghi mande migozarim
			
			int random = make_random(edge.get(0).size());
			map.set_secondLayer_cell(edge.get(0).get(random), calcute_mapCode(numberOfPlayers));
			check_put_castle[edge.get(0).get(random).y][edge.get(0).get(random).x] =true ;
			edge.get(0).remove(random);
			
			put_castle_in_one_island(numberOfPlayers-1);
			
			
//			check_put_castle[edge.get(0).get(0).y][edge.get(0).get(0).x] = true ; 
//			Point p = edge.get(0).get(0);
//			edge.get(0).remove(0);
//			int [] last_distance_with_put_castle = new int [number_of_players-1];
//			distance_with_put_castle = new int [number_of_players-1];
//
//			put_castle_in_one_island(numberOfPlayers-1);
//
//
//
//
//
//			for(int i =1 ; i<edge.get(0).size() ; i++){
//
//				int x =1 ; 
//
//				for(int j =0 ; j<distance_with_put_castle.length ; j++){
//					if(distance_with_put_castle[j]>last_distance_with_put_castle[j])
//						x++;
//				}
//
//				if(x==distance_with_put_castle.length){
//					las
//				}
//
//			}
			
					

		}


	}

	
	public void check_island( int number_of_islands){
		if(number_of_islands ==1)
			return;
		else{
			//yeki az caslte dar kooshektarin jazire
			
			
			
			int smallest_island_size = edge.get(0).size();
			int smallest_island_index = 0;
			for(int i =1 ; i<number_of_islands ; i++){
				
				 if(edge.get(i).size()<smallest_island_size){
					 smallest_island_size = edge.get(i).size();
					 smallest_island_index = i ; 
					 
				 }
			}
			
			
			map.set_secondLayer_cell(edge.get(smallest_island_index).get(make_random(edge.get(smallest_island_index).size())),calcute_mapCode(numberOfPlayers) );
			edge.remove(smallest_island_index);
			
			number_of_islands--;
			numberOfPlayers--;
			
			
			check_island(number_of_islands);
			
		}
		
			
	}
	
	public void put_castle_in_one_island(int number_of_players){
		
		if(number_of_players==0)
			return;
		else{
			
			//peydakardan max majmoo gasr ba gasrhaye gozashte shode
			
			
			ArrayList<Point> x = new ArrayList<>();
			
			for(int i =0 ; i<check_put_castle.length ; i++ ){
				
				for(int j =0 ; j<check_put_castle[i].length ; j++){
					
					if(check_put_castle[i][j] == true){
						x.add(new Point(j, i));
						
					}
				}
			}
				
			int distance =0 ;
			for(int i =0 ; i<x.size() ; i++){
				
				distance += (int) Math.sqrt(	Math.pow((edge.get(0).get(0).x) - (x.get(i).x)  , 2)   +   Math.pow((edge.get(0).get(0).y) - (x.get(i).y), 2));

			}
			Point index=new Point(edge.get(0).get(0).x , edge.get(0).get(0).y);
			int index2=0; 
			for(int i =1  ; i<edge.get(0).size() ; i++){
				
				int distance_=0;
				for(int j =0 ; j<x.size() ; j++){
					
					distance_+= (int) Math.sqrt(	Math.pow((edge.get(0).get(i).x) - (x.get(j).x)  , 2)   +   Math.pow((edge.get(0).get(i).y) - (x.get(j).y), 2));

				}
				
				if(distance<distance_){
					distance=distance_;
					index = new Point(edge.get(0).get(i).x,edge.get(0).get(i).y );
					index2 = i;
					
				}
			
				
			}
			
			map.set_secondLayer_cell(index, calcute_mapCode(number_of_players));
			check_put_castle[index.y][index.x]  = true;
			edge.get(0).remove(index2);
			
			
			
			number_of_players--;
			
			put_castle_in_one_island(number_of_players);

			
			
		}
	}
	


	public Image getImg() {
		// TODO Auto-generated method stub
		return img.getImage();
	}




	@Override
	public void setMyTime(MyTime myTime) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void changeHealth(int enemyORown, int damagePoint){
	//make if for our human positive damage and for enemy negative damage
	//number for own is 1 for other enemy 2
		if(enemyORown==1){
			health -= damagePoint;
			destroy(!isAlive());
		}
		
		if(enemyORown==2){
			health +=damagePoint;
		}
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		if(health<1){
			return false;
		}
		else
			return true;
	}
	
	@Override
	public void destroy(boolean hp) {
		//dar inja khane mored nazar nabood va namaiesh dadan on motevaghef mishavad
		
	}


}
