import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = -1;
		int max = 0;
		for(int i=1;i<=9;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(max<temp) {
				max = temp;
				idx = i;
			}
		}
		br.close();
		sb.append(max);
		sb.append(" ");
		sb.append(idx);
		System.out.print(sb);
	}

}