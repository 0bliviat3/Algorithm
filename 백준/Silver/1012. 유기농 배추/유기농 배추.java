import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] area,visit;
	static int m,n;
	static int[] nx = {-1, 0 , 1 , 0};
	static int[] ny = {0, -1, 0, 1};
			
	static void init() {
		area = new boolean[n][m];
		visit = new boolean[n][m];
	}
	
	static void dfs(int row, int col) {
		visit[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int x = row + nx[i];
			int y = col + ny[i];
			if(x >= 0 && y >= 0 && x < n && y < m) {
				if(!visit[x][y] && area[x][y]) {
					dfs(x,y);
				}
			}	
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			
			m = Integer.parseInt(st.nextToken()); // 가로길이 열의수
			n = Integer.parseInt(st.nextToken()); // 세로길이 행의수
			int k = Integer.parseInt(st.nextToken());
			
			init();
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine()," ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				area[x][y] = true;
			}
			
			int cnt = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(area[i][j] && !visit[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}
		in.close();
		
		System.out.print(sb);
	}
}
