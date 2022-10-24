import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> days = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; ++i) {
            int day = 0;
            if ((100 - progresses[i]) % speeds[i] == 0) {
                day = (100 - progresses[i]) / speeds[i];
            } else {
                day = (100 - progresses[i]) / speeds[i] + 1;
            }
            days.add(day);
        }
        
        int before = days.get(0);
        int cnt = 0;
        for (int d : days) {
            if (d <= before) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                before = d;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (int l : list) {
            answer[index++] = l;
        }
        return answer;
    }
}