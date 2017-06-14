package network;

import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import maps.Map;

public class Client extends Thread {
	
	private Socket socket ; 
	private ObjectInputStream input ; 
	private ObjectOutputStream output ;
	private int mapSender = 0 ; 
	private Map map ; 
	private String mapCode ; 
	private int ID ;
	private String userName;
	private Server server;
	private int number_of_players ;
	private GameCube gameCube;
	private boolean allConected = false;



	public Client(int mapSender , String userName , String hostName ,Server server ,  int number_of_players  , Map map   ) {//Map map g
		// TODO Auto-generated constructor stub
		this.userName = userName ; 
		this.mapSender = mapSender ;
		this.server = server;
		this.map =map ; 
		this.number_of_players = number_of_players ; 
		this.gameCube =gameCube;
		

		try {
			socket = new Socket(InetAddress.getByName(hostName),5005); //Set hostName by using getHostName();
			output = new ObjectOutputStream(socket.getOutputStream());
			output.flush();
			input = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		byte [] I = new byte[10];//getting id from the server
//		try {
//			input.read(I);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try {
			int i = (int) input.readObject();
			setID(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(getID());
	}
	
	///////////////		sending map functions
	
	public synchronized void sendFirstLayer_and_secondLayer(){
		

		
		
	}
	public synchronized void sendMap( int i , int j , int k , int gameCubeValue , int x,int y , int seconLayerValue ){
		ArrayList<Integer> maps = new ArrayList<>();
		
		maps.add(map.getMap_width());
		maps.add(map.getMap_height());
		
		for(int m =0 ; m<map.getMap_width() ; m++){
			for(int n =0 ;n<map.getMap_height() ; n++){
				
				maps.add(map.getFirstLayer()[m][n]) ;
			}
		}
		
		for(int m =0 ; m<map.getMap_width() ; m++){
			for(int n =0 ; n<map.getMap_height() ; n++){
				
				maps.add(map.getSecondLayer()[m][n]) ;
			}
		}
		
		
		try {
			output.writeObject(maps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		maps.add(i);
		maps.add(j);
		maps.add(k);
		maps.add(gameCubeValue);
		maps.add(x);
		maps.add(y);
		maps.add(seconLayerValue);

		try {
			output.writeObject(maps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	///////////////		receiving map functions	
	
	public void recieveFirstMap(ArrayList<Integer> maps){
		

	}
	
	public synchronized void recieveMap(ArrayList<Integer>maps){
		
		int map_width = maps.get(0);
		maps.remove(0);
		int map_height = maps.get(0);
		maps.remove(0);
		
		
		
		int [][] firstLayer = new int [map_width][map_height];
		
		for(int i =0 ; i<map.getMap_width() ; i++){
			for(int j =0 ; j<map.getMap_height() ; j++){
				
				firstLayer[i][j] = maps.get(0);
				maps.remove(0);
			}
		}
		
		int [][] secondLayer = new int [map_width][map_height];
		
		for(int i =0 ; i<map.getMap_width() ; i++){
			for(int j =0 ; j<map.getMap_height() ; j++){
				
				secondLayer[i][j] = maps.get(0);
				maps.remove(0);
			}
		}

		
		map.setFirstLayer(firstLayer);
		map.setSecondLayer(secondLayer);
		
		map.setMap_width(map_width);
		map.setMap_height(map_height);
		
		map.getMm().calcTileSize();
		map.getMm().calcOffset();
		
		if(maps.get(0) != -1){
			gameCube.cube[maps.get(0)][maps.get(1)][maps.get(2)] = maps.get(3);
		}
		
		if(maps.get(4) != -1){
			map.set_secondLayer_cell(new Point(maps.get(5), maps.get(4)), maps.get(6));
		}
		
		
		
		map.repaint();
	}
		

	
	///////////////

	public String getUserName() {
		return userName;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int  getID() {

		return ID;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public void setNumber_of_players(int number_of_players) {
		this.number_of_players = number_of_players;
		
	}
	
	public boolean isAllConected() {
		return allConected;
	}
	
	
	public void recieve(ArrayList<int [][]> maps ){
		
		map.setFirstLayer(maps.get(0));
		
		map.setSecondLayer(maps.get(1));
		
		
		
		
	}
	
	public void send (){
		
		ArrayList<int [][]>maps  = new ArrayList<>();
		maps.add(map.getFirstLayer());
		maps.add(map.getSecondLayer());
		
		try {
			output.writeObject(maps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(mapSender==1){
			while(server.getLastElement() <number_of_players  ){	// don't forget to make number for refactorable
//				System.out.println("Waiting for all players to join or the map is not set now !");
			}
			
	//		sendMap(-1, 0, 0, 0, -1, 0, 0);
			
			allConected = true;
		}
		

	
		
		
		try {
			//  new game 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		ArrayList<int [][]> maps = new ArrayList<>() ;
		
		while(maps != null){
			try {
				
				maps = (ArrayList<int [][]>) input.readObject();
				
				if(maps != null)
					recieve(maps);
				
	
				
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		int i = 0;
//		while (i != -1){
//			byte [] b = new byte[1600];
//			try {
//				i = input.read(b);
//				if (i != -1) recieveMap(); 
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
	}
	
//	public static void main(String[] args) {
//		server = new Server(4);
//		server.start();
//		(new Thread(new Client(1, "ali", "DESKTOP-IFD82C2" ))).start();
//		client1 = new Client(1, "ali", "DESKTOP-IFD82C2", server );
//		client1.start();
//		client2 = new Client(2, "a", "DESKTOP-IFD82C2", server  );
//		client2.start();
//		client3 = new Client(3, "li", "DESKTOP-IFD82C2", server  );
//		client3.start();
//		client4 = new Client(4, "al", "DESKTOP-IFD82C2", server  );
//		client4.start();
//	}
	



}
