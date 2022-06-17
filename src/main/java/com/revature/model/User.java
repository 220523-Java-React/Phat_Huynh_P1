package com.revature.model;


import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private Role role = Role.USER;

    public User(){

    }


    public User(String firstname, String lastname, String username, String password){
        this.firstname = firstname;
        this.lastname = lastname;
       this.username = username;
        this.password = password;

    }



    public int getId() { return id;}

    public void setId(int id) {this.id = id;}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname){this.firstname = firstname;}

    public String getLastname(){return lastname;}

    public void setLastname(String lastname){this.lastname = lastname;}

    public String getUsername(){return  username;}

    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}

    public Role getRole() { return role;}

    public void setRole(Role role){this.role = role;}


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

enum Role{
    USER, ADMIN
}






