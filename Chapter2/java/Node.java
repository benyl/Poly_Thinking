class Node{
	public Node next = null;
	public int data;
	public Node(){
		this(0);
	}
	public Node(int d){
		data = d;
	}
	public void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
}
