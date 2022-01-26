import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static Integer[][] dp = new Integer[41][2];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());
        
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            fib(num);
            System.out.println(dp[num][0] + " " + dp[num][1]);
        }
    }
    
    public static Integer[] fib(int num) {
        if (dp[num][0] == null || dp[num][1] == null) {
            dp[num][0] = fib(num - 1)[0] + fib(num - 2)[0];
            dp[num][1] = fib(num - 1)[1] + fib(num - 2)[1];
        }
        
        return dp[num];
    }
}