import java.util.NoSuchElementException;

public class MyCircularQueue {
	private int front;
	private int rear;
	private int queueSize;
	private int queue[];
	 
	
	public MyCircularQueue(int num) {
		front = 0;
		rear = 0;
		queueSize = num;
		queue = new int[num];
	}

	public boolean isEmpty() {
		return (front == rear);
	}
	
	public boolean isFull() {
		return (((rear+1) % this.queueSize) == front);
	}
	
	public void enQueue(int num) {
		if(isFull()) {
			System.out.println("πËø≠¿Ã ∞°µÊ√°Ω¿¥œ¥Ÿ.");
		}
		else {
			rear = (rear+1) % queueSize;
			queue[rear] = num;
			
		}
	}
	
	public int deQueue() throws  NoSuchElementException {
		if(isEmpty()) {
			throw new  NoSuchElementException();
		}
		else {
			front = (front+1) % queueSize;
			return queue[front];
		}
	}
}
