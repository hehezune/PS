import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        for (String name : participant) {
            if (participantMap.containsKey(name)) {
                participantMap.put(name, participantMap.get(name) + 1);
            } else {
                participantMap.put(name, 1);
            }
        }
        
        for (String name : completion) {
            int value = participantMap.get(name);
            if (value == 1) {
                participantMap.remove(name);
            } else {
                participantMap.put(name, value - 1);
            }
        }
        
        Object[] answer = participantMap.keySet().toArray();
        // System.out.println(answer[0]);
        return (String)answer[0];
    }
}