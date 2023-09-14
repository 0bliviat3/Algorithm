import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private int[][] importantArr;
	private int[] sortedImportantArr;
	
	private int front = 0;
	private int near = 0;
	private int idx = -1;
	private int n = 0;
	
	private void init(String info, String important) {
		front = 0;
		near = 0;
		
		StringTokenizer st = new StringTokenizer(info," ");
		n = Integer.parseInt(st.nextToken());
		idx = Integer.parseInt(st.nextToken());
		
		importantArr = new int[n][2];
		sortedImportantArr = new int[n];
		
		st = new StringTokenizer(important," ");
		for(int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			importantArr[i][0] = now;
			sortedImportantArr[i] = now;
		}
		
		importantArr[idx][1] = 1;
		
		Arrays.sort(sortedImportantArr);	
		
	}
	
	private int findCnt() {
		int cnt = 0;
		for(int i = n - 1; i >= 0; i--) {
			while(true) {
				if(sortedImportantArr[i] == importantArr[front][0]) {
					cnt++;
					if(importantArr[front][1] == 1) return cnt;
					importantArr[front++][0] = 0; //pop
					front%=n;		
					break;
				}else {
					boolean flag = (importantArr[front][1] == 1) ? true : false;
					if(flag) {
						importantArr[front][1] = 0;
						importantArr[near][1] = 1;
					}
					int temp = importantArr[front++][0];
					importantArr[near++][0] = temp;
					front%=n;
					near%=n;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		Main m = new Main();
		while(t-- > 0) {
			m.init(in.readLine(), in.readLine());
			int now = m.findCnt();
			sb.append(now+"\n");
		}
		in.close();
		
		System.out.print(sb);
	}

}



