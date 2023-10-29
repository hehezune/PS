import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        // 원래대로 사람은 하나의 숫자만 말하는 대신에
        // 인원이 다하면 순환하는거고
        // t번의 사이클에 대한 답을 저장해야 하는 것ㅛㅅㄱㄷㄱ 
        StringBuilder answer = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        int number = 0;
        int count = 0;
        int goal = t * m;
        while (count < goal) {
            // 몇번째 숫자인지 계산해서 거기만? 다 계산해놓고 charAt으로 뽑아오기?
            String convertedNumber = Integer.toString(number++, n);
            sentence.append(convertedNumber);
            count += convertedNumber.length();
        }
        
        count = 0;
        while (count < t) {
            answer.append(sentence.charAt(m * count++ + p - 1));
        }
        
        return answer.toString().toUpperCase();
    } 
}