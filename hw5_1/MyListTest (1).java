//***************************
 // ���ϸ�: MyListTest.java
 // �ۼ���: �ȼ���
 // �ۼ���: 2017.09.19
 // ����:������ ���� ���� ����Ʈ�� �����ϴ� MyList Ŭ������ �ۼ��ϰ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 //***************************

import java.util.Scanner;

public class MyListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hw5_1: �ȼ���");
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
		System.out.println("����Ʈ ũ�� = " + list.size());
		System.out.println();

		Scanner scanner = new Scanner(System.in);

		int index;
		
		System.out.print("��ȸ�� �ε��� �Է�: ");
		index = scanner.nextInt();
		System.out.println("�ε��� " + index + "�� ���� = " + list.get(index));
		System.out.println();

		System.out.print("777�� ������ �ε��� �Է�: ");
		index = scanner.nextInt();
		list.remove(index);
		list.add(index, 777);
		System.out.println(list);
		System.out.println();

		System.out.print("999�� ������ �ε��� �Է�: ");
		index = scanner.nextInt();
		list.add(index,999);
		System.out.println(list);
		System.out.println();

		System.out.print("������ �ε��� �Է�: ");
		index = scanner.nextInt();
		System.out.println("�ε��� " + index + "�� ���� = " + list.get(index));
		list.remove(index);
		System.out.println(list);
		System.out.println();
		
		for(int i=1; i<26; i++) {
			list.add(i);
		}
		System.out.println(list);
	}


}
