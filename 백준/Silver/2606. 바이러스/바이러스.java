import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private boolean[][] network;
	private boolean[] infection;
	private int n;
	
	public void createNetwork(int n) {
		this.n = n;
		network = new boolean[n + 1][n + 1];
		infection = new boolean[n + 1];
	}
	
	public void init(int a, int b) {
		network[a][b] = network[b][a] = true;
	}
	
	public int dfs(int node) {
		int cnt = 0;
		if(infection[node]) return cnt;
		infection[node] = true;
		cnt++;
		for(int i = 1; i <= n; i++) {
			if(network[i][node] && !infection[i]) {
				cnt += dfs(i);
				
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main bj = new Main();
		bj.createNetwork(Integer.parseInt(in.readLine()));
		
		int edge = Integer.parseInt(in.readLine());
		StringTokenizer st;
		while(edge-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			bj.init(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		in.close();
		
		System.out.print(bj.dfs(1) - 1);
	}

}
