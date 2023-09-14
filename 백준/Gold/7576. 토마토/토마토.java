import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * BFS
	 */
	
	static int n,m,front,rear,size;
	static Point[] queue;
	static int[][] metrix;
	
	static int[] dx = { 0 , 1 , 0 , -1};
	static int[] dy = { 1 , 0 , -1 , 0};
	
	static void init() {
		size = n*m;
		queue = new Point[size];
		metrix = new int[m][n];
	}
	
	static void bfs(Point[] start, int len) {
		for(int i = 0; i < len; i++) {
			queue[rear++] = start[i];
		}
		while(queue[front] != null) {
			Point node = queue[front];
			queue[front++] = null;
			front%=size;
			for(int i = 0; i < 4; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				if(x >= 0 && y >= 0 && x < m && y < n && metrix[x][y] == 0) {
					queue[rear++] = new Point(x,y);
					metrix[x][y] = metrix[node.x][node.y] + 1;
					rear%=size;
				}
			}
		}
	}
	
	static int chk() {
		int max = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(metrix[i][j] == 0) {
					return -1;
				}
				max = Math.max(max, metrix[i][j]);
			}
		}
		return max - 1; // 시작이 1이였으므로 -1로 보정처리... 구하고자 하는것은 일수이다
	}
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		boolean flag = false;
		int cnt = 0;
		Point[] start = new Point[size];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < n; j++) {
				metrix[i][j] = Integer.parseInt(st.nextToken());
				if(metrix[i][j] == 0) {
					flag = true;
				} else if(metrix[i][j] == 1) {
					start[cnt++] = new Point(i,j);
				}
			}
		}
		
		in.close();
		
		if(flag) {
			bfs(start,cnt);
			System.out.print(chk());
		}else {
			System.out.print(0);
		}
	}

}
