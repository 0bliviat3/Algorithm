import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private void quick(char[] charArr, int start, int end) {
		if(start >= end) {
			return;
		}
		int pivotIdx = nowPivot(charArr, start, end);
		quick(charArr,start,pivotIdx - 1);
		quick(charArr,pivotIdx + 1,end);
		
		
	}
	
	private int nowPivot(char[] charArr, int start, int end) {
		char pivot = charArr[start];
		int left = start;
		int right = end;
		while(left < right) {
			while(charArr[right] > pivot && left < right) {
				right--;
			}
			while(charArr[left] <= pivot && left < right) {
				left++;
			}
			change(charArr,left,right);
		}
		change(charArr,start,left);
		
		return left;
	}
	
	private void change(char[] charArr, int idx, int jdx) {
		char temp = charArr[idx];
		charArr[idx] = charArr[jdx];
		charArr[jdx] = temp;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] number = in.readLine().toCharArray();
		in.close();
		Main m = new Main();
		StringBuilder sb = new StringBuilder();
		m.quick(number, 0, number.length - 1);
		for(int i = number.length - 1; i>=0; i--) {
			sb.append(number[i]);
		}
		System.out.print(sb);
	}

}
