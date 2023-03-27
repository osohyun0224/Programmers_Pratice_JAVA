import java.util.*;
class Solution {
    public int solution(int num) {
        int answer = 0;
        ArrayList<Integer> number = new ArrayList<>();
        while (num > 0) {
            number.add(num % 3);
            num = num / 3;
        }
        for (int i = number.size()-1; i >= 0; --i) 
            answer += number.get(i) * Math.pow(3, number.size()-1-i);
        return answer;
    }
}