import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine()," ");
		in.close();
		int[] apple = new int[n];
		for(int i = 0; i < n; i++) {
			apple[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(apple);
		for(int i = 0; i < n; i++) {
			if(len >= apple[i]) {
				len++;
			}
		}
		
		System.out.print(len);
	}

}