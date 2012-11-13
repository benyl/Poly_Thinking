import java.util.Scanner;

public class Rotate{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n;
		while((n = in.nextInt()) > 0){
			int[][] arrays = new int[n][];
			for(int i=0; i < n ; i++){
				arrays[i] = new int[n];
				for(int j = 0 ; j < n ; j++){
					arrays[i][j] = in.nextInt();
				}
			}
			rotate(arrays);
			System.out.print('\n');
			prettyPrint(arrays);
		}
	}

	public static void rotate(int[][] arrays){
		int len = arrays.length - 1;
		int temp;
		for(int i=0;i<=len/2;i++){
			for(int j=i;j<=len/2;j++){
				temp = arrays[i][j]; 
				arrays[i][j] = arrays[len-j][i];
				arrays[len-j][i] = arrays[len-i][len-j];
				arrays[len-i][len-j] = arrays[j][len-i];
				arrays[j][len-i] = temp;
			}
		}
	}

	public static void prettyPrint(int[][] arrays){
		for(int i = 0 ; i < arrays.length ; i++){
			for(int j = 0 ; j < arrays[i].length ; j++){
				System.out.print(arrays[i][j]);
				if(j != arrays[i].length-1){
					System.out.print(' ');
				}
			}
			System.out.print('\n');
		}
	}

}
