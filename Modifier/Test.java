package modifier;

class Student{
	private int age;
	private String name;
	public Student(){
		System.out.println("�����޲ҹ��캯��");
	}
	public Student(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("�����˺��ι��캯��");
//		actionSum(3, 5);
		eat("��");
	}
	private void actionSum(int a,int b){
		int sum = a + b;
		System.out.println("����������ֵ�ĺ�Ϊ"+sum);
	}
	protected static void eat(String name) {
		System.out.println("���ڳԣ�"+name);
	}
	public void mmmm(){
		System.out.println("���ù�������"+this);
	}
	protected void love(){
		System.out.println("�����ڵ���protected Love����");
	}
}
class Yanjiusheng extends Student{
	private static String name;
	private static int age;
	public Yanjiusheng(){
//		super(name,age);
		System.out.println("yanjiusheng");
		eat("kkk");
		mmmm();
	}
	public void keyan(){
		System.out.println("�����ڿ���");
	}
}
public class Test {
	public static void main(String[] args){
//		Student student2 = new Student("guo", 26); 
//		Student student = new Student();
		Yanjiusheng yanjiusheng = new Yanjiusheng();
//		student.actionSum(3, 4);
//		student.eat();
//		student2.mmmm();
//		yanjiusheng.keyan();
//		yanjiusheng.mmmm();
//		yanjiusheng.love();
//	    Yanjiusheng.eat("sfk");
	}

}
