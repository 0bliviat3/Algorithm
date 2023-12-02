import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ14502Sol instance = new BOJ14502Sol();
		instance.run();
	}

}

class BOJ14502Sol {
	
	private List<Point> space;
	private List<Point> virus;
	private Queue<Point> queue;
	private int[][] metrix;
	private int[][] cloneMtx;
	private int n, m, size, max;
	private final int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	private void clear() {
		space = new ArrayList<>();
		virus = new ArrayList<>();
		queue = new ArrayDeque<>();
		metrix = new int[n][m];
		cloneMtx = new int[n][m];
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		clear();
		
		for(int i = 0; i < n; i++) {
			init(in.readLine(), i);
		}
	}
	
	private void init(String input, int col) {
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int i = 0; i < m; i++) {
			metrix[col][i] = Integer.parseInt(st.nextToken());
			if(metrix[col][i] == 0) {
				space.add(new Point(col, i));
				size++;
			}else if(metrix[col][i] == 2) {
				virus.add(new Point(col, i));
			}
		}
	}
	
	private void dfs(int cnt, int start) {
		if(cnt == 3) {
			addVirus();
			copy();
			bfs();
			countMax();
			return;
		}		
		for(int i = start; i < size; i++) {
			Point now = space.get(i);
			if(metrix[now.x][now.y] == 0) {
				metrix[now.x][now.y] = 1;
				dfs(cnt + 1, i + 1);
				metrix[now.x][now.y] = 0;
			}
		}
	}
	
	private void addVirus() {
		for(Point v : virus) {
			queue.add(v);
		}
	}
	
	private void copy() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				cloneMtx[i][j] = metrix[i][j];
			}
		}
	}
	
	private void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int x = now.x + move[i][1];
				int y = now.y + move[i][0];
				
				if(x < 0 || y < 0 || x >= n || y >= m) {
					continue;
				}
				if(cloneMtx[x][y] == 0) {
					queue.add(new Point(x, y));
					cloneMtx[x][y] = 2;
				}
			}
		}		
	}
	
	private void countMax() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(cloneMtx[i][j] == 0) {
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}
	
	void run() {
		try {
			init();
			dfs(0, 0);
			System.out.print(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
