import java.util.Scanner;
import java.lang.StringBuffer;
import java.util.Stack;

public class Reverse_Sentense{

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(true){
			String str = s.nextLine();
			System.out.println(str);
			if(str.equals("0") == true){
				break;
			}else{
				String result = reverse(str);
				System.out.println(result);
			}
		}
	}

	public static String reverse(String str){
		StringBuffer buf = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0 ; i < str.length() ; i++){
			if(str.charAt(i) == '.'){
				while(!stack.empty()){
					buf.append(stack.pop());
				}
				buf.append('.');
			}
			if(str.charAt(i) == ' '){
				while(!stack.empty()){
					buf.append(stack.pop());
				}
				buf.append(' ');
			}else{
				stack.push(str.charAt(i));
			}
		}

		return buf.toString();
	}
}
