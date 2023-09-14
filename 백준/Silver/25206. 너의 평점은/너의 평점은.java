import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Double> grade = new HashMap<>();
		// 값 넣기
		grade.put("A+", 4.5);
		grade.put("A0", 4.0);
		grade.put("B+", 3.5);
		grade.put("B0", 3.0);
		grade.put("C+", 2.5);
		grade.put("C0", 2.0);
		grade.put("D+", 1.5);
		grade.put("D0", 1.0);
		grade.put("F", 0.0);
		double sum = 0;
		double tempSum = 0;
		for(int i=0;i<20;i++) {
			String data = in.readLine();
			String[] reData = data.split(" ");
			if(!reData[2].equals("P")) {
				tempSum += Double.valueOf(reData[1]);
				sum += grade.get(reData[2])*Double.valueOf(reData[1]);
			}
		}
		System.out.println(sb.append(sum/tempSum));
	}

}