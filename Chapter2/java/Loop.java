import java.util.Scanner;
import java.lang.Math;
public class Loop{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			int n = in.nextInt();
			Node head = NodeHelper.makeList(n);
			int r = (int)(Math.random()*n*2);
			Node temp = head;
			int i = 0;
			Node loop = null;
			while(temp.next != null){
				if(i == r){
					loop = temp;
					System.out.println("the loop start at " + r + " value:"+loop.data);
				}
				temp = temp.next;
				i++;
			}
			if(loop == null){
				System.out.println("No loop");
			}
			NodeHelper.prettyPrint(head);
			temp.next = loop;
			Node result = findLoop(head);
			if(result == null){
				System.out.println("Result : No loop");
			}else{
				System.out.println("Result : Loop value: " + result.data);
				System.out.println("check eq " + (result == loop));
			}
		}


	}

	public static Node findLoop(Node head){
		if(head == null)return null;
		Node fast = head;
		Node slow = head;
		while(true){
			slow = slow.next;
			if(slow == null)return null;
			fast = fast.next;
			if(fast == null) return null;
			fast = fast.next;
			if(fast == null) return null;
			if(slow == fast){
				Node result = head;
				while(true){
					slow = slow.next;
					result = result.next;
					if(slow == result){
						break;
					}
				}
				return result;
			}
		}
	}
}
