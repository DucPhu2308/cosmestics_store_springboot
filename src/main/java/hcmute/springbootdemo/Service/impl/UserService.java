package hcmute.springbootdemo.Service.impl;

import hcmute.springbootdemo.Entity.User;
import hcmute.springbootdemo.Repository.UserRepository;
import hcmute.springbootdemo.Service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checklogin(String phoneNumber_email, String password) {
        Optional<User> user = userRepository.findUserByPhone(phoneNumber_email);
        if(user.isPresent() && user.get().getPasswordHashed().contains(password)){
            return true;
        }
        else if(user.isPresent() && user.get().getEmail().contains(phoneNumber_email)){
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> findUserByPhone(String phoneNumber) {
        return userRepository.findUserByPhone(phoneNumber);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
