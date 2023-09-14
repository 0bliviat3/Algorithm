import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		in.nextLine();
		in.close();
		System.out.println(n*(n-1)*(n-2)/6);	
		System.out.print(3);		
		
	}

}