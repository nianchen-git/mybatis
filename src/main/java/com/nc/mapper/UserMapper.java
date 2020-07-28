package com.nc.mapper;

import com.nc.model.User;

import java.util.List;

public interface UserMapper {
    User queryUserById(Integer id);
    Integer addUser(User user);
    Integer addUser2(User user);
    Integer addUser3(User user);
    Integer deleteUserById(Integer id);
    Integer updateUserById(User user);
    List<User> queryUser();

}
