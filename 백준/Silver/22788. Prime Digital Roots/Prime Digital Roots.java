import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static final int end = 1_000_000;
	static boolean[] primeArr = new boolean[end];
	
	static void eratos() {
		primeArr[0] = primeArr[1] = true;
		for(int i = 2; i*i < end; i++) {
			for(int j = i*i; j < end; j += i) {
				primeArr[j] = true;
			}
		}
	}
	
	static int getRoot(int input) {
		if(!primeArr[input]) return input;
		if(input < 10) return 0;
		int sum = 0;
		for(int i = end/10; i > 0; i/=10) {
			int now = input/i;
			sum += now;
			input -= now*i;
		}
		return getRoot(sum);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		eratos();
		
		String now = in.readLine();
		
		while(!now.equals("0")) {
			sb.append(String.format("%7s", now)).append(' ');
			int root = getRoot(Integer.parseInt(now));
			if(root == 0) {
				sb.append(String.format("%7s", "none"));
			}else {
				sb.append(String.format("%7d", root));
			}
			sb.append('\n');
			now = in.readLine();
		}
		
		in.close();
		
		System.out.print(sb);
	}

}
