/*그냥 써보는 알고리즘*/
//1) 최대한 먼 곳을 가는게 맞는데, 마지막 집에 배달할 게 없을 수도 있으니까 처음에 갈 곳을 구하기
/*1-1) 일단 들어오는 배달에서 최대한 먼 곳을 찾자
  1-2) 들어오는 픽업에서 최대한 먼 곳을 찾아야 한다.*/
//2) 배달하기
/*2-1) 배달할 때, 가지고 온 갯수랑 배달할 곳 개수를 보면서 상자의 개수를 
  2-2) 갖고 있는 거랑 놓을게 같으면 다시 창고를 가야하니까 이것도 잡아서 구해줘야해.*/
//3) 픽업하기
/*3-1) 픽업할 때, 배달하고 남은거가 있으면 픽업할 곳 개수 비교해서 상자를 더해줘야해
  3-2) 픽업을 해야하는데 이미 트럭에 max로 있으면 다시 창고가야하니까 이것도 잡아서 구해줘야해.*/
//4) 택배 업무 종료하고 최종 움직인 거리를 리턴해주기
/*4-1) 이 반복이 종료되려면 테스트케이스에서 표가 다 0이 되어야하니까 이때를 조건으로 잡고
  4-2) 4-1의 이동거리를 구해준다. 테스트케이스 분석할때 최종이 배달의 두배라서 배달의 2배를 리턴하면 될 것 같아요.*/

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // 들어오는 픽업에서 가장 먼 곳을 찾아야하기 때문에 첫 번째로 배달/픽업 집을 찾아야한다.
        int lastdeliever= -1;
        int lastpickup  = -1;

        // 1-1  배달 주소 찾기 
        for(int i = n - 1; i >= 0; i--) {
            if(deliveries[i] != 0) {
                lastdeliever = i;
                break;
            }
        }

        // 1-2  픽업 주소 찾기 
        for(int i = n - 1; i >= 0; i--) {
            if(pickups[i] != 0) {
                lastpickup = i;
                break;
            }
        }

        long answer = 0;
        
        // 4-1 이걸 전체 while문으로 배달과 픽업이 없을 때까지 작업을 진행하기
        while(lastdeliever != -1 || lastpickup != -1) {
            // 4-2 우리가 최종적으로 구해야 할 최종 거리를 구해야한다. 배달의 2배
            answer += (long) (Math.max(lastdeliever + 1, lastpickup + 1) * 2);

            // 2 배달하는 것 부터 구하자
            // 배달하는 모든 합계
            int dsum = 0;
            for(int dp = lastdeliever; dp >= 0; dp--) {
                int delivery = deliveries[dp];
                // 2-1,2를 구현하기 위해서 전체 배달 해야하는 최대 배달cap을 넘기 직전까지의 트럭 위치 
                if(delivery + dsum > cap) {
                    lastdeliever = dp;
                    // 남은 부분 배달의 상자의 수를 줄인다.
                    deliveries[dp] -= cap - dsum;
                    break;
                    
                } else if(dp == 0) {
                    lastdeliever = -1;
                }
                dsum += delivery;
            }

            // 3 픽업하는 것 구하자
            // 수거해야하는 상자 모든 합계
            int psum = 0;

            for(int pp = lastpickup;  pp >= 0;  pp--) {
                int pickup = pickups[pp];
                // 3-1,2를 구현하기 위해서 전체 배달 해야하는 최대 배달cap을 넘기 직전까지의 트럭 위치 
                if(pickup + psum > cap) {
                    lastpickup =pp;
                    // 남은 부분 수거해야하는 상자의 수를 줄인다.
                    pickups[pp] -= cap - psum;
                    break;
                } else if(pp == 0) {
                    lastpickup = -1;
                }
                psum += pickup;
            }
        }

        return answer;
    }
}
