package hcmute.springbootdemo.Service;

import hcmute.springbootdemo.Entity.Review;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

public interface IReviewService {

	void delete(Review entity);

	void deleteById(Integer id);

	long count();

	<S extends Review> boolean exists(Example<S> example);

	boolean existsById(Integer id);

	Optional<Review> findById(Integer id);

	List<Review> findAll();

	<S extends Review> S save(S entity);

	int getMaxId();

	int avgRating(int productId);

	int countReviewByProductId(int id);

}
