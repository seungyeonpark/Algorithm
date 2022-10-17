import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashSet<String> phoneNum = new HashSet<>();
        
        for (String p : phone_book) {
            phoneNum.add(p);
        }
        
        for (int i = 0; i < phone_book.length; ++i) {
            for (int j = phone_book[i].length() - 1; j >= 0; --j) {
                if (phoneNum.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}