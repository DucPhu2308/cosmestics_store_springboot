package hcmute.springbootdemo.Service;

import java.util.List;
import java.util.Optional;
import hcmute.springbootdemo.Entity.Category;

public interface ICategoryService {

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Category entity);

	long count();

	Optional<Category> findById(Integer id);

	List<Category> findAllById(Iterable<Integer> ids);


	List<Category> findAll();

	<S extends Category> S save(S entity);

	void deleteById(Integer id);

}
