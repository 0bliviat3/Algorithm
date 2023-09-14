import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 플로이드 와샬 알고리즘
	 * 1. i에서 j로 갈수 있는가
	 * 2. i에서 k로, k에서 j로 갈수 있는가
	 * 3. 1 과 2는 같은 말이다.
	 */
	
	static int[][] metrix;
	static int n;
	
	static void prt() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(metrix[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	static void floydWarshall() {
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(metrix[i][k] == 1 && metrix[k][j] == 1) {
						metrix[i][j] = 1;
					}
				}
			}			
		}
	}
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		metrix = new int[n][n];
		
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < n; j++) {
				metrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		in.close();
		
		floydWarshall();
		
		prt();
	}

}
