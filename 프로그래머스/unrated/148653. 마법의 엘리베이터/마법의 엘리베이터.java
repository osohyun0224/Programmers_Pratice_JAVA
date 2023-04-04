/*일단 써보는 알고리즘 -너비우선탐색*/
/*일의 자리 수부터 반올림 대상 숫자이면6이상, 앞자리에 1더하고 / 내림 대상 숫자4이하이면, 걍 버리기
5가 문제인데.. 
1) 일의 자리만 5라면 걍 올리기
2) 십의 자리까지 5라면 (1) 5이상 올리기 (2) 5미만일때 내리기 
*/
import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            //현재 층수를 10으로 나눈 나머지를 우선 n에 저장해야한다.
            int n = storey % 10;
            //n을 가지고 가장 문제가 되는 5보다 클때(반올림) / 5일때 / 5보다 작을때(버림)의 경우를 나눈다.
            //반올림의 계산
            if(n > 5) {
                answer += 10 -n;
                storey /= 10;
                storey += 1;
            }
            //5일때는 
            //1) 일의 자리만 5라면 걍 올리기
            //2) 십의 자리까지 5라면 (1) 5이상 올리기 (2) 5미만일때 내리기 
            else if(n == 5) {
                int ex = (storey/10) % 10;                                                      
                    if(ex >= 5) {
                        //(1) 5이상 올리기
                        storey /=10;
                        storey += 1;
                    }
                    // (2) 5미만일때 내리기
                    else {
                        storey /= 10;
                    }
                    answer+=5;
        }
        //간단하게 버린다.
        else {
            answer += n;
            storey /= 10;
        }
    }
    
    return answer;
    }
}