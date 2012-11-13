import java.lang.Math;
import java.lang.Integer;
class NodeHelper{
	public static final int MAX = 10;
	public static Node makeList(int length){
		if(length<=0){
			return null;
		}else{
			Node head = new Node((int)(Math.random()*MAX));
			for(int i=0;i<length-1;i++){
				int r =  (int)(Math.random()*MAX);
				head.appendToTail(r);
			}
			return head;
		}
	}
	public static void prettyPrint(Node head){
		Node temp = head;
		int i = 0 ;
		while(temp != null){
			System.out.print("The " + i + "Node : ");
			System.out.println(temp.data);
			temp = temp.next;
			i++;
		}
	}
}
