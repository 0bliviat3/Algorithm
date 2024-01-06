import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static final String JOKE = "joke";
	private static final int SIZE = 4;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		int cnt = 0;
		while((input = in.readLine()) != null) {
			cnt += (input.length() - input.replace(JOKE, "").length()) / SIZE;
		}
		System.out.print(cnt);
	}

}