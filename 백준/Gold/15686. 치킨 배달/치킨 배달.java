import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ76756Sol instance = new BOJ76756Sol();
		instance.run();
	}

}

class BOJ76756Sol {
	
	private int n, m, size, ans = Integer.MAX_VALUE;
	private boolean[][] visit;
	private List<Point> chicken;
	private List<Point> house;
	private Point[] peekChicken;
	
	private void clear() {
		visit = new boolean[n][n];
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		peekChicken = new Point[m];
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
	
	private void init(String input, int x) {
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int y = 0; y < n; y++) {
			int city = Integer.parseInt(st.nextToken());
			if(city == 1) {
				house.add(new Point(x, y));
			}else if(city == 2) {
				chicken.add(new Point(x, y));
				size++;
			}
		}
	}
	
	private void dfs(int cnt, int start) { // 치킨집 선택
		if(cnt == m) {
			// 치킨거리 계산
			calculateChickenDist();
			return;
		}
		
		for(int i = start; i < size; i++) {
			Point chickenPoint = chicken.get(i);
			int x = chickenPoint.x;
			int y = chickenPoint.y;
			if(!visit[x][y]) {
				peekChicken[cnt] = chickenPoint;
				visit[x][y] = true;
				dfs(cnt + 1, i + 1);
				visit[x][y] = false;
			}
		}
	}
	
	private void calculateChickenDist() {
		int dist = 0;
		for(Point housePoint : house) {
			dist += calculateMinDist(housePoint);
		}
		ans = Math.min(ans, dist);
	}
	
	private int calculateMinDist(Point house) {
		int min = Integer.MAX_VALUE;
		for(Point c : peekChicken) {
			min = Math.min(min, Math.abs(house.x - c.x) + Math.abs(house.y - c.y));
		}
		return min;
	}
	
	void run() {
		try {
			init();
			dfs(0, 0);
			System.out.print(ans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}