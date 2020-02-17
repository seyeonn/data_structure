
import java.util.LinkedList;
import java.util.Queue;

public class ListGraph {
   private Node[] list;
   private int n;
   private boolean[] dfsVisited;
   private boolean[] bfsVisited;
   private Queue<Integer> queue = new LinkedList<Integer>();

   public ListGraph(int n) {
      list = new Node[n];
      this.n =n;
      dfsVisited = new boolean[n];
      bfsVisited = new boolean[n];
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

   private void depthFirstSearch(int v) {
      dfsVisited[v] = true;
      System.out.print(v + " ");

      for(Node temp =list[v]; temp != null; temp = temp.link) {
         if(!dfsVisited[temp.vertex])
            depthFirstSearch(temp.vertex);
            
      }
   }

   public void depthFirstSearch() {
      for(int i=0; i<n; ++i) {
         dfsVisited[i] = false;
      }

      for(int i=0; i<n; ++i) {
         if(!dfsVisited[i]) {
            depthFirstSearch(i);

         }
      }
      System.out.println();
   }

   private void breadthFirstSearch(int v) {

      bfsVisited[v] = true;
      System.out.print(v + " ");
      queue.offer(v);

      while(!queue.isEmpty()){
         int temp = queue.poll();

         for(Node temp2 = list[temp]; temp2 != null; temp2 = temp2.link){
            if(temp2 != null && bfsVisited[temp2.vertex] == false){
               bfsVisited[temp2.vertex] = true;
               queue.offer(temp2.vertex);
               System.out.print(temp2.vertex + " ");
            }
         }
      }
   }

   public void breadthFirstSearch() {
      for(int i=0; i<n; i++) {
         bfsVisited[i] = false;
      }

      for(int i=0; i<n; i++) {
         if(!bfsVisited[i]) {
            breadthFirstSearch(i);
         }
      }
      System.out.println();
   }

   private class Node {
      int vertex;
      Node link;
   }
}