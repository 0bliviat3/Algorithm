import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ1043Sol instance = new BOJ1043Sol();
		instance.run();
	}

}

class BOJ1043Sol {

	private static final int TRUE = 0;
	private List<List<Integer>> partys;
	private int[] group;

	private void clear(int n) {
		group = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			group[i] = i;
		}
		partys = new ArrayList<>();
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		clear(n);

		init(in.readLine());

		for (int i = 0; i < m; i++) {
			partys.add(new ArrayList<>());
			init(partys.get(i), in.readLine());
		}
	}

	private void init(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int n = Integer.parseInt(st.nextToken());
		while (n-- > 0) {
			group[Integer.parseInt(st.nextToken())] = TRUE;
		}
	}

	private void init(List<Integer> party, String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			int person = Integer.parseInt(st.nextToken());
			party.add(person);
			if (i > 0) {
				unionParent(party.get(i - 1), person);
			}
		}
	}

	private int getParent(int child) {
		if (group[child] == child)
			return child;
		return group[child] = getParent(group[child]);
	}

	private void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a < b) {
			group[b] = a;
			return;
		}
		group[a] = b;
	}

	private boolean isKnowTrue(int person) {
		person = getParent(person);
		if (person == TRUE) {
			return true;
		}
		return false;
	}

	private boolean isFakeTime(List<Integer> party) {
		for (int person : party) {
			if (isKnowTrue(person)) {
				return false;
			}
		}
		return true;
	}

	void run() {
		int partyCnt = 0;
		try {
			init();
			for (List<Integer> party : partys) {
				if (isFakeTime(party)) {
					partyCnt++;
				}
			}
			System.out.print(partyCnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
