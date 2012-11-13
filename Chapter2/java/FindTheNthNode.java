
import java.util.Scanner;

public class FindTheNthNode{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			Node head = NodeHelper.makeList(n);
			NodeHelper.prettyPrint(head);
			System.out.print("the last ?th node:");
			
			int last = in.nextInt();
			Node t = findNode(head,last);
			if(t != null){
				System.out.println("the last " + last + "th node: " + t.data);
		
			}else{
				System.out.println("wrong");
			}
		}
	}

	public static Node findNode(Node head,int index){
		if(head == null)return null;
		if(index<=0)return null;
		int i = 0;
		Node frontier = head;
		Node result = head;
		for(;i<index;i++){
			//node list size < index
			if(frontier == null) return null;
			frontier = frontier.next;
		}
		while(frontier != null){
			result = result.next;
			frontier = frontier.next;
		}
		return result;	
	}
}
