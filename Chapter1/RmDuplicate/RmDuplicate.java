import java.util.Scanner;
import java.lang.StringBuffer;
public class RmDuplicate{

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			String str = scanner.nextLine();
			StringBuffer buf = new StringBuffer(str);
			System.out.println(remove(buf));
		}
	}

	public static String remove(StringBuffer str){
		if(str==null)return "";
		if(str.length()<2)return str.toString();
		int len = str.length();
		int replace = len;
		int last = 1;
		for(int i = 1; i < len ; i++){
			boolean flag = false;
			int p;
			for(p = 0; p < i ; p++){
				if(str.charAt(p) == str.charAt(i)){
					flag = true;
					break;
				}
			}
			if(flag == false){
				str.setCharAt(last,str.charAt(i));
				last++;
			}
		}
		return str.substring(0,last);
	}

}
