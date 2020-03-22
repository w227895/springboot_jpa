package com.kebo.springboot_jpa.po;

import javax.persistence.*;
import java.util.Date;

/**
 * @description:
 * @author: kb
 * @create: 2020-03-22 10:37
 **/
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private Integer age;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Integer version;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public User() {
    }

    public User(Long Id,String name, Integer age, String email, Date createTime, Date updateTime, Integer version) {
        this.Id=Id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.version = version;
    }

    public User(String name, Integer age, String email, Date createTime, Date updateTime, Integer version) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.version = version;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                '}';
    }
}

