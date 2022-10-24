import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int value = -1;
        
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != value) {
                list.add(arr[i]);
                value = arr[i];
            }
        }

        int[] answer = new int[list.size()];
        int index = 0;
        for (int l : list) {
            answer[index++] = l;
        }
        
        return answer;
    }
}