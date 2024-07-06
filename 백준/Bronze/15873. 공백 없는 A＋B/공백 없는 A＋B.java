import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] input = in.readLine().toCharArray();
        int size = input.length;
        
        if (size == 3) {
            if (input[1] == '0') {
                System.out.print(10 + (input[2] - '0'));
            } else if (input[2] == '0') {
                System.out.print(10 + (input[0] - '0'));
            }         
        } else if (size == 4) {
            System.out.print(20);
        } else {
            System.out.print((input[0] - '0') + (input[1] - '0'));
        }
    }
}