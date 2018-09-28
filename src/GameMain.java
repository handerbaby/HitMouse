import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameMain extends JFrame{
	
	private Rank rank = new Rank();

	public GameMain(){
		this.getContentPane().setLayout(null);
		addBackground();
		addMenu();
		FrameCommon.initFrame(this, "游戏主界面", 800, 510);
		this.setVisible(true);
	}
	
	public void addBackground(){
		ImageIcon bgImage = new ImageIcon(this.getClass().getResource("image/GameInterface.png"));
		JLabel jlBackground = new JLabel(bgImage);
		jlBackground.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
		this.getLayeredPane().add(jlBackground, new Integer(Integer.MIN_VALUE));
		((JPanel) this.getContentPane()).setOpaque(false);
	}
	
	public void addMenu(){
		ImageIcon imgGameStart = new ImageIcon(this.getClass().getResource("image/GameStart.png"));
		ImageIcon imgGameRank = new ImageIcon(this.getClass().getResource("image/GameRank.png"));
		ImageIcon imgGameHelp = new ImageIcon(this.getClass().getResource("image/GameHelp.png"));
		ImageIcon imgGameExit = new ImageIcon(this.getClass().getResource("image/GameExit.png"));
		JLabel[] menus = new JLabel[4];
		for(int i = 0; i < menus.length; i++){
			menus[i] = new JLabel();
			menus[i].setSize(250, 85);
			this.getContentPane().add(menus[i]);
		}
		
		menus[0].setIcon(imgGameStart);
		menus[1].setIcon(imgGameRank);
		menus[2].setIcon(imgGameHelp);
		menus[3].setIcon(imgGameExit);
		
		menus[0].setLocation(250, 55);
		menus[1].setLocation(250, 150);
		menus[2].setLocation(250, 245);
		menus[3].setLocation(250, 340);
		
		menus[0].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				dispose();
				new ProgressBar();
			}

			public void mousePressed(MouseEvent e){
				menus[0].setLocation(250, 57);
			}

			public void mouseReleased(MouseEvent e){
				menus[0].setLocation(250, 55);
			}
		});
		menus[1].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				rank.jf.setVisible(true);
				rank.read();
			}
			public void mousePressed(MouseEvent e){
				menus[1].setLocation(250, 152);
			}

			public void mouseReleased(MouseEvent e){
				menus[1].setLocation(250, 150);
			}
		});
		menus[2].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
			public void mousePressed(MouseEvent e){
				menus[2].setLocation(250, 247);
			}

			public void mouseReleased(MouseEvent e){
				menus[2].setLocation(250, 245);
			}
		});
		menus[3].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.exit(0);
			}
			public void mousePressed(MouseEvent e){
				menus[3].setLocation(250, 342);
			}

			public void mouseReleased(MouseEvent e){
				menus[3].setLocation(250, 340);
			}
		});
	}
	
	public static void main(String[] args) {
		new GameMain();
	}

}
