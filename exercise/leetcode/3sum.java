/**
3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
» Solve this problem
**/
//  I got AC for this one. But sometime this code would exceed time limit. 
   import java.util.*;

public class Solution {
public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> filter = new HashSet<ArrayList<Integer>>();
        
        int len = num.length;
        
        if(len<3){
            return result;
        }
        
        Arrays.sort(num);
    
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int n : num){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }
        
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                int sum = num[i] + num[j];
                int[] temp = new int[]{num[i],num[j],-sum};
                Arrays.sort(temp);
                if(temp[2]<0 || temp[0]>0){
                    continue;
                }
                ArrayList<Integer> res = new ArrayList<Integer>();
                for(int t:temp){
                    res.add(t);
                
                } 
                if(filter.contains(res)){
                    continue;
                }
                if(map.containsKey(-sum) == false){
                    continue;
                }
                
                
                  // ugly code. but just for not having the program exceed time limit.
                if(temp[0] == temp[1] && map.get(temp[0])<2){
                    continue;
                }
                if(temp[1] == temp[2] && map.get(temp[1])<2){
                    continue;
                }
                if(temp[0] == temp[2] && map.get(temp[0])<3){
                    continue;
                }
                filter.add(res);

            }
    }
    for(ArrayList<Integer> arrlist : filter){
        result.add(arrlist);
    }
    return result;
}
}