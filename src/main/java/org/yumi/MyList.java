package org.yumi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyList {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        Collections.sort(list, Comparator.comparing(s -> s.age));
        for (Person p : list) {
            System.out.println(p.age);
        }
        System.out.println("max&min");
        list.add(new Person("张三", "25"));
        list.add(new Person("李四", "30"));
        list.add(new Person("王五", "20"));
        Person p = new Person();
        String name = p.getName();
        p.setName("张三");

        String age = p.getAge();
        p.setName("");
        p.setAge("");


        System.out.println(Collections.max(list, Comparator.comparing(s -> s.age)).name+ " " + Collections.min(list, Comparator.comparing(s -> s.age)).name);
    }

    static class Person {
        String name;
        String age;

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}
