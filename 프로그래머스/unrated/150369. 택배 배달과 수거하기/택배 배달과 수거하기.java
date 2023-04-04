
import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d_d=0;
        int p_d=0; 
        int return_d=cap;
        
        for(int i=n-1; i>=0; i--){
            if(deliveries[i]!=0){
                d_d=i+1;
                break;
            }
        }    
        for(int i=n-1; i>=0; i--){
            if(pickups[i]!=0){
                p_d=i+1;
                break;
            }
        }
        
        while(true){
            if(p_d==0&&d_d==0){
            break;
        }
        answer +=(Math.max(d_d,p_d))*2;
        while(true){
            if(p_d==0||cap==0&&deliveries[d_d-1]!=0){
                break;
            }
            if(cap>=deliveries[d_d-1]){
                cap-=deliveries[d_d-1];
                deliveries[d_d-1]=0;
                d_d--;
            }
            else{
                deliveries[d_d-1]-=cap;
                cap=0;
            }
//2-2) 갖고 있는 거랑 놓을게 같으면 다시 창고를 가야하니까 이것도 잡아서 구해줘야해.
            if(d_d==0){
                break;
            }
            if(cap==0&&deliveries[d_d-1]==0){
                d_d--;
            }
        }
        cap=return_d;


        while(true){
            if(p_d==0 || cap==0&&pickups[p_d-1]!=0 ){
                break;
            }
            if(cap>=pickups[p_d-1]){
                cap-=pickups[p_d-1];
                pickups[p_d-1]=0;
                p_d--;
            }
//2-2) 갖고 있는 거랑 놓을게 같으면 다시 창고를 가야하니까 이것도 잡아서 구해줘야해.
            else{
                pickups[p_d-1]-=cap;
                cap=0;
            }
        
            if(p_d==0){
                break;
            }
            if(cap==0 && pickups[p_d-1]==0){
                p_d--;
            }
        }
        cap=return_d;
}
        return answer;
    }
}