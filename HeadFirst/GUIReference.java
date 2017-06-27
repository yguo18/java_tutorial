package HeadFirst;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUIReference implements  ListSelectionListener{
	JCheckBox checkBox;
	JList list;
	public static void main(String[] args){
		GUIReference gui = new GUIReference();
		gui.go1();
	}
//	public void go(){
//		JFrame frame = new JFrame("Head First");
//		checkBox = new JCheckBox("go to 100");
//		checkBox.addItemListener(this);
//		frame.add(BorderLayout.NORTH,checkBox);
//		frame.setSize(300, 300);
//		frame.setVisible(true);
//	}
//	public void itemStateChanged(ItemEvent ev){
//		String flag = "off";
//		if(checkBox.isSelected())
//			flag = "on";
//		System.out.println("Check box is "+flag);
//	}
	
	public void go1(){
		JFrame frame = new JFrame("Head First");
		JPanel panel = new JPanel(); 
		String[] listEntries = {"alpha", "beta", "game", "delta", "epsilon", "zeta"};
		list = new JList(listEntries);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);
		frame.add(BorderLayout.CENTER, panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	public void valueChanged(ListSelectionEvent lse){
		if(!lse.getValueIsAdjusting()){
			String selection = (String) list.getSelectedValue();
			System.out.println(selection);
		}
	}
}
