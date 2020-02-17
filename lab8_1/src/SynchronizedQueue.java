
/*
 * ���ϸ� : SynchronizedQueue.java
 * �ۼ���: 2017�� 11�� 2��
 * �ۼ���: �ȼ���
 * ����: �迭�� ������ ����ȭ�� ���� ť
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue {
	private final Lock lock = new ReentrantLock();
	private final Condition notFull  = lock.newCondition();   //���Ǻ���
	private final Condition notEmpty = lock.newCondition();   //���Ǻ���
	private int[] array;        //���� �迭
	private int capacity;       //�뷮. ��, �迭 ũ��
	private int front = 0;      //���� ť ��
	private int rear = 0;       //���� ť ��
	
	public SynchronizedQueue(int capacity) {    //������
		this.capacity = capacity;  
		array = new int[capacity];
	}
	
	public boolean isEmpty() {    //ť�� ������� Ȯ��
		return front == rear;     //front�� rear�� ���� �� ť�� ����ִ�. true ��ȯ.
	}
	
	public boolean isFull() {     //ť�� ��ȭ�Ǿ����� Ȯ��
		return (rear + 1) % capacity == front;   //�޺κ��� �ε����� 1�� ���Ͽ� �迭 ũ�� ��ŭ ������ �� �������� front�� ������ ť�� ��ȭ����. true ��ȯ
	}

	public void enQueue(int item) throws InterruptedException {    //ť�� ���Ҹ� �����ϴ� �޼ҵ�
		lock.lock();  ////enqueue�� �����Ҷ� ǰ
		try {
			while (isFull()) {       //ť�� ��ȭ�ɶ� ���� �ݺ��� 
				System.out.println("enQueue : ť�� �������� ��ٸ��ϴ�.");
				notFull.await();				//���� ���� ���Ҹ� ������ �� �����Ƿ� ����ȭ������ �� ��ٸ��� ��
			}
			rear = (rear + 1) % capacity;    //rear�� �迭 ũ�⸦ ������ �ȵǹǷ� rear�� 1�� ���ϰ� �迭 ũ�⸦ ���� �������� rear�� �ٽ� ���� 
			array[rear] = item;       //item ����
			notEmpty.signal();        //������� ���� �� ��ٸ��� �ִ� ť�� ���� ��� ��ȣ�� ����
		} finally {
			lock.unlock();   //���
		}
	}

	public int deQueue() throws InterruptedException {    //ť���� ���Ҹ� �����ϴ� �޼ҵ�
		lock.lock();  //dequeue�� �����Ҷ� ǰ
		try {
			while (isEmpty()) {     //ť�� ���� ���� �ݺ���
				System.out.println("\t\tdeQueue : ť�� �� ��ٸ��ϴ�.");
				notEmpty.await();    //������� ���� �� ��ٸ���� ��ɹ�
			}
			front = (front + 1) % capacity;  // front�� 1�� ���ϰ� �迭 ũ�⸦ ���� �������� front�� �ٽ� ���� 
			int item = array[front];     //item�� �迭  ���� ����
			notFull.signal();     //���� ���� �ʾ��� �� ��ٸ��� �ִ� ť�� ���� ��� ��ȣ�� ����
			return item;     //item ����
		} finally {
			lock.unlock();   //���
		}
	}
}

