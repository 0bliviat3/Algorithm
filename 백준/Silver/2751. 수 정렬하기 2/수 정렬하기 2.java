import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 정렬해서 담을 배열
	public int [] myArr = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력 시작
		// 수의 개수
		int n = Integer.parseInt(br.readLine());
		// 정렬할 수
		// 전체 데이터 저장
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 입력 끝
		br.close();
		Main ms = new Main();
		ms.myArr = new int[n];
		ms.mySort(arr,0,n-1);
		
		for(int i=0;i<n;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}


	private void mySort(int[] arr, int left, int right) {
		// 받은 배열의 길이가 1이라면 정렬할필요 없음.
		if (left == right) {
			return;
		}
		
		int mid = (left+right)/2;
		
		// 재귀 시켜서 길이 1까지 분리
		mySort(arr,left,mid);
		
		mySort(arr,mid+1,right);
		
		// 병합정렬 진행
		merge(arr,left,mid,right);
	}


	private void merge(int[] arr, int left, int mid, int right) {
		int l = left; // 왼쪽 부분 배열 시작점
		int r = mid + 1; // 오른쪽 부분 배열 시작점
		int idx = left; // 채워넣을 배열 인덱스
		
		while((l <= mid) && (r <= right)) { // 반복할 배열의 범위
			// 왼쪽 배열과 오른쪽 배열의 값 비교
			if(arr[l] <= arr[r]) {
				myArr[idx] = arr[l];
				idx++;
				l++;
			}else {
				myArr[idx] = arr[r];
				idx++;
				r++;
			}
		}
		
		// 한쪽의 부분 배열이 먼저 끝까지 진행되어
		// 반복을 빠져나온경우
		// 왼쪽배열이 끝난경우를 먼저 가정
		if(l > mid) { // 오른쪽 배열끝날때까지 그냥 다 때려박음
			while(r <= right) {
				myArr[idx] = arr[r];
				idx++;
				r++;
			}
		}else { // 오른쪽 배열이 먼저 끝난경우
			while(l <= mid) {
				myArr[idx] = arr[l];
				idx++;
				l++;
			}
		}
		
		// 정렬된 배열을 기존 배열에 복사
		for(int i = left; i<= right; i++) {
			arr[i] = myArr[i];
		}
		
	}

}