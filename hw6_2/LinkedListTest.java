//***************************
 // 파일명: LinkedListTest.java
 // 작성자: 안세연
 // 작성일: 2017.09.25
 // 설명: hw6_1과 동일한 결과를 얻는 프로그램을 MyLinkedList 대신, java.util 패키지의 LinkedList 클래스를 이용하여 작성하시오.
 //***************************

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListTest {

	public static void main(String[] args) {

		System.out.println("hw6_2: 안세연");
		
		// (1) 정수형을 저장할 LinkedList 객체생성하여 변수 list에 지정(raw type 사용 금지)
		LinkedList<Integer> list = new LinkedList<Integer>();

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		int index = 0;

		// 종료를 선택할 때까지 반복하여 메뉴를 제공하고 그에 맞는 작업을 수행
		do {
			System.out.print("1:리스트출력 2:맨앞삽입 3:맨앞삭제 4:검색 5:인덱스삽입 6:인덱스삭제 9:종료 --->");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("리스트출력을 수행합니다.");
				System.out.println(list.toString());		// (2)
				break;
			case 2:
				System.out.println("맨앞삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				        list.addFirst(item);		// (3)
				break;
			case 3:
				System.out.println("맨앞삭제를 수행합니다.");
				System.out.println("삭제한 원소 = " +  list.removeFirst());	// (4)
				break;
			case 4:
				System.out.println("검색을 수행합니다.");
				System.out.print("검색할 정수 입력:");
				item = scan.nextInt();
				if(list.contains(item))			// (5)
					System.out.println("검색 성공");
				else
					System.out.println("검색 실패");
				break;
			case 5:
				System.out.println("인덱스삽입을 수행합니다.");
				System.out.print("인덱스 입력:");
				index = scan.nextInt();
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				list.add(index, item);		// (6)
				break;
			case 6:
				System.out.println("인덱스삭제를 수행합니다.");
				System.out.print("인덱스 입력:");
				index = scan.nextInt();
				System.out.println("삭제한 원소 = " +  list.remove(index));	// (7)
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while(menu != 9);
	}
}

