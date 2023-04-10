import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        Double sqrt = Math.sqrt(n);
        if(sqrt == sqrt.intValue()) {
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }
}