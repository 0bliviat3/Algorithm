import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	/*
	 * 문제에서 주어지는 것은 배열의 크기 n, 개수 k 이다
	 * k가 의미하는것은 임의의 수 b[k] 를 m 이라고 둘 때
	 * m 보다 작거나 같은 수의 개수를 의미한다
	 * 이분 탐색을 통해 m보다 작거나 같은 수의 개수가 k인 경우를
	 * 찾아내면 된다
	 * 
	 * 참고 ) http://wookje.dance/2017/02/20/boj-1300-K%EB%B2%88%EC%A7%B8-%EC%88%98/
	 */
	
	static int n,k;
	
	static boolean chk(int mid) {
		int cnt = 0;
		for(int i = 1; i <= n; i++) { // i는 이차원 배열의 행을 의미한다
			cnt += Math.min(mid/i, n); // 더하는 값은 각 행에서 현재구하려는 값보다 작거나 같은 값의 수를 의미한다
		}
		return cnt < k; // cnt 값은 모든 배열을 탐색했을때 임의의 값 보다 작거나 같은 값의 개수를 의미하므로 k와 비교한다
	}
	
	static int getVal() {
		int start = 1;
		int end = k; // 상한을 k로 두는 이유는 배열에 존재하는 수가 k번째로 작은 수는 k 이하이므로 가능하다
		int mid = 0;
		while(start < end) {
			mid = (start + end)/2;
			if(chk(mid)) { // k보다 작은 경우
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return end;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		k = Integer.parseInt(in.readLine());
		
		in.close();
		
		System.out.print(getVal());
	}

}
