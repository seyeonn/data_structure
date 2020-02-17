
public class RecursionTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("lab0_8: ¾È¼¼¿¬");
		System.out.println();
		
		g(4);
		System.out.println();
		System.out.println(sum(4));

	}

	private static void g(int n) {
		if(n>0) {
			System.out.println(n + " ");
			g(n-1);
		}
	}

	private static int sum(int n) {	
		if(n>0) {
			return n + sum(n-1);
		}
		else {
			return 0;
		}
	}

}


