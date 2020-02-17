//***************************
 // 파일명: MyListTest.java
 // 작성자: 안세연
 // 작성일: 2017.09.19
 // 설명:다음과 같이 정수 리스트를 관리하는 MyList 클래스를 작성하고 사용하는 프로그램을 작성하시오.
 //***************************

import java.util.Scanner;

public class MyListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hw5_1: 안세연");
		System.out.println();

		MyList list = new MyList();

		list.add(20);
		list.add(30);
		list.add(20);
		list.add(40);
		list.add(-999);
		list.add(50);
		list.add(90);
		list.add(10);

		System.out.println(list);
		System.out.println("리스트 크기 = " + list.size());
		System.out.println();

		Scanner scanner = new Scanner(System.in);

		int index;
		
		System.out.print("조회할 인덱스 입력: ");
		index = scanner.nextInt();
		System.out.println("인덱스 " + index + "의 원소 = " + list.get(index));
		System.out.println();

		System.out.print("777로 갱신할 인덱스 입력: ");
		index = scanner.nextInt();
		list.remove(index);
		list.add(index, 777);
		System.out.println(list);
		System.out.println();

		System.out.print("999를 삽입할 인덱스 입력: ");
		index = scanner.nextInt();
		list.add(index,999);
		System.out.println(list);
		System.out.println();

		System.out.print("삭제할 인덱스 입력: ");
		index = scanner.nextInt();
		System.out.println("인덱스 " + index + "의 원소 = " + list.get(index));
		list.remove(index);
		System.out.println(list);
		System.out.println();
		
		for(int i=1; i<26; i++) {
			list.add(i);
		}
		System.out.println(list);
	}


}
