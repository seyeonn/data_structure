
//***************************
// ���ϸ�: MyLinkedQueue.java
// �ۼ���: �ȼ���
// �ۼ���: 2017.11.14
// ����:
//***************************
import java.util.Scanner;

public class MyLinkedQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_2: �ȼ���");
		System.out.println();

		MyLinkedQueue linkedQueue = new MyLinkedQueue();

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
				linkedQueue.enQueue(num);
				System.out.println();
				break;

			case 2:
				System.out.println("���� ����");
				System.out.print("������ ����: ");
				System.out.println(linkedQueue.deQueue());
				System.out.println();
				break;

			case 3:
				System.out.println("��ü���� ����");

				while (!linkedQueue.isEmpty()) {
					System.out.print("������ ����: ");
					System.out.println(linkedQueue.deQueue());		
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


