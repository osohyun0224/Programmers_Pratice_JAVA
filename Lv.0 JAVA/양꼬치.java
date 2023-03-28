class Solution {
  public int solution(int n, int k) {
      int answer = 0;
      int yang= 12000*n;
      if( n>=10){
          int s=n/10;
          k=k-s;
      }
      int drink=2000*k;
      answer=yang+drink;
      return answer;
  }
}