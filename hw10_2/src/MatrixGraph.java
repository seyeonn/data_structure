import java.util.LinkedList;
import java.util.Queue;

public class MatrixGraph {
	private int[][] matrix;
	private int n;
	private boolean[] dfsVisited;
	private boolean[] bfsVisited;
	private Queue<Integer> queue = new <Integer> LinkedList();

	public MatrixGraph(int n) {
		matrix = new int[n][n];
		this.n =n;
		dfsVisited = new boolean[n];
		bfsVisited = new boolean[n];
	}

	public void addEdge(int v1, int v2) {
		if(v1<0 || v1>=n || v2<0 || v2>=n) {
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다.");
		}
		else if(matrix[v1][v2] == 1 || matrix[v2][v1] == 1) {
			System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다. ");
		}
		else {
			matrix[v1][v2] = 1;
			matrix[v2][v1] = 1;
		}
	}

	public void printAdjacentVertices(int v1) {
		if(v1<0 || v1>=n) {
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다.");
		}
		else {
			System.out.print(v1 + "에 인접한 정점 =");
			for(int i=0; i<n; i++) {
				if(matrix[i][v1] == 1)
					System.out.print(i + " ");

			}
			System.out.println();
		}
	}

	private void depthFirstSearch(int v) {
		dfsVisited[v] = true;
		System.out.print(v + " ");

		for(int i=0; i<n; i++) {
			if(matrix[v][i] == 1 && dfsVisited[i]== false){ 
				depthFirstSearch(i);
			}
		}
	}

	public void depthFirstSearch() {
		for(int i=0; i<n; i++) {
			dfsVisited[i] = false;
		}
		
		depthFirstSearch(0);

		for(int i=0; i<n; i++) {
			if(!dfsVisited[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}


	private void breadthFirstSearch(int v) {
		
		bfsVisited[v] = true;
		queue.offer(v);

		while(!queue.isEmpty()){
			int temp = queue.poll();
			System.out.print(temp + " ");

			for(int i =0; i < n; i++){
				if(matrix[temp][i] == 1 && bfsVisited[i] == false){
					queue.offer(i);
					bfsVisited[i] = true;
				}
			}
		}
	}
	
	public void breadthFirstSearch() {
		for(int i=0; i<n; i++) {
			bfsVisited[i] = false;
		}
		
		breadthFirstSearch(0);

		for(int i=0; i<n; i++) {
			if(!bfsVisited[i]) {
				System.out.print(i +" ");
			}
		}
		System.out.println();
	}
}


