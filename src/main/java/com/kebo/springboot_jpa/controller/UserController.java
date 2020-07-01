package com.kebo.springboot_jpa.controller;

import com.kebo.springboot_jpa.dao.UserDao;
import com.kebo.springboot_jpa.po.User;
import com.kebo.springboot_jpa.utils.FieldIsNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @description:
 * @author: kb
 * @create: 2020-07-01 19:11
 **/
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping()
    @ApiOperation("添加用户")
    public User saveUser(@RequestBody User user) {
        return userDao.save(user);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public void deleteUser(@PathVariable("id") Long userId) {
        userDao.deleteById(userId);
    }

    @PutMapping("/{id}")
    @ApiOperation("修改用户")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setId(userId);
        return userDao.saveAndFlush(user);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    public User getUserInfo(@PathVariable("id") Long userId) {
        Optional<User> optional = userDao.findById(userId);
        if(!FieldIsNull.allFieldIsNULL(optional.orElseGet(User::new),null)){
            return optional.orElseGet(User::new);
        }
        return null;

    }

    @GetMapping("/list")
    @ApiOperation("查询所有的用户")
    public Page<User> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return userDao.findAll(PageRequest.of(pageNum - 1, pageSize));
    }
}

