import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Stu[] student = new Stu[n];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			Stu s = new Stu(name,year,month,day);
			student[i] = s;
		}
		
		Arrays.sort(student);
		
		StringBuilder sb = new StringBuilder();
		sb.append(student[n - 1].name + "\n");
		sb.append(student[0].name);
		
		System.out.print(sb);
		
	}
	
	

}


		
class Stu implements Comparable<Stu>{
	String name = null;
	int year = 0;
	int month = 0;
	int day = 0;
	Stu(String name, int year, int month, int day){
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public int compareTo(Stu o) {
		if(year == o.year && month == o.month) {
			return day - o.day;
		}
		if(year == o.year) {
			return month - o.month;
		}
		return this.year - o.year;
	}
}