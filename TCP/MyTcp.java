package modifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTcp {
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	void getserver(){
		try{
			server = new ServerSocket(8889);
			System.out.println("�������׽����Ѿ������ɹ�");
			while(true){
				System.out.println("�ȴ��ͻ���������");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void getClientMessage(){
		try{
			while(true){
				System.out.println("�ͻ�����"+reader.readLine());		
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader!=null){
				reader.close();
			}
			if(socket!=null){
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		MyTcp tcp1 = new MyTcp();
		tcp1.getserver();
	}
}