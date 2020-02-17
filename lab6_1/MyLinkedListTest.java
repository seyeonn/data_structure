//***************************
 // 파일명: MyLinkedListTest.java
 // 작성자: 안세연
 // 작성일: 2017.09.21
 // 설명: 다음과 같이 정수 리스트를 관리하는 MyLinkedList 클래스를 작성하고 사용하는 프로그램을 작성하시오.
 //***************************

public class MyLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("lab6_1: 안세연");
		System.out.println();

		// 비어있는 리스트를 생성하고 출력
		MyLinkedList list = new MyLinkedList();
		list.printList();		 

		// 리스트의 앞부분에 세개의 값을 삽입하고 출력
		list.addFirst(111);
		list.printList();		 
		list.addFirst(222);
		list.printList();		 
		list.addFirst(333);
		list.printList();	

		// 리스트의 길이를 출력
		System.out.println(list.size());
	}

}
