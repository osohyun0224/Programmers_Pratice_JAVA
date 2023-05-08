class Solution {
    public int[] solution(int[] sec, int k) {        

    	int le = 0;
    	int ri = 0;
    	int sum = 0;
    	int size = sec.length;
    	int ans1 = 0;
    	int ans2 = 0;
    	
    	for(ri=0; ri<sec.length; ri++) {    		
    		sum += sec[ri];
    		
    		while(sum > k) {
    			sum -= sec[le];
    			le++;
    		}
    		
    		if(sum == k) {
    			if(size > ri-le) {
    				size = ri-le;
    				ans1 = le;
    				ans2 = ri;
    			}
    			else if(size == ri-le) {
    				ans1 = Math.min(ans1, le);
    				ans2 = Math.min(ans2, ri);
    			}
    		}
    	}
    	return new int[] {ans1, ans2};
    }
}