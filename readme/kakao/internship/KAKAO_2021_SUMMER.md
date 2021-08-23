# KAKAO 2021 SUMMER

## 문제1: 숫자 문자열과 영단어

문자열안에 숫자 영어단어를 숫자로 바꾸는 문제

~~~java
    return s.replaceAll("zero", "0")
            .replaceAll("one", "1")
            .replaceAll("two", "2")
            .replaceAll("three","3")
            .replaceAll("four", "4")
            .replaceAll("five", "5")
            .replaceAll("six", "6")
            .replaceAll("seven", "7")
            .replaceAll("eight", "8")
            .replaceAll("nine", "9");
~~~

## 문제2: 거리두기 확인하기

실제 코테에서 '모든' 시간을 쓴 문제 였지만 해결하지 못한 문제

5 X 5의 대기실의 거리두기가 잘 지켜졌는지 확인 하는 문제

~~~
두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면,  
T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2|
~~~
P(사람) 좌표리스트를 구한 후

P(사람) 좌표리스트중에서 거리두기 체크를 하는 방식으로 해결
```java
    int[] answer = {0, 0, 0, 0, 0};
    int index = 0;
    for (String[] str : places) {
        /*
        * P(사람)의 좌표 리스트 생성
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
```

맨해튼 거리 함수
~~~java
    int getDist(Point p1, Point p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }
~~~

거리두기 확인하는 메소드 isOk()
~~~java
    boolean isOk(List<Point> pointList, String[] str) {
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
~~~

### 막혔던 부분
~~~java
    // 틀림
    if (!str[pLocation.get(i).getX()].substring(x1, x2).contains("X"))
~~~
~~~java
    // 정답
    if (!str[pointList.get(i).getY()].substring(x1, x2).contains("X"))
~~~

코테가 끝난 후   
다시 프로그래머스에 문제가 올라와 제일 먼저 풀어 봤는데  
y 좌표가 같은 경우에 거리두기 체크하는 부분이 틀린 것으로 확인 되었다.  
getX()를 하는 것이 아닌 getY()를 통해서 배열의 인덱스에 접근해야 했는데  
처음보는 코테인지 이런 부분을 놓친거 같다..

두번째 대기실에서 
~~~
"POOPX"
"OXPXP"
"PXXXO"
"OXXXO"
"OOOPP"
~~~
마지막행에 PP y 좌표가 같은 경우가 있었지만  
(0,0) 과 (2,0)를 체크하고 - 체크못해서 통과   
(0,0) 과 (0,2)를 체크 할 때 x 좌표가 같을 때 거리두기가 안지켜져서  
(4,3) 과 (4,4)는 체크하지 않은거 같다.  

~~~
(0,0), (2,0): isOk() -> true로 다음 for문
(0,0), (0,2): isOk() -> false로 break
(4,3), (4,4): 미체크
~~~
  
2.5컷이라고 봣는데  
2번 점수 반 이상 나왔을 때 3번으로 넘어갔으면 하는 아쉬움.. ㅠㅠ

## 문제3: 표 편집
'복구' 라는 단어를 보고   
Stack 자료구조에 삭제 처리된 인덱스를 저장한 후  
모든 커멘드 종료시에도 Stack 자료구조에 데이터가 있다면 이 데이터를 인덱스로 잡고 "X"로 출력
~~~java
    Stack<Integer> backup = new Stack<>();
~~~
~~~java
    for(String str : cmd) {
        // D 아래로 이동
        if(str.charAt(0) == 'D') {
            select += Integer.parseInt(str.substring(2));
        }
        // U 위로 이동
        else if(str.charAt(0) == 'U') {
            select -= Integer.parseInt(str.substring(2));
        }
        // C 삭제
        else if(str.equals("C")) {
            backup.push(select);
            select = (select == curLen - 1) ? select - 1 : select;
            curLen -= 1;
        }
        // Z 복구 =
        else if(str.equals("Z")) {
            int backupIndex = backup.pop();
            select = (select >= backupIndex) ? select + 1 : select;
            curLen += 1;
        }
    }
~~~
~~~java
    StringBuilder answer = new StringBuilder();
    for(int i = 0; i < curLen; i++) answer.append("O");

    while(!backup.isEmpty()) {
        int backupIndex = backup.pop();
        answer.insert(backupIndex, "X");
    }
~~~

## 문제4: 미로 탈출
다익스트라 알고리즘을 사용해서 풀어 보는 중 
