import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		String[] num = in.readLine().split(" "); // idx가 출력할 순서가 됨 나중에 비교하면서 출력
		in.close();
		
		Set<Integer> numberSet = new HashSet<>();
		for(int i = 0; i < n; i++) {
			numberSet.add(Integer.parseInt(num[i])); // 중복되는값 제거
		}
		
		List<Integer> numberList = new ArrayList<>(numberSet); // 정렬을 위해 리스트로 변환
		Collections.sort(numberList); // 정렬
		
		// key값으로 num배열의 값으로 넣어서 출력하기 위해 map으로 변환
		HashMap<Integer,Integer> numberMap = new HashMap<>();
		for(int i = 0; i < numberList.size(); i++) {
			numberMap.put(numberList.get(i), i);
		}
		
		for(int i = 0; i < n; i++) {
			int now = numberMap.get(Integer.parseInt(num[i]));
			out.write(now + " ");
		}
		
		out.flush();
		out.close();
		
	}

}
