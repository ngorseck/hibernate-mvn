package com.sopra.dao;

public class UserRolesTuple {

    private String fullName;
    private String email;
    private String roleName;

    public UserRolesTuple() {
    }

    public UserRolesTuple(String fullName, String email, String roleName) {
        this.fullName = fullName;
        this.email = email;
        this.roleName = roleName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
