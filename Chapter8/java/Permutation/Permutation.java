//8.4 Write a method to compute all permutations of a string.
import java.util.Scanner;
import java.util.ArrayList;
public class Permutation{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			String str = in.nextLine();
			ArrayList<String> result = permutate(str,0);
			for(String item:result){
				System.out.println(item);
			}
		}

	}


	static ArrayList<String> permutate(String str,int index){
		int len = str.length();
		if(len-1 == index){
			ArrayList<String>result = new ArrayList<String>();
			String last = str.substring(len-1,len);
			result.add(last);
			return result;
		}else{
			ArrayList<String>result = new ArrayList<String>();
			char current = str.charAt(index);
			ArrayList<String>nextPermutation = permutate(str, index + 1);
			for(String permutation : nextPermutation){
				int pLen = permutation.length();
				for(int i=0; i<=pLen; i++){
					String newPermutation = permutation.substring(0,i) + current + permutation.substring(i,pLen);
					result.add(newPermutation);
				}

			}
			return result;
		}
	}
}
