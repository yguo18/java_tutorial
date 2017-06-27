package HeadFirst;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class guiTest{
	JButton button1,button2;
	boolean flag = true;
	boolean flag2 = true;
	public static void main(String[] args){
		guiTest gui = new guiTest();
		gui.go();
	}
	public void go(){
		JFrame frame = new JFrame("Tile");
		button1 = new JButton("124");
		button2 = new JButton("woshi2");
		button1.addActionListener(new Button1Listener());
		button2.addActionListener(new Button2Listener());
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	class Button1Listener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			if(flag){
			   button1.setText("clicked");
			   flag = false;
			}else {
				button1.setText("124");
				flag = true;
			}
			
		}
	}
	class Button2Listener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(flag2){
				   button2.setText("clicked");
				   flag2 = false;
				}else {
					button2.setText("124");
					flag2 = true;
				}
		}
	}
}
