package modifier;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Address {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		InetAddress ip;
		try{
			ip = InetAddress.getLocalHost();
			String localname = ip.getHostName();
			String localip = ip.getHostAddress();
			System.out.println("��������"+localname);
			System.out.println("����Ip��ַ��"+localip);
			
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
	}

}
