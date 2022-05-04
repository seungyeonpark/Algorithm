import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] ary = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i);
            if (97 <= n && n <= 122) {
                n -= 32;
            }
            ary[n - 65]++;
        }
        
        int max = -1;
        char maxChar = ' ';
        for (int i = 0; i < 26; i++) {
            if (max < ary[i]) {
                max = ary[i];
                maxChar = (char)(i + 65);
            } else if (max == ary[i]) {
                maxChar = '?';
            }
        }
        System.out.println(maxChar);
	}
}