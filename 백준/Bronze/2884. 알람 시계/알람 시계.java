import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		if(min < 45) {
			if(hour == 0) {
				hour = 23;
				min+=15;
			}else {
				hour--;
				min+=15;
			}
		}else {
			min-=45;
		}
		sb.append(hour).append(" ").append(min);
		System.out.println(sb);

	}

}