package hcmute.springbootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
