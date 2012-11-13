import java.util.Scanner;
import java.lang.Math;
public class RemoveMiddle{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			Node head = NodeHelper.makeList(n);
			NodeHelper.prettyPrint(head);
			int r = (int)(Math.random()*n);
			Node middle = head;
			for(int i=0;i<r;i++){
				middle = middle.next;
			}
			System.out.println("deleting the " + r +" ");
			remove(middle);
			NodeHelper.prettyPrint(head);
		}
	}

	public static void remove(Node middle){
		if(middle.next == null)return;
		middle.data = middle.next.data;
		middle.next = middle.next.next;
	}
}
