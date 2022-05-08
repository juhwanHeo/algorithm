package com.programmers.level3;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @level3
 * @TestName: 베스트앨범
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/42579
 */
public class BestAlbum {

    static class Album implements Comparable<Album>{
        int seq;
        String genre;
        int plays;

        public int getPlays() {
            return plays;
        }

        public Album(int seq, String genre, int plays) {
            this.seq = seq;
            this.genre = genre;
            this.plays = plays;
        }

        @Override
        public String toString() {
            return "Album{" +
                    "seq=" + seq +
                    ", genre='" + genre + '\'' +
                    ", plays=" + plays +
                    '}';
        }

        @Override
        public int compareTo(Album o) {
            return Integer.compare(o.plays, plays);
        }
    }

    static int[] solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<Album>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            if (!map.containsKey(genres[i])) {
                PriorityQueue<Album> list = new PriorityQueue<>();
                list.offer(new Album(i, genres[i], plays[i]));
                map.put(genres[i], list);
            }
            else {
                map.get(genres[i]).offer(new Album(i, genres[i], plays[i]));
            }
        }
        System.out.println("map = " + map);

        List<String> keys = map.keySet().stream().sorted((data1, data2) -> {
            int sum1 = map.get(data1).stream()
                    .map(Album::getPlays)
                    .mapToInt(Integer::valueOf)
                    .sum();
            int sum2 = map.get(data2).stream()
                    .map(Album::getPlays)
                    .mapToInt(Integer::valueOf)
                    .sum();

            return Integer.compare(sum2, sum1);
        }).collect(Collectors.toList());

        List<Integer> list = new ArrayList<>();
        for (String key : keys) {
            PriorityQueue<Album> pq = map.get(key);
            int repeat = 2;
            while (!pq.isEmpty() && repeat-- != 0) {
                list.add(pq.poll().seq);
            }
        }

        return list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static void main(String[] args) {
        String[] genres = {
                "classic", "pop", "classic", "classic", "pop"
        };

        int[] plays = {
                500, 600, 150, 800, 2500
        };

        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}
