import java.util.*;
public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        int size = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int i = 0; i < size; i++){
            char temp = s.charAt(i);
            if(temp == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty() == false){
                    int left = stack.pop();
                    map.put(left,i);
                }
            }
        }
        while(map.isEmpty() == false){
            Map.Entry entry = map.pollFirstEntry();
            int left = (Integer)entry.getKey();
            int dest = (Integer)entry.getValue();
            int length = dest - left + 1;
            int next =  dest + 1;
            while(map.containsKey(next)){
                dest = map.get(next);
                length = dest - left + 1;
                next = dest+1;
            }
            if(max < length){
                max = length;
            }
        
        }
        return max ;
    }
}