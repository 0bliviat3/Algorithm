import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] queue = new int[n];
		
		for(int i = 0; i < n; i++) {
			queue[i] = i;
		}
		
		st = new StringTokenizer(in.readLine()," ");
		
		in.close();
		
		int cnt = 0;
		int front = (n == 1) ? 0 : 1;
		int rear = 1;
		int rCnt = 0;
		int auto = 0;
		while(m-- > 0) {
			int target = Integer.parseInt(st.nextToken())%n;
			while(true) {
				if(queue[front] != target) {
					int temp = queue[front];
					queue[front++] = -1;
					queue[rear++] = temp;
					rCnt++;
					front%=n;
					rear%=n;
				}else {
					queue[front++] = -1;
					front%=n;
					//queue의 사이즈는 가변적이여야 한다.
					cnt += (rCnt > (n - auto)/2) ? ((n - auto) - rCnt) : rCnt;
					rCnt = 0;
					auto++;
					break;
				}
				
			}
		}
		
		System.out.print(cnt);
	}
}
