import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		int cnt = 1;
		while(n-1 > 0) {
			n -= 6*cnt;
			cnt++;
		}
		System.out.print(cnt);
	}

}