package com.example.lab1;

public class UserModel {
    private int id;
    private String name;
    private String surname;
    private int age;
    private boolean isActive;

    public UserModel(int id, String name, String surname, int age, boolean isActive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isActive = isActive;
    }

    public UserModel() { }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
