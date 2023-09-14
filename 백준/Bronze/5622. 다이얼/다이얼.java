import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String word = in.readLine();
		in.close();
		int time = 0;
		for(int j=0;j<word.length();j++) {
			for(int i=65;i<=90;i++) { // A-Z
				if((int) word.charAt(j) == i) {
					if(i<80) {
						time += (i-65)/3 + 3;
						break;						
					}else if(i>86) {
						time += 10;
						break;
					}else if(i>79 && i<84){
						time +=8;
						break;
					}else {
						time +=9;
					}
				}
			}
		}	
		sb.append(time);
		System.out.print(time);

	}

}