package swingContainer;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ExampleFrame_01 extends JFrame{
	public ExampleFrame_01(){
		super();
		setTitle("�������Թ����ı��");
		setBounds(100, 100, 240, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = {"A", "B"}; // ��������������
		//����������
		String[][] rowData = {{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}};
		//����ָ�������������ͱ�����ݵ�����
		JTable table = new JTable(rowData, columnNames);
		// ������ʾ���Ĺ������
		JScrollPane scrollPane = new JScrollPane(table); // �ѱ��Ƕ�������
		//�����������ӵ��߽粼�ֵ��м�
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	public static void main(String[] args){
		ExampleFrame_01 frame_01 = new ExampleFrame_01();
		frame_01.setVisible(true);
	}
}
