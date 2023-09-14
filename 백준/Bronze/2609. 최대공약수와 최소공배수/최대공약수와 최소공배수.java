import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int big = (n > m) ? n : m; // 큰수
		int small = (n > m) ? m : n; // 작은수
		
		Main u = new Main();
		
		int most = u.euclid(big, small);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(most + "\n");
		sb.append(big/most*small);
		
		System.out.print(sb);
		
	}
	/**
	 * 유클리드 호제법
	 * @param b : 큰수를 인자값으로 받습니다
	 * @param s : 작은수를 인자값으로 받습니다
	 * @return : 최대공약수를 리턴합니다.
	 */
	private int euclid(int b, int s) {
		if(b%s == 0) {
			return s;
		}
		int mod = b%s;
		return euclid(s,mod);
	}

}