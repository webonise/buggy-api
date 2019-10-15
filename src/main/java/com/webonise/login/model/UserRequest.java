package com.webonise.login.model;

public class UserRequest {

    private String firstName;

    private String lastName;

    private String loginId;

    private String password;

    private String place;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRequest userRequest = (UserRequest) o;

        if (firstName != null ? !firstName.equals(userRequest.firstName) : userRequest.firstName != null) return false;
        return loginId != null ? loginId.equals(userRequest.loginId) : userRequest.loginId == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (loginId != null ? loginId.hashCode() : 0);
        return result;
    }
}
