import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (in.read() == '0') {
            System.out.print("YONSEI");
            return;
        }
        System.out.print("Leading the Way to the Future");
    }
}