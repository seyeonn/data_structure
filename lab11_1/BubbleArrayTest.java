//***************************
 // 파일명: BubbleArrayTest.java
 // 작성자: 안세연
 // 작성일: 2017.12.07
 // 프로그램 설명: bubble sort 알고리즘을 이용하여 정수값을 오름차순으로 정렬하는 프로그램을 작성하시오.
 //***************************
import java.util.Scanner;

public class BubbleArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("lab11_1: 안세연");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		
		int num;
		
		System.out.print("정수 갯수 입력: ");
		num = scan.nextInt();
		
		int[] arr= new int[num];
		
		System.out.print(num + "개의 정수값 입력: ");
		for(int i=0; i<num; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.print("배열 원소 출력: ");
		for(int i=0; i<num; i++) {
			System.out.print(arr[i] + " ");
		}
		bubbleSort(arr);
		System.out.println();
		
		System.out.print("버블 정렬 후 : ");
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
