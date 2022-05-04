import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int[] ary = new int[26];
        for (int i = 0; i < 26; i++) {
            ary[i] = -1;
        }
        
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i);
            if (ary[n - 97] == -1) {
                ary[n - 97] = i;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            System.out.print(ary[i] + " ");
        }
	}
}