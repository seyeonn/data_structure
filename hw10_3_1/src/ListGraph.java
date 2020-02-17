

import java.util.LinkedList;

import java.util.Queue;



public class ListGraph {

	private Node[] list;

	private int num; // vertex 개수

	private int[] dfsVisited;// 깊이 우선 탐색 ->방문했는지확인

	private int[] bfsVisited;// 너비 우선 탐색 ->방문했는지확인

	private Queue<Integer> queue = new LinkedList<>();// 너비 우선 탐색



	public ListGraph(int num) {

		list = new Node[num];

		this.num = num;

		dfsVisited = new int[num];

		bfsVisited = new int[num];

	}



	public void addEdge(int vertex1, int vertex2) {

		if ((vertex1 < 0 || vertex1 >= num) || (vertex2 < 0 || vertex2 >= num))// 0~5 범위를 벗어 날때

			System.out.println("그래프에 없는 정점입니다");

		// 리스트에 연결 되어 있는게 있을 경우 -> 앞에 넣어줘야지

		else if (list[vertex2] != null) {

			Node temp = list[vertex2];

			while (temp != null) {

				if (temp.vertex != vertex1)

					temp = temp.link;

				else // temp.vertex가 vertex1이 같다면

				{

					System.out.println("간선이 존재합니다");

					return;

				}

			}

			Node newNode = new Node(); // 새노드를 생성

			newNode.vertex = vertex2;

			newNode.link = list[vertex1];

			list[vertex1] = newNode;

			// 무방향 이므로 하나 더만들어야 한다

			Node make = new Node();

			make.vertex = vertex1;

			make.link = list[vertex2];

			list[vertex2] = make;

		} else {

			Node newNode = new Node(); // 새노드를 생성

			newNode.vertex = vertex2;

			newNode.link = list[vertex1];

			list[vertex1] = newNode;

			// 무방향 이므로 하나 더만들어야 한다

			Node make = new Node();

			make.vertex = vertex1;

			make.link = list[vertex2];

			list[vertex2] = make;

		}

	}



	public void printAdjacentVertices(int vertex) {

		if (vertex < 0 || vertex >= num)

			System.out.println("그래프에 없는 정점입니다");

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



	//깊이 우선 탐색

	public void depthFirstSearch() {

		for (int i = 0; i < num; ++i) //초기화 시키기

			dfsVisited[i] = 0;



		for (int i = 0; i < num; ++i)

			if (dfsVisited[i] == 0) //내가 방문안하면 실행 시키기

				depthFirstSearch(i);

	}

	

	//재귀적 호출

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



	// 너비 우선 탐색

	public void breadthFirstSearch(){

		for (int i = 0; i < num; ++i) // 초기화

			bfsVisited[i] = 0;



		for (int i = 0; i < num; ++i)

			if (bfsVisited[i] == 0)

				breadthFirstSearch(i);

	}

	

	//재귀 호출

	public void breadthFirstSearch(int quest) {

		bfsVisited[quest] = 1;

		System.out.print(quest + " ");

		queue.offer(quest);

		

		while (!queue.isEmpty()) //안비어 있으면 계속 실행

		{

			int pos = queue.poll(); //큐에서 값을 꺼낸다.

			

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

		int vertex;// 정점

		Node link;

	}

	

}