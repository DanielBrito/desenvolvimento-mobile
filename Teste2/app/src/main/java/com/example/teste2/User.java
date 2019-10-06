package com.example.teste2;

public class User {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private String profissao;
    private String data;

    public User(Integer id, String name, String username, String email, String profissao, String data) {

        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.profissao = profissao;
        this.data = data;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", profissao='" + profissao + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
