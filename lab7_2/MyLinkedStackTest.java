//***************************
 // ���ϸ�: MyLinkedStackTest.java
 // �ۼ���: �ȼ���
 // �ۼ���: 2017.10.26
 // ����: ���������� ���� �ڷᱸ���� ������ ���� ���� �߻��ڷ����� MyLinkedStack�� �����ϰ� �̸� �̿��ϴ� ���α׷��� �ۼ��Ͻÿ�.
 //***************************

import java.util.Scanner;

public class MyLinkedStackTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("lab7_2: �ȼ���");
		System.out.println();

		MyLinkedStack stack = new MyLinkedStack();

		Scanner scan = new Scanner(System.in);
		
		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		
		int menu = 0;
		int item = 0;
		
		do {
			System.out.print("1:���� 2:���� 3:��ȸ 4:��ü���� 5:���� --->");
			menu = scan.nextInt();
			
			switch(menu) {
			
			case 1:
				System.out.println("���� ����");
				System.out.print("������ ���� �Է� :");
				item = scan.nextInt();
				stack.push(item);
				break;
				
			case 2:
				System.out.println("���� ����");
				System.out.println("������ ���� : " + stack.pop());
				break;
				
			case 3:
				System.out.println("��ȸ ����");
				System.out.println("��ȸ�� ���� : " + stack.peek());
				break;
				
			case 4:
				System.out.println("��ü���� ����");
				
				while (!stack.isEmpty()) {
					System.out.print("������ ���� :" + stack.pop() + " ");
				}
				System.out.println();
				break;
				
			case 5:
				System.out.println("���α׷� ����");
				break;
				
			default:
				System.out.println("�޴� ��ȣ ����");
			}
			
		} while (menu != 9);
	}
}
