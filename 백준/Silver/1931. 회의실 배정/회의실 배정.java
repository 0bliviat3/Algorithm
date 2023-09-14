import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 *  두 값을 갖는 객체로 배열 생성후 
	 *  배열 정렬
	 *  정렬기준 override >> 두값중 끝값을 기준으로 정렬
	 *  정렬된 배열 반복문 진행
	 *  조건은 배열의 현재 객체의 첫값 >= 이전 배열의 객체의 끝값인 경우 cnt++
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Bound[] timeBound = new Bound[n];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			timeBound[i] = new Bound(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		in.close();
		Arrays.sort(timeBound);
		int end = 0;
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(end <= timeBound[i].start) {
				cnt++;
				end = timeBound[i].end;
			}
		}
		
		System.out.print(cnt);
	}
	
	

}

class Bound implements Comparable<Bound>{
	
	int start,end;
	
	Bound(int s, int e){
		start = s;
		end = e;
	}

	@Override
	public int compareTo(Bound o) { // 시작도 정렬기준에 포함 시켜야 한다
		if(this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
	
}
