package com.xzm.springbootjpa.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")//对应数据库的表
public class User {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    @Column(name = "userid")//列名
    private Integer userid;

    @Column(name = "username")
    private String username;

    @Column(name = "userpass")
    private String userpass;

    @Column(name = "genderid")
    private Integer genderid;

    @Column(name = "createtime")
    private Date createtime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public Integer getGenderid() {
        return genderid;
    }

    public void setGenderid(Integer genderid) {
        this.genderid = genderid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
