import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = in.readLine();
		in.close();
		for (int i = 97; i < 123; i++) { // ASCII
			sb.append(s.indexOf((char)i));
			sb.append(" ");
		}
		System.out.print(sb);
	}
}