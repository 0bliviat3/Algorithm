import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = { 1 , 0 , 0 , -1 };
	static int[] dy = { 0 , 1 , -1 , 0 };
	
	static boolean[][] visit;
	
	static int[][] metrix;
	
	static int n,m,max,maxVal;
	
	static void clear() {
		visit = new boolean[n][m];
		metrix = new int[n][m];
	}
	
	static void dfs(int x, int y, int depth, int sum) {
		if(depth == 3) {
			max = Math.max(max,sum);
			return;
		}
		if(max > sum + maxVal * (4 - depth)) return;
		
		for(int i = 0; i < 4; i++) {
			int nowX = x + dx[i];
			int nowY = y + dy[i];
			if(nowX >= 0 && nowY >= 0 && nowX < n && nowY < m && !visit[nowX][nowY]) {
				if(depth == 1) { // ㅗ , ㅜ , ㅏ , ㅓ
					visit[nowX][nowY] = true;
					dfs(x,y,depth + 1,sum + metrix[nowX][nowY]);
					visit[nowX][nowY] = false;
				}
				visit[nowX][nowY] = true;
				dfs(nowX,nowY,depth + 1,sum + metrix[nowX][nowY]);
				visit[nowX][nowY] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		clear();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < m; j++) {
				metrix[i][j] = Integer.parseInt(st.nextToken());
				maxVal = Math.max(maxVal, metrix[i][j]);
			}
		}
		
		in.close();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = true;
				dfs(i,j,0,metrix[i][j]);
				visit[i][j] = false;
			}
		}
		
		System.out.print(max);
	}
	
	

}
