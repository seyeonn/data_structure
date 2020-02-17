
/*
 * ���ϸ�: MyDoublyLinkedList.java
 * �ۼ���: �ȼ���
 * �ۼ���: 2017�� 10�� 11��
 * ����: ���߿����ڷᱸ���� ��������Ʈ�� ������ MyDoublyLinkedList Ŭ����
 */

public class MyDoublyLinkedList {

	private Node head; // ����Ʈ�� ù��° ��带 ����ų ����
	private int count; // ����Ʈ�� ���� ���� ��Ÿ���� ����

	public MyDoublyLinkedList() {
		head = null;
		count = 0;
	}

	// ����Ʈ ���̸� ����
	public int size() {
		return count;
	}

	// ����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {

		// (1) �����Ͱ� item�� ���ο� ��� ����
		Node newNode = new Node();
		newNode.data = item;

		// (2) ���ο� ��带 ����Ʈ�� �� �տ� ����
		if (head == null) {
			head = newNode;
		} else {
			newNode.rlink = head;
			newNode.rlink.llink = newNode;
			head = newNode;
		}
		// (3) ���� �� 1 ����
		count++;

	}

	public int removeFirst() {
		int erase = 0;

		if (head != null) {
			if (head.rlink == null) {
				erase = head.data;
				head = head.rlink;
				count--;
			} else {
				erase = head.data;
				head.rlink.llink = head.llink;
				head = head.rlink;
				count--;
			}

		} else {
			System.out.println("������ ���� �����ϴ�.");
			System.exit(0);
		}
		return erase;
	}

	public void remove(int num) {
		if (head == null) {
			return;
		}

		else if (head.rlink == null) {
			if (head.data == num) {
				head = null;
				count--;
			}
		} else {
			Node temp = head;

			if (head.data == num) {
				head.rlink.llink = head.llink;
				head = head.rlink;
				count--;
			}

			else {
				while (temp.rlink.rlink != null) {
					if (temp.rlink.data == num) {
						temp.rlink.rlink.llink = temp;
						temp.rlink = temp.rlink.rlink;
						count--;
						break;
					}
					temp = temp.rlink;
				}
				if (temp.rlink.rlink == null) {
					if (temp.rlink.data == num) {
						temp.rlink = temp.rlink.rlink;
						count--;
					}
				}

			}
		}
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("[");
		Node temp = head;

		while (temp != null) {
			str.append(temp.data);
			temp = temp.rlink;

			if (temp != null) {
				str.append(", ");
			}
		}
		str.append("]");
		return str.toString();
	}

	// ����Ʈ�� ����⿬���� ����� �̷�������� Ȯ��
	public void printLink() {
		if (head == null) {
			System.out.println("���鸮��Ʈ��");
		} else {
			// ����Ʈ�� ���������� ���
			Node temp = head;
			System.out.print("����Ʈ ����=" + count + " ������ ��ũ: ");
			while (temp.rlink != null) {
				System.out.print(temp.data + "->");
				temp = temp.rlink;
			}
			System.out.print(temp.data);

			// ����Ʈ�� ���������� ���
			System.out.print(" ������ ��ũ: ");
			while (temp.llink != null) {
				System.out.print(temp.data + "->");
				temp = temp.llink;
			}
			System.out.println(temp.data);
		}
	}

	// ���߿��Ḯ��Ʈ ��� ����
	private class Node {
		int data;
		Node llink;
		Node rlink;

		Node() {
			this(0, null, null);
		}

		Node(int data) {
			this(data, null, null);
		}

		Node(int data, Node llink, Node rlink) {
			this.data = data;
			this.llink = llink;
			this.rlink = rlink;
		}
	}
}
