package com.sabeel.obdreader.GeneralClasses;

public class User {
    private String uname, uemail, userpassword;

    public User(String uname, String uemail, String userpassword) {
        this.uname = uname;
        this.uemail = uemail;
        this.userpassword = userpassword;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }


    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }


    public String getUname() {
        return uname;
    }

    public String getUemail() {
        return uemail;
    }


    public String getUserpassword() {
        return userpassword;
    }

}
