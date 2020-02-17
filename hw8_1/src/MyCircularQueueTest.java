//***************************
 // ���ϸ�: MyCircularQueueTest.java
 // �ۼ���: �ȼ���
 // �ۼ���: 2017.11.07
 // ����: int�� �ڷḦ �����ϴ� ť�� ���� ť�� �����ϰ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 //***************************

import java.util.Scanner;

public class MyCircularQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hw8_1: �ȼ���");
		System.out.println();

		MyCircularQueue CircularQueue = new MyCircularQueue(5);

		Scanner scan = new Scanner(System.in);

		int menu=0;
		int num=0;

		do {
			System.out.print("1:���� 2:���� 3:��ü���� 4:���� --->");
			menu = scan.nextInt();

			switch(menu) {
			case 1:
				System.out.println("���� ����");
				System.out.print("������ �Է�: ");
				num = scan.nextInt();
				CircularQueue.enQueue(num);
				System.out.println();
				break;

			case 2:
				System.out.println("���� ����");
				System.out.print("������ ����: ");
				System.out.println(CircularQueue.deQueue());
				System.out.println();
				break;

			case 3:
				System.out.println("��ü���� ����");

				while (!CircularQueue.isEmpty()) {
					System.out.print("������ ����: ");
					System.out.println(CircularQueue.deQueue());		
				}
				System.out.println();
				break;

			case 4:
				System.out.println("���α׷� ����");
				System.out.println();
				break;

			default:
				System.out.println("�޴� ��ȣ ����");
				System.out.println();
				
			}
		} while (menu != 4);


	}

}


