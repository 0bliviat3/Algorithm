import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) {
      BOJ16562Sol instance = new BOJ16562Sol();
      instance.run();
   }

}

class BOJ16562Sol {
   
   /*
    * 서로 친구인경우 부모노드가 될때까지 최소비용으로 갱신해줌
    * 부모노드를 통해 해당 집합의 최소비용을 찾는다.
    * 모든 집합의 최소비용의 합이 가진 금액보다 낮거나 같다면
    * 합을 출력, 높다면 X
    */
   
   private int[] cost;
   private int[] parent;
   private int n;
   
   private void clear() {
      cost = new int[n + 1];
      parent = new int[n + 1];
      for(int i = 1; i <= n; i++) {
         parent[i] = i;
      }
   }
   
   private int getParent(int a) {
      if(parent[a] == a) {
         return a;
      }
      return parent[a] = getParent(parent[a]);
   }
   
   private void union(int a, int b) {
      a = getParent(a);
      b = getParent(b);
      cost[a] = cost[b] = Math.min(cost[a], cost[b]);
      if(a < b) {
         parent[b] = a;
         return;
      }
      parent[a] = b;
   }
   
   private int getCost() {
      int sum = 0;
      boolean[] visit = new boolean[n + 1];
      for(int i = 1; i <= n; i++) {
         int parent = getParent(i);
         if(!visit[parent]) {
            sum += cost[parent];
            visit[parent] = true;            
         }
      }
      return sum;
   }
   
   private void printAns(int money) {
      int cost = getCost();
      if(money < cost) {
         System.out.print("Oh no");
         return;
      }
      System.out.print(cost);
   }
   
   private void initCost(String input) {
      StringTokenizer st = new StringTokenizer(input, " ");
      for(int i = 1; i <= n; i++) {
         cost[i] = Integer.parseInt(st.nextToken());
      }
   }
   
   private void initUnion(String input) {
      StringTokenizer st = new StringTokenizer(input, " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      union(a, b);
   }
   
   private void init() throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine(), " ");
      n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int money = Integer.parseInt(st.nextToken());
      
      clear();
      
      initCost(in.readLine());
      
      while(m-- > 0) {
         initUnion(in.readLine());
      }
      
      printAns(money);
   }
   
   void run() {
      try {
         init();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}