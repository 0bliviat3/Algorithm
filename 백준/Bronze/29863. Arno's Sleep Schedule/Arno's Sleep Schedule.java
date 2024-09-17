import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sleep = Integer.parseInt(in.readLine());
		int up = Integer.parseInt(in.readLine());
		
		if (sleep > 10) {
			sleep = 24 - sleep;
			up += sleep;
		} else {
			up -= sleep;
		}
		
		System.out.print(up);
	}
}
