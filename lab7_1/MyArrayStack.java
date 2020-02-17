
public class MyArrayStack {

	private int[] stack = new int[10];
	private int top = -1;

	public boolean isFull() {
		return (top == 9);
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public void push(int item) throws Exception {

		if (top == 10) {
			throw new Exception("예외 발생");
		}

		top++;
		stack[top] = item;

	}

	public int pop() throws Exception {

		if (top == -1) {
			throw new Exception("예외 발생");
		}

		return stack[top--];
		
	}

	public int peek() throws Exception {

		if (top == -1) {
			throw new Exception("예외 발생");
		}

		return stack[top];

	}

}
