import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int max = Integer.parseInt(st.nextToken());
		int min = max;
		for(int i = 0;i<n-1;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(max<temp) {
				max = temp;
			}
			if(min>temp) {
				min = temp;
			}
		}
		sb.append(min);
		sb.append(" ");
		sb.append(max);
		System.out.print(sb);

	}

}