
public class ListGraph {
	private Node[] list;
	private int n;

	public ListGraph(int n) {
		list = new Node[n];
		this.n =n;
	}

	public void addEdge(int v1, int v2) {
		if(v1<0 || v1>=n || v2<0 || v2>=n) {
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다.");
		}
		else {
			Node temp = list[v1];

			while(temp != null) {
				if(temp.vertex == v2) {
					System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다. ");
					return;				
				}
				temp = temp.link;
			}

			Node newNode1 = new Node();
			newNode1.vertex = v2;

			newNode1.link = list[v1];
			list[v1] = newNode1;

			Node newNode2 = new Node();
			newNode2.vertex = v1;

			newNode2.link = list[v2];
			list[v2] = newNode2;

		}

	}

	public void printAdjacentVertices(int v1) {
		if(v1<0 || v1>=n) {
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다.");
		}
		else {
			Node temp = list[v1];

			System.out.print(v1 + "에 인접한 정점 = ");

			while(temp != null) {
				System.out.print(temp.vertex + " ");
				temp = temp.link;
			}
		}
		System.out.println();
	}


	private class Node {
		int vertex;
		Node link;
	}
}


