import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        System.out.println(recur(num));
    }
    
    public static int recur(int n) {
        if (n <= 1) {
            return 1;
        }
        
        return n * recur(n - 1);
    }
}