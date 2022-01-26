import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int[] memo;
    public static int zero;
    public static int one;
    public static int zeroPlusOne;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            countNum(num);
            System.out.println(zero + " " + one);
        }
    }
    
    public static void countNum(int num) {
        zero = 1;
        one = 0;
        zeroPlusOne = 1;
        
        for (int i = 1; i <= num; i++) {
            zero = one;
            one = zeroPlusOne;
            zeroPlusOne = zero + one;
        }
    }
}