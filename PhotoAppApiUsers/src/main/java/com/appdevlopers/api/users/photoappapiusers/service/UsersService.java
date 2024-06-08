package com.appdevlopers.api.users.photoappapiusers.service;

import com.appdevlopers.api.users.photoappapiusers.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {

    UserDto createUser(UserDto userDetails);

    UserDto getUserDetailsByEmail(String email);

}
