import java.util.Scanner;

public class Main {
    public static void main(String srags[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] coins = new int[n];
        
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int cnt = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            cnt += k / coins[i];
            k %= coins[i];
        }
        
        System.out.println(cnt);
    }
}