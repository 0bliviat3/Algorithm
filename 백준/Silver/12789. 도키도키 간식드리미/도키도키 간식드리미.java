import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 2개의 스택 사용
	 * 1. 기본적으로 현재 줄 스택 A
	 * 2. 순서가 다른경우 세울 줄 스택 B
 	 * 3. 각 스택의 top에 현재 순서에 해당하는 번호라면 pop
 	 * 4. 두 스택 모두 top에 현재 순서에 해당하는 번호가 없는경우 
 	 * 		A 스택 pop B스택으로 push
 	 * 5. A 스택 isEmpty == ture 일때 n+1 != 현재순서 라면 sad
 	 * 6. 현재 순서 == n + 1 인 경우 nice 
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		for(int i = 0; i < n; i++) { // init
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int now = 1; // 현재 순서
		int aTop = 0;
		int bTop = n - 1;
		
		while(true) {
			if(aTop == n) { // A isEmpty
				if(now == n + 1) {
					System.out.print("Nice");
					break;
				}else if(B[bTop] != now) {
					System.out.print("Sad");
					break;
				}
			}
			if(aTop != n && now == A[aTop]) { // 3
				A[aTop++] = 0;
				now++;
			}else if(now == B[bTop]) { // 3
				B[bTop++] = 0;
				now++;
			}else { // 4
				B[--bTop] = A[aTop];
				A[aTop++] = 0;
			}
		}
	}

}