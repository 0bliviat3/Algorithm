import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num1 = Integer.parseInt(br.readLine());
		String num2 = br.readLine();
		br.close();
		for(int i=2;i>=0;i--) {
			sb.append(num1*((int)num2.charAt(i)-48)).append("\n");
		}
		sb.append(num1*Integer.parseInt(num2));
		System.out.println(sb);
	}

}