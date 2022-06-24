package com.revature.model;


import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private Role role;

    public User(){

    }



    public int getId() { return id;}

    public User setId(int id) {
        this.id = id;
    return this;}

    public String getFirstname() {return firstname;}

    public User setFirstname(String firstname){this.firstname = firstname;
    return this;}

    public String getLastname(){return lastname;}

    public User setLastname(String lastname){this.lastname = lastname; return this;}

    public String getUsername(){return  username;}

    public User setUsername(String username){this.username = username; return this;}

    public String getPassword(){return password;}

    public User setPassword(String password){this.password = password; return this;}

    public Role getRole() { return role;}

    public User setRole(Role role){this.role = role; return this;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, username, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}








