import java.util.Scanner;
import java.util.Arrays;
public class SetToZero
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			int[][] arrays = new int[n][];
			for(int i=0;i<n;i++){
				arrays[i] = new int[n];
				for(int j=0;j<n;j++){
					arrays[i][j] = in.nextInt();
				}
			}
			setZero(arrays);
			prettyPrint(arrays);

		}
	}	


	public static void setZero(int[][] arrays){
		int len = arrays.length;
		boolean[] rows = new boolean[len];
		boolean[] cols = new boolean[len];
		Arrays.fill(rows,false);
		Arrays.fill(cols,false);
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(arrays[i][j] == 0){
					cols[j] = true;
					rows[i] = true; 
				}
			}
		}
		for(int i=0;i<len;i++){
			if(rows[i] == true)Arrays.fill(arrays[i],0);
			if(cols[i] == true){
				for(int j=0;j<len;j++){
					arrays[j][i] = 0;
				}
			}
		}
	}

	public static void prettyPrint(int[][] arrays){
		for(int i=0;i<arrays.length;i++){
			for(int temp:arrays[i]){
				System.out.print(temp);
				System.out.print(' ');
			}
			System.out.print('\n');
		}
	}
}
