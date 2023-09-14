import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] grade = new int[n];
		
		for(int i = 0; i < n; i++) {
			grade[i] = Integer.parseInt(in.readLine());
		}
		
		int now = grade[n - 1] - 1;
		int cnt = 0;
		
		for(int i = n - 2; i >= 0; i--) {
			if(now < grade[i]) {
				int gap = grade[i] - now;
				cnt += gap;
				grade[i] -= gap;
			}
			now = grade[i] - 1;
		}
		
		System.out.print(cnt);
	}
}
