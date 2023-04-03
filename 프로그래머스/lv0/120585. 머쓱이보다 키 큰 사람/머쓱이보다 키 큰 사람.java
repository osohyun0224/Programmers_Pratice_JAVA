class Solution {
    public int solution(int[] array, int height) {
        int rst=0;
        for(int i=0;i<array.length; i++){
            if(array[i]>height){
                rst++;
            }
        }
        return rst;
    }
}