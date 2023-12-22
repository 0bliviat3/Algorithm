import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) {
      BOJ1956Sol instance = new BOJ1956Sol();
      instance.run();
   }

}

class BOJ1956Sol {
   
   private int[][] metrix;
   
   private void clear(int n) {
      metrix = new int[n + 1][n + 1];
      for(int i = 1; i <= n; i++) {
         Arrays.fill(metrix[i], Integer.MAX_VALUE);
      }
   }
   
   private void floyd(int n) {
      for(int k = 1; k <= n; k++) {
         for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
               metrix[i][j] = min(metrix[i][j], metrix[i][k], metrix[k][j]);
            }
         }
      }
   }
   
   private int min(int cur, int start, int end) {
      if(start == Integer.MAX_VALUE || end == Integer.MAX_VALUE) {
         return cur;
      }
      return Math.min(cur, start + end);
   }
   
   private void printMinCycle(int n) {
      int ans = Integer.MAX_VALUE;
      for(int i = 1; i <= n; i++) {
         for(int j = 1; j <= n; j++) {
            if(metrix[i][j] == Integer.MAX_VALUE || metrix[j][i] == Integer.MAX_VALUE) {
               continue;
            }
            ans = Math.min(ans, metrix[i][j] + metrix[j][i]);
         }
      }
      if(ans == Integer.MAX_VALUE) {
         ans = -1;
      }
      System.out.print(ans);
   }
   
   private void process() throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine(), " ");
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      
      clear(v);
      while(e-- > 0) {
         init(in.readLine());
      }
      
      floyd(v);
      printMinCycle(v);
   }
   
   private void init(String input) {
      StringTokenizer st = new StringTokenizer(input, " ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());
      metrix[start][end] = dist;
   }
   
   void run() {
      try {
         process();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}