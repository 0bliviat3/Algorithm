import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] cnt = new int[6];
		while(n-- > 0) {
			cnt[Integer.parseInt(in.readLine())]++;
		}
		in.close();
		double avg = 0;
		boolean flag = true;
		for(int i = 1; i < 6; i++) {
			while(cnt[i]-- > 0) {
				if(flag) {
					avg = (double)i;
					flag = false;
				}else {
					avg = (i + avg)/2;					
				}
			}
		}
		System.out.print(String.format("%.6f", avg));
	}
}