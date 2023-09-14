import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	/*
	 * DFS
	 */
	static int n,call;
	
	static char[][] metrix;
	
	static int[] dx = { 1 , 0 , -1 , 0 };
	static int[] dy = { 0 , 1 , 0 , -1 };
	
	static void dfs(int x, int y) {
		if(metrix[x][y] == '0') return;
		metrix[x][y] = '0';
		call++;
		for(int i = 0; i < 4; i++) {
			int nowX = x + dx[i];
			int nowY = y + dy[i];
			
			if(nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
				dfs(nowX,nowY);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		
		metrix = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String now = in.readLine();
			for(int j = 0; j < n; j++) {
				metrix[i][j] = now.charAt(j);
			}
		}
		
		in.close();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(metrix[i][j] == '1') {
					call = 0;
					dfs(i,j);
					list.add(call);
				}
			}
		}
		
		Collections.sort(list);
		
		int size = list.size();
		
		sb.append(size).append('\n');
		
		for(int i = 0; i < size; i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		System.out.print(sb);
		
	}

}
