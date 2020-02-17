//***************************
 // ���ϸ�: Sort.java
 // �ۼ���: �ȼ���
 // �ۼ���: 2017.12.14
 // ���α׷� ����: ���� ���� �˰����� �̿��Ͽ� �л����� ���� �������� �������� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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

		System.out.println("hw11_1: �ȼ���");
		System.out.println();

		Scanner scan = new Scanner(System.in);

		int account; // �л� ��
		int number; // �й�
		int age; // ����

		System.out.print("�л� �� �Է�: ");
		account = scan.nextInt();

		Student[] student = new Student[account];

		for (int i = 0; i < account; i++) {
			System.out.print((i+1) + "��° �й�: ");
			number = scan.nextInt();
			System.out.print((i+1) + "��° ����: ");
			age = scan.nextInt();
			System.out.println();

			student[i] = new Student(number, age);
		}

		System.out.println();
		System.out.println("���� �� �л� ����: ");

		for (int i = 0; i < account; i++) {
			System.out.println(student[i].toString());
		}

		insertionSort(student);

		System.out.println();
		System.out.println("���� �� �л� ����: ");

		for (int i = 0; i < account; i++) {
			System.out.println(student[i].toString());
		}
	}
}