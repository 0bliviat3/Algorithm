import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[][] high = new int[n][m];
		int max = -1;
		int min = 257;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < m; j++) {
				high[i][j] = Integer.parseInt(st.nextToken());
				if(max < high[i][j]) max = high[i][j];
				if(min > high[i][j]) min = high[i][j];
			}
		}
		in.close();
		
		int minTime = Integer.MAX_VALUE;
		int land = 0;
		int inven = b;
		
		for(int i = min; i <= max; i++) {
			
			int nowTime = 0;
			int nowland = 0;
			b = inven;
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(high[j][k] < i) { // 블록쌓는 경우
						nowTime += (i - high[j][k]);
						b -= (i - high[j][k]);
					}else if(high[j][k] > i) { // 블록 제거
						nowTime += (high[j][k] - i)*2;
						b += (high[j][k] - i);
					}
				}
			}
			
			if(b>=0) { // 인벤의 블록수가 0 이상일때만 체크
				if(minTime >= nowTime) {
					minTime = nowTime;
					land = i;
				}		
			}	
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(minTime + " ");
		sb.append(land);
		
		System.out.print(sb);
		
	}

}
