package com.mobius.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User implements Comparable<User>{

    private String name ;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
    @Override
    public int compareTo(User user) {
        return this.age - user.age;
    }

}
public class Sort {

    public void listSort(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(5));
        list.add(new Integer(13));
        list.add(new Integer(4));
        list.add(new Integer(9));
        Collections.sort(list);
        System.out.println(list.toString());
    }

    public void userSort() {
        List<User> list = new ArrayList<User>();
        list.add(new User("张三", 5));
        list.add(new User("李四", 30));
        list.add(new User("王五", 19));
        list.add(new User("陈十七", 17)); // 陈十七永远十七岁
        Collections.sort(list); // 按年龄排序
        System.out.println(list.toString());

        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                int diff = u1.getAge() - u2.getAge();
                if (diff > 0) {
                    return 1;
                }else if (diff < 0) {
                    return -1;
                }
                return 0; //相等为0
                }
            }); // 按年龄排序
            System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.userSort();
    }
}
