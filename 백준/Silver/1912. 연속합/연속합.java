import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 수열을 배열에 저장할 필요는 없다
	 * 변수 두개로 해결 가능
	 * 1. ans : 구간의 최대값을 의미
	 * 2. sum : 현재구간까지의 구간 합을 의미
	 * now 가 음수가 되는순간
	 * 다음 구간은 0부터 시작 이때 0 + 다음 구간수로 계산한다
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		int ans = -1001;
		int sum = 0;
		while(n-- > 0) {
			sum += Integer.parseInt(st.nextToken());
			if(ans < sum) ans = sum;
			if(sum < 0) sum = 0;
		}
		
		System.out.print(ans);
	}
}
