

import java.util.LinkedList;

import java.util.Queue;



public class ListGraph {

	private Node[] list;

	private int num; // vertex ����

	private int[] dfsVisited;// ���� �켱 Ž�� ->�湮�ߴ���Ȯ��

	private int[] bfsVisited;// �ʺ� �켱 Ž�� ->�湮�ߴ���Ȯ��

	private Queue<Integer> queue = new LinkedList<>();// �ʺ� �켱 Ž��



	public ListGraph(int num) {

		list = new Node[num];

		this.num = num;

		dfsVisited = new int[num];

		bfsVisited = new int[num];

	}



	public void addEdge(int vertex1, int vertex2) {

		if ((vertex1 < 0 || vertex1 >= num) || (vertex2 < 0 || vertex2 >= num))// 0~5 ������ ���� ����

			System.out.println("�׷����� ���� �����Դϴ�");

		// ����Ʈ�� ���� �Ǿ� �ִ°� ���� ��� -> �տ� �־������

		else if (list[vertex2] != null) {

			Node temp = list[vertex2];

			while (temp != null) {

				if (temp.vertex != vertex1)

					temp = temp.link;

				else // temp.vertex�� vertex1�� ���ٸ�

				{

					System.out.println("������ �����մϴ�");

					return;

				}

			}

			Node newNode = new Node(); // ����带 ����

			newNode.vertex = vertex2;

			newNode.link = list[vertex1];

			list[vertex1] = newNode;

			// ������ �̹Ƿ� �ϳ� �������� �Ѵ�

			Node make = new Node();

			make.vertex = vertex1;

			make.link = list[vertex2];

			list[vertex2] = make;

		} else {

			Node newNode = new Node(); // ����带 ����

			newNode.vertex = vertex2;

			newNode.link = list[vertex1];

			list[vertex1] = newNode;

			// ������ �̹Ƿ� �ϳ� �������� �Ѵ�

			Node make = new Node();

			make.vertex = vertex1;

			make.link = list[vertex2];

			list[vertex2] = make;

		}

	}



	public void printAdjacentVertices(int vertex) {

		if (vertex < 0 || vertex >= num)

			System.out.println("�׷����� ���� �����Դϴ�");

		else {

			Node temp = list[vertex];

			while (list[vertex] != null) {

				if (temp == null)

					return;

				else {

					System.out.print(temp.vertex + " ");

					temp = temp.link;

				}

			}

		}

	}



	//���� �켱 Ž��

	public void depthFirstSearch() {

		for (int i = 0; i < num; ++i) //�ʱ�ȭ ��Ű��

			dfsVisited[i] = 0;



		for (int i = 0; i < num; ++i)

			if (dfsVisited[i] == 0) //���� �湮���ϸ� ���� ��Ű��

				depthFirstSearch(i);

	}

	

	//����� ȣ��

	public void depthFirstSearch(int quest) {

		dfsVisited[quest] = 1; 

		System.out.print(quest + " ");

		for (int i = 0; i < num; ++i)

			if (list[i] != null && dfsVisited[i] == 0)

			{

				dfsVisited[i] = 1;

				depthFirstSearch(i);

			}

	}



	// �ʺ� �켱 Ž��

	public void breadthFirstSearch(){

		for (int i = 0; i < num; ++i) // �ʱ�ȭ

			bfsVisited[i] = 0;



		for (int i = 0; i < num; ++i)

			if (bfsVisited[i] == 0)

				breadthFirstSearch(i);

	}

	

	//��� ȣ��

	public void breadthFirstSearch(int quest) {

		bfsVisited[quest] = 1;

		System.out.print(quest + " ");

		queue.offer(quest);

		

		while (!queue.isEmpty()) //�Ⱥ�� ������ ��� ����

		{

			int pos = queue.poll(); //ť���� ���� ������.

			

			for(Node temp = list[pos]; temp!= null;  temp = temp.link)

			{

				if(bfsVisited[temp.vertex] ==0 && temp != null)

				{

					bfsVisited[temp.vertex] = 1;

					queue.offer(temp.vertex);

					System.out.print(temp.vertex+" ");	

				}

			}



		}



	}



	private class Node {

		int vertex;// ����

		Node link;

	}

	

}