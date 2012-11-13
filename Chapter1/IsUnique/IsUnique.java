import java.util.Scanner;
import java.util.Arrays;
public class IsUnique {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(in.hasNextLine()){
			String str = in.nextLine();
			if(str.charAt(0) == '0'){
				break;
			}else{
				int length = 256;
				boolean result = true;
				boolean[] record = new boolean[256];
				Arrays.fill(record,false);
				for(int i=0; i<str.length() ; i++){
					int index = (int)(str.charAt(i));
					if(record[index] == true){
						result = false;
						break;
					}else{
						record[index] = true;
					}
				}
				if(result == true){
					System.out.println("Unique");
				}else{
					System.out.println("Not Unique");
				}
			}
		}
	}
}
