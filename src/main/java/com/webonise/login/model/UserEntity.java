package com.webonise.login.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.sql.Timestamp;

@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LOGIN_ID", unique=true)
    private String loginId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PLACE")
    private String place;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Timestamp createdAt;

    public UserEntity() {
    }

    public UserEntity(UserRequest userRequest) {
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.loginId = userRequest.getLoginId();
        this.password = userRequest.getPassword();
        this.place = userRequest.getPlace();
    }

	public Long getId() {
        return id;
    }

	public void setId(Long id) {
        this.id = id;
    }

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return loginId != null ? loginId.equals(that.loginId) : that.loginId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loginId != null ? loginId.hashCode() : 0);
        return result;
    }
}
