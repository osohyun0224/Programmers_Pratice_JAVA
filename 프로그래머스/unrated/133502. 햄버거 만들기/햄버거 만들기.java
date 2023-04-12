/* 일단 그냥 써보는 알고리즘 
1) 들어오는 배열에 비교해서 1231 뺄 수 있는지 확인하고 해당 수 카운트
2) 빼고 나서 남은 배열을 저장
3) 2번 배열에 1231 뺄 수 있는지 확인하고 해당 수 카운트
4) 카운트 값 answer에 리턴
*/
class Solution {
    public int solution(int[] ingredient) {
		int answer = 0;
        int count = 0;
		StringBuilder istr = new StringBuilder();
        //들어오는 배열을 처음부터 비교한다. 
		for (int i = 0; i < ingredient.length; i++) {
            //stringbuffer로 선언된 istr 배열에 들어오는 문자열을 추가한다.
			istr.append(ingredient[i]);
            //햄버거를 만들려면 최소한 4개는 있어야하고, 햄버거를 2개 이상 만들때부터 전체길이에서 빼주어야 다음 햄버거를 만들 수 있다.
			if (istr.length()>3 && istr.subSequence(istr.length()-4, istr.length()).equals("1231")) {
                istr.delete(istr.length()-4, istr.length());
				count++;
			}
            //카운트 answer에 저장
            answer=count;
		}
        return answer;
    }
} 