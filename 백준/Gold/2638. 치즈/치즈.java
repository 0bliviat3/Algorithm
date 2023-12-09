import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ2638Sol instance = new BOJ2638Sol();
		instance.run();
	}

}

class BOJ2638Sol {

	private int[][] paper;
	private boolean[][] visit;
	private List<Point> cheese;
	private Queue<Point> meltedCheese;
	private int n, m;
	private int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private void clear() {
		paper = new int[n][m];
		visit = new boolean[n][m];
		cheese = new LinkedList<>();
		meltedCheese = new ArrayDeque<>();
	}

	private void init() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			clear();
			for (int i = 0; i < n; i++) {
				init(in.readLine(), i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init(String input, int i) {
		StringTokenizer st = new StringTokenizer(input, " ");
		for (int j = 0; j < m; j++) {
			paper[i][j] = Integer.parseInt(st.nextToken());
			if (paper[i][j] == 1) {
				cheese.add(new Point(i, j));
			}
		}
	}

	private void clearVisit() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], false);
		}
	}

	private void searchOutside(int x, int y) {
		if (visit[x][y]) {
			return;
		}
		visit[x][y] = true;
		paper[x][y] = -1;
		for (int i = 0; i < 4; i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
				continue;
			}
			if (!visit[dx][dy] && paper[dx][dy] < 1) {
				searchOutside(dx, dy);
			}
		}
	}

	private void searchContect() {
		for (Point node : cheese) {
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int dx = node.x + move[i][0];
				int dy = node.y + move[i][1];
				if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
					continue;
				}
				if (paper[dx][dy] < 0) {
					cnt++;
				}
			}
			if (cnt > 1) {
				meltedCheese.add(node);
			}
		}
	}

	private void meltCheese() {
		while (!meltedCheese.isEmpty()) {
			Point cheese = meltedCheese.remove();
			this.cheese.remove(cheese);
			paper[cheese.x][cheese.y] = -1;
		}
	}

	void run() {
		int cnt = 0;
		init();
		while (!cheese.isEmpty()) {
			clearVisit();
			searchOutside(0, 0);
			searchContect();
			meltCheese();
			cnt++;
		}
		System.out.print(cnt);
	}
}
