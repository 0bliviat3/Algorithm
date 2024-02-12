import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        char[] wordArr = in.readLine().toCharArray();
        for(char piece : wordArr) {
            if(piece > 'Z') {
                ans.append((char) (piece - 'a' + 'A'));
            }else {
                ans.append((char) (piece - 'A' + 'a'));
            }
        }
        System.out.print(ans);
    }    
}

