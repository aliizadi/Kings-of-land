package frames;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AboutUs extends JFrame {
	private Dimension screen;
	private Button Close;
	private ImageIcon  backGround;
	private ImageIcon cl;
	private JLabel  Au0 , Au1 , Au2 , Au3 ,Au4 , Au5 , Au6 ,Au7;
	
	 public AboutUs(int width , int height) {
		// TODO Auto-generated constructor stub
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		backGround = new ImageIcon("images\\BackGround\\AboutUs.jpg");
		setLayout(null);
		setSize(backGround.getIconWidth(),backGround.getIconHeight());
		setLocation(screen.width/8, 0);
		setUndecorated(true);
		setContentPane(new JLabel(backGround));
		Au1 = new JLabel();
		Au1.setSize(500 , 100);
		Au1.setLocation((int)screen.getWidth()*3/10,(int)screen.getHeight()/6);
		Au1.setVerticalTextPosition(JLabel.CENTER);
		Au1.setHorizontalTextPosition(JLabel.CENTER);
		Au1.setText("*KING OF LANDS*");
		Au1.setFont(new Font("Oxin", Font.TRUETYPE_FONT, 20));
		getContentPane().add(Au1);
		
		Au2 = new JLabel();
		Au2.setSize(1000 , 100);
		Au2.setLocation((int)screen.getWidth()*1/5,(int)screen.getHeight()*6/25);
		Au2.setVerticalTextPosition(JLabel.CENTER);
		Au2.setHorizontalTextPosition(JLabel.CENTER);
		Au2.setText("This Project it is very Hard Because The Project Deadline Very Short");
		Au2.setFont(new Font("Oxin", Font.TRUETYPE_FONT, 20));
		getContentPane().add(Au2);

		Au3 = new JLabel();
		Au3.setSize(1000 , 100);
		Au3.setLocation((int)screen.getWidth()*1/8,(int)screen.getHeight()*7/25);
		Au3.setVerticalTextPosition(JLabel.CENTER);
		Au3.setHorizontalTextPosition(JLabel.CENTER);
		Au3.setText("Me AmirHOssein Shariatikia and My Teammate Ali Izadi And Pooya Torabi Hard Tey to Creat This Game");
		Au3.setFont(new Font("Oxin", Font.TRUETYPE_FONT, 20));
		getContentPane().add(Au3);

		Au4 = new JLabel();
		Au4.setSize(1000 , 100);
		Au4.setLocation((int)screen.getWidth()*26/100,(int)screen.getHeight()*8/25);
		Au4.setVerticalTextPosition(JLabel.CENTER);
		Au4.setHorizontalTextPosition(JLabel.CENTER);
		Au4.setText("and Hope You Are Enjoing toplaying");	
		Au4.setFont(new Font("Oxin", Font.TRUETYPE_FONT, 20));
		getContentPane().add(Au4);
		
		Au5 = new JLabel();
		Au5.setSize(1000 ,100);
		Au5.setLocation((int)screen.getWidth()*53/400,(int)screen.getHeight()*9/25);
		Au5.setVerticalTextPosition(JLabel.CENTER);
		Au5.setHorizontalTextPosition(JLabel.CENTER);
		Au5.setText("In End of We thank our good professor For This Hard Project and Should Us to learning Very Things");
		Au5.setFont(new Font("Oxin", Font.TRUETYPE_FONT, 20));
		getContentPane().add(Au5);
		

		Au6 = new JLabel();
		Au6.setSize(1000 ,100);
		Au6.setLocation((int)screen.getWidth()*53/400,(int)screen.getHeight()*10/25);
		Au6.setVerticalTextPosition(JLabel.CENTER);
		Au6.setHorizontalTextPosition(JLabel.CENTER);
		Au6.setText("The Second Version Coming Soon....");
		Au6.setFont(new Font("Oxin", Font.TRUETYPE_FONT, 20));
		getContentPane().add(Au6);
		
		Au7 = new JLabel();
		Au7.setSize(1000 ,100);
		Au7.setLocation((int)screen.getWidth()*3/10,(int)screen.getHeight()*11/25);
		Au7.setVerticalTextPosition(JLabel.CENTER);
		Au7.setHorizontalTextPosition(JLabel.CENTER);
		Au7.setText("@CopyRight 2016 _ 2017");
		Au7.setFont(new Font("Oxin", Font.TRUETYPE_FONT, 20));
		getContentPane().add(Au7);
		
		
		ImageIcon myIcon17 = new ImageIcon("images\\button\\back.jpg");
		Image img17 = myIcon17.getImage();
		Image newimg17 = img17.getScaledInstance(200,50,  java.awt.Image.SCALE_SMOOTH);
		cl = new ImageIcon(newimg17);		
		//Close
		Close = new Button();
		Close.setLocation((int)screen.getWidth()*5/8,(int)screen.getHeight()*20/25);
		Close.setSize(200,50);
		Close.setIcon(cl);
		add(Close);	
		
		setVisible(true);
	 }
	 

	class Button extends JButton implements ActionListener{
		private static final long serialVersionUID = 1L;
		public Button(){
			addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource()==Close){
				dispose();
			}
		}
	}
	
}