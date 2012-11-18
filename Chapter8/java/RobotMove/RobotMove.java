import java.util.Scanner;

public class RobotMove{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			walk(0,0,n,"");
		}
	}

	public static boolean walk(int x,int y,int n,String record){
		String newRecord = record + " ("+ x + "," + y +") ";
		if(x == n-1 && y == n-1){
			System.out.println(newRecord);
			return true;
		}else{
			if(x+1<=n-1){
				walk(x+1,y,n,newRecord);
			}
			if(y+1<=n-1){
				walk(x,y+1,n,newRecord);
			}
		}
		return false;
	}

}
