import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int yang=numbers[0]*numbers[1];
        int umm=numbers[numbers.length - 1] * numbers[numbers.length - 2];
        if(yang>umm){
            answer=yang;
        }
        else if(umm>yang){
            answer=umm;
        }
        else {
            answer=yang;
        }
        return answer;
    }
}