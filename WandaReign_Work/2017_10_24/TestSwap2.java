public class TestSwap2 {
	
//由于java中的参数传递都是采用值传递的传递方式，因此不能使用引用符号。
//可以使用重新赋值的方法
private static int[] swap(int a, int b){ 
	int temp = a;
	a = b; 
	b = temp; 
	return new int[]{a,b};
	}

	//下面是主函数的实现 
	public static void main(String[] args){ 
		int a = 4; 
		int b = 6;
		System.out.println("before swap "+"a的值="+a+" b的值="+b); 
		
		
		int[] swap = swap(a,b); 
		a = swap[0]; 
		b = swap[1]; 
		System.out.print(a + " "); 
		System.out.print(b); 
		System.out.println("======");
		System.out.println("after swap "+"a的值="+a+" b的值="+b); 
	}
}