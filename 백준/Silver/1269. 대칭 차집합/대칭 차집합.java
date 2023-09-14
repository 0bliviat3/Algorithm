import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] symmetricDifference = new boolean[100_000_000];
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine()," ");
		while(A-- > 0) {
			int idx = Integer.parseInt(st.nextToken());
			symmetricDifference[idx] = true;
		}
		st = new StringTokenizer(in.readLine()," ");
		while(B-- > 0) {
			int idx = Integer.parseInt(st.nextToken());
			if(symmetricDifference[idx]) {
				symmetricDifference[idx] = false;
			}else {
				symmetricDifference[idx] = true;
			}
		}
		
		int cnt = 0;
		
		for(boolean flag : symmetricDifference) {
			if(flag) cnt++;
		}
		
		System.out.print(cnt);
	}

}
