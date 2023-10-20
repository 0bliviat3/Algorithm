import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ1926Sol instance = new BOJ1926Sol();
		instance.run();
	}

}

class BOJ1926Sol {
	
	private boolean[][] metrix;
	private StringTokenizer st;
	private int n,m,max,cnt,maxCnt;
	private int[][] move = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	BOJ1926Sol() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		clear();
		for(int i = 0; i < n; i++) { init(in.readLine(), i); }
		in.close();
	}
	
	private void clear() {
		metrix = new boolean[n][m];
	}
	
	private void init(String input, int row) {
		st = new StringTokenizer(input," ");
		for(int i = 0; i < m; i++) {
			if(st.nextToken().equals("1")) {
				metrix[row][i] = true;				
			}
		}
	}
	
	private void countPicture() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(metrix[i][j]) {
					maxCnt = 0;
					dfs(i,j);
					cnt++;
				}
			}
		}
	}
	
	private void dfs(int x, int y) {
		if(!metrix[x][y]) { return; }
		metrix[x][y] = false;
		max = Math.max(max, ++maxCnt);
		for(int i = 0; i < 4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			if(dx < 0 || dy < 0 || dx >= n || dy >= m) {
				continue;
			}
			dfs(dx,dy);
		}
	}
	
	void run() {
		StringBuilder sb = new StringBuilder();
		countPicture();
		sb.append(cnt).append('\n').append(max);
		System.out.print(sb);
	}
	
}
