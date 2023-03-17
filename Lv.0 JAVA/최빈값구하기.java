class Solution {
  public int solution(int[] array) {
      int[] countArray = new int[1001];
      for (int i = 0; i < array.length; i++) {
          countArray[array[i]]++;
      }

      int max = 0;
      int answer = 0;
      for (int i = 0; i < countArray.length; i++) {
          if (countArray[i] > max) {
              max = countArray[i];
              answer = i;
          }
      }

      int maxCount = 0;
      for (int i = 0; i < countArray.length; i++) {
          if (countArray[i] == max) maxCount++;
          if (maxCount > 1) return -1;
      }
      return answer;
  }
}