import java.util.*;

class Solution {
    static int skillLength;
    static String skillTree;
    static boolean[] skillTreeType; // 스킬 담긴 카운트배열
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        skillTree = skill;
        skillTreeType = new boolean[27];
        
        for (int i = 0; i < skill.length(); i++) {
            skillTreeType[skill.charAt(i) - 'A'] = true;
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            if (!isWrightTree(skill_trees[i])) {
                continue;
            }
            answer++;
        }
        return answer;
    }
    
    public boolean isWrightTree(String skill) {
        int treeIdx = 0;
        for (int i = 0; i < skill.length(); i++) {
            char target = skill.charAt(i);
            if (!skillTreeType[target - 'A']) {
                continue;
            }
            if (skillTree.charAt(treeIdx) == skill.charAt(i)) {
                treeIdx++;
            } else {
                return false;
            }
        }
        return true;
    }
}