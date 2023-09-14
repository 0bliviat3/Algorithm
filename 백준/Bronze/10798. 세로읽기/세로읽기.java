import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] temp = new String[5]; 
		
		int maxLen = 0;
		for(int i = 0; i < 5; i++) {
			temp[i] = in.readLine();
			if(maxLen < temp[i].length()) {
				maxLen = temp[i].length();
			}
		}
		
		for(int i = 0; i < maxLen; i++) {
			for(int j = 0;j < 5; j++) {
				if(temp[j].length() > i) {
					String now = String.valueOf(temp[j].charAt(i));
					sb.append(now);
				}
			}
		}
		
		System.out.print(sb);

	}

}