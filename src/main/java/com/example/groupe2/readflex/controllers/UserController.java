package com.example.groupe2.readflex.controllers;

import com.example.groupe2.readflex.Services.UserService;
import com.example.groupe2.readflex.mappers.UserMapper;
import com.example.groupe2.readflex.models.dto.UserDto;
import com.example.groupe2.readflex.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/all")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<User> _users = userService.getAllUsers();
        try {
            if(_users.isEmpty()) {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT);
            }else {
                List<UserDto> userDtos = _users.stream()
                                            .map(UserMapper::toUserDto)
                                            .collect(Collectors.toList());
                return ResponseEntity.ok(userDtos);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/by/id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        User _user = userService.getUserById(id);
        if(_user != null) {
            UserDto userDto = UserMapper.toUserDto(_user);
            return ResponseEntity.ok(userDto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/by/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email){
        User _user = userService.getUserByEmail(email);
        if(_user != null) {
            UserDto userDto = UserMapper.toUserDto(_user);
            return ResponseEntity.ok(userDto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/by/username/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable("username") String username){
        User _user = userService.getUserByUsername(username);
        if(_user != null) {
            UserDto userDto = UserMapper.toUserDto(_user);
            return ResponseEntity.ok(userDto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        if(id == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        User _user = userService.deleteUser(id);
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        if (user != null &&  id != null ){
            User _user = userService.updateUser(id, user);
            UserDto userDto = UserMapper.toUserDto(_user);
            return ResponseEntity.ok(userDto);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/change_status/{id}")
    public ResponseEntity<UserDto> change_user_status(@PathVariable("id") Long id){
        if (id != null) {
            User user = userService.change_user_status(id);
            UserDto userDto = UserMapper.toUserDto(user);
            return ResponseEntity.ok(userDto);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}