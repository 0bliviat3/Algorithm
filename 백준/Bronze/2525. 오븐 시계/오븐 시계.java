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
		int time = Integer.parseInt(br.readLine());
		br.close();
		int plus = min + time;
		if(plus/60>=1) {
			hour+=plus/60;
			if(hour>23) {
				hour-=24;
			}
		}
		sb.append(hour).append(" ");
		sb.append(plus%60);
		System.out.println(sb);
	}

}