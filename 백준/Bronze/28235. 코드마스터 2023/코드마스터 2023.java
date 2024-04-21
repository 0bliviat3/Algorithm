import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        
        /*
        구호 SONGDO에 대해 HIGHSCHOOL로 응원.
        구호 CODE에 대해 MASTER로 응원.
        구호 2023에 대해 0611로 응원.
        구호 ALGORITHM에 대해 CONTEST로 응원.
        */
        switch (input) {
            case "SONGDO" :
                System.out.print("HIGHSCHOOL");
                break;
            case "CODE" :
                System.out.print("MASTER");
                break;
            case "2023" :
                System.out.print("0611");
                break;
            case "ALGORITHM" :
                System.out.print("CONTEST");
                break;
            default :
                break;
        }
        
        
    }
}