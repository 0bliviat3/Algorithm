import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        in.close();
        
        int time = Integer.parseInt(st.nextToken());
        
        if(time >= 12 && time <= 16 && st.nextToken().equals("0")) {
            System.out.print(320);
        }else {
            System.out.print(280);
        }
    }
}