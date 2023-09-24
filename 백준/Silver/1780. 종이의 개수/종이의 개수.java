import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] metrix;
	static int[] nums = new int[3];
	
	static void cnt(int s) {
		if(s < 0) {
			nums[0]++;
		}else if(s == 0) {
			nums[1]++;
		}else {
			nums[2]++;
		}
	}
	
	static void quadTree(int n, int x, int y) {
		int standard = metrix[x][y];
		if(n == 1) {
			cnt(standard);
			return;
		}
		
		int triple = n/3;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(metrix[x + i][y + j] != standard) {
					quadTree(triple,x,y);
					quadTree(triple,x + triple,y);
					quadTree(triple,x + triple*2,y);
					quadTree(triple,x,y + triple);
					quadTree(triple,x,y + triple*2);
					quadTree(triple,x + triple,y + triple);
					quadTree(triple,x + triple*2,y + triple*2);
					quadTree(triple,x + triple*2,y + triple);
					quadTree(triple,x + triple,y + triple*2);
					return;
				}
			}
		}
		
		cnt(standard);
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine());
		
		metrix = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < n; j++) {
				metrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		in.close();
		
		quadTree(n,0,0);
		
		for(int i = 0; i < 3; i++) {
			sb.append(nums[i]).append('\n');
		}
		
		System.out.print(sb);
	}

}
