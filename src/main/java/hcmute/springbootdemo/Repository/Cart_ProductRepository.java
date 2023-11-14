package hcmute.springbootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cart_ProductRepository extends JpaRepository<Cart_ProductRepository, Integer>{

}
