package com.mobius.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private Integer age;   //年龄
    private String gender;  //性别
    private String firstName;
    private String lastName;

    public Employee(Integer id,Integer age,String gender,String firstName,String lastName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
