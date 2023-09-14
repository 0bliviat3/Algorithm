import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		int[] p = new int[4];
		p[0] = Integer.parseInt(st.nextToken());
		p[1] = Integer.parseInt(st.nextToken());
		p[2] = Integer.parseInt(st.nextToken()) - p[0];
		p[3] = Integer.parseInt(st.nextToken()) - p[1];
		
		int min = p[0];
		for(int i = 0; i < p.length; i++) {
			if(min>p[i]) {
				min = p[i];
			}
		}
		
		System.out.print(min);
		
	}

}