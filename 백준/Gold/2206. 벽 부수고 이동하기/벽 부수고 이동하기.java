import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int front, rear, n, m, size;
	
	static int[][][] metrix;
	
	static ChkPoint[] queue;
	
	static int[] dx = { 1 , 0 , -1 , 0 };
	static int[] dy = { 0 , 1 , 0 , -1 };
	
	static void init() {
		size = n*m;
		queue = new ChkPoint[size];
		metrix = new int[2][n][m];
	}
	
	static int bfs() {
        if(n == 1 && m == 1 && metrix[0][0][0] == 0) return 1;
        
		queue[rear++] = new ChkPoint(0,0,0);
		metrix[1][0][0] = metrix[0][0][0] = 1;
		
		while(queue[front] != null) {
			ChkPoint edge = queue[front];
			int dis = metrix[edge.w][edge.x][edge.y] + 1;
			queue[front++] = null;
			front%=size;			
			for(int i = 0; i < 4; i++) {
				int x = edge.x + dx[i];
				int y = edge.y + dy[i];

				if(x == n - 1 && y == m - 1) return dis; // 목표지점 도달했다면 탐색 종료
				
				if(x >= 0 && y >= 0 && x < n && y < m) { // 기본적으로 범위안인가 체크
					if(metrix[edge.w][x][y] == 1 && edge.w == 0) { // 다음 정점이 벽이고 현재 벽을 부순적 없는 경우
						queue[rear++] = new ChkPoint(x,y,1); // 벽을 부순 정점 큐에 삽입
						rear%=size;
						metrix[1][x][y] = dis; // 벽을 부순경우를 관리할 행렬로 방문처리
					}else if(metrix[edge.w][x][y] == 0) { // 다음 정점이 벽이 아닌 경우
						queue[rear++] = new ChkPoint(x,y,edge.w);
						rear%=size;
						metrix[edge.w][x][y] = dis;
					}
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		for(int i = 0; i < n; i ++) {
			String now = in.readLine();
			for(int j = 0; j < m; j++) {
				metrix[0][i][j] = metrix[1][i][j] = now.charAt(j) - '0';
			}
		}
		
		in.close();
		
		System.out.print(bfs());
	}

}

class ChkPoint{
	
	int x;
	int y;
	int w;
	
	ChkPoint(int x, int y, int w){
		this.x = x;
		this.y = y;
		this.w = w;
	}
}
