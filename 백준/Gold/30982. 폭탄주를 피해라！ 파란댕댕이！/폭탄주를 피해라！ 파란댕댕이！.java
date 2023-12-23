import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		new PadaengDSol().run();
	}

}

class PadaengDSol {
	
	/*
	 * step 1.
	 * 1마리 부터 m마리까지 왼쪽에서만 가져올때의 최소시간들을 저장
	 * 			"		오른쪽에서만		"
	 * step 2.
	 * 왼쪽에서 x마리 가져오고 오른쪽에서 y마리를 가져오되 x + y == m - p 인경우만 가져온다.
	 * 각 경우에 대해서 min(left[x], right[y]) * 2 + max(left[x], right[y]) <= t 라면 return yes
	 * 모든 경우가 > t 라면 return no 
	 */
	// 기본적으로 주어지는 값들
	private int[] groups;
	private int n, m, t, p;
	
	// 1마리에서 m마리까지 왼쪽에서만 가져올 최소시간들
	private int[] leftTime;
	// 1마리에서 m마리까지 오른쪽에서만 가져올 최소시간들
	private int[] rightTime;
	
	// 배열 초기 길이 동적할당
	private void clear() {
		groups = new int[n + 1];
		leftTime = new int[m + 1];
		rightTime = new int[m + 1];
		Arrays.fill(leftTime, Integer.MAX_VALUE);
		Arrays.fill(rightTime, Integer.MAX_VALUE);
		leftTime[0] = 0;
		rightTime[0] = 0;
	}
	
	// 1마리 부터 m마리까지 최소시간을 저장 (왼쪽)
	private void minLeft() {
		for(int time = 1; time < p; time++) {
			int group = groups[p - time];
			for(int i = m; i >= group; i--) {
				if(leftTime[i - group] != Integer.MAX_VALUE) {
					leftTime[i] = Math.min(leftTime[i], time);
				}
			}
		}
	}
	
	// 1마리 부터 m마리까지 최소시간을 저장 (오른쪽)
	private void minRight() {
		for(int time = 1; time <= n - p; time++) {
			int group = groups[p + time];
			for(int i = m; i >= group; i--) {
				if(rightTime[i - group] != Integer.MAX_VALUE) {
					rightTime[i] = Math.min(rightTime[i], time);
				}
			}
		}
	}
	
	// step2
	private String find() {
		m -= groups[p];
		int right = m;		
		for(int left = 0; left <= m; left++) {
			int min = Math.min(leftTime[left], rightTime[right]);
			int max = Math.max(leftTime[left], rightTime[right]);
			right--;
			
			if(max == Integer.MAX_VALUE || min == Integer.MAX_VALUE) {
				continue;
			}
			if(min * 2 + max <= t) {		
				return "YES";
			}
		}
		return "NO";
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		clear();
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			groups[i] = Integer.parseInt(st.nextToken());
		}
		
		p = Integer.parseInt(in.readLine());
	}
	
	void run() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		minLeft();
		minRight();
		System.out.print(find());
	}
	
}
