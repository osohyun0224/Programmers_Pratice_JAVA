class Solution {
  public int[] solution(int money) {
      int num = money/5500;
      int[] answer = {num, money%5500 };
      return answer;
  }
}