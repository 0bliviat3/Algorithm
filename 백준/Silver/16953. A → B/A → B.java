import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/* B -> A 로 진행
	 * B가 짝수인경우 2로 나눔
	 * 아닌 경우 마지막 자리 1이라면 1제거
	 * 마지막 자리가 1인건 10으로 나눈 나머지로 알 수 있음
	 * 반복중 A와 일치하면 반복횟수 리턴
	 * 탐색종료되면 -1 리턴
	 */
	
	static int a,b,depth = 1;
	
	static int bfs() {
		int now = 0;
		
		while(now != b) {
			now = b;
			if(b%2 == 0) {
				b/=2;
				depth++;
			}else if(b%10 == 1) {
				b = (b - 1)/10;
				depth++;
			}
			if(a == b) return depth;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		in.close();
		
		System.out.print(bfs());
	}

}
