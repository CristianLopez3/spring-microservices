package com.finance.mobileappws.model.mapper;

import com.finance.mobileappws.model.request.UserDetailsRequestModel;
import com.finance.mobileappws.model.response.UserRest;

public class UserMapper {

    public static UserRest toUserRest(UserDetailsRequestModel userDetails) {
        UserRest userRest = new UserRest();
        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastname(userDetails.getLastName());
        userRest.setEmail(userDetails.getEmail());
        return userRest;
    }

    public static UserRest toUserRest(String id, UserDetailsRequestModel userDetails) {
        UserRest userRest = new UserRest();
        userRest.setUserId(id); // You might want to set this differently
        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastname(userDetails.getLastName());
        userRest.setEmail(userDetails.getEmail());
        return userRest;
    }

    public static UserDetailsRequestModel toUserDetailsRequestModel(UserRest userRest) {
        UserDetailsRequestModel userDetails = new UserDetailsRequestModel();
        userDetails.setFirstName(userRest.getFirstName());
        userDetails.setLastName(userRest.getLastname());
        userDetails.setEmail(userRest.getEmail());
        // userDetails.setPassword(); // You might want to set this if needed
        return userDetails;
    }
}