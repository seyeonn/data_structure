//***************************
 // 파일명: Sort.java
 // 작성자: 안세연
 // 작성일: 2017.12.14
 // 프로그램 설명: 삽입 정렬 알고리즘을 이용하여 학생들을 나이 기준으로 오름차순 정렬하는 프로그램을 작성하시오.
 //***************************

import java.util.Scanner;

public class Sort {

	public static void insertionSort(Student[] a) {
		int i, j;
		Student item;

		for (i = 1; i < a.length; i++) {
			item = a[i];

			for (j = i; (j > 0) && (a[j - 1].getAge() > item.getAge()); j--) {
				a[j] = a[j - 1];
			}
			a[j] = item;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hw11_1: 안세연");
		System.out.println();

		Scanner scan = new Scanner(System.in);

		int account; // 학생 수
		int number; // 학번
		int age; // 나이

		System.out.print("학생 수 입력: ");
		account = scan.nextInt();

		Student[] student = new Student[account];

		for (int i = 0; i < account; i++) {
			System.out.print((i+1) + "번째 학번: ");
			number = scan.nextInt();
			System.out.print((i+1) + "번째 나이: ");
			age = scan.nextInt();
			System.out.println();

			student[i] = new Student(number, age);
		}

		System.out.println();
		System.out.println("정렬 전 학생 정보: ");

		for (int i = 0; i < account; i++) {
			System.out.println(student[i].toString());
		}

		insertionSort(student);

		System.out.println();
		System.out.println("정렬 후 학생 정보: ");

		for (int i = 0; i < account; i++) {
			System.out.println(student[i].toString());
		}
	}
}