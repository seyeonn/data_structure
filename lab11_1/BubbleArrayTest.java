//***************************
 // ���ϸ�: BubbleArrayTest.java
 // �ۼ���: �ȼ���
 // �ۼ���: 2017.12.07
 // ���α׷� ����: bubble sort �˰����� �̿��Ͽ� �������� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 //***************************
import java.util.Scanner;

public class BubbleArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("lab11_1: �ȼ���");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		
		int num;
		
		System.out.print("���� ���� �Է�: ");
		num = scan.nextInt();
		
		int[] arr= new int[num];
		
		System.out.print(num + "���� ������ �Է�: ");
		for(int i=0; i<num; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.print("�迭 ���� ���: ");
		for(int i=0; i<num; i++) {
			System.out.print(arr[i] + " ");
		}
		bubbleSort(arr);
		System.out.println();
		
		System.out.print("���� ���� �� : ");
		for(int i=0; i<num; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
	}

	static public void bubbleSort(int[] arr) {
		
		int temp = 0;
		for(int i=arr.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
