import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		BOJ3273Sol instance = new BOJ3273Sol();
		instance.run();
	}

}

class BOJ3273Sol {
	
	private BOJ3273Numbers numbers;
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		init(in.readLine(), n);
		System.out.print(
				numbers.calculatePairCnt(Integer.parseInt(in.readLine())));
	}
	
	private void init(String input, int n) {
		Set<Integer> nums = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(input," ");
		while(n-- > 0) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		numbers = new BOJ3273Numbers(nums);
	}
	
}

class BOJ3273Numbers {
	
	private final Set<Integer> numbers;
	
	BOJ3273Numbers(final Set<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public int calculatePairCnt(int target) {
		int cnt = 0;
		for(int number : numbers) {
			if(number > target) {
				return cnt / 2;
			}
			int gap = target - number;
			if(gap == number) {
				continue;
			}
			if(numbers.contains(gap)) {
				cnt++;
			}
		}
		return cnt / 2;
	}
	
}