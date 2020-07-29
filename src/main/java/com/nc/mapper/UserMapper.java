package com.nc.mapper;

import com.nc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User queryUserById(Integer id);
    Integer addUser(User user);
    Integer addUser2(User user);
    Integer addUser3(User user);
    Integer deleteUserById(Integer id);
    Integer updateUserById(User user);
    Integer updateUserById1(String id, String username);
    List<User> queryUser();
    List<User> queryUserByName(String username);
    List<User> queryAllUser(String orderBy);
    List<User> queryUserByPage(@Param("start") Integer start, @Param("count") Integer count);
    List<User> queryUserByUsernameAndId(User user);
    List<User> queryUserByIds(Integer[] ids);

}
