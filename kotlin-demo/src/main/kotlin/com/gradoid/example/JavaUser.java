package com.gradoid.example;

public class JavaUser {
    private String name;
    private int age;

    public JavaUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaUser javaUser = (JavaUser) o;

        if (age != javaUser.age) return false;
        return name != null ? name.equals(javaUser.name) : javaUser.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return String.format("JavaUser{name='%s', age=%d}", name, age);
    }
}
