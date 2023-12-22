import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) {
      new BOJ10282Sol().run();
   }

}

class Node10282 implements Comparable<Node10282>{
   
   int a, b;
   
   Node10282(int a, int b) {
      this.a = a;
      this.b = b;
   }

   @Override
   public int compareTo(Node10282 o) {
      return this.b - o.b;
   }
}

class BOJ10282Sol {
   
   private List<List<Node10282>> edges;
   
   private void clear(int n) {
      edges = new ArrayList<>();
      for(int i = 0; i <= n; i++) {
         edges.add(new ArrayList<>());
      }
   }
   
   private void initEdges(String input) {
      StringTokenizer st = new StringTokenizer(input, " ");
      int end = Integer.parseInt(st.nextToken());
      int start = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      edges.get(start).add(new Node10282(end, time));
   }
   
   private int[] dijkstra(int start, int n) {
      int[] times = new int[n + 1];
      PriorityQueue<Node10282> heap = new PriorityQueue<>();
      Arrays.fill(times, Integer.MAX_VALUE);
      times[start] = 0;
      heap.add(new Node10282(start, times[start]));
      while(!heap.isEmpty()) {
         Node10282 node = heap.remove();
         
         if(times[node.a] < node.b) {
            continue;
         }
         
         for(Node10282 next : edges.get(node.a)) {
            int time = next.b + node.b;
            if(time < times[next.a]) {
               times[next.a] = time;
               heap.add(new Node10282(next.a, times[next.a]));
            }   
         }
      }
      return times;
   }
   
   private String countCom(int[] times) {
      int cnt = 0;
      int max = 0;
      for(int time : times) {
         if(time == Integer.MAX_VALUE) {
            continue;
         }
         cnt++;
         max = Math.max(max, time);
      }
      return cnt + " " + max + "\n";
   }
   
   private void init() throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder ans = new StringBuilder();
      int tc = Integer.parseInt(in.readLine());
      while(tc-- > 0) {
         StringTokenizer st = new StringTokenizer(in.readLine(), " ");
         int n = Integer.parseInt(st.nextToken());
         int d = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         clear(n);
         while(d-- > 0) {
            initEdges(in.readLine());
         }
         ans.append(countCom(dijkstra(c, n)));
      }
      System.out.print(ans);
   }
   
   void run() {
      try {
         init();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
}