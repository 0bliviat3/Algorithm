import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	/*
	 * a 배열을 오름차순
	 * b 배열은 내림차순으로 정렬후
	 * 곱, 합 진행
	 * 합을 출력
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringTokenizer st2 = new StringTokenizer(in.readLine()," ");
		
		in.close();
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += a[i]*b[n - 1 - i];
		}
		
		System.out.print(sum);
	}
}
