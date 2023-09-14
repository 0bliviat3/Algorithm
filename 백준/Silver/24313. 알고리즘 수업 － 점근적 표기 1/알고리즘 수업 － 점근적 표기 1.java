import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		/*
		 * f(n) = a1n + a0
		 * c,n0 > 0
		 * n >= n0
		 * f(n) <= c*g(n)인 양수 c와 n0가 존재한다.
		 * 
		 * f(n) = 7*n + 7
		 * 7(n+1) <= 8*n
		 * 7 <= n
		 * g(n) = n
		 * n == 1~6일때 만족하지 않는다.
		 * 
		 * n >= n0 일때,
		 * (n0<=100)
		 * a1*n + a0 <= c*n
		 * 의 조건을 만족하면 1
		 * 만족하지 않는다면 0 출력
		 * 
		 * (a1-c)*n + a0 <= 0
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		final int a1 = Integer.parseInt(st.nextToken());
		final int a0 = Integer.parseInt(st.nextToken());
		final int c = Integer.parseInt(in.readLine());
		final int n0 = Integer.parseInt(in.readLine());
		in.close();
		boolean flag = false;
		for(int i = n0; i<=100; i++) {
			if((((a1 - c) * i) + a0) > 0) {
				flag = true;
			}
		}
		
		if(flag) {
			System.out.print(0);
		}else {
			System.out.print(1);
		}
	}

}