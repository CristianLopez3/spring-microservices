package com.finance.mobileappws.service.implementation;

import com.finance.mobileappws.exceptions.UserNotFoundException;
import com.finance.mobileappws.service.UserService;
import com.finance.mobileappws.shared.Utils;
import com.finance.mobileappws.model.mapper.UserMapper;
import com.finance.mobileappws.model.request.UpdateUserDetails;
import com.finance.mobileappws.model.request.UserDetailsRequestModel;
import com.finance.mobileappws.model.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private Map<String, UserDetailsRequestModel> users = new HashMap<>();
    private UserMapper userMapper = new UserMapper();;
    private Utils utils;

    public UserServiceImp(){}


    @Autowired
    public UserServiceImp(Utils utils){
        this.utils = utils;
    }


    @Override
    public UserRest createUser( UserDetailsRequestModel user) {
        String userId = utils.generateUserId();
        users.put(userId, user);
        return userMapper.toUserRest(userId, user);
    }


    @Override
    public UserRest getUser(String userId) {
        if(userId == null || !users.containsKey(userId) ){
            throw new UserNotFoundException("User not found.");
        }
        return userMapper.toUserRest(userId, users.get(userId));
    }


    @Override
    public List<UserRest> getUsers() {
        return users.values()
                .stream()
                .map(user -> userMapper.toUserRest(UUID.randomUUID().toString(), user))
                .collect(Collectors.toList());

    }


    @Override
    public UserRest updateUser(String userId, UpdateUserDetails user) {
        UserDetailsRequestModel userDetailsRequestModel = users.get(userId);
        if (userDetailsRequestModel == null) {
            throw new UserNotFoundException("User not found, cannot update user.");
        }
        userDetailsRequestModel.setFirstName(user.getFirstName());
        userDetailsRequestModel.setLastName(user.getLastName());
        users.put(userId, userDetailsRequestModel);
        return userMapper.toUserRest(userId, userDetailsRequestModel);
    }


    @Override
    public void deleteUser(String userId) {
        if(userId == null ){
            throw new UserNotFoundException("User not found, cannot delete user.");
        }
        users.remove(userId);
    }


}
