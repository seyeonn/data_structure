import java.util.Arrays;

public class MyList {
	private int[] arr;  //정수형 배열
	private int save;  //저장용량
	private int count;  //정수 갯수

	public MyList() {
		arr = new int[10];
		save = 10;
		count = 0;
	}

	public void add(int a) {
		if(save == count) {

			System.out.print("용량 증가 " + save + "-->");
			save = save*2;
			System.out.println(save);

			int[] arr2 = new int[save];

			for(int i=0; i<count; i++) {
				arr2[i] = arr[i];
			}
			arr= arr2;
		}
		arr[count] = a;
		count++;
	}

	public void print() {
		System.out.print("[");

		for(int i=0; i<count; i++) {
			if(i > 0) {
				System.out.print(", " + arr[i]);
			}

			else if(i == 0) {
				System.out.print(arr[i]);	
			}
		}
		System.out.println("]");
	}

	public int get(int index) {
		return arr[index];
	}

	public void set(int index, int num) {
		arr[index] = num;
	}

	public int size() {
		return count;
	}

	public void add(int index, int num) {
		if(save == count) {

			System.out.print("용량 증가 " + save + "-->");
			save = save*2;
			System.out.println(save);

			int[] arr2 = new int[save];

			for(int i=0; i<count; i++) {
				arr2[i] = arr[i];
			}
			arr= arr2;
		}
		
		for(int len=count++; len>index; len-- )
		{
			arr[len] = arr[len-1];
		}
		arr[index] = num;
	}

	public int remove(int index) {

		int result = arr[index];

		for(int len=index; len<count-1; len++) {
			arr[len] = arr[len+1];
		}
		count--;

		return result;

	}

	@Override
	public String toString() {

		StringBuffer str = new StringBuffer("[");
		for(int i=0; i<count-1; i++) {
			str.append(arr[i] + ", ");
		}
		str.append(arr[count-1] + "]");
		return str.toString(); 
	}


}
