package com.example.studenthelpernew;

import java.util.Date;
public class User {
    String username;
    String fullName;
    Date sessionExpiryDate;

    public void setUsername(String username)
    {
        this.username = username;
    }
    //ok

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public void setSessionExpiryDate(Date sessionExpiryDate)
    {
        this.sessionExpiryDate = sessionExpiryDate;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getSessionExpiryDate() {
        return sessionExpiryDate;
    }

}
