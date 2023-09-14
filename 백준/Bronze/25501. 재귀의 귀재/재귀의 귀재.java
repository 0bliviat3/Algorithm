import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int cnt = 0;
	
	static int recursion(String s, int left, int right) {
		cnt++;
		if(left >= right) {
			return 1;
		}else if(s.charAt(left) != s.charAt(right)) {
			return 0;
		}else {
			return recursion(s,left + 1, right - 1);
		}
	}
	
	static int isPalindrome(String s) {
		return recursion(s,0,s.length() - 1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			sb.append(isPalindrome(in.readLine()) + " ");
			sb.append(cnt + "\n");
			cnt = 0;
		}
		
		in.close();
		
		System.out.print(sb);
	}

}
