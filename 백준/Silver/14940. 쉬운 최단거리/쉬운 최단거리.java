import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] metrix;
	static boolean[][] visit;
	static Point[] queue;
	static int front,rear,n,m,size;
	
	static int[] dx = {0 , 1 , 0 , -1};
	static int[] dy = {1 , 0 , -1 , 0};
	
	static void setting() {
		size = n*m;
		metrix = new int[n][m];
		visit=  new boolean[n][m];
		queue = new Point[size];
	}
	
	static void bfs(int sx, int sy) {
		queue[rear++] = new Point(sx,sy);
		metrix[sx][sy] = 0;
		visit[sx][sy] = true;
		
		while(queue[front] != null) {
			Point node = queue[front];
			queue[front++] = null;
			front%=size;
			
			for(int i = 0; i < 4; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				
				if(x >= 0 && x < n && y >= 0 && y < m && !visit[x][y] && metrix[x][y] != 0) {
					queue[rear++] = new Point(x,y);
					rear%=size;
					metrix[x][y] += metrix[node.x][node.y];
					visit[x][y] = true;
				}
			}
		}
	}
	
	static void prt() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(metrix[i][j] == 1 && !visit[i][j]) {
					sb.append(-1).append(' ');
				}else {
					sb.append(metrix[i][j]).append(' ');
				}
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		setting();
		
		int sx = 0;
		int sy = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < m; j++) {
				metrix[i][j] = Integer.parseInt(st.nextToken());
				if(metrix[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		in.close();
		
		bfs(sx,sy);
		
		prt();
	}

}
