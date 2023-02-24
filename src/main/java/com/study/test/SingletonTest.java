package com.study.test;

import java.util.Arrays;
import java.util.Optional;

class Connection {
    private static Connection _inst = null;
    private static int count = 0;

    static public Connection get() {
        if (_inst == null) {
            _inst = new Connection();

        }

        return _inst;
    }

    public void count() {
        count++;
    }

    public int getCount() {
        return count;
    }
}



public class SingletonTest {
    static class Test {

        private String str;
        public static Optional<Test> test(String str) {
            Test test = new Test();
            test.str = str;
            return Optional.of(test);
        }
        public static String output() {
            System.out.println("[run output !!]");
            return "output !!";
        }

        public String getStr() {
            return str;
        }
    }
    private static byte[] bytes;
    public static void main(String[] args) {
        Connection conn1 = Connection.get();
        conn1.count();
        Connection conn2 = Connection.get();
        conn2.count();
        Connection conn3 = Connection.get();
        conn3.count();

//        System.out.println(conn1.getCount());


        int[] arr = new int[] {1,23,3,42,5,6};


//        Arrays.stream(arr).reduce((a, b) -> a * b)
//                .ifPresent(System.out::println);
//-------------------------------------------------






//        String nullStr = Test.test(null)
//                .map(Test::getStr)
//                .orElse(Test.output());
//
//        String notNullStr = Test.test("orElse !!")
//                .map(Test::getStr)
//                .orElse(Test.output());

//  -------------------------------------------
        String nullStr = Test.test(null)
                .map(Test::getStr)
                .orElseGet(Test::output);

        String notNullStr = Test.test("orElseGet !!")
                .map(Test::getStr)
                .orElseGet(Test::output);

        System.out.println("nullStr = " + nullStr);
        System.out.println("notNullStr = " + notNullStr);

    }
}