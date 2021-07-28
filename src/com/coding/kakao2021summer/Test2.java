package com.coding.kakao2021summer;

import java.util.*;
class Point {
    private int x;
    private int y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Test2 {
    public static int[] solution(String[][] places) {
        int[] answer = {0, 0, 0, 0, 0};
        int index = 0;
        for (String[] str : places) {
            /*
            * P (사람)좌표 리스트 생성
            * List<Point> pLocation
            * */
            List<Point> pLocation = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                for (int k = 0; k < str[i].length(); k++) {
                    if (str[i].charAt(k) == 'P') {
                        pLocation.add(new Point(k, i));
                    }
                }
            }

            /*
            * 2개 이하면 무조권 통과
            * */
            if (pLocation.size() < 2) {
                answer[index++] = 1;
                continue;
            }

            /*
            * 거리두기 확인
            * */
            if (isOk(pLocation, str))
                answer[index] = 1;
            index++;
        }
        return answer;
    }

    private static boolean isOk(List<Point> pointList, String[] str) {
        for (int i = 0; i < pointList.size(); i++) {
            for (int k = i + 1; k < pointList.size(); k++) {
                /*
                *  거리 계산
                * */
                int dist = getDist(pointList.get(i), pointList.get(k));
                if (dist <= 2) {
                    /*
                    * x 좌표가 같은 경우
                    * {P,X,X,X,X}
                    * {?,X,X,X,X}
                    * {P,X,X,X,X}
                    * ...
                    * */
                    if (pointList.get(i).getX() == pointList.get(k).getX()) {
                        StringBuilder yRoom = new StringBuilder();
                        for (int s = 0; s < 5; s++) {
                            yRoom.append(str[s].charAt(pointList.get(i).getX()));
                        }
                        int y1 = pointList.get(i).getY();
                        int y2 = pointList.get(k).getY();
                        if (!yRoom.substring(y1, y2).contains("X")) {
                            return false;
                        }

                    }
                    /*
                     * y 좌표가 같은 경우
                     * {P,?,P,X,X}
                     * {X,X,X,X,X}
                     * {X,X,X,X,X}
                     * ...
                     * */
                    else if (pointList.get(i).getY() == pointList.get(k).getY()) {
                        int x1 = pointList.get(i).getX();
                        int x2 = pointList.get(k).getX();
                        if (!str[pointList.get(i).getY()].substring(x1, x2).contains("X")) {
                            return false;
                        }
                    }
                    /*
                     * 대각석
                     * {P,?,X,X,X}
                     * {?,P,X,X,X}
                     * {X,X,X,X,X}
                     * ...
                     * */
                    else {
                        Point p1 = new Point(pointList.get(i).getX(), pointList.get(k).getY());
                        Point p2 = new Point(pointList.get(k).getX(), pointList.get(i).getY());
                        if (!(str[p1.getY()].charAt(p1.getX()) == 'X'
                                && str[p2.getY()].charAt(p2.getX()) == 'X')) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /*
    * 예전 풀이
    * */
    public static int[] solution2(String[][] places) {
        int[] answer = { 0, 0, 0, 0, 0 };

        int a = 0;
        for (String[] str : places) {
            List<Point> pLocation = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                for (int k = 0; k < str[i].length(); k++) {
                    if (str[i].charAt(k) == 'P') {
                        pLocation.add(new Point(k, i));
                    }
                }
            }

            if (pLocation.size() < 2) {
                answer[a++] = 1;
                continue;
            }

            int err = 0;
            for (int i = 0; i < pLocation.size(); i++) {
                for (int k = i + 1; k < pLocation.size(); k++) {
                    int dist = getDist(pLocation.get(i), pLocation.get(k));
                    if (dist <= 2) {
                        // x
                        if (pLocation.get(i).getX() == pLocation.get(k).getX()) {
                            String yRoom = "";
                            for (int s = 0; s < 5; s++) {
                                yRoom += str[s].charAt(pLocation.get(i).getX());
                            }
                            int y1 = pLocation.get(i).getY();
                            int y2 = pLocation.get(k).getY();
                            if (!yRoom.substring(y1, y2).contains("X")) {
                                err++;
                                break;
                            }

                        }
                        // y

                        else if (pLocation.get(i).getY() == pLocation.get(k).getY()) {
                            int x1 = pLocation.get(i).getX();
                            int x2 = pLocation.get(k).getX();
                            // (!str[pointList.get(i).getY()].substring(x1, x2).contains("X"))
                            if (!str[pLocation.get(i).getX()].substring(x1, x2).contains("X")) {
                                err++;
                                break;
                            }
                        }
                        // 대각선
                        else {
                            Point p1 = new Point(pLocation.get(i).getX(), pLocation.get(k).getY());
                            Point p2 = new Point(pLocation.get(k).getX(), pLocation.get(i).getY());
                            if (!(str[p1.getY()].charAt(p1.getX()) == 'X' && str[p2.getY()].charAt(p2.getX()) == 'X')) {
                                err++;
                                break;
                            }
                        }
                    }
                }
            }

            if (err == 0)
                answer[a] = 1;
            a++;
        }
        return answer;
    }

    private static int getDist(Point p1, Point p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    public static void main(String[] args) {

        String[][] str1 = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        String[][] str2 = {
                {
                    "XXPOP",
                    "XXXXX",
                    "XXXXX",
                    "XXXXX",
                    "XXXXX"
                }
        };
        String answer1 = Arrays.toString(solution(str1));
        String answer2 = Arrays.toString(solution(str2));
        String answer2_2 = Arrays.toString(solution2(str2));

        System.out.println("myAnswer1: " + answer1);
        System.out.println("myAnswer1 equals: " + answer1.equals("[1, 0, 1, 1, 1]"));

        System.out.println("============================");
        System.out.println("myAnswer2: " + answer2);
        System.out.println("myAnswer2 equals: " + answer2.equals("[0, 0, 0, 0, 0]"));

        System.out.println("---------------------------");
        System.out.println("myAnswer2_2: " + answer2_2);
        System.out.println("myAnswer2_2 equals: " + answer2_2.equals("[0, 0, 0, 0, 0]"));

    }

}
