import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private int[] line;
	
	Main(int k){
		line = new int[k];
	}
	
	private int binarySearch(int n, long end) {
		long start = 1;
		long mid = 0;
		while(start <= end) {
			mid = (start + end)/2;
			if(count(n,mid)) { // 크거나 같다면
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return (int) end;
	}
	
	private boolean count(int n, long len) {
		int modCnt = 0;
		for(int i = 0; i < line.length; i++) {
			modCnt += line[i]/len;
		}
		return modCnt >= n;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		Main m = new Main(k);
		
		long end = 0;
		for(int i = 0; i < k; i++) {
			m.line[i] = Integer.parseInt(in.readLine());
			if(end < m.line[i]) {
				end = m.line[i];
			}
		}
		
		in.close();
		
		
		int ans = m.binarySearch(n, end);
		
		System.out.print(ans);
	}

}
