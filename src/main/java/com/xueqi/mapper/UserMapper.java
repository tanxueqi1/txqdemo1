package com.xueqi.mapper;

import com.xueqi.model.User;
import com.xueqi.vo.UserQueryVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    public int save(User user);

    public User findUserById(Integer id);

    public List<User> findUserByName(String name);

    public int deleteUser(Integer id);

    public int updateUser(User user);

    public List<User> findUserByUserQueryVo(UserQueryVO userQueryVO);

    public List<User> findUserListByMap(Map<String,Object> map);

    public int findUserCount(UserQueryVO vo);

    public User findUserByIdResultMap(Integer id);
}
