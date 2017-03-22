package swingContainer;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ExampleFrame_04 extends JFrame{
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField aTextField;
	private JTextField bTextField;
	public static void main(String[] args){
		ExampleFrame_04 frame_04 = new ExampleFrame_04();
		frame_04.setVisible(true);
	}
	public ExampleFrame_04(){
		super();
		setTitle("维护表格模型");
		setBounds(100,100,510,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = {"A","B"};
		String[][] tableValues = {{"1","2"},{"3","4"},{"5","6"}};
		tableModel = new DefaultTableModel(tableValues, columnNames);
		table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				// 获得被选中行的索引
				int selectRow = table.getSelectedRow();
				// 获得单元格的值
				Object oa = tableModel.getValueAt(selectRow, 0);
				Object ob = tableModel.getValueAt(selectRow, 1);
				aTextField.setText(oa.toString());
				bTextField.setText(ob.toString());
			}
		});
		scrollPane.setViewportView(table);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.add(new Label("A: "));
		aTextField = new JTextField("A4", 10);
		panel.add(aTextField);
		panel.add(new Label("B: "));
		bTextField = new JTextField("B4", 10);
		panel.add(bTextField);
		final JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String[] rowValues = {aTextField.getText(), bTextField.getText()};
				tableModel.addRow(rowValues);
				int rowCount = table.getRowCount()+1;
				aTextField.setText("A"+rowCount);
				bTextField.setText("B"+rowCount);
			}
		});
		panel.add(addButton);
		final JButton upButton = new JButton("修改");
		upButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int rowCount = table.getSelectedRow();
				if (rowCount != -1){
					tableModel.setValueAt(aTextField.getText(), rowCount, 0);
					tableModel.setValueAt(bTextField.getText(), rowCount, 1);					
				}
			}
		});
		panel.add(upButton);
		final JButton deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int rowCount = table.getSelectedRow();
				if(rowCount!=-1){
					tableModel.removeRow(rowCount);
				}
			}
		});
		panel.add(deleteButton);
	}
}
