import java.util.stream.Stream;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[][] sizes) {
        int answer= 0;
        int max= 0;
        int min = 0;

        int[] Array = Stream.of(sizes).
       flatMapToInt(IntStream::of).toArray();
        
    for(int i = 0; i < Array.length; i+=2) {
        if(Array[i]>=Array[i+1]) {
            if(Array[i]>max){
                max = Array[i];
            } 
            if(Array[i+1]>=min){
                min = Array[i+1];
            }
        }
        else{
            int temp = Array[i];
            Array[i]=Array[i+1];
            Array[i+1]=temp;
            if(Array[i+1]>=min){
                min= Array[i+1];
            }
            if(Array[i]>max) {
                max = Array[i];
            }
        }
    }
    answer = max*min;
    return answer;
    }
}