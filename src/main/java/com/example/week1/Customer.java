package com.example.week1;

public class Customer {
    private String ID;
    private String name;
    private  boolean sex;
    private  int age;

    public Customer() {
        new Customer("", null, "female", 0);
    }

    public Customer(String ID, String name, String sex, int age) {
        this.ID = ID;
        this.name = name;
        if(sex.equals("female") || sex.equals("Female")){
            this.sex = false;
       }
        else{
          this.sex = true;
        };

        if(age > 0){
            this.age = age;
        }
        else{
            this.age = 0;
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
