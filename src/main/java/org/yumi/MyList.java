package org.yumi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyList {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("c", "3"));
        list.add(new Person("a", "1"));
        list.add(new Person("b", "2"));
        Collections.sort(list, Comparator.comparing(s -> s.age));
        for (Person p : list) {
            System.out.println(p.age);
        }
        System.out.println("max&min");
        System.out.println(Collections.max(list, Comparator.comparing(s -> s.age)).name+ " " + Collections.min(list, Comparator.comparing(s -> s.age)).name);
    }

    static class Person {
        String name;
        String age;

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}
