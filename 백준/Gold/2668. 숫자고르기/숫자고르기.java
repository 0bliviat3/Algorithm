import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Boj2668Sol instance = new Boj2668Sol();
		instance.run();
	}
	
}


class Boj2668Sol {
	
	private int[] edges;
	private boolean[] visit;
	private boolean flag;
	private Set<Integer> ans;
	
	private void clear(int n) {
		edges = new int[n + 1];
		visit = new boolean[n + 1];
		ans = new HashSet<>();
	}
	
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
		clear(n);
		for(int i = 1; i <= n; i++) {
			edges[i] = Integer.parseInt(in.readLine());
		}
		search(n);
		System.out.print(build(n));
	}
	
	private void dfs(int edge, int defaultVal) {
		if(visit[edge]) { 
			if(defaultVal == edge) {
				flag = true;
				ans.add(edge);
			}
			return;
		}
		visit[edge] = true;
		dfs(edges[edge],defaultVal);
		if(flag) {
			ans.add(edge);
			ans.add(edges[edge]);
		}
	}
	
	private void search(int n) {
		for(int i = 1; i <= n; i++) {
			visit[i] = true;
			dfs(edges[i], i);
			Arrays.fill(visit, false);
			flag = false;
		}
	}
	
	private String build(int n) {
		StringBuilder sb = new StringBuilder();
		List<Integer> ansList = new ArrayList<>(ans);
		Collections.sort(ansList);
		sb.append(ansList.size()).append('\n');
		for(int i : ansList) {
			sb.append(i).append('\n');
		}
		return sb.toString();
	}
	
}