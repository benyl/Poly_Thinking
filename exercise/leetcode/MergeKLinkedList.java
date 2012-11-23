/**

Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

» Solve this problem
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 import java.util.*;
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
         
        
         ListNode result = null;
         
         ListNode current = null;
         
         int size = lists.size();
         
         ListNode[] pointers = new ListNode[size];
         
         
         for(int i = 0; i < size; i++){
             if(lists.get(i) != null){
                pointers[i] = lists.get(i);
             }
         }
         
         TreeMap<Integer,Queue<Integer>> frontier = new TreeMap<Integer,Queue<Integer>>();
         
         for(int i = 0; i < size; i++){
            if(lists.get(i) != null){
                int val = lists.get(i).val;
                if(frontier.containsKey(val)){
                    frontier.get(val).add(i);
                }else{
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.add(i);
                    frontier.put(val,queue);
                }
             }
         }
         while(frontier.isEmpty() == false){
             
                Map.Entry top = frontier.pollFirstEntry();
                int minVal = (Integer)top.getKey();
                Queue<Integer> queue = (Queue<Integer>)top.getValue();
                while(queue.isEmpty() == false){
                //add to result;
                    int nextIndex = queue.poll();
                    ListNode tobeInsert = new ListNode(minVal);
                    if(result == null){
                        result = tobeInsert;
                        current = result;
                    }else{
                        current.next = tobeInsert;
                        current = current.next;
                    }
                    //add to frontier
                    if(pointers[nextIndex].next != null){
                        pointers[nextIndex] = pointers[nextIndex].next;
                        ListNode next = pointers[nextIndex];
                         if(frontier.containsKey(next.val)){
                            frontier.get(next.val).add(nextIndex);
                        }else{
                            Queue<Integer> newqueue = new LinkedList<Integer>();
                            newqueue.add(nextIndex);
                            frontier.put(next.val,newqueue);
                        }
                    }
                }
             
         }
         
         return result;
         
    }
}