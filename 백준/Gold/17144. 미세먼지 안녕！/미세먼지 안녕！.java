import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ17144Sol instance = new BOJ17144Sol();
		instance.run();
	}

}

class Dust {
	int x, y, w;
	
	Dust(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}

class BOJ17144Sol {
	
	private Queue<Dust> dusts;
	private int[][] map;
	private int[] machine;
	private int r, c, t, idx;
	private static final int MOD = 5;
	private final int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	private void clear() {
		dusts = new ArrayDeque<>();
		map = new int[r][c];
		machine = new int[2];
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		initRCT(in.readLine());
		clear();
		
		for(int row = 0; row < r; row++) {
			initMap(in.readLine(), row);
		}
	}
	
	private void initRCT(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
	}
	
	private void initMap(String input, int row) {
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int col = 0; col < c; col++) {
			map[row][col] = Integer.parseInt(st.nextToken());
			if(map[row][col] >= MOD) {
				dusts.add(new Dust(row, col, map[row][col]));
			} else if(map[row][col] == -1) {
				machine[idx++] = row;
				continue;
			}
		}
	}
	
	private void spreadDust() {
		while(!dusts.isEmpty()) {
			Dust now = dusts.remove();
			int amount = now.w / MOD;
			int cnt = 0;
			if(amount < 1) {
				continue;
			}			
			for(int i = 0; i < 4; i++) {
				int x = now.x + move[i][0];
				int y = now.y + move[i][1];				
				if(x < 0 || y < 0 || x >= r || y >= c) {
					continue;
				}
				if(map[x][y] == -1) {
					continue;
				}
				map[x][y] += amount;
				cnt++;
			}
			map[now.x][now.y] -= cnt * amount;
		}
	}
	
	private int addQueue() {
		int sum = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] >= MOD) {
					dusts.add(new Dust(i, j, map[i][j]));
				} else if(map[i][j] == -1) {
					continue;
				}
				sum += map[i][j];
			}
		}
		return sum;
	}
	
	// 순환
	private void rotateUpCycle() {
		
		for(int i = machine[0] - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for(int i = 0; i < c - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for(int i = 0; i < machine[0]; i++) {
			map[i][c - 1] = map[i + 1][c - 1];
		}
		for(int i = c - 1; i > 1; i--) {
			map[machine[0]][i] = map[machine[0]][i - 1];
		}
		map[machine[0]][1] = 0;
	}
	
	private void rotateDownCycle() {
		for(int i = machine[1] + 1; i < r - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for(int i = 0; i < c - 1; i++) {
			map[r - 1][i] = map[r - 1][i + 1];
		}
		for(int i = r - 1; i > machine[1]; i--) {
			map[i][c - 1] = map[i - 1][c - 1];
		}
		for(int i = c - 1; i > 1; i--) {
			map[machine[1]][i] = map[machine[1]][i - 1];
		}
		map[machine[1]][1] = 0;
	}
	
	void run() {
		int ans = 0;
		try {
			init();
			while(t-- > 0) {
				spreadDust();
				rotateUpCycle();
				rotateDownCycle();
				ans = addQueue();
			}
			System.out.print(ans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
