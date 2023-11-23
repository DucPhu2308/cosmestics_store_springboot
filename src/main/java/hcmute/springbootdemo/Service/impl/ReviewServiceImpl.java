package hcmute.springbootdemo.Service.impl;

import hcmute.springbootdemo.Entity.Review;
import hcmute.springbootdemo.Repository.ReviewRepository;
import hcmute.springbootdemo.Service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements IReviewService {

    @Autowired
    ReviewRepository reviewRepository;

	@Override
	public <S extends Review> S save(S entity) {
		return reviewRepository.save(entity);
	}

	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public Optional<Review> findById(Integer id) {
		return reviewRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return reviewRepository.existsById(id);
	}

	@Override
	public <S extends Review> boolean exists(Example<S> example) {
		return reviewRepository.exists(example);
	}

	@Override
	public long count() {
		return reviewRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		reviewRepository.deleteById(id);
	}

	@Override
	public void delete(Review entity) {
		reviewRepository.delete(entity);
	}

    
}
