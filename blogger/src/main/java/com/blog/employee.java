package com.blog;

public class employee {
    private String Name;
    private String city;
    private int salary;
// Constructor type: getters & setters
//    public employee(String name, String city, int salary) {
//        Name = name;
//        this.city = city;
//        this.salary = salary;
//    }


    public String getName() {
        return Name;
    }

    public String getCity() {
        return city;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
