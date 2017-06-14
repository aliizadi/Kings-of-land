package frames;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.applet.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.BoldAction;

import Other.Music;
import Other.MyTime;
import Other.SetCursor;
import firstLayerObject.LayerObject;
import maps.LoadForMulti;
import maps.Map;
import network.GameCube;
import singlePlayer.Castle;

public class Menu extends JFrame implements MouseListener , KeyListener{
	private Dimension screen;
	private Button singlePlayer,multiPlayer,mapEditor,preview,aboutUs,exit;
	private ImageIcon backGround;
	private int number_of_players  ; 
	private Music music;
	public Menu(){
		music = new Music();
		music.playSoundloop(32,false);
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		backGround = new ImageIcon("images\\BackGround\\background 2.jpg");
		setSize(backGround.getIconWidth(),backGround.getIconHeight()); 
		setLocation(screen.width/8,0);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		//setAlwaysOnTop(true);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(backGround));
		//add menu button
		singlePlayer = new Button("SinglePlayer");
		singlePlayer.setSize(200,60);
		singlePlayer.setLocation((int)backGround.getIconWidth()/5,(int)backGround.getIconHeight()*1/9);
		singlePlayer.setFont(new Font("Iomanoid Front", Font.TRUETYPE_FONT, 31));
		singlePlayer.addMouseListener(this);
		getContentPane().add(singlePlayer);
		multiPlayer = new Button("MultiPlayer");
		multiPlayer.setSize(200,60);
		multiPlayer.setLocation((int)backGround.getIconWidth()/5,(int)backGround.getIconHeight()*2/9);
		multiPlayer.setFont(new Font("Iomanoid Front", Font.TRUETYPE_FONT, 31));
		multiPlayer.addMouseListener(this);
		getContentPane().add(multiPlayer);
		mapEditor = new Button("MapEditor");
		mapEditor.setSize(200,60);
		mapEditor.setLocation((int)backGround.getIconWidth()/5,(int)backGround.getIconHeight()*3/9);
		mapEditor.setFont(new Font("Iomanoid Front", Font.TRUETYPE_FONT, 31));
		mapEditor.addMouseListener(this);
		getContentPane().add(mapEditor);
		preview = new Button("Preview");
		preview.setSize(200,60);
		preview.setLocation((int)backGround.getIconWidth()/5,(int)backGround.getIconHeight()*4/9);
		preview.setFont(new Font("Iomanoid Front", Font.TRUETYPE_FONT, 31));
		preview.addMouseListener(this);
		getContentPane().add(preview);
		aboutUs = new Button("AboutUS");
		aboutUs.setSize(200,60);
		aboutUs.setLocation((int)backGround.getIconWidth()/5,(int)backGround.getIconHeight()*5/9);
		aboutUs.setFont(new Font("Iomanoid Front", Font.TRUETYPE_FONT, 31));
		aboutUs.addMouseListener(this);
		getContentPane().add(aboutUs);
		exit = new Button("Exit");
		exit.setSize(200,60);
		exit.setLocation((int)backGround.getIconWidth()/5,(int)backGround.getIconHeight()*6/9);
		exit.setFont(new Font("Iomanoid Front", Font.TRUETYPE_FONT, 31));
		exit.addMouseListener(this);
		getContentPane().add(exit);
		setCursor(new SetCursor().setMouseIcon(0));
		addKeyListener(this);
		setFocusable(true);
		setLayout(null);
		setResizable(false);
		setVisible(true);
	}

	class Button extends JButton implements ActionListener{
		private static final long serialVersionUID = 1L;
		public Button(String s){
			super(s);
			addActionListener(this);
		}


		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if("Exit".equals(getText())){
				music.playSoundloop(32,true);
				music.playsound(2,false);
				long d = System.currentTimeMillis();
				while (d+1000>System.currentTimeMillis());
				System.exit(0);  
			}
			else if("MapEditor".equals(getText())){
				music.playsound(32,true);
				music.playsound(25,false);
				long d = System.currentTimeMillis();
				while (d+1000>System.currentTimeMillis());
				music.playsound(34, false);
				new MainFrame(music);
			}
			else if("Preview".equals(getText())){
				music.playsound(32,true);
				music.playsound(25, false);
				long d = System.currentTimeMillis();
				while (d+1000>System.currentTimeMillis());
				music.playsound(35, false);
				new PreviewFrame(music);          
			}
			else if("SinglePlayer".equals(getText())){
				music.playsound(32,true);
				music.playsound(25,false);
				long d = System.currentTimeMillis();
				while (d+1000>System.currentTimeMillis());
				music.playSoundloop(33,false);
				//new SinglePlayerFrame(music);          
			}
			else if("AboutUS".equals(getText())){
				new AboutUs(getWidth(), getHeight());
			}
			
			else if("MultiPlayer".equals(getText())){
		        int nop = 2;
		        music.playsound(32,true);
		        music.playsound(25,false);
		        long d = System.currentTimeMillis();
		        while (d+1000>System.currentTimeMillis());
		        music.playsound(33, false);
		        GameCube gameCube  = new GameCube();
		        
		        
		        Map map = new Map(1	, 1, gameCube);
		        loadMap(map);
		        new Castle(map, nop);
		        new MultiPlayerFrame(map,gameCube,nop,music);
		        
		        
		        
		      }


		}
	}

	public void setButtonVisible(Boolean set){
		singlePlayer.setVisible(set);
		multiPlayer.setVisible(set);
		mapEditor.setVisible(set);
		preview.setVisible(set);
		aboutUs.setVisible(set);
		exit.setVisible(set);
	}

	public int getNumber_of_players() {
		return number_of_players;
	}

	public static void main(String[] args) {
		new Menu();
	}
	
	
	public void loadMap(Map map)
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
//				JOptionPane.showMessageDialog(null,"Not File Exist");
//				System.out.println(e.getMessage());
			}
		}

		map.setEnabled(true);
	} 

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getComponent()==singlePlayer){
			music.playsound(1,false);
		}
		if(arg0.getComponent()==multiPlayer){
			music.playsound(1,false);
		}
		if(arg0.getComponent()==mapEditor){
			music.playsound(1,false);
		}
		if(arg0.getComponent()==aboutUs){
			music.playsound(1,false);
		}
		if(arg0.getComponent()==preview){
			music.playsound(1,false);
		}
		if(arg0.getComponent()==exit){
			music.playsound(1,false);
		}
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
		if(arg0.getKeyCode()== KeyEvent.VK_F4){
			music.playSoundloop(32,true);
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