package demo.user.controller;

import demo.user.modele.UserData;

public class User {
    private Integer id;

    private String name;

    private String pwd;

    private String role;

    public User(UserData userData) {
        this.id = userData.getId();
        this.name = userData.getName();
        this.pwd = userData.getPwd();
        this.role = userData.getRole();
    }

    public User(String name, String pwd, String role) {
        this.name = name;
        this.pwd = pwd; 
        this.role = role;
    }

    public UserData toData() {
        UserData u = new UserData();
        u.setId(id);
        u.setName(name);
        u.setPwd(pwd);
        u.setRole(role);
        return u;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
