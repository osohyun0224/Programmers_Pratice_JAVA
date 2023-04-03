//문자열 뒤집는 문제는 진짜 많이 나오니까 그냥 외우기
// StringBuffer랑 reverse함수 써서 뒤집는거 연습하기!
class Solution {
  public String solution(String my_string) {
      StringBuffer sb = new StringBuffer(my_string);
      my_string = sb.reverse().toString();
      String answer = my_string;
      return answer;
  }
}