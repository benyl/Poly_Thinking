import java.util.*;


public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map map = new HashMap<Integer,ArrayList<Integer>>();
        
        int[] result = new int[2];
        
        for(int i = 0; i < numbers.length; i++){
            
            ArrayList<Integer> record;
            
            if(map.containsKey(numbers[i])){
                
                record = (ArrayList<Integer>)map.get(numbers[i]);
            
            }else{
                
                record = new ArrayList<Integer>();
            
            }
            
            record.add(i);
            
            map.put(numbers[i],record);
            
        }
        
        for(int i = 0; i < numbers.length ; i++){
            
            int rest = target - numbers[i];
            
            if(map.containsKey(rest)){
                
                ArrayList<Integer> record = (ArrayList<Integer>)map.get(rest);
                
                for(int index : record){
                    
                    if(index != i){
                        
                        result = new int[]{i+1,index+1};
                        

                        Arrays.sort(result);
                        
                        return result;

                    }
                    
                }
                
            }
            
        }
        
        return result;
        
    }
}