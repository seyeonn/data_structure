public class MyLinkedList {
	// (1) 인스턴스 변수 head 선언: 연결리스트의 첫번째 노드를 가리킴
	private Node head;

	// (2) 기타 필요한 인스턴스 변수 선언
	private int count;

	// (3) 비어있는 리스트를 생성
	public MyLinkedList() {
		head = null;
		count = 0;

	}

	// (4) 리스트의 맨 앞에 item을 삽입
	public void addFirst(int item) {
		// data 필드가 item인 새로운 Node 객체를 생성(newNode)
		Node newNode = new Node();
		newNode.data = item;

		// head가 가리키는 연결리스트의 맨 앞에 newNode를 삽입
		newNode.link = head;
		head = newNode;

		count++;

	}

	// (5) 리스트의 길이를 리턴
	public int size() {
		return count;

	}

	// 리스트 원소들을 모두 출력
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
			System.out.println("삭제할 값이 없습니다.");
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
			System.out.println("잘못된 인덱스 입니다.");
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
			System.out.println("잘못된 인덱스 입니다.");
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
	// 리스트에서 item이 저장된 노드를 탐색하는 private 메소드 -- lab6_1에서는 사용하지 않음

	private Node searchNode(int item) {
		Node temp = head;
		while (temp != null) {
			if (item == temp.data)
				return temp; // 탐색 성공시 해당 노드 리턴
			else
				temp = temp.link;
		}
		return temp; // 탐색 실패시 null 리턴
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
		int data; // (6) 정수값을 저장할 데이터 필드 data 선언
		Node link; // (7) 다음 노드 참조값을 저장할 링크 필드link 선언

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

// 연결리스트 노드 구조를 표현하는 private 클래스
