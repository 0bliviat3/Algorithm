import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String temp = in.readLine();
		in.close();
		int n = Integer.parseInt(temp);	
		int ans = 0;
		int start = n - temp.length() * 9;
		for(int i = start; i < n; i++) {
			String strN = Integer.toString(i);
			int now = i;
			for(int j = 0; j < strN.length(); j++) {
				now += (strN.charAt(j) - '0');
			}
			if(now == n) {
				ans = i;
				break;
			}
		}
		System.out.print(ans);
	}

}