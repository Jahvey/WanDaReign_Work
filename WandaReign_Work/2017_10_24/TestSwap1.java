public class TestSwap1 { 
//外部内联的方式
	static int a = 3; 
	static int b = 2;
	public static void main(String[] args){ 
		Exchange exc = new Exchange(a,b); 
		System.out.println("before swap "+"a的值="+a+" b的值="+b); 
		exc.swap(exc); 
		//System.out.print(exc.i); 
		a=exc.i;
		b=exc.j;
		System.out.println("after swap "+"a的值="+a+" b的值="+b);
	} 
} 

class Exchange{ 
	int i , j; 
	Exchange(int i, int j){ 
	this.i = i; 
	this.j = j; 
	}

	public void swap(Exchange exc)
	{ 
		int temp = exc.i; 
		exc.i = exc.j;
		exc.j = temp; 
	} 
 }