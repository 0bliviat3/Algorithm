import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = in.readLine();
		while(input != null) {
			if(!input.isEmpty()) {
				sb.append(input);
				sb.append("\n");
				input = in.readLine();
			}else {
				break;
			}
		}
		in.close();
		System.out.print(sb);
		
	}

}