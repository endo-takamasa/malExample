package com.mal.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mal.repository.user.entity.UserEntry;

@Mapper
public interface UserInfoRepository {

    public List<UserEntry> getUserList();

    public UserEntry getUser(
            @Param(value = "id") int id);

    public void saveUserInfo(UserEntry user);
}
