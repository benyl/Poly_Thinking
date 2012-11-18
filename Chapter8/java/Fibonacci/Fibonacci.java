import java.util.Scanner;
import java.util.ArrayList;
public class Fibonacci{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = getAll(1000);//:w
		while(true){
			int n = in.nextInt();
			System.out.println(list.get(n));
			System.out.println(fib(n));
		}
	}
	
	public static ArrayList<Integer> getAll(int max){
		ArrayList<Integer> list = new ArrayList<Integer>(max);
		list.add(0);
		list.add(1);
		for(int i=2;i<max;i++){
			list.add(list.get(i-1)+list.get(i-2));
		}
		return list;
	}

	public static int fib(int n){
		if(n == 1){
			return 1;
		}
		if(n == 0){
			return 0;
		}
		int result = fib(n-1) + fib(n-2);	
		return result;
	}
}
