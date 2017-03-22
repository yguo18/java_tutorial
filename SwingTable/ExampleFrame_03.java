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
		setTitle("������");
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
		// �رձ���е��Զ���������
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		table.setRowSelectionInterval(1, 3);
//		table.addRowSelectionInterval(5, 5);;
		//ѡ��ģʽΪ��ѡ
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(Color.YELLOW);
		//��ѡ���е�ǰ��������ɫ
		table.setSelectionForeground(Color.RED);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		JButton selectAllButton = new JButton("ȫ��ѡ��");
		selectAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				table.selectAll();
//				selectAllButton.setText("��ѡ��ȫ��");
			}
		});
		buttonPanel.add(selectAllButton);
		JButton clearButton = new JButton("ȡ��ѡ��");
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				table.clearSelection();
			}
		});
		buttonPanel.add(clearButton);
		System.out.println("����й���"+table.getRowCount()+"��"+table.getColumnCount()+"��");
		System.out.println("����"+table.getSelectedRowCount()+"�б�ѡ��");
		System.out.println("��3�б�ѡ�е�״̬��"+table.isRowSelected(3));
		System.out.println("��4�б�ѡ�е�״̬��"+table.isRowSelected(4));
		System.out.println("ѡ�еĵ�һ�е�������"+table.getSelectedRow());
		int[] rows = table.getSelectedRows();
		System.out.print("��ѡ�е��У�");
		for (int i : rows) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("���ƶ�ǰ��2�е������ǣ�"+table.getColumnName(1));
		System.out.println("���ƶ�ǰ�ĵ�2�еڶ��е�ֵ�ǣ�"+table.getValueAt(1, 1));
//		table.moveColumn(1, 5);
		System.out.println("���ƶ����2�е������ǣ�"+table.getColumnName(1));
		System.out.println("���ƶ���ĵ�2�еڶ��е�ֵ�ǣ�"+table.getValueAt(1, 1));
	}
	private class MTable extends JTable{
		public MTable(Vector<Vector<String>> rowData, Vector<String> columnNames){
			super(rowData,columnNames);
		}
		public JTableHeader getTableHeader(){
			//��ñ�ͷ����
			JTableHeader tableHeader = super.getTableHeader();
			// ���ñ���в�����������
			tableHeader.setReorderingAllowed(false);
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer)tableHeader.getDefaultRenderer();
			//��������������ʾ
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableHeader;
		}
		//���嵥Ԫ��
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass){
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer)super.getDefaultRenderer(columnClass);
			//���õ�Ԫ�������ʾ
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
