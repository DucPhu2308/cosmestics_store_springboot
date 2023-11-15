package hcmute.springbootdemo.Service;

import hcmute.springbootdemo.Entity.User;

import java.util.Optional;

public interface IUserService {

    boolean checklogin(String phoneNumber ,String password);

    Optional<User> findUserByPhone(String phoneNumber);
}
