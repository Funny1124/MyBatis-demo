package com.cyan.pojo;

public class User {
    private Integer id;
    private String name;
    private String tele;

    public User() {
    }

    public User(Integer id, String name, String tele) {
        this.id = id;
        this.name = name;
        this.tele = tele;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }
}
