package firstLayerObject;

import java.awt.Image;

import javax.swing.ImageIcon;

import Other.MyTime;

public class LowGround implements LayerObject{
	private ImageIcon[] img;
	private ImageIcon [] img2; 
	private ImageIcon [][] seasons ; 
	private MyTime myTime;

	public LowGround() {
		// TODO Auto-generated constructor stub
		
		seasons = new ImageIcon[12][81];
		img = new ImageIcon [81];
		img2 = new ImageIcon[81];
		
		//low ground in center vs sea 
		img[0] = new ImageIcon("images\\firstLayer\\1b0\\1-0000.PNG");
		img[1] = new ImageIcon("images\\firstLayer\\1b0\\1-1000.PNG");
		img[3] = new ImageIcon("images\\firstLayer\\1b0\\1-0100.PNG");
		img[4] = new ImageIcon("images\\firstLayer\\1b0\\1-1100.PNG");
		img[9] = new ImageIcon("images\\firstLayer\\1b0\\1-0010.PNG");
		img[10] = new ImageIcon("images\\firstLayer\\1b0\\1-1010.PNG");
		img[12] = new ImageIcon("images\\firstLayer\\1b0\\1-0110.PNG");
		img[13] = new ImageIcon("images\\firstLayer\\1b0\\1-1110.PNG");
		img[27] = new ImageIcon("images\\firstLayer\\1b0\\1-0001.PNG");
		img[28] = new ImageIcon("images\\firstLayer\\1b0\\1-1001.PNG");
		img[30] = new ImageIcon("images\\firstLayer\\1b0\\1-0101.PNG");
		img[31] = new ImageIcon("images\\firstLayer\\1b0\\1-1101.PNG");
		img[36] = new ImageIcon("images\\firstLayer\\1b0\\1-0011.PNG");
		img[37] = new ImageIcon("images\\firstLayer\\1b0\\1-1011.PNG");
		img[39] = new ImageIcon("images\\firstLayer\\1b0\\1-0111.PNG");
		img[40] = new ImageIcon("images\\firstLayer\\1b0\\1-1111.PNG");
		
		//low ground in center vs high ground and sea
		img[2] = new ImageIcon("images\\firstLayer\\1b0\\1-1000.PNG");	//2000
		img[6] = new ImageIcon("images\\firstLayer\\1b0\\1-0100.PNG");	//0200	
		img[5] = new ImageIcon("images\\firstLayer\\1b0\\1-1100.PNG");	//2100
		img[7] = new ImageIcon("images\\firstLayer\\1b0\\1-1100.PNG");	//1200
		img[8] = new ImageIcon("images\\firstLayer\\1b0\\1-1100.PNG");	//2200
		img[18] = new ImageIcon("images\\firstLayer\\1b0\\1-0010.PNG");	//0020
		img[11] = new ImageIcon("images\\firstLayer\\1b0\\1-1010.PNG");	//2010
		img[19] = new ImageIcon("images\\firstLayer\\1b0\\1-1010.PNG");	//1020
		img[20] = new ImageIcon("images\\firstLayer\\1b0\\1-1010.PNG");	//2020
		img[15] = new ImageIcon("images\\firstLayer\\1b0\\1-0110.PNG");	//0210
		img[21] = new ImageIcon("images\\firstLayer\\1b0\\1-0110.PNG");	//0120
		img[24] = new ImageIcon("images\\firstLayer\\1b0\\1-0110.PNG");	//0220
		img[14] = new ImageIcon("images\\firstLayer\\1b0\\1-1110.PNG");	//2110
		img[16] = new ImageIcon("images\\firstLayer\\1b0\\1-1110.PNG");	//1210
		img[22] = new ImageIcon("images\\firstLayer\\1b0\\1-1110.PNG");	//1120
		img[17] = new ImageIcon("images\\firstLayer\\1b0\\1-1110.PNG");	//2210
		img[23] = new ImageIcon("images\\firstLayer\\1b0\\1-1110.PNG");	//2120
		img[25] = new ImageIcon("images\\firstLayer\\1b0\\1-1110.PNG");	//1220
		img[26] = new ImageIcon("images\\firstLayer\\1b0\\1-1110.PNG");	//2220
		img[54] = new ImageIcon("images\\firstLayer\\1b0\\1-0001.PNG");	//0002
		img[29] = new ImageIcon("images\\firstLayer\\1b0\\1-1001.PNG");	//2001
		img[55] = new ImageIcon("images\\firstLayer\\1b0\\1-1001.PNG");	//1002
		img[56] = new ImageIcon("images\\firstLayer\\1b0\\1-1001.PNG");	//2002
		img[33] = new ImageIcon("images\\firstLayer\\1b0\\1-0101.PNG");	//0201
		img[57] = new ImageIcon("images\\firstLayer\\1b0\\1-0101.PNG");	//0102
		img[60] = new ImageIcon("images\\firstLayer\\1b0\\1-0101.PNG");	//0202
		img[32] = new ImageIcon("images\\firstLayer\\1b0\\1-1101.PNG");	//2101
		img[34] = new ImageIcon("images\\firstLayer\\1b0\\1-1101.PNG");	//1201
		img[58] = new ImageIcon("images\\firstLayer\\1b0\\1-1101.PNG");	//1102
		img[35] = new ImageIcon("images\\firstLayer\\1b0\\1-1101.PNG");	//2201
		img[59] = new ImageIcon("images\\firstLayer\\1b0\\1-1101.PNG");	//2102
		img[61] = new ImageIcon("images\\firstLayer\\1b0\\1-1101.PNG");	//1202
		img[62] = new ImageIcon("images\\firstLayer\\1b0\\1-1101.PNG");	//2202
		img[45] = new ImageIcon("images\\firstLayer\\1b0\\1-0011.PNG");	//0021
		img[63] = new ImageIcon("images\\firstLayer\\1b0\\1-0011.PNG");	//0012
		img[72] = new ImageIcon("images\\firstLayer\\1b0\\1-0011.PNG");	//0022
		img[38] = new ImageIcon("images\\firstLayer\\1b0\\1-1011.PNG");	//2011
		img[46] = new ImageIcon("images\\firstLayer\\1b0\\1-1011.PNG");	//1021
		img[64] = new ImageIcon("images\\firstLayer\\1b0\\1-1011.PNG");	//1012
		img[47] = new ImageIcon("images\\firstLayer\\1b0\\1-1011.PNG");	//2021
		img[65] = new ImageIcon("images\\firstLayer\\1b0\\1-1011.PNG");	//2012
		img[73] = new ImageIcon("images\\firstLayer\\1b0\\1-1011.PNG");	//1022
		img[74] = new ImageIcon("images\\firstLayer\\1b0\\1-1011.PNG");	//2022
		img[42] = new ImageIcon("images\\firstLayer\\1b0\\1-0111.PNG");	//0211
		img[48] = new ImageIcon("images\\firstLayer\\1b0\\1-0111.PNG");	//0121
		img[66] = new ImageIcon("images\\firstLayer\\1b0\\1-0111.PNG");	//0112
		img[51] = new ImageIcon("images\\firstLayer\\1b0\\1-0111.PNG");	//0221
		img[69] = new ImageIcon("images\\firstLayer\\1b0\\1-0111.PNG");	//0212
		img[75] = new ImageIcon("images\\firstLayer\\1b0\\1-0111.PNG");	//0122
		img[78] = new ImageIcon("images\\firstLayer\\1b0\\1-0111.PNG");	//0222
		img[41] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");	
		img[43] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[44] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[49] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[50] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[52] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[53] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[67] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[68] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[70] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[71] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[76] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[77] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[79] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		img[80] = new ImageIcon("images\\firstLayer\\1b2\\1-1111.PNG");
		
		//winter 
		//low ground in center vs sea 
		img2[0] = new ImageIcon("images\\firstLayer\\1b0\\1-0000i.PNG");
		img2[1] = new ImageIcon("images\\firstLayer\\1b0\\1-1000i.PNG");
		img2[3] = new ImageIcon("images\\firstLayer\\1b0\\1-0100i.PNG");
		img2[4] = new ImageIcon("images\\firstLayer\\1b0\\1-1100i.PNG");
		img2[9] = new ImageIcon("images\\firstLayer\\1b0\\1-0010i.PNG");
		img2[10] = new ImageIcon("images\\firstLayer\\1b0\\1-1010i.PNG");
		img2[12] = new ImageIcon("images\\firstLayer\\1b0\\1-0110i.PNG");
		img2[13] = new ImageIcon("images\\firstLayer\\1b0\\1-1110i.PNG");
		img2[27] = new ImageIcon("images\\firstLayer\\1b0\\1-0001i.PNG");
		img2[28] = new ImageIcon("images\\firstLayer\\1b0\\1-1001i.PNG");
		img2[30] = new ImageIcon("images\\firstLayer\\1b0\\1-0101i.PNG");
		img2[31] = new ImageIcon("images\\firstLayer\\1b0\\1-1101i.PNG");
		img2[36] = new ImageIcon("images\\firstLayer\\1b0\\1-0011i.PNG");
		img2[37] = new ImageIcon("images\\firstLayer\\1b0\\1-1011i.PNG");
		img2[39] = new ImageIcon("images\\firstLayer\\1b0\\1-0111i.PNG");
		img2[40] = new ImageIcon("images\\firstLayer\\1b0\\1-1111i.PNG");
		
		//low ground in center vs high ground and sea
		img2[2] = new ImageIcon("images\\firstLayer\\1b0\\1-1000i.PNG");	//2000
		img2[6] = new ImageIcon("images\\firstLayer\\1b0\\1-0100i.PNG");	//0200	
		img2[5] = new ImageIcon("images\\firstLayer\\1b0\\1-1100i.PNG");	//2100
		img2[7] = new ImageIcon("images\\firstLayer\\1b0\\1-1100i.PNG");	//1200
		img2[8] = new ImageIcon("images\\firstLayer\\1b0\\1-1100i.PNG");	//2200
		img2[18] = new ImageIcon("images\\firstLayer\\1b0\\1-0010i.PNG");	//0020
		img2[11] = new ImageIcon("images\\firstLayer\\1b0\\1-1010i.PNG");	//2010
		img2[19] = new ImageIcon("images\\firstLayer\\1b0\\1-1010i.PNG");	//1020
		img2[20] = new ImageIcon("images\\firstLayer\\1b0\\1-1010i.PNG");	//2020
		img2[15] = new ImageIcon("images\\firstLayer\\1b0\\1-0110i.PNG");	//0210
		img2[21] = new ImageIcon("images\\firstLayer\\1b0\\1-0110i.PNG");	//0120
		img2[24] = new ImageIcon("images\\firstLayer\\1b0\\1-0110i.PNG");	//0220
		img2[14] = new ImageIcon("images\\firstLayer\\1b0\\1-1110i.PNG");	//2110
		img2[16] = new ImageIcon("images\\firstLayer\\1b0\\1-1110i.PNG");	//1210
		img2[22] = new ImageIcon("images\\firstLayer\\1b0\\1-1110i.PNG");	//1120
		img2[17] = new ImageIcon("images\\firstLayer\\1b0\\1-1110i.PNG");	//2210
		img2[23] = new ImageIcon("images\\firstLayer\\1b0\\1-1110i.PNG");	//2120
		img2[25] = new ImageIcon("images\\firstLayer\\1b0\\1-1110i.PNG");	//1220
		img2[26] = new ImageIcon("images\\firstLayer\\1b0\\1-1110i.PNG");	//2220
		img2[54] = new ImageIcon("images\\firstLayer\\1b0\\1-0001i.PNG");	//0002
		img2[29] = new ImageIcon("images\\firstLayer\\1b0\\1-1001i.PNG");	//2001
		img2[55] = new ImageIcon("images\\firstLayer\\1b0\\1-1001i.PNG");	//1002
		img2[56] = new ImageIcon("images\\firstLayer\\1b0\\1-1001i.PNG");	//2002
		img2[33] = new ImageIcon("images\\firstLayer\\1b0\\1-0101i.PNG");	//0201
		img2[57] = new ImageIcon("images\\firstLayer\\1b0\\1-0101i.PNG");	//0102
		img2[60] = new ImageIcon("images\\firstLayer\\1b0\\1-0101i.PNG");	//0202
		img2[32] = new ImageIcon("images\\firstLayer\\1b0\\1-1101i.PNG");	//2101
		img2[34] = new ImageIcon("images\\firstLayer\\1b0\\1-1101i.PNG");	//1201
		img2[58] = new ImageIcon("images\\firstLayer\\1b0\\1-1101i.PNG");	//1102
		img2[35] = new ImageIcon("images\\firstLayer\\1b0\\1-1101i.PNG");	//2201
		img2[59] = new ImageIcon("images\\firstLayer\\1b0\\1-1101i.PNG");	//2102
		img2[61] = new ImageIcon("images\\firstLayer\\1b0\\1-1101i.PNG");	//1202
		img2[62] = new ImageIcon("images\\firstLayer\\1b0\\1-1101i.PNG");	//2202
		img2[45] = new ImageIcon("images\\firstLayer\\1b0\\1-0011i.PNG");	//0021
		img2[63] = new ImageIcon("images\\firstLayer\\1b0\\1-0011i.PNG");	//0012
		img2[72] = new ImageIcon("images\\firstLayer\\1b0\\1-0011i.PNG");	//0022
		img2[38] = new ImageIcon("images\\firstLayer\\1b0\\1-1011i.PNG");	//2011
		img2[46] = new ImageIcon("images\\firstLayer\\1b0\\1-1011i.PNG");	//1021
		img2[64] = new ImageIcon("images\\firstLayer\\1b0\\1-1011i.PNG");	//1012
		img2[47] = new ImageIcon("images\\firstLayer\\1b0\\1-1011i.PNG");	//2021
		img2[65] = new ImageIcon("images\\firstLayer\\1b0\\1-1011i.PNG");	//2012
		img2[73] = new ImageIcon("images\\firstLayer\\1b0\\1-1011i.PNG");	//1022
		img2[74] = new ImageIcon("images\\firstLayer\\1b0\\1-1011i.PNG");	//2022
		img2[42] = new ImageIcon("images\\firstLayer\\1b0\\1-0111i.PNG");	//0211
		img2[48] = new ImageIcon("images\\firstLayer\\1b0\\1-0111i.PNG");	//0121
		img2[66] = new ImageIcon("images\\firstLayer\\1b0\\1-0111i.PNG");	//0112
		img2[51] = new ImageIcon("images\\firstLayer\\1b0\\1-0111i.PNG");	//0221
		img2[69] = new ImageIcon("images\\firstLayer\\1b0\\1-0111i.PNG");	//0212
		img2[75] = new ImageIcon("images\\firstLayer\\1b0\\1-0111i.PNG");	//0122
		img2[78] = new ImageIcon("images\\firstLayer\\1b0\\1-0111i.PNG");	//0222
		img2[41] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");	
		img2[43] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[44] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[49] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[50] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[52] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[53] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[67] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[68] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[70] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[71] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[76] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[77] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[79] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		img2[80] = new ImageIcon("images\\firstLayer\\1b2\\1-1111i.PNG");
		
		//set seasons image
		for(int i =0 ; i<8 ; i++)
			seasons[i] = img;
		for(int i =8; i<12 ; i++)
			seasons[i] = img2;
		
	}
	
	@Override
	public void setMyTime(MyTime myTime) {
		this.myTime = myTime;
	}

	@Override
	public Image getImg(int code) {
		// TODO Auto-generated method stub
		return seasons[myTime.getDate()[1]][code].getImage();
	}

}
