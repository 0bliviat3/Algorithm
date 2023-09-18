import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 버튼은 0부터 9 10개
	 * 현재 위치는 100
	 * 이동하려는 채널 - 100 의 절댓값이 초기 최소값
	 * 백트래킹으로 현재의 리모콘 상태로 가능한 모든 번호의 조합 생성
	 * 생성된 조합 - 이동하려는채널의 절댓값 + 누른 버튼의 수와 비교
	 * 최소값 갱신후 모든 탐색이 끝나면 출력
	 */
	
	static int min,num,len;
	
	static int[] arr = new int[7];
	
	static boolean[] remote = new boolean[10];
	
	static void dfs(int depth) {
		if(depth == 7) return;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < depth; i++) {
			sb.append(arr[i]);
		}
		String val = sb.toString();
		if(val != null && !val.isEmpty()) {
			int now = Integer.parseInt(val);
			min = Math.min(min, val.length() + Math.abs(num - now));			
		}
		
		for(int i = 0; i < 10; i++) {
			if(!remote[i]) {
				if(depth == 0 && i == 0 && len > 2) continue;
				arr[depth] = i;
				dfs(depth + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String origin = in.readLine();

		int m = Integer.parseInt(in.readLine());
		
		if(m != 0) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");			
			while(m-- > 0) {
				remote[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		in.close();
		
		len = origin.length();
		num = Integer.parseInt(origin);
		min = Math.abs(num - 100);
		
		
		dfs(0);
		
		System.out.print(min);
	}

}
