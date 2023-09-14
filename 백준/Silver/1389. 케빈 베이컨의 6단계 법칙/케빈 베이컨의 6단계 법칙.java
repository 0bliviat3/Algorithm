import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/*
	 * 양방향 그래프
	 * 기본적으로 주어지는 친구관계 인접행렬에 입력
	 * (a,a) 같은 자기자신은 0 입력
	 * 인접행렬 값중 null 값인 값들에 대해 최단거리로 값 구하기 --> 플로이드와샬
	 * 각 행에 대해 총합 구한뒤 최소값에 해당하는 행 리턴
	 */
	
	static Integer[][] metrix;
	static int n,m;
	
	static void init(int a, int b) {
		metrix[a][b] = metrix[b][a] = 1;
		metrix[a][a] = 0;
		metrix[b][b] = 0;
	}
	
	static void floyd() {
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(metrix[i][k] != null && metrix[k][j] != null) {
						int dis = metrix[i][k] + metrix[k][j];
						if(metrix[i][j] == null) {
							metrix[i][j] = dis;
						}else {
							metrix[i][j] = Math.min(metrix[i][j], dis);
						}						
					}
				}
			}			
		}
	}
	
	static int getMin() {
		int min = Integer.MAX_VALUE;
		int idx = 0;
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum = 0;
			for(int j = 1; j <= n; j++) {
				sum += metrix[i][j];
			}
			if(min > sum) {
				min = sum;
				idx = i;
			}
		}
		return idx;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		metrix = new Integer[n + 1][n + 1];
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			init(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		in.close();
		
		floyd();
		
		System.out.print(getMin());
	}
	
}
