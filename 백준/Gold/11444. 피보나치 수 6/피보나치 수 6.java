import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private final int mod = 1000000007;

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long n = Long.parseLong(in.readLine());
		in.close();
		Main f = new Main();
		long fNum = f.square(n);
		sb.append(fNum);
		System.out.print(sb);

	}
	
	
	public long square(long n) {
		
		long[][] now = {{1,0},{0,1}};
		long[][] f = {{1,1},{1,0}};
		while(n >= 1) { // n이 1이 될때까지 나누기를 반복
			if(n%2 == 1) { // 모든 자연수는 2의 제곱수로 표현이 가능하다.
				// 홀수인경우 나누면서 나오는 나머지 행렬을 추가로 곱해줘야 한다.
				now = metrix(now,f);
			}
			f = metrix(f, f); //행렬의 제곱을 진행
			n/=2; // 2의 제곱수를 제곱함을 역순으로 진행 n을 2의 제곱수로 나누길 반복
		}
		return now[0][1];
	}
	
	private long[][] metrix(long[][] m1, long[][] m2){ // 행렬의 곱
		long[][] m3 = new long[2][2];
		m3[0][0] = (m1[0][0]*m2[0][0]%mod + m1[0][1]*m2[1][0]%mod)%mod;
		m3[0][1] = (m1[0][0]*m2[0][1]%mod + m1[0][1]*m2[1][1]%mod)%mod;
		m3[1][0] = (m1[1][0]*m2[0][0]%mod + m1[1][1]*m2[0][1]%mod)%mod;
		m3[1][1] = (m1[1][0]*m2[0][1]%mod + m1[1][1]*m2[1][1]%mod)%mod;
		return m3;
	}

}