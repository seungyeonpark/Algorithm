import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int max;
        
        String reverse = "";
        for (int i = s1.length() - 1; i >= 0 ; i--) {
            reverse += s1.charAt(i);
        }
        s1 = reverse;
        
        reverse = "";
        for (int i = s2.length() - 1; i >= 0 ; i--) {
            reverse += s2.charAt(i);
        }
        s2 = reverse;
        
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        max = n1 < n2 ? n2 : n1;
        
        System.out.println(max);
	} 
}