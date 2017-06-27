package HeadFirst;

public class RunnableTest implements Runnable {
	private int a;
	public void run(){		
		for(int j = 0; j < 50; j++){
			increase();
			System.out.println(Thread.currentThread().getName()+" "+a);
		}	
	}
	public synchronized void increase(){
		int i = a;
		a = i + 1;
	}
	public static void main(String[] args){
		RunnableTest t = new RunnableTest();
		Thread thread1 = new Thread(t);
		Thread thread2 = new Thread(t);
		thread1.setName("yguo");
		thread2.setName("elect");
		thread1.start();
		thread2.start();
//		try {
//			thread1.join();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//		for(int i = 0; i < 10; i++){
//			System.out.println("a="+i);
//		}
	}
}
