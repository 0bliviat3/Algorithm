import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ2468Sol instance = new BOJ2468Sol();
		System.out.print(instance.run());
		instance.close();
	}

}

class BOJ2468Sol {
	
	private int[][] metrix;
	private boolean[][] visit;
	
	private boolean[] height;
	
	private StringTokenizer st;
	private int n;
	
	private int[][] move = { {1 , 0} , {-1 , 0} , {0 , 1} , {0 , -1} };
	
	BOJ2468Sol() {
		try {
			init();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clear() {
		metrix = new int[n][n];
		height = new boolean[101];
	}
	
	private void visitClear() {
		visit = new boolean[n][n];
	}
	
	private void setMetrix(String input, int j) {
		st = new StringTokenizer(input," ");
		for(int i = 0; i < n; i++) { 
			metrix[j][i] = Integer.parseInt(st.nextToken());
			height[metrix[j][i]] = true;
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		this.n = Integer.parseInt(in.readLine());
		clear();
		for(int i = 0; i < n; i++) { setMetrix(in.readLine(), i); }
		in.close();
	}
	
	private void dfs(int high, int row, int col) {
		if(visit[row][col]) { return; }
		visit[row][col] = true;
		for(int i = 0; i < 4; i++) {
			int x = row + move[i][0];
			int y = col + move[i][1];
			if(x >= 0 && y >= 0 && x < n && y < n && metrix[x][y] > high) {
				dfs(high,x,y);
			}
		}
	}
	
	private int dfsCnt(int high) {
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j] && metrix[i][j] > high) {
					dfs(high,i,j);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	int run() {
		int max = 1;
		for(int i = 1; i < 101; i++) {
			if(height[i]) {
				visitClear();
				max = Math.max(max, dfsCnt(i)); 
			}
		}
		return max;
	}
	
	void close() {
		st = null;
		visit = null;
		height = null;
		metrix = null;
		move = null;
	}
	
}
