package modifier;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MyClient extends JFrame{
	private PrintWriter writer;
	Socket socket;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container cc;
	public MyClient(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane();
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf,"South");
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				writer.println(tf.getText());
				ta.append(tf.getText()+'\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			}
		});
	}
	private void connect(){
		ta.append("尝试连接\n");
		try{
			socket = new Socket("127.0.0.1", 8889);
			writer = new PrintWriter(socket.getOutputStream(),true);
			ta.append("连接完成\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		MyClient client = new MyClient("向服务器发送数据");
		client.setSize(200,200);
		client.setVisible(true);
		client.connect();
	}
}
