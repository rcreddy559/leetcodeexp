package com.designpattern.creational;

public class BuilderDesigPattern {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .setAge(43)
                .setName("Ravi")
                .setPhoneNumber("9090909090").build();
        System.out.println(person.toString());
    }
}

class PersonBuilder {
    private String name;
    private int age;
    private String phoneNumber;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Person build() {
        return new Person(name, age, phoneNumber);
    }

}

class Person {
    private String name;
    private int age;
    private String phoneNumber;

    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "PersonBuilder [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
    }
}