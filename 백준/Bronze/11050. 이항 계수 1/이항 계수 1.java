import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int result = 1;
		if(k != 0 && n != k) {
			for(int i = n; i >= 1; i--) {		
				if(i > k) result*=i;
				if(i <= n - k) result/=i;
			}			
		}
		
		System.out.print(result);
		
	}

}