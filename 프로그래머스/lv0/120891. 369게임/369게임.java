class Solution {
    public int solution(int order) {
        int count = 0;
        while (order != 0) {
            if (order % 10 == 3 || order % 10 == 6 || order % 10 == 9) count++;
            order /= 10;
        }
        return count;
    }
}