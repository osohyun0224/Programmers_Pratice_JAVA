import java.util.*;
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String[] str = new String[my_string.length()];
        str= my_string.split("");
        for(int i =0; i<my_string.length();i++){
            answer += str[i].repeat(n);
        }
        return answer;
    }
}