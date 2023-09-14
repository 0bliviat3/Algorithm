import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		in.close();
		
		char[] left = input[0].toCharArray();
		char[] right = input[1].toCharArray();
		int n = left.length; // 한번만 참조하기 위함
		int cnt = 0;
		if(n == right.length) {
			for(int i = 0; i < n; i++) {
				if(left[i] == right[i] && left[i] == '8') {
					cnt++;
				}else if(left[i] != right[i]) {
					break;
				}
			}			
		}		
		System.out.print(cnt);
	}
}
