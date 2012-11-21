/**
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
**/

import java.lang.Math;
import java.util.*;
public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int width = height.length;
        if(width<1){
            return 0;
        }
        
        Map<Integer,int[]> map = new HashMap<Integer,int[]>();
        
       
        for(int i=0;i<width;i++){
            int[] rec = new int[]{i,i};
            for(int left = 0;left<=i;left++){
                if(height[left]>=height[i]){
                    rec[0] = left;
                    break;
                }
            }
            for(int right = width-1;right >= i;right--){
                if(height[right]>=height[i]){
                    rec[1] = right;
                    break;
                }
            }
            map.put(i,rec);
            
        }
       
        
        int maxVol = 0;
         
        for(int left = 0; left < width;left++){
            int leftHeight = height[left];
            int maxDistance = 0;
            int lowest = map.get(left)[0];
            int farest =  map.get(left)[1];
              
            int distance = Math.max(Math.abs(lowest - left),Math.abs(left - farest));
            if(distance > maxDistance){
                maxDistance = distance;
            }
            int vol = maxDistance * leftHeight;
            if(vol>maxVol)maxVol = vol;
            
        }
        return maxVol;
    }
}