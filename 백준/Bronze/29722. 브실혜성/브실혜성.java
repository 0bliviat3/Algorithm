import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(),"-");
		
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(in.readLine());
		
		in.close();		
		
		if(n >= 360) {
			year += n/360;
			n %= 360;
		}
		
		if(n >= 30) {
			month += n/30;
			
			n %= 30;
		}
		
		day += n;
		
		if(day > 30) {
			day -= 30;
			month++;
		}
		
		if(month > 12) {
			month -= 12;
			year++;
		}
		
		sb.append(year).append('-');
		
		if(month < 10) {
			sb.append(0).append(month).append('-');
		}else {
			sb.append(month).append('-');
		}
		
		if(day < 10) {
			sb.append(0).append(day);
		}else {
			sb.append(day);
		}
		
		System.out.print(sb);
	}
	
}
