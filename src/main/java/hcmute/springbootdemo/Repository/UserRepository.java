package hcmute.springbootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
