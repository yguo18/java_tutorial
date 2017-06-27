package HeadFirst;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

interface ButDisplay{
	public abstract void display();
}
class BtnEvent implements ButDisplay{
	public void display(){
		System.out.println("Buttom");
	}
}
class ButtonListener extends BtnEvent{
	JFrame jFrame;
	JButton button;
	class ButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			display();
		}
	}
	public void go(){
		jFrame = new JFrame("lou");
		button = new JButton("Cliked me!");
		button.addActionListener(new ButtonActionListener());
		jFrame.getContentPane().add(button);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(200, 200);
		jFrame.setVisible(true);
	}
}
public class GuiTestModify {
	public static void main(String[] args){
		ButtonListener bl = new ButtonListener();
		bl.go();
	}
}
