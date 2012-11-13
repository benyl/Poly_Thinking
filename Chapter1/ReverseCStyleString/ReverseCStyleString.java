import java.util.Scanner;
import java.util.Stack;
import java.lang.StringBuffer;

public class ReverseCStyleString{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine() ;
			System.out.println(reverse(str)+"\n");
		}
	}

	public static String reverse(String str){
		Stack<Character> stack = new Stack<Character>();
		int i = str.length()-1;
		
		StringBuffer buf = new StringBuffer();
		while(i>=0){
			buf.append(str.charAt(i));
			i--;
		}
		return buf.toString();
	}
}
