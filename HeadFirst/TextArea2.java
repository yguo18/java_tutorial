package HeadFirst;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextArea2 {
	JTextArea text;
	public static void main(String[] args){
		TextArea2 gui = new TextArea2();
		gui.go();
	}
	public void go(){
		JFrame frame = new JFrame("Head First");
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		JButton button1 = new JButton("Click");
		JButton button2 = new JButton("Clear");
		text = new JTextArea(10,20);
		text.setLineWrap(true);
		button1.addActionListener(new Button1Listener());
		button2.addActionListener(new Button2Listener());
		container1.add(button1);
		container1.add(button2);
		JScrollPane scrollPane = new JScrollPane(text);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		container2.add(scrollPane);
		frame.getContentPane().add(BorderLayout.CENTER, container2);
		frame.getContentPane().add(BorderLayout.SOUTH, container1);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}
	
	class Button1Listener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			text.append("button clicked! \n");
			System.out.println("add sucessed");
		}
	}
	class Button2Listener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			text.setText("");
			System.out.println("clear!");
		}
	}
}
