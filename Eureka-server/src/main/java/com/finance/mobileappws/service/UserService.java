package com.finance.mobileappws.service;

import com.finance.mobileappws.model.request.UpdateUserDetails;
import com.finance.mobileappws.model.request.UserDetailsRequestModel;
import com.finance.mobileappws.model.response.UserRest;

import java.util.List;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel user);

    UserRest getUser(String userId);

    List<UserRest> getUsers();

    UserRest updateUser(String userId, UpdateUserDetails user);

    void deleteUser(String userId);

}
