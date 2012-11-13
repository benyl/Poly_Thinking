import java.util.Scanner;
import java.util.Arrays;
public class Anagrams{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			String str = in.nextLine();
			String[] input = str.split(" ");
			if(input.length < 2)continue;
			char[] arr1 = input[0].toCharArray();
			char[] arr2 = input[1].toCharArray();
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			System.out.println(Arrays.equals(arr1,arr2));
		}

	}
}
