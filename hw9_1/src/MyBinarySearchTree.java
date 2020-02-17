
/* 
 * ���ϸ�: MyBinarySearchTree.java
 * �ۼ���: 2017.11.23
 * �ۼ���: �ȼ���
 * ����: int�� Ű�� �����ϴ� ����Ž��Ʈ���� �����ڷᱸ���� ������ Ŭ����
 */

import java.util.NoSuchElementException;

class MyBinarySearchTree {
	// Ʈ���� ��Ʈ ��带 ����ų �ν��Ͻ� ���� root �����ϰ� null�� �ʱ�ȭ
	// (��) ...
	private Node root = null;


	// Ʈ���� ��带 ǥ���ϴ� Ŭ���� - �ʵ�(int�� key, leftChild, rightChild), ������(key���� �Ű������Ͽ� �ʱ�ȭ)
	private class Node {
		// (��) ...
		int key;
		Node leftChild;
		Node rightChild;

		public Node(int key) {
			this.key = key;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

	}

	// (1) ��ü��ȸ�� ���� toString() �������̵�
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ���ڿ��� �����ϴ� �޼ҵ�(��� �˰���)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) ��� ����
	public void insert(int key) { 
		root = insertKey(root, key);
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� key�� �����ϴ� �޼ҵ� (��� �˰���)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// ��Ʈ �Һ�
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// ��Ʈ �Һ�        
		}
		else {  // key = p.key �� ��� ���� ����
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// ��Ʈ �Һ�
		}
	}   

	// (3) ���� ��ȸ
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ����ϴ� �޼ҵ�
	private void postorder(Node p) {
		if(p != null) {
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.printf("%d ", p.key);
		}
		// (��) ...
	}
	
	// (4) �˻� - Ʈ���� key�� �����ϴ� �� ���θ� �����ϴ� �޼ҵ�  
		public boolean contains(int key) {
			return contains2(root, key);
		}

		private boolean contains2(Node p, int num) {
			if(p == null)   //Ʈ���� ������ ���
				return false;
			
			if(num == p.key) {   //��尡 1���� ���
				return true;
			}
			else if(num < p.key) {    //num�� ����� �����ͺ��� ���� ���
				return contains2(p.leftChild, num);
			}
			else {   //Ŭ ���
				return contains2(p.rightChild, num);
			}
			
		}
		// (5) �ִ밪 ��ȸ - Ʈ���� �ִ� Ű ���� �����ϴ� �޼ҵ�  
		public int max() {
			if(root == null) {
				// ���� Ʈ���� ��� ���� �߻�
				throw new NoSuchElementException("�ִ밪 ��ȸ ����");
			}
			else {
				return max2(root);
				// ���� Ʈ���� �ƴ� ���, �ִ� Ű ���� ã�� ����
			}
		}
		
		private int max2(Node p) {
			if(p == null) {    //Ʈ���� ������ ���
				throw new NoSuchElementException("Ʈ���� ������ϴ�.");
			}
			
			if(p.rightChild == null) {    //��尡 1���� ���
				return p.key;
			}
			else {    //��尡 2�� �̻��� ���
				return max2(p.rightChild);
			}
		}

		// (6) ����  - Ʈ���� key�� �����ϰ�, ���� ���� ���θ� �����ϴ� �޼ҵ� (�ݺ� �˰���)
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
		
		// (7) ���� - Ʈ������ key�� �����ϰ�, ���� ���� ���θ� �����ϴ� �޼ҵ� 
//		public boolean remove(int key) {
//		}

}
