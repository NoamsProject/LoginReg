package com.example.loginreg;

public class User {
    public String Nickname;
    public String Pass;
    public String Email;
    public String Phone;

    public User(String nickname, String pass, String email, String phone) {
        Nickname = nickname;
        Pass = pass;
        Email = email;
        Phone = phone;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return  "Nickname=" + Nickname +
                ", Pass=" + Pass +
                ", Email=" + Email +
                ", Phone=" + Phone;
    }
}
