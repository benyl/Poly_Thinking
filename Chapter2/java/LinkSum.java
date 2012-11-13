import java.util.Scanner;
import java.util.Stack;
public class LinkSum{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(true){
			
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			Node node1 = NodeHelper.makeList(n1);
			Node node2 = NodeHelper.makeList(n2);
			NodeHelper.prettyPrint(node1);
			NodeHelper.prettyPrint(node2);
			Node result = sum(node1,node2);
			NodeHelper.prettyPrint(result);
		}
	}

	public static Node sum(Node node1,Node node2){
		if(node1 == null || node2 == null){
			return null;
		}
		int carrier = 0;
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		while(node1 != null){
			stack1.push(node1.data);
			node1 = node1.next;
		}
		while(node2 != null){
			stack2.push(node2.data);
			node2 = node2.next;
		}
		Stack<Integer> result = new Stack<Integer>();
		while(true){
			if(stack1.empty() && stack2.empty() && carrier == 0) break;
			int x,y;
			if(stack1.empty() == false){
				x = stack1.pop();
			}else{
				x = 0;
			}
			if(stack2.empty() == false){
				y = stack2.pop();
			}else{
				y = 0;
			}
			int temp = x + y + carrier;
			if(temp >= 10){
				temp -= 10;
				carrier = 1;
			}else{
				carrier = 0;
			}
			result.push(temp);
		}
		Node node = new Node(result.pop());
		while(!result.empty()){
			node.appendToTail(result.pop());
		}
		return node;
	}
}
