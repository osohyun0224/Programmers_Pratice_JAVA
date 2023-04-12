//가위는 2 바위는 0 보는 5
class Solution {
    public String solution(String rsp) {
        String answer = "";
        for(int i=0;i<rsp.length();i++){
            if(rsp.split("")[i].equals("0")){
                answer+="5";
            }
            else if(rsp.split("")[i].equals("2")){
                answer+="0";
            }
            else {
                answer+="2";
            }
        }
        return answer;
    }
}