import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] arr = new int[41];
	
	static int dp(int n) {
		int cnt = 0;
		arr[1] = arr[2] = 1;
		for(int i = 3; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			cnt++;
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		in.close();
		
		int cnt = dp(n);
		
		System.out.print(arr[n] + " " + cnt);
	}

}
