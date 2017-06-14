package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Server extends Thread {
	
	private ServerSocket ss ; 
	private ObjectInputStream input ; 
	private ObjectOutputStream output ;
	private WorkStation [] workStation ; 
	private  int lastElement = 0 ;
	private int number_of_players;

	public Server(int number_of_players) {
		// TODO Auto-generated constructor stub
		workStation = new WorkStation[number_of_players];
		this.number_of_players = number_of_players;
		
		try {
			ss = new ServerSocket(5005);// port number, MaxClients
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int getNumber_of_players() {
		return number_of_players;
	}
	
	public int getLastElement() {
		return lastElement;
	}
	
	public void execute() {
		while (lastElement<workStation.length) {
			try {
				Socket client = ss.accept();
				WorkStation w = new WorkStation(client, this);
				workStation[lastElement] = w;
				lastElement++;
				w.output.writeObject(lastElement);

				w.start();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void sendToAll(ArrayList<int [][] > maps) {
		for (int i = 0 ; i <lastElement ;i++) {
			try {
				workStation[i].output.writeObject(maps);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	





	

//	public static void main(String[] args) {	//just for test
//		new Server(1).execute();
//	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		execute();
		
	}
	


}
