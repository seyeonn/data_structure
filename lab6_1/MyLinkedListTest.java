//***************************
 // ���ϸ�: MyLinkedListTest.java
 // �ۼ���: �ȼ���
 // �ۼ���: 2017.09.21
 // ����: ������ ���� ���� ����Ʈ�� �����ϴ� MyLinkedList Ŭ������ �ۼ��ϰ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 //***************************

public class MyLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("lab6_1: �ȼ���");
		System.out.println();

		// ����ִ� ����Ʈ�� �����ϰ� ���
		MyLinkedList list = new MyLinkedList();
		list.printList();		 

		// ����Ʈ�� �պκп� ������ ���� �����ϰ� ���
		list.addFirst(111);
		list.printList();		 
		list.addFirst(222);
		list.printList();		 
		list.addFirst(333);
		list.printList();	

		// ����Ʈ�� ���̸� ���
		System.out.println(list.size());
	}

}
