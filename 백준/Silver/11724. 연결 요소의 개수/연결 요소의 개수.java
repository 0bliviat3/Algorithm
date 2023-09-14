import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private boolean[] visit;
	private boolean[][] metrix;
	
	private int n,cnt;
	
	Main(int n){
		this.n = n;
		visit = new boolean[n + 1];
		metrix = new boolean[n + 1][n + 1];
	}
	
	public void init(int a, int b) {
		metrix[a][b] = metrix[b][a] = true;
	}
	
	private void dfs(int node) {
		if(visit[node]) return;
		visit[node] = true;
		for(int i = 1; i <= n; i++) {
			if(metrix[node][i] && !visit[i]) {
				dfs(i);
			}
		}
	}
	
	
	public int getCnt() {
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				cnt++;
				dfs(i);
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		Main bj = new Main(Integer.parseInt(st.nextToken()));

		int m = Integer.parseInt(st.nextToken());
		
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			bj.init(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}	
		
		System.out.print(bj.getCnt());
		
	}

}
