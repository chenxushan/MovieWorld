package com.mobius.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        // Integer 自身已经实现了Comparable接口并重写了compareTo方法
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



    public void testSortStudentInfo() {
        List<StudentInfo> studentList = new ArrayList<>();
        studentList.add(new StudentInfo("李小明",true,18,1.76, LocalDate.of(2001,3,23)));
        studentList.add(new StudentInfo("张小丽",false,18,1.61,LocalDate.of(2001,6,3)));
        studentList.add(new StudentInfo("王大朋",true,19,1.82,LocalDate.of(2000,3,11)));
        studentList.add(new StudentInfo("陈小跑",false,17,1.67,LocalDate.of(2002,10,18)));
        //排序前输出
        StudentInfo.printStudents(studentList);
        //按年龄排序(Integer类型)
        List<StudentInfo> studentsSortName = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());
        //排序后输出
        List<StudentInfo> studentsSortNameReversed = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge).reversed()).collect(Collectors.toList());
        StudentInfo.printStudents(studentsSortName);

        List<StudentInfo> studentsSortAgeAndHeight = studentList.stream()
                .sorted(Comparator.comparing(StudentInfo::getAge).reversed().thenComparing(StudentInfo::getHeight))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.userSort();
        sort.testSortStudentInfo();
    }


}
