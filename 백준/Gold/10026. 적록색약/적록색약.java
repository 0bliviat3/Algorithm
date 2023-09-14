import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	int n,front,rear,size;
	
	int[] dx = { 1 , 0 , -1 , 0 };
	int[] dy = { 0 , 1 , 0 , -1 };
	
	Point[] queue;
	
	void init(int n) {
		this.n = n;
		size = n*n;
		queue = new Point[size];
	}
	
	void bfs(int sx, int sy, char c, char[][] metrix) {
		queue[rear++] = new Point(sx,sy);
		metrix[sx][sy] = 'x';
		while(queue[front] != null) {
			Point node = queue[front];
			queue[front++] = null;
			front%=size;
			for(int i = 0; i < 4; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				if(x >= 0 && y >= 0 && x < n && y < n && metrix[x][y] == c) {
					queue[rear++] = new Point(x,y);
					rear%=size;
					metrix[x][y] = 'x';
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main bfs = new Main();
		
		int n = Integer.parseInt(in.readLine());
		bfs.init(n);
		
		char[][] metrix1 = new char[n][n];
		char[][] metrix2 = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String now = in.readLine();
			for(int j = 0; j < n; j++) {
				metrix2[i][j] = metrix1[i][j] = now.charAt(j);
				if(metrix1[i][j] == 'G') {
					metrix2[i][j] = 'R';
				}
			}
		}
		
		in.close();
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(metrix1[i][j] != 'x') {
					cnt1++;
					bfs.bfs(i, j, metrix1[i][j], metrix1);
				}
				if(metrix2[i][j] != 'x') {
					cnt2++;
					bfs.bfs(i, j, metrix2[i][j], metrix2);
				}
			}
		}
		
		System.out.print(cnt1 + " " + cnt2);
	}

}
