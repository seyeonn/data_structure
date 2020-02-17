//***************************
 // 파일명: MyCircularQueueTest.java
 // 작성자: 안세연
 // 작성일: 2017.11.07
 // 설명: int형 자료를 저장하는 큐를 원형 큐로 구현하고 사용하는 프로그램을 작성하시오.
 //***************************

import java.util.Scanner;

public class MyCircularQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hw8_1: 안세연");
		System.out.println();

		MyCircularQueue CircularQueue = new MyCircularQueue(5);

		Scanner scan = new Scanner(System.in);

		int menu=0;
		int num=0;

		do {
			System.out.print("1:삽입 2:삭제 3:전체삭제 4:종료 --->");
			menu = scan.nextInt();

			switch(menu) {
			case 1:
				System.out.println("삽입 수행");
				System.out.print("정수값 입력: ");
				num = scan.nextInt();
				CircularQueue.enQueue(num);
				System.out.println();
				break;

			case 2:
				System.out.println("삭제 수행");
				System.out.print("삭제한 원소: ");
				System.out.println(CircularQueue.deQueue());
				System.out.println();
				break;

			case 3:
				System.out.println("전체삭제 수행");

				while (!CircularQueue.isEmpty()) {
					System.out.print("삭제할 원소: ");
					System.out.println(CircularQueue.deQueue());		
				}
				System.out.println();
				break;

			case 4:
				System.out.println("프로그램 종료");
				System.out.println();
				break;

			default:
				System.out.println("메뉴 번호 오류");
				System.out.println();
				
			}
		} while (menu != 4);


	}

}


