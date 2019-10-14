package com.example.application.mvp.main.bean;

public class UserBean {
    private Integer id;

    private String userNumber;

    private String username;

    private String password;

    private Integer age;

    private String sex;

    private Integer indentityId;

    private String station;

    private String phone;

    private String email;

    private Integer levelId;

    private String isApprove;

    private String accumulate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getIndentityId() {
        return indentityId;
    }

    public void setIndentityId(Integer indentityId) {
        this.indentityId = indentityId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(String isApprove) {
        this.isApprove = isApprove == null ? null : isApprove.trim();
    }

    public String getAccumulate() {
        return accumulate;
    }

    public void setAccumulate(String accumulate) {
        this.accumulate = accumulate == null ? null : accumulate.trim();
    }
}