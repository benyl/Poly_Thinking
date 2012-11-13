import java.util.HashMap;
public class RemoveDuplicateNode{

	public static void main(String[] args){
		
		Node head = NodeHelper.makeList(15);
		NodeHelper.prettyPrint(head);
		head = removeDuplicateWithoutBuf(head);
		NodeHelper.prettyPrint(head);
	}
	public static Node removeDuplicate(Node head){
		if(head == null) return null;
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		map.put(head.data,true);
		Node temp = head;
		while(temp.next != null){
			if(map.get(temp.next.data) != null){
				if(temp.next.next != null){
					temp.next = temp.next.next;
				}else{
					temp.next = null;
				}
			}else{
				map.put(temp.next.data,true);
				temp = temp.next;
			}
		}
		return head;
	}
	public static Node removeDuplicateWithoutBuf(Node head){
		if(head == null) return null;	
		Node current = head;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
		return head;
	}
}
