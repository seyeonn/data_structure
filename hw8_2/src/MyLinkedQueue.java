import java.util.NoSuchElementException;

class QNode {
	int data;
	QNode link;
}

public class MyLinkedQueue {
	QNode front;
	QNode rear;
	
	public MyLinkedQueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	public void enQueue(int item) {
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
		}
		else {
			rear.link = newNode;
			rear = newNode;
		}
		
	}
	public int deQueue() throws NoSuchElementException{
		if(isEmpty()) {
			throw new  NoSuchElementException();
		}
		else {
			int item = front.data;
			front = front.link;
			
			if(front == null) {
				rear = null;
			}
			return item;
		}
	}


}

