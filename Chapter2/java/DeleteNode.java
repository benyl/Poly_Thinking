public class DeleteNode{

	public static void main(String[] args){
		Node a= new Node(1);
		a.next = new Node(2);
		a.next.next = new Node(3);
		
		a.next.next.next = new Node(4);
		a.next.next.next.next = new Node(5);
		a = deleteNode(a,1);
		Node temp = a;
		while(temp!= null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public static Node deleteNode(Node head,int aData){
		Node temp = head;
		if(head.data == aData){
			return head.next;
		}
		while(temp.next!=null){
			if(temp.next.data == aData){
				temp.next = temp.next.next;
				return head;
			}
			temp = temp.next;
		}
		return head;
	}


}
