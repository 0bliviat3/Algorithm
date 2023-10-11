import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ17070Sol instance = new BOJ17070Sol();
		instance.run();
	}

}

class BOJ17070Sol {
	
	private boolean[][] metrix;
	private int n,ans;
	
	BOJ17070Sol() {
		try {
			init();			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private void setMetrix() { metrix = new boolean[n][n]; }
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		setMetrix();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < n; j++) {
				if(st.nextToken().equals("1")) { metrix[i][j] = true; }
			}
		}
		in.close();
	}
	
	private boolean endChk() {
		return metrix[n - 1][n - 1];
	}
	
	private void dfs(Boolean way,int x, int y) {
		if(x == n - 1 && y == n - 1) {
			ans++;
			return;
		}
		if(x == n || y == n ||metrix[x][y]) { return; }
		
		if(way == null || way) { dfs(true, x + 1, y); }
		if(way == null || !way){ dfs(false, x, y + 1); }
		if(x + 1 < n && y + 1 < n && !metrix[x][y + 1] && !metrix[x + 1][y]) { dfs(null, x + 1,y + 1); }
	}
	
	void run() {
		if(!endChk()) { dfs(false,0,1); }
		System.out.print(ans);
	}
}


