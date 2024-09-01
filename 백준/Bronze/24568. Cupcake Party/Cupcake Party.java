import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int sum = 0;
      sum += 8 * Integer.parseInt(in.readLine());
      sum += 3 * Integer.parseInt(in.readLine());
      
      System.out.println(sum - 28);
   }

}