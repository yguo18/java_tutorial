package HeadFirst;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation{
	int x = 20;
	int y = 20;
	public void go(){
		JFrame frame = new JFrame("lalal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for(int i = 0; i < 200; i++){
			x++;
			y++;
			drawPanel.repaint();
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.red);
			g.fillRect(x, y, 100, 100);
		}
		
	}
	public static void main(String[] args){
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
}
