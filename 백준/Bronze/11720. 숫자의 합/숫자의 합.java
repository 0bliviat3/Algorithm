import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		String num = in.readLine();
		in.close();
		int temp = 0;
		while(n-- >0) {		
			temp+=Integer.parseInt(String.valueOf(num.charAt(n)));
		}
		sb.append(temp);
		System.out.print(sb);

	}

}