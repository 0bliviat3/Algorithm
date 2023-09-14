import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		
		int now = 666;
		int cnt = 0;
		int value = 0;
		while(cnt != n) {
			value = now;
			now++;
			while(value != 0) {
				if(value % 1000 == 666) {
					cnt++;
					break;
				}
				value/=10;
			}
		}
		
		System.out.print(--now);
	}
	

}