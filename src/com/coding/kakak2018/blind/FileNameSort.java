package com.coding.kakak2018.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @level2
 * @TestName: [3차] 파일명 정렬
 * @URL: https://programmers.co.kr/learn/courses/30/lessons/17686
 */
public class FileNameSort {

    static class File implements Comparable<File>{
        String head;
        int fileNo;
        String extension;
        String originalName;

        public File(String head, String fileNo, String extension, String originalName) {
            this.head = head;
            this.fileNo = Integer.parseInt(fileNo);
            this.extension = extension;
            this.originalName = originalName;
        }

        public String getOriginalName() {
            return originalName;
        }

        @Override
        public int compareTo(File o) {
            if (!head.equals(o.head)) return head.compareToIgnoreCase(o.head);
            return Integer.compare(fileNo, o.fileNo);
        }

        @Override
        public String toString() {
            return "File{" +
                    "head='" + head + '\'' +
                    ", fileNo=" + fileNo +
                    ", extension='" + extension + '\'' +
                    ", originalName='" + originalName + '\'' +
                    '}';
        }
    }

    public static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();

        for (String file : files) {
            String[] split = file.split("\\.");
            int numFirstIndex = findNumberFirstIndex(split[0]);
            String head = file.substring(0, numFirstIndex).toLowerCase();
            String extension = split.length > 1 ? split[1].toLowerCase() : "";

            StringBuilder fileNo = new StringBuilder();
            for (char c : split[0].toLowerCase().toCharArray()) {
                if (c >= '0' && c <= '9') fileNo.append(c);
            }

            fileList.add(new File(head.replaceAll("[0-9]", ""), fileNo.toString(), extension, file));
        }

        System.out.println("fileList = " + fileList);
        Collections.sort(fileList);
        System.out.println("fileList = " + fileList);
        for (File file : fileList) {
            System.out.println("file.originalName = " + file.originalName);
        }

        return fileList.stream()
                .map(File::getOriginalName)
                .toArray(String[]::new);
    }

    private static int findNumberFirstIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') return i;
        }

        return -1;
    }


    public static void main(String[] args) {

//        System.out.println(solution("()()"));
        String[] files = {
                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
//                "ABC12", "AbC12", "aBc12" // [ABC12,AbC12,aBc12]
        };

        System.out.println(Arrays.toString(solution(files)));
    }
}
