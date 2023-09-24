import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static char[][] metrix;
	static StringBuilder sb = new StringBuilder();
	
	static void quadTree(int n, int x, int y) {
		char flag = metrix[x][y];
		if(n == 1) {
			sb.append(flag);
			return;
		}
		int half = n >> 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(metrix[x + i][y + j] != flag) {
					sb.append('(');
					quadTree(half,x,y);
					quadTree(half,x ,y + half);
					quadTree(half,x + half,y);
					quadTree(half,x + half,y + half);
					sb.append(')');
					return;
				}
			}
		}
		sb.append(flag);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		metrix = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String input = in.readLine();
			for(int j = 0; j < n; j++) {
				metrix[i][j] = input.charAt(j);
			}
		}
		
		in.close();
		
		quadTree(n,0,0);
		
		System.out.print(sb);
	}
	

}
