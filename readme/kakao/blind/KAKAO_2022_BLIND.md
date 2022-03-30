# KAKAO 2022 BLIND

1, 2, 3, 6(0.5) 번을 풀고  
문제가 이해 가지 않는 4번을 보지 않고  
바로 5번 (양과 늑대) 문제를 풀었다면 1차 테스트에 통과했을까? 라는 생각을한다.

정답: `3.5` / 7 (문제)  
컷: `4 ~ 4.5` (문제)  
체감난이도: 어려웠다. 다 풀이하신 분들보면 존경의 눈빛 (+ - +)  
  
이번 테스트에서는 `맵(자료구조)`을 사용하는 문제와 `완전탐색`하는 문제들이 많이 출제 되었다.   
나는 완전 탐색문제에 많이 취약한 것 같다.
  
카카오 코딩 테스트 매번 시험보면서 내가 알고리즘 적으로 성장하고 있다는 것을 느끼고 있다. (뿌듯)  
다음 여름인턴 코딩테스트(진행 할려나?? 안하면 2023 BLIND)도 시험보고 몇문제를 풀 수 있는지 얼마만의 시간에 푸는지 등을 확인할 것이다.

## 문제1: 신고 결과 받기 (해결)
맵 자료구조를 사용하여 문제 풀이

1번부터 효울성 테스트가 나와서 시간을 보냈다.

처음에 `userList`를 `ArrayList`로 구현해서 효율성에서 탈락을 당했던 기억이 있다.  
그래서 `PriorityQueue`로 변경해서 효율성을 해결

### User 클래스 정의 후 
```java
class User implements Comparable<User>{
    String singo;
    String baned;

    public User(String singo, String baned) {
        this.singo = singo;
        this.baned = baned;
    }

    @Override
    public String toString() {
        return "User{" +
                "singo=" + singo +
                ", baned=" + baned +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return singo.compareTo(o.singo);
    }
}
```

```java
public static int[] solution(String[] id_list, String[] report, int k) {
    Map<String, Set<String>> map = new HashMap<>();
    Map<String, Integer> banMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    PriorityQueue<User> userList = new PriorityQueue<>();
    for (String s : report) {
        String[] split = s.split(" ");
        userList.add(new User(split[0], split[1]));
    }

    for (String id : Arrays.stream(id_list).sorted().map(String::valueOf).toArray(String[]::new)) {
        Set<String> singo = new HashSet<>();

        while(!userList.isEmpty()) {
            User user =  userList.peek();
            if(!id.equals(user.singo)) break;
            
            userList.remove(user);
            if (!singo.contains(user.baned)) {
                userList.remove(user);
                banMap.put(user.baned, banMap.getOrDefault(user.baned, 0) + 1);
            }
            singo.add(user.baned);
        }
        map.put(id, singo);
    }
    
    /*
    *  유저별 신고 결과 메일을 받은 횟수 
    */
    for (String key : id_list) {
        Set<String> set = map.get(key);
        int cnt = 0;
        for (String id : set) {
            if (banMap.get(id) >= k) cnt ++;
        }

        list.add(cnt);
    }

    return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
}
```

## 문제2: k진수에서 소수 개수 구하기 (해결)
단순 구현

### 소수인지 판별하는 메소드
```java
public boolean isPrime(long number) {
    if(number < 2) return false;
    if(number == 2) return true;
    for(int i = 2; i <= (int) Math.sqrt(number); i++) {
        if(number % i == 0)  return false;
    }
    return true;
}
```
k 진수로 변환 해서   
0의 개수가 1개 이상 연속 되는 문자열을 0으로 대치하고  
0을 기준으로 split 하여     
소수가 몇개 인지 판별
```java
public int solution(int n, int k) {
    int answer = 0;
    String[] split = Long.toUnsignedString(n, k)
                .replaceAll("[0]+", "0")
                .split("0");

    for (String str : split) {
        if (isPrime(Long.parseLong(str))) {
            System.out.println(str);
            answer++;
        }
    }
    return answer;
}
```
## 문제3: 주차 요금 계산 (해결)
이것도 맵 자료구조를 사용하여 문제 풀이

### Car 클래서 정의
```java
class Car implements Comparable<Car> {
    String carNum;
    int time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return time == car.time && Objects.equals(carNum, car.carNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNum, time);
    }


    @Override
    public int compareTo(Car o) {
        return carNum.compareTo(o.carNum);
    }
}
```

### 초 변환 메소드
```java
private int calSecond(String time) {
    String[] split = time.split(":");
    return (Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60);
}
```

이 문제를 풀면서 코테에서 처음으로 테스트 코드는 다맞는데 제출 후 체점하기를 진행하면  
모든 문제들이 틀리는 것이아니라 에러가 떨어졌다.  
그래서 한줄씩 try-catch 문을 사용해서 어디에서 오류나는지 시간을 보냇다...ㅠㅠ

inOutPut (HashMap)에서 remove 메소드를 사용해서 값을 가져왔는데
```java
int resTime = (calSecond("23:59" - inOutPut.remove(key))) / 60;
```
이 부분에서 `NPE`가 떨어지는 것을 확인하여 문제를 해결하였다.

```java

public int[] solution(int[] fees, String[] records) {
    List<Integer> list = new ArrayList<>();
    Map<String, Integer> res = new LinkedHashMap<>();
    Map<String, Integer> inOutPut = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String curTime = split[0];
            String num = split[1];
            String cmd = split[2];
            if (cmd.equals("IN")) inOutPut.put(num, calSecond(curTime));
            else if (cmd.equals("OUT")) {
                if (inOutPut.containsKey(num)) {
                    int resTime = (calSecond(curTime) - inOutPut.remove(num)) / 60;
                    res.put(num, res.getOrDefault(num, 0) + resTime);
                }

            }
        }

    for (String key : inOutPut.keySet()) {
        // inOutPut.remove(key) 에서 NullPointErr가 발생하여 골머리 썩음 ㅠㅠ;;
        int resTime = (calSecond("23:59") - inOutPut.getOrDefault(key, 0)) / 60;
        res.put(key, res.getOrDefault(key, 0) + resTime);
    }

    for (String s :  res.keySet().stream().sorted().map(String::valueOf).toArray(String[]::new)) {
        int time = res.getOrDefault(s, 0);
        if (fees[0] < time){
            int fee = (int) (fees[1] + ((( Math.ceil(((double) time - fees[0]) / fees[2]) * fees[3]))));
            list.add(fee);
        }
        else list.add(fees[1]);
    }

    return list.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
}
```

## 문제4: 양궁대회 (미해결)
문제 이해가 잘 안된다 ㅠㅠ

## 문제5: 양과 늑대 (미해결 - 문제 공개 후 해결)
dfs로 완전 탐색하여 해결

## 전역변수
```java
static List<List<Integer>> list;
static int answer = 1; // Root는 무조권 양이므로 1로 시작
```

### dfs
```java
private void dfs(int node, int sheep, int wolf, int[] info, List<Integer> lst) {
    if (info[node] == 0) sheep++;
    else wolf++;
    
    answer = Math.max(sheep, answer);
    if (wolf >= sheep) return;

    List<Integer> child = new ArrayList<>();
    child.addAll(lst);
    child.addAll(list.get(node));
    child.remove(Integer.valueOf(node));
    
    for (int val : child) {
        dfs(val, sheep, wolf, info, child);
    }
}
```

### 인접 리스트 생성
```java
public int solution(int[] info, int[][] edges) {
    list = new ArrayList<>();
    for (int i = 0; i < info.length; i++) list.add(new ArrayList<>());
    for (int[] edge : edges) list.get(edge[0]).add(edge[1]);

    dfs(0, 0, 0, info, new ArrayList<>());
    return answer;
}
```

## 문제6: 파괴되지 않은 건물 (미해결 - 문제 공개 후 해결)
테스트에선 효율성을 무시하고 정확성만 맞추고  
문제 공개 후 블로그를 찾아 보며 누적합을 활용하여 해결하는 문제 였다.

```java
static int[][] sum;
static int N, M;
public int solution(int[][] board, int[][] skill) {
    N = board.length;
    M = board[0].length;

    sum = new int[N + 1][M + 1];
    for (int[] s : skill) {
        int y1 = s[1], x1 = s[2];
        int y2 = s[3], x2 = s[4];
        int degree = s[5] * (s[0] == 1 ? -1 : 1);

        sum[y1][x1] += degree;
        sum[y1][x2 + 1] += (degree * -1);
        sum[y2 + 1][x1] += (degree * -1);
        sum[y2 + 1][x2 + 1] += degree;
    }
    
    // 누적합 실행
    operate();

    // 살아남은 건물 확인
    int answer = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] + sum[i][j] > 0) answer++;
        }
    }
    return answer;
}
```

### 누적합
```java
private static void operate() {
    // 상하
    for (int y = 1; y < N; y++) {
        for (int x = 0; x < M; x++) {
            sum[y][x] += sum[y - 1][x];
        }
    }
    
    // 좌우
    for (int x = 1; x < M; x++) {
        for (int y = 0; y < N; y++) {
            sum[y][x] += sum[y][x - 1];
        }
    }
}
```
## 문제7: 사라지는 발판 (미해결)
처다도 보지 않았다.