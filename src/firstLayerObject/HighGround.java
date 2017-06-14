package firstLayerObject;

import java.awt.Image;

import javax.swing.ImageIcon;

import Other.MyTime;

public class HighGround implements LayerObject {
	private ImageIcon[] img;
	private ImageIcon [] img2; 
	private ImageIcon [][] seasons ; 
	private MyTime myTime;
	
	public HighGround() {
		// TODO Auto-generated constructor stub
		
		seasons = new ImageIcon[12][81];
		img = new ImageIcon [81];
		img2 = new ImageIcon[81];
		
		img[0] = new ImageIcon("images\\firstLayer\\2b0\\2-0000.PNG");
		img[2] = new ImageIcon("images\\firstLayer\\2b0\\2-2000.PNG");
		img[6] = new ImageIcon("images\\firstLayer\\2b0\\2-0200.PNG");
		img[8] = new ImageIcon("images\\firstLayer\\2b0\\2-2200.PNG");
		img[18] = new ImageIcon("images\\firstLayer\\2b0\\2-0020.PNG");
		img[20] = new ImageIcon("images\\firstLayer\\2b0\\2-2020.PNG");
		img[24] = new ImageIcon("images\\firstLayer\\2b0\\2-0220.PNG");
		img[26] = new ImageIcon("images\\firstLayer\\2b0\\2-2220.PNG");
		img[54] = new ImageIcon("images\\firstLayer\\2b0\\2-0002.PNG");
		img[56] = new ImageIcon("images\\firstLayer\\2b0\\2-2002.PNG");
		img[60] = new ImageIcon("images\\firstLayer\\2b0\\2-0202.PNG");
		img[62] = new ImageIcon("images\\firstLayer\\2b0\\2-2202.PNG");
		img[72] = new ImageIcon("images\\firstLayer\\2b0\\2-0022.PNG");
		img[74] = new ImageIcon("images\\firstLayer\\2b0\\2-2022.PNG");
		img[78] = new ImageIcon("images\\firstLayer\\2b0\\2-0222.PNG");
		img[80] = new ImageIcon("images\\firstLayer\\2b0\\2-2222.PNG");
		
		//high ground in center vs low ground 
		img[40] = new ImageIcon("images\\firstLayer\\2b1\\2-1111.PNG");
		img[41] = new ImageIcon("images\\firstLayer\\2b1\\2-2111.PNG");
		img[43] = new ImageIcon("images\\firstLayer\\2b1\\2-1211.PNG");
		img[44] = new ImageIcon("images\\firstLayer\\2b1\\2-2211.PNG");
		img[49] = new ImageIcon("images\\firstLayer\\2b1\\2-1121.PNG");
		img[50] = new ImageIcon("images\\firstLayer\\2b1\\2-2121.PNG");
		img[52] = new ImageIcon("images\\firstLayer\\2b1\\2-1221.PNG");
		img[53] = new ImageIcon("images\\firstLayer\\2b1\\2-2221.PNG");
		img[67] = new ImageIcon("images\\firstLayer\\2b1\\2-1112.PNG");
		img[68] = new ImageIcon("images\\firstLayer\\2b1\\2-2112.PNG");
		img[70] = new ImageIcon("images\\firstLayer\\2b1\\2-1212.PNG");
		img[71] = new ImageIcon("images\\firstLayer\\2b1\\2-2212.PNG");
		img[76] = new ImageIcon("images\\firstLayer\\2b1\\2-1122.PNG");
		img[77] = new ImageIcon("images\\firstLayer\\2b1\\2-2122.PNG");
		img[79] = new ImageIcon("images\\firstLayer\\2b1\\2-1222.PNG");
		
		//high ground in center vs low ground and sea
		img[1] = new ImageIcon("images\\firstLayer\\2b01\\2-1000.PNG");
		img[4] = new ImageIcon("images\\firstLayer\\2b01\\2-1100.PNG");
		img[13] = new ImageIcon("images\\firstLayer\\2b01\\2-1110.PNG");
		img[10] = new ImageIcon("images\\firstLayer\\2b01\\2-1010.PNG");
		img[37] = new ImageIcon("images\\firstLayer\\2b01\\2-1011.PNG");		
		img[28] = new ImageIcon("images\\firstLayer\\2b01\\2-1001.PNG");
		img[31] = new ImageIcon("images\\firstLayer\\2b01\\2-1101.PNG");
		img[3] = new ImageIcon("images\\firstLayer\\2b01\\2-0100.PNG");
		img[12] = new ImageIcon("images\\firstLayer\\2b01\\2-0110.PNG");
		img[30] = new ImageIcon("images\\firstLayer\\2b01\\2-0101.PNG");
		img[39] = new ImageIcon("images\\firstLayer\\2b01\\2-0111.PNG");
		img[9] = new ImageIcon("images\\firstLayer\\2b01\\2-0010.PNG");
		img[36] = new ImageIcon("images\\firstLayer\\2b01\\2-0011.PNG");	
		img[27] = new ImageIcon("images\\firstLayer\\2b01\\2-0001.PNG");
		img[5] = new ImageIcon("images\\firstLayer\\2b01\\2-2100.PNG");
		img[14] = new ImageIcon("images\\firstLayer\\2b01\\2-2110.PNG");
		img[32] = new ImageIcon("images\\firstLayer\\2b01\\2-2101.PNG");
		img[11] = new ImageIcon("images\\firstLayer\\2b01\\2-2010.PNG");
		img[38] = new ImageIcon("images\\firstLayer\\2b01\\2-2011.PNG");
		img[29] = new ImageIcon("images\\firstLayer\\2b01\\2-2001.PNG");
		img[7] = new ImageIcon("images\\firstLayer\\2b01\\2-1200.PNG");
		img[16] = new ImageIcon("images\\firstLayer\\2b01\\2-1210.PNG");
		img[34] = new ImageIcon("images\\firstLayer\\2b01\\2-1201.PNG");
		img[15] = new ImageIcon("images\\firstLayer\\2b01\\2-0210.PNG");
		img[42] = new ImageIcon("images\\firstLayer\\2b01\\2-0211.PNG");
		img[33] = new ImageIcon("images\\firstLayer\\2b01\\2-0201.PNG");
		img[17] = new ImageIcon("images\\firstLayer\\2b01\\2-2210.PNG");
		img[35] = new ImageIcon("images\\firstLayer\\2b01\\2-2201.PNG");
		img[19] = new ImageIcon("images\\firstLayer\\2b01\\2-1020.PNG");
		img[22] = new ImageIcon("images\\firstLayer\\2b01\\2-1120.PNG");
		img[46] = new ImageIcon("images\\firstLayer\\2b01\\2-1021.PNG");
		img[21] = new ImageIcon("images\\firstLayer\\2b01\\2-0120.PNG");
		img[48] = new ImageIcon("images\\firstLayer\\2b01\\2-0121.PNG");
		img[45] = new ImageIcon("images\\firstLayer\\2b01\\2-0021.PNG");
		img[23] = new ImageIcon("images\\firstLayer\\2b01\\2-2120.PNG");
		img[47] = new ImageIcon("images\\firstLayer\\2b01\\2-2021.PNG");
		img[25] = new ImageIcon("images\\firstLayer\\2b01\\2-1220.PNG");
		img[51] = new ImageIcon("images\\firstLayer\\2b01\\2-0221.PNG");
		img[55] = new ImageIcon("images\\firstLayer\\2b01\\2-1002.PNG");
		img[58] = new ImageIcon("images\\firstLayer\\2b01\\2-1102.PNG");
		img[64] = new ImageIcon("images\\firstLayer\\2b01\\2-1012.PNG");
		img[57] = new ImageIcon("images\\firstLayer\\2b01\\2-0102.PNG");
		img[66] = new ImageIcon("images\\firstLayer\\2b01\\2-0112.PNG");
		img[63] = new ImageIcon("images\\firstLayer\\2b01\\2-0012.PNG");
		img[59] = new ImageIcon("images\\firstLayer\\2b01\\2-2102.PNG");
		img[65] = new ImageIcon("images\\firstLayer\\2b01\\2-2012.PNG");
		img[61] = new ImageIcon("images\\firstLayer\\2b01\\2-1202.PNG");
		img[69] = new ImageIcon("images\\firstLayer\\2b01\\2-0212.PNG");
		img[73] = new ImageIcon("images\\firstLayer\\2b01\\2-1022.PNG");
		img[75] = new ImageIcon("images\\firstLayer\\2b01\\2-0122.PNG");
		
		//winter
		img2[0] = new ImageIcon("images\\firstLayer\\2b0\\2-0000i.PNG");
		img2[2] = new ImageIcon("images\\firstLayer\\2b0\\2-2000i.PNG");
		img2[6] = new ImageIcon("images\\firstLayer\\2b0\\2-0200i.PNG");
		img2[8] = new ImageIcon("images\\firstLayer\\2b0\\2-2200i.PNG");
		img2[18] = new ImageIcon("images\\firstLayer\\2b0\\2-0020i.PNG");
		img2[20] = new ImageIcon("images\\firstLayer\\2b0\\2-2020i.PNG");
		img2[24] = new ImageIcon("images\\firstLayer\\2b0\\2-0220i.PNG");
		img2[26] = new ImageIcon("images\\firstLayer\\2b0\\2-2220i.PNG");
		img2[54] = new ImageIcon("images\\firstLayer\\2b0\\2-0002i.PNG");
		img2[56] = new ImageIcon("images\\firstLayer\\2b0\\2-2002i.PNG");
		img2[60] = new ImageIcon("images\\firstLayer\\2b0\\2-0202i.PNG");
		img2[62] = new ImageIcon("images\\firstLayer\\2b0\\2-2202i.PNG");
		img2[72] = new ImageIcon("images\\firstLayer\\2b0\\2-0022i.PNG");
		img2[74] = new ImageIcon("images\\firstLayer\\2b0\\2-2022i.PNG");
		img2[78] = new ImageIcon("images\\firstLayer\\2b0\\2-0222i.PNG");
		img2[80] = new ImageIcon("images\\firstLayer\\2b0\\2-2222i.PNG");
		
		//high ground in center vs low ground 
		img2[40] = new ImageIcon("images\\firstLayer\\2b1\\2-1111i.PNG");
		img2[41] = new ImageIcon("images\\firstLayer\\2b1\\2-2111i.PNG");
		img2[43] = new ImageIcon("images\\firstLayer\\2b1\\2-1211i.PNG");
		img2[44] = new ImageIcon("images\\firstLayer\\2b1\\2-2211i.PNG");
		img2[49] = new ImageIcon("images\\firstLayer\\2b1\\2-1121i.PNG");
		img2[50] = new ImageIcon("images\\firstLayer\\2b1\\2-2121i.PNG");
		img2[52] = new ImageIcon("images\\firstLayer\\2b1\\2-1221i.PNG");
		img2[53] = new ImageIcon("images\\firstLayer\\2b1\\2-2221i.PNG");
		img2[67] = new ImageIcon("images\\firstLayer\\2b1\\2-1112i.PNG");
		img2[68] = new ImageIcon("images\\firstLayer\\2b1\\2-2112i.PNG");
		img2[70] = new ImageIcon("images\\firstLayer\\2b1\\2-1212i.PNG");
		img2[71] = new ImageIcon("images\\firstLayer\\2b1\\2-2212i.PNG");
		img2[76] = new ImageIcon("images\\firstLayer\\2b1\\2-1122i.PNG");
		img2[77] = new ImageIcon("images\\firstLayer\\2b1\\2-2122i.PNG");
		img2[79] = new ImageIcon("images\\firstLayer\\2b1\\2-1222i.PNG");
		

		//high ground in center vs low ground and sea
		img2[1] = new ImageIcon("images\\firstLayer\\2b01\\2-1000i.PNG");
		img2[4] = new ImageIcon("images\\firstLayer\\2b01\\2-1100i.PNG");
		img2[13] = new ImageIcon("images\\firstLayer\\2b01\\2-1110i.PNG");
		img2[10] = new ImageIcon("images\\firstLayer\\2b01\\2-1010i.PNG");
		img2[37] = new ImageIcon("images\\firstLayer\\2b01\\2-1011i.PNG");		
		img2[28] = new ImageIcon("images\\firstLayer\\2b01\\2-1001i.PNG");
		img2[31] = new ImageIcon("images\\firstLayer\\2b01\\2-1101i.PNG");
		img2[3] = new ImageIcon("images\\firstLayer\\2b01\\2-0100i.PNG");
		img2[12] = new ImageIcon("images\\firstLayer\\2b01\\2-0110i.PNG");
		img2[30] = new ImageIcon("images\\firstLayer\\2b01\\2-0101i.PNG");
		img2[39] = new ImageIcon("images\\firstLayer\\2b01\\2-0111i.PNG");
		img2[9] = new ImageIcon("images\\firstLayer\\2b01\\2-0010i.PNG");
		img2[36] = new ImageIcon("images\\firstLayer\\2b01\\2-0011i.PNG");	
		img2[27] = new ImageIcon("images\\firstLayer\\2b01\\2-0001i.PNG");
		img2[5] = new ImageIcon("images\\firstLayer\\2b01\\2-2100i.PNG");
		img2[14] = new ImageIcon("images\\firstLayer\\2b01\\2-2110i.PNG");
		img2[32] = new ImageIcon("images\\firstLayer\\2b01\\2-2101i.PNG");
		img2[11] = new ImageIcon("images\\firstLayer\\2b01\\2-2010i.PNG");
		img2[38] = new ImageIcon("images\\firstLayer\\2b01\\2-2011i.PNG");
		img2[29] = new ImageIcon("images\\firstLayer\\2b01\\2-2001i.PNG");
		img2[7] = new ImageIcon("images\\firstLayer\\2b01\\2-1200i.PNG");
		img2[16] = new ImageIcon("images\\firstLayer\\2b01\\2-1210i.PNG");
		img2[34] = new ImageIcon("images\\firstLayer\\2b01\\2-1201i.PNG");
		img2[15] = new ImageIcon("images\\firstLayer\\2b01\\2-0210i.PNG");
		img2[42] = new ImageIcon("images\\firstLayer\\2b01\\2-0211i.PNG");
		img2[33] = new ImageIcon("images\\firstLayer\\2b01\\2-0201i.PNG");
		img2[17] = new ImageIcon("images\\firstLayer\\2b01\\2-2210i.PNG");
		img2[35] = new ImageIcon("images\\firstLayer\\2b01\\2-2201i.PNG");
		img2[19] = new ImageIcon("images\\firstLayer\\2b01\\2-1020i.PNG");
		img2[22] = new ImageIcon("images\\firstLayer\\2b01\\2-1120i.PNG");
		img2[46] = new ImageIcon("images\\firstLayer\\2b01\\2-1021i.PNG");
		img2[21] = new ImageIcon("images\\firstLayer\\2b01\\2-0120i.PNG");
		img2[48] = new ImageIcon("images\\firstLayer\\2b01\\2-0121i.PNG");
		img2[45] = new ImageIcon("images\\firstLayer\\2b01\\2-0021i.PNG");
		img2[23] = new ImageIcon("images\\firstLayer\\2b01\\2-2120i.PNG");
		img2[47] = new ImageIcon("images\\firstLayer\\2b01\\2-2021i.PNG");
		img2[25] = new ImageIcon("images\\firstLayer\\2b01\\2-1220i.PNG");
		img2[51] = new ImageIcon("images\\firstLayer\\2b01\\2-0221i.PNG");
		img2[55] = new ImageIcon("images\\firstLayer\\2b01\\2-1002i.PNG");
		img2[58] = new ImageIcon("images\\firstLayer\\2b01\\2-1102i.PNG");
		img2[64] = new ImageIcon("images\\firstLayer\\2b01\\2-1012i.PNG");
		img2[57] = new ImageIcon("images\\firstLayer\\2b01\\2-0102i.PNG");
		img2[66] = new ImageIcon("images\\firstLayer\\2b01\\2-0112i.PNG");
		img2[63] = new ImageIcon("images\\firstLayer\\2b01\\2-0012i.PNG");
		img2[59] = new ImageIcon("images\\firstLayer\\2b01\\2-2102i.PNG");
		img2[65] = new ImageIcon("images\\firstLayer\\2b01\\2-2012i.PNG");
		img2[61] = new ImageIcon("images\\firstLayer\\2b01\\2-1202i.PNG");
		img2[69] = new ImageIcon("images\\firstLayer\\2b01\\2-0212i.PNG");
		img2[73] = new ImageIcon("images\\firstLayer\\2b01\\2-1022i.PNG");
		img2[75] = new ImageIcon("images\\firstLayer\\2b01\\2-0122i.PNG");


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
