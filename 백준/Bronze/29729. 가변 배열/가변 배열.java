import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,idx;
	static boolean[] arr,arr2;
	
	static void cloneArr() {
		arr2 = new boolean[n << 1];
		for(int i = 0; i < n; i++) {
			arr2[i] = arr[i];
		}
		arr = arr2;
		n*=2;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(st.nextToken());
		t += Integer.parseInt(st.nextToken());
		
		arr = new boolean[n];
		
		while(t-- > 0) {
			int now = Integer.parseInt(in.readLine());
			if(now == 1) {
				if(idx == n) {
					cloneArr();
				}
				arr[idx++] = true;
			}else {
				arr[--idx] = false;
			}
		}
		
		in.close();
		
		System.out.print(n);
		
	}

}
