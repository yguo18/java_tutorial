package modifier;

class Student{
	private int age;
	private String name;
	public Student(){
		System.out.println("调用无惨构造函数");
	}
	public Student(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("调用了含参构造函数");
//		actionSum(3, 5);
		eat("橡胶");
	}
	private void actionSum(int a,int b){
		int sum = a + b;
		System.out.println("计算了两个值的和为"+sum);
	}
	protected static void eat(String name) {
		System.out.println("我在吃！"+name);
	}
	public void mmmm(){
		System.out.println("调用公共方法"+this);
	}
	protected void love(){
		System.out.println("我们在调用protected Love方法");
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
		System.out.println("我正在科研");
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
