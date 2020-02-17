
public class MyList {
	private int[] arr;
	private int save;
	private int count;

	public MyList() {
		arr = new int[10];
		save = 10;
		count = 0;
	}

	public void add(int a) {
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
}
