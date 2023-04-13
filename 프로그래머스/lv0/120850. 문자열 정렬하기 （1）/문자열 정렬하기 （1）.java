import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String[] arr = my_string.replaceAll("[^0-9]", "").split("");
		
		Arrays.sort(arr);
		
		int[] answer = new int[arr.length];
		
		for (int i = 0; i < answer.length; i++) {
				answer[i] = Integer.parseInt(arr[i]);
  }
        return answer;
    }
}
