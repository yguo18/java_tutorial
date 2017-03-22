package swingContainer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class ExampleFrame_03 extends JFrame{
	public ExampleFrame_03(){
		super();
		setTitle("定义表格");
		setBounds(100,100,500,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = {"A","B","C","D","E","F"};
		Vector<String> columnNameV = new Vector<>();
		for (int column=0; column<columnNames.length; column++){
			columnNameV.add(columnNames[column]);
		}
		Vector<Vector<String>> tableValueV = new Vector<>();
		for(int row=1; row<21; row++){
			Vector<String> rowV = new Vector<>();
			for(int column=0; column<columnNames.length; column++){
				rowV.add(columnNames[column]+row);
			}
			tableValueV.add(rowV);
		}
		DefaultTableModel tableModel = new DefaultTableModel(tableValueV, columnNameV);
//		JTable table = new MTable(tableValueV,columnNameV);
		JTable table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));
		// 关闭表格列的自动调整功能
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.setRowSelectionInterval(1, 3);
//		table.addRowSelectionInterval(5, 5);;
		//选择模式为单选
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(Color.YELLOW);
		//被选择行的前景文字颜色
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		JButton selectAllButton = new JButton("全部选择");
		selectAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				table.selectAll();
//				selectAllButton.setText("已选中全部");
			}
		});
		buttonPanel.add(selectAllButton);
		JButton clearButton = new JButton("取消选择");
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				table.clearSelection();
			}
		});
		buttonPanel.add(clearButton);
		System.out.println("表格中共有"+table.getRowCount()+"行"+table.getColumnCount()+"列");
		System.out.println("共有"+table.getSelectedRowCount()+"行被选中");
		System.out.println("第3行被选中的状态："+table.isRowSelected(3));
		System.out.println("第4行被选中的状态："+table.isRowSelected(4));
		System.out.println("选中的第一行的索引是"+table.getSelectedRow());
		int[] rows = table.getSelectedRows();
		System.out.print("被选中的行：");
		for (int i : rows) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("列移动前第2列的名称是："+table.getColumnName(1));
		System.out.println("列移动前的第2行第二列的值是："+table.getValueAt(1, 1));
//		table.moveColumn(1, 5);
		System.out.println("列移动后第2列的名称是："+table.getColumnName(1));
		System.out.println("列移动后的第2行第二列的值是："+table.getValueAt(1, 1));
	}
	private class MTable extends JTable{
		public MTable(Vector<Vector<String>> rowData, Vector<String> columnNames){
			super(rowData,columnNames);
		}
		public JTableHeader getTableHeader(){
			//获得表头对象
			JTableHeader tableHeader = super.getTableHeader();
			// 设置表格列不可重新排列
			tableHeader.setReorderingAllowed(false);
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer)tableHeader.getDefaultRenderer();
			//设置列名居中显示
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableHeader;
		}
		//定义单元格
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass){
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer)super.getDefaultRenderer(columnClass);
			//设置单元格居中显示
			cr.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
			return cr;
		}
		public boolean isCellEditable(int row,int column){
			return false;
		}
	}
	public static void main(String[] args){
		ExampleFrame_03 frame = new ExampleFrame_03();
		frame.setVisible(true);
	}
}
