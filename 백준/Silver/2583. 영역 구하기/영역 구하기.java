import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ2583Sol instance = new BOJ2583Sol();
		instance.run();
	}

}

class BOJ2583Sol {
	
	private boolean[][] metrix;
	private int n,m;
	private ArrayList<Integer> area;
	private int[][] move = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	BOJ2583Sol() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clear() {
		metrix = new boolean[n][m];
		area = new ArrayList<>();
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] area = new int[4];
		clear();
		while(k-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			for(int i = 0; i < 4; i++) {
				area[i] = Integer.parseInt(st.nextToken());
			}
			setMetrix(area);
		}
		in.close();
	}
	
	private void setMetrix(int[] area) {
		for(int i = area[0]; i < area[2]; i++) {
			for(int j = area[1]; j < area[3]; j++) {
				metrix[i][j] = true;
			}
		}
	}
	
	private int dfs(int x, int y) {
		int cnt = 1;
		metrix[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			if(dx < 0 || dy < 0 || dx >= n || dy >= m) {
				continue;
			}
			if(!metrix[dx][dy]) {
				metrix[dx][dy] = true;
				cnt += dfs(dx,dy);
			}
		}
		return cnt;
	}
	
	private void countArea() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!metrix[i][j]) {
					area.add(dfs(i,j));
				}
			}
		}
	}
	
	void run() {
		StringBuilder sb = new StringBuilder();
		countArea();
		Collections.sort(area);
		sb.append(area.size()).append('\n');
		for(int i : area) {
			sb.append(i).append(' ');
		}
		System.out.print(sb);
	}
	
}
