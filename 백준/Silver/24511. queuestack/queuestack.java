import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int n , size;
	String[] arr;
	
	Main(int n){
		this.n = n;
		arr = new String[n];
	}
	
	private void clear(String A, String B) {
		String[] aArr = A.split(" ");
		String[] bArr = B.split(" ");
		for(int i = 0; i < n; i++) {
			if(aArr[i].equals("0")) {
				arr[size++] = bArr[i];
			}
		}
		
	}
	
	public String run(String A, String B, String C, int m) {
		StringTokenizer st = new StringTokenizer(C," ");
		StringBuilder sb = new StringBuilder();
		
		clear(A, B);
		
		while(m-- > 0) {
			if(size-- > 0) {
				sb.append(arr[size]).append(' ');
			}else {
				sb.append(st.nextToken()).append(' ');
			}
		}
		
		return sb.toString();
	}

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main instance = new Main(Integer.parseInt(in.readLine()));
		
		String A = in.readLine();
		String B = in.readLine();
		int m = Integer.parseInt(in.readLine());
		String C = in.readLine();
		
		in.close();

		System.out.print(instance.run(A, B, C, m));
	}
	

}


