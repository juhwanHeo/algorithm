package com.coding.level2;

/*
 * @level2
 * @TestName: 스킬 트리
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/49993
 */
public class SkillTrees {

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < skillTree.toCharArray().length; i++) {
                char c = skillTree.charAt(i);
                if (skill.contains(String.valueOf(c))) sb.append(skillTree.charAt(i));
            }


            if (skill.indexOf(sb.toString()) == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {
                "BACDE", // x
                "CBADF", // o
                "AECB",  // o
                "BDA"    // x
                // 2
        };

        System.out.println(solution(skill, skill_trees));

    }
}
