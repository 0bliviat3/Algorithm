import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] numberArr = in.readLine().toCharArray();
		in.close();
		
		int n = numberArr.length - 1;
		Arrays.sort(numberArr);
		if(numberArr[0] != '0') {
			System.out.print(-1);
		}else {
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = n; i >= 0; i--) {
				sum += numberArr[i] - '0';
				sb.append(numberArr[i]);
			}
			if(sum % 3 != 0) {
				System.out.print(-1);
			}else {
				System.out.print(sb);
			}
		}
		
	}
}
