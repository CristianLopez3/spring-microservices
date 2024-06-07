package com.appdevlopers.api.users.photoappapiusers.ui.controllers;

import com.appdevlopers.api.users.photoappapiusers.service.UsersService;
import com.appdevlopers.api.users.photoappapiusers.shared.UserDto;
import com.appdevlopers.api.users.photoappapiusers.ui.model.CreateUserRequestModel;
import com.appdevlopers.api.users.photoappapiusers.ui.model.CreateUserResponseModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {


    private final Environment env;
    private final UsersService usersService;

    @Autowired
    public UsersController(Environment env, UsersService usersService) {
        this.env = env;
        this.usersService = usersService;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Working on port " + env.getProperty("local.server.port");
    }


    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(
            @RequestBody CreateUserRequestModel userDetails)
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper
                .map(userDetails, UserDto.class);

        UserDto createdUser = usersService.createUser(userDto);

        CreateUserResponseModel returnValue = modelMapper
                .map(createdUser, CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}



