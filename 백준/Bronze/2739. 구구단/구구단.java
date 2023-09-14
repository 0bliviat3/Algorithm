import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		br.close();
		for (int i = 1; i < 10; i++) {
			sb.append(n);
			sb.append(" * ");
			sb.append(i);
			sb.append(" = ");
			sb.append(n*i);
			sb.append("\n");
		}
		System.out.print(sb);
	}

}