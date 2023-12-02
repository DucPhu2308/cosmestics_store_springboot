package hcmute.springbootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.springbootdemo.Entity.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

    List<Review> findReviewByProductId(int id);

    @Query(value = "SELECT MAX(id) FROM review", nativeQuery = true)
    int getMaxId();

    int countReviewByProductId(int id);

}
