import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = Integer.parseInt(br.readLine());

        outer:
        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.empty()) {
                        sb.append("NO").append("\n");
                        continue outer;
                    }
                    stack.pop();
                }
            }
            
            if (stack.empty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
            stack.clear();
        }
        
        System.out.println(sb.toString());
        br.close();
    }
}