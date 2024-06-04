package com.finance.mobileappws.controller;

import com.finance.mobileappws.model.request.UpdateUserDetails;
import com.finance.mobileappws.model.request.UserDetailsRequestModel;
import com.finance.mobileappws.model.response.UserRest;
import com.finance.mobileappws.service.implementation.UserServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "User Controller", description = "This is the User Controller")
@RestController
@RequestMapping("/users")
public class UserController {

    private static UserServiceImp userService;


    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }


    @Operation(summary = "Get all Users")
    @GetMapping(produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<UserRest>> getUsers(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "sort", required = false) String sort) {
        return ResponseEntity.ok(userService.getUsers());
    }


    @Operation(summary = "Get user by id")
    @GetMapping(
            value = "/{userId}",
            produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserRest> getUser(
       @PathVariable String userId
    ) {
        return ResponseEntity.ok(userService.getUser(userId));
    }


    @Operation(summary = "Create a User")
    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<UserRest> createUser(
            @Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel
    ) {
        return ResponseEntity.ok(userService.createUser(userDetailsRequestModel));
    }


    @Operation(summary = "Update a User", responses = {
            @ApiResponse(responseCode = "200", description = "User Updated"),
            @ApiResponse(responseCode = "404", description = "User Not Found")})
    @PutMapping("/{userId}")
    public ResponseEntity<UserRest> updateUser(
            @PathVariable String userId,
            @Valid @RequestBody UpdateUserDetails updateUserDetails){

        return ResponseEntity.ok(userService.updateUser(userId, updateUserDetails));
    }


    @Operation(summary = "Delete a User", responses = {
            @ApiResponse(responseCode = "200", description = "User Deleted"),
            @ApiResponse(responseCode = "404", description = "User Not Found")})
    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String userId) {
        if(getUser(userId) == null){
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(userId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "delete user was called with userId = " + userId);
        return ResponseEntity.ok(response);
    }


}
