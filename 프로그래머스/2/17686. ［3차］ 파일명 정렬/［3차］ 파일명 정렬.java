import java.util.*;

class Solution {
    // sort 사용 가능, 소문자로 or 대문자로 사용, substring 사용 가능
    int numberOfFiles = 0;
    public String[] solution(String[] files) {

        numberOfFiles = files.length;
        SeparatedFiles[] separatedFilesArray = new SeparatedFiles[numberOfFiles];
        
        for (int i = 0; i < numberOfFiles; i++) {
            String target = files[i];
            boolean numberStart = false;
            int number = 0;
            int headIdx = 0;
            
            for (int j = 0; j < target.length(); j++) {
                if (!numberStart && isNumber(target.charAt(j))) {
                    numberStart = true;
                    number = target.charAt(j) - '0';
                    headIdx = j;
                } else if (numberStart && !isNumber(target.charAt(j))) {
                    break;
                } else if (numberStart && isNumber(target.charAt(j))) {
                    number = number * 10 + target.charAt(j) - '0';
                }
            }
            
            SeparatedFiles file = new SeparatedFiles(target.substring(0, headIdx).toLowerCase(), number, i);
            separatedFilesArray[i] = file;
        }
        
        Arrays.sort(separatedFilesArray);
        String[] answer = new String[numberOfFiles];
        for (int i = 0; i < numberOfFiles; i++) {
            answer[i] = files[separatedFilesArray[i].idx];
        }
        return answer;
    }
    
    public boolean isNumber(char target) {
        if ('0' <= target && target <= '9') {
            return true;
        }
        return false;
    }

}
    class SeparatedFiles implements Comparable<SeparatedFiles>{
        String head;
        int number, idx;
        
        public SeparatedFiles(String head, int number, int idx) {
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
        
        public int compareTo(SeparatedFiles o) {
            if (o.head.equals(this.head)) {
                return this.number - o.number;
            } else {
                return this.head.compareTo(o.head);
            }
        }
    }