package com.beatdev.api.controller;

import com.beatdev.core.model.Status;
import com.beatdev.core.model.User;
import com.beatdev.core.model.dto.StatusDto;
import com.beatdev.core.model.dto.UserDto;
import com.beatdev.core.model.converter.Converter;
import com.beatdev.core.model.converter.UserConverter;
import com.beatdev.core.service.logic.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;
    private final Converter converter;

    @Autowired
    public UserController(UserService userService,
                          UserConverter converter){
        this.userService = userService;
        this.converter = converter;
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findUserById(@PathVariable("id") long id){
        User user = userService.findUserById(id);
        UserDto userDto = (UserDto) converter.convertToDto(user);
        return userDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long createUser(@RequestBody UserDto userDto){
        User user = (User) converter.convertToEntity(userDto);
        return userService.createUser(user);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StatusDto updateUserStatus(@RequestBody String statusJson,
                                      @PathVariable long id) throws JsonProcessingException {
        String status = getStatusFromJson(statusJson);
        User user = userService.updateUserStatus(id , status);
        StatusDto statusDto = createStatusDto(user);
        return statusDto;
    }

    private String getStatusFromJson(String statusJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(statusJson);
        String status = rootNode.get("status").asText();
        return status;
    }

    private StatusDto createStatusDto(User user){
        StatusDto statusDto = new StatusDto();
        statusDto.setUserId(user.getId());
        if (user.getStatus().equals(Status.ONLINE)){
            statusDto.setCurrentStatus(Status.ONLINE.toString());
            statusDto.setPreviousStatus(Status.OFFLINE.toString());
        } else {
            statusDto.setPreviousStatus(Status.ONLINE.toString());
            statusDto.setCurrentStatus(Status.OFFLINE.toString());
        }
        return statusDto;
    }
}
