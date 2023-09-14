import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 마지막 도시의 기름값은 의미가 없다
	 * 도시들의 기름값을 입력받으면서 더 작은 값이 나올때까지 현재 주유소의 기름값 == 기준기름값
	 * 더 작은 기름값이 나오는 경우 기준 기름값 변경
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()) - 1;
		long[] dis = new long[n];
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringTokenizer st2 = new StringTokenizer(in.readLine()," ");
		in.close();
		
		long nowP = Long.parseLong(st2.nextToken());
		long sum = 0;
		long now = 0;
		for(int i = 0; i < n; i++) {
			dis[i] = Long.parseLong(st.nextToken());
			sum += nowP * dis[i];
			now = Long.parseLong(st2.nextToken());
			if(nowP > now) nowP = now;
		}
		
		System.out.print(sum);
	}

}
