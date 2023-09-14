import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int min = Integer.MAX_VALUE;
	
	static int[][] metrix;
	static boolean[] visit;
	
	static int getGap() {
		int temp = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(visit[i] && visit[j]) {
					temp += metrix[i][j] + metrix[j][i];
				}else if(!visit[i] && !visit[j]) {
					temp -= metrix[i][j] + metrix[j][i];
				}
			}
		}
		return Math.abs(temp);
	}
	
	static void pro(int idx, int cnt) {
		if(cnt == n/2) {
			min = Math.min(min, getGap());
			return;
		}
		for(int i = idx; i < n; i++) {
			visit[i] = true;
			pro(i + 1, cnt + 1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		metrix = new int[n][n];
		visit = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < n; j++) {
				metrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		in.close();
		
		pro(0,0);
		
		System.out.print(min);
		
	}

}
