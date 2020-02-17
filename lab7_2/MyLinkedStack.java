
public class MyLinkedStack {

	Node top = new Node();

	public boolean isEmpty() {
		return (top == null);
	}

	public void push(int item) {

		Node newNode = new Node(item);
		
		newNode.link = top;
		top = newNode;
		

	}

	public int pop() throws Exception {

		int erase = 0;
		
		if (top == null) {
			throw new Exception("예외 발생");
		}

		erase = top.data;
		
		top = top.link;
		
		return erase;
	}

	public int peek() throws Exception {

		if (top == null) {
			throw new Exception("예외 발생");
		}

		return top.data;

	}

	private class Node {
		int data; 
		Node link; 

		Node() {
			data = 0;
			link = null;
		}

		Node(int data) {
			this.data = data;
			this.link = null;
		}

		Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}

}

	


