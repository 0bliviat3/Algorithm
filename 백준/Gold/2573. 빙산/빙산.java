import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ2573Sol instance = new BOJ2573Sol();
		System.out.print(instance.getCnt());
		instance.close();
	}
	
}

class BOJ2573Sol {
	
	private int[][] metrix;
	private boolean[][] visit;
	private int[] nm = new int[2];
	private StringTokenizer st;
	private int[][] move = { {0,1} , {0,-1} , {1,0} , {-1,0} };
	
	BOJ2573Sol() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void close() {
		metrix = null;
		visit = null;
		nm = null;
		st = null;
		move = null;
	}
	
	private void clear() {
		metrix = new int[nm[0]][nm[1]];
	}
	
	private void visitClear() {
		visit = new boolean[nm[0]][nm[1]];
	}
	
	private void setMetrix(int row, String input) {
		st = new StringTokenizer(input," ");
		for(int col = 0; col < nm[1]; col++) {
			metrix[row][col] = Integer.parseInt(st.nextToken());
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine()," ");
		nm[0] = Integer.parseInt(st.nextToken());
		nm[1] = Integer.parseInt(st.nextToken());
		clear();
		for(int row = 0; row < nm[0]; row++) { setMetrix(row,in.readLine()); }
		in.close();
	}
	
	private void dfs(int row, int col) {
		if(visit[row][col]) { return; }
		visit[row][col] = true;
		for(int i = 0; i < 4; i++) {
			int x = row + move[i][0];
			int y = col + move[i][1];
			if(x >= nm[0] && y >= nm[1] && x < 0 && y < 0) {
				continue;
			}
			if(metrix[x][y] > 0) {
				dfs(x,y);					
			}else if(metrix[x][y] == 0 && metrix[row][col] > 0 && !visit[x][y]){
				metrix[row][col]--;
			}
		}
	}
	
	private int search() {
		int cnt = 0;
		visitClear();
		for(int i = 0; i < nm[0]; i++) {
			for(int j = 0; j < nm[1]; j++) {
				if(!visit[i][j] && metrix[i][j] > 0) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	int getCnt() {
		int cnt = 0;
		int val = 0;
		while((val = search()) == 1) { cnt++; }
		if(val == 0) { return val; }
		return cnt;
	}
	
}
