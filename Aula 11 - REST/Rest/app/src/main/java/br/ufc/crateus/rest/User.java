package br.ufc.crateus.rest;

public class User {

    private Integer id;
    private String name;
    private String userName;

    public User(Integer id, String name, String userName) {

        this.id = id;
        this.name = name;
        this.userName = userName;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
