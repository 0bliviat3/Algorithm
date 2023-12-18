import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) {
      BOJ11657Sol instance = new BOJ11657Sol();
      instance.run();
   }

}

class Node11657 {
   int start;
   int end;
   int cost;
   
   Node11657(int start, int end, int cost) {
      this.start = start;
      this.end = end;
      this.cost = cost;
   }
}

class BOJ11657Sol {
   
   private long[] dist;
   private List<Node11657> edges;
   private int[][] metrix;
   
   private void clear(int n) {
      dist = new long[n + 1];
      metrix = new int[n + 1][n + 1];
      edges = new ArrayList<>();
      for(int i = 1; i <= n; i++) {
         Arrays.fill(metrix[i], Integer.MAX_VALUE);
      }
   }
   
   private boolean bellmanFord(int n) {
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[1] = 0;
      
      for(int i = 1; i <= n; i++) {
         for(Node11657 node : edges) {
            int cur = node.start;
            int next = node.end;
            int cost = node.cost;
            
            if(dist[cur] == Integer.MAX_VALUE) {
               continue;
            }
            if(dist[next] > dist[cur] + cost) {
               dist[next] = dist[cur] + cost;
               if(i == n) {
                  return false;
               }
            }
         }
      }
      return true;
   }
   
   private void printAns(int n) {
      StringBuilder ans = new StringBuilder();
      for(int i = 2; i <= n; i++) {
         if(dist[i] == Integer.MAX_VALUE) {
            ans.append("-1\n");
            continue;
         }
         ans.append(dist[i]).append('\n');
      }
      System.out.print(ans);
   }
   
   private void process() throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine(), " ");
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      clear(n);
      while(m-- > 0) {
         init(in.readLine());
      }
      
      initEdges(n);
      
      if(bellmanFord(n)) {
         printAns(n);
         return;
      }
      System.out.print(-1);
   }
   
   private void init(String input) {
      StringTokenizer st = new StringTokenizer(input, " ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      
      metrix[start][end] = Math.min(metrix[start][end], cost);
   }
   
   private void initEdges(int n) {
      for(int i = 1; i <= n; i++) {
         for(int j = 1; j <= n; j++) {
            if(metrix[i][j] == Integer.MAX_VALUE) {
               continue;
            }
            edges.add(new Node11657(i, j, metrix[i][j]));
         }
      }
   }
   
   void run() {
      try {
         process();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}