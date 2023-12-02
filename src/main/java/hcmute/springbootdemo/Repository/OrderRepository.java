package hcmute.springbootdemo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    // get all orders between 2 dates based on OrderDate field and paid status
    // select * from orders where OrderDate between '2020-01-01' and '2020-01-31' and Paid = 1
    @Query(value = "select * from orders where OrderDate between ?1 and ?2 and Paid = true", nativeQuery = true)
    List<Order> findByOrderDateBetween(Date startDate, Date endDate);

}
