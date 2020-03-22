package com.kebo.springboot_jpa.dao;

import com.kebo.springboot_jpa.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @description:
 * @author: kb
 * @create: 2020-03-22 10:42
 **/
public interface UserDao extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {

    @Query(value="select * from user where name = ?",nativeQuery=true)
    List<User> queryUserByNameSQL(String name);

}

