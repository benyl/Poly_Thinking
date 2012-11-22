/**

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.


 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;
 
public class Solution {
    
    
    public int maxPathSum(TreeNode root) {

        if(root == null){
            return 0;
        }
        
        HashMap<TreeNode,int []>record = new HashMap<TreeNode,int[]>();
    
        getPathSumFromRoot(root,record);
        
        int result = Integer.MIN_VALUE;
        
        Set<TreeNode> set = record.keySet();
        for(TreeNode node : set){
            int item[] = record.get(node);
            
            int temp = node.val;
            if(item[0] > 0){
                temp += item[0];
            }
            if(item[1] > 0){
                temp += item[1];
            }
            
            if(temp > result){
                result = temp;
            }
        }
    
        return result;
    }
    
    
    int getPathSumFromRoot(TreeNode root, HashMap<TreeNode,int[]> record){
        
        if(record.containsKey(root)){
            int[] rootRecord = record.get(root);
            int result = root.val;
            int childPathMax = Math.max(rootRecord[0],rootRecord[1]);
            if(childPathMax > 0){
                result += childPathMax;
            }
            return result;
        }else{
            int[] newrecord = new int[2];
            
            // if the current node is leaf;
            if(root.left == null && root.right == null){
                newrecord[0] = 0 ;
                newrecord[1] = 0 ;
                record.put(root,newrecord);
                return root.val;
            }
            else{
                if(root.left == null){
                    newrecord[0] = 0;
                }else{
                    newrecord[0] = getPathSumFromRoot(root.left,record);
                }
                if(root.right == null){
                    newrecord[1] = 0;
                }else{
                    newrecord[1] = getPathSumFromRoot(root.right,record);
                }
                record.put(root,newrecord);
                int result = root.val;
                int childPathMax = Math.max(newrecord[0],newrecord[1]);
                if(childPathMax > 0){
                    result += childPathMax;
                }
                return result;
            }
                
        }
    }
    
    
}