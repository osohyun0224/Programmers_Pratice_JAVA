// 주석은 모두 알고리즘 - JAVA
import java.util.*;
// 1 일단 1->2 /2->3을 검사하고, 다 넣어둔 다음에 (1,2)랑 (2,3)이 같을 경우를 대비해서 임시로저장할 새로운 배열 생성 필요할 것 같음
public class Solution {
public int[] solution(int []arr) {
/*첫 번째 검사 후 동일한 값들을 저장한 배열 생성 */
int[] sounii = new int[arr.length];
//2 배열의 처음부터 차근차근 하나씩 비교해 다르면, ㄱㄱ 같으면, 저장해야할 것 같다.
//테스트케이스 해보니까 sounii 인덱스 번호 따로 지정해야됨
int s = 0;
for (int i = 0; i < arr.length -1; i++) {
//3 주의할 점이 다르면 옆으로 계속 가야하니까 같은거 말고 다를때를 넣어주자
if(arr[i] != arr[i+1]) {
sounii[s++] = arr[i];
}
}//4 배열의 끝까지 계속 가야돼
sounii[s++]=arr[arr.length -1];
/*최종 배열을 리턴할 배열 answer 생성 */
//sounii 배열의 길이인줄 알았는데 테스트 케이스해보니까 처음의 길이에 다들어감index변수를 넣어야 했음
int[] answer = new int[s];
//5 조건으로 걸러진 sounii 배열에 저장된 것을 최종 answer에 저장해줌.
for (int i = 0; i < s; i++) {
answer[i] = sounii[i];
}
return answer;
}
}