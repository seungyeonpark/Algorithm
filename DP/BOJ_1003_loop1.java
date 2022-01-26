import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int[] memo;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
            	System.out.println(1 + " " + 0);
            } else if (num == 1) {
            	System.out.println(0 + " " + 1);
            } else {
                memo = new int[num + 1];
                System.out.printf("%d %d%n", countNum(0, num), countNum(1, num));
            }
        }
    }
    
    public static int countNum(int target, int num) {
    	int nonTarget = target == 0 ? 1 : 0;
    	
    	memo[nonTarget] = 0;
        memo[target] = 1;
        
        for (int i = 2; i <= num; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        
        return memo[num];
    }
}