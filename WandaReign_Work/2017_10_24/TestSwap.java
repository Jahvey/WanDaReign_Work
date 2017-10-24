public class TestSwap { /** * @param args */ 
	//定义类变量 
	static int a = 3; 
	static int b = 2; 
	public static void main(String[] args) { 
		TestSwap ts = new TestSwap(); 
		System.out.println("before swap "+"a的值="+a+" b的值="+b); 
		ts.swap(ts.a,ts.b); 
		System.out.println("after swap "+"a的值="+a+" b的值="+b); 
	} 


	//改变的是类变量的值 
	private static void swap(int m, int n) 
	{ 
		int temp; 
		temp = a;
		a = b; 
		b = temp; 
	} 
 
 }