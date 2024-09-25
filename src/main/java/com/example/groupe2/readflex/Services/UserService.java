package com.example.groupe2.readflex.services;

import com.example.groupe2.readflex.models.entities.User;
import com.example.groupe2.readflex.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityService securityService;

    public List<User> getAllUsers(){
        List<User> _users = userRepository.findAll();
        if(!_users.isEmpty()) {
            return _users;
        }
        return null;
    }

    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User getUserByEmail(String email){
//
//        return null;
//        }
//        else {
        if(!email.isBlank()) {
            Optional<User> user = userRepository.findByEmail(email);
            if(user.isPresent()) {
                return user.get();
            }
        }
        return null;
    }

    public User getUserByUsername(String username){
        if(!username.isBlank()) {
            Optional<User> user = userRepository.findByUsername(username);
            if(user.isPresent()) {
                return user.get();
            }
        }
        return null;
    }

    public User saveUser(User user){
        if(user != null) {
            String hashedPassword = securityService.HashPassword (user.getPassword());
            user.setPassword(hashedPassword);
            return userRepository.save(user);
        }
        return null;
    }

    public User deleteUser(Long id){
        if(id != null) {
            Optional<User> _user = userRepository.findById(id);
            if(_user.isPresent()) {
                userRepository.deleteById(id);
                return _user.get();
            }
        }
        return null;
    }

    public User updateUser(Long id , User user){
        Optional<User> DataUser = userRepository.findById(id);
        if(DataUser.isPresent()){
            User _user =DataUser.get();
            if(user.getEmail() != null) _user.setEmail(user.getEmail());
            if (user.getUsername() != null) _user.setUsername(user.getUsername());
            if (user.getPassword() != null) {
                String hashedPassword = securityService.HashPassword (user.getPassword());
                _user.setPassword(hashedPassword);
            }
            _user.setAdmin(user.isAdmin());
            return userRepository.save(_user);
        }
        return null;
    }


    public User change_user_status(long id){
        Optional<User> userData = userRepository.findById(id);
        if(userData.isPresent()){
            User _user = userData.get();
            if (_user.isAdmin()){
                _user.setAdmin(false);
                return userRepository.save(_user);
            }
            else{
                _user.setAdmin(true);
                return userRepository.save(_user);
            }
        }
        return null;
    }

    public boolean authenticateUser(String username, String password){
        Optional<User> userData = userRepository.findByUsername(username);
        if(userData.isPresent()){
            User _user = userData.get();
            return securityService.VerifyPassword(password, _user.getPassword());
        }
        return false;
    }



}
