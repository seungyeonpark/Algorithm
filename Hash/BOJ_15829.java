import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int prime = 1234567891;
        long sum = 0;
        long pow = 1;
        
        for (int i = 0; i < length; i++) {
            sum += ((word.charAt(i) - 'a' + 1) * pow) % prime;
            pow = (pow * 31) % prime;
        }
        
        System.out.println(sum % prime);
    }
}