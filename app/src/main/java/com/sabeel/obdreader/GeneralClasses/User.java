package com.sabeel.obdreader.GeneralClasses;

public class User {
    private String uname, vtype, vmodel, vengine, vyear, uemail, upass;

    public User(String uname, String uemail, String upass) {
        this.uname = uname;
        this.uemail = uemail;
        this.upass = upass;
    }

    public User(String uname, String vtype, String vmodel, String vengine, String vyear, String uemail, String upass) {
        this.uname = uname;
        this.vtype = vtype;
        this.vmodel = vmodel;
        this.vengine = vengine;
        this.vyear = vyear;
        this.uemail = uemail;
        this.upass = upass;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getVmodel() {
        return vmodel;
    }

    public void setVmodel(String vmodel) {
        this.vmodel = vmodel;
    }

    public String getVengine() {
        return vengine;
    }

    public void setVengine(String vengine) {
        this.vengine = vengine;
    }

    public String getVyear() {
        return vyear;
    }

    public void setVyear(String vyear) {
        this.vyear = vyear;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }


    public void setUpass(String upass) {
        this.upass = upass;
    }


    public String getUname() {
        return uname;
    }

    public String getUemail() {
        return uemail;
    }


    public String getUpass() {
        return upass;
    }

}
