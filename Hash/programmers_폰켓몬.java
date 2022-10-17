import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int answer = 0;
        HashSet<Integer> mon = new HashSet<>();
        
        for(int n : nums) {
            mon.add(n);
        }
        
        if (mon.size() < nums.length / 2) {
            answer = mon.size();
        } else {
            answer = nums.length / 2;
        }
        
        return answer;
    }
}
