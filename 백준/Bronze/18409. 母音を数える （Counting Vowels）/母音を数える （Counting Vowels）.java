import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
        
        char[] chks = {'a', 'e', 'i', 'o', 'u'};
        char[] arr = in.readLine().toCharArray();
        
        int cnt = 0;
        
        for (char val : arr) {
            for (char chk : chks) {
                if (val == chk) {
                    cnt++;
                }
            }
        }
        
        System.out.print(cnt);
        
    }
}