import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ1987Sol instance = new BOJ1987Sol();
		instance.run();
	}

}

class BOJ1987Sol {

	private int[][] board;
	private boolean[] visit;
	private int r, c, max;
	private int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private void clear() {
		board = new int[r][c];
		visit = new boolean[26];
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		clear();
		
		for (int i = 0; i < r; i++) {
			init(in.readLine(), i);
		}
	}
	
	private void init(String input, int row) {
		for(int i = 0; i < c; i++) {
			board[row][i] = input.charAt(i) - 'A';
		}
	}
	
	private void dfs(int depth, int row, int col) {
		if(visit[board[row][col]]) {
			return;
		}
		max = Math.max(max, depth);
		visit[board[row][col]] = true;
		for(int i = 0; i < 4; i++) {
			int x = move[i][0] + row;
			int y = move[i][1] + col;
			
			if(x < 0 || y < 0|| x >= r || y >= c) {
				continue;
			}
			dfs(depth + 1, x, y);		
		}
		visit[board[row][col]] = false;
	}
	
	void run() {
		try {
			init();
			dfs(1, 0, 0);
			System.out.print(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}