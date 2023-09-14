import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		/*
		 * 가장 긴 변의 길이보다 나머지 두변의 길이가 길어야 한다.
		 * 가장 긴 길이를 제외한 나머지 변의 길이의 합 -1 
		 * 가장 긴변의 길이와 비교후 둘레길이 구하기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int[] arr = new int[3];
		int max = 0;
		int idx = 0;
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max<arr[i]) {
				max = arr[i];
				idx = i;
			}
		}
		int sum = 0;
		for(int i=0;i<3;i++) {
			if(i != idx) {
				sum+=arr[i];
			}
		}
		int result = 0;
		if(sum > max) {
			result = sum+max;
		}else {
			result = (sum << 1) - 1;
		}
		
		System.out.print(result);
	}

}