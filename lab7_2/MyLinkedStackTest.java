//***************************
 // 파일명: MyLinkedStackTest.java
 // 작성자: 안세연
 // 작성일: 2017.10.26
 // 설명: 내부적으로 연결 자료구조로 구현한 정수 스택 추상자료형인 MyLinkedStack을 정의하고 이를 이용하는 프로그램을 작성하시오.
 //***************************

import java.util.Scanner;

public class MyLinkedStackTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("lab7_2: 안세연");
		System.out.println();

		MyLinkedStack stack = new MyLinkedStack();

		Scanner scan = new Scanner(System.in);
		
		System.out.println("메뉴 번호를 입력하세요.");
		
		int menu = 0;
		int item = 0;
		
		do {
			System.out.print("1:삽입 2:삭제 3:조회 4:전체삭제 5:종료 --->");
			menu = scan.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.println("삽입 수행");
				System.out.print("삽입할 정수 입력 :");
				item = scan.nextInt();
				stack.push(item);
				break;
				
			case 2:
				System.out.println("삭제 수행");
				System.out.println("삭제한 원소 : " + stack.pop());
				break;
				
			case 3:
				System.out.println("조회 수행");
				System.out.println("조회한 원소 : " + stack.peek());
				break;
				
			case 4:
				System.out.println("전체삭제 수행");
				
				while (!stack.isEmpty()) {
					System.out.print("삭제한 원소 :" + stack.pop() + " ");
				}
				System.out.println();
				break;
				
			case 5:
				System.out.println("프로그램 종료");
				break;
				
			default:
				System.out.println("메뉴 번호 오류");
			}
			
		} while (menu != 9);
	}
}
