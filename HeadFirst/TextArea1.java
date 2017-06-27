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

public class TextArea1 implements ActionListener{
	JTextArea text;
	public static void main(String[] args){
		TextArea1 gui = new TextArea1();
		gui.go();
	}
	public void go(){
		JFrame frame = new JFrame("Head First");
		JPanel panel = new JPanel();
		JButton button = new JButton("Clicked me");
		button.addActionListener(this);
		text = new JTextArea(10,20);
		text.setLineWrap(true); // 设置自动换行
		
		JScrollPane scrollPane = new JScrollPane(text);//为text对象加上滚动条
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scrollPane);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ev){
		text.append("Button clicked! \n");
	}
}
