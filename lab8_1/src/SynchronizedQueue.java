
/*
 * 파일명 : SynchronizedQueue.java
 * 작성일: 2017년 11월 2일
 * 작성자: 안세연
 * 내용: 배열로 구현한 동기화된 원형 큐
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue {
	private final Lock lock = new ReentrantLock();
	private final Condition notFull  = lock.newCondition();   //조건변수
	private final Condition notEmpty = lock.newCondition();   //조건변수
	private int[] array;        //정수 배열
	private int capacity;       //용량. 즉, 배열 크기
	private int front = 0;      //원향 큐 앞
	private int rear = 0;       //원형 큐 뒤
	
	public SynchronizedQueue(int capacity) {    //생성자
		this.capacity = capacity;  
		array = new int[capacity];
	}
	
	public boolean isEmpty() {    //큐가 비었는지 확인
		return front == rear;     //front가 rear와 같을 때 큐는 비어있다. true 반환.
	}
	
	public boolean isFull() {     //큐가 포화되었는지 확인
		return (rear + 1) % capacity == front;   //뒷부분의 인덱스에 1을 더하여 배열 크기 만큼 나눠서 그 나머지가 front와 같을때 큐는 포화상태. true 반환
	}

	public void enQueue(int item) throws InterruptedException {    //큐에 원소를 삽입하는 메소드
		lock.lock();  ////enqueue를 실행할때 품
		try {
			while (isFull()) {       //큐가 포화될때 까지 반복문 
				System.out.println("enQueue : 큐가 가득차서 기다립니다.");
				notFull.await();				//가득 차면 원소를 삽입할 수 없으므로 비포화상태일 때 기다리게 함
			}
			rear = (rear + 1) % capacity;    //rear이 배열 크기를 넘으면 안되므로 rear에 1을 더하고 배열 크기를 나눠 나머지를 rear에 다시 저장 
			array[rear] = item;       //item 저장
			notEmpty.signal();        //비어있지 않을 때 기다리고 있는 큐가 있을 경우 신호를 보냄
		} finally {
			lock.unlock();   //잠금
		}
	}

	public int deQueue() throws InterruptedException {    //큐에서 원소를 삭제하는 메소드
		lock.lock();  //dequeue를 실행할때 품
		try {
			while (isEmpty()) {     //큐가 빌때 까지 반복문
				System.out.println("\t\tdeQueue : 큐가 비어서 기다립니다.");
				notEmpty.await();    //비어있지 않을 때 기다리라는 명령문
			}
			front = (front + 1) % capacity;  // front에 1을 더하고 배열 크기를 나눠 나머지를 front에 다시 저장 
			int item = array[front];     //item에 배열  원소 저장
			notFull.signal();     //가득 차지 않았을 때 기다리고 있는 큐가 있을 경우 신호를 보냄
			return item;     //item 리턴
		} finally {
			lock.unlock();   //잠금
		}
	}
}

