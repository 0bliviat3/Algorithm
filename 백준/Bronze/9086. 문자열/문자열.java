import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			String word = br.readLine();
			sb.append(word.charAt(0));
			sb.append(word.charAt(word.length()-1));
			sb.append("\n");
		}
		System.out.print(sb);

	}

}