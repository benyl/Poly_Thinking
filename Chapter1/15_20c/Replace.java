import java.util.Scanner;
import java.lang.StringBuffer;
public class Replace{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String input =  in.nextLine();
			StringBuffer buf = new StringBuffer();
			for(int i=0;i<input.length();i++){
				if(input.charAt(i) == ' '){
					buf.append("%20");
				}else{
					buf.append(input.charAt(i));
				}

			}
			System.out.println(buf.toString());
		}
	}
}
