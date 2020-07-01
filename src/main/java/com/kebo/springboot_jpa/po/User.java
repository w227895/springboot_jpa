package com.kebo.springboot_jpa.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @description:
 * @author: kb
 * @create: 2020-03-22 10:37
 **/
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户id", example = "1000")
    private Long Id;
    @ApiModelProperty(value = "用户姓名", example = "柯博")
    private String name;
    @ApiModelProperty(value = "用户年龄", example = "23")
    private Integer age;
    @ApiModelProperty(value = "用户email", example = "249183617@qq.com")
    private String email;
    @ApiModelProperty(value = "创建时间")
    @CreatedDate  //填充字段
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //时间格式,时区选择
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //时间格式,时区选择
    private Date updateTime;
    @ApiModelProperty(value = "版本", example = "1")
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

    public User(Long Id, String name, Integer age, String email, Date createTime, Date updateTime, Integer version) {
        this.Id = Id;
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

