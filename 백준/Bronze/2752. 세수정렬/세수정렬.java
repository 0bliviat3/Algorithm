import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		
		Arrays.sort(arr);
		
		for(int i : arr) {
			sb.append(i).append(' ');
		}
		
		System.out.print(sb);
	}

}
