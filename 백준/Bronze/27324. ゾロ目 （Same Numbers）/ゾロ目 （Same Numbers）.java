import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in.readLine().toCharArray();
        if (arr[0] == arr[1]) {
            System.out.print(1);
            return;
        }
        System.out.print(0);
    }
}