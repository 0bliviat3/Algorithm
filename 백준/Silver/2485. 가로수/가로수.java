import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int nowTree = 0;
		int preTree = 0;
		int gap = 0;
		int most = 0;
		int first = 0;
		int last = 0;
		for(int i = 0; i < n; i++) {
			nowTree = Integer.parseInt(in.readLine());
			if(i == 0) first = nowTree;
			if(i == n - 1) last = nowTree;
			if(preTree == 0) {
				preTree = nowTree;
			}else {
				gap = nowTree - preTree;
				if(most == 0) {
					most = gap;
				}else {
					int big = (most > gap) ? most : gap;
					int small = (most > gap) ? gap : most;
					most = euclid(big,small);
					preTree = nowTree;
				}
			}
		}
		
		System.out.print((last - first)/most - n + 1);
	}
	
	static int euclid(int b, int s) {
		if(b == s || b%s == 0) {
			return s;
		}
		return euclid(s,b%s);
	}

}
