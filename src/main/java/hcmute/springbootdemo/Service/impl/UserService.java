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
    public boolean checklogin(String phoneNumber, String password) {
        Optional<User> user = userRepository.findUserByPhone(phoneNumber);
        if(user.isPresent() && user.get().getPasswordHashed().contains(password)){
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> findUserByPhone(String phoneNumber) {
        return userRepository.findUserByPhone(phoneNumber);
    }
}
