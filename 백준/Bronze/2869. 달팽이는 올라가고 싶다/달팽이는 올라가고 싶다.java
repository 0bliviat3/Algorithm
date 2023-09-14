import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		in.close();
		int n = (V-B)/(A-B);
		int mod = (V-B)%(A-B);
		
		if(mod == 0) {
			sb.append(n);
		}else {
			sb.append(n+1);
		}
		System.out.print(sb);
	}

}