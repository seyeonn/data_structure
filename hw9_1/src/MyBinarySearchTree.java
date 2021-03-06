
/* 
 * 파일명: MyBinarySearchTree.java
 * 작성일: 2017.11.23
 * 작성자: 안세연
 * 설명: int형 키값 저장하는 이진탐색트리를 연결자료구조로 구현한 클래스
 */

import java.util.NoSuchElementException;

class MyBinarySearchTree {
	// 트리의 루트 노드를 가리킬 인스턴스 변수 root 선언하고 null로 초기화
	// (가) ...
	private Node root = null;


	// 트리의 노드를 표현하는 클래스 - 필드(int형 key, leftChild, rightChild), 생성자(key값을 매개변수하여 초기화)
	private class Node {
		// (나) ...
		int key;
		Node leftChild;
		Node rightChild;

		public Node(int key) {
			this.key = key;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

	}

	// (1) 전체조회를 위한 toString() 오버라이드
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p를 루트로 하는 트리를 중위 순회하며 키값을 문자열로 리턴하는 메소드(재귀 알고리즘)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) 재귀 삽입
	public void insert(int key) { 
		root = insertKey(root, key);
	}

	// p를 루트로 하는 트리에 key를 삽입하는 메소드 (재귀 알고리즘)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// 루트 불변
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// 루트 불변        
		}
		else {  // key = p.key 인 경우 삽입 실패
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// 루트 불변
		}
	}   

	// (3) 후위 순회
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p를 루트로 하는 트리를 후위 순회하며 키값을 출력하는 메소드
	private void postorder(Node p) {
		if(p != null) {
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.printf("%d ", p.key);
		}
		// (다) ...
	}
	
	// (4) 검색 - 트리에 key가 존재하는 지 여부를 리턴하는 메소드  
		public boolean contains(int key) {
			return contains2(root, key);
		}

		private boolean contains2(Node p, int num) {
			if(p == null)   //트리가 공백일 경우
				return false;
			
			if(num == p.key) {   //노드가 1개일 경우
				return true;
			}
			else if(num < p.key) {    //num이 노드의 데이터보다 작을 경우
				return contains2(p.leftChild, num);
			}
			else {   //클 경우
				return contains2(p.rightChild, num);
			}
			
		}
		// (5) 최대값 조회 - 트리의 최대 키 값을 리턴하는 메소드  
		public int max() {
			if(root == null) {
				// 공백 트리인 경우 예외 발생
				throw new NoSuchElementException("최대값 조회 실패");
			}
			else {
				return max2(root);
				// 공백 트리가 아닌 경우, 최대 키 값을 찾아 리턴
			}
		}
		
		private int max2(Node p) {
			if(p == null) {    //트리가 공백일 경우
				throw new NoSuchElementException("트리가 비었습니다.");
			}
			
			if(p.rightChild == null) {    //노드가 1개일 경우
				return p.key;
			}
			else {    //노드가 2개 이상일 경우
				return max2(p.rightChild);
			}
		}

		// (6) 삽입  - 트리에 key를 삽입하고, 삽입 실패 여부를 리턴하는 메소드 (반복 알고리즘)
		public boolean add(int key) {
			return add2(root, key);
		}
		
		private boolean add2(Node p, int num) {
			if(contains(num) == true) {
				return false;
			}
			else {
				while(true) {
					
					 if(p==null) {
			               Node newNode = new Node(num);
			               p = newNode;
			               root = newNode;
			               break;
			            }
					
					if(num < p.key) {
						if(p.leftChild == null) {
							Node newNode = new Node(num);
							p.leftChild = newNode;
							break;
						}	
						p = p.leftChild;
					}
					else {
						if(p.rightChild == null) {
							Node newNode = new Node(num);
							p.rightChild = newNode;
							break;
						}
						p = p.rightChild;
					}
				}
				return true;
			}
		}
		
		// (7) 삭제 - 트리에서 key를 삭제하고, 삭제 성공 여부를 리턴하는 메소드 
//		public boolean remove(int key) {
//		}

}
