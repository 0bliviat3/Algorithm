import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String word = br.readLine();
		int idx = Integer.parseInt(br.readLine());
		char a = word.charAt(idx-1);
		sb.append(a);
		System.out.print(sb);
	}
}