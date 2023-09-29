import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static HashMap<Long,Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	
	static int stepA, stepB;
	static long c;
	
	private static void setStep(long a) {
		int step = 0;
		while(true) {
			Integer key = map.put(a, step);
			if(key != null) { // 이전에 입력된적 있는 키인 경우
				stepA = key;
				stepB = step;
				c = a;
				return;
			}
			if(a == 1) return; // 1이면 리턴
			a = (a % 2 == 0) ? a / 2 : a * 3 + 1;
			step++;
		}
	}
	
	static void setSB(long a, long b) {
		map.clear();
		setStep(a);
		setStep(b);
		sb.append(a).append(" needs ").append(stepA)
		.append(" steps, ").append(b).append(" needs ")
		.append(stepB).append(" steps, they meet at ")
		.append(c).append('\n');
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		long a,b;
		while(true) {
			st = new StringTokenizer(in.readLine()," ");
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			if(a == 0) break;
			setSB(a,b);
		}
		
		in.close();
		
		System.out.print(sb);
	}
	

}


