package network;



public class GameCube {
	public int[][][] cube;
	public int ClientNumber;
	
	public GameCube() {
		// TODO Auto-generated constructor stub
		cube = new int[4][250][6];
		
		ClientNumber = 1;
		
		for (int i = 0; i < cube.length; i++) {
			for (int i2 = 0; i2 < cube[0].length; i2++) {
				for (int i3 = 0; i3 < cube[0][0].length; i3++) {
					cube[i][i2][i3] = -1;
				}
			}
		}
		

	}
	
	
	
}
