import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
public class Bracket{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			ArrayList<String> result = solve(n);
			for(String line:result){
				System.out.println(line);
			}
		}
	}

	static ArrayList<String> solve(int len){
		if(len == 1){
			ArrayList<String> result = new ArrayList<String>();
			result.add("()");
			return result;
		}else{
			ArrayList<String> result = new ArrayList<String>();
			ArrayList<String> lastCombine = solve(len-1);
			Set<String> set = new HashSet<String>();
			for(String temp:lastCombine){
				int tempLen = temp.length();
				for(int i=0;i<=tempLen;i++){
					String term = temp.substring(0,i)+"()"+temp.substring(i,tempLen);
					set.add(term);
				}
			}
			for(String item:set){
				result.add(item);
			}
			return result;
		}
	}
}
