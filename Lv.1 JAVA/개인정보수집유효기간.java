import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayDayCounts = getDays(today);
        
        Map<String, String> termMap = new HashMap<>();

        for (String term : terms) {
            String[] words = term.split(" ");
            String alp = words[0];
            String mon = words[1];
            termMap.put(alp, mon);
        }

        List<Integer> dyList = new ArrayList<>();

        int idx = 1;

        for (String privacy : privacies) {
            String[] words = privacy.split(" ");
            String date = words[0];
            String alp = words[1];
            int monLimit = Integer.parseInt(termMap.get(alp));

            int limitDayDayCount = getDays(date) + getDays(monLimit);
            if (todayDayCounts >= limitDayDayCount) {
                dyList.add(idx);
            }
            idx++;
        }
        int[] answer = new int[dyList.size()];
        for (int i = 0; i < dyList.size(); i++) {
            answer[i] = dyList.get(i);
        }
        return answer;
    }

    private int getDays(String StrOfDate) {
        String[] todayWords = StrOfDate.split("\\.");
        int y = Integer.parseInt(todayWords[0]);
        int m = Integer.parseInt(todayWords[1]);
        int d = Integer.parseInt(todayWords[2]);
        return (y*(12*28)) + (m*28) + d;
    }

    private int getDays(int mon) {
        return (mon*28);
    }
}