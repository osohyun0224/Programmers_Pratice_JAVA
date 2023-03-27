import java.util.*;

class Solution {
    private static int max = -1;
    private int getMaxPriority(int[] count) {
        if (max == -1) {
            for (int i = 9; i >= 1; i--) {
                if (count[i] != 0) {
                    max = i;
                    return max;
                }
            }
        }
        return max;
    }
    public int solution(int[] priorities, int location) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] count = new int[10];
        for (int i = 0; i < priorities.length; i++) {
            count[priorities[i]]++;
            dq.addLast(priorities[i]);
        }
        int answer = 0;
        while (!dq.isEmpty()) {
            int current = dq.pollFirst();
            int maxPriority = getMaxPriority(count);
            if (current != maxPriority) {
                dq.addLast(current);
            } else {
                answer++;
                if (location == 0)
                    break;
                if (--count[current] == 0)
                    max = -1;
            }
            if (--location == -1)
                location = dq.size()-1;
        }

        return answer;
    }
}