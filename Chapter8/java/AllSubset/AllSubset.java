import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class AllSubset{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			ArrayList<Integer> set = new ArrayList<Integer>(n);
			for(int i=0;i<n;i++){	
				set.add((int)(Math.random()*100));
			}
			ArrayList<ArrayList<Integer>> result = subset(set,0);
			for(ArrayList<Integer> temp : result){
					System.out.println(temp.toString());
			}
		}
	}
	
	static ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> set,int index){
		
		int size = set.size();
		if(size == index){
			ArrayList<Integer> empty = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			result.add(empty);
			return result;
		}else{
			
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			int num = set.get(index);
			ArrayList<ArrayList<Integer>> nextSubset = subset(set,index+1);
			for(ArrayList<Integer> list : nextSubset){
				result.add(list);
				ArrayList<Integer> temp = (ArrayList<Integer>)list.clone();
				temp.add(num);
				result.add(temp);
			}
			return result;
		}
	}

}
