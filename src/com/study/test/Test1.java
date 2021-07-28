package com.study.test;

import java.util.Optional;

/*
* Optional class Study
* */
public class Test1 {
    public static void main(String[] args) {
        Home home = new Home();
        home.setAddress(null);
        String address = Optional.of(home)
                            .map(Home::getAddress)
                            .orElse("Default");
        Home home2 = new Home();

//        Optional.ofNullable(home2)
//                .flatMap()
//                .get();

        System.out.println("address: " + address);

    }
}

class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Home {
    private Person person01;
    private String address;

    public Home() {
        this.person01 = new Person();
        this.address = "";
    }

    public Person getPerson01() {
        return person01;
    }

    public void setPerson01(Person person01) {
        this.person01 = person01;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Home{" +
                "person01=" + person01 +
                ", address='" + address + '\'' +
                '}';
    }
}

