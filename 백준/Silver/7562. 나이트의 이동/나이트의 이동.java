import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * BFS
	 */
	int n,front,rear,size;
	
	int[] dx = { -2 , -1 , 1 , 2 , 2 , 1 , -1 , -2 };
	int[] dy = { 1 , 2 , 2 , 1 , -1 , -2 , -2 , -1 };
	
	int[][] metrix;
	Point[] queue;
	
	void setting(int l) {
		n = l;
		size = n*n;
		metrix = new int[n][n];
		queue = new Point[size];
	}
	
	int bfs(int sx, int sy, int ex, int ey) {
		queue[rear++] = new Point(sx,sy);
		metrix[sx][sy] = 1;
		while(queue[front] != null && metrix[ex][ey] == 0) {
			Point node = queue[front];
			queue[front++] = null;
			front%=size;
			for(int i = 0; i < 8; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				if(x >= 0 && y >= 0 && x < n && y < n && metrix[x][y] == 0) {
					queue[rear++] = new Point(x,y);
					rear%=size;
					metrix[x][y] = metrix[node.x][node.y] + 1;
				}
			}
		}
		return metrix[ex][ey] - 1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main bfs;
		StringTokenizer st = null;
		int t = Integer.parseInt(in.readLine());
		int[] input = new int[4];
		
		while(t-- > 0) {
			bfs = new Main();
			
			bfs.setting(Integer.parseInt(in.readLine()));
			
			for(int i = 0; i < 4; i++) {
				if(i%2 == 0) {
					st = new StringTokenizer(in.readLine()," ");					
				}
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(bfs.bfs(input[0],input[1],input[2],input[3])).append('\n');
		}
		
		in.close();
		
		System.out.print(sb);
	}

}
