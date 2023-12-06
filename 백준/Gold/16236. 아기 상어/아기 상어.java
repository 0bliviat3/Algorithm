import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		FoodExploration exploration = new FoodExploration();
		exploration.run();
	}

}

class BabyShark {

	int x;
	int y;
	int size;
	int feed;
	int time;

	BabyShark(int x, int y, int size, int feed, int time) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.feed = feed;
		this.time = time;
	}

	void eat() {
		if (++feed == size) {
			size++;
			feed = 0;
		}
	}
	
	BabyShark copy() {
		return new BabyShark(x, y, size, feed, time);
	}
}

class FoodExploration {

	private int[][] map;
	private int n;
	private BabyShark shark;

	private void clear() {
		map = new int[n][n];
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		clear();

		for (int row = 0; row < n; row++) {
			init(in.readLine(), row);
		}
	}

	private void init(String input, int row) {
		StringTokenizer st = new StringTokenizer(input, " ");
		for (int col = 0; col < n; col++) {
			map[row][col] = Integer.parseInt(st.nextToken());
			if (map[row][col] == 9) {
				shark = new BabyShark(row, col, 2, 0, 0);
				map[row][col] = 0;
			}
		}
	}

	/*
	 * 상어가 먹이를 먹는 순간에 위치, 시간 갱신
	 * 현재 위치에서 먹이를 먹는 경우의 수가 없는 경우 종료
	 */

	// 먹이탐색 1회
	private boolean search() {
		Queue<BabyShark> queue = new ArrayDeque<>();
		int[][] move = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		boolean[][] visit = new boolean[n][n];
		boolean flag = false;
		int min = Integer.MAX_VALUE;
		int width = n;
		int high = n;
		
		queue.add(shark.copy());
		visit[shark.x][shark.y] = true;
		
		while(!queue.isEmpty()) {
			BabyShark dummy = queue.remove();
			for(int i = 0; i < 4; i++) {
				int x = dummy.x + move[i][0];
				int y = dummy.y + move[i][1];
				
				if(x < 0 || y < 0 || x >= n || y >= n) {
					continue;
				}
				if(map[x][y] > dummy.size || visit[x][y]) {
					continue;
				}
				if(map[x][y] != 0 && map[x][y] < dummy.size) {
					if(dummy.time <= min) {
						min = dummy.time;
						if(x < high) {
							high = x;
							width = y;
						}else if(x == high) {
							if(y < width) {
								width = y;
							}
						}
					}	
					flag = true;
				}
				if(map[x][y] == 0 || map[x][y] == dummy.size) {
					visit[x][y] = true;
					queue.add(new BabyShark(x, y, dummy.size, dummy.feed, dummy.time + 1));					
				}
			}
		}
		if(flag) {
			map[high][width] = 0;
			shark.x = high;
			shark.y = width;
			shark.eat();
			shark.time = min + 1;
		}
		return flag;
	}
	
	void run() {
		try {
			init();
			while(search()) {/*searching...*/}
			System.out.print(shark.time);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
