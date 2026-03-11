import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) {
      new BOJ1068Sol().run();
   }

}

class BOJ1068Sol {
   
   private List<List<Integer>> edges;
   private int[] parent;
   private boolean[] visit;
   private int root, n, cnt;
   
   private void clear() {
      visit = new boolean[n];
      parent = new int[n];
      edges = new ArrayList<>();
      for(int i = 0; i < n; i++) {
         edges.add(new ArrayList<>());
      }
   }
   
   private void initEdges(int idx, int data) {
      if(data == -1) {
         root = idx;
         return;
      }
      edges.get(data).add(idx);
   }
   
   private void initParent(String input) {
      StringTokenizer st = new StringTokenizer(input, " ");
      for(int i = 0; i < n; i++) {
         parent[i] = Integer.parseInt(st.nextToken());
         initEdges(i, parent[i]);
      }
   }
   
   private void clearVisit() {
      Arrays.fill(visit, false);
      cnt = 0;
   }
   
   private void dfs(int node) {
      if(visit[node]) {
         return;
      }
      visit[node] = true;
      if(edges.get(node).isEmpty()) {
         cnt++;
         return;
      }
      for(int next : edges.get(node)) {
         dfs(next);
      }
   }
   
   private int countLeaf(int target) {
      dfs(root);
      int ans = cnt;
      clearVisit();
      visit[parent[target]] = true;
      dfs(target);
      ans -= cnt;
      if(edges.get(parent[target]).size() == 1) {
         return ++ans;
      }
      return ans;
   }
   
   private void process() throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(in.readLine());
      clear();
      initParent(in.readLine());
      int target = Integer.parseInt(in.readLine());
      if(target == root) {
         System.out.print(0);
         return;
      }
      System.out.print(countLeaf(target));
   }
   
   void run() {
      try {
         process();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}