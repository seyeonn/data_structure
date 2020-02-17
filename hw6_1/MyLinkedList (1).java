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
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.link;
			if (temp != null)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	public int removeFirst() {
		int erase =0;

		if (head != null) {
			erase=head.data;
			head = head.link;
			count--;

		} else {
			System.out.println("������ ���� �����ϴ�.");
			System.exit(0);
		}
		return erase;
	}

	public boolean contains(int num) {
		Node temp = head;
		while (temp != null) {
			if (num == temp.data)
				return true;
			temp = temp.link;
		}
		return false;
	}

	public void add(int index, int num) {
		if (count < index) {
			System.out.println("�߸��� �ε��� �Դϴ�.");
		} 
		else {
			Node newNode = new Node();
			newNode.data = num;

			Node temp = head;

			if(index ==0) {
				newNode.link = head;
				head = newNode;
				count++;
			}
			else {

				for (int i = 0; i < index-1; i++) {
					temp = temp.link;
				}
				newNode.link = temp.link;
				temp.link = newNode;
				count++;
			}
		}
	}

	public int remove(int index) {
		int erase = 0;

		if(count <= index) {
			System.out.println("�߸��� �ε��� �Դϴ�.");
			System.exit(0);
		}
		else {

			Node temp = head;

			if(index == 0) {
				erase= temp.data;
				head = temp.link;
				count--;		
			}
			else {

				for (int i = 0; i < index-1; i++) {
					temp = temp.link;
				}
				erase= temp.link.data;
				temp.link = temp.link.link;
				count--;

			}

		}
		return erase;
	}
	// ����Ʈ���� item�� ����� ��带 Ž���ϴ� private �޼ҵ� -- lab6_1������ ������� ����

	private Node searchNode(int item) {
		Node temp = head;
		while (temp != null) {
			if (item == temp.data)
				return temp; // Ž�� ������ �ش� ��� ����
			else
				temp = temp.link;
		}
		return temp; // Ž�� ���н� null ����
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("[");
		Node temp = head;

		while( temp != null) {
			str.append(temp.data );
			temp = temp.link;

			if (temp != null) {
				str.append(", ");
			}
		}
		str.append("]");
		return str.toString();
	}

	private class Node {
		int data; // (6) �������� ������ ������ �ʵ� data ����
		Node link; // (7) ���� ��� �������� ������ ��ũ �ʵ�link ����

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

// ���Ḯ��Ʈ ��� ������ ǥ���ϴ� private Ŭ����
