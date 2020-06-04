package com.ht.bean;

/**
 * Created by Administrator on 2020/2/20.
 */
public class Emp {
    private int id;
    private String eName;
    private String pwd;
    private int age;
    private String face;
    private int did;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", eName='" + eName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", face='" + face + '\'' +
                ", did=" + did +
                '}';
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
