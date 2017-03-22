package swingContainer;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class ExampleFrame_02 extends JFrame{
	public ExampleFrame_02(){
		super();
		setTitle("创建不可滚动的表格");
		setBounds(100,100,240,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vector<String> columnNameV = new Vector<>();// 定义表格列名向量
		columnNameV.add("A");
		columnNameV.add("B");
		Vector<Vector<String>> tableValueV = new Vector<>();
		for(int row = 1; row < 10; row++){
			Vector<String> rowV = new Vector<>();
			rowV.add("A"+row);
			rowV.add("B"+row);
			tableValueV.add(rowV);
		}
		// 创建指定表格列名和表格数据的表格
		JTable table = new JTable(tableValueV, columnNameV);
		//将表格添加到边界布局的中间
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		
		JTableHeader tableHeader = table.getTableHeader();
		getContentPane().add(tableHeader,BorderLayout.NORTH);
	}
	public static void main(String[] args){
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}
}
