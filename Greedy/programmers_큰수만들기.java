import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int length = number.length();
        int left = length - k - 1;
        int start = 0;
        
        while (left >= 0) {
            
            int max = -1;
            for (int i = start; i < length - left; ++i) {
                int num = number.charAt(i) - '0';
                if (max < num) {
                    max = num;
                    start = i + 1;
                }
            }
            
            sb.append(max);
            left--;
        }
        
        return sb.toString();
    }
}