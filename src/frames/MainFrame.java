package frames;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Other.Music;
import Other.MyTime;
import Other.SetCursor;
import Other.coreandvalue;
import firstLayerObject.LayerObject;
import maps.Map;
import maps.MiniMap;
import maps.RightJpanel;
import network.Client;
import network.Server;
import singlePlayer.Castle;



public class MainFrame extends JFrame implements Runnable {
	Dimension screen;
	Map map;
	RightJpanel rj;
	MiniMap mm;
	Point p ;

	private ListenForMap lfm ;
	private ListenForMiniMap lfmm;
	private ScrollComponent sc ;
	public JLabel tl , t , tr , r , dl , d , dr , l ;
	private Stack<coreandvalue> redo , undo ;
	private JButton MapEdit1,MapEdit2,MapEdit3,MapEdit4,MapEdit5,MapEdit6,MapEdit7,MapEdit8,MapEdit9,MapEdit10;
	private JButton MapEdit11,MapEdit12,MapEdit13,MapEdit14,MapEdit15,MapEdit16,MapEdit17,MapEdit18,MapEdit19,MapEdit20;
	private JButton Close;
	private ImageIcon im[] = new ImageIcon[20];
	private ButtonAction ba;
	public  int selected_object_code = 1;
	public  final int MAX_GROUP_CODE = 7;
	private int max_undo =10;
	private int scroll_delay = 80;
	private int scroll_increament = 15;
	private MyTime myTime;
	private Music music;

	private Castle castle;	
	private Server server ; 
	private Client client;
	
	public MainFrame(Music mus){
		
		music = mus;
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screen);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		setLayout(null);

		setTitle("King Of Land");

		lfm = new ListenForMap();
		map = new Map(40 , 40, this );
		map.setBackground(Color.black);
		map.setSize((int)(screen.width*4/5),(int)(screen.height));
		map.addMouseListener(lfm);
		map.addKeyListener(lfm);
		map.setFocusable(true);
		getContentPane().add(map);
		
		setCursor(new SetCursor().setMouseIcon(0));
		

		//Creat Images Icon And SetSize

		//sea
		ImageIcon myIcon1 = new ImageIcon("images\\button\\sea.jpg");
		Image img1 = myIcon1.getImage();
		Image newimg1 = img1.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[0] = new ImageIcon(newimg1);
		//lowground
		ImageIcon myIcon2 = new ImageIcon("images\\button\\lowground.jpg");
		Image img2 = myIcon2.getImage();
		Image newimg2 = img2.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[1] = new ImageIcon(newimg2);
		//highground
		ImageIcon myIcon3 = new ImageIcon("images\\button\\highground.jpg");
		Image img3 = myIcon3.getImage();
		Image newimg3 = img3.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[2] = new ImageIcon(newimg3);
		//fish
		ImageIcon myIcon4 = new ImageIcon("images\\button\\fishBtn.png");
		Image img4 = myIcon4.getImage();
		Image newimg4 = img4.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[3] = new ImageIcon(newimg4);
		//tree
		ImageIcon myIcon5 = new ImageIcon("images\\button\\Tree.gif");
		Image img5 = myIcon5.getImage();
		Image newimg5 = img5.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[4] = new ImageIcon(newimg5);
		//farm
		ImageIcon myIcon6 = new ImageIcon("images\\button\\farmBtn.png");
		Image img6 = myIcon6.getImage();
		Image newimg6 = img6.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[5] = new ImageIcon(newimg6);
		//iron
		ImageIcon myIcon7 = new ImageIcon("images\\button\\ironMineBtn.png");
		Image img7 = myIcon7.getImage();
		Image newimg7 = img7.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[6] = new ImageIcon(newimg7);
		//gold
		ImageIcon myIcon8 = new ImageIcon("images\\button\\goldMineBtn.png");
		Image img8 = myIcon8.getImage();
		Image newimg8 = img8.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[7] = new ImageIcon(newimg8);
		//up
		ImageIcon myIcon9 = new ImageIcon("images\\button\\up.gif");
		Image img9 = myIcon9.getImage();
		Image newimg9 = img9.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[8] = new ImageIcon(newimg9);
		//down
		ImageIcon myIcon10 = new ImageIcon("images\\button\\down.gif");
		Image img10 = myIcon10.getImage();
		Image newimg10 = img10.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[9] = new ImageIcon(newimg10);
		//right
		ImageIcon myIcon11 = new ImageIcon("images\\button\\right.gif");
		Image img11 = myIcon11.getImage();
		Image newimg11 = img11.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[10] = new ImageIcon(newimg11);
		//left
		ImageIcon myIcon12 = new ImageIcon("images\\button\\left.gif");
		Image img12 = myIcon12.getImage();
		Image newimg12 = img12.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[11] = new ImageIcon(newimg12);
		//redo
		ImageIcon myIcon13 = new ImageIcon("images\\button\\redo.png");
		Image img13 = myIcon13.getImage();
		Image newimg13 = img13.getScaledInstance(40,40,  java.awt.Image.SCALE_SMOOTH);
		im[12] = new ImageIcon(newimg13);
		//undo
		ImageIcon myIcon14 = new ImageIcon("images\\button\\undo.png");
		Image img14 = myIcon14.getImage();
		Image newimg14 = img14.getScaledInstance(40,40,  java.awt.Image.SCALE_SMOOTH);
		im[13] = new ImageIcon(newimg14);
		//zoom out
		ImageIcon myIcon15 = new ImageIcon("images\\button\\Negative.jpg");
		Image img15 = myIcon15.getImage();
		Image newimg15 = img15.getScaledInstance(30,30,  java.awt.Image.SCALE_SMOOTH);
		im[14] = new ImageIcon(newimg15);
		//zoom in
		ImageIcon myIcon16 = new ImageIcon("images\\button\\Positive.png");
		Image img16 = myIcon16.getImage();
		Image newimg16 = img16.getScaledInstance(40,40,  java.awt.Image.SCALE_SMOOTH);
		im[15] = new ImageIcon(newimg16);

		ImageIcon myIcon17 = new ImageIcon("images\\button\\close.png");
		Image img17 = myIcon17.getImage();
		Image newimg17 = img17.getScaledInstance(25,25,  java.awt.Image.SCALE_SMOOTH);
		im[16] = new ImageIcon(newimg17);


		ba = new ButtonAction();



		//add JButton to Jframe

		//sea
		MapEdit1 = new JButton();
		MapEdit1.setSize(50,50);
		MapEdit1.setLocation(screen.width*33/40,screen.height*1/32);
		MapEdit1.setIcon(im[0]);
		MapEdit1.addMouseListener(ba);
		getContentPane().add(MapEdit1);

		//lowground
		MapEdit2 = new JButton();
		MapEdit2.setLocation(screen.width*37/40,screen.height*1/32);
		MapEdit2.setSize(50,50);
		MapEdit2.setIcon(im[1]);
		MapEdit2.addMouseListener(ba);
		getContentPane().add(MapEdit2);

		//Close
		Close = new JButton();
		Close.setLocation(screen.width*79/80,0);
		Close.setSize(25,25);
		Close.setIcon(im[16]);
		Close.addMouseListener(ba);
		getContentPane().add(Close);



		//highground
		MapEdit3 = new JButton();
		MapEdit3.setLocation(screen.width*33/40,screen.height*4/32);
		MapEdit3.setSize(50,50);
		MapEdit3.setIcon(im[2]);
		MapEdit3.addMouseListener(ba);
		getContentPane().add(MapEdit3);

		//fish
		MapEdit4 = new JButton();
		MapEdit4.setLocation(screen.width*37/40,screen.height*4/32);
		MapEdit4.setSize(50,50);
		MapEdit4.setIcon(im[3]);
		MapEdit4.addMouseListener(ba);
		getContentPane().add(MapEdit4);

		//tree
		MapEdit5 = new JButton();
		MapEdit5.setLocation(screen.width*33/40,screen.height*7/32);
		MapEdit5.setSize(50,50);
		MapEdit5.setIcon(im[4]);
		MapEdit5.addMouseListener(ba);
		getContentPane().add(MapEdit5);

		//farm
		MapEdit6 = new JButton();
		MapEdit6.setLocation(screen.width*37/40,screen.height*7/32);
		MapEdit6.setSize(50,50);
		MapEdit6.setIcon(im[5]);
		MapEdit6.addMouseListener(ba);
		getContentPane().add(MapEdit6);

		//iron
		MapEdit7 = new JButton();
		MapEdit7.setLocation(screen.width*33/40,screen.height*10/32);
		MapEdit7.setSize(50,50);
		MapEdit7.setIcon(im[6]);
		MapEdit7.addMouseListener(ba);
		getContentPane().add(MapEdit7);

		//gold
		MapEdit14 = new JButton();
		MapEdit14.setLocation(screen.width*37/40,screen.height*10/32);
		MapEdit14.setSize(50,50);
		MapEdit14.setIcon(im[7]);
		MapEdit14.addMouseListener(ba);
		getContentPane().add(MapEdit14);

		//Save
		MapEdit8 = new JButton("S");
		MapEdit8.setLocation(screen.width*68/80,screen.height*17/32);
		MapEdit8.setSize(50,50);
		MapEdit8.addMouseListener(ba);
		//MapEdit8.setIcon(im[7]);
		getContentPane().add(MapEdit8);

		//Load
		MapEdit9 = new JButton("L");
		MapEdit9.setLocation(screen.width*71/80,screen.height*17/32);
		MapEdit9.setSize(50,50);
		MapEdit9.addMouseListener(ba);
		//MapEdit9.setIcon(im[8]);
		getContentPane().add(MapEdit9);

		//New map
		MapEdit19 = new JButton("N");
		MapEdit19.setLocation(screen.width*74/80,screen.height*17/32);
		MapEdit19.setSize(50,50);
		MapEdit19.addMouseListener(ba);
		//MapEdit9.setIcon(im[8]);
		getContentPane().add(MapEdit19);

		//Redo
		MapEdit10 = new JButton();
		MapEdit10.setLocation(screen.width*75/80,screen.height*20/32);
		MapEdit10.setSize(40,40);
		MapEdit10.setBackground(Color.white);
		MapEdit10.setIcon(im[12]);
		MapEdit10.addMouseListener(ba);
		getContentPane().add(MapEdit10);

		//Undo
		MapEdit11= new JButton();
		MapEdit11.setLocation(screen.width*77/80, screen.height*20/32);
		MapEdit11.setSize(40,40);
		MapEdit11.setBackground(Color.white);
		MapEdit11.setIcon(im[13]);
		MapEdit11.addMouseListener(ba);
		getContentPane().add(MapEdit11);

		//Zoom Out
		MapEdit12= new JButton();
		MapEdit12.setLocation(screen.width*67/80, screen.height*20/32);
		MapEdit12.setSize(40,40);
		MapEdit12.setBackground(Color.white);
		MapEdit12.setIcon(im[14]);
		MapEdit12.addMouseListener(ba);
		getContentPane().add(MapEdit12);

		//Zoom In
		MapEdit13= new JButton();
		MapEdit13.setLocation(screen.width*65/80, screen.height*20/32);
		MapEdit13.setSize(40,40);
		MapEdit13.setBackground(Color.white);
		MapEdit13.setIcon(im[15]);
		MapEdit13.addMouseListener(ba);
		getContentPane().add(MapEdit13);

		//Go to Up
		MapEdit15= new JButton();
		MapEdit15.setLocation(screen.width*71/80, (int)(screen.height*20/32));
		MapEdit15.setSize(40,40);
		MapEdit15.setBackground(Color.white);
		MapEdit15.setIcon(im[8]);
		MapEdit15.addMouseListener(ba);
		getContentPane().add(MapEdit15);

		//Go To Left
		MapEdit16= new JButton();
		MapEdit16.setLocation((int)(screen.width*68/80), screen.height*22/32);
		MapEdit16.setSize(40,40);
		MapEdit16.setBackground(Color.white);
		MapEdit16.setIcon(im[11]);
		MapEdit16.addMouseListener(ba);
		getContentPane().add(MapEdit16);

		//Go To Down
		MapEdit17= new JButton();
		MapEdit17.setLocation(screen.width*71/80, screen.height*22/32);
		MapEdit17.setSize(40,40);
		MapEdit17.setBackground(Color.white);
		MapEdit17.setIcon(im[9]);
		MapEdit17.addMouseListener(ba);
		getContentPane().add(MapEdit17);

		//Go To Right
		MapEdit18= new JButton();
		MapEdit18.setLocation((int)(screen.width*74/80), screen.height*22/32);
		MapEdit18.setSize(40,40);
		MapEdit18.setBackground(Color.white);
		MapEdit18.setIcon(im[10]);
		MapEdit18.addMouseListener(ba);
		getContentPane().add(MapEdit18);


		rj = new RightJpanel(music,map);

		rj.setSize((int)(screen.width*1/5),(int)(screen.height*3/4));
		rj.setLocation((int)(screen.width*4/5),0);
		rj.setBackground(Color.blue);
		getContentPane().add(rj);

		lfmm = new ListenForMiniMap();
		mm = new MiniMap(map ,screen.width*1/5 , screen.height*1/4 , new Point(screen.width*4/5,screen.height));
		mm.setSize((int)(screen.width*1/5),(int)(screen.height*1/4));
		mm.setLocation((int)(screen.width*4/5),(int)(screen.height*3/4));
		mm.addMouseListener(lfmm);
		mm.setBackground(Color.orange);
		map.setMm(mm);
		getContentPane().add(mm);
		
		
		server = new Server(2);
		server.start();
		//client initialization
		client = new Client(1, "ali", "DESKTOP-IFD82C2",server, 2 ,map ); 
		client.start();

		//initialize time
		myTime = new MyTime(0, new int [] {0,0,0,0});
		for ( LayerObject l : map.getLayerObject()) {
			l.setMyTime(myTime);
		}

		map.setTimeTree(myTime);



		map.setLayout(null);
		mm.setLayout(null);

		sc = new ScrollComponent();

		tl = new JLabel();
		tl.setSize(map.getWidth()/100,map.getHeight()/100);
		tl.setLocation(0,0);
		tl.addMouseListener(sc);
		map.add(tl);	

		sc = new ScrollComponent();
		t = new JLabel();
		t.setSize(map.getWidth()*98/100,map.getHeight()/100);
		t.setLocation(map.getWidth()/100,0);
		t.addMouseListener(sc);
		map.add(t);

		sc = new ScrollComponent();
		tr = new JLabel();
		tr.setSize(map.getWidth()/100,map.getHeight()/100);
		tr.setLocation(map.getWidth()*99/100,0);
		tr.addMouseListener(sc);
		map.add(tr);

		sc = new ScrollComponent();
		r = new JLabel();
		r.setSize(map.getWidth()/100,map.getHeight()*98/100);
		r.setLocation(map.getWidth()*99/100,map.getHeight()/100);
		r.addMouseListener(sc);
		map.add(r);

		sc = new ScrollComponent();
		dr = new JLabel();
		dr.setSize(map.getWidth()/100,map.getHeight()/100+10);
		dr.setLocation(map.getWidth()*99/100,map.getHeight()*99/100);
		dr.addMouseListener(sc);
		map.add(dr);

		sc = new ScrollComponent();
		d = new JLabel();
		d.setSize(map.getWidth()*98/100,map.getHeight()/100+10);
		d.setLocation(map.getWidth()/100,map.getHeight()*99/100);
		d.addMouseListener(sc);
		map.add(d);

		sc = new ScrollComponent();
		dl = new JLabel();
		dl.setSize(map.getWidth()/100,map.getHeight()/100+10);
		dl.setLocation(0,map.getHeight()*99/100);
		dl.addMouseListener(sc);
		map.add(dl);

		sc = new ScrollComponent();
		l = new JLabel();
		l.setSize(map.getWidth()/100,map.getHeight()*98/100);
		l.setLocation(0,map.getHeight()/100);
		l.addMouseListener(sc);
		map.add(l);

		redo = new Stack<coreandvalue>();
		undo = new Stack<coreandvalue>();
		redo.removeAllElements();
		undo.removeAllElements();
		setFocusable(true);
		setVisible(true);
		setResizable(false);

	}

	class ButtonAction implements MouseListener , Runnable {

		private boolean is_entered = false ; 

		public void setIs_entered(boolean is_entered) {
			this.is_entered = is_entered;
		}

		public boolean isIs_entered() {
			return is_entered;
		}

		private int which_action_entered = 0 ;

		public void setWhich_action_entered(int which_action_entered) {
			this.which_action_entered = which_action_entered;
		}

		public int getWhich_action_entered() {

			return which_action_entered;
		}



		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource().equals(MapEdit8)){			//save
				saveMap();
			}
			if(arg0.getSource().equals(MapEdit9)){			//load
				loadMap();
				map.repaint();
			}


			if(arg0.getSource().equals(MapEdit1)){			//sea
				selected_object_code = 0 ;
			}
			if(arg0.getSource().equals(MapEdit2)){			//low ground
				selected_object_code = 1;
			}
			if(arg0.getSource().equals(MapEdit3)){			//high ground
				selected_object_code = 2; 
			}
			if(arg0.getSource().equals(MapEdit4)){			//fish
				selected_object_code = 7;
			}
			if(arg0.getSource().equals(MapEdit5)){			//tree 
				selected_object_code = 8;
			}

			if(arg0.getSource().equals(MapEdit6)){			//farm
				selected_object_code = 9;
			}
			if(arg0.getSource().equals(MapEdit7)){			//iron
				selected_object_code = 10;
			}
			if(arg0.getSource().equals(MapEdit14)){			//gold
				selected_object_code= 11 ; 
			}

			if(arg0.getSource().equals(MapEdit10)){			//Redo
				redo();
			}
			if(arg0.getSource().equals(MapEdit11)){			//Undo
				undo();
			}
			if(arg0.getSource().equals(MapEdit19)){			//New map
				newMap();
			}
			if(arg0.getSource().equals(Close)){			//Close
				music.playsound(34, true);
				music.playsound(32, false);
				setVisible(false);
				dispose();
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

			setIs_entered(true);
			if(arg0.getSource().equals(MapEdit18)){
				(new Thread(this)).start();
				setWhich_action_entered(1);
			}
			if(arg0.getSource().equals(MapEdit17)){
				(new Thread(this)).start();
				setWhich_action_entered(2);

			}
			if(arg0.getSource().equals(MapEdit16)){
				(new Thread(this)).start();
				setWhich_action_entered(3);
			}
			if(arg0.getSource().equals(MapEdit15)){
				(new Thread(this)).start();
				setWhich_action_entered(4);
			}
			if(arg0.getSource().equals(MapEdit13)){
				(new Thread(this)).start();
				setWhich_action_entered(5);

			}
			if(arg0.getSource().equals(MapEdit12)){
				(new Thread(this)).start();
				setWhich_action_entered(6);


			}
			if(arg0.getSource().equals(MapEdit11)){
				(new Thread(this)).start();
				setWhich_action_entered(7);
			}
			if(arg0.getSource().equals(MapEdit10)){
				(new Thread(this)).start();
				setWhich_action_entered(8);
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			setIs_entered(false);
			setWhich_action_entered(0);

		}

		public void saveMap() {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("/home/me/Documents"));
			int retrival = chooser.showSaveDialog(null);
			if (retrival == JFileChooser.APPROVE_OPTION) {
				try {
					FileOutputStream fw = new FileOutputStream(chooser.getSelectedFile()+".txt");
					ObjectOutputStream out = new ObjectOutputStream(fw);
					out.writeObject(map.getFirstLayer());
					out.writeObject(map.getSecondLayer());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		public void loadMap()
		{
			String filename;
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION)
			{
				File selectedFile = fileChooser.getSelectedFile();
				filename = selectedFile.getAbsolutePath();

				try
				{
					FileInputStream reader = new FileInputStream(filename);
					ObjectInputStream in = new ObjectInputStream(reader);
					
					
					map.loadMap((int[][]) in.readObject(), (int[][]) in.readObject());

					in.close();
					reader.close();
				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,"Not File Exist");
					System.out.println(e.getMessage());
				}
			}
		}   


		@Override
		public void run() {
			// TODO Auto-generated method stub

			while(isIs_entered()){


				switch(getWhich_action_entered()){

				case 1:{
					if(map.getX_middle_tile()<=map.getMapColumns()-1&&map.getY_middle_tile()>=0)
						map.set_scroll_x(+scroll_increament);
				}
				break;
				case 2:{
					if(map.getX_middle_tile()<=map.getMapColumns()-1&&map.getY_middle_tile()<=map.getMapRows()-1)
						map.set_scroll_y(+scroll_increament);
				}
				break;
				case 3:{
					if(map.getX_middle_tile()>=0&&map.getY_middle_tile()<=map.getMapRows()-1)
						map.set_scroll_x(-scroll_increament);
				}
				break;
				case 4:{
					if(map.getX_middle_tile()>=0&&map.getY_middle_tile()>=0)
						map.set_scroll_y(-scroll_increament);
				}
				break;

				case 5:{
					if(map.getTileSize()<map.getMax_zoom()){
						map.zoom(1);
					}
				}
				break;
				case 6:{
					if(map.getTileSize()>map.getMin_zoom()){
						map.zoom(-1);

					}
				}

				}
				map.repaint();

				long d = System.currentTimeMillis();
				while (d+scroll_delay>System.currentTimeMillis());


			}
		}

	}


	class ScrollComponent implements MouseListener, Runnable{


		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub


		}



		private boolean is_entered = false ; 

		public void setIs_entered(boolean is_entered) {
			this.is_entered = is_entered;
		}

		public boolean isIs_entered() {
			return is_entered;
		}

		private int which_lable_entered = 0 ;

		public void setWhich_lable_entered(int which_lable_entered) {
			this.which_lable_entered = which_lable_entered;
		}

		public int getWhich_lable_entered() {

			return which_lable_entered;
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

			setIs_entered(true);
			if(arg0.getComponent() == tl){
				(new Thread(this)).start();
				setWhich_lable_entered(1);
			}

			if(arg0.getComponent() == t){
				(new Thread(this)).start();
				setWhich_lable_entered(2);


			}

			if(arg0.getComponent() == tr){
				(new Thread(this)).start();
				setWhich_lable_entered(3);
			}

			if(arg0.getComponent() == r){
				(new Thread(this)).start();
				setWhich_lable_entered(4);
			}

			if(arg0.getComponent() == dr){
				(new Thread(this)).start();
				setWhich_lable_entered(5);
			}

			if(arg0.getComponent() == d){
				(new Thread(this)).start();
				setWhich_lable_entered(6);
			}

			if(arg0.getComponent() == dl){
				(new Thread(this)).start();
				setWhich_lable_entered(7);
			}

			if(arg0.getComponent() == l){
				(new Thread(this)).start();
				setWhich_lable_entered(8);
			}

		}
		@Override
		public void mouseExited(MouseEvent arg0) {

			setIs_entered(false);
			setWhich_lable_entered(0);


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

			while(isIs_entered()){

				long d = System.currentTimeMillis();
				while (d+scroll_delay>System.currentTimeMillis());

				switch(getWhich_lable_entered()){

				case 1 :{  // top left
					if(map.getX_middle_tile()>=0&&map.getY_middle_tile()>=0){
						map.set_scroll_x(-scroll_increament);
						map.set_scroll_y(-scroll_increament);
					}



				}

				break;

				case 2 :{  // top 


					if(map.getX_middle_tile()>=0&&map.getY_middle_tile()>=0)
						map.set_scroll_y(-scroll_increament);

				}

				break;

				case 3 :{  // top right 
					if(map.getX_middle_tile()>=0&&map.getY_middle_tile()>=0){
						map.set_scroll_y(-scroll_increament);
						map.set_scroll_x(+scroll_increament);
					}

				}

				break;

				case 4 :{  // right
					if(map.getX_middle_tile()<=map.getMapColumns()-1&&map.getY_middle_tile()>=0)
						map.set_scroll_x(+scroll_increament);

				}

				break;

				case 5 :{  // down right  
					if(map.getX_middle_tile()<=map.getMapColumns()-1&&map.getY_middle_tile()<=map.getMapRows()-1){
						map.set_scroll_x(+scroll_increament);
						map.set_scroll_y(+scroll_increament);
					}

				}

				break;

				case 6 :{  // down
					if(map.getX_middle_tile()<=map.getMapColumns()-1&&map.getY_middle_tile()<=map.getMapRows()-1)
						map.set_scroll_y(+scroll_increament);

				}

				break;

				case 7 :{  // down left
					if(map.getX_middle_tile()<=map.getMapColumns()-1&&map.getY_middle_tile()<=map.getMapRows()-1){
						map.set_scroll_y(+scroll_increament);
						map.set_scroll_x(-scroll_increament);
					}

				}

				break;

				case 8 :{  // left
					if(map.getX_middle_tile()>=0&&map.getY_middle_tile()<=map.getMapRows()-1)
						map.set_scroll_x(-scroll_increament);

				}

				break;

				}
				repaint();

			}

		}

	}

	class ListenForMap implements Runnable , MouseListener, KeyListener{
		private boolean mousePressed;

		public ListenForMap() {
			// TODO Auto-generated constructor stub

			mousePressed = false ;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub



		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub


		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

			mousePressed = true;
			(new Thread(this)).start();
			//System.out.println(map.getX_middle_tile()+" "+map.getY_middle_tile());
			//System.out.println(map.getTileIndex(map.convert_to_2D(new Point(arg0.getX(), arg0.getY()))));

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

			mousePressed = false ; 



		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}



		@Override
		public void run() {
			int x = -1;
			int y = -1;

			int first_layer_or_second_layer = selected_object_code/MAX_GROUP_CODE;

			boolean hasChanged = false;

			while(mousePressed){
				Point p = map.getTileIndex(map.convert_to_2D(new Point(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y)));
				if(x != p.x || y != p.y){
					x = p.x;
					y = p.y;
					hasChanged = true;
				}
				else {
					hasChanged = false;
				}



				if(hasChanged){

					if(first_layer_or_second_layer==0){	

						event(x, y, 1);
						changeFirstLayerCell(x, y  ,selected_object_code);
						client.send();



					}

					else{
						switch(selected_object_code){
						
						case 7 :{			//fish
							if(map.getFirstLayer()[y][x]/map.getMax_tile_code() == 0 ){
								Point po = new Point(x, y);
								event(x, y, 2);
								map.set_secondLayer_cell(po, selected_object_code);
								client.send();
							}
						}
						break;

						case 8:{			//tree

							if(map.getFirstLayer()[y][x]/map.getMax_tile_code() == 1){
								Point po = new Point(x, y);
								event(x, y, 2);
								map.set_secondLayer_cell(po, selected_object_code);
								client.send();

							}
						}
						break;
						case 9:{			//farm
							if(map.getFirstLayer()[y][x]/map.getMax_tile_code() == 1){
								Point po = new Point(x, y);
								event(x, y, 2);
								map.set_secondLayer_cell(po, selected_object_code);
								client.send();
							}
						}
						break;
						case 10:{			//iron 
							if(map.getFirstLayer()[y][x]/map.getMax_tile_code() == 2){
								Point po = new Point(x, y);
								event(x, y, 2);
								map.set_secondLayer_cell(po, selected_object_code);
								client.send();
							}
						}
						break;
						case 11:{			//gold
							if(map.getFirstLayer()[y][x]/map.getMax_tile_code() == 2){
								Point po = new Point(x, y);
								event(x, y, 2);
								map.set_secondLayer_cell(po, selected_object_code);
								client.send();
							}
						}
						break;


						}  

					}
					//					for(int i =0 ; i<map.getSecondLayer().length ; i++){
					//						for(int j =0 ; j<map.getSecondLayer()[i].length ; j++){
					//
					//							System.out.print(map.getSecondLayer()[i][j]);
					//						}
					//						System.out.println();
					//					}
					//					System.out.println();
					map.repaint();

				}
			}

		}


	}

	class ListenForMiniMap implements Runnable , MouseListener{
		private boolean mousePressed;
		private Point shiftedCoor;

		public ListenForMiniMap() {
			// TODO Auto-generated constructor stub
			shiftedCoor = new Point((int)(screen.width*4/5), (int)(screen.height*3/4));
			mousePressed = false ;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub



		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub


		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

			mousePressed = true;
			(new Thread(this)).start();
			//System.out.println(map.getX_middle_tile()+" "+map.getY_middle_tile());
			//System.out.println(map.getTileIndex(map.convert_to_2D(new Point(arg0.getX(), arg0.getY()))));

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

			mousePressed = false ; 



		}

		@Override
		public void run() {
			int x = -1;
			int y = -1;
			boolean hasChanged = false;
			while(mousePressed){
				Point p = mm.convert_to_2D(new Point(MouseInfo.getPointerInfo().getLocation().x - shiftedCoor.x, MouseInfo.getPointerInfo().getLocation().y - shiftedCoor.y));
				if((x != p.x || y != p.y) && (p.x>=0 && p.y>=0 && p.x<=map.getMapColumns()*mm.getHalfTileSize() && p.y<=map.getMapRows()*mm.getHalfTileSize())){
					x = p.x * map.getTileSize()/mm.getHalfTileSize();
					y = p.y * map.getTileSize()/mm.getHalfTileSize();
					hasChanged = true;  

				}
				else {
					hasChanged = false;
				}

				if(hasChanged){

					//	          if(x>map.getTileSize()*1 && y>map.getTileSize()*1 && x<map.getTileSize()*(map.getMapColumns()-1) && y<map.getTileSize()*(map.getMapRows()-1)){
					Point tempP = map.converttoiso(new Point(x,y));
					//System.out.println(x + ":" + y);
					map.set_scroll_x(-map.getScroll_x() + tempP.x - map.getWidth()/2);
					map.set_scroll_y(-map.getScroll_y() + tempP.y - map.getHeight()/2);

					map.repaint();
					//	          }
					//	          else{
					//	            Point tempP = map.converttoiso(new Point(x,y));
					//	            //System.out.println(x + ":" + y);
					//	            map.set_scroll_x(-map.getScroll_x() + tempP.x - map.getWidth()/2);
					//	            map.set_scroll_x(-map.getScroll_y() + tempP.y - map.getHeight()/2);
					//
					//	            map.repaint();
					//	            
					//	          }
				}
				long d = System.currentTimeMillis();
				while (d+scroll_delay>System.currentTimeMillis());
			}


		}

	}




	public void changeFirstLayerCell(int x, int y, int type) {
		Point self =new Point(x, y);
		map.set_firstLayer_cell(self,map.get_tile_code(self ,true, type) );

		Point topCell =new Point(x, y-1);
		map.set_firstLayer_cell(topCell,map.get_tile_code(topCell, false , type) );

		Point rightCell =new Point(x+1, y);
		map.set_firstLayer_cell(rightCell,map.get_tile_code(rightCell, false , type) );

		Point downCell =new Point(x, y+1);
		map.set_firstLayer_cell(downCell,map.get_tile_code(downCell, false , type) );

		Point leftCell =new Point(x-1, y);
		map.set_firstLayer_cell(leftCell,map.get_tile_code(leftCell,false , type) );

		map.set_secondLayer_cell(self, 0);;
	}


	public void event(int x , int y,int layer){
		if(layer ==1){
			coreandvalue cV = new coreandvalue(x, y, map.getFirstLayer()[x][y]%map.getMax_tile_code(),layer);
			//System.out.println(cV.getValue());
			if(undo.size()<max_undo)
				undo.push(cV);
			else{
				Stack<coreandvalue> temp = new Stack<>();
				while(!undo.isEmpty())
					temp.push(undo.pop());
				temp.pop();
				while(!temp.isEmpty())
					undo.push(temp.pop());
				undo.push(cV);

			}

		}
		if(layer ==2){
			coreandvalue cV = new coreandvalue(x, y, map.getSecondLayer()[y][x],layer);
			if(undo.size()<max_undo)
				undo.push(cV);
			else{
				Stack<coreandvalue> temp = new Stack<>();
				while(!undo.isEmpty())
					temp.push(undo.pop());
				temp.pop();
				while(!temp.isEmpty())
					undo.push(temp.pop());
				undo.push(cV);



			}
		}
	}

	public void undo(){
		if(!undo.isEmpty()){
			coreandvalue cV = undo.pop();
			if(cV.getLayer()==1){
				redo.push(new coreandvalue(cV.getX(), cV.getY() , map.getFirstLayer()[cV.getY()][cV.getX()]/map.getMax_tile_code(),cV.getLayer()));
				changeFirstLayerCell(cV.getX(),cV.getY(),cV.getValue());
				//changeFirstLayerCell(undo.peek().getX(),undo.peek().getY() ,map.getFirstLayer()[undo.peek().getY()][undo.peek().getX()]/map.getMax_tile_code());
			}
			else
			{
				redo.push(new coreandvalue(cV.getX(), cV.getY() , map.getSecondLayer()[cV.getY()][cV.getX()],cV.getLayer()));
				map.set_secondLayer_cell(new Point(cV.getX(), cV.getY()), cV.getValue());
			}
			map.repaint();
		}

	}

	public void redo(){

		if(!redo.isEmpty()){

			coreandvalue cV = redo.pop();
			if(cV.getLayer()==1){

				undo.push(new coreandvalue(cV.getX(), cV.getY(),map.getFirstLayer()[cV.getY()][cV.getX()]/map.getMax_tile_code(),cV.getLayer()));
				changeFirstLayerCell(cV.getX(),cV.getY(),cV.getValue());


			}
			else
			{
				undo.push(new coreandvalue(cV.getX(), cV.getY() , map.getSecondLayer()[cV.getY()][cV.getX()],cV.getLayer()));
				map.set_secondLayer_cell(new Point(cV.getX(), cV.getY()), cV.getValue());

			}
			map.repaint();


		}  
	}

	public void newMap(){
		JTextField row = new JTextField();
		JTextField column = new JTextField();
		Object[] message = {
				"Row", row,
				"Column", column
		};
		int option = JOptionPane.showConfirmDialog(null, message, "NewMap", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			this.map.reNewMap(Integer.parseInt(row.getText()),Integer.parseInt(column.getText()));
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			//System.out.println(MapEdit());
		}

	}

}	





