import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 상하좌우 이동가능
	 * 벽은 미리 방문처리
	 * 
	 */
	
	static char[][] metrix;
	static boolean[][] visit;
	static int n,m,cnt;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static void dfs(int x, int y) {
		if(x >= n || y >= m || x < 0 || y < 0) return;
		if(visit[x][y]) return;
		visit[x][y] = true;
		if(metrix[x][y] == 'P') cnt++;
		for(int i = 0; i < 4; i++) {
			int nowX = x + dx[i];
			int nowY = y + dy[i];
			dfs(nowX,nowY);
		}
	}
	
	static void ans() {
		if(cnt == 0) {
			System.out.print("TT");
		}else {
			System.out.print(cnt);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		metrix = new char[n][m];
		visit = new boolean[n][m];
		
		int[] I = new int[2];
		
		for(int i = 0; i < n; i++) {
			String now = in.readLine();
			for(int j = 0; j < m; j++) {
				metrix[i][j] = now.charAt(j);
				if(metrix[i][j] == 'X') {
					visit[i][j] = true;
				}else if(metrix[i][j] == 'I') {
					I[0] = i;
					I[1] = j;
				}
			}
		}
		in.close();
		
		dfs(I[0],I[1]);
		
		ans();
	}

}
