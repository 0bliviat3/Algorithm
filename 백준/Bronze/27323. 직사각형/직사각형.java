import java.io.*;
class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(Integer.parseInt(in.readLine())*Integer.parseInt(in.readLine()));
		in.close();
	}
}