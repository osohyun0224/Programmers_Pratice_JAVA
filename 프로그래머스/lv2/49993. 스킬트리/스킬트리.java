class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String cur : skill_trees) {
            cur = cur.replaceAll("[^"+skill+"]", "");	//정규식으로 제거
            answer += skill.indexOf(cur)==0 ? 1 : 0;
        }
        return answer;
    }
}