package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class WorkStation extends Thread{
	
	private Server s ; 
	private Socket client ;
	public ObjectInputStream input ; 
	public ObjectOutputStream output ;

	public WorkStation(Socket client  , Server s) {
		// TODO Auto-generated constructor stub
		
		this.client = client ; 
		this.s = s ;

		try {
			output =  new ObjectOutputStream(client.getOutputStream());
			output.flush();
			input =  new ObjectInputStream(client.getInputStream());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Server getS() {
		return s;
	}
	


	@Override
	public void run() {

		// TODO Auto-generated method stub
		boolean flag = false;
		while (!flag) {
			try {
				 ArrayList<int [][] > maps =   (ArrayList<int [][] > ) input.readObject();
				
				if (maps == null) {
					flag = true;
					continue;
				}
				
				s.sendToAll(maps);

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					input.close();
					output.close();
					client.close();
					flag = true ;
					break;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
			
	}

}
