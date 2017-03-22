package swingContainer;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ExampleFrame_01 extends JFrame{
	public ExampleFrame_01(){
		super();
		setTitle("创建可以滚动的表格");
		setBounds(100, 100, 240, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = {"A", "B"}; // 定义表格列名数组
		//定义表格数据
		String[][] rowData = {{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}};
		//创建指定表格列名数组和表格数据的数组
		JTable table = new JTable(rowData, columnNames);
		// 创建显示表格的滚动面板
		JScrollPane scrollPane = new JScrollPane(table); // 把表格嵌入面板中
		//将滚动面板添加到边界布局的中间
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	public static void main(String[] args){
		ExampleFrame_01 frame_01 = new ExampleFrame_01();
		frame_01.setVisible(true);
	}
}
