
public class MyLinkedList {
	// (1) �ν��Ͻ� ���� head ����: ���Ḯ��Ʈ�� ù��° ��带 ����Ŵ
	private Node head;	

	// (2) ��Ÿ �ʿ��� �ν��Ͻ� ���� ����
	private int count;

	// (3) ����ִ� ����Ʈ�� ����
	public MyLinkedList() {
		head = null;
		count = 0;

	}

	// (4) ����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {
		// data �ʵ尡 item�� ���ο� Node ��ü�� ����(newNode)
		Node newNode = new Node();
		newNode.data = item;

		// head�� ����Ű�� ���Ḯ��Ʈ�� �� �տ� newNode�� ����
		newNode.link = head;
		head = newNode;

		count++;

	}

	// (5) ����Ʈ�� ���̸� ����
	public int size() {
		return count;

	}

	// ����Ʈ ���ҵ��� ��� ���
	public void printList() {
		Node temp = head;
		System.out.print("[");
		while(temp != null) {
			System.out.print(temp.data);
			temp = temp.link;
			if(temp != null)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	// ����Ʈ���� item�� ����� ��带 Ž���ϴ� private �޼ҵ� -- lab6_1������ ������� ����
	private Node searchNode(int item) {
		Node temp = head;
		while(temp != null) {
			if(item == temp.data)  
				return temp;		// Ž�� ������ �ش� ��� ����
			else 
				temp = temp.link;
		}
		return temp;				// Ž�� ���н� null ����
	}

	// ���Ḯ��Ʈ ��� ������ ǥ���ϴ� private Ŭ����
	private class Node {
		int data;	 // (6) �������� ������ ������ �ʵ� data ����
		Node link;	 // (7) ���� ��� �������� ������ ��ũ �ʵ�link ����

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


