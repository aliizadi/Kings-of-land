package frames;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Other.Music;
import Other.MyTime;
import Other.SetCursor;
import firstLayerObject.LayerObject;
import maps.Map;
import maps.MiniMap;
import maps.RightJpanel;

public class PreviewFrame extends JFrame implements Runnable , KeyListener {
	private Dimension screen;
	private Map map;
	private RightJpanel rj;
	private MiniMap mm;

	private ListenForMap lfm ;
	private ListenForMiniMap lfmm;
	private ScrollComponent sc ;
	private ButtonAction ba;
	public JLabel tl , t , tr , r , dl , d , dr , l ;
	private JButton loadBtn,zoomOutBtn,zoomInBtn,upBtn,leftBtn,downBtn,rightBtn, resumePreview, pausePreview;
	private JButton Close;
	private DayViewer dayViewer;
	private DateViewer dateViewer;
	private ImageIcon im[] = new ImageIcon[20];
	private int scroll_delay = 80;
	private int scroll_increament = 15;
	public  final int MAX_GROUP_CODE = 7;
	private MyTime myTime;
	private Thread myTimeThread;
	private final int[] startDate;
	private Music music;

	public  PreviewFrame(Music mus){
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

		//Creat Images Icon And SetSize

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
		im[17] = new ImageIcon(newimg11);
		//left
		ImageIcon myIcon12 = new ImageIcon("images\\button\\left.gif");
		Image img12 = myIcon12.getImage();
		Image newimg12 = img12.getScaledInstance(50,50,  java.awt.Image.SCALE_SMOOTH);
		im[11] = new ImageIcon(newimg12);
		//pause
		ImageIcon myIcon13 = new ImageIcon("images\\button\\pauseBtn.png");
		Image img13 = myIcon13.getImage();
		Image newimg13 = img13.getScaledInstance(40,40,  java.awt.Image.SCALE_SMOOTH);
		im[12] = new ImageIcon(newimg13);
		//resume
		ImageIcon myIcon14 = new ImageIcon("images\\button\\playBtn.png");
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
		//close
		ImageIcon myIcon17 = new ImageIcon("images\\button\\close.png");
		Image img17 = myIcon17.getImage();
		Image newimg17 = img17.getScaledInstance(25,25,  java.awt.Image.SCALE_SMOOTH);
		im[16] = new ImageIcon(newimg17);


		ba = new ButtonAction();
		
		

		//add JButton and JLable to Jframe


		//Close
		Close = new JButton();
		Close.setLocation(screen.width*79/80,0);
		Close.setSize(25,25);
		Close.setIcon(im[16]);
		Close.addMouseListener(ba);
		getContentPane().add(Close);
		
		//Load
		loadBtn = new JButton("L");
		loadBtn.setLocation(screen.width*71/80,screen.height*17/32);
		loadBtn.setSize(50,50);
		loadBtn.addMouseListener(ba);
		//MapEdit9.setIcon(im[8]);
		getContentPane().add(loadBtn);
		

		//Zoom Out
		zoomOutBtn= new JButton();
		zoomOutBtn.setLocation(screen.width*67/80, screen.height*20/32);
		zoomOutBtn.setSize(40,40);
		zoomOutBtn.setBackground(Color.white);
		zoomOutBtn.setIcon(im[14]);
		zoomOutBtn.addMouseListener(ba);
		getContentPane().add(zoomOutBtn);

		//Zoom In
		zoomInBtn= new JButton();
		zoomInBtn.setLocation(screen.width*75/80, screen.height*20/32);
		zoomInBtn.setSize(40,40);
		zoomInBtn.setBackground(Color.white);
		zoomInBtn.setIcon(im[15]);
		zoomInBtn.addMouseListener(ba);
		getContentPane().add(zoomInBtn);

		//Go to Up
		upBtn= new JButton();
		upBtn.setLocation(screen.width*71/80, (int)(screen.height*20/32));
		upBtn.setSize(40,40);
		upBtn.setBackground(Color.white);
		upBtn.setIcon(im[8]);
		upBtn.addMouseListener(ba);
		getContentPane().add(upBtn);

		//Go To Left
		leftBtn= new JButton();
		leftBtn.setLocation((int)(screen.width*68/80), screen.height*22/32);
		leftBtn.setSize(40,40);
		leftBtn.setBackground(Color.white);
		leftBtn.setIcon(im[11]);
		leftBtn.addMouseListener(ba);
		getContentPane().add(leftBtn);

		//Go To Down
		downBtn= new JButton();
		downBtn.setLocation(screen.width*71/80, screen.height*22/32);
		downBtn.setSize(40,40);
		downBtn.setBackground(Color.white);
		downBtn.setIcon(im[9]);
		downBtn.addMouseListener(ba);
		getContentPane().add(downBtn);

		//Go To Right
		rightBtn= new JButton();
		rightBtn.setLocation((int)(screen.width*74/80), screen.height*22/32);
		rightBtn.setSize(40,40);
		rightBtn.setBackground(Color.white);
		rightBtn.setIcon(im[10]);
		rightBtn.addMouseListener(ba);
		getContentPane().add(rightBtn);
		
		//ResumeBtn
		resumePreview = new JButton();
		resumePreview.setLocation(screen.width*34/40,screen.height*14/32);
		resumePreview.setSize(40,40);
		resumePreview.setBackground(Color.white);
		resumePreview.setIcon(im[13]);
		resumePreview.addMouseListener(ba);
		getContentPane().add(resumePreview);

		//PauseBtn
		pausePreview = new JButton();
		pausePreview.setLocation(screen.width*37/40,screen.height*14/32);
		pausePreview.setSize(40,40);
		pausePreview.setBackground(Color.white);
		pausePreview.setIcon(im[12]);
		pausePreview.addMouseListener(ba);
		getContentPane().add(pausePreview);

		//dayViewer and dateViewer
		dayViewer = new DayViewer();
		dayViewer.setSize(screen.width / 10, screen.width / 20);
		dayViewer.setLocation((screen.width * 17/20), 0);
		dayViewer.setIcon(im[10]);
		getContentPane().add(dayViewer);
		
		dateViewer = new DateViewer();
		dateViewer.setSize(screen.width / 15, screen.width / 15);
		dateViewer.setLocation((screen.width * 29/33), screen.width / 23 );
		getContentPane().add(dateViewer);
		//////////////////////////////////////////


		rj = new RightJpanel(music, map);

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


		map.setLayout(null);
		mm.setLayout(null);

		//setting scroll components
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

		
		//initialize time
		startDate = new int [] {1550,7,0,0};
		int []  temp_startDate = startDate.clone();
		myTime = new MyTime(1000, temp_startDate, map, dayViewer, dateViewer);
		for ( LayerObject l : map.getLayerObject()) {
			l.setMyTime(myTime);
		}
		map.setTimeTree(myTime);

		myTimeThread = new Thread(myTime);
		
		
		setCursor(new SetCursor().setMouseIcon(0));
		
		setVisible(true);
		setResizable(false);

	}

	class ButtonAction implements MouseListener , Runnable{

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
			if(arg0.getSource().equals(loadBtn)){//load
				music.playsound(2,false);
				loadMap();
				map.repaint();
			}
			if(arg0.getSource().equals(resumePreview)){			//resume
				music.playsound(30,false);
				myTime.resume();
			}
			if(arg0.getSource().equals(pausePreview)){	
				music.playsound(31,false);//pause
				myTime.suspend();
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
			if(arg0.getSource().equals(rightBtn)){
				(new Thread(this)).start();
				setWhich_action_entered(1);
			}
			if(arg0.getSource().equals(downBtn)){
				(new Thread(this)).start();
				setWhich_action_entered(2);

			}
			if(arg0.getSource().equals(leftBtn)){
				(new Thread(this)).start();
				setWhich_action_entered(3);
			}
			if(arg0.getSource().equals(upBtn)){
				(new Thread(this)).start();
				setWhich_action_entered(4);
			}
			if(arg0.getSource().equals(zoomInBtn)){
				(new Thread(this)).start();
				setWhich_action_entered(5);

			}
			if(arg0.getSource().equals(zoomOutBtn)){
				(new Thread(this)).start();
				setWhich_action_entered(6);
			}
			if(arg0.getSource().equals(Close)){			//Close
				music.playsound(35, true);
				music.playsound(32, false);
				setVisible(false);
				dispose();
			}

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			setIs_entered(false);
			setWhich_action_entered(0);

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
					map.setFirstLayer((int[][]) in.readObject());
					map.setSecondLayer((int[][]) in.readObject());
					
					in.close();
					reader.close();
					

					//starting new time thread
					
					int [] temp_startDate = startDate.clone();
					myTime.setDate(temp_startDate);

					if(!myTimeThread.isAlive())
						myTimeThread.start();

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

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
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

					

				}
			}

		}


	}
	
	class DayViewer extends JLabel{
		private ImageIcon[] dayViewerImg;
		
		public DayViewer() {
			dayViewerImg = new ImageIcon[2];
			//setting sun and moon pics
			dayViewerImg[0] = new ImageIcon("images\\button\\dayTime.PNG");
			dayViewerImg[1] = new ImageIcon("images\\button\\nightTime.PNG");
		}
		
		public void paint(Graphics p) {
			// TODO Auto-generated method stub
			super.paint(p);
			
			p.drawImage(this.dayViewerImg[ myTime.getDate()[3] ].getImage(), 0, 0,getWidth(),getHeight(), null);
		}
	}
	
	class DateViewer extends JLabel{
		
		
		public DateViewer() {
			this.setFont(new Font("Iomanoid", Font.TRUETYPE_FONT, 30));
		}
		
		public void paint(Graphics p) {
			// TODO Auto-generated method stub
			super.paint(p);
			
			this.setText(myTime.getDate()[0] + "/" + myTime.getDate()[1]);
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

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			//System.out.println(MapEdit());
		}

	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE){
		setVisible(false);
		dispose();
		music.playsound(35 , true);
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}	





