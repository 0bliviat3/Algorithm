import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BOJ6198Sol instance = new BOJ6198Sol(new int[80_000]);
		instance.run();
	}
	
}

class BOJ6198Sol {
	
	private final int[] stack;
	
	private int top = -1;
	
	BOJ6198Sol(final int[] stack) {
		this.stack = stack;
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long ans = 0;
		while(n-- > 0) {
			int h = Integer.parseInt(in.readLine());
			ans += nextBuilding(h);			
		}
		ans += popCnt();
		System.out.print(ans);
	}
	
	private long nextBuilding(int h) {
		long size = 0;
		while(top != -1 && stack[top] <= h) {
			size += top;
			top--;
		}
		stack[++top] = h;
		return size;
	}
	
	private long popCnt() {
		long size = 0;
		while(top != -1) {
			size += top;
			top--;
		}
		return size;
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
